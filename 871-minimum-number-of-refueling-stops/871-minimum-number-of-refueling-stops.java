class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        int range=startFuel;
        int pump=0;
        while(range<target){
            while(i<stations.length){
                if(range>=stations[i][0]){
                    pq.add(stations[i][1]);
                }
                else{
                    break;
                }
                i++;
            }
            if(pq.size()==0){
                return -1;
            }
            range+=pq.remove();
            pump++;
        }
        return pump;
        
    }
}