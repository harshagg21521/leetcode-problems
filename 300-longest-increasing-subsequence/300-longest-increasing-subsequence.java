class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        int omax=0;
        for(int i=0;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            if(omax<dp[i]){
                omax=dp[i];
            }
        }
        return omax;
    }
}