package lesson13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Main1 {
    public static void main(String[] args) {
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        hashSet.add("123");
        hashSet.add("1234");
        hashSet.add("1235");
        hashSet.add("1235");
        hashSet.add("1237");
        for (Iterator<String> iterator = hashSet.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
