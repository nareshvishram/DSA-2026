class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        bt(nums, new ArrayList<>(), vis);
        return res;
    }

    private void bt(int[] nums, List<Integer> tmp, boolean[] vis) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && vis[i - 1] == false))
                continue;
            tmp.add(nums[i]);
            vis[i] = true;
            bt(nums, tmp, vis);
            vis[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}