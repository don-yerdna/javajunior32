package lesson13;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        long startTime = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            arrayList.add("123" + i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("array add: " + (endTime-startTime));

        long startTiml = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            linkedList.add("123" + i);
        }
        long endTimel = System.currentTimeMillis();
        System.out.println("linked add: " + (endTimel-startTiml));

        long startTime3 = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            arrayList.get(i);
        }
        long endTime3 = System.currentTimeMillis();
        System.out.println("array get: " + (endTime3-startTime3));

        long startTime4 = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            linkedList.get(i);
        }
        long endTime4 = System.currentTimeMillis();
        System.out.println("linked get: " + (endTime4-startTime4));
    }
}

