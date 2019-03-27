Problem
==
Given a 2d gridAccording to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

    Input: 
    [
     [0,1,0],
     [0,0,1],
     [1,1,1],
     [0,0,0]
    ]
    Output: 
    [
     [0,0,0],
     [1,0,1],
     [0,1,1],
     [0,1,0]
    ]


Solution
==
It's easy to make a new matrix to save the original one or create new one, but what if we want to do the algorithm in-place? We can create 4 conditions like followings.

Condition0: dead to dead;.
Condition1: live to live;.
Condition2: live to dead;.
Condition3: dead to live;.

We can see that those 4 conditions % 2 can get what we want.

Condition0: 0(dead) % 2 = 0(dead).
Condition1: 1(live) % 2 = 1(live).
Condition2: 2(live) % 2 = 0(dead).
Condition3: 3(dead) % 2 = 1(live).

All we need to do is when we count the matrix, we count condition1 and condition2 into live cells. 
