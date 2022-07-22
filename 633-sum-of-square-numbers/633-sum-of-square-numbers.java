class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==1){
            return true;
        }
        long i=0;
        long j=(long)Math.sqrt(c);
        while(i<=j){
            if(((i*i)+(j*j))<c){
                i++;
            }
            else if(((i*i)+(j*j))>c){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}