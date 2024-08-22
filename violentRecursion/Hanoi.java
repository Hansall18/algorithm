package violentRecursion;

//三根柱子，左中右，要将左边的盘子全都按大的在下方的顺序，转移到中间的柱子
public class Hanoi {
    public static void hanoi(int n){
        if(n>0){
            process(n,"左","中","右");
        }
    }
    public static void process(int i,String from,String to,String other){
        if(i == 1) {
            System.out.println("mv" + i + "from" + from + "to" + to);
        }else {
            process(i - 1, from, other, to);
            System.out.println("mv" + i + "from" + from + "to" + to);
            process(i - 1, other, to, from);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        hanoi(3);
    }
}



