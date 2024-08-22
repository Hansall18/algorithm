package 笔试代码题.TencentMusic;

import java.util.ArrayList;
import java.util.List;

//给定[i..j]
//求出全排列
public class allArrange {
    //当前在第i个位置进行交换
    public static void allArrange(int[] nums,int i,List<List<Integer>> res){
        List<Integer> list = new ArrayList<>();
        if (i == nums.length){
            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j]);
            }
            res.add(list);
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums,i,j);
            allArrange(nums,i+1,res);
            swap(nums,i,j);
        }
    }
    public static void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        allArrange(nums,0,res);
        return res;
    }
}
