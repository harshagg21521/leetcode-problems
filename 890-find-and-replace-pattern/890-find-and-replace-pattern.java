class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            String s=words[i];
            HashMap<Character,Character> map=new HashMap<>();
            HashMap<Character,Boolean> map1=new HashMap<>();
            boolean fish=true;
            if(s.length()!=pattern.length()){
                continue;
            }
            for(int j=0;j<s.length();j++){
                char ch=pattern.charAt(j);
                char ch1=s.charAt(j);
                if(map.containsKey(ch)){
                    if(map.get(ch)!=ch1){
                        fish=false;
                        break;
                    }
                }
                else{
                    if(!map1.containsKey(ch1)){
                        map.put(ch,ch1);
                        map1.put(ch1,true); 
                    }
                    else{
                        fish=false;
                        break;
                    }
                   
                }
            }
            if(fish){
                list.add(s);
            }
        }
        return list;
    }
}