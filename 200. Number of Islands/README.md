Problem
==
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
Example 1:

    Input:
    11110
    11010
    11000
    00000
    Output: 1

Example 2:

    Input:
    11000
    11000
    00100
    00011
    Output: 3
    

Solution
==
For the grid, we have a same matrix represent the bfs' visited or not(include true or false), with the new matrix, we can mark the element when we first visit through bfs. At the same time, we set a int result to count whenever we visit a new un-visited element. 
