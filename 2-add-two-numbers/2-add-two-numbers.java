/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null||l2==null){
            return l1==null?l2:l1;
        }
        ListNode ans=null;
        ListNode curr=ans;
        int q=0;
        int r=0;
        int c=0;
        while(l1!=null&&l2!=null){
            int s=l1.val+l2.val+c;
            q=s/10;
            r=s%10;
            ListNode node= new ListNode(r);
            if(ans==null){
                ans=node;
                curr=node;
            }
            else{
                curr.next=node;
                curr=curr.next;
            }
            c=q;
            l1=l1.next;
            l2=l2.next;
        }
           while(l1!=null){
            int ss=l1.val+c;
            q=ss/10;
            r=ss%10;
            ListNode n2=new ListNode(r);
            curr.next=n2;
            curr=curr.next;
            c=q;
            l1=l1.next;
        }
        while(l2!=null){
            int ss=l2.val+c;
            q=ss/10;
            r=ss%10;
            ListNode n1=new ListNode(r);
            curr.next=n1;
            curr=curr.next;
            c=q;
            l2=l2.next;
            
        }
        if(c>0){
            ListNode n=new ListNode(c);
            curr.next=n;
            curr=curr.next;
        }
        return ans;
    }
}