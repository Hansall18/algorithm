package 面试代码题.腾讯;

import java.util.Arrays;

/**
 * 给定一群人的体重，以及船只的限重
 * 可以一个人或者两个人一艘船
 * 两个一艘船的前提是： 体重之和不超过限重！ 奇偶数体重不能再一艘船！
 *
 * 要求出最少的船只数量！
 */
public class LessBoats {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,4,1,7,5,3,8,8,9,10};

        Solution(arr);
    }

    static void Solution(int[] arr){
        //先对数组进行排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        //定义两个指针表示配对的左右人员的下标！
        //left表示左边的最大下标！
        //right表示右边的最小下标！
        int left = arr.length/2-1;
        int right = arr.length/2;

        //定义最小船只数！
        int count = 0;

        //定义temp指针表示每一轮left的初始位置！
        int temp = -1;

        while (left>=0 && right<arr.length){
            //每一轮开始之前将left的初始位置赋值给temp！
            temp = left;

            //左边最大不能匹配，left下标递减！
            while (left>=0 && right<arr.length && arr[left]+arr[right]>10) {
                left--;
            }

            //计算左边未能匹配的人员所需要的船只数量！
            if(left>=0){
                count += (temp-left)/2 + (temp-left)%2;
            }

            //计算左右两边可以配对的船只数量！
            while (right<arr.length && left>=0 && arr[right]+arr[left]<=10) {
                right++;
                left--;
                count++;
            }

        }

        //最后计算左边或者右边剩下的人员所需要的船只数量！
        if(left>=0){
            count += (left-0)/2 + (left-0)%2;
        }else if(right<arr.length){
            count += arr.length-right;
        }

        System.out.println(count);
    }
}
