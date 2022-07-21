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
    public class Pair{
        Node node;
        int state;
        
        Pair(Node node,int state){
            this.node=node;
            this.state=state;
        }
        
    }
    public List<Integer> postorder(Node root) {
        if(root==null){
            return new ArrayList<>();
        }
        Stack<Pair> st=new Stack<>();
        List<Integer> list=new ArrayList<>();
        st.push(new Pair(root,-1));
        while(st.size()>0){
            Pair peek=st.peek();
            if(peek.state==-1){
                peek.state++;
            }
            else if(peek.state>=0&&peek.state<peek.node.children.size()){
                st.push(new Pair(peek.node.children.get(peek.state),-1));
                peek.state++;
            }
            else if(peek.state==peek.node.children.size()){
                list.add(peek.node.val);
                peek.state++;
            }
            else{
                st.pop();
            }
        }
        return list;
    }
}