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
        int l = 0, r = mount.length();
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mount.get(mid) > mount.get(mid - 1))
                l = mid + 1;
            else
                r = mid - 1;
        }
        int left = bs1(target, 0, l - 1, mount);
        if (left != -1)
            return left;
        return bs2(target, l, mount.length(), mount);
    }

    private int bs1(int target, int l, int r, MountainArray mount) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mount.get(mid) == target)
                return mid;
            if (mount.get(mid) > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    private int bs2(int target, int l, int r, MountainArray mount) {
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (mount.get(mid) == target)
                return mid;
            if (mount.get(mid) < target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }
}