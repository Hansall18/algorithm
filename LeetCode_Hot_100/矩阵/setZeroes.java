package LeetCode_Hot_100.矩阵;

import java.util.HashSet;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 */
public class setZeroes {
    // 1、暴力
    public static void setZeroes(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        // 记录matrix中值为0的x坐标的Set：row_zero
        HashSet<Integer> row_zero = new HashSet<>();
        // 记录matrix中值为0的y坐标的Set：col_zero
        HashSet<Integer> col_zero = new HashSet<>();
        // 遍历matrix，更新row_zero 和 col_zero
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // row_zero中存在i，说明该位置是在目标的同一行上，将值置为0
                // col_zero中存在j，说明该位置是在目标的同一列上，将值置为0
                if (row_zero.contains(i) || col_zero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}
