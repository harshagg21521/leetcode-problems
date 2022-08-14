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
    int ind=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        
        TreeNode node=helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return node;
    }
    public TreeNode helper(int[] pre,int min,int max){
        if(pre.length==ind){
            return null;
        }
        
        if(pre[ind]<max&&pre[ind]>min){
        TreeNode node=new TreeNode();
         node.val=pre[ind];
            ind++;
        
        node.left=helper(pre,min,node.val);
        node.right=helper(pre,node.val,max);
        return node;
    }
        else{
            return null;
        }
}
}