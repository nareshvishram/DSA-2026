class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        helper(nums, new ArrayList<>());
        return res;
    }

    private void helper(int nums[], List<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp.contains(nums[i]))
                continue;
            tmp.add(nums[i]);
            helper(nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}