package LeetCode_Hot_100.子串;

import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。子数组是数组中元素的连续非空序列。
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
public class subarraySum {
    // 方法一：暴力循环
    public static int process(int[] nums, int k){
        int coun = 0;
        for(int i = 0;i<nums.length;i++){
            int temp = 0;
            for(int j = i;j<nums.length;j++){
                temp += nums[j];
                if (temp == k){
                    coun++;
                }
            }
        }
        return coun;
    }
    // 方法二：前缀和 + 哈希表
    public static int process2(int[] nums, int k){
        // 存放从[0..i]位置的前缀和Key，个数为Value
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int temp = 0;
        int res = 0;
        // 前缀和为0的个数初始化为1
        hashMap.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            // presum[j] - presum[i] = k 则找到符合条件的子数组
            // 因此temp - k 在map存在表示 找到一个presum符合条件
            if (hashMap.containsKey(temp-k)) {
                res += hashMap.get(temp - k);
            }
            hashMap.put(temp,hashMap.getOrDefault(temp,0) + 1);
        }
        return res;
    }
}
