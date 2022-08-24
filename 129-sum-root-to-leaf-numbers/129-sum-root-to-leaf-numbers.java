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
     int sum=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int sume){
        if(root==null){
            return ;
        }
        helper(root.left,sume*10+root.val);
        helper(root.right,sume*10+root.val);
        if(root.left==null&&root.right==null){
            sum=sum+sume*10+root.val;
        }
    }
}