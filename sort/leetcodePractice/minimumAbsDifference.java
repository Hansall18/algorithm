package sort.leetcodePractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-absolute-difference/solutions/1641099/zui-xiao-jue-dui-chai-by-leetcode-soluti-7g0e
 */
public class minimumAbsDifference {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(minimumAbsDifference(arr).toString());
    }
    static List<List<Integer>> minimumAbsDifference(int[] arr){
        int absoluteDifference = findMinDifference(arr);
        ArrayList<List<Integer>> list = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]-arr[i-1] == absoluteDifference){
                ArrayList<Integer> list2 = new ArrayList<>();
                list2.add(arr[i-1]);
                list2.add(arr[i]);
                list.add(list2);
            }
        }
        return list;
    }
    static int findMinDifference(int[] arr){
        Arrays.sort(arr);
        int absoluteDifference = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i]-arr[i-1];
            absoluteDifference = absoluteDifference>k ? k:absoluteDifference;
        }
        return absoluteDifference;
    }

}
