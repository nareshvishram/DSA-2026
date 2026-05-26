class Solution {
    int[][] dist;
    int[][] mat;
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {
        this.mat = mat;
        dist = new int[mat.length][mat[0].length];
        bfs();
        return dist;
    }

    private void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    q.add(new int[] { i, j });
                else
                    dist[i][j] = -1;
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int X = dir[i][0] + x;
                int Y = dir[i][1] + y;
                if (X >= 0 && Y >= 0 && X < m && Y < n && dist[X][Y] == -1) {
                    dist[X][Y] = 1 + dist[x][y];
                    q.add(new int[] { X, Y });
                }
            }
        }
    }
}