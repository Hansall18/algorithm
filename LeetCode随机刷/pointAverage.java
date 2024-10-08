package LeetCode随机刷;

import java.util.Scanner;

/**
 * 每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
 *=========输入=========
 * A B C D F
 * B F F C C A
 * D C E F
 * ========输出==========
 * 2.00
 * 1.83
 * Unknown
 */
public class pointAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            process(s);
        }
    }
    public static void process(String[] s){
        float res = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("A")){
                res += 4;
            }else if (s[i].equals("B")){
                res += 3;
            }else if (s[i].equals("C")){
                res += 2;
            }else if (s[i].equals("D")){
                res += 1;
            }else if (s[i].equals("F")){
                res += 0;
            }else {
                res = -2;
            }
        }
        if (res == -2){
            System.out.println("Unknown");
        }else {
            res /= s.length;
            System.out.printf("%.2f\n",res);
        }
    }
}
