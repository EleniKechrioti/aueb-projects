from mininet.net import Mininet
from mininet.node import Node
from mininet.cli import CLI
from mininet.link import TCLink
from mininet.topo import Topo
from mininet.log import setLogLevel, info
import time


# True = Scenario 1 (Static Routing)
# False = Scenario 2 (RIP - Dynamic Routing)
ENABLE_STATIC_ROUTES = False 

class LinuxRouter(Node):
    "A Node with IP forwarding enabled."
    def config(self, **params):
        super(LinuxRouter, self).config(**params)
        self.cmd('sysctl net.ipv4.ip_forward=1')

    def terminate(self):
        self.cmd('sysctl net.ipv4.ip_forward=0')
        super(LinuxRouter, self).terminate()

class DiamondTopo(Topo):
    def build(self, **_kwargs):
        # Create Routers
        r1 = self.addHost('r1', cls=LinuxRouter)
        r2 = self.addHost('r2', cls=LinuxRouter)
        r3 = self.addHost('r3', cls=LinuxRouter)
        r4 = self.addHost('r4', cls=LinuxRouter)

        # Create Hosts with their default gateways
        # H1 -> R1 (eth0), H2 -> R1 (eth1)
        h1 = self.addHost('h1', ip='10.0.1.10/24', defaultRoute='via 10.0.1.1')
        h2 = self.addHost('h2', ip='10.0.2.10/24', defaultRoute='via 10.0.2.1')
        
        # H3 -> R4 (eth2), H4 -> R4 (eth3)
        h3 = self.addHost('h3', ip='10.0.7.10/24', defaultRoute='via 10.0.7.1')
        h4 = self.addHost('h4', ip='10.0.8.10/24', defaultRoute='via 10.0.8.1')

        # Links
        # Hosts -> R1
        self.addLink(h1, r1, intfName1='h1-eth0', intfName2='r1-eth0') # 10.0.1.0/24
        self.addLink(h2, r1, intfName1='h2-eth0', intfName2='r1-eth1') # 10.0.2.0/24

        # R1 -> R2 & R1 -> R3
        self.addLink(r1, r2, intfName1='r1-eth2', intfName2='r2-eth0') # 10.0.3.0/24
        self.addLink(r1, r3, intfName1='r1-eth3', intfName2='r3-eth0') # 10.0.4.0/24

        # R2 -> R4 & R3 -> R4
        self.addLink(r2, r4, intfName1='r2-eth1', intfName2='r4-eth0') # 10.0.5.0/24
        self.addLink(r3, r4, intfName1='r3-eth1', intfName2='r4-eth1') # 10.0.6.0/24

        # R4 -> Hosts
        self.addLink(r4, h3, intfName1='r4-eth2', intfName2='h3-eth0') # 10.0.7.0/24
        self.addLink(r4, h4, intfName1='r4-eth3', intfName2='h4-eth0') # 10.0.8.0/24

def main():
    topo = DiamondTopo()
    net = Mininet(topo=topo, link=TCLink, autoSetMacs=True)
    net.start()

    # IP addressing configuration on Routers
    # R1 Interfaces
    net['r1'].cmd('ifconfig r1-eth0 10.0.1.1/24') # To H1
    net['r1'].cmd('ifconfig r1-eth1 10.0.2.1/24') # To H2
    net['r1'].cmd('ifconfig r1-eth2 10.0.3.1/24') # To R2
    net['r1'].cmd('ifconfig r1-eth3 10.0.4.1/24') # To R3
    
    # R2 Interfaces
    net['r2'].cmd('ifconfig r2-eth0 10.0.3.2/24') # To R1
    net['r2'].cmd('ifconfig r2-eth1 10.0.5.1/24') # To R4

    # R3 Interfaces
    net['r3'].cmd('ifconfig r3-eth0 10.0.4.2/24') # To R1
    net['r3'].cmd('ifconfig r3-eth1 10.0.6.1/24') # To R4

    # R4 Interfaces
    net['r4'].cmd('ifconfig r4-eth0 10.0.5.2/24') # To R2
    net['r4'].cmd('ifconfig r4-eth1 10.0.6.2/24') # To R3
    net['r4'].cmd('ifconfig r4-eth2 10.0.7.1/24') # To H3
    net['r4'].cmd('ifconfig r4-eth3 10.0.8.1/24') # To H4

    # Disable rp_filter to allow asymmetric routing
    for r in ['r1', 'r2', 'r3', 'r4']:
        rp_disable(net[r])

    # SCENARIO 1: STATIC ROUTING
    if ENABLE_STATIC_ROUTES:
        # H1->H3 via R1-R2-R4 and H2->H4 via R1-R3-R4
        
        # R1: How to reach H3 (10.0.7.0) and H4 (10.0.8.0)
        net['r1'].cmd('ip route add 10.0.7.0/24 via 10.0.3.2') # Via R2
        net['r1'].cmd('ip route add 10.0.8.0/24 via 10.0.4.2') # Via R3

        # R2: How to reach H3
        net['r2'].cmd('ip route add 10.0.7.0/24 via 10.0.5.2') # Via R4
        # R2: How to return to H1
        net['r2'].cmd('ip route add 10.0.1.0/24 via 10.0.3.1') # Via R1

        # R3: How to reach H4
        net['r3'].cmd('ip route add 10.0.8.0/24 via 10.0.6.2') # Via R4
        # R3: How to return to H2
        net['r3'].cmd('ip route add 10.0.2.0/24 via 10.0.4.1') # Via R1

        # R4: How to return to H1 and H2
        net['r4'].cmd('ip route add 10.0.1.0/24 via 10.0.5.1') # Via R2 (symmetry with H1-R1-R2-R4-H3)
        net['r4'].cmd('ip route add 10.0.2.0/24 via 10.0.6.1') # Via R3 (symmetry with H2-R1-R3-R4-H4)

    # SCENARIO 2: DYNAMIC ROUTING WITH RIP
    # In Scenario 2, we don't add static routes.

    CLI(net)
    net.stop()

def rp_disable(host):
    ifaces = host.cmd('ls /proc/sys/net/ipv4/conf')
    ifacelist = ifaces.split()
    for iface in ifacelist:
       if iface != 'lo': host.cmd('sysctl net.ipv4.conf.' + iface + '.rp_filter=0')

setLogLevel('info')
main()
