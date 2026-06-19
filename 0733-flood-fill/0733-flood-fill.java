class Solution {
    int m, n, fillColor, orgColor;
    int[][] direx = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        fillColor = color;
        orgColor = image[sr][sc];
        dfs(image, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int i, int j) {
        image[i][j] = fillColor;
        for (int k = 0; k < 4; k++) {
            if (isValid(direx[k][0] + i, direx[k][1] + j, image))
                dfs(image, direx[k][0] + i, direx[k][1] + j);
        }
    }

    private boolean isValid(int i, int j, int[][] image) {
        if (i >= 0 && j >= 0 && i < m && j < n && image[i][j] == orgColor && image[i][j] != fillColor)
            return true;
        return false;
    }
}