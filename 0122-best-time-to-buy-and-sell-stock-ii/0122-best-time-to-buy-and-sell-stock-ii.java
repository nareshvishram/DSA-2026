class Solution {
    public int maxProfit(int[] prices) {
        int ans=0,n=prices.length;
        for(int i=0;i<n;i++){
            while(i<n-1 && prices[i]>prices[i+1])
                i++;
            //buy
            int buy=prices[i];
            while(i<n-1 && prices[i]<prices[i+1])
                i++;
            //sell
            int sell=prices[i];
            ans+=sell-buy;
        }
        return ans;
    }
}