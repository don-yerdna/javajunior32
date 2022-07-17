package lesson12;

import java.util.*;

public class CollectionUtilsImpl implements CollectionUtils {
    @Override
    public Collection<Integer> union(Collection<Integer> a, Collection<Integer> b) throws NullPointerException {
        if (a == null || b == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        ArrayList<Integer> unionList = new ArrayList<>();
        unionList.addAll(a);
        for (Integer i : b) {
            if (!unionList.contains(i)) {
                unionList.add(i);
            }
        }
        return unionList;
    }

    @Override
    public Collection<Integer> intersection(Collection<Integer> a, Collection<Integer> b) throws NullPointerException {
        if (a == null || b == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        ArrayList<Integer> interList = new ArrayList<>();
        for (Integer itemA : a) {
            if (b.contains(itemA)) {
                interList.add(itemA);
            }
        }
        return interList;
    }

    @Override
    public Set<Integer> unionWithoutDuplicate(Collection<Integer> a, Collection<Integer> b) throws NullPointerException {
        if (a == null || b == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        HashSet<Integer> unionListNotDubl = new HashSet<>();
        unionListNotDubl.addAll(a);
        for (Integer i : b) {
            if (!unionListNotDubl.contains(i)) {
                unionListNotDubl.add(i);
            }
        }
        return unionListNotDubl;
    }

    @Override
    public Set<Integer> intersectionWithoutDuplicate(Collection<Integer> a, Collection<Integer> b) throws NullPointerException {
        if (a == null || b == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        HashSet<Integer> iterListNotDubl = new HashSet<>();
        for (Integer itemA : a) {
            if (b.contains(itemA)) {
                iterListNotDubl.add(itemA);
            }
        }
        return iterListNotDubl;
    }

    @Override
    public Collection<Integer> difference(Collection<Integer> a, Collection<Integer> b) throws NullPointerException {
        if (a == null || b == null) {
            throw new NullPointerException("нулевые входящие параметры");
        }
        ArrayList<Integer> difList = new ArrayList<>();
        difList.addAll(a);
        for (Iterator<Integer> iterator = b.iterator(); iterator.hasNext(); ) {
            if (difList.contains(iterator.next())) {
                difList.remove(iterator.next());
            }
        }
        return difList;
    }
}
