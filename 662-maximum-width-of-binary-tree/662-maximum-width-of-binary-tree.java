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
    public class Pair{
        long min;
        long max;
    }
    long maxw=0;
    public int widthOfBinaryTree(TreeNode root) {
        maxw=0;
        HashMap<Integer,Pair> map=new HashMap<>();
        helper(root,1,1,map);
        return (int)maxw;
    }
    public void helper(TreeNode root,int level,long idx,HashMap<Integer,Pair> map){
        if(root==null){
            return ;
        }
        helper(root.left,level+1,idx*2,map);
        helper(root.right,level+1,2*idx+1,map);
        Pair p=null;
        if(map.containsKey(level)){
            p=map.get(level);
            p.max=idx;
        }else{
            p=new Pair();
            p.min=idx;
            p.max=idx;
            map.put(level,p);
        }
        
        long width=p.max-p.min+1;
        if(width>maxw){
            maxw=width;
        }
    }
}