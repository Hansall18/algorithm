package violentRecursion;

//打印一个字符串的子串，包含空字符串
public class printAllSubsquence {
    public static void process(char[] chr,int i){
        if( i == chr.length){
            System.out.println(String.valueOf(chr));
            return;
        }
        //选择第i个
        process(chr,i+1);
        //不选择第i个
        char tmp = chr[i];
        chr[i] = 0;
        process(chr,i+1);
        chr[i] = tmp;
    }
    public static void printAllSubsquence(String str){
        char[] chr = str.toCharArray();
        process(chr,0);
    }
    public static void main(String[] args) {
        String str = "abc";
        printAllSubsquence(str);
    }
}
