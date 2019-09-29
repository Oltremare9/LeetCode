/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int length= nums.length;
        if(length==0)
            return 0;
        else{
            return maxSubSum(nums,0,length-1);
        }
    }
    private int maxMid(int[] num,int left,int mid ,int right){
        int sumleft=Integer.MIN_VALUE;
        int temp=0;
        for(int i=mid;i>=left;i--){
            temp+=num[i];
            if(temp>sumleft)
                sumleft=temp;
        }
        int sumright=Integer.MIN_VALUE;
        temp=0;
        for(int i=mid+1;i<=right;i++){
            temp+=num[i];
            if(temp>sumright)
                sumright=temp;
        }
        return sumleft+sumright;
    }
    private int maxSubSum(int []num,int left,int right){
        if(left==right)
            return num[left];
        int mid=(left+right)>>>1;
        return Math.max(Math.max(maxSubSum(num,left,mid),maxSubSum(num,mid+1,right)),maxMid(num,left,mid,right));
    }
}