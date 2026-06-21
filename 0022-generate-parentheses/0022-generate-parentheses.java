class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        fun(n,0,0,"");
        return ans;
    }
    private void fun(int n,int open,int close,String tmp){
        if(open==n && close==n)
            ans.add(tmp);
        if(open<n)
            fun(n,open+1,close,tmp+"(");
        if(close<open)
            fun(n,open,close+1,tmp+")");
            
    }
}