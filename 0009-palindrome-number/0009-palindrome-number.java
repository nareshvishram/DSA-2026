class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        return (x ^ reverse(x)) == 0;
    }

    public int reverse(int x) {
        int y = 0;
        while (x != 0) {
            int num = x % 10;
            y = y * 10 + num;
            x = x / 10;
        }
        return y;
    }
}