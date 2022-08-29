class Solution {
    public int[] sortedSquares(int[] nums) {
        int i=0;
        int j=nums.length-1;
        int k=j;
        int[] ans=new int[nums.length];
        while(i<=j){
            int ith=nums[i]*nums[i];
            int jth=nums[j]*nums[j];
            if(ith>jth){
                ans[k]=ith;
                k--;
                i++;
            }
            else{
               ans[k]=jth;
                k--;
                j--;
            }
        }
        return ans;
    }
}