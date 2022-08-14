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
    public int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        HashMap<Long,Integer> map=new HashMap<>();
        map.put((long)0,1);
        helper(root,targetSum,root.val,map);
        return count;
    }
    public  void helper(TreeNode root,int target,long curr,HashMap<Long,Integer> map){
       count+=map.getOrDefault(curr-target,0);
        map.put(curr,map.getOrDefault(curr,0)+1);
        if(root.left!=null){
            helper(root.left,target,curr+root.left.val,map);
        }
        if(root.right!=null){
            helper(root.right,target,curr+root.right.val,map);
        }
        map.put(curr,map.getOrDefault(curr,0)-1);
    }
}