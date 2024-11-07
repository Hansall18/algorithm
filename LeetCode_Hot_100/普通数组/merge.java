package LeetCode_Hot_100.普通数组;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class merge {
    public static int[][] process(int[][] intervals){
        // 对每个区间按照a[0]元素进行排序
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        // 左右指针初始化为第一个区间
        int left = intervals[0][0];
        int right = intervals[0][1];
        int N = intervals.length;
        // 保存临时结果的数组res
        int[][] res = new int[N][2];
        // res的下标Index
        int Index = 0;
        for (int i = 1; i < N; i++) {
            int temp = intervals[i][0];
            // right大于a[0]元素，则表示有重叠
            if (right >= temp){
                // 更新right
                right = Math.max(right,intervals[i][1]);
            }else {
                // 反之没有重叠，更新res以及left、right
                res[Index][0] = left;
                res[Index][1] = right;
                left = temp;
                right = intervals[i][1];
                Index++;
            }
        }
        // 循环结束后，再次更新res
        res[Index][0] = left;
        res[Index][1] = right;
        Index++;
        // 复制res到最终结果s
        int[][] s = new int[Index][2];
        for (int i = 0; i < s.length; i++) {
            s[i][0] = res[i][0];
            s[i][1] = res[i][1];
        }
        return s;
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] process = process(intervals);
        for (int[] interval : process) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
