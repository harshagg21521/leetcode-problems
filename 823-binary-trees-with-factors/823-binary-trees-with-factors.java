class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long count=0;
        long in=1;
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],in);
        }
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]%arr[j]==0){
                    if(map.containsKey(arr[i]/arr[j])){
                        long f=map.get(arr[j]);
                        long f2=map.get(arr[i]/arr[j]);
                        map.put(arr[i],map.get(arr[i])+f*f2);
                    }
                    
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            count+=map.get(arr[i]);
        }
        return (int)(count%(1000000007));
    }
}