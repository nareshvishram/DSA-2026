class Solution {
    public boolean isBalanced(String num) {
        int odd = 0, even = 0, idx = 0;
        for (char c : num.toCharArray()) {
            if (idx % 2 == 0)
                even += (int)(c-'0');
            else
                odd += (int)(c-'0');
            idx++;
        }
        return even == odd;
    }
}