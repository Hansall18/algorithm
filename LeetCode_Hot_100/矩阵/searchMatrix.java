package LeetCode_Hot_100.矩阵;

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


    public static void main(String[] args) {

    }
}
