# Internet Technologies and Services - Coursework

This repository contains the projects completed for the "Internet Technologies and Services" course. The assignments focus on network emulation using Mininet, traffic analysis with Wireshark, and Software-Defined Networking (SDN).

---

## 1. Multi-Hop Network Analysis & Classic Routing
**Topic:** Traffic analysis in a diamond-topology network using Static and Dynamic (RIP) routing.

This project involved designing a complex network topology to understand Layer 3 routing principles and protocol behavior.

### Key Components:
* **Diamond Topology:** Built a custom topology (`H1-R1-R2-R4-H3` and `H2-R1-R3-R4-H4`) using Python scripting in Mininet.
* **Routing Scenarios:**
    * **Static Routing:** Manually configured IP routes to enable specific communication paths between hosts.
    * **Dynamic Routing (RIPv2):** Implemented the Routing Information Protocol using a distance-vector algorithm to automate route discovery and path selection.
* **Traffic Inspection:** Used Wireshark on router interfaces to capture and analyze ARP, ICMP, and RIPv2 control traffic.
* **Linux Kernel Routing:** Configured hosts as L3 routers by enabling IP forwarding and managing system routing tables.


---

## 2. SDN Firewall Implementation (Mininet & POX)
**Topic:** Implementation of a centralized Firewall using Software-Defined Networking (SDN) principles.

The second project focused on the separation of the Control Plane and Data Plane by creating a programmable firewall via a remote controller.

### Key Components:
* **Architecture:** Deployed a network with 4 Hosts and 1 OpenFlow Switch controlled by a remote **POX Controller**.
* **Flow Management:** Developed a Python-based controller (`myController.py`) to "install" specific flow rules into the switch’s Flow Table.
* **Firewall Policy:** * **Permit:** All ARP traffic (flooding) and UDP packets.
    * **Selective Permit:** Bi-directional HTTP traffic specifically between Host 1 and Host 4.
    * **Deny:** Explicitly dropped all other TCP traffic.
* **Verification:** Validated rule enforcement using `iperfudp` for UDP testing, `wget` for HTTP requests, and `dpctl dump-flows` to inspect the switch's active flow entries.


---

## Technologies & Tools
* **Network Emulator:** Mininet
* **SDN Controller:** POX (OpenFlow 1.3)
* **Protocol Analysis:** Wireshark
* **Scripting:** Python 3
* **Linux Utilities:** xterm, sysctl, ifconfig, ip route