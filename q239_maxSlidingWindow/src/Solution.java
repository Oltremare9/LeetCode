class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==0){
            return nums;
        }
        int [] res=new int[nums.length-k+1];
        int index=0;
        for(int i=0;i<=nums.length-k;i++){
            res[index++]=arrayMax(nums,i,k);
        }
        return res;
    }
    private int arrayMax(int nums[],int start,int k){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<start+k;i++){
            if(nums[i]>max)
                max=nums[i];
        }
        return max;
    }
}