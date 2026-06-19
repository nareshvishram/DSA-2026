class Solution {
    public boolean canFinish(int courses, int[][] pre) {
        int[] indeg = new int[courses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < courses; i++)
            graph.put(i, new ArrayList<>());
        for (int[] x : pre) {
            indeg[x[1]]++;
            graph.get(x[0]).add(x[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < courses; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        if (q.size() == 0)
            return false;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child : graph.get(curr)) {
                indeg[child]--;
                if (indeg[child] == 0) {
                    q.add(child);
                }
            }
        }
        for (int x : indeg)
            if (x != 0)
                return false;
        if (!q.isEmpty())
            return false;
        return true;
    }
}