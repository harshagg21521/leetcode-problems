/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        List<TreeNode> list1=new ArrayList<>();
        List<TreeNode> list2=new ArrayList<>();
        list1= nodetorootpath(root,p);
        list2=nodetorootpath(root,q);
        int i=list1.size()-1;
        int j=list2.size()-1;
        while(i>=0&&j>=0){
            if(list1.get(i).val==list2.get(j).val){
                i--;
                j--;
            }
            else{
                break;
            }
        }
        return list1.get(i+1);
    }
    public List<TreeNode> nodetorootpath(TreeNode root, TreeNode node){
        if(root==null){
            return new ArrayList<>();
        }
        if(root.val==node.val){
            List<TreeNode> bres=new ArrayList<>();
            bres.add(root);
            return bres;
        }
        
        List<TreeNode> leftl=nodetorootpath(root.left,node);
        List<TreeNode> rightl=nodetorootpath(root.right,node);
        if(leftl.size()>0){
            leftl.add(root);
        }
        else if(rightl.size()>0){
            rightl.add(root);
        }
        return leftl.size()>0?leftl:rightl;
    }
}