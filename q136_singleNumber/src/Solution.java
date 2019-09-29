import java.util.Arrays;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4

 */
class Solution {
    //排序后 时间复杂度o(nlogn)
    /*
    public int singleNumber(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }
        if(nums[0]!=nums[1])
            return nums[0];
        else return nums[nums.length-1];
    }
    */
    //使用异或操作，java将int型转为二进制后进行异或运算
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans=ans^nums[i];
            }
        return ans;
        }
}