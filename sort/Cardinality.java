package sort;

import java.util.Arrays;

public class Cardinality {
    public static void main(String[] args) {
        int[] arr = {421,240,115,532,305,430,324};

        //找到最大的单位数值！
        int max = findMax(arr);
        System.out.println("最大的个位数值：" + max);

        sort(arr,max);
    }

    static void sort(int[] arr,int max){
        int[] result = new int[arr.length];
        int[] count = new int[max + 1];

        //按照最大的数字的最高位次循环！
        for (int i = 0; i < 3; i++) {
            //得出每次要除以的10的次方数！
            int division = (int) Math.pow(10,i);

            for (int j = 0; j < arr.length; j++) {
                count[arr[j]/division%10]++;
            }

            //累加数组！
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j-1];
            }

            //赋值！
            for (int j = arr.length-1; j >= 0; j--) {
                result[--count[arr[j]/division%10]] = arr[j];
            }

            System.out.println(Arrays.toString(result));

            //复制result中的值给arr!
            System.arraycopy(result,0,arr,0,arr.length);

            //count数组重新置换为0！
            Arrays.fill(count,0);
        }

        System.out.println("最终结果：");
        System.out.println(Arrays.toString(arr));
    }

/*
    static int[] arrCopy(int[] result,int[] arr){
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }

        return  arr;
    }
*/

    static int findMax(int[] arr){
        int max = 0;

        for (int i = 0; i < 3; i++) {
            int division = (int) Math.pow(10,i);

            for (int j = 0; j < arr.length; j++) {
                if (max<=arr[j]/division%10){

                    max = arr[j]/division%10;

                }
            }
        }

        return max;
    }

    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
