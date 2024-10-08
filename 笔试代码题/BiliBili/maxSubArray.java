package 笔试代码题.BiliBili;

// 给定数组[],找出最大的子数组和输出
public class maxSubArray {
    public  int maxSubArray(int[] nums){
        return process(nums,0);
    }
    // 暴力递归
    public int process(int[] nums,int i){
        if (i == nums.length) return Integer.MIN_VALUE;
        int tmp = 0;
        int max = nums[i];
        for (int j = i; j < nums.length; j++) {
            tmp += nums[j];
            max = Math.max(max,tmp);
        }
        max = Math.max(max,process(nums,i+1));
        return max;
    }

    // 记忆化搜索
    public int maxSubArray2(int[] nums){
        int N = nums.length;
        int[] dp = new  int[N];
        dp[N-1] = nums[N-1];
        for (int i = 0; i < N-1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        return process2(nums,0,dp);
    }
    public int process2(int[] nums,int i,int[] dp){
        if (i == nums.length) return Integer.MIN_VALUE;
        if (dp[i] != Integer.MIN_VALUE) return dp[i];
        int tmp = 0;
        int max = nums[i];
        for (int j = i; j < nums.length; j++) {
            tmp += nums[j];
            max = Math.max(max,tmp);
        }
        dp[i] = Math.max(max,process2(nums,i+1,dp));
        return dp[i];
    }

}
