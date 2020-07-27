public class isSubsequence {
    public static void main(String[] args) {
        String a = "abc";
        String b = "aebfc";
        System.out.println(isSubsequence(a, b));
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i ++) {
            dp[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i --) {
            char c = t.charAt(i);
            for (int j = 0; j < 26; j ++) {
                if (c - 'a' == j) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        int index = 0;
        for (int i = 0; i < n; i ++) {
            if (dp[index][s.charAt(i) - 'a'] == m) {
                return false;
            }
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }

        return true;
    }
}
