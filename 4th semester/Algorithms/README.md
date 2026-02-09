# Algorithms - Homework Assignments

This repository contains the solutions and algorithmic analysis for the **"Algorithms"** course.


## Assignment Series 1: Complexity & Divide and Conquer

### Exercise 1: Asymptotic Notation Ranking
A comprehensive ranking of functions based on their rate of growth.
* **Ranked Functions:** From slowest to fastest growing: $\sqrt{\log_9 n}$, $\log(\sqrt{n})$, $2^{\frac{\log n}{2}}$, $\log(4^n)$, $\log(n^n)$, $(\log(2^n))^2$, $8^{\log n}$, $n^{\log n}$, $2^n$, $2^{n \log n}$, $n!$.

### Exercise 2: Big-O Proofs
Mathematical proofs using limits and derivatives to verify asymptotic bounds.
* **2a:** Proof that $n \cdot 2^n = O(3^n)$.
* **2b:** Proof that $n^2 \cdot 2^n + 10 = O(3^n)$.

### Exercise 3: Recurrence Relations & Master Theorem
Solving recurrence relations to determine algorithm time complexity.
* **3a:** Analysis of $T(n) = 2T(n/2) + n$, resulting in $\Theta(n \log n)$.
* **3b:** Analysis of $T(n) = 2T(n/2) + 1$, resulting in $\Theta(n)$.

### Exercise 4: Majority Element Algorithm
Analysis and implementation of an algorithm to find a majority element in an array.
* **Logic:** Covers both even and odd array sizes.
* **Complexity:** Proved to be $O(n)$ using the Master Theorem.

### Exercise 5: Bin Packing (Color Sorting)
An algorithm to fill boxes with balls of different colors, ensuring each box contains exactly 20 balls using at most two colors.
* **Technique:** Uses Mergesort ($O(n \log n)$) to sort colors by quantity and then pairs them.
* **Complexity:** Total complexity of $O(n^2)$ including initialization, or $O(n \log n)$ for the core logic.

---

## Assignment Series 2: Greedy Algorithms & Dynamic Programming

### Exercise 1: Guest List Optimization
An algorithm to maximize the number of invited guests under specific social constraints (each guest must know at least 4 others and not know at least 4 others).
* **Approach:** Iterative exclusion of guests who do not meet criteria.
* **Complexity:** $O(n^3)$.

### Exercise 2: Minimum Coin Change Problem
A dynamic programming solution to find the minimum number of coins needed to reach a specific value $E$.
* **Approach:** Uses a $(n+1) \times (E+1)$ table to store sub-problem results.
* **Complexity:** $O(n \cdot E)$.

### Exercise 3: Travel Stops (Penalty Minimization)
Optimizing stops during a 400km trip to minimize a squared penalty function $(40 - x)^2$.
* **Logic:** Dynamic programming to find the optimal sequence of stops.
* **Complexity:** $O(n^2)$.

### Exercise 4: Chessboard Value Optimization
Finding a set of cells on an $n \times n$ board to maximize total value, with the constraint that no two cells can be in the same column in adjacent rows.
* **Dynamic Programming:** Optimized approach achieved $O(n^2)$ complexity by keeping track of the two maximum values per row.
* **Greedy vs. Optimal:** Includes a counter-example proving the greedy approach is non-optimal, with an approximation ratio analysis (up to 3 for $3 \times 3$ boards).

---

## 🛠️ Implementation Details
* **Documentation:** All proofs and pseudocode are documented in Greek.
* **Tools Used:** Mathematical analysis, induction proofs, and Python-style pseudocode.