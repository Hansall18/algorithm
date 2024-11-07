package LeetCode_Hot_100.普通数组;

/**
 *给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class productExceptSelf {
    // 方法一：暴力循环
    public static int[] process(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                temp *= nums[j];
            }
            answer[i] = temp;
        }
        return answer;
    }

    // 方法二：记忆化搜索
    public static int[] process2(int[] nums){
        int n = nums.length;
        // 存放[0..i-1]乘积的pre[i]
        int[] pre = new int[n];
        // 存放[i+1..n-1]乘积的suf[i]
        int[] suf = new int[n];
        // answer[i] = pre[i] * suf[i]
        int[] answer = new int[n];
        // 初始化pre[0]和suf[n-1] == 1
        pre[0] = 1;
        suf[n-1] = 1;
        // 更新pre，用于之后的记忆搜索
        for (int i = 1; i < n; i++) {
            // pre[i-1] 表示nums[0]到nums[i-2]的乘积
            pre[i] = pre[i-1] * nums[i-1];
        }
        // 更新suf
        for (int i = n-2; i >= 0; i--) {
            suf[i] = suf[i+1] * nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = pre[i] * suf[i];
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
