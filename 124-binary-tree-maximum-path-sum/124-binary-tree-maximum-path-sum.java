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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
     if(root==null){
      return 0;   
     }
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        
        int s=Math.max(0,left)+Math.max(0,right)+root.val;
        if(s>max){
            max=s;
        }
        return Math.max(0,Math.max(left,right))+root.val;
    }
    
}