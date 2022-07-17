package lesson12;

import java.util.*;

public class SetUtilsImpl implements SetUtils {
    @Override
    public SortedSet<String> orderedSet(Collection<Integer> collection1, Set<String> set2) throws NullPointerException {
        if (collection1 == null || set2 == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        HashSet<String> set1 = new HashSet<>();
        for (Iterator<Integer> iterator = collection1.iterator(); iterator.hasNext(); ) {
            set1.add(iterator.next().toString());
        }
        for (String s : set2) {           // при объединении множеств элемент, может принадлежать к обоим множествам
            if (!set1.contains(s)) {    // объединение множеств, если элемент не в данном множестве, тогда добавить его
                set1.add(s);
            }
        }
        TreeSet<String> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.addAll(set1);
        return sortedSet;
    }

    @Override
    public Set<Integer> customOrderSet(int val1, int val2, int val3, int val4, int val5) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(val1);
        set.add(val2);
        set.add(val3);
        set.add(val4);
        set.add(val5);
        return set;
    }
}
