package LeetCode_Hot_100.滑动窗口;

import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class lengthOfLongestSubstring {
    public static int process(String s){
        int N = s.length();
        // 保存窗口内的字符window
        HashSet<Character> window = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < N){
            char c = s.charAt(right);
            right++;
            if (!window.contains(c)){
                // window内没有字符c，则进行添加
                window.add(c);
            }else {
                // 直到window内存在重复字符c，那么保存当前window.size()与max之间的较大者为max
                max =Math.max(max, window.size());
                // left++不断缩小窗口，直到window内没有字符c
                while (window.contains(c)){
                    // 缩小窗口时，不断删除window内的字符
                    window.remove(s.charAt(left++));
                }
                // 确保window内没有字符c后，再把当前的字符c重新添加上去
                window.add(c);
            }
        }
        max = Math.max(max,window.size());
        return max;
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(process(s));
    }
}
