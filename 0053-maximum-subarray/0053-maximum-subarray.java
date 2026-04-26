class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 0)
            return 0;
        int tmp = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            sum = Math.max(sum, tmp);
            if (tmp < 0)
                tmp = 0;
        }
        return sum;
    }
}