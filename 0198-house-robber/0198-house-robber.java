class Solution {
    public int rob(int[] nums) {
        return helperDp(nums, nums.length);
    }

    private int helperRecursion(int[] nums, int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return nums[n - 1];
        return Math.max(helperRecursion(nums, n - 2) + nums[n - 1], helperRecursion(nums, n - 1));
    }

    private int helperDp(int[] nums, int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}