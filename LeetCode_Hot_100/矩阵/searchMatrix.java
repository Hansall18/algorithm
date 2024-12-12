package LeetCode_Hot_100.矩阵;

/**
 *编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 */
public class searchMatrix {
    // 方法一：暴力
    public static boolean process(int[][] matrix, int target){
        int row = matrix.length;
        int col = matrix[0].length;
        boolean res = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == target){
                    res = true;
                    return res;
                }
            }
        }
        return res;
    }


    // 方法二：二分查找
    public static boolean process2(int[][] matrix, int target){
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) break;
            if (matrix[i][matrix[i].length-1] < target) continue;
            int col = binarySearch(matrix[i], target);
            if (col != -1){
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        while (start<=end){
            int mid = (start+end) >>> 1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }

        }
        return -1;
    }
}
