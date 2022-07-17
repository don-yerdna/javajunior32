package lesson12;

import java.util.*;

public class ListUtilsImpl implements ListUtils {
    @Override
    public List<String> asList(String... strings) throws IllegalArgumentException {
        ArrayList<String> stringList = new ArrayList<>();
        for (String s : strings) {
            if (s == null) {
                throw new IllegalArgumentException("нулевые входящие параметры");
            }
            stringList.add(s);
        }
        return stringList;
    }

    @Override
    public List<Double> sortedList(List<Double> data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("нулевой входящий список");
        }
        ArrayList<Double> sortList = new ArrayList<>();
        sortList.addAll(data);
        Collections.sort(sortList);
        Collections.reverse(sortList);
        return sortList;
    }
}
