class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0;
        int j=matrix[0].length-1;
        while(i<matrix.length&&i>=0&&j<matrix[0].length&&j>=0){
            int v=matrix[i][j];
            if(v<target){
                i++;
            }
            else if(v>target){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}