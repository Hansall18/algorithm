package Hash;

import java.util.HashMap;

public class Test_hashMap {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();

        hashMap.put(1,"abc");
        hashMap.put(2,"dwadad");

        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.get(2));

        hashMap.replace(1,"dawaw");

        System.out.println(hashMap.get(1));

        hashMap.remove(1);

        System.out.println(hashMap.get(1));

    }
}
