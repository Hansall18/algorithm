package sort;

public class quick {
    public static void main(String[] args) {
        int[] arr = {4,2,1,6,7,3,5,9,8,11,25,23,10};
        sort(arr,0,arr.length-1);
        print(arr);
    }
    static void sort(int[] arr,int left,int right){
        if(left >= right) {
            return;
        }
        int mid = quick(arr,left,right);
        sort(arr,left,mid-1);
        sort(arr,mid,right);
    }
    //[left,right]之间进行进行左右分类
    //返回基准的坐标
    static int quick(int[] arr,int left,int right){
        //取arr[right]的值作为基准
        int temp = arr[right];
        //左右指针i,j
        int i = left;
        int j = right-1;
        while (i<=j){
            while (i<=j && arr[i]<=temp) i++;
            while (i<=j && arr[j]>temp) j--;
            //找到小于和大于的俩数，进行交换
            if(i<=j) swap(arr,i,j);
        }
        //将基准放到中间位置
        swap(arr,i,right);
        return i;
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
