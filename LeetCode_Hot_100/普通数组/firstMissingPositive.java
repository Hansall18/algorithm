package LeetCode_Hot_100.普通数组;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 */
public class firstMissingPositive {
    // 利用数组的下标进行原地哈希
    // 即[i]的值应该为i+1
    // 要找的最小正整数一定在[1..N+1]的范围内（N为数组的长度）
    public static int firstMissingPositive(int[] nums){
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            // 每一轮while，确定该nums[i]无法在nums找到可以入住的[nums[i] - 1 ]
            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] -1);
            }
        }
        // 遍历数组，第一个遇到的nums[i] != i+1，则i+1为结果
        for (int i = 0; i < N; i++) {
            if (nums[i] == i+1){
                continue;
            }
            return i+1;
        }
        // 如果数组全部都对应上了，那么最小的正整数为N+1
        return N+1;
    }
    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public static void main(String[] args) {

    }
}
