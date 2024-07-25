package sort.leetcodePractice;

import com.sun.crypto.provider.RSACipher;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/find-the-difference/submissions/549318211
 */
public class findTheDifference {
    static char findTheDifference(String s,String t){
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        for (int i = 0; i < sc.length; i++) {
            if(sc!=null && sc[i] != tc[i]){
                return sc[i]>tc[i] ? sc[i]:tc[i];
            }
        }
        return tc[tc.length-1];
    }
}
