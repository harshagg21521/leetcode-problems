class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] mina=new int[arr.length];
        int min=Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            min=Math.min(min,arr[i]);
            mina[i]=min;
        }
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++){
            max=Math.max(max,arr[i]);
            if(max<=mina[i+1]){
                count++;
            }
        }
        return count+1;            
    }
}