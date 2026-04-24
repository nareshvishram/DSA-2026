class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean noReapt = true;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

        }
        int ans = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            ans += e.getValue() - (e.getValue() % 2);
        }
        // System.out.println(map);
        return s.length() > ans ? ans + 1 : ans;

    }
}