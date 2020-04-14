import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int x = 0; x < nums.length - 2; x++) {
            if (x > 0 && nums[x] == nums[x - 1])
                continue;
            for (int y = nums.length - 1; y > x; y--) {
                if (y < nums.length - 1 && nums[y] == nums[y + 1])
                    continue;
                int i = x + 1;
                int j = y - 1;
                while (i < j) {
                    if (nums[x] + nums[y] + nums[i] + nums[j] == target) {
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[x], nums[i], nums[j], nums[y])));
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    } else if (nums[x] + nums[y] + nums[i] + nums[j] > target) {
                        while (i < j && nums[j] == nums[--j]) ;
                    } else {
                        while (i < j && nums[i] == nums[++i]) ;
                    }
                }
            }
        }
        return list;
    }
}