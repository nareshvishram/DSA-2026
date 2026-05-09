class Solution {
    public int search(int[] nums, int target) {
        // 1. find pivot
        // 2. search
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[0] <= nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        int pivot = l;
        if (pivot >= n)
            return bs(nums, target, 0, n - 1);
        System.out.println(pivot + " " + r);
        if (target >= nums[0] && target <= nums[pivot - 1])
            return bs(nums, target, 0, pivot - 1);
        else if (target >= nums[pivot] && target <= nums[n - 1])
            return bs(nums, target, pivot, n - 1);
        return -1;
    }

    private int bs(int nums[], int target, int l, int r) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}