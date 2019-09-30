/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-stack
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class MinStack {
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        Node temp=new Node(x);
        if(head==null) {
            head = temp;
            head.next=null;
            head.max=temp.value;
        }else{
            temp.next=head;
            if(temp.value<head.max) {
                temp.max = temp.value;
                head=temp;
            }else{
                temp.max=head.max;
                head=temp;
            }
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head.value;
    }

    public int getMin() {
        return head.max;
    }
    class Node{
        Node next;
        int value;
        int max;
        public Node(){
            next=null;
        }
        public Node(int x){
            value=x;
            next=null;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */