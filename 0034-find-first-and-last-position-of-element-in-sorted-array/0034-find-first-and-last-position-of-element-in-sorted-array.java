class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bs1(nums, target, 0, nums.length - 1);
        int last = bs2(nums, target, 0, nums.length - 1);
        return new int[] { first, last };
    }

    private int bs1(int[] nums, int target, int l, int r) {
        int idx = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] >= target)
                r = mid - 1;
            else {
                l = mid + 1;
            }
            if (nums[mid] == target)
                idx = mid;

        }
        return idx;
    }

    private int bs2(int[] nums, int target, int l, int r) {
        int idx = -1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] <= target)
                l = mid + 1;
            else {
                r = mid - 1;
            }
            if (nums[mid] == target)
                idx = mid;
        }
        return idx;
    }
}