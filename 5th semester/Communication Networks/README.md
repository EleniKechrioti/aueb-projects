# Wireshark Network Traffic Analysis

This project involves the analysis of network traffic using **Wireshark** as part of the **Computer Networks** course (2023-2024) at the Athens University of Economics and Business. The goal is to dissect various network protocols across different layers of the OSI model, focusing on HTTP, TCP, and DNS.

## Project Overview

The analysis is based on captured network traffic (`.pcap` files) and addresses specific questions regarding protocol headers, handshake mechanisms, and data transmission.

### Protocols Analyzed
* **HTTP (Hypertext Transfer Protocol):** Analysis of GET requests, status codes (200 OK, 304 Not Modified), and header fields like `Accept-Language` and `If-Modified-Since`.
* **TCP (Transmission Control Protocol):** Detailed examination of the **Three-Way Handshake** (SYN, SYN-ACK, ACK), sequence numbers, and segment lengths.
* **DNS (Domain Name System):** Inspection of recursive queries, CNAME records, and IP address resolution for specific hostnames.



## Key Tasks & Analysis

### 1. HTTP Protocol Analysis
* Identifying the browser and server versions via the `User-Agent` and `Server` fields.
* Analyzing the conditional GET mechanism and how servers respond when a page has not been modified.
* Determining the total data size transferred and the number of TCP segments required for a single HTTP response.

### 2. TCP Protocol Details
* Extracting Source and Destination ports for communication.
* Calculating the relative and absolute sequence numbers to track data flow.
* Identifying the presence of specific TCP flags (SYN, ACK, FIN, PSH).



### 3. DNS Analysis
* Verifying the transport layer protocol used (UDP).
* Checking the destination port for DNS queries (Port 53).
* Analyzing DNS response packets to identify the aliases (CNAME) and final IP addresses of web servers.

## Files Included
* `wireshark_exercise_2023-2024.pdf`: The official assignment guidelines and questions.
* `exercise_solutions.pdf`: Detailed answers and screenshots from the Wireshark analysis.
