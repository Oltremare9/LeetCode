import java.util.Arrays;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] str1=new char[s.length()];
        char[] str2=new char[t.length()];
        for (int i=0;i<s.length();i++){
            str1[i]=s.charAt(i);
            str2[i]=t.charAt(i);
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i=0;i<s.length();i++){
            if(str1[i]!=str2[i])
                return false;
        }
        return true;
    }
}
//class Solution {
//    public boolean isAnagram(String s, String t) {
//        int[] b = new int[26];
//        for(int i = 0; i < s.length(); i++) b[s.charAt(i) - 'a']++;
//        for(int i = 0; i < t.length(); i++) if(--b[t.charAt(i) - 'a'] < 0) return false;
//        return s.length() == t.length();
//    }
//}
//
//作者：lyl0724-2
//        链接：https://leetcode-cn.com/problems/valid-anagram/solution/4xing-javadai-ma-shi-yong-tong-lai-jie-jue-ben-ti-/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。