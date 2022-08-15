/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
    if(root==null){
        return null;
    }
        Node leftmost=root;
        leftmost.next=null;
        while(leftmost.left!=null){
            Node hash=leftmost;
            while(hash!=null){
                hash.left.next=hash.right;
                if(hash.next!=null){
                    hash.right.next=hash.next.left;
                }
                else{
                    hash.right.next=null;
                }
                hash=hash.next;
            }
            leftmost=leftmost.left;
        }
        return root;
        
    }
}