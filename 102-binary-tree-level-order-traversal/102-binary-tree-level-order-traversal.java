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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> que=new ArrayDeque<>();
        ArrayList<List<Integer>> list=new ArrayList<List<Integer>>();
        que.add(root);
        while(que.size()>0){
            int count=que.size();
            List<Integer> list1=new ArrayList<>();
            for(int i=0;i<count;i++){
                TreeNode peekp=que.remove();
                list1.add(peekp.val);
                if(peekp.left!=null){
                    que.add(peekp.left);
                }
                if(peekp.right!=null){
                    que.add(peekp.right);
                } 
            }
            list.add(list1);
        }
        return list;
        
    }
}