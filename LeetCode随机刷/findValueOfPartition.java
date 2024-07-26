package LeetCode随机刷;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-value-of-the-partition/submissions/549929581
 */
public class findValueOfPartition {
    static int findValueOfPartition(int[] nums){
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<nums.length;i++){
            min = Math.min(min,nums[i]-nums[i-1]);
        }
        return min;
    }
}
