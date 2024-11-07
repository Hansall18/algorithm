package LeetCode_Hot_100.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class findAnagrams {
    // 字符串s转化成char[] s
    // 字符串p转化成char[] p
    public static List<Integer> process(char[] s,char[] p){
        int N = p.length;
        // 滑动窗口的两个边界指针left、right
        int left = 0;
        int right = 0;
        // 保存目标字符串的字符以及个数的map：need
        // 保存滑动窗口内符合need的字符以及个数的map：window
        HashMap<Character,Integer> need = new HashMap<>(N);
        HashMap<Character,Integer> window = new HashMap<>(N);
        // 保存结果的list
        List<Integer> list = new ArrayList<>();
        // 记录window内字符达到need要求的数量valid
        // 只有当window中某一个字符以及对应的个数与need中的相等，valid才会+1
        int valid = 0;
        // 遍历目标p，初始化need
        for(char c : p){
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        // 向右移动right，增大窗口
        while (right < s.length){
            // 当前right位置的字符c
            char c = s[right];
            if (need.containsKey(c)){
                // c字符 是 need内的字符，更新window中的c字符及其数量+1
                window.put(c, window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))){
                    // window中c字符数量与need中c字符数量相等，说明c字符达到要求，valid+1
                    valid++;
                }
            }
            // 扩大窗口
            right++;
            // 判断是否需要缩小窗口
            while (right-left == N){
                if (valid == need.size()){
                    // 窗口长度与目标字符串长度相等，valid与need.size()相等
                    // 说明该窗口内的字符串符合要求，添加left左边到list中
                    list.add(left);
                }
                // 当前left位置的字符d
                char d = s[left];
                if (need.containsKey(d)){
                    // d字符 是 need 内的字符，并且window内d字符数量达到need要求，那么valid-1
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    // 无论window内d字符是否达到need要求，数量都-1
                    window.put(d,window.get(d)-1);
                }
                // 缩小窗口
                left++;
            }
        }
        return list;
    }
    public static List<Integer> findAnagrams(String s,String p){
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        return process(sc,pc);
    }
    public static void main(String[] args) {
        String s = "baa";
        String p = "aa";
        System.out.println(findAnagrams(s, p));
    }
}
