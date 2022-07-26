class RandomizedCollection {
    Random r;
    HashMap<Integer,HashSet<Integer>> map;
    List<Integer> list;

    public RandomizedCollection() {
        r=new Random();
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        list.add(val);
        int i=list.size()-1;
        if(map.containsKey(val)){
            HashSet<Integer> set=map.get(val);
            set.add(i);
            return false;
        }
        else{
            HashSet<Integer> set=new HashSet<>();
            set.add(i);
            map.put(val,set);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int lidx=list.size()-1;
        int last=list.get(lidx);
        int vidx=map.get(val).iterator().next();
        list.set(lidx,val);
        list.set(vidx,last);
        list.remove(lidx);
        map.get(val).remove(vidx);
        if(map.get(val).size()==0){
            map.remove(val);
        }
        if(map.containsKey(last)){
        map.get(last).remove(lidx);
        map.get(last).add(vidx);
        }
        
        return true;
    }
    
    public int getRandom() {
        int idx=r.nextInt(list.size());
        return list.get(idx);
    }
  
 
   
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */