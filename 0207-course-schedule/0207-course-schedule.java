class Solution {
    public boolean canFinish(int numCourses, int[][] preq) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int indeg[] = new int[numCourses];
        if (preq.length == 0)
            return true;
        for (int i = 0; i < numCourses; i++)
            graph.put(i, new ArrayList<>());
        for (int x[] : preq) {
            graph.get(x[0]).add(x[1]);
            indeg[x[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        int v = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child : graph.get(curr)) {
                indeg[child]--;
                if (indeg[child] == 0)
                    q.add(child);
                v++;
            }
        }
        System.out.println(v + " " + q.size());
        if (!q.isEmpty())
            return false;
        if (v != numCourses)
            return false;
        return true;

    }
}