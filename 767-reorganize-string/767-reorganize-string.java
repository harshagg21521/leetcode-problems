class Solution {
    public class Pair implements Comparable{
        char ch;
        int freq;
        Pair(char ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }
        public int compareTo(Object o){
            Pair other=(Pair)o;
            return this.freq-other.freq;
        }
    }
        
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            pq.add(new Pair(ch,map.get(ch)));
        }
        String ans="";
        Pair store=pq.remove();
        ans+=store.ch;
        store.freq=store.freq-1;
        while(pq.size()>0){
            Pair temp=pq.remove();
            ans+=temp.ch;
            temp.freq=temp.freq-1;
            if(store.freq!=0){
                pq.add(store);
            }
            store=temp;
        }
        if(ans.length()!=s.length()){
            return "";
        }
        return ans;
    }
}