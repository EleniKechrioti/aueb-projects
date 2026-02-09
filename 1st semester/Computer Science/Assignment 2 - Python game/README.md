# Connect 4: Pop & Collapse Variant

A Python-based command-line strategy game developed for the **Introduction to Computer Science** course. This project implements a variation of the classic "Connect 4" game with dynamic board sizing, a scoring system, and a unique "collapsing" gravity mechanic similar to Tetris or Candy Crush.

## Table of Contents
- [About the Game](#about-the-game)
- [Features](#features)
- [How to Play](#how-to-play)
- [Installation & Execution](#installation--execution)
- [Project Structure](#project-structure)
- [Technical Implementation](#technical-implementation)

## About the Game
This is a turn-based strategy game for two players (`O` and `X`). Players drop pieces into columns, attempting to align 4 matching symbols vertically, horizontally, or diagonally.

**The Twist:** unlike standard Connect 4, when a sequence of 4 is formed:
1. The matching pieces **disappear**.
2. The player earns points.
3. The pieces directly above the match **slide down** to fill the gaps (gravity simulation), potentially creating chain reactions.

## Features
* **Dynamic Board Size:** Players can choose a grid size ranging from **5x5 to 10x10**.
* **Save & Load System:** The game state (board + scores) can be saved to a `.csv` file and resumed later.
* **Scoring System:** The game tracks points for both players throughout the session.
* **Physics Simulation:** Implements "gravity" logic where pieces stack up and slide down when support is removed.
* **Input Validation:** Ensures players only enter valid column numbers and commands.

## How to Play
1.  **Start the Game:** Choose between a **New Game (N)** or **Load Game (S)**.
2.  **Setup:** If starting new, input the desired number of columns (5-10).
3.  **Turns:**
    * **Player 1** plays as `O`.
    * **Player 2** plays as `X`.
    * Enter the column number where you want to drop your piece.
4.  **Winning:** Create lines of 4 to earn points. The game continues until players decide to stop or the board is full.
5.  **Controls:**
    * Enter numbers `1-10` to drop a piece.
    * Press `s` between turns to **Save and Quit**.

## Installation & Execution

### Prerequisites
* Python 3.x

### Running the Game
1.  Clone or download this repository.
2.  Navigate to the project folder.
3.  Run the main script:
    ```bash
    python program.py
    ```
    *(Note: Ensure `synarthseis.py` is in the same directory)*

## Project Structure

* `program.py`: The entry point of the application. Handles game initialization, user inputs, and the main game loop.
* `synarthseis.py`: Contains all the core logic functions:
    * `table()`: Renders the board.
    * `fill_board()`: Handles placing pieces.
    * `stars()`: Checks for winning conditions.
    * `olor()`, `olka8()`, `oldk()`, `oldd()`: Functions handling the "sliding/collapsing" logic for horizontal, vertical, and diagonal matches.
* `*.csv`: Stores saved game data.

## Technical Implementation
* **Board Representation:** The 2D grid is flattened and managed as a **single-dimensional list** (`1D array`), using mathematical logic to calculate row/column positions (`index = lines * i + j`).
* **Gravity Logic:** Custom algorithms calculate how many positions a piece must drop when a match is cleared below it.
* **File I/O:** Uses Python's `csv` library to serialize the board state and player scores.
