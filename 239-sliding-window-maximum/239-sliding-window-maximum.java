class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge=new int[nums.length];
        int[] ans=new int[nums.length-k+1];
        Stack<Integer> st=new Stack<>();
        st.push(nums.length-1);
        nge[nums.length-1]=nums.length;
        for(int i=nums.length-2;i>=0;i--){
            int val=nums[i];
            while(st.size()>0&&val>=nums[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i]=nums.length;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        int i=0,j=0;
        while(i<=nums.length-k){
            if(nge[j]<k+i){
                j=nge[j];
            }
            else{
                ans[i]=nums[j];
                i++;
                if(j<i){
                    j=i;
                }
            }
        }
        return ans;
    }
}