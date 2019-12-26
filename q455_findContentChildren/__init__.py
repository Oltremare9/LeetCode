class Solution(object):
    def findContentChildren(self, g, s):
        """
        :type g: List[int]
        :type s: List[int]
        :rtype: int
        """
        g.sort()
        s.sort()
        index = 0
        res = 0
        for i in range(len(g)):
            while index < len(s):
                if s[index] >= g[i]:
                    del s[index]
                    res += 1
                    break
                else:
                    index += 1
        return res