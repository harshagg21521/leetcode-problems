class RandomizedSet {
    Random r;
    HashMap<Integer,Integer> map;
    List<Integer> list;
    
    public RandomizedSet() {
        r=new Random();
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        list.add(val);
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int vidx=map.get(val);
        int lidx=list.size()-1;
        int last=list.get(lidx);
        list.set(vidx,last);
        list.set(lidx,val);
        map.put(val,lidx);
        map.put(last,vidx);
        list.remove(lidx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int idx=r.nextInt(list.size());
        return list.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */