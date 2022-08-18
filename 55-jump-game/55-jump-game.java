class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp=new boolean[nums.length];
        dp[nums.length-1]=true;
        for(int i=nums.length-2;i>=0;i--){
             dp[i]=false;
            for(int j=i;j<=i+nums[i];j++){
                if(j<dp.length){
                    if(dp[j]){
                        dp[i]=dp[j];
                        break;
                    }
                }
            }
        }
            
        return dp[0];
    }
}