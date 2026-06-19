class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        if (grid.length == 0)
            return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    q.add(new Node(i, j));
            }
        }
        int direct[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            while (size-- > 0) {
                Node curr = q.poll();
                int x = curr.x;
                int y = curr.y;
                for (int i = 0; i < 4; i++) {
                    if (isValid(direct[i][0] + x, direct[i][1] + y, grid)) {
                        q.add(new Node(direct[i][0] + x, direct[i][1] + y));
                        grid[direct[i][0] + x][direct[i][1] + y] = 2;
                    }
                }
            }
        }
        for (int[] x : grid)
            for (int y : x)
                if (y == 1)
                    return -1;
        return time == -1 ? 0 : time;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1)
            return true;
        return false;
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}