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
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        height(root);
        return dia;
        
    }
    public int height(TreeNode root){
        if(root==null){
            return -1;
        }
        int l=height(root.left);
        int r=height(root.right);
        if(l+r+2>dia){
            dia=l+r+2;
        }
        return Math.max(l,r)+1;
    }
}