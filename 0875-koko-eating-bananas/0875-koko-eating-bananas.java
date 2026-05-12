class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (canEat(mid, piles, h)) {
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return l;
    }

    private boolean canEat(int k, int[] piles, int h) {
        long hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (int) Math.ceil(piles[i] / (k * 1.0));
        }
        return hours <= h ? true : false;
    }
}