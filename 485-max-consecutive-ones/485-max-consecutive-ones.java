class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==1){
                ans=Math.max(ans,j-i+1);
                j++;
            }
            else{
                j++;
                i=j;
            }
        }
        return ans;
    }
}