/*
给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。

子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。

输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。


示例：

输入: "aba", "cdc", "eae"
输出: 3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public static int findLUSlength(String[] strs) {
        for(int i=0;i<strs.length;i++){
            for(int j=i+1;j<strs.length;j++){
                if(strs[i].length()<strs[j].length()) {
                    String temp=strs[i];
                    strs[i]=strs[j];
                    strs[j]=temp;
                }
            }
        }
        for(int i=0;i<strs.length;i++){
            int length=strs[i].length();
            boolean flag=true;
            for(int j=0;j<i;j++){
                if(ifSubString(strs[j],strs[i])) {
                    flag=false;
                    break;
                }
            }
            if(flag) {
                for (int j = i + 1; j < strs.length; j++) {

                    if (strs[j].length() < length){
                        return length;
                    }else if(ifSubString(strs[j],strs[i])) {
                        flag=false;
                        break;
                    }

                }
                if(flag)
                    return length;
            }else
                continue;
        }
        return -1;
    }
    private static boolean ifSubString(String a,String b){
        if(a.equals(b))
            return true;
        char[] c1=a.toCharArray();
        char[] c2=b.toCharArray();
        int index=0;
        int i=0;
        while(index<c2.length){
            boolean flag=true;
            char temp=c2[index];
            index++;
            while(i<c1.length){
                if(c1[i]==temp){
                    i++;
                    flag=false;
                    break;

                }else
                    i++;

            }
            if(flag)
                return false;
        }
        return true;
    }
//    public static void main(String args[]){
//        String []str={"aabbcc","abc"};
//        System.out.println(ifSubString(str[0],str[1]));
//    }
}