class Solution {
    public int longestOnes(int[] nums, int k) {
        int count=0;
        int ans=0;
        int i=0;
        int j=0;
        while(i<nums.length&&j<nums.length){
            while(j<nums.length){
                if(nums[j]==0){
                    count++;
                    if(count==k+1){
                        j++;
                        break;
                    }
                }
                ans=Math.max(ans,j-i+1);
                j++;
                
            }
            while(count>k&&i<nums.length){
                if(nums[i]==0){
                    count--;
                }
                i++;
            }
        }
        return ans;
    }
}