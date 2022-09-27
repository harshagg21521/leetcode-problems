class Solution {
         int[] res;
        class Pair{
            int val;
            int idx;
            
            Pair(int val,int idx){
                this.val=val;
                this.idx=idx;
            }
        }
    public List<Integer> countSmaller(int[] nums) {
        Pair[] pair=new Pair[nums.length];
        res=new int[pair.length];
        for(int i=0;i<nums.length;i++){
            pair[i]=new Pair(nums[i],i);
        }
        mergesort(pair,0,pair.length-1);
        List<Integer> list=new ArrayList<>();
        for(int val:res){
            list.add(val);
        }
        return list;
        
    }
    public Pair[] mergesort(Pair[] pair,int lo,int hi){
        if(lo==hi){
            Pair[] ba=new Pair[1];
            ba[0]=new Pair(pair[lo].val,lo);
            return ba;
        }
        int mid=(lo+hi)/2;
        Pair[] fr=mergesort(pair,lo,mid);
        Pair[] se=mergesort(pair,mid+1,hi);
        Pair[] ret=mergetwosorted(fr,se);
        return ret;
    }
    public Pair[] mergetwosorted(Pair[] fr,Pair[] se){
        Pair[] ans=new Pair[fr.length+se.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<fr.length&&j<se.length){
            if(fr[i].val>se[j].val){
                ans[k]=fr[i];
                res[fr[i].idx]+=(se.length-j);
                i++;
                k++;
            }
            else{
                ans[k]=se[j];
                j++;
                k++;
            }
        }
        while(i<fr.length){
            ans[k]=fr[i];
            i++;
            k++;
        }
        while(j<se.length){
            ans[k]=se[j];
            j++;
            k++;
        }
        return ans;
    }
}