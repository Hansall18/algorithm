package LeetCode_Hot_100.滑动窗口;

import java.util.HashMap;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列.如果是，返回 true ；否则，返回 false 。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 *
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 */
public class checkInclusion {

    public static boolean process(String s1,String s2) {
        int N = s2.length();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int valid = 0;
        int left = 0;
        int right = 0;
        boolean tag = false;
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        while (right < N) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (right - left == s1.length()) {
                char p = s2.charAt(left);
                left++;
                if (valid == need.size()) {
                    tag = true;
                    return tag;
                }
                if (need.containsKey(p)){
                    if (window.get(p).equals(need.get(p))) {
                        valid--;
                    }
                    window.put(p, window.getOrDefault(p, 0) - 1);
                }
            }
        }
        return tag;
    }

    public static void main(String[] args) {

    }
}
