/*
在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int [][]res=new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<res[0].length;i++){
            res[0][i]=0;
        }
        for(int i=0;i<res.length;i++){
            res[i][0]=0;
        }
        int max=0;
        for(int i=1;i<res.length;i++){
            for(int j=1;j<res[0].length;j++){
//                res[i][j]=Integer.parseInt(String.valueOf(matrix[i-1][j-1]));
                if(matrix[i-1][j-1]=='1') {
                    res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]), res[i - 1][j - 1])+1;
                    if (max<res[i][j])
                        max=res[i][j];
                }
            }
        }
        return max*max;
    }
}