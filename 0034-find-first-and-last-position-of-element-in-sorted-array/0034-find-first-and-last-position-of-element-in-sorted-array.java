class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = -1, n = nums.length;
        boolean flag = false;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                flag = true;
                break;
            }
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        int[] ans = new int[] { -1, -1 };
        if (!flag)
            return ans;
        // left
        // right
        ans[0] = mid;
        ans[1] = mid;
        if (mid == 0) {
            while (mid < n && nums[mid] == target)
                mid++;
            ans[1] = mid - 1;
            return ans;
        }
        if (mid == n - 1) {
            while (mid >= 0 && nums[mid] == target)
                mid--;
            ans[0] = mid + 1;
            return ans;
        }
        int tmp = mid;
        if (nums[tmp - 1] == target) {
            // mid to 0
            while (tmp >= 0 && nums[tmp] == target)
                tmp--;
            ans[0] = tmp + 1;
        }
        tmp = mid;
        if (nums[tmp + 1] == target) {
            // mid to n-1;
            while (tmp < n && nums[tmp] == target)
                tmp++;
            ans[1] = tmp - 1;
        }
        return ans;

    }
}