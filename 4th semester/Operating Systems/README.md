# Pizzeria Ordering & Delivery System (POSIX Threads)

This project is a multi-threaded simulation of a pizzeria's ordering, preparation, and delivery system.

## Project Overview

The system simulates an electronic pizzeria where orders are placed, paid for, prepared, baked, packed, and delivered. The core challenge involves managing a large volume of concurrent orders using a limited pool of resources, requiring robust **Mutual Exclusion** (mutexes) and **Synchronization** (condition variables).

### System Resources
The pizzeria operates with the following fixed staff and equipment:
* **Cooks ($N_{cook}$):** 2
* **Ovens ($N_{oven}$):** 15
* **Packers ($N_{packer}$):** 2
* **Deliverers ($N_{deliverer}$):** 10


## Process Workflow

Each customer is represented by a unique thread (total $N_{cust}$ threads). The lifecycle of an order follows these strictly synchronized stages:

1.  **Arrival:** Customers arrive at random intervals between 1-3 minutes.
2.  **Order Details:** A customer orders 1-5 pizzas[cite: 2313, 2314]. Each pizza has a 60% chance of being "Plain" (€10) and a 40% chance of being "Special" (€12).
3.  **Payment:** Credit card processing takes 1-3 minutes[cite: 2316, 2317]. There is a 10% failure rate, which results in order cancellation.
4.  **Preparation:** A cook prepares each pizza ($T_{prep} = 1$ min per pizza).
5.  **Baking:** The cook waits for enough available ovens to bake all pizzas in the order simultaneously. One oven holds one pizza. Baking takes 10 minutes ($T_{bake}$).
6.  **Packing:** Once baked, the cook is released. A packer removes and boxes the pizzas ($T_{pack} = 1$ min per pizza), then releases the ovens.
7.  **Delivery:** A deliverer transports the order (5-15 mins) and returns to the shop (equal return time) before becoming available again.


## Output & Statistics

Upon completion, the system provides a detailed report including:
* **Financials:** Total revenue and number of pizzas sold by type.
* **Order Tracking:** Total count of successful and failed order.
* **Service Times:** Average and maximum time from order placement to delivery.
* **Quality Metrics:** Average and maximum "cooling time" (from oven exit to delivery).


## Project Structure
- header.h: Header file containing constants and function prototypes.
- main.c: Main source code implementing the thread logic and synchronization.
- test-res.sh: Shell script for automated compilation and testing.

## Execution Instructions

### Compilation
To compile the program, use the `gcc` compiler with the `-pthread` flag to link the POSIX threads library:

```bash
gcc -pthread p3x-p3y-p3z-pizzeria.c -o pizzeria
```

## Running
The program requires two parameters: the number of customers and a random seed.

```Bash
./pizzeria 100 1000
```
(Note: To ensure reasonable execution time, the simulation treats given time units as seconds instead of minutes.)
