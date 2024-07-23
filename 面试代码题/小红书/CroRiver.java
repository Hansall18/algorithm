package 面试代码题.小红书;

/**
 * 过一条河，有一些石头，红色和蓝色还有无色
 * 无色的石头可以改变颜色！
 * 最终所有的石头都要有颜色，且红色和蓝色的石头数量相等，才能过河！
 *
 * [0,5,3] ==> 0表示是石头原来无色，变成红色代价为5，变成蓝色代码为3！
 * [1,x,x] ==> 1表示石头为红色，不得再改变颜色！
 * [2,x,x] ==> 2表示石头为蓝色，不得再改变颜色！
 *
 * 要求出 最小通过河流的代价是多少？
 */
public class CroRiver {
    public static void main(String[] args) {
        int[][] arr ={
                {0,4,6},
                {0,3,1},
                {0,1,5},
                {0,6,3},
                {1,9,9},
                {2,9,9}
        };

    }

//    static void solution(int[][] arr){
//        int count = 5;
//
//        int redCount  = 0;
//        int blueCount = 0;
//
//        for (int i = 0; i < 5; i++) {
//            if (arr[0] == 1) redCount++;
//            if (arr[0] == 2) blueCount++;
//        }
//    }
}
