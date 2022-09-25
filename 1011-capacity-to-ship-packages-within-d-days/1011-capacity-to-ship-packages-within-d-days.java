class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo=Integer.MIN_VALUE;
        int hi=0;
        for(int w:weights){
            hi+=w;
            lo=Math.max(lo,w);
        }
        int ans=0;
        while(lo<hi){
            int limit=(lo+hi)/2;
            int currsum=0;
            int currparts=1;
            for(int w:weights){
                if(currsum+w<=limit){
                    currsum+=w;
                }
                else{
                    currsum=w;
                    currparts++;
                }
            }
            if(currparts<=days){
                hi=limit;
            }
            else {
                lo=limit+1;
            }
        }
        return lo;
        
    }
}