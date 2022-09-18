class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        ArrayList<int[]> list=new ArrayList<>();
        for(int[] interval:intervals){
            if(list.size()==0){
                list.add(interval);
            }
            else{
                int[] top=list.get(list.size()-1);
                if(interval[0]>top[1]){
                    list.add(interval);
                }
                else{
                    top[1]=Math.max(top[1],interval[1]);
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}