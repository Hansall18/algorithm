package LeetCode_Hot_100.普通数组;

import java.util.Arrays;

/**
 *  * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
 *  *
 *  * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  * 输出：6
 *  * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class maxSubArray {
    // 方法一：暴力循环
    public static int process(int[] nums){
        int max = Integer.MIN_VALUE;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = i; j < N; j++) {
                temp += nums[j];
                max = Math.max(max,temp);
            }
        }
        return max;
    }

    // 方法二：暴力改递归
    public static int process2(int[] nums, int Index, int max){
        if (Index >= nums.length) return max;
        int temp = 0;
        for (int i = Index; i < nums.length; i++) {
            temp += nums[i];
            max = Math.max(max,temp);
        }
        max = process2(nums,Index+1,max);
        return max;
    }

    // 方法三：动态规划
    public static int process3(int[] nums, int[] dp){
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 以nums[i]结尾的最大子数组和为dp[i]
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
