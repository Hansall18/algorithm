package pd;

// 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
// 求能够偷到的最高金额
public class rob {
    // 暴力递归
    public int rob(int[] nums) {
        return process(nums,0);
    }
    public static int process(int[] arr,int index){
        int max = 0;
        if(index >= arr.length){
            return max;
        }
        int p1 = arr[index]+process(arr,index+2);
        int p2 = process(arr,index+1);
        max = Math.max(p1,p2);
        return max;
    }

    // 记忆化搜索
    public static int process2(int[] arr,int index,int[] dp){
        if(index >= arr.length){
            return 0;
        }
        if (dp[index] != -1){
            return dp[index];
        }
        int p1 = arr[index]+process2(arr,index+2,dp);
        int p2 = process2(arr,index+1,dp);
        dp[index] = Math.max(p1,p2);
        return dp[index];
    }
    public int rob2(int[] nums){
        int N = nums.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        return process2(nums,0,dp);
    }

    // 动态规划
    public int rob3(int[] nums){
        int N = nums.length;
        int[] dp = new int[N+2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
        }
        for (int index = N-1; index >= 0; index--) {
            int p1 = nums[index]+dp[index+2];
            int p2 = dp[index+1];
            dp[index] = Math.max(p1,p2);
        }
        return dp[0];
    }
}
