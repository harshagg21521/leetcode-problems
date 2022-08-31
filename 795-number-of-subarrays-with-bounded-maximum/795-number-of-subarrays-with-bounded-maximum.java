class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int i=-1;
        int j=-1;
        int k=0;
        int res=0;
        while(k<nums.length){
            if(nums[k]<=right&&nums[k]>=left){
                j=k;
                
            }
            else if(nums[k]>right){
                i=k;
                j=k;
            }
            res+=(j-i);
            k++;
            
        }
        return res;
    }
}