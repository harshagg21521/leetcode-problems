class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans=0;
       for(int i=0;i<nums1.length;i++){
           int r=nums2.length-1;
           int l=i;
           while(l<=r){
               int m=l+(r-l)/2;
               if(nums1[i]>nums2[m]){
                  r=m-1;
               }
               else{
                   l=m+1;
               }
           }
           if(r<0){
               continue;
           }
           ans=Math.max(ans,r-i);
       }
        return ans;
    }
}