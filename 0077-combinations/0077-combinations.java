class Solution {
    int[] arr;
    List<List<Integer>> ans;

    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        bt(n, k, 0, new ArrayList<>());
        return ans;
    }

    private void bt(int n, int k, int start, List<Integer> tmp) {
        if (tmp.size() == k){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < n; i++) {
            tmp.add(arr[i]);
            bt(n, k, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}