package LeetCode_Hot_100.双指针;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
public class maxArea {
    public static int process(int[] height){
        int N = height.length;
        int leftIndex = 0;
        int rightIndex = N-1;
        int area = 0;
        while (leftIndex<=rightIndex){
            // 每一次得到的临时容量temp
            int temp = (rightIndex-leftIndex)*Math.min(height[leftIndex],height[rightIndex]);
            // area为两者中较大者
            area = Math.max(area,temp);
            // 向内移动两个高度中较小的Index
            if (height[leftIndex]<=height[rightIndex]){
                leftIndex++;
            }else {
                rightIndex--;
            }
        }
        return area;
    }
}
