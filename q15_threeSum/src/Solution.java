/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int x=0;x<nums.length-2;x++){

            if(nums[x]>0) break;
            if(x>0&&nums[x]==nums[x-1])
                continue;
            int i=x+1;
            int j=nums.length-1;
            while(i<j){
                if(nums[x]+nums[i]+nums[j]==0){
                    list.add(new ArrayList<Integer>(Arrays.asList(nums[x],nums[i],nums[j])));
                    while(i<j&&nums[i]==nums[++i]);
                    while(i<j&&nums[j]==nums[--j]);
                }else if(nums[x]+nums[i]+nums[j]>0){
                    while(i<j && nums[j]==nums[--j]);
                }else{
                    while(i<j && nums[i]==nums[++i]);
                }
            }
        }
        return list;
    }
}