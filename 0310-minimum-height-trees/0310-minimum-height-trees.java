class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        int[] indeg = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            indeg[e[0]]++;
            indeg[e[1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 1)
                q.add(i);
        }
        int remaining = n;
        while (remaining > 2) {
            int size = q.size();
            while (size-- > 0) {
                int parent = q.poll();
                remaining--;
                for (int child : map.get(parent)) {
                    indeg[child]--;
                    if (indeg[child] == 1)
                        q.add(child);

                }
            }
        }
        //List<Integer> ans = new ArrayList<>();
        return new ArrayList<>(q);

    }
}