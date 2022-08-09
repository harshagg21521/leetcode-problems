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
    int xl=0;
    int xr=0;
    public int size(TreeNode root,int x){
        if(root==null){
            return 0;
        }
        int lefts=size(root.left,x);
        int rights=size(root.right,x);
        if(root.val==x){
            xr=rights;
            xl=lefts;
        }
        return lefts+rights+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int c=size(root,x);
        int other=n-(xl+xr+1);
        int maxofth=Math.max(other,Math.max(xl,xr));
        int rest=n-maxofth;
        if(maxofth>rest){
            return true;
        }
        else{
            return false;
        }
    }
}