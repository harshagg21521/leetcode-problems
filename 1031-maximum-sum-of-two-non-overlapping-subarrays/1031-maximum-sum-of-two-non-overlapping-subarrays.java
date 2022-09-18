class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int max=getmax(nums,firstLen,secondLen);
        int max1=getmax(nums,secondLen,firstLen);
        return Math.max(max,max1);
    }
    public int getmax(int[] nums,int f1,int s1){
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i==f1-1){
                left[i]=sum;
            }
            else if(i>=f1){
                sum-=nums[i-f1];
                left[i]=Math.max(left[i-1],sum);
            }
        }
        sum=0;
        for(int i=nums.length-1;i>=0;i--){
            sum+=nums[i];
            if(i==nums.length-s1){
                right[i]=sum;
            }
            else if(i<nums.length-s1){
                sum-=nums[i+s1];
                right[i]=Math.max(right[i+1],sum);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=f1-1;i<nums.length-s1;i++){
            max=Math.max(left[i]+right[i+1],max);
        }
        return max;
    }
}