class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return topDown(cost, cost.length);
    }

    private int topDown(int cost[], int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[n];
    }

    private int rec(int[] cost, int n) {
        if (n == 0 || n == 1)
            return 0;
        return Math.min(rec(cost, n - 2) + cost[n - 2], rec(cost, n - 1) + cost[n - 1]);

    }
}