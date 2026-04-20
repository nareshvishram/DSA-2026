class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return nums[0];
        int sum = nums[0], tmp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(nums[i], tmp + nums[i]);
            sum = Math.max(sum, tmp);
            if (tmp < 0)
                tmp = 0;
        }
        return sum;
    }
}