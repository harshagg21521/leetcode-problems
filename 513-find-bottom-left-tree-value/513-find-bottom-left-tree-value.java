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
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.remove();
                if(i==0){
                    list.add(temp.val);
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }
        return list.get(list.size()-1);
    }
}