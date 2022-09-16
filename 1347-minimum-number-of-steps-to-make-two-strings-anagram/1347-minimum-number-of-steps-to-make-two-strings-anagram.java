class Solution {
    public int minSteps(String s, String t) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        int count=0;
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(freq[ch-'a']==0){
                count++;
            }
            else{
                freq[ch-'a']--;
            }
        }
        return count;
    }
}