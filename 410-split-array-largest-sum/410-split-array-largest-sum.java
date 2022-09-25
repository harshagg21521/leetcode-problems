class Solution {
    public int splitArray(int[] nums, int m) {
        int hi=0;
        int lo=Integer.MIN_VALUE;
        for(int i:nums){
            hi+=i;
            lo=Math.max(i,lo);
        }
        while(lo<hi){
            int limit=(lo+hi)/2;
            int currparts=1;
            int currpartsum=0;
            for(int num:nums){
                if(currpartsum+num<=limit){
                    currpartsum+=num;
                }
                else{
                    currpartsum=num;
                    currparts++;
                }
            }
            if(currparts>m){
                lo=limit+1;
            }
            else{
                hi=limit;
            }
        }
        return lo;
    }
}