package 笔试代码题;

import java.util.HashMap;
import java.util.Scanner;

public class queryArr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int qcount = in.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
        }
        int left = 0;
        int right = 0;
        query q = null;
        HashMap<Integer,query> map = new HashMap<>();
        for (int i = 0; i < qcount; i++) {
            left = in.nextInt();
            right = in.nextInt();
            q = new query(left,right);
            map.put(i,q);
        }
        for (int i = 0; i < qcount; i++) {
            Sum(arr,map.get(i).left,map.get(i).right);
            System.out.println();
        }
    }
    public static void Sum(int[] arr,int left,int right){
        int sum = 0;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
            if (arr[i] == 0) zeroCount++;
        }
        System.out.print(sum+zeroCount*left + " " + (sum+zeroCount*right));
    }
}
class query{
    int left;
    int right;
    public query(int left,int right){
        this.left = left;
        this.right = right;
    }
}
