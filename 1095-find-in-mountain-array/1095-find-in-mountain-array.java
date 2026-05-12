/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mount) {
        int l = 0, r = mount.length() - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (mount.get(mid) < mount.get(mid + 1))
                l = mid + 1;
            else
                r = mid;
        }
        int peak = l;
        if (mount.get(peak) == target)
            return peak;
        int left = bsAsc(0, peak, target, mount);
        int right = bsDesc(peak + 1, mount.length() - 1, target, mount);

        return left != -1 ? left : right;
    }

    private int bsAsc(int l, int r, int target, MountainArray mount) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int val = mount.get(mid);
            if (val == target)
                return mid;
            if (val > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    private int bsDesc(int l, int r, int target, MountainArray mount) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int val = mount.get(mid);
            if (val == target)
                return mid;
            if (val > target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}