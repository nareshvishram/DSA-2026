class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++)
            dp.add(new ArrayList<>(Collections.nCopies(triangle.get(i).size(), null)));
        dp.get(0).set(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            int size = triangle.get(i).size();
            int sizePrev = triangle.get(i - 1).size();
            dp.get(i).set(0, triangle.get(i).get(0) + dp.get(i - 1).get(0));
            dp.get(i).set(size - 1,
                    triangle.get(i).get(size - 1) + dp.get(i - 1).get(sizePrev - 1));
        }
        // for (List<Integer> l : dp)
        //     System.out.println(l);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1)
                    continue;
                int a = dp.get(i - 1).get(j - 1);
                int b = dp.get(i - 1).get(j);
                dp.get(i).set(j, Math.min(a, b) + triangle.get(i).get(j));
            }
        }
        // System.out.println("-------");
        // for (List<Integer> l : dp)
        //     System.out.println(l);
        int ans = Integer.MAX_VALUE;
        int n = triangle.get(triangle.size() - 1).size();
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, dp.get(triangle.size() - 1).get(i));
        return ans;
    }
}