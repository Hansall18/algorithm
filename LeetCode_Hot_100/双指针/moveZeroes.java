package LeetCode_Hot_100.双指针;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 */
public class moveZeroes {
    // 垃圾写法
    // 给定的数组nums
    public static void moveZeroes2(int[] nums){
        int N = nums.length;
        // 当前零数值的下标zeroIndex,初始化为0
        int zeroIndex = 0;
        // 当前非零数值的下标NotZeroIndex,初始化为0
        int NotZeroIndex = 0;
        while (zeroIndex < N && NotZeroIndex < N){
            // 找到依次遇到的零数值
            while (zeroIndex < N){
                if (nums[zeroIndex] != 0) {
                    zeroIndex++;
                }else {
                    break;
                }
            }
            // 找到依次遇到的非零数值
            while (NotZeroIndex < N){
                if (nums[NotZeroIndex] == 0){
                    NotZeroIndex++;
                }else {
                    break;
                }
            }
            if (zeroIndex < N && NotZeroIndex < N) {
                if (zeroIndex < NotZeroIndex){
                    // 零数值位置在非零数值位置前方，才进行交换
                    swap(nums, zeroIndex, NotZeroIndex);
                    zeroIndex++;
                    NotZeroIndex++;
                }else {
                    // 否则说明非零数值已经在0前方，非零下标自增继续寻找下一个非零位置
                    NotZeroIndex++;
                }
            }
        }
    }
    // 取巧写法
    public static void moveZeroes(int[] nums){
        int N = nums.length;
        // 当前需要复制的非零数值下标fastIndex
        int fastIndex = 0;
        // slowIndex下标左边表示排好序的序列
        int slowIndex = 0;
        while (fastIndex<N){
            // 依次找到非零数值下标fastIndex
            while (fastIndex<N && nums[fastIndex] == 0){
                fastIndex++;
            }
            if (fastIndex<N) {
                // 将nums[fastIndex]的值复制到nums[slowIndex]
                nums[slowIndex++] = nums[fastIndex++];
            }
        }
        if (slowIndex<N){
            // nums[slowIndex..N-1]区间没有尚未复制的非零数值，将后续区间值都置为0即可
            for (int i = slowIndex; i < N; i++) {
                nums[i] = 0;
            }
        }
    }
    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
