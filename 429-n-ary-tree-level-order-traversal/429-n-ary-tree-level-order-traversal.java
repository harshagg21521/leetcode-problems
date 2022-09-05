/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
                if(root==null){
           return  new ArrayList<>();
        }
        List<List<Integer>> list=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            List<Integer> list2=new ArrayList<>();
            while(size-->0){
                Node top=q.remove();
                list2.add(top.val);
                for(Node child:top.children){
                    if(child!=null){
                    q.add(child);
                    }
                }
            }
            list.add(list2);
        }
        return list;
    }
}