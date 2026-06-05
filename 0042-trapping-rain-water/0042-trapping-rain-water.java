class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1,leftMax=Integer.MIN_VALUE,rightMax=Integer.MIN_VALUE,ans=0;
        while(l<=r){
            int left=height[l],right=height[r];
            if(left<=right){
                if(leftMax>left)
                    ans+=leftMax-left;
                else
                    leftMax=left;
                l++;
            }else{
                if(rightMax>right)
                    ans+=rightMax-right;
                else
                    rightMax=right;
                r--;
            }
        }
        return ans;
    }
}