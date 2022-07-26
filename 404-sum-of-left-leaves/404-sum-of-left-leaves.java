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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            if(root.right!=null){
                return sumOfLeftLeaves(root.right);
            }else{
                return 0;
            }
            
        }
        int leftv=sumOfLeftLeaves(root.left);
        int rightv=sumOfLeftLeaves(root.right);
        if(root.left.left==null&&root.left.right==null){
        return root.left.val+rightv+leftv;
        }
        return leftv+rightv;
    }
}