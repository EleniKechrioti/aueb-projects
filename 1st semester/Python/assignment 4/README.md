# Conway's Game of Life Simulation

A Python implementation of John Conway's famous cellular automaton. This project simulates the evolution of cells on a grid based on a set of mathematical rules regarding population and survival.

## Description
The **Game of Life** is a zero-player game. Its evolution is determined by its initial state, requiring no further input. The board is represented using a **sparse matrix** approach (Python Dictionary), ensuring memory efficiency by only tracking live cells.

## Key Features
* **Sparse Matrix Representation:** Uses a dictionary `{(x,y): True/False}` to manage grid state.
* **Simulation Rules:**
    * **Underpopulation:** A live cell with < 2 neighbors dies.
    * **Survival:** A live cell with 2 or 3 neighbors lives.
    * **Overpopulation:** A live cell with > 3 neighbors dies.
    * **Reproduction:** A dead cell with exactly 3 neighbors becomes a live cell.
* **Pattern Generation:** Includes functions to spawn famous patterns like **Blinkers** and **Gliders**.
* **Visualization:** Console-based rendering using Unicode characters (⬛/⬜).

## Usage
```python
from game_of_life import board, place_glider, tick, print_board

# Initialize a 10x10 board
game = board(10)

# Add a Glider pattern at position (2,2)
place_glider(game, (2, 2))

# Evolve the game by one generation
tick(game)

# Display the board
print_board(game)