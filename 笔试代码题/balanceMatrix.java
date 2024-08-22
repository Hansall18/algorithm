package 笔试代码题;

import java.util.Scanner;

public class balanceMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 读取矩阵的行数
        int rows = in.nextInt();
        int[][] matrix = new int[rows][rows]; // 初始化二维数组，列数稍后确定
        // 读取每一行并转换
        for (int i = 0; i < rows; i++) {
            String line = in.next();
            // 将字符串转换为整型数组
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j) - '0'; // 字符'0'和'1'与整数0和1之间的转换
            }
        }
        for (int i = 1; i <= rows; i++) {
            System.out.println(traverse(matrix,i));
        }
    }
    public static int traverse(int[][] arr,int len){
        int count = 0;
        if(len%2 != 0) return count;
        for (int y = 0; y <= arr.length-len; y++) {
            for (int x = 0; x <= arr.length-len; x++) {
                boolean b = isBalance(arr,x,x+len-1,y,y+len-1,len);
                if (b) count++;
            }
        }
        return count;
    }
    public static boolean isBalance(int[][] arr,int xStart,int xEnd,int yStart,int yEnd,int len){
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if(arr[i][j] == 0) zeroCount++;
                if(arr[i][j] == 1) oneCount++;
                if (zeroCount > len*len/2 || oneCount > len*len/2) return false;
            }
        }
        return true;
    }
}
