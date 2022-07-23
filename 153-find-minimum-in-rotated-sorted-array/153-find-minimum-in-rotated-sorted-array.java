class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int mid=(n-1)/2;
        int ans=0;
        if(nums[mid]>nums[0]&&nums[mid]<nums[n-1]){
            ans=nums[0];
        }
        else{
            int st=0;
            int end=n-1;
            while(st<=end){
                mid=(st+end)/2;
                if(nums[mid]<nums[end]){
                    end=mid;
                }
                else{
                    st=mid+1;
                }
            }
            ans=nums[end];
        }
        return ans;
        
    }
}