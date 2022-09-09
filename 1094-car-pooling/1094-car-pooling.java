class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ans=new int[1001];
        int data=0;
        for(int i=0;i<trips.length;i++){
            
            ans[trips[i][1]]+=trips[i][0];
            ans[trips[i][2]]-=trips[i][0];
            
        }
        for(int i=0;i<1001;i++){
            data+=ans[i];
            if(data>capacity){
                return false;
            }
        }
        return true;
    }
}