# Network Security

## Project Overview
This repository contains a comprehensive set of laboratory exercises conducted for the Network Security course at AUEB (2024-2025). The project covers three core pillars of network security: reconnaissance with Nmap, intrusion detection with Snort, and active Man-in-the-Middle (MitM) simulations.


## 1. Man-in-the-Middle Attack (ARP Poisoning)
Demonstration of an active MitM attack by manipulating the ARP cache of a victim and a gateway.

### Methodology & Execution
* **Setup:** Kali Linux (Attacker), Ubuntu (Victim), and a Network Gateway.
* **IP Forwarding:** Enabled on Kali to route intercepted traffic and maintain the victim's internet connectivity.
* **ARP Spoofing:** Executed `arpspoof` in dual directions:
    1. Convincing the Victim that the Attacker is the Gateway.
    2. Convincing the Gateway that the Attacker is the Victim.
* **Traffic Interception:** Captured redirected packets in Wireshark, identifying MDNS, UDP, and TCP traffic while monitoring for "Duplicate IP" warnings.


## 2. Intrusion Detection System (Snort)
Configuration of Snort IDS to monitor and alert on suspicious network traffic using custom-authored rules.

### Implemented Rules (local.rules)
* **ICMP Alert:** Detects PING requests with a non-standard TTL value of 99, indicating possible manual packet crafting.
* **RDP Detection:** Monitors TCP port 3389 for incoming Remote Desktop connection attempts.
* **Scan Detection:**
    * **Nmap Fast Scan:** Detects rapid SYN packets on port 21 while ignoring standard HTTP/SSH traffic.
    * **FIN Scan:** Detects stealthy scans on port 22 (SSH) that use the FIN flag to bypass traditional filters.
* **Validation:** All rules were successfully triggered, providing real-time alerts in the Snort console.

## 3. Network Reconnaissance (Nmap)
Exploration of network topology and identification of active services, operating systems, and vulnerabilities.

### Key Activities
* **Subnet Discovery:** Scanned the `172.16.1.10/24` range, identifying 56 active hosts.
* **OS Fingerprinting:** Analyzed the `172.16.2.1/24` subnet, identifying a composition of 97.6% Windows and 2.4% Linux devices.
* **Service Auditing:** Version detection on port 80 identified specific web servers including Apache 2.4.x and Nginx.
* **Evasion Testing:** Evaluated MAC address spoofing (`--spoof-mac`) to test network invisibility and firewall bypass.
* **DNS Analysis:** Performed reverse DNS lookups to map IP addresses (e.g., `195.251.255.156`) back to hostnames (`www-cl.aueb.gr`).

