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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lf=0;
        TreeNode node1=root;
        while(node1.left!=null){
            lf++;
            node1=node1.left;
        }
        int rf=0;
        TreeNode node2=root;
        while(node2.right!=null){
            rf++;
            node2=node2.right;
        }
        if(lf==rf){
            int h=lf+1;
            return (1<<h)-1;
        }
        else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        
    }
   
}