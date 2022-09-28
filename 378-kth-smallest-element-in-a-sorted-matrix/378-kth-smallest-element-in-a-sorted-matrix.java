class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int lo=matrix[0][0];
        int hi=matrix[m][n];
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            
            int count=0;
            int j=n;
            for(int i=0;i<=m;i++){
                while(j>=0&&matrix[i][j]>mid){
                    j--;
                }
                count+=(j+1);
            }
            if(count<k){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
                
        }
        return lo;
    }
}