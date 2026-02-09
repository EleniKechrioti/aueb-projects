# Data Structures Project 3: 2D Spatial Search


## Project Overview
This project focuses on **Geometric Data Structures** and **Spatial Search Algorithms**. It involves implementing a library for handling 2D rectangles and a spatial tree structure (likely a 2D-Tree) to efficiently perform **Range Searches** and **Nearest Neighbor** queries on a set of 2D points.

---

## Implementation Details

The project is divided into two main parts:

### Part A: Geometric Primitives (`Rectangle` Class)
A class representing an axis-aligned bounding box (AABB) defined by its minimum and maximum coordinates $[x_{min}, x_{max}] \times [y_{min}, y_{max}]$.

* **`contains(Point p)`** Determines if a given 2D point lies within the rectangle boundaries.
    * **Logic:** Checks if $x \in [x_{min}, x_{max}]$ and $y \in [y_{min}, y_{max}]$ simultaneously.

* **`intersects(Rectangle that)`** Checks if the rectangle overlaps with another rectangle.
    * **Logic:** Instead of checking for overlap directly, it efficiently checks for the *absence* of overlap (e.g., if one rectangle is completely to the left or above the other). If none of the non-overlapping conditions are met, the rectangles intersect.

* **`distanceTo(Point p)`** Calculates the Euclidean distance from a point $p$ to the rectangle.
    * **Inside:** Returns `0` if the point is inside or on the boundary.
    * **Outside:** Calculates the distance to the nearest edge or corner. It handles various cases, such as when the point is strictly diagonal to a corner (using Euclidean distance) or directly perpendicular to an edge (using linear difference).

### Part B: Spatial Tree & Search Algorithms
Implementation of a tree-based data structure (using `TreeNode`) to manage 2D points and perform efficient spatial queries.

#### 1. Range Search
Finds all points contained within a given query rectangle.
* **`rangeSearch(Rectangle rect)`:** Initializes the search and clears previous results.
* **`rangeSearch_helper(TreeNode t, Rectangle rect)`:** A recursive method that traverses the tree.
    * **Pruning:** It checks if the query rectangle intersects with the node's region. If not, it prunes the search for that subtree.
    * **Collection:** If the current node's point is inside the query rectangle, it is added to the results list.
    * **Recursion:** Recursively searches left and right subtrees if they intersect with the query area.

#### 2. Nearest Neighbor Search
Finds the point in the tree closest to a given query point $p$.
* **`nearestNeighbor(Point p)`:** Bootstraps the recursive search, returning `null` if the tree is empty.
* **`nearestNeighbor_helper(TreeNode t, Point p)`:** Recursively searches the tree to minimize the distance to $p$.
    * **Leaf Case:** Returns the current node if it has no children.
    * **Recursive Step:** Decides which subtree (left or right) to search first based on the query point's location relative to the splitting axis.
    * **Comparison:** It compares the distances from the current node, the best candidate from the left subtree, and the best candidate from the right subtree, returning the closest one.

---

## Key Concepts
* **Geometric Algorithms:** Efficient intersection and distance calculations for Axis-Aligned Bounding Boxes.
* **Spatial Indexing:** Using trees to organize 2D data.
* **Pruning:** Optimizing search queries by eliminating subtrees that cannot contain the solution.
* **Recursion:** utilized heavily for tree traversal and backtracking.
