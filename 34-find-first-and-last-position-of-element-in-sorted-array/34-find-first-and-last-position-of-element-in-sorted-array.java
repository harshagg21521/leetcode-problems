class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=-1;
        ans[1]=-1;
        if(nums.length==0){
            return ans;
        }
        ans[0]=first(nums,target);
        ans[1]=last(nums,target);
        return ans;
        
    }
    public int first(int[] arr,int x){
        int ans=-1;
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>x){
                j=mid-1;
            }
            else if(arr[mid]<x){
                i=mid+1;
            }
            else{
                ans=mid;
                j=mid-1;
            }
        }
        return ans;
    }
      public int last(int[] arr,int x){
        int ans=-1;
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>x){
                j=mid-1;
            }
            else if(arr[mid]<x){
                i=mid+1;
            }
            else{
                ans=mid;
                i=mid+1;
            }
        }
        return ans;
    }
}