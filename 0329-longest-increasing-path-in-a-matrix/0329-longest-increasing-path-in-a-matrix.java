
class Solution {
    int dx[]=new int[]{1,-1,0,0};
    int dy[]=new int[]{0,0,1,-1};
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int vis[][]=new int[m][n];
        int ans=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=(dfs(i,j,m,n,vis,matrix));
                ans=Math.max(x,ans);
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int m, int n, int[][] dp,int [][]mat) {
        if(dp[i][j]!=0)
            return dp[i][j];
        int maxForOneElement=1;
        for(int k=0;k<4;k++){
            int x=i+dx[k];
            int y=j+dy[k];
            if(x<0||y<0||x>=m||y>=n||mat[i][j]>=mat[x][y])continue;
            int len=1+dfs(x,y,m,n,dp,mat);
            maxForOneElement=Math.max(maxForOneElement,len);
        }
        dp[i][j]=maxForOneElement;
        return dp[i][j];
    }
}