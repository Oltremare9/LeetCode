class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        rest = 0
        res = 0
        if sum(gas) < sum(cost):
            return -1
        for i in range(len(gas)):
            rest += gas[i] - cost[i]
            if rest < 0:
                rest = 0
                res=i+1

        return res