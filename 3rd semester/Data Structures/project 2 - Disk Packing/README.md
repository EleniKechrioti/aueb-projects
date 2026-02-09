# Data Structures Project 2: Disk Storage Simulation

## Project Overview
This project implements a simulation of the **Bin Packing Problem** using **Greedy Algorithms** and **Priority Queues**. The goal is to store a set of folders (with specific sizes in MB) into the minimum number of Disks (bins) possible.

The project compares two algorithmic approaches:
1.  **Greedy:** Processes folders in the order they appear.
2.  **Greedy-Decreasing:** Sorts folders in descending order before processing.

---

## Project Structure

The implementation is divided into four main parts:

### Part A: Max Priority Queue (`MaxPQ`)
A custom implementation of a Max Priority Queue using a binary heap structure.
* **Key Features:**
    * Dynamic resizing: The heap automatically expands (`grow()`) when full.
    * **Core Methods:** `insert`, `peek`, `getMax`, `getSize`.
    * **Helper Methods:** `sink`, `swim`, `swap` to maintain heap invariants.
* **Usage:** It stores `Disk` objects, prioritizing the disk with the **most free space**.

### Part B: The Greedy Algorithm
The `Greedy` class handles the logic of reading folder data and distributing them to disks.
* **Data Input:** Reads folder sizes from `.txt` files via the `readFile` method.
* **Algorithm Logic:**
    1.  Uses `MaxPQ` to manage active disks using a `DiskComparator` (compares based on free space).
    2.  For every folder:
        * Checks the disk with the *most* free space (`peek()`).
        * If the folder fits, the disk is removed (`getMax()`), updated, and re-inserted to refresh its priority.
        * If the folder does not fit, a **new Disk** is created and added to the queue.

### Part C: Sorting (`Sort` Class)
Implementation of the **Quicksort** algorithm to support the "Greedy-Decreasing" approach.
* **Functionality:** Sorts an array of integers (folder sizes) in **descending order**.
* **Components:**
    * `partition`: Rearranges elements based on a pivot (last element) .
    * `swap`: Helper to exchange elements.

### Part D: Data Generation & Experimentation
* **`CreateFolders`:** Generates random test datasets.
    * Creates 10 files for each $N$ category ($N=100, 500, 1000$ folders).
    * Folder sizes are random integers between 0 and 1,000,000 MB .
* **`Experiment`:** Compares the efficiency of the two algorithms.
    * Runs both algorithms on the generated datasets.
    * Calculates the average number of disks used for each case.

---

## Experimental Results

The experiment compared the **Greedy** (unsorted input) vs. **Greedy-Decreasing** (sorted input) approaches across different dataset sizes ($N$).

| N (Folders) | Avg Disks (Greedy) | Avg Disks (Greedy-Decreasing) | Conclusion |
| :--- | :--- | :--- | :--- |
| **100** | 59.1 | **52.9** | ~10% improvement |
| **500** | 293.1 | **256.6** | Significant reduction |
| **1000** | 587.3 | **509.3** | Major efficiency gain |

**Analysis:**
The **Greedy-Decreasing** algorithm consistently outperforms the standard Greedy approach. By processing larger folders first, the algorithm utilizes disk space more efficiently, reducing the total number of disks required. This efficiency gap widens as the number of folders ($N$) increases.

---

## How to Run

1.  **Generate Data:** Run `CreateFolders` to generate the test `.txt` files in the `data/` directory.
    ```java
    java CreateFolders <number_of_folders>
    ```
2.  **Run Experiment:** Run `Experiment` to execute the comparison and view the results in the console.
    ```java
    java Experiment
    ```
