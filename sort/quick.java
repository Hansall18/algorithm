package sort;

import com.sun.scenario.effect.Brightpass;

public class quick {
    public static void main(String[] args) {
        int[] arr = {4,2,1,6,7,3,5,9,8,11,25,23,10};

        sort(arr,0,arr.length-1);

        print(arr);
    }

    static void sort(int[] arr,int left,int right){
        if(left == right) {
//            System.out.println("l ==  r");
            return;
        }

        int mid = quick(arr,left,right);
//        System.out.println(mid);
        sort(arr,left,mid-1);
//        System.out.println(right);
        sort(arr,mid,right);
    }

    static int quick(int[] arr,int left,int right){

        int temp = arr[right];

        int i = left;
        int j = right-1;

        while (i<=j){
            while (i<=j && arr[i]<=temp) i++;
            while (i<=j && arr[j]>temp) j--;

            if(i<=j) swap(arr,i,j);
        }
//        print(arr);
//        System.out.println();

        swap(arr,i,right);
//        print(arr);
//        System.out.println();
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
