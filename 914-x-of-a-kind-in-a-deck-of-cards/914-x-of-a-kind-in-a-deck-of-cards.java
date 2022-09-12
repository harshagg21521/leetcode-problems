class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int t:deck){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        int gcd=0;
        int count=0;
        for(int key:map.keySet()){
            if(count==0){
                gcd=map.get(key);
            }
            else{
                gcd=getgcd(gcd,map.get(key));
                if(gcd<2){
                    return false;
                }
            }
            count++;
        }
        return gcd>=2;
    }
    public int getgcd(int n1,int n2){
        while(n1>0){
            int rem=n2%n1;
            n2=n1;
            n1=rem;
        }
        return n2;
    }
}