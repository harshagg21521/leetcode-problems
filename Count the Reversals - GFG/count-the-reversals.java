//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String s)
    
    {
        if(s.length()%2==1){
            return -1;
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='}'){
                if(st.size()>0&&st.peek()=='{'){
                    st.pop();
                }
                else{
                    st.push(s.charAt(i));
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        int open=0;
        int closed=0;
        while(st.size()>0){
            if(st.peek()=='{'){
            closed++;
            }
            else if(st.peek()=='}'){
                open++;
            }
            st.pop();
        }
        return ((open+1)/2)+((closed+1)/2);
        // your code here       
    }
}