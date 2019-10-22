import javax.naming.PartialResultException;
import java.util.Arrays;
import java.util.Stack;

/*
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
思路：每个柱子能接到的水 等于该柱子两侧最大值中 较小的那个长度 减去该柱子长度
 */
class Solution {
    public static int trap(int[] height) {
        if(height.length==0||height.length==1)
            return 0;
        int res=0;
        for(int i=1;i<height.length-1;i++){
            res+=getWater(i, height);
        }
        return res;
    }
    private static int getWater(int index,int[] arr){
        int max=arr[index];
        int index_left=index;

        for(int i=0;i<index;i++){
            if(arr[i]>max) {
                index_left = i;
                max=arr[i];
            }
        }
        int index_right=index;
        max=arr[index];
        for(int i=arr.length-1;i>index;i--){
            if(arr[i]>max) {
                index_right = i;
                max=arr[i];
            }
        }
        int water=Math.min(arr[index_right],arr[index_left])-arr[index];
        return water;
    }
//    public static void main(String args[]){
//        int height[]={0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(trap(height));
//    }
}