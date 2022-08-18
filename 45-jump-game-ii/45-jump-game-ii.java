class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        dp[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int j=i+1;j<=i+nums[i];j++){
                if(j<dp.length){
                    min=Math.min(min,dp[j]);
                }
            }
            if(min==Integer.MAX_VALUE){
                dp[i]=min;
            }else{
                dp[i]=min+1;
            }
            
        }
        return dp[0];
    }
}