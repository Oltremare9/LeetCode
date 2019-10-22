import java.util.Stack;

/*
给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。

示例 1：

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
示例 2：

输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
输出：false
解释：1 不能在 2 之前弹出。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-stack-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < popped.length; i++) {
            if (stack.contains(popped[i])) {
                if (stack.peek() != popped[i])
                    return false;
                else {
                    stack.pop();
                    continue;
                }
            } else {
                while (pushed[j] != popped[i]) {
                    stack.push(pushed[j]);
                    j++;
                    if(j>pushed.length-1)
                        return false;
                }
                stack.push(pushed[j]);
                stack.pop();
                j++;
                continue;
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String args[]){
        int a[]={1,2,3,4,5};
        int b[]={4,5,3,2,1};
        System.out.println(validateStackSequences(a,b));
    }
}