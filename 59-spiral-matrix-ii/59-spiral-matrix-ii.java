class Solution {
    public int[][] generateMatrix(int n) {
          int[][] matrix=new int[n][n];
        int minr=0;
        int minc=0;
        int maxr=n-1;
        int maxc=n-1;
        int k=1;       
        while(k<=n*n){
            //right
            for(int i=minc;i<=maxc&&k<=n*n;i++){
                matrix[minr][i]=k;
                k++;
            }
            minr++;
            //down
            for(int i=minr;i<=maxr&&k<=n*n;i++){
                matrix[i][maxc]=k;
                k++;
            }
            maxc--;            
            //left
            for(int i=maxc;i>=minc&&k<=n*n;i--){
                matrix[maxr][i]=k;
                k++;
            }
            maxr--;            
            //up
            for(int i=maxr;i>=minr&&k<n*n;i--){
                matrix[i][minc]=k;
                k++;
            }
            minc++;            
        }
        return matrix;
    }
}