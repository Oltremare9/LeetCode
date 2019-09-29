

/*

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
 */
import java.util.Arrays;
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int temp=nums[0];
        int num=0;
        int max=0;
        int maxi=0;
        for(int i=0;i<nums.length;i++){
            if(temp==nums[i]){
                num++;
            }else{

                if(num>max) {
                    max = num;
                    maxi=i-1;
                }
                num=1;
                temp=nums[i];
            }
        }
        if(num>max) {
            return nums[nums.length-1];
        }else{
            return nums[maxi];
        }

    }
}