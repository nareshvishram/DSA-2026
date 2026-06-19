class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        int[][] direx = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dist[i][j] = 0;
                    dist[i][j] = -1;
                } else
                    q.add(new Pair(i, j));
            }
        }
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = direx[i][0] + p.x;
                int y = direx[i][1] + p.y;
                if (x >= 0 && y >= 0 && x < m && y < n && dist[x][y] == -1) {
                    dist[x][y] = dist[p.x][p.y] + 1;
                    q.add(new Pair(x, y));
                }
            }
        }
        return dist;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}