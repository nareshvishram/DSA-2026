class Solution {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        bt(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void bt(int[] arr, int target, int start, List<Integer> tmp) {
        if (target < 0)
            return;
        if (target == 0)
            ans.add(new ArrayList<>(tmp));
        for (int i = start; i < arr.length; i++) {
            tmp.add(arr[i]);
            bt(arr, target - arr[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}