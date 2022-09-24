class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo=1;
        int hi=Integer.MIN_VALUE;
        for(int i:nums){
            if(i>hi){
                hi=i;
            }
        }
        while(lo<hi){
            int mid=(lo+hi)/2;
            int sum=0;
            for(int i:nums){
                int qou=(i+mid-1)/mid;
                sum+=qou;

            }
            if(sum>threshold){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
            
        }
        return lo;
    }
}