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
        class Solution {
        public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(res, "", 0, 0, n);
        return res;
    }
    public void generate(ArrayList<String> res, String tmp, int l_p_num, int r_p_num, int n) {
        if(l_p_num == n) {
            for(int i = 0; i < n - r_p_num; i ++) {
                tmp += ")";
            }
            res.add(tmp);
            return;
        }
        generate(res, tmp + "(", l_p_num + 1, r_p_num, n);
        if(l_p_num > r_p_num) {
            generate(res, tmp + ")", l_p_num, r_p_num + 1, n);
        }
    }
}
