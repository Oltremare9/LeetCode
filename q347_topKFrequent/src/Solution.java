/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import javax.swing.text.html.HTMLDocument;
import java.util.*;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer>map =new HashMap<>();
        int temp=nums[0];
        int sum=1;
        for(int i=1;i<nums.length;i++){
            if(temp==nums[i]){
                sum++;
            }else{
                map.put(temp,sum);
                sum=1;
                temp=nums[i];
            }
            map.put(temp,sum);
        }
        List<Integer> list=new ArrayList<>();
        if(nums.length==1){
            list.add(nums[0]);
            return list;
        }
        for(int i=0;i<k;i++) {
            int max=Integer.MIN_VALUE;
            int maxnum=-1;
            Iterator iterator=map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry e= (Map.Entry) iterator.next();
                if(Integer.parseInt(e.getValue().toString())>max) {
                    max = Integer.parseInt(e.getValue().toString());
                    maxnum=Integer.parseInt(e.getKey().toString());
                }
            }
            list.add(maxnum);
            map.remove(maxnum);
        }
        return list;
    }
}