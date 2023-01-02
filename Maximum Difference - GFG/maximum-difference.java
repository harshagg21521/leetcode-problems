//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.findMaxDiff(a,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findMaxDiff(int a[], int n)
    {
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        arr1=left(a,n);
        arr2=right(a,n);
        int maxi=0;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,Math.abs(arr1[i]-arr2[i]));
        }
        return maxi;
	// Your code here	
    }
    int[] left(int[] ar,int n){
        Stack<Integer> st=new Stack<>();
        int[] an=new int[n];
        st.push(n-1);
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&ar[i]<ar[st.peek()]){
                an[st.peek()]=ar[i];
                st.pop();
            }
            st.push(i);
        }
        return an;
    }
    int[] right(int[] ar,int n){
        Stack<Integer> st=new Stack<>();
        int[] an=new int[n];
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size()>0&&ar[i]<ar[st.peek()]){
                an[st.peek()]=ar[i];
                st.pop();
            }
            st.push(i);
        }
        return an;
    }
}