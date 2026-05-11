class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;
        while (l <= r) {
            int px = (l + r) / 2;
            int py = (m + n + 1) / 2 - px;
            int maxLeftX = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int maxLeftY = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int minRightX = px == m ? Integer.MAX_VALUE : nums1[px];
            int minRightY = py == n ? Integer.MAX_VALUE : nums2[py];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            }
            if (maxLeftX > minRightY)
                r = px - 1;
            else
                l = px + 1;
        }
        return -1.0;
    }
}