class Solution(object):
    def isToeplitzMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: bool
        """
        for i in range(len(matrix) - 1, -1, -1):
            temp = matrix[i][0]
            line = i
            row = 0
            while line < len(matrix) and row < len(matrix[0]):
                if matrix[line][row] != temp:
                    return False
                line += 1
                row += 1
        for i in range(len(matrix[0])):
            temp = matrix[0][i]
            line = 0
            row = i
            while line < len(matrix) and row < len(matrix[0]):
                if matrix[line][row] != temp:
                    return False
                line += 1
                row += 1
        return True
