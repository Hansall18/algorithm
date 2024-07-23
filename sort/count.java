package sort;

import java.util.Arrays;

public class count {
    public static void main(String[] args) {
        int[] arr = {4,1,1,6,7,7,7,9,8,11,25,23,10};

        Count(arr);

    }

    // 注意现在的这个算法是 不稳定的！
    static void Count(int[] arr) {
        //根据元素的范围选择最大数字！
        // 注意这里可以实现一个 findMax() 的方法！来找到范围的最大值！

//        int max = 25;
        int max = findMax(arr);
//        System.out.println(max);

        //建立一个范围数组用来计数！
        int[] temp = new int[max + 1];

        //统计各个数字出现的次数！
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        //建立一个原数组长度相同的数组！用来存放排好序后的数字！
        int index = 0;
        int[] sort = new int[arr.length];

        //不稳定的写法！
        //遍历temp数组，将sort数组填满！
/*        for (int i = 0; i < temp.length; i++) {
            int count = temp[i];
            while (count > 0) {
                sort[index++] = i;
                count--;
            }
        }*/


        //改进的稳定写法！
        //采用累加数组并且倒序变脸数组的方法！
        for (int i = 1; i < temp.length; i++) {
            //进行累加！
            temp[i] = temp[i] + temp[i-1];
        }
        for (int i = arr.length-1; i >= 0; i--) {
            //倒序遍历原数组！
            sort[--temp[arr[i]]] = arr[i];
        }

//        打印数组！
//        System.out.println(Arrays.toString(sort));
//        System.out.println(sort[0]);
        print(sort);
    }


    static int findMax(int[] arr){
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max<=arr[i]){
                max = arr[i];
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
