class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, pivot = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= nums[0])
                l = mid + 1;
            else
                r = mid - 1;
        }
        if (l == nums.length)
            return nums[0];
        if (r == -1)
            return nums[nums.length - 1];
        return nums[l];
    }
}