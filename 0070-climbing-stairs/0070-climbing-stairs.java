class Solution {
    int map[];
    public int climbStairs(int n) {
        if(n==1||n==2||n==3)
            return n;
        map=new int[n+1];
        Arrays.fill(map,-1);
        return dp(n);
        //return climbStairs(n-1)+climbStairs(n-2);
    }

    private int dp(int n){
        if(n==1||n==2||n==3)
            return n;
        if(map[n]!=-1)
            return map[n];
        map[n]=dp(n-1)+dp(n-2);
        return map[n];
        
    }

    public int climbStairsRec(int n) {
        if(n==1||n==2||n==3)
            return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }

}