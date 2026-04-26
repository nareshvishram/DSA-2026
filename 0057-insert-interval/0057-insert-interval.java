class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int tmp[][] = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            tmp[i] = intervals[i];
        }
        tmp[tmp.length - 1] = newInterval;
        return merge(tmp);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        int curr[] = intervals[0];
        ans.add(curr);
        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(intervals[i][1], curr[1]);
            } else {
                curr = intervals[i];
                ans.add(curr);
            }
        }
        int arr[][] = new int[ans.size()][2];
        for (int i = 0; i < arr.length; i++)
            arr[i] = ans.get(i);
        return arr;
    }
}