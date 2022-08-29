class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            int n=1;
            List<Integer> list1=new ArrayList<>();
            for(int j=0;j<=i;j++){
                list1.add(n);
                n=n*(i-j)/(j+1);
            }
            list.add(list1);
        }
          return list;  
    }
}