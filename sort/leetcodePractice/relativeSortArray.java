package sort.leetcodePractice;

import java.util.Arrays;

public class relativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
    static int[] relativeSortArray(int[] arr1,int[] arr2){
        int[] res = new int[arr1.length];
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr1[j] == arr2[i]){
                    res[k++] = arr1[j];
                    arr1[j] = -1;
                }
            }
        }
        Arrays.sort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != -1){
                res[k++] = arr1[i];
            }
        }
        return res;    }
}
