class Solution {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return Arrays.asList(0);
        for (int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        int[] deg = new int[n];
        for (int[] x : edges) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
            deg[x[0]]++;
            deg[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1)
                q.add(i);
        }

        List<Integer> ans = new ArrayList<>();
        int count = n;
        while (!q.isEmpty() && count > 2) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                deg[curr]--;
                count--;
                for (int child : graph.get(curr)) {
                    deg[child]--;
                    if (deg[child] == 1)
                        q.add(child);
                }
            }
        }
        while (!q.isEmpty())
            ans.add(q.poll());
        return ans;
    }
}