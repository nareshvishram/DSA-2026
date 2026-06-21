class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int arr[], int start, List<Integer> tmp) {
        if (start > arr.length)
            return;
        ans.add(new ArrayList<>(tmp));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1])
                continue;
            tmp.add(arr[i]);
            helper(arr, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}