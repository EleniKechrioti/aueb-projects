# Network Security: Snort Intrusion Detection Lab

## Project Overview
This laboratory exercise focuses on configuring **Snort**, an open-source Intrusion Detection System (IDS), to detect specific network activities and potential threats. The lab involves writing custom rules in `local.rules` to monitor traffic between two hosts in a controlled environment.

## Environment Details
* **Institution:** Athens University of Economics and Business (AUEB)
* **Course:** Network Security (2024-2025)
* **Software:** Snort IDS (Installed at `C:\snort`)
* **Attacker/Peer IP:** 172.16.1.55
* **Victim IP:** 172.16.1.44

---

## Implemented Snort Rules

### 1. ICMP Ping Detection (Specific TTL)
**Objective:** Detect ICMP echo requests (ping) originating from a peer with a Time-to-Live (TTL) value of 99.
**Rule:**
`alert icmp 172.16.1.55 any -> 172.16.1.44 any (msg:"ICMP Ping with TTL 99"; ttl:99; sid:100001; rev:1;)`
* **Justification:** Standard TTL values are typically 64 or 128. A TTL of 99 is unusual and may indicate network scanning or manual packet crafting.

### 2. Remote Desktop (RDP) Attempt
**Objective:** Detect incoming Remote Desktop connection requests.
**Rule:**
`alert tcp 172.16.1.55 any -> 172.16.1.44 3389 (msg:"RDP Connection Attempt"; flags:S; sid:100002; rev:1;)`
* **Justification:** Monitors port 3389 (default RDP). The use of the `flags:S` (SYN) specifically targets the initiation of a new connection, reducing false positives.

### 3. Nmap Fast Scan Detection
**Objective:** Detect an Nmap "Fast Scan" while ignoring normal traffic (HTTP, HTTPS, SSH).
**Rule:**
`alert tcp 172.16.1.55 any -> 172.16.1.44 21 (flags:S; msg:"Nmap Fast Scan Detected"; sid:100003; rev:1;)`
* **Justification:** Nmap's fast scan targets the top 100 ports. By monitoring port 21 (FTP) for SYN packets while excluding common ports like 80, 443, and 22, we can identify scanning behavior with minimal log noise.

### 4. Nmap FIN Scan Detection
**Objective:** Detect a stealthy Nmap FIN scan targeting port 22 (SSH).
**Rule:**
`alert tcp 172.16.1.55 any -> 172.16.1.44 22 (flags:F; msg:"Nmap FIN Scan Detected"; sid:100004; rev:1;)`
* **Justification:** A FIN scan sends packets with only the FIN flag set to bypass simple IDS filters that only look for SYN scans. Targeting port 22 is critical as it is a common point of entry for attackers.


## Results Summary
All rules were successfully triggered during the lab session. Snort generated console alerts providing:
* Timestamp of the event.
* The specific Rule SID (100001-100004).
* The custom alert message.
* Source and Destination IP addresses and ports.
