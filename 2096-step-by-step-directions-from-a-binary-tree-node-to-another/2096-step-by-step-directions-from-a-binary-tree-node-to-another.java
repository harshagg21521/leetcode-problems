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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> list1=helper(root,startValue);
        ArrayList<TreeNode> list2=helper(root,destValue);
        
        int i=list1.size()-1;
        int j=list2.size()-1;
        while(i>=0&&j>=0){
            if(list1.get(i)==list2.get(j)){
                i--;
                j--;
            }
            else{
                break;
            }
        }
        i++;
        j++;
        StringBuilder ans=new StringBuilder();
        for(int ii=0;ii<i;ii++){
            ans.append("U");
        }
        for(int jj=j;jj>0;jj--){
            if(list2.get(jj-1)==list2.get(jj).left){
                ans.append("L");
            }
            else{
                ans.append("R");
            }
        }
        return ans.toString();
    }
    public ArrayList<TreeNode> helper(TreeNode root,int n){
        if(root==null){
            return new ArrayList<>();
        }
        if(root.val==n){
            ArrayList<TreeNode> bs=new ArrayList<>();
            bs.add(root);
            return bs;
        }
        else{
            ArrayList<TreeNode> left=helper(root.left,n);
            if(left.size()>0){
                left.add(root);
                return left;
            }else{
                ArrayList<TreeNode> right=helper(root.right,n);
                if(right.size()>0){
                    right.add(root);
                    return right;
                }
                else{
                    return new ArrayList<>();
                }
            }
        }
    }
}