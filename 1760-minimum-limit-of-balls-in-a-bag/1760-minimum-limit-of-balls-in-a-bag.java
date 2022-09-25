class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo=1;
        int hi=-0;
        for(int i:nums){
            hi=Math.max(i,hi);
        }
        while(lo<hi){
            int limit=(lo+hi)/2;
            int ops=0;
            for(int i:nums){
                if(i>limit){
                    int spare=i-limit;
                    int count=(spare+limit-1)/limit;
                    ops+=count;
                }
            }
            if(ops>maxOperations){
                lo=limit+1;
            }
            else{
                hi=limit;
            }
        }
        return lo;
    }
}