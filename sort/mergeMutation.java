package sort;

import java.util.Arrays;

/**
 * 小和问题：
 * 在一个数组中，每一个数左边的比当前数小的值累加起来，叫做这个数组的小和！
 * 求出一个给定数组的小和?
 */
public class mergeMutation {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,3};
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }
    static int smallSum(int[] arr,int left,int right){
        if(left == right) return 0;
        int mid = left+((right-left)>>1);
        int i = smallSum(arr,left,mid);
        int j = smallSum(arr,mid+1,right);
        int k = merge(arr,left,mid,right);
        //将每次划分的小和累加起来！
        return i+j+k;
    }
    static int merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int k = 0;
        int l = left;
        int r = mid+1;
        int sum = 0;
        while(l<=mid && r<=right){
            //求小和增加的量！
            sum += arr[l]<arr[r] ? arr[l]*(right-r+1):0;
            temp[k++] = arr[l]<arr[r] ? arr[l++]:arr[r++];
        }
        while(l<=mid) temp[k++] = arr[l++];
        while(r<=right) temp[k++] = arr[r++];

        for (int i = 0; i < temp.length; i++) {
            arr[left+i] = temp[i];
        }
        return sum;
    }
}
