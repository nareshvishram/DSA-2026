class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length<=1)
            return false;
        Map<Integer,Integer> mod=new HashMap<>();
       
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            sum%=k;
            
            if(sum==0 && i>0)
                return true;
            if(mod.containsKey(sum) && i-mod.get(sum)>1){
                
                return true;
            }
            if(!mod.containsKey(sum)){
                mod.put(sum,i);
            }
        }
        return false;
    }
}