/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public class Pair implements Comparable<Pair>{
        TreeNode node;
        int h;
        int v;
        Pair(TreeNode node,int h,int v){
            this.node=node;
            this.h=h;
            this.v=v;
        }
        public int compareTo(Pair other){
            if(this.h==other.h){
                return this.node.val-other.node.val;
            }
            else{
               return  this.h-other.h;
            }
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,PriorityQueue<Pair>> map=new HashMap<>();
        int lv=0;
        int hv=0;
        q.add(new Pair(root,0,0));
        while(q.size()>0){
            Pair temp=q.remove();
            lv=Math.min(lv,temp.v);
            hv=Math.max(hv,temp.v);
            
            if(map.containsKey(temp.v)){
                map.get(temp.v).add(temp);
            }
            else{
                map.put(temp.v,new PriorityQueue<>());
                map.get(temp.v).add(temp);
                
            }
            if(temp.node.left!=null){
                q.add(new Pair(temp.node.left,temp.h+1,temp.v-1));
            }
            if(temp.node.right!=null){
                q.add(new Pair(temp.node.right,temp.h+1,temp.v+1));
            }
        }
        List<List<Integer>>list=new ArrayList<>();
        for(int i=lv;i<=hv;i++){
            List<Integer> list2=new ArrayList<>();
            PriorityQueue<Pair> p=map.get(i);
            while(p.size()>0){
                Pair w=p.remove();
                list2.add(w.node.val);
            }
            list.add(list2);
        }
        return list;

    }
}