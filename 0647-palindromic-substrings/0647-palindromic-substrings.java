class Solution {
     public int countSubstrings(String s) {
        int n = s.length(), ans = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                   ans++;
                }
            }
        }
        return ans;
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            r--;
            l++;
        }
        return true;
    }
}