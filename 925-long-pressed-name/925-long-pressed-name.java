class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length()>typed.length()){
            return false;
        }
        int i=0;
        int j=0;
        while(i<typed.length()){
            if(j<name.length()&&name.charAt(j)==typed.charAt(i)){
                i++;
                j++;
            }
            else if(i>0&&typed.charAt(i)==typed.charAt(i-1)){
                i++;
            }
            else{
                return false;
            }
        }
        return j==name.length();
    }
}