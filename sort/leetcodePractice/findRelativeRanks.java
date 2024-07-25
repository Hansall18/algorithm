package sort.leetcodePractice;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.cn/problems/relative-ranks/solutions/2855845/yu-shi-bu-jue-xian-pai-xu-by-i2ecursing-e5my3
 */
public class findRelativeRanks {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
    static String[] findRelativeRanks(int[] score){
        int[] temp = new int[score.length];
        String[] answer = new String[score.length];
        System.arraycopy(score,0,temp,0,score.length);
        Arrays.sort(temp);

        HashMap<Integer,String> map = new HashMap<>();
        for (int i = temp.length-1; i >= 0 ; i--) {
            if(i == temp.length-1) {map.put(temp[i],"Gold Medal");continue;}
            if(i == temp.length-2) {map.put(temp[i],"Silver Medal");continue;}
            if(i == temp.length-3) {map.put(temp[i],"Bronze Medal");continue;}

            map.put(temp[i],String.valueOf(temp.length-i));
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(score[i]);
        }
        return answer;
    }
}
