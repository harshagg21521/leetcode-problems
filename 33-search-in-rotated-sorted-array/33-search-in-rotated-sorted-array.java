class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==1){
            if(nums[0]==target){
                return 0;
            }
            return -1;
        }
         int pivi=pivot(nums);
         int ans1= binarysearch(nums,0,pivi-1,target);
         int ans2=binarysearch(nums,pivi,n-1,target); 
        return Math.max(ans2,ans1);
        
        
    }
    public int pivot(int[] arr){
        int n=arr.length;
        int lo=0;
        int hi=n-1;
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(arr[mid]>arr[hi]){
                lo=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return lo;
    }
    public int binarysearch(int[] arr,int lo,int hi,int key){
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(arr[mid]>key){
                hi=mid;
            }
            else if(arr[mid]<key){
                lo=mid+1;
            }
            else{
                return mid;
            }
        }
        if(arr[lo]==key){
            return lo;
        }
        return -1;
    }
}