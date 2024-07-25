package sort.leetcodePractice;

import java.util.Arrays;
import java.util.HashMap;

public class fairCandySwap {
    public static void main(String[] args) {
        int[] a = {35,17,4,24,10};
        int[] b = {63,21};
        System.out.println(Arrays.toString(fairCandySwap(a, b)));
    }
    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes){
        int[] answer = new int[2];
        int aliceCount = Arrays.stream(aliceSizes).sum();
        int bobCount = Arrays.stream(bobSizes).sum();
        int k = (aliceCount-bobCount)/2;
        Arrays.sort(bobSizes);
        for (int i = 0; i < aliceSizes.length; i++) {
            int dest = aliceSizes[i]-k;
            int left = 0;
            int right = bobSizes.length-1;
            while (left>=0 && right<=bobSizes.length-1 && left<=right){
                int mid = left+(right-left)/2;
                if(bobSizes[mid]<dest){
                    left = mid+1;
                }else if(bobSizes[mid]>dest){
                    right = mid-1;
                }else {
                    answer[0] = aliceSizes[i];
                    answer[1] = bobSizes[mid];
                    break;
                }
            }
        }
        HashMap<Integer,int[]> map = new HashMap<>();
        return answer;
    }
}
