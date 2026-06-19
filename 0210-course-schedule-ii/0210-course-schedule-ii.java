class Solution {
    public int[] findOrder(int courses, int[][] pre) {
        int[] indeg = new int[courses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] topo = new int[courses];
        for (int i = 0; i < courses; i++)
            graph.put(i, new ArrayList<>());
        for (int[] x : pre) {
            indeg[x[1]]++;
            graph.get(x[0]).add(x[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        int k = courses;
        for (int i = 0; i < courses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        if (q.size() == 0)
            return new int[0];
        while (!q.isEmpty()) {
            int curr = q.poll();
            topo[--k] = curr;
            for (int child : graph.get(curr)) {
                indeg[child]--;
                if (indeg[child] == 0) {
                    q.add(child);
                }
            }
        }
        //System.out.println("topo::"+topo);
        for (int x : indeg)
            if (x != 0)
                return new int[0];
        return topo;
    }
}