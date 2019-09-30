import java.util.Arrays;

/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int firstUniqChar(String s) {
        if(s.length()==0)
            return -1;
        char[] str=new char[s.length()];
        char[] ans=new char[s.length()];
        for(int i=0;i<s.length();i++){
            str[i]=s.charAt(i);
            ans[i]=s.charAt(i);
        }
        Arrays.sort(str);
        for(int i=0;i<ans.length;i++){
            char temp=ans[i];
            int j;
            for(j=0;j<str.length-1;j++){
                if(temp==str[j] && str[j+1]==temp)
                    break;
                if(temp==str[j] && str[j+1]!=temp)
                    return i;
            }
            if(j==(str.length-1))
                return i;
        }
        return -1;
    }
}
/*
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}

作者：LeetCode
链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string/solution/zi-fu-chuan-zhong-de-di-yi-ge-wei-yi-zi-fu-by-leet/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */