package 笔试代码题.TencentMusic;

import java.util.HashSet;

//n件服装，每一件服装有一个编号k
//进行叠穿，要求相邻两件服装的编号之和sum为素数
//求有多少种符合要求的穿搭数
public class funDressUp {
    //在第i个位置进行选择
    public static int process(int[] num,int i){
        if(i == num.length) {
            return 1;
        }
        //记录方案数res
        int res = 0;
        //防止重复的方案
        HashSet<Integer> set = new HashSet<>();
        for (int j = i; j < num.length; j++) {
            //不重复，才继续往下个的位置选择
            if (!set.contains(num[j])){
                set.add(num[j]);
                //判断j位置的元素与j-1位置的元素之和是否为素数
                //之和不是素数，那么直接剪掉
                if (judge(num,j,i)) {
                    swap(num, i, j);
                    res += process(num, i + 1);
                    swap(num, i, j);
                }
            }
        }
        return res;
    }
    //目前要进行交换的位置j
    //要将j位置的元素交换到i位置
    public static boolean judge(int[] num,int j,int i){
        //0位置直接返回true
        if (i == 0) return true;
        int res = num[j-1]+num[j];
        for (int k = 2; k < res; k++) {
            //如果俩位置之和不是素数，返回false
            if (res%k == 0) return false;
        }
        return true;
    }
    //简单的交换元素
    public static void swap(int[] num,int i,int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    public static int funDressUp(int[] num){
        return process(num,0);
    }
    public static void main(String[] args) {
        int[] num = {1,1,2};
        System.out.println(funDressUp(num));
    }
}