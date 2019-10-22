import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<Integer> arr=new LinkedList<>();
        for(int i=0;i<lists.length;i++){
            ListNode node=lists[i];
            while(node!=null){
                arr.add(node.val);
                node=node.next;
            }
        }

        Object[] a =arr.toArray();
        Arrays.sort(a);
        ListNode res=new ListNode(-1);
        ListNode temp=null;
        for(int i=0;i<a.length;i++){
            ListNode node=new ListNode((int)a[i]);
            if(res.next==null)
                res.next=node;
            else
                temp.next=node;
            temp=node;
        }

        return res.next;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
