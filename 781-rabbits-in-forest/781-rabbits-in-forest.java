class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int ans:answers){
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        int ans=0;
        for(int key:map.keySet()){
            if((key+1)>=map.get(key)){
                ans+=key+1;
            }
            else{
                int q=map.get(key)/(key+1);
                int r=map.get(key)%(key+1);
                if(r==0){
                     ans+=((key+1)*q);
                }
                else{
                    ans+=(((key+1)*q)+(key+1));
                        
                }
               
            }
        }
        return ans;
    }
}