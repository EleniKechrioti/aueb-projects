# ARP Poisoning & MitM Attack Lab

## Project Overview
This laboratory exercise demonstrates a **Man-in-the-Middle (MitM)** attack using **ARP Cache Poisoning**. The goal was to intercept communication between a victim and a gateway within a controlled virtual environment to understand network vulnerabilities.

## Environment Setup
The lab was implemented using the following configuration:
* **Virtualization:** Oracle VM VirtualBox.
* **Attacker Machine:** Kali Linux (2024.1).
* **Victim Machine:** Ubuntu.
* **Network:** A custom NAT Network named `netsec` with the IP range `192.168.1.0/24`.
* **DHCP:** Disabled for manual IP assignment.

### Network Topology
| Machine | IP Address | MAC Address |
| :--- | :--- | :--- |
| **Attacker (Kali)** | 192.168.1.10 | 08:00:27:44:F9:12 |
| **Victim (Ubuntu)** | 192.168.1.11 | 08:00:27:2F:F4:29 |
| **Gateway (Router)**| 192.168.1.1 | 52:54:00:12:35:00 |

---

## Execution Steps

### 1. Attacker Preparation
To allow the Kali machine to act as a router and forward intercepted packets, **IP Forwarding** was enabled via the terminal:
```bash
sudo sysctl -w net.ipv4.ip_forward=1
```

The **dsniff** suite was also installed to provide the `arpspoof` tool.

### 2. Network Discovery
The attacker used `netdiscover` to scan the network and identify active hosts:
```bash
sudo netdiscover -r 192.168.1.0/24
```

This scan confirmed the presence of the Ubuntu victim and the network gateway.

### 3. Launching the Attack
Two simultaneous `arpspoof` instances were executed to poison the ARP caches of both targets:
* **Target Victim:** 
```bash
sudo arpspoof -i eth0 -t 192.168.1.11 192.168.1.1
```
* **Target Router:** 
```bash
sudo arpspoof -i eth0 -t 192.168.1.1 192.168.1.11
```

### 4. Validation
The attack was verified on the Ubuntu machine using the `arp -a` command. Success was confirmed when the gateway's IP (192.168.1.1) was correctly associated with the attacker's MAC address.

---

## Analysis & Findings
* **Packet Capture:** Using **Wireshark**, real-time ARP replies were captured and analyzed.
* **Duplicate Detection:** Wireshark flagged "Duplicate IP address" warnings, providing visual proof of the spoofing activity.
* **Traffic Interception:** The setup successfully monitored **UDP**, **MDNS**, and **TCP** connection attempts from the victim to external servers.
* **Limitations:** Establishing a static IP on the victim caused a loss of external internet access, which limited the use of higher-level tools like `urlsnarf`.
