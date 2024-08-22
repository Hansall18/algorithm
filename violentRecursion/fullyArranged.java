package violentRecursion;

//打印字符串的全排列，要求不要重复
public class fullyArranged {
    public static void fullyArranged(String str){
        char[] chr = str.toCharArray();
        process2(0,chr);
    }
    //可以重复版本
    public static void process1(int i, char[] chr){
        if(i == chr.length){
            System.out.println(String.valueOf(chr));
            return;
        }
        //[..i-1]的区域不用看，已经选好
        //当前需要选择的位置i
        //i位置可以有[i..length-1]个选择
        for (int j = i; j < chr.length; j++) {
            //将每一个可选的值换到i位置
            swap(chr,i,j);
            process1(i+1,chr);
            //子流程走完后，把值换回来
            swap(chr,i,j);
        }
    }
    //不可以重复版本
    public static void process2(int i, char[] chr){
        if(i == chr.length){
            System.out.println(String.valueOf(chr));
            return;
        }
        //记录小写字母是否被选择过isValid
        boolean[] isValid = new boolean[26];
        //[..i-1]的区域不用看，已经选好
        //当前需要选择的位置i
        //i位置可以有[i..length-1]个选择
        for (int j = i; j < chr.length; j++) {
            //交换的值不同，进入子流程
            //交换的值相同，退出此循环，即保证不重复
            if (!isValid[chr[j]-'a']){
                isValid[chr[j]-'a'] = true;
                //将每一个可选的值换到i位置
                swap(chr,i,j);
                process2(i+1,chr);
                //子流程走完后，把值换回来
                swap(chr,i,j);
            }
        }
    }
    public static void swap(char[] chr,int i, int j){
        char tmp = chr[i];
        chr[i] = chr[j];
        chr[j] = tmp;
    }
    public static void main(String[] args) {
        String str = "abac";
        fullyArranged(str);
    }
}
