# Data Structures & Algorithms Projects

## Overview
This repository contains a collection of three comprehensive projects developed in **Java**, focusing on fundamental and advanced data structures, algorithmic efficiency, and problem-solving.

---

## Project 1: Linear Data Structures & Maze Solver
**Focus:** Stacks, Queues, Linked Lists, and Depth-First Search (DFS).

### Key Implementations
1.  **Custom Stack & Queue:**
    * Implemented `StringStack` and `StringQueue` interfaces using a custom singly linked list (`Node` class) rather than Java's built-in libraries.
    * **Stack:** Standard LIFO operations (`push`, `pop`, `peek`) with exception handling.
    * **Queue:** FIFO operations (`put`, `get`, `peek`) utilizing `head` and `tail` pointers for efficiency.

2.  **Circular Queue Optimization:**
    * Implemented `StringQueueWithOnePointer`, a space-efficient circular queue using only a single `tail` pointer (where `tail.next` points to the head).

3.  **Maze Solver Application:**
    * A backtracking algorithm (`solve_maze`) to find a path from an entrance to an exit in a 2D grid.
    * **Logic:** Uses a **Stack** to store coordinates, exploring paths and backtracking when hitting dead ends or visited cells (marked to prevent infinite loops).

---

## Project 2: Priority Queues & Greedy Algorithms
**Focus:** Binary Heaps, Sorting, and Optimization Problems (Bin Packing).

### Key Implementations
1.  **Max Priority Queue (`MaxPQ`):**
    * A resizeable Binary Heap implementation supporting `insert`, `getMax`, `swim`, and `sink` operations to maintain heap invariants.
    * Used to efficiently manage disks based on their remaining free space.

2.  **Disk Storage Simulation (Bin Packing):**
    * **Problem:** Storing folders of varying sizes into the minimum number of 1TB disks.
    * **Greedy Algorithm:** Processes folders in the order they arrive, placing them in the disk with the most free space (retrieved via `MaxPQ`).
    * **Greedy-Decreasing Algorithm:** Sorts folders by size (descending) before processing.

3.  **Quicksort:**
    * A custom implementation of the Quicksort algorithm to sort folder data for the Greedy-Decreasing approach.

### Experimental Results
* Performed comparative analysis on datasets of 100, 500, and 1000 folders.
* **Result:** The **Greedy-Decreasing** algorithm significantly outperformed the standard Greedy approach, reducing the number of disks required (e.g., ~509 disks vs. ~587 for N=1000).

---

## Project 3: Geometric Data Structures & Spatial Search
**Focus:** Trees, Recursion, and 2D Spatial Querying.

### Key Implementations
1.  **Geometric Primitives (`Rectangle`):**
    * A class representing 2D axis-aligned bounding boxes.
    * Includes logic for point containment (`contains`), intersection detection (`intersects`), and efficient Euclidean distance calculation (`distanceTo`) from a point to the rectangle edges.

2.  **Spatial Tree Structure:**
    * Implemented a tree-based structure (using `TreeNode`) to organize 2D points, facilitating fast spatial queries.

3.  **Spatial Algorithms:**
    * **Range Search:** Finds all points contained within a query rectangle. Uses **pruning** to ignore subtrees that do not intersect with the query area.
    * **Nearest Neighbor:** Finds the closest point to a specific query coordinate. Uses recursion and branch-and-bound logic to minimize the search space.