class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[nums.length];
        int pref[] = new int[nums.length];
        int suff[] = new int[nums.length];
        for (int i = 0; i < n; i++) {
            pref[i] = 1;
            if (i > 0)
                pref[i] = pref[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            suff[i] = 1;
            if (i < n - 1)
                suff[i] = suff[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++)
            ans[i] = suff[i] * pref[i];
        return ans;
    }
}