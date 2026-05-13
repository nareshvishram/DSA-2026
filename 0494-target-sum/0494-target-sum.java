class Solution {
    int dp[][];

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int req = (sum + target) / 2;
        if (Math.abs(target) > sum)
            return 0;
        if ((sum + target) % 2 != 0)
            return 0;
        int[][] dp = new int[nums.length + 1][req + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= req; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1])
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];

            }
        }
        return dp[n][req];
    }

    private int getRes(int[] nums, int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        int res = 0;
        if (sum >= nums[n - 1])
            res = getRes(nums, n - 1, sum - nums[n - 1]) + getRes(nums, n - 1, sum);
        else
            res = getRes(nums, n - 1, sum);
        dp[n][sum] = res;
        return dp[n][sum];
    }
}