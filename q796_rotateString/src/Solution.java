/*
给定两个字符串, A 和 B。

A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。

示例 1:
输入: A = 'abcde', B = 'cdeab'
输出: true

示例 2:
输入: A = 'abcde', B = 'abced'
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static boolean rotateString(String A, String B) {
        if(A.equals(B))
            return true;
        else if(A.length()!=B.length())
            return false;
        char[] c1=A.toCharArray();
        char[] c2=B.toCharArray();
        for(int index=0;index<A.length();index++){
            boolean flag=true;
            for(int i=0;i<A.length();i++){
                if(c1[(i+index)%c1.length]!=c2[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag==true)
                return true;
            else
                continue;
        }
        return false;
    }
//    public static void main(String args[]){
//        System.out.println(rotateString("abcde","abced"));
//
//    }
}