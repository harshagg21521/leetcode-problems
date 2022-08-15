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
    int m=0;
    int nm=1;
    int c=2;
    public int minCameraCover(TreeNode root) {
        if(root==null){
            return 0;
        }
        int val=helper(root);
        if(val==nm){
            count++;
        }
        return count;
    }
    public int helper(TreeNode root){
        if(root==null){
            return m;
        }
        int left=helper(root.left);
        int right=helper(root.right);
        if(left==nm||right==nm){
            count++;
            return c;
        }
        else if(left==c||right==c){
            return m;
        }
        else{
            return nm;
        }
    }
}