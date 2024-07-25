package sort.leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * leetcode 排序题库中的 350.两个数组的交集II
 */
public class intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};

        int[] res = solution(nums1,nums2);

        System.out.println(Arrays.toString(res));
    }
    static int[] solution(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = 0;

        while(left<nums1.length && right<nums2.length){
            if(nums1[left]<nums2[right]){
                left++;
            }else if (nums1[left]>nums2[right]){
                right++;
            }else {
                list.add(nums1[left++]);
                right++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
