class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), ans = 0;
        String res = s.charAt(0)+"";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    if (ans < (j - i)) {
                        ans = j - i;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
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