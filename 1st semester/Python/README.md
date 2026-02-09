# Python Programming Exercises & Mini-Projects

A collection of Python projects and algorithmic exercises developed for the **Introduction to Programming with Python** course. This repository demonstrates various programming paradigms including Object-Oriented Programming (OOP), Functional Programming, Simulation, and Data Structures.

## Table of Contents
- [Algorithmic Collections](#algorithmic-collections)
    - [Assignment 1: Functional Programming & Math](#assignment-1-functional-programming--math)
    - [Assignment 2: Nested Data Structures](#assignment-2-nested-data-structures)
    - [Assignment 3: Geospatial Data Handling](#assignment-3-geospatial-data-handling)
- [Assignment 4: Conway's Game of Life](#assignment-4-conways-game-of-life)
- [Assignment 5: Object-Oriented Clock Simulation](#assignment-5-object-oriented-clock-simulation)


---

## Algorithmic Collections

### Assignment 1: Functional Programming & Math
Exploration of Python's functional capabilities and mathematical sequences.
* **Higher-Order Functions:** Custom implementations of `map`, `filter`, and logic using `lambda` functions.
* **Recursion:** Solving problems like "Sum of Squares" or "Digit Printing" without loops.
* **Sequence Summation:** Calculating complex mathematical series (e.g., Pi approximations).
* **List Comprehensions:** Efficiently filtering data (e.g., finding prime numbers up to *N*).

### Assignment 2: Nested Data Structures
* **Deep Traversal:** Algorithms to navigate and extract data from arbitrarily deep, nested lists (e.g., `['a', ['b', ['c']]]`).

### Assignment 3: Geospatial Data Handling
Working with abstract data types to manage geographical coordinates.
* **Haversine Logic:** Calculating the distance (in km) between two coordinates (Latitude/Longitude).
* **Nearest Neighbor:** Algorithms to find the closest Point of Interest (POI) from a list of locations.
* **Data Abstraction:** Managing `location` objects with getters for name, type, and coordinates.

---

## Assignment 4: Conway's Game of Life
A complete implementation of John Conway's "Game of Life," a cellular automaton simulation.

### Features
* **Grid Management:** Dynamic board creation using dictionaries for sparse matrix representation.
* **Simulation Logic:** Implements the core rules of survival, death, and reproduction based on neighbor counts.
* **Patterns:** Includes pre-built functions to spawn famous patterns like **Blinkers** and **Gliders**.
* **Visualization:** Renders the grid in the console using Unicode characters (⬛/⬜) for a visual representation of generations.

---

## Assignment 5: Object-Oriented Clock Simulation
A modular system simulating digital timekeeping using Class Inheritance and Composition.

### Key Classes
* **`Counter`**: A base class for simple incrementing values.
* **`CyclicCounter`**: Inherits from Counter; resets to zero after reaching a limit (modulo arithmetic).
* **`CascadeCounter`**: A counter that triggers a "next" counter when it wraps around (e.g., seconds triggering minutes).
* **`Clock`**: Composes hours, minutes, and seconds to simulate a full digital clock.
* **`RomanClock`**: A polymorphic variant displaying time in Roman Numerals (e.g., `XXIII:LIX:LVIII`).
* **`DayClock`**: Extends the clock to track days of the week alongside time.
