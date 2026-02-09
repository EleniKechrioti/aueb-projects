# Network Security: Nmap Network Exploration Lab

## Project Overview
This laboratory exercise explores the capabilities of **Nmap** (Network Mapper) for network discovery, security auditing, and service identification. The lab covers subnet scanning, OS fingerprinting, service version detection, and DNS analysis within a controlled environment.

## Environment Details
* **Institution:** Athens University of Economics and Business (AUEB)
* **Course:** Network Security (2024-2025)
* **Target Subnets:** `172.16.1.0/24`, `172.16.2.0/24`, `172.16.10.0/24`
* **Tools Used:** Nmap (CLI) and Zenmap (GUI)

---

## Lab Exercises & Methodology

### 1. Subnet Scanning & Host Discovery
**Command:** `nmap 172.16.1.10/24`
* **Objective:** Scan an entire subnet (256 IPs) for active hosts and open ports.
* **Findings:** Identified 56 active hosts. Since the scan occurred on a local network (LAN), Nmap utilized ARP pings, which automatically revealed the MAC addresses of the devices.

### 2. OS Fingerprinting
**Command:** `nmap -Pn -O 172.16.2.1/24`
* **Objective:** Identify the operating systems of hosts in the subnet.
* **Methodology:** Used `-Pn` to skip host discovery (treating all hosts as online) and `-O` for OS detection based on TCP/IP stack fingerprinting.
* **Results:** The network composition was found to be approximately 97.6% Windows and 2.4% Linux.

### 3. Service Version Detection & MAC Spoofing
**Command:** `nmap -sV -p 80 172.16.10.1-255`
* **Objective:** Identify specific web server versions running on port 80.
* **Findings:** Successfully identified various servers, including Apache httpd (2.4.x), nginx (1.14.2/1.10.3), and GoAhead WebServer.
* **Evasion Attempt:** Tested MAC address spoofing using `--spoof-mac 0`. In this specific local environment, spoofing resulted in zero hosts being detected, likely due to network security policies or ARP filtering.

### 4. DNS Operations
**Commands:** * `nmap -sL www.aueb.gr` (List scan to find IP)
* `nmap -R 195.251.255.156` (Reverse DNS lookup)
* **Objective:** Resolve hostnames to IPs and vice versa.
* **Findings:** Identified the IP address of `www.aueb.gr` as `195.251.255.156`. The reverse lookup revealed the internal hostname `www-cl.aueb.gr`.


## Key Conclusions
* **Local vs. Remote:** Nmap behaves differently on local segments (using ARP) versus remote segments.
* **Stealth and Accuracy:** OS detection provides high-confidence "guesses" but may vary depending on network conditions.
* **IDS/Firewall Impact:** Spoofing and scanning are easily detectable and can be blocked by modern network defenses.
