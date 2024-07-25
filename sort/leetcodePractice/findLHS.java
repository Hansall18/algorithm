package sort.leetcodePractice;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-harmonious-subsequence/submissions/549520214
 */
public class findLHS {
    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11,13,15,17};

        System.out.println(findLHS(nums));
    }
    static int findLHS(int[] nums){
        Arrays.sort(nums);//对数组进行排序！
        int max = 0;//记录最长的子序列的长度！
        int left = 0;//子序列的起点下标！
        int right = 0;//子序列的终点下标+1！
        while(left<nums.length && right<nums.length){
            if(nums[right] - nums[left] == 1 || nums[right] - nums[left] == 0){
                right++;//数值相等或者相减等于1，则右下标向右移动!
            } else if(nums[right] - nums[left] !=1 && nums[right-1] - nums[left] == 1){
                max = max>right-left ? max : right-left;//数值相差大于1且right-1的值与left相差等于1，则记录max!
                left++;//左下标向右移动！
            }else {
                max = max>right-1-left ? max : 0;//如果right-1的数值与left差值>1,则以此时left和right-1围成的子序列不构成和谐序列，长度取0！
                left++;//左下标向右移动！
            }
        }
        //循环结束后，如果最有一个元素与left构成和谐序列，则记录max！
        if(nums[right-1] - nums[left] == 1){
            max = max>right-left ? max : right-left;
        }
        return max;
    }

    //同样的思路，别人的写法！
    public int findLHS2(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        Arrays.sort(nums);

        int l = 0, r = 1, ans = 0; // 滑动窗口
        for (; l < n; l++) {
            while (r < n && nums[r] <= nums[l]+1) r++;
            if (nums[r-1] == nums[l] + 1) // 必须得校验下窗口是否有效
                ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
