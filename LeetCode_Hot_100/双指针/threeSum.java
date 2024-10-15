package LeetCode_Hot_100.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */
public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 存放结果的listList
        List<List<Integer>> listList = new ArrayList<>();
        // 对数组排序
        Arrays.sort(nums);
        int N = nums.length;
        int i = 0;
        // 遍历nums
        while (i < nums.length) {
            if (nums[i] > 0) {
                // 只有nums[i]小于零才有后续，否则说明不可能再有i之后的两个数同i相加等于零（因为对nums排序了！）
                // 所以直接返回结果
                return listList;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                // nums[i] == nums[i-1]，跳过i,避免重复
                i++;
                continue;
            }
            // 每一次num[i]循环，L为i+1，R为N-1
            int L = i + 1;
            int R = N - 1;
            while (L < R) {
                // 此刻三者之和为temp
                int temp = nums[i] + nums[L] + nums[R];
                if (temp == 0) {
                    // temp等于0满足要求，将结果保存
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    listList.add(list);
                    // 在此次nums[i]循环中，避免重复的L和R
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    // 当L和R的各自下一个都不重复后，各自迭代
                    L++;
                    R--;
                } else if (temp > 0) {
                    // temp小于零，说明R大了
                    R--;
                } else {
                    // 否则说L小了
                    L++;
                }
            }
            // 迭代i
            i++;
        }
        return listList;
    }
}
