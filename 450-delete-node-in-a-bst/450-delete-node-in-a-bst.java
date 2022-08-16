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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(root.val==key){
            if(root.left==null&&root.right==null){
                return null;
            }
            else if(root.left==null||root.right==null){
                return root.left==null?root.right:root.left;
            }
            else{
                root.val=min(root.right);
                root.right= deleteNode(root.right,root.val);
                return root;
            }
        }
        else if(root.val>key){
            root.left= deleteNode(root.left,key);
        }
        else{
            root.right= deleteNode(root.right,key);
        }
        return root;
        
    }
    public int min(TreeNode root){
        if(root.left==null){
            return root.val;
        }
        
         int left=min(root.left);
        
        return left;
    }
}