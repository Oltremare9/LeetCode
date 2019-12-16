/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        else if(head.next == null)
            return head;
        else {
            ListNode res=new ListNode(-1);
            res.next=head;
            ListNode temp=res;
            while(temp!=null&&temp.next!=null){
                ListNode point=getNext(temp.next);
                while(point!=null&&point.next!=null&&point.val==point.next.val){
                    point=getNext(point);
                }
                temp.next=point;
                temp=point;
            }
            return res.next;
        }
    }
    private static ListNode getNext(ListNode node){
        if(node==null)
            return null;
        else if(node.next==null)
            return node;
        else if(node.next.val!=node.val){
            return node;
        }
        else{
            while(node.next!=null && node.val==node.next.val){
                node=node.next;
            }
            if(node.next==null)
                return null;
            else
                return node.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

}