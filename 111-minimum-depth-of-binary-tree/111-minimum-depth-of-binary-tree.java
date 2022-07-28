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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftv=minDepth(root.left);
        int rightv=minDepth(root.right);
        if(root.left==null){
            return rightv+1;
        }
        if(root.right==null){
            return leftv+1;
        }
        return Math.min(leftv,rightv)+1;
        
    }
}