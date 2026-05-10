class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lc = 0, hc = n - 1, lr = 0, hr = m - 1;
        while (lr <= hr) {
            int midr = (hr - lr) / 2 + lr;
            if (matrix[midr][0] <= target && matrix[midr][n - 1] >= target) {
                while (lc <= hc) {
                    int midc = (hc - lc) / 2 + lc;
                    if (matrix[midr][midc] == target)
                        return true;
                    if (matrix[midr][midc] > target)
                        hc = midc - 1;
                    else
                        lc = midc + 1;
                }
            }
            if (matrix[midr][0] > target)
                hr = midr - 1;
            else
                lr = midr + 1;
        }
        return false;
    }
}