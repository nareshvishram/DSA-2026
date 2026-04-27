class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for (int[] x : points) {
            pq.add(new Node(x[0], x[1], (x[0] * x[0]) + (x[1] * x[1])));
            if (pq.size() > k)
                pq.poll();
        }
        int ans[][] = new int[pq.size()][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            ans[idx][0] = pq.peek().x;
            ans[idx][1] = pq.peek().y;
            pq.poll();
            idx++;
        }
        return ans;

    }
}

class Node {
    int x;
    int y;
    int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}