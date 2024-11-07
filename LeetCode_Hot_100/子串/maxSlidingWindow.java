package LeetCode_Hot_100.子串;

import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回 滑动窗口中的最大值 。
 *
 *输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class maxSlidingWindow {
    // 方法一：暴力循环
    public static int[] process(int[] nums,int k){
        int[] res = new int[nums.length+1-k];
        int left = 0;
        int right = k-1;
        int index = 0;
        while (right < nums.length){
            int max = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                max = Math.max(max,nums[i]);
            }
            res[index++] = max;
            left++;
            right++;
        }
        return res;
    }

    // 方法二：双向队列
    public static int[] process2(int[] nums,int k){
        int N = nums.length;
        // 存放窗口中值为nums[i]的下标i的队列queue
        // 这个队列需要按照nums[i]从大到小的顺序存放对应的下标i
        LinkedList<Integer> queue = new LinkedList<>();
        // 存放结果的数组res
        int[] res = new int[N+1-k];
        for (int i = 0; i < N; i++) {
            // 当前队列中的队尾值j所对应的nums[j]小于当前nums[i]
            // 那么弹出队尾元素，直到新的队尾元素的nums[]大于当前nums[i]
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 满足上述条件后，将下标i添加到队尾
            queue.add(i);
            // i-k大于等于目前队列队首的nums[]值，说明当前队首值j不在窗口内了
            // 所以把队首弹出
            if (i-k >= queue.peekFirst()){
                queue.pollFirst();
            }
            // 每次窗口移动后，将队首值j对应的nums[j]存放到res中
            if (i+1 >= k){
                res[i+1-k] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
