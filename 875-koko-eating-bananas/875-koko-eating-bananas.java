class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int i:piles){
            hi=Math.max(hi,i);
        }
        while(lo<hi){
            int limit=(lo+hi)/2;
            int totaltime=0;
            for(int p:piles){
                int time=(p+limit-1)/limit;
                totaltime+=time;
            }
            if(totaltime<=h){
                hi=limit;
            }
            else{
                lo=limit+1;
            }
        }
        return lo;
    }
}