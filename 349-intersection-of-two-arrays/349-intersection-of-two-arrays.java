class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            if(map.containsKey(i)){
                list.add(i);
                map.remove(i);
            }
        }
        int[] arr=new int[list.size()];
        int j=0;
        for(int i:list){
            arr[j]=i;
            j++;
        }
        return arr;
    }
}