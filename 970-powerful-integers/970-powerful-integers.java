class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        if(bound<=1){
            return list;
        }
        else if(x==1&&y==1){
            list.add(2);
            return list;
        }
        else if(x==1){
            for(int py=1;py+1<=bound;py*=y){
                int val=1+py;
                if(!set.contains(val)){
                    set.add(val);
                    list.add(val);
                }
            }
            return list;
        }
        else if(y==1){
            for(int px=1;px+1<=bound;px*=x){
                int val=px+1;
                if(!set.contains(val)){
                    set.add(val);
                    list.add(val);
                }
            }
            return list;
        }
        for(int px=1;px<=bound;px*=x){
            for(int py=1;px+py<=bound;py*=y){
                int val=px+py;
                if(!set.contains(val)){
                    list.add(val);
                    set.add(val);
                }
            }
        }
        return list;
    }
}