class Solution {
    Map<String, Set<String>> graph;
    Map<String, String> emailToName;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        graph = new HashMap<>();
        emailToName = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            String name = accounts.get(i).get(0);
            if (accounts.get(i).size() == 2) {
                emailToName.put(accounts.get(i).get(1), name);
                graph.put(accounts.get(i).get(1), new TreeSet<>());
            } else {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    emailToName.put(accounts.get(i).get(j), name);
                    if (j == 1)
                        continue;
                    String u = accounts.get(i).get(j - 1);
                    String v = accounts.get(i).get(j);

                    if (!graph.containsKey(u))
                        graph.put(u, new TreeSet<>());
                    if (!graph.containsKey(v))
                        graph.put(v, new TreeSet<>());
                    graph.get(u).add(v);
                    graph.get(v).add(u);
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        for (String email : emailToName.keySet()) {
            if (!vis.contains(email)) {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(emailToName.get(email));
                Set<String> tmpSet = new TreeSet<>();
                dfs(email, tmpSet, vis);
                tmpList.addAll(1, new ArrayList<>(tmpSet));
                ans.add(tmpList);
            }
        }
        return ans;
    }

    private void dfs(String email, Set<String> tmp, Set<String> vis) {
        if (vis.contains(email))
            return;
        vis.add(email);
        tmp.add(email);
        for (String child : graph.get(email)) {
            dfs(child, tmp, vis);
        }
    }
}