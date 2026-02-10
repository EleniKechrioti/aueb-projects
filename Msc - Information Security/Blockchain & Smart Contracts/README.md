# Blockchains and Smart Contracts - Coursework

This repository contains the smart contract implementation for "CryptoSOS", a decentralized, multiplayer version of the SOS game developed in Solidity for the Ethereum blockchain.

---

## Project Overview: CryptoSOS
**Objective:** Design and implement a secure, gas-efficient smart contract that manages a 3x3 SOS game, handling player turns, win/tie conditions, and automated financial settlements.

### Game Mechanics:
* **SOS Logic:** Played on a 3x3 grid where two players take turns placing "S" or "O". The first to form the word "SOS" (horizontally, vertically, or diagonally) wins.
* **Economic Stakes:** Each player must deposit exactly 1 Ether to join the game.
* **Payout Structure:** * **Winner:** Receives 1.8 Ether.
    * **Tie:** Both players receive 0.95 Ether.
    * **Fees:** The contract keeps a small commission (0.2 Ether for a win, 0.1 total for a tie).

### Smart Contract Features:
* **Automated Lobby:** Handles player registration and emits `StartGame` events. It prevents a third player from joining once a game is in progress.
* **Game State Management:** Includes functions like `placeS()` and `placeO()` for moves and `getGameState()` for retrieving the current board as a string.
* **Timeout Protections:** * **Cancel:** Allows the first player to withdraw their funds if no opponent joins within 2 minutes.
    * **TooSlow (Player):** Allows a player to claim a win (1.5 Ether) if their opponent delays a move for more than 1 minute.
    * **TooSlow (Owner):** Allows the contract owner to end a stale game as a tie if no moves occur for 5 minutes.
* **Financial Integrity:** Features a `sweepBalance` function for the owner to collect assets, ensuring that enough balance is always reserved for ongoing games.

### Security & Optimization:
* **Security-First Design:** Protected against common smart contract attacks studied in class (e.g., reentrancy, unauthorized access).
* **Gas Optimization:** Use of efficient data types (like `uint64` for timestamps) and optimized logic to reduce execution costs on the EVM.
* **Event-Driven Transparency:** Emits detailed events for every move, game start, and termination (Winner/Tie) for easy off-chain monitoring.

---

## Technical Specifications
* **Language:** Solidity ^0.8.*
* **Framework:** Ethereum Virtual Machine (EVM)
* **API:** Public functions for joining, playing, and managing the game state.