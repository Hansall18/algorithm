package sort;

public class merge {
    public static void main(String[] args) {
        int[] arr = {4,2,1,6,7,3,5,9,8,11,25,23,10};

        sort(arr,0,arr.length-1);

        print(arr);
    }

    static void sort(int[] arr,int left,int rightBound){
        //数组个数为1直接返回！
        if(left == rightBound)return;
        int right = left+(rightBound-left)/2;

        //从中间分开，左右两个数组分别排序！
        sort(arr,left,right);
        sort(arr,right+1,rightBound);

        //两个排好序的数组，进行合并！
        mergesort(arr,left,right+1,rightBound);
    }

    static void mergesort(int[] arr,int left,int right, int rightBound){

        //复制一个等长的数组！
        int[] temp = new int[rightBound-left+1];

        //表示temp数组的下标！
        int k = 0;

        //定义元素组两半的指针！

        int i = left;//左边数组的第一个位置！
        int j = right;//右边数组的第一个位置！
        int side = rightBound;//右边数组的最有一个位置！

        while (i<right && j<=side){
            //判断并且依次有序的放入temp数组！

            while (i<right && arr[i]<=arr[j]) temp[k++] = arr[i++];

//            System.out.println("i 的坐标" + i);
//            print(temp);
//            System.out.println();

            while (j<=side && arr[j]<arr[i]) temp[k++] = arr[j++];

//            System.out.println("j 的坐标" + j);
//            print(temp);
//            System.out.println();
        }

        //处理多出来的部分数组，直接放在temp的后面！
        if(i<right){
            while (i<right) temp[k++] = arr[i++];
        }else {
            while (j<=side) temp[k++] = arr[j++];
        }
//        System.out.println("i 的最终坐标: " +i);
//        System.out.println("j 的最终坐标: " +j);
//        print(temp);


        //将temp数组中的元素复制到原来的arr中！
        for (int l = 0; l < temp.length; l++) {
            arr[left++] = temp[l];
        }


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
