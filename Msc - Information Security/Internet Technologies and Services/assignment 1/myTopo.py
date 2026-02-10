
from mininet.topo import Topo
from mininet.net import Mininet
from mininet.util import dumpNodeConnections
from mininet.log import setLogLevel
from mininet.cli import CLI
from mininet.node import RemoteController

# Constants for POX Controller / Localhost IP και Default Port
CONTROLLER_IP = '127.0.0.1'
CONTROLLER_PORT = 6666

class FirewallTopo(Topo):
    """
    Custom topology for the Firewall exercise: 4 Hosts connected to 1 Switch (S1).
    All devices are controlled by a Remote POX Controller.
    """
    def build(self):
        s1 = self.addSwitch("s1")

        h1 = self.addHost("h1",mac="00:00:00:00:00:01", ip="10.0.2.10/24")
        h2 = self.addHost("h2",mac="00:00:00:00:00:02", ip="10.0.2.20/24")
        h3 = self.addHost("h3",mac="00:00:00:00:00:03", ip="10.0.2.30/24")
        h4 = self.addHost("h4",mac="00:00:00:00:00:04", ip="10.0.2.40/24")

        self.addLink(h1, s1)
        self.addLink(h2, s1)
        self.addLink(h3, s1)
        self.addLink(h4, s1)

# Define the topology
topos = {"firewall_topo": FirewallTopo}

def configure():
    topo = FirewallTopo()

    # Starting mininet and connecting to controller
    net = Mininet(
        topo=topo, 
        controller=lambda a: RemoteController(a, ip=CONTROLLER_IP, port=CONTROLLER_PORT)
    )
    net.start()

    print("\n*** Mininet topology started with Remote POX Controller at %s:%d ***\n" % (CONTROLLER_IP, CONTROLLER_PORT))
    
    #start mininet CLI
    CLI(net)
    net.stop()

if __name__ == "__main__":
    setLogLevel("info")
    configure()
