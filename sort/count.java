package sort;

public class count {
    public static void main(String[] args) {
        int[] arr = {4,2,1,6,7,3,5,9,8,11,25,23,10};

        Count(arr);

    }

    static void Count(int[] arr){
        //根据元素的范围选择最大数字！
        int max = 25;

        //建立一个范围数组用来计数！
        int[] temp = new int[max+1];

        //统计各个数字出现的次数！
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;
        }

        //建立一个原数组长度相同的数组！用来存放排好序后的数字！
        int index = 0;
        int[] sort = new int[arr.length];

        //遍历temp数组，将sort数组填满！
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i];
            while (count>0){
                sort[index++] = i;
                count--;
            }
        }
//        System.out.println(sort[0]);
        print(sort);
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
