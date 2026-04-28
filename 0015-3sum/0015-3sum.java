class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int req = -1 * nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == req) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < nums.length - 1 && nums[l] == nums[l + 1])
                        l++;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > req)
                    r--;
                else
                    l++;
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return ans;
    }
}