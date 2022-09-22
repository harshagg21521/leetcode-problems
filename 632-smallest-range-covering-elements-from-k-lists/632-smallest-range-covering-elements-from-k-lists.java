class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.size();i++){
            pq.add(new Pair(nums.get(i).get(0),i,0));
            max=Math.max(max,nums.get(i).get(0));
        }
        int rsize=Integer.MAX_VALUE;;
        int rbeg=0;
        int rend=0;
        while(pq.size()==nums.size()){
            Pair rv=pq.remove();
            int size=max-rv.data;
            if(size<rsize){
                rsize=size;
                rbeg=rv.data;
                rend=max;
            }
            if(rv.di<nums.get(rv.li).size()-1){
                rv.di++;
                rv.data=nums.get(rv.li).get(rv.di);
                pq.add(rv);
                max=Math.max(max,rv.data);
            }
        }
        return new int[] {rbeg,rend};
    }
    class Pair implements Comparable<Pair> {
        int data;
        int li;
        int di;
        Pair(int data,int li,int di){
            this.data=data;
            this.li=li;
            this.di=di;
        }
        public int compareTo(Pair o){
            return this.data-o.data;
        }
    }
}