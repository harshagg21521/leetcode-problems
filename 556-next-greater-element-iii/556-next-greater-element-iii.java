class Solution {
    public int nextGreaterElement(int n) {
        char[] arr=(n+"").toCharArray();
        int i=arr.length-1;
        while(i>0){
            if(arr[i-1]>=arr[i]){
                i--;
            }
            else{
                break;
            }
        }
        if(i==0){
            return -1;
        }
        int indx=i-1;
        int j=arr.length-1;
        while(j>indx){
            if(arr[j]>arr[indx]){
                break;
            }
            j--;
        }
        swap(arr,indx,j);
        int left=i;
        int right=arr.length-1;
        while(left<right){
            swap(arr,left,right);
            right--;
            left++;
        }
        String res=new String(arr);
        long val=Long.parseLong(res);
        if(val>Integer.MAX_VALUE){
            return -1;
        }
        else{
            return (int)val;
        }
    }
    public void swap(char[] arr,int i,int j){
        if(i>j){
            return;
        }
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}