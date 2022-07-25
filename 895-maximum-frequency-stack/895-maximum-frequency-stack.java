class FreqStack {
        HashMap<Integer,Integer> map;
        HashMap<Integer,Stack<Integer>> freq;
        int maxfreq=0;

    public FreqStack() {
            map=new HashMap<>();
            freq=new HashMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        if(freq.containsKey(map.get(val))){
            Stack<Integer> st=freq.get(map.get(val));
            st.push(val);
            freq.put(map.get(val),st);
        }
        else{
            Stack<Integer> si=new Stack<>();
            si.push(val);
            freq.put(map.get(val),si);
        }
    }
    
    public int pop() {
        Stack<Integer> sl=freq.get(freq.size());
        int ans=sl.pop();
        freq.put(freq.size(),sl);
        if(freq.get(freq.size()).size()==0){
            freq.remove(freq.size());
        }
        if(map.get(ans)>1){
            map.put(ans,map.get(ans)-1);
        }
        else{
            map.remove(ans);
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */