from pox.core import core
import pox.openflow.libopenflow_01 as of
from pox.lib.addresses import IPAddr

log = core.getLogger()

# Define IPs and HTTP Ports
H1_IP = IPAddr('10.0.2.10')
H4_IP = IPAddr('10.0.2.40')
HTTP_PORT = 80

class Firewall(object):
    """
    Stateless firewall for a single switch
    """

    def __init__(self, connection):
        self.connection = connection
        connection.addListeners(self)
        self.install_firewall_rules()

    def send_flow_mod(self, match, action=None, priority=100):
        """Helper to send flow mod to switch"""
        msg = of.ofp_flow_mod()
        msg.match = match
        msg.priority = priority
        if action:
            msg.actions.append(action)
        self.connection.send(msg)
        log.info("Flow installed with priority %s", priority)

    def install_firewall_rules(self):
        conn = self.connection
        action_flood = of.ofp_action_output(port=of.OFPP_FLOOD)

        # ARP → accept/flood
        arp_match = of.ofp_match(dl_type=0x0806)
        self.send_flow_mod(match=arp_match, action=action_flood, priority=100)

        # UDP → accept (NORMAL)
        udp_match = of.ofp_match(dl_type=0x0800, nw_proto=17)
        udp_action = of.ofp_action_output(port = of.OFPP_NORMAL)
        self.send_flow_mod(match=udp_match, action=udp_action, priority=90)

        # HTTP H1 -> H4 → accept
        h1_h4_http_match = of.ofp_match(
            dl_type=0x0800, nw_proto=6,
            nw_src=H1_IP, nw_dst=H4_IP, tp_dst=HTTP_PORT
        )
        self.send_flow_mod(match=h1_h4_http_match, action=action_flood, priority=80)

        # HTTP H4 -> H1 → accept (reply)
        h4_h1_http_match = of.ofp_match(
            dl_type=0x0800, nw_proto=6,
            nw_src=H4_IP, nw_dst=H1_IP, tp_src=HTTP_PORT
        )
        self.send_flow_mod(match=h4_h1_http_match, action=action_flood, priority=80)

        # Drop rest TCP
        tcp_drop_match = of.ofp_match(dl_type=0x0800, nw_proto=6)
        self.send_flow_mod(match=tcp_drop_match, action=None, priority=70)

        log.info("Firewall rules installed on switch %s", conn.dpid)

    def _handle_PacketIn(self, event):
        """
        Drop any packet not matching the rules.
        """
        packet = event.parsed
        if not packet.parsed:
            log.warning("Ignoring incomplete packet")
            return
        # All unmatched packets are implicitly dropped
        pass

def launch():
    """
    Start the firewall component
    """
    def start_switch(event):
        log.debug("Controlling %s" % event.connection)
        Firewall(event.connection)

    core.openflow.addListenerByName("ConnectionUp", start_switch)
    log.info("Firewall POX controller running (Python 3.8 compatible)")

