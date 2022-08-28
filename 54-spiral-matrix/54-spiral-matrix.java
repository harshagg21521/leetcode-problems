class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int minr=0;
        int minc=0;
        int maxr=matrix.length-1;
        int maxc=matrix[0].length-1;
        int k=0;
        int n=matrix.length;
        int m=matrix[0].length;        
        while(k<n*m){
            //right
            for(int i=minc;i<=maxc&&k<n*m;i++){
                list.add(matrix[minr][i]);
                k++;
            }
            minr++;
            //down
            for(int i=minr;i<=maxr&&k<n*m;i++){
                list.add(matrix[i][maxc]);
                k++;
            }
            maxc--;            
            //left
            for(int i=maxc;i>=minc&&k<n*m;i--){
                list.add(matrix[maxr][i]);
                k++;
            }
            maxr--;            
            //up
            for(int i=maxr;i>=minr&&k<n*m;i--){
                list.add(matrix[i][minc]);
                k++;
            }
            minc++;            
        }
        return list;
    }
}