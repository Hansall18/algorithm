package LeetCode_Hot_100.子串;

import java.util.HashMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 */
public class minWindow {
    public static String process(String s,String t){
        // 记录窗口中符合要求的key及其数量的map：window
        HashMap<Character,Integer> window = new HashMap<>();
        // 记录目标子串的key及其数量的map：need
        HashMap<Character,Integer> need = new HashMap<>();
        int left = 0;
        int right = 0;
        // 记录window中key.value == need.value的数量
        int valid = 0;
        // 记录最小覆盖子串的起始索引start
        int start = 0;
        // 记录最小覆盖子串的长度len
        int len = Integer.MAX_VALUE;
        // 初始化need
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c,need.getOrDefault(c,0) + 1);
        }
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            while (valid == need.size()) {
                // 更新最小覆盖子串的start和len
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char k = s.charAt(left);
                left++;
                if (need.containsKey(k)) {
                    if (window.get(k).equals(need.get(k))){
                        valid--;
                    }
                    window.put(k, window.get(k) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
