## Theseus - Maze Solving

Theseus is a java based program for the course of Data Structures at AUEB. It was one of the three assignments done in my 
3rd semester studying there. The description of the 
[assignment](https://github.com/EleniKechrioti/Maze-Solving-Theseus/blob/main/DS22-project1.pdf)
and the final [report](https://github.com/EleniKechrioti/Maze-Solving-Theseus/blob/main/project1-report.pdf)
can be found in greek in this repository.

### Description
The aim of the assignment is to become familiar with basic abstract data types such as stacks, and FIFO queues. 
The assignment consists of 2 Abstarct Data Types (ADT) implementations (Parts A and C) as well as 1 application (Part B).

Using the implementations of the first part, we build Thiseas, a client program that will traverse a maze in order to find the exit. 
The program takes as input a .txt file, which contains the maze in the form of an array of characters, dimensions n × m, where n, m are integers. 
The table can only contain the characters 0, 1 and E, where E will be found only at one point of the table and will indicate the entrance to the maze. 
When someone enters the maze, they can move horizontally or vertically (but not diagonally) in any direction containing 0 (see example below). 
If you reach the border of the table, and find 0, then you have reached an exit of the maze. There may be multiple exits to the maze (or none at all).
<br>
**Example:** The input will be a file in the form of the example below.

```
9 7
0 3
1 1 1 E 1 1 1
1 1 1 0 1 1 1
1 0 0 0 1 0 1
1 0 1 0 1 0 0
1 1 1 0 1 1 1
1 0 0 0 0 0 1
1 0 1 1 1 0 1
1 0 1 1 0 0 1
0 1 1 1 0 1 1
```

### Implementation
The assignment consists of the following code files located under the src folder.

- **Node**: Implements a generic type node, used for the ADTs.
- **StringQueue**: Interface that declares the basic methods of a queue.
- **StringQueueImpl**: An implementation of the ADT FIFO queue.
- **StringQueueWithOnePointer**: An implementation of the ADT queue, using one pointer (as a circular queue).
- **StringStack**: Interface that declares the basic methods of a stack.
- **StringStackImpl**:  An implementation of the ADT stack.
- **Thiseas**: A client program that will traverse a maze in order to find the exit.
