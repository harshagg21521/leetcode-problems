class Solution {
    public int maxDistToClosest(int[] seats) {
        int j=-1;
        int res=0;
        for(int i=0;i<seats.length;i++){
            if(seats[i]==1){
                int ans=0;
                if(j<0){
                    ans=i;
                }
                else{
                    ans=(i-j)/2;
                }
                res=Math.max(ans,res);
                j=i;
            }
        }
        res=Math.max(seats.length-1-j,res);
        return res;
     
    }
}