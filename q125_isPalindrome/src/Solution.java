/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
 */

class Solution {
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.trim();
        int len=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')) {
//                System.out.print(s.charAt(i)+" ");
                len++;
            }
        }
//        System.out.println();

        char []temp=new char[len];
        if(len==0 || len==1)
            return true;
        len=0;
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)>='a' && s.charAt(i)<='z')||(s.charAt(i)>='0' && s.charAt(i)<='9')) {
                temp[len] = s.charAt(i);
//                System.out.print(temp[len]+" ");
                len++;
            }
        }
//        System.out.println();
        for(int i=0;i<len;i++){
            if(temp[i]!=temp[len-i-1])
                return false;
        }
        return true;
    }
//    public static void main(String args[]){
//        System.out.println(isPalindrome("1b1"));
//    }
}