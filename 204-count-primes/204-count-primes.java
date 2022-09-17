class Solution {
    public int countPrimes(int n) {
        if(n<2){
            return 0;
        }
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        int count=0;
        for(int tbl=2;tbl*tbl<=n;tbl++){
            if(arr[tbl]==false){
                continue;
            }
            for(int ja=tbl;tbl*ja<=n;ja++){
                arr[tbl*ja]=false;
            }
        }
        for(int i=2;i<n;i++){
            if(arr[i]){
                count++;
            }
        }
        
        return count;
    }
}