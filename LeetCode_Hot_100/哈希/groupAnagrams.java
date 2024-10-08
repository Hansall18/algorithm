package LeetCode_Hot_100.哈希;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */

public class groupAnagrams {
    // 要进行判断的字符串str
    // 存放List<String>的hashMap
    public static void process(String str, HashMap<String, List<String>> hashMap){
        char[] chars = str.toCharArray();
        // 将转化后的数组进行排序，按照字母排序的顺序确保<相同字母组成但是不同顺序的str>形成统一的字符串
        Arrays.sort(chars);
        // 将排序后的数组转化为字符串，将此字符串作为hashMap的Key
        String bk = String.valueOf(chars);
        if (hashMap.containsKey(bk)){
            // map中存在bk，将该value拿出来添加上str
            List<String> list = hashMap.get(bk);
            list.add(str);
            // 更新map中的key
            hashMap.put(bk,list);
        }else {
            // map中不存在key，创建一个新List，将str添加到该List
            List<String> temp = new ArrayList<>();
            temp.add(str);
            // map中添加该List，并且以bk作为Key
            hashMap.put(bk,temp);
        }
    }
    // 给定的字符串数组strs
    public static List<List<String>> groupAnagrams(String[] strs){
        // 保存结果的res
        List<List<String>> res = new ArrayList<>();
        // 存储List<String>的hashMap
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 遍历strs，依次调用process方法将map更新完成
            process(strs[i],hashMap);
        }
        for (List<String> temp: hashMap.values()) {
            // 遍历map，将value添加到res
            res.add(temp);
        }
        return res;
    }
}
