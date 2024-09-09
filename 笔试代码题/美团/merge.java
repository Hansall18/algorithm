package 笔试代码题.美团;

import java.util.Arrays;

//合并两个有序数组
//nums1的长度是m+n
public class merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m+n];
        int left1 = 0;
        int left2 = 0;
        int right1 = m-1;
        int right2 = n-1;
        int k = 0;
        while (left1<=right1 && left2<=right2){
            while (left1<=right1 && nums1[left1]<=nums2[left2]) temp[k++] = nums1[left1++];
            while (left2<=right2 && nums2[left2]<nums1[left1]) temp[k++] = nums2[left2++];
        }
        for (int i = left1; i<=right1; i++){
            temp[k++] = nums1[i];
        }
        for (int i = left2; i<=right2; i++){
            temp[k++] = nums2[i];
        }
        System.arraycopy(temp,0,nums1,0,nums1.length);
        Arrays.toString(nums1);
    }
}
