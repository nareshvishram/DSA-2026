class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0)
            return true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        for (char c : s.toCharArray()) {
            if ((c - 'a' >= 0 && c - 'a' < 26) || (c - '0' >= 0 && c - '0' <= 9)) {
                sb.append(c);
            }
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}