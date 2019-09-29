import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    ListNode [] result=new ListNode[100];
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1=0,size2=0;
        int []arr1,arr2;
        ListNode node1,node2;
        size1=getSize(l1);
        size2=getSize(l2);
        int maxsize=Math.max(size1,size2);
        System.out.println(size1+""+size2);
        if(size1<size2){
            node1=new ListNode(l1.val);
            node1.next=l1.next;
            node2=new ListNode(l2.val);
            node2.next=l2.next;
            arr1=new int[maxsize+1];
            arr2=new int[maxsize+1];
        }else{
            node1=new ListNode(l2.val);
            node1.next=l2.next;
            node2=new ListNode(l1.val);
            node2.next=l1.next;
            arr1=new int[maxsize+1];
            arr2=new int[maxsize+1];
        }//node1 为短链表 node2为长链表
        arr1[0]=0;
        arr2[0]=0;
        int i=0;
        for(;i<Math.abs(size1-size2);i++){
            arr2[i+1]=node2.val;
            node2=node2.next;
            arr1[i+1]=0;
        }
        for(;i<maxsize;i++){
            arr2[i+1]=node2.val;
            arr1[i+1]=node1.val;
            node2=node2.next;
            node1=node1.next;
        }
//        for(int k=0;k<maxsize+1;k++){
//            System.out.print(arr1[k]);
//        }
//        for(int k=0;k<maxsize+1;k++){
//            System.out.print(arr2[k]);
//        }
        for(int k=maxsize;i>0;i++){
            if(arr1[k]+arr2[k]>=10){
                arr2[k-1]+=1;
                arr2[k]=arr1[k]+arr2[k]-10;
            }else{
                arr2[k]=arr1[k]+arr2[k];
            }
        }
        ListNode [] result=new ListNode[maxsize+1];
        for(int j=0;j<=maxsize;j++){
            result[j]=new ListNode(arr2[j]);
            if(j>0)
                result[j-1].next=result[j];
        }
        if(arr2[0]==0)
            return result[1];
        else return result[0];

    }
    private static int getSize(ListNode node){
        int size=0;
        while(node!=null){
            size++;
            node=node.next;
        }
        return size;
    }
    public static void main(String args[]){
        ListNode a=new ListNode(2);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(5);
        ListNode e=new ListNode(6);
        ListNode f=new ListNode(4);
        a.next=b;
        b.next=c;
        d.next=e;
        e.next=f;
        ListNode t=addTwoNumbers(a,d);
        for(int i=0;i<getSize(t);i++){
            System.out.print(t.val+"-->");
            t=t.next;
        }

    }
}