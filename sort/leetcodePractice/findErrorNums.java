package sort.leetcodePractice;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/set-mismatch/solutions/2856832/cai-ji-de-shou-ci-bai-fen-bai-by-i2ecurs-dmfe
 */
public class findErrorNums {
    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
    static int[] findErrorNums(int[] nums){
        int[] count = new int[nums.length+1];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
//        System.out.println(Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            if(count[i] == 2) {
//                System.out.println(i+":"+count[i]);
                res[0] = i;
            }
            if(count[i] == 0) {
//                System.out.println(i+":"+count[i]);
                res[1] = i;
            }
        }
        return res;
    }
}
