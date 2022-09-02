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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,Integer.MIN_VALUE);
        return count;
        
    }
    public void helper(TreeNode root,int no){
        if(root==null){
            return ;
        }
        if(root.val>=no){
            count++;
            helper(root.left,root.val);
            helper(root.right,root.val);
        }
        else{
            helper(root.left,no);
            helper(root.right,no);
            
        }
        return ;
    }
}