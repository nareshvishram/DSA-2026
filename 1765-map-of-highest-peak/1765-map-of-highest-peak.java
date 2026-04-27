class Solution {
    int[][] mat;
    int[][] dist;
    int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] highestPeak(int[][] isWater) {
        this.mat = isWater;
        dist = new int[isWater.length][isWater[0].length];
        multiSourceBfs();
        return dist;
    }

    private void multiSourceBfs() {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    dist[i][j] = -1;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if (nx >= 0 && ny >= 0 && nx < mat.length && ny < mat[0].length && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}