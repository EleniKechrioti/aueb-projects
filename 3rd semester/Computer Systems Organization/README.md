# Computer Systems Organization - MIPS32 Assignments

This repository contains the assembly projects developed for the **"Computer Systems Organization"** course.

## Assignment Overview

### Assignment 1: Simple Arithmetic Calculator
An interactive program that evaluates arithmetic expressions from left to right.

* **Operations:** Supports signed decimal integers and operators `+`, `-`, `*`, `/` (integer division), and `%` (modulo).
* **Flow:** The user enters numbers and operators in different lines, ending the expression with `=`.
* **Features:** Includes error handling for invalid operators and division by zero.
* **Repetition:** The program loops to calculate new expressions based on user input (`y/n`).

### Assignment 2: Pattern Matching & Code Validation
A program designed to scan a string and validate a specific syntax for a code.

* **Logic:** The program ignores all characters until it encounters the `#` symbol.
* **Validation:** Once `#` is found, the next 4 characters must be binary digits (`0` or `1`).
* **Output:** Displays `ok` if the code is valid, otherwise displays `not ok`.

### Assignment 3: Postfix Evaluation (RPN Calculator)
A calculator that evaluates expressions in Reverse Polish Notation (RPN) using the system stack.

* **Stack Implementation:** Uses the MIPS stack pointer (`$sp`) rather than an array.
* **Input:** Unsigned integers separated by at least one space, ending with `=`.
* **Algorithm:**
    * Push operands onto the stack.
    * For operators (`+`, `-`, `*`, `/`), pop two values, calculate, and push the result back.
* **Architecture:** Requires the implementation of specific subprograms: `push`, `pop`, and `calc`.