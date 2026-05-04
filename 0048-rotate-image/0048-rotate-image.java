class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        // transpose
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        int i=0,j=n-1;
        while(i<j){
            for(int k=0;k<m;k++){
                int tmp=matrix[k][i];
                matrix[k][i]=matrix[k][j];
                matrix[k][j]=tmp;
            }
            i++;
            j--;
        }
    }
}