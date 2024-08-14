package Hash;

import java.util.HashSet;

public class Test_hashSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("231312");
        hashSet.add("2312");
        hashSet.add("2312");
        hashSet.add("23daw312");
        hashSet.add("231gse2");

        String[] array = hashSet.stream().toArray(String[]::new);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
