class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int maxp=Integer.MIN_VALUE;
        int currsum=0;
        for(int i=0;i<nums.length;i++){
            currsum+=nums[i];
             maxp=Math.max(maxp,currsum);
            if(currsum<0){
                currsum=0;
            }
           
        }
        return maxp;
        
    }
}