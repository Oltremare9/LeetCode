/**
 * Definition for singly-linked list.
 * */


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode temp=head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
                continue;
            }
            if(temp.next!=null)
                temp=temp.next;
            else {
                temp.next = null;
                break;
            }
        }
        return head;
    }
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
}