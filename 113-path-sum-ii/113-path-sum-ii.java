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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        List<Integer> list2=new ArrayList<>();
        helper(root,list,list2,targetSum,0);
        return list;
    }
    public void helper(TreeNode root,List<List<Integer>> list,List<Integer> list2,int tar,int sum ){
        if(root==null){
            return ;
        }
        list2.add(root.val);
        sum+=root.val;
        if(root.left==null&&root.right==null&&sum==tar){
            list.add(new ArrayList<>(list2));
        }
        helper(root.left,list,list2,tar,sum);
        helper(root.right,list,list2,tar,sum);
        list2.remove(list2.size()-1);
        return ;
    }
}