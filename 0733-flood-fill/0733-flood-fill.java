class Solution {
    boolean vis[][];

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        vis = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int color, int srcColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != srcColor || vis[i][j] == true)
            return;
        image[i][j] = color;
        vis[i][j] = true;
        dfs(image, i + 1, j, color, srcColor);
        dfs(image, i - 1, j, color, srcColor);
        dfs(image, i, j + 1, color, srcColor);
        dfs(image, i, j - 1, color, srcColor);
    }
}