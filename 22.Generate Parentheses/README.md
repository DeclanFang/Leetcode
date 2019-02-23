Problem
==
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:

    [
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
    ]

Solution
==
Utilize recursion tree, when the number of left parentheses is larger than the number of right parentheses, we can add either left parenthese or right parenthese, otherwise we can only add left parenthese. Besides, when the number of left parentheses has reached n, add all the right parentheses we need. 
