/*
一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//class Solution {
//    public int numDecodings(String s) {
//        int length=s.length();
//        if(length==1 && Integer.parseInt(s)>0)
//            return 1;
//        else if(length==1 && Integer.parseInt(s)==0)
//            return 0;
//        int res=dfs(s,0,length);
//    }
//    private static int dfs(String s,int index,int length){
//        if(length-index<2){
//                return 1;
//
//        }if (s.length() == 2) {
//            return s.compareTo("26") <= 0 ? 2 : 1;
//        }else
//            if(Integer.parseInt(s.substring(index,index+1))>0){
//                if(Integer.parseInt(s.substring(index,index+2))<=26){
//                    return 2+dfs(s,index+1,length);
//                }else return 1+dfs(s,index+1,length);
//            }else{
//                return dfs(s,index+1,length);
//            }
//        }
//    }
//
//}

class Solution {
    public int numDecodings(String s) {
        if (!s.contains("0")) {
            return fun(s);
        }
        s = s.replaceAll("10", "A");
        s = s.replaceAll("20", "A");
        if (s.contains("0")) {
            return 0;
        }
        String[] as = s.split("A");
        int res = 1;
        for (String a : as) {
            res *= fun(a);
        }
        return res;
    }

    private int fun(String s) {
        if (s.length() < 2) {
            return 1;
        }
        if (s.length() == 2) {
            return s.compareTo("26") <= 0 ? 2 : 1;
        }
        String sub = s.substring(0, 2);
        if (sub.compareTo("26") <= 0) {
            return fun(s.substring(1)) + fun(s.substring(2));
        } else {
            return fun(s.substring(1));
        }
    }
}
