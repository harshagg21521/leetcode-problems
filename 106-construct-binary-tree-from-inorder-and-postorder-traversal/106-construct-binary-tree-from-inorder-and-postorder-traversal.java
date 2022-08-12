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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=construct(0,inorder.length-1,0,postorder.length-1,inorder,postorder);
        return root;
    }
    public TreeNode construct(int ins,int ine,int posts,int poste,int[] in,int[] post){
        if(posts>poste||ins>ine){
            return null;
        }
        int i=ins;
        while(post[poste]!=in[i]){
            i++;
        }
        TreeNode node=new TreeNode();
        node.val=post[poste];
        int ind=ine-i;
        node.left=construct(ins,i-1,posts,poste-ind-1,in,post);
        node.right=construct(i+1,ine,poste-ind,poste-1,in,post);
        return node;
    }
    }
