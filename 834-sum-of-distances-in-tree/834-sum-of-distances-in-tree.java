class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        HashSet<Integer>[] graph=new HashSet[n];
        for(int i=0;i<n;i++){
            graph[i]=new HashSet<Integer>();
        }
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int[] nodes=new int[n];
        int[] res=new int[n];
        helper(graph,nodes,res,0,-1);
        helper2(graph,nodes,res,0,-1);
        return res;
    }
    public void helper(HashSet<Integer>[] graph,int[] nodes,int[] res,int src,int par){
        for(int nbr:graph[src]){
            if(nbr!=par){
                helper(graph,nodes,res,nbr,src);
                nodes[src]+=nodes[nbr];
                res[src]+=nodes[nbr]+res[nbr];
            }
        }
        nodes[src]++;
    }
       public void helper2(HashSet<Integer>[] graph,int[] nodes,int[] res,int src,int par){
        for(int nbr:graph[src]){
            if(nbr!=par){
                res[nbr]=res[src]+(nodes.length-nodes[nbr])-nodes[nbr];
                helper2(graph,nodes,res,nbr,src);
               
            }
        }
      
    }
}