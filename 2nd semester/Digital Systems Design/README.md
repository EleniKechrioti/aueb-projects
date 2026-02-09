# Digital System Design Projects

This repository contains two assignments developed for the "Digital System Design" course. The projects focus on digital logic design, circuit minimization, and hierarchical architecture using VHDL and the Intel Quartus software.

## Tools Used
* **Language:** VHDL
* **Software:** Intel (Altera) Quartus Prime
* **Simulation:** Quartus Functional Simulation (Waveforms)
* **Design Entry:** VHDL Code & Block/Schematic Diagrams

---

## Assignment 1: Combinational Circuits & VHDL Basics

This assignment focuses on the minimization of boolean functions and their implementation using both VHDL code and schematic diagrams.

### Problem 1: Boolean Function Implementation
* **Objective:** Design a circuit for the function $F(x_1...x_5)$ defined by specific minterms and don't-care terms.
* **Methodology:**
    * Calculate Sum of Products (SOP) and Product of Sums (POS) forms using Karnaugh maps to determine the minimum cost.
    * Implement the lowest-cost circuit in VHDL using components for sum/product terms.
* **Verification:** Functional simulation for all input combinations and RTL Viewer analysis.

### Problem 2: Schematic Design
* **Objective:** Design a circuit for a 4-variable function $f(x_1...x_4)$ which outputs 1 only if $x_1=0$ and exactly two of the remaining variables are 1.
* **Methodology:**
    * Derive the minimum cost POS form.
    * Implement the design using the Quartus Block/Schematic Diagram editor (instead of VHDL code).
* **Verification:** Functional simulation with a step of 20nsec.

### Problem 3: Reverse Engineering from Timing
* **Objective:** Analyze a provided timing diagram to deduce the boolean function it represents.
* **Methodology:**
    * Extract the simplest SOP form from the waveforms.
    * Implement the derived function in VHDL.
* **Verification:** Confirm that the output simulation matches the original timing diagram.

---

## Assignment 2: Hierarchical 16-bit ALU Design

This major project involves the hierarchical design of a 16-bit Arithmetic Logic Unit (ALU) capable of performing arithmetic and logic operations.

### Overview
The ALU operates on 16-bit signed numbers (2's complement) and supports overflow detection. The design is split into two parts: designing a 1-bit slice and then cascading it to form the 16-bit unit.

### Supported Operations
The ALU implements the following operations based on a 3-bit Opcode:
* **Arithmetic:** Addition (ADD), Subtraction (SUB).
* **Logic:** AND, OR, XOR, NOR, NAND.

### Architecture

#### Part 1: 1-bit ALU Slice
The 1-bit ALU is constructed structurally using components. It features:
* **Logic Unit:** Performs AND/OR operations using multiplexers.
* **Full Adder:** Handles addition and carries.
* **Subtraction Logic:** Implements Subtraction via 2's complement (adding 1 via CarryIn and inverting input B via `Binvert`).
* **Universal Logic:** Implements NOR/NAND using De Morgan's laws by manipulating input inverters (`Ainvert`, `Binvert`) and the OR/AND gates.
* **XOR Support:** Includes specific logic for Exclusive-OR operations.

#### Part 2: 16-bit ALU & Control Circuit
* **Ripple Carry Architecture:** Connects 16 instances of the 1-bit ALU, where the `CarryOut` of one slice drives the `CarryIn` of the next.
* **Overflow Detection:** Calculates overflow using the carry bits of the last two stages ($C_{n-1} \oplus C_n$).
* **Control Circuit:** Decodes the `opcode` (e.g., "011" for SUB) into specific control signals (`Operation`, `Ainvert`, `Binvert`, `CarryIn`) to drive the ALU components.

### Verification
The design is verified via Quartus waveforms using specific test vectors provided in the assignment specifications:
1.  **Arithmetic:** Verified with specific 16-bit binary inputs for ADD/SUB.
2.  **Basic Logic:** Verified using inputs for AND/OR.
3.  **Complex Logic:** Verified using inputs for NAND/NOR/XOR.