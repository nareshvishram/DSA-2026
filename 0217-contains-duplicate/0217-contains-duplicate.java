class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x))
                return true;
            map.put(x, 1);
        }
        return false;
    }
}