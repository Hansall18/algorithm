package sort.leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-product-of-three-numbers/solutions/567309/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb
 */
public class maximumProduct {
    static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);

    }

}
