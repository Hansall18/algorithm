package 笔试代码题.TencentMusic;

//一个仅由字母 'r'、'e' 和 'd' 组成的字符串
//所有的 'r' 变成 'e'，'e' 变成 'd'，'d' 变成 'r'
public class strChange {
    //当前在第i个位置进行转换
    public static void process(char[] chr,int i){
        if (i == chr.length) return;
        if (chr[i] == 'r') {
            chr[i] = 'e';
            process(chr,i+1);
        }else if (chr[i] == 'e') {
            chr[i] = 'd';
            process(chr,i+1);
        }else if (chr[i] == 'd') {
            chr[i] = 'r';
            process(chr,i+1);
        }
    }
    public static void strChange(String str){
        char[] chr = str.toCharArray();
        process(chr,0);
        System.out.println(String.valueOf(chr));
    }
    public static void main(String[] args) {
        String str = "rredd";
        strChange(str);
    }
}