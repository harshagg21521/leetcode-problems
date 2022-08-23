class Solution {
    public class Pair implements Comparable <Pair>{
        int start;
        int end;
        
        public int compareTo(Pair o){
            if(this.start!=o.start){
                return this.start-o.start;
            }
            else{
                return this.end-o.end;
            }
        }
    }
    public int[][] merge(int[][] intervals) {
        Pair[] arr=new Pair[intervals.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=new Pair();
            arr[i].start=intervals[i][0];
            arr[i].end=intervals[i][1];

        }
        Arrays.sort(arr);
        Stack<Pair> st=new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            Pair top=st.peek();
            if(arr[i].start>top.end){
                st.push(arr[i]);
            }
            else{
                top.end=Math.max(top.end,arr[i].end);
            }
          
        }
        Stack<Pair> rev=new Stack();
        while(st.size()>0){
            rev.push(st.pop());
        }
                   
        List<Pair> list= new ArrayList<>();
            while(rev.size()>0){
                list.add(rev.pop());
            }
        int[][] ans=new int[list.size()][2];
        int i=0;
        for(Pair pair:list){
            ans[i][0]=pair.start;
            ans[i][1]=pair.end;
            i++;
        }
        return ans;
    }
}