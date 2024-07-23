package 面试代码题.网易;

import java.util.Arrays;

/**
 * 几个小朋友围成一个圈进行座位
 * 得分相同的相邻两个小朋友分多少糖果无所谓！
 * 但是相邻得分高的一定要比得分低的得到的糖果要多！
 *
 * 要求得出最少的糖果总数？
 */
public class DivideSweets {
    public static void main(String[] args) {
        int[] arr = {3,1,4,5,5,9,2,7};
        int[] newArr = createArr(arr);
        Solution(newArr);
    }

    static int[] createArr(int[] arr){

        //创建新的数组存放置换后的数值！
        int[] newArr = new int[arr.length+1];

        //表示找到的局部最小值！
        int min = -1;

        for (int i = 1; i < arr.length-1; i++) {
            if(arr[i-1]>=arr[i] && arr[i+1]>=arr[i]){
                min = arr[i];
                break;
            }
        }
        if(min == -1){
            if(arr[arr.length-1]>= arr[0] && arr[1]>=arr[0]){
                min = arr[0];
            }else {
                min = arr[arr.length-1];
            }
        }
//        System.out.println(min);

        //将找到的最小值放到新数组的头部和尾部！
        newArr[0] = min;
        newArr[newArr.length-1] = min;

        //表示新数组的下标！
        int k = 1;

        //将原来数组的内容按顺序排到新数组中！
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == min) continue;
            newArr[k++] = arr[i];
        }

//        print(newArr);
//        System.out.println();

        return newArr;
    }

    static void Solution(int[] arr){
        //定义左右坡的数组！
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        //左坡的第一个位置糖果数为1
        left[0] = 1;
        //右坡的最后一个位置糖果数为1
        right[arr.length-1] = 1;

        //填充左坡数组！
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<=arr[i-1]){
                left[i] = 1;
            }else {
                left[i] = left[i-1]+1;
            }
        }

//        print(left);
//        System.out.println();

        //填充右坡数组！
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i]<=arr[i+1]){
                right[i] = 1;
            }else {
                right[i] = right[i+1]+1;
            }
        }

//        print(right);
//        System.out.println();

        int sum = 0;
        //累加糖果数！
        for (int i = 0; i < left.length; i++) {
            if(left[i]<=right[i]){
                sum += right[i];
            }else {
                sum += left[i];
            }
        }

        //sum-1是为了减掉多出来的一个局部最小值分到的糖果！
        System.out.println(sum-1);

    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
