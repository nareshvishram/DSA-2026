class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new Node(e.getKey(), e.getValue()));
            if (pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[k];
        int l = 0;
        while (!pq.isEmpty())
            ans[l++] = pq.poll().val;
        return ans;
    }
}

class Node {
    int val;
    int freq;

    Node(int val, int freq) {
        this.val = val;
        this.freq = freq;
    }

    public String toString() {
        return "{" + val + "," + freq + "}";
    }
}