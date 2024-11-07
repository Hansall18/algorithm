package LeetCode_Hot_100.普通数组;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class rotate {
    // 纯逻辑数学问题
    public static void process(int[] nums, int k){
        int N = nums.length;
        int[] res = new int[N];
        int step = k%N;
        int p1 = N-step;
        int p2 = 0;
        int p = 0;
        for (int i = p1; i < N; i++) {
            res[p++] = nums[i];
        }
        for (int i = p2; i < p1; i++) {
            res[p++] = nums[i];
        }
        for (int i = 0; i < N; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        process(nums,3);
    }
}
