class Solution {
    Set<Integer> visited;
    Map<Integer, List<Integer>> graph;
    int e, n;

    public int countCompleteComponents(int V, int[][] edges) {
        // a component has n nodes, e edges then its complete component if and only if
        // e=n*(n-1)/2
        graph = new HashMap<>();
        visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < V; i++)
            graph.put(i, new ArrayList<>());
        for (int[] x : edges) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        int components = 0;
        for (int v = 0; v < V; v++) {
            if (!visited.contains(v)) {
                n = 0;
                e = 0;
                dfs(v);
                if (n * (n - 1) / 2 == e / 2)
                    ans++;
                components++;
            }
        }
        System.out.println("components:" + components);
        return ans;
    }

    private void dfs(int src) {
        if (visited.contains(src))
            return;
        visited.add(src);
        n++;
        e += graph.get(src).size();
        for (int child : graph.get(src))
            dfs(child);
    }
}