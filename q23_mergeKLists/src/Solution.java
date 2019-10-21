class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res=null;
        while(!ifEmpty(lists)){
            ListNode min=lists[getMinNode(lists)];
            if(res==null)
                res=min;
            else{
                ListNode point=res.next;
                while(point.next!=null){
                    point=point.next;
                }
                point.next=min;
                point=point.next;
                point.next=null;
            }
            lists[getMinNode(lists)]=lists[getMinNode(lists)].next;
        }
        return res;
    }
    private boolean ifEmpty(ListNode[] lists){
        for(int i=0;i<lists.length;i++){
            if(lists[i].val!=-1)
                return false;
        }
        return true;
    }
    private int getMinNode(ListNode[] lists){
        int index=-1;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<lists.length;i++){
            if(lists[i].val<max){

                index=i;
                max=lists[i].val;
            }

        }
        return index;
    }
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
