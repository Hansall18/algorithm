package 笔试代码题.TencentMusic;


// 一个数字，奇数和偶数的数量相等，为幸运数字
// 给定r,l，求[r,l]范围内幸运数字的数量
public class luckyNum {
    //存放[r,l]范围内数字的数组arr
    public static int process(int[] arr){
        int res = 0;
        //数字为幸运数字，res++
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            if (judge(tmp)){
                res++;
            }
        }
        return res;
    }
    // 当前进行判断的数字cur
    public static boolean judge(int cur){
        String str = String.valueOf(cur);
        // 数字的位数不为偶数，返回false
        if (str.length()%2 != 0) return false;
        // 奇数个数 j
        // 偶数个数 o
        int j = 0;
        int o = 0;
        //统计奇偶个数
        for (int i = 0; i < str.length(); i++) {
            int tmp = cur%10;
            if (tmp%2 == 0){
                o++;
            }else {
                j++;
            }
            cur = cur/10;
        }
        //奇偶不相等，返回false
        if (o != j) return false;
        return true;
    }
    //数字范围[r,l]
    public static void luckyNum(int l,int r){
        //范围内数字存入数组
        int[] arr = new int[r-l+1];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = l++;
        }
        System.out.println(process(arr));
    }
    public static void main(String[] args) {
        luckyNum(8,12);
    }
}
