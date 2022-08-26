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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            int max=Integer.MIN_VALUE;
            while(size-->0){
                TreeNode node=q.remove();
                if(max<node.val){
                    max=node.val;
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}