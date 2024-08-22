package violentRecursion;

//左右抽牌，在[...]中，一次只能从左右边缘抽牌
//有一个先抽，一个后抽
//问最后赢得一方的分数
public class leftAndRightCards {
    //先手函数
    //在[l,r]的范围内进行左右选择
    public static int P(int[] arr,int l,int r){
        if (l == r) return arr[l];
        return Math.max(
            arr[l] + S(arr,l+1,r),
            arr[r] + S(arr,l,r-1)
        );
    }
    //后手函数
    public static int S(int[] arr,int l,int r){
        if (l == r) return 0;
        return Math.min(
            P(arr,l+1,r),
            P(arr,l,r-1)
        );
    }
    public static int process(int[] arr){
        return P(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,100,4};
        System.out.println(process(arr));
    }
}
