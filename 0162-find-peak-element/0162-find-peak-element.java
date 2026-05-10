class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1)
            return 0;
        if (nums.length == 2) {
            if (nums[0] > nums[1])
                return 0;
            if (nums[1] > nums[0])
                return 1;
        }
        int l = 0, r = nums.length - 1, mid = -1;
        while (l < r) {
            mid = (r - l) / 2 + l;
            if (mid == 0 && nums[mid] > nums[mid + 1])
                return mid;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1])
                return mid;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return mid + 1;
    }
}