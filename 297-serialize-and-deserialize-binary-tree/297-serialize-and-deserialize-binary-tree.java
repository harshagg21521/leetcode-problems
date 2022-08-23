/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     public class Pair{
        int state;
         TreeNode node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return  "";
        }
        StringBuilder sb=new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
    public void helper(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(".");
            sb.append(" ");
            return ;
        }
        sb.append(root.val);
        sb.append(" ");
        helper(root.left,sb);
        helper(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] str=data.split(" ");
        Stack<Pair> st=new Stack<>();
        Pair rp=new Pair();
        rp.node=new TreeNode(Integer.parseInt(str[0]));
        st.push(rp);
        int idx=0;
        
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==0){
                idx++;
                top.state++;
                if(str[idx].equals(".")==false){
                    Pair lp=new Pair();
                    lp.node=new TreeNode(Integer.parseInt(str[idx]));
                    top.node.left=lp.node;
                    st.push(lp);
                }
            }
            else if(top.state==1){
                idx++;
                top.state++;
                if(str[idx].equals(".")==false){
                    Pair rtp=new Pair();
                    rtp.node=new TreeNode(Integer.parseInt(str[idx]));
                    top.node.right=rtp.node;
                    st.push(rtp);
                }
                
            }
            else{
                st.pop();
            }
        }
        return rp.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));