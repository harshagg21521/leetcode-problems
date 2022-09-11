class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int i=0;
        int j=0;
        int end=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            end=Math.max(end,map.get(ch));
            if(end==j){
                list.add(end-i+1);
                end=i=j+1;
            }
            j++;
        }
        return list;
    }
}