class Solution {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0) {
            return amount == 0 ? 1 : 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i ++) {
            for(int j = 0; j < amount + 1; j ++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
