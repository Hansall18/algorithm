package LeetCode_Hot_100.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class spiralOrder {
    public static List<Integer> process(int[][] matrix){
        // 定义四个边界 l、r、t、b
        int l = 0;
        int r = matrix[0].length-1;
        int t = 0;
        int b = matrix.length-1;
        // 保存结果的 res
        ArrayList<Integer> res = new ArrayList<>();
        // 螺旋遍历
        while (true){
            // 从左往右遍历
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            // t边界大于b，说明接下来的一行已经遍历过了
            if (++t > b) break;
            // 从上往下遍历
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l) break;
            // 从右往左遍历
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            if (--b < t) break;
            // 从下往上遍历
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return res;
    }
}
