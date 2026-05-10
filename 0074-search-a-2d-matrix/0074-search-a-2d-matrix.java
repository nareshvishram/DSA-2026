class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (r - l / 2) + l;
            if (matrix[mid / n][mid % n] == target)
                return true;
            if (matrix[mid / n][mid % n] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return false;
    }

    // O(logM + logN)
    public boolean searchMatrix1(int[][] matrix, int target) {
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