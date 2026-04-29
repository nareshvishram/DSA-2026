class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0;
        while (m <= r) {
            if (nums[m] == 0) {
                int tmp = nums[l];
                nums[l] = nums[m];
                nums[m] = tmp;
                m++;
                l++;
            } else if (nums[m] == 2) {
                int tmp = nums[r];
                nums[r] = nums[m];
                nums[m] = tmp;
                r--;
            } else
                m++;
        }
    }
}