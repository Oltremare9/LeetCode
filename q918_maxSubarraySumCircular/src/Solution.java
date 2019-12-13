class Solution {
    public static int maxSubarraySumCircular(int[] A) {
        int res[]=new int[A.length];
        int count=0;
        while(count++<A.length){
            int temp[]=new int[A.length];
            temp[0]=A[count-1];
            int p=1;
            for(int i=count;i%A.length!=count-1;i++){
                i=i%A.length;
                temp[p]=Math.max(temp[p-1]+A[i],A[i]);
                p++;
            }
            int max=Integer.MIN_VALUE;
            for(int i=0;i<temp.length;i++){
                max=Math.max(max,temp[i]);
            }
            res[count-1]=max;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<res.length;i++){
            max=Math.max(max,res[i]);
        }
        return max;
    }
    public static void main(String args[]){
        int a[]={-2,-3,-1};
        System.out.println(maxSubarraySumCircular(a));
    }
}