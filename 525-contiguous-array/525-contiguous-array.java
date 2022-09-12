class Solution {
    public int findMaxLength(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(sum,-1);
        for(int i=0;i<nums.length;i++){
            sum=sum+(nums[i]==0?-1:1);
            if(map.containsKey(sum)){
                int len=i-map.get(sum);
                if(len>max){
                    max=len;
                }
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
}