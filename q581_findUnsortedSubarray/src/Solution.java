import java.util.Arrays;

/*
给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int a[]=nums.clone();
        Arrays.sort(a);
        int index1=-1,index2=-1;
        for(int i=0;i<a.length;i++){
            if(a[i]!=nums[i]){
                index1=i;
                break;
            }
        }
        for(int i=a.length-1;i>=0;i--){
            if(a[i]!=nums[i]){
                index2=i;
                break;
            }
        }
        if(index1==-1&&index2==-1){
            return 0;
        }else if(index1==-1||index2==-1)
            return 1;
        else
            return index2-index1+1;
    }
}