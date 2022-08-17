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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        
        TreeNode root=helper(preorder,postorder,map,0,postorder.length-1,0,preorder.length-1);
        return root;
    }
    public TreeNode helper(int[] pre,int[] post, HashMap<Integer,Integer> map,int postl,int posth,int prel,int preh){
        if(prel>preh||postl>posth){
            return null;
        }
        TreeNode node=new TreeNode(pre[prel]);
        if(prel+1<=preh){
            int ind=map.get(pre[prel+1]);
            int lhs=ind-postl+1;
            node.left=helper(pre,post,map,postl,ind,prel+1,prel+lhs);
            node.right=helper(pre,post,map,ind+1,posth-1,prel+lhs+1,preh);
        }
        return node;
    }
}