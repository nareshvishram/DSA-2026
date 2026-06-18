class Solution {
    int m, n;
    int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;

    }

    private void dfs(int i, int j, char[][] grid) {
        if (!isValid(i, j, grid))
            return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            if (isValid(i + dir[k][0], j + dir[k][1], grid))
                dfs(i + dir[k][0], j + dir[k][1], grid);
        }
    }

    private boolean isValid(int i, int j, char[][] grid) {
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1')
            return true;
        return false;
    }
}