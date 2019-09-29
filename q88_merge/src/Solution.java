/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1为空
        if(m==0){
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
        }else if(n==0){
        //nums2为空
            return;
        }else{
            //都不为空
            int inum=0;
            for(int j=0;j<n;j++){
                for(int i=inum;i<m;i++){
                    if(nums2[j]<nums1[i]){
                        for(int temp=m;temp>i;temp--){
                            nums1[temp]=nums1[temp-1];
                        }
                        nums1[i]=nums2[j];
                        m++;
                        inum++;
                        break;
                    }else{
                        inum++;
                        continue;
                    }

                }
                if(inum==m){
                    for(int k=j;k<n;k++){
                        nums1[inum]=nums2[k];
                        inum++;
                    }
                    break;
                }
            }
        }
    }
    public static void main(String args[]){
        int a[]={1,2,3,0,0,0};
        int b[]={2,5,6};
        merge(a,3,b,3);
        for(int i=0;i<6;i++){
            System.out.print(a[i]);
        }
    }
}