package violentRecursion;

//装载最大价值
//给定 重量数组w[],价值数组v[],限重bag
//求出weight之和不超过bag的最大价值
public class MaxValue {
    //选择i位置物品是否加入
    //当前重量currentWeight
    //当前价值currentValue
    public static int process(
            int[] w,int[] v,int i,
            int bag,int currentValue, int currentWeight)
    {
        if (w.length == 0) return 0;
        if (i == w.length) return currentValue;
        int value1 = 0;
        //如果不超过容量，选择第i块物品
        if (currentValue+w[i] <= bag){
            value1 = process(w,v,i+1,bag,currentValue+v[i],currentWeight+w[i]);
        }
        //不选择第i块物品
        int value2 = process(w,v,i+1,bag,currentValue,currentWeight);
        //返回两个选取方式的最大值
        return Math.max(value1,value2);
    }
    public static int MaxValue(int[] w,int[] v, int bag){
        return process(w,v,0,bag,0,0);
    }
    public static void main(String[] args) {
        int[] w = {2,3,100};
        int[] v = {5,10,20};
        int bag = 100;
        System.out.println(MaxValue(w,v,bag));
    }
}
