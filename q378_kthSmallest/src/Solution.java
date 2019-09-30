import java.util.Arrays;

/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
说明:
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int length=matrix.length;
        int []nums=new int[length*length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                nums[i*length+j]=matrix[i][j];
            }
        }
        Arrays.sort(nums);
        return nums[k-1];
    }
}