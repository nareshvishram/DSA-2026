class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        bt(nums, nums.length, 0, new ArrayList<>());
        return res;
    }

    private void bt(int[] nums, int n, int start, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int i = start; i < n; i++) {
            tmp.add(nums[i]);
            bt(nums, n, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}