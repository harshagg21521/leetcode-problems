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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
        return root;
    }
    public TreeNode construct(int pres,int pree,int ins,int ine,int[] pre,int[] in){
        if(pres>pree||ins>ine){
            return null;
        }
        int i=0;
        while(pre[pres]!=in[i]){
            i++;
        }
        TreeNode node=new TreeNode();
        node.val=pre[pres];
        int ind=i-ins;
        node.left=construct(pres+1,pres+ind,ins,i-1,pre,in);
        node.right=construct(pres+ind+1,pree,i+1,ine,pre,in);
        return node;
    }
}