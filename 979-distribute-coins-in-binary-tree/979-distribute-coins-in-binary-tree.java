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
    public int moves=0;
    public class Pair{
     int nodes;
     int coins;
    } 
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }
    public Pair helper(TreeNode root){
        if(root==null){
            return new Pair();
        }
        Pair lp=helper(root.left);
        Pair rp=helper(root.right);
        
        Pair tp=new Pair();
        tp.coins=lp.coins+rp.coins+root.val;
        tp.nodes=lp.nodes+rp.nodes+1;
        moves+=Math.abs(tp.nodes-tp.coins);
        return tp;
    }
}