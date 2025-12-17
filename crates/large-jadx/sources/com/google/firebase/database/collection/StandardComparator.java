package com.google.firebase.database.collection;

import java.util.Comparator;

/* loaded from: classes2.dex */
public class StandardComparator<A extends Comparable<A>>  implements Comparator<A> {

    private static com.google.firebase.database.collection.StandardComparator INSTANCE;
    static {
        StandardComparator standardComparator = new StandardComparator();
        StandardComparator.INSTANCE = standardComparator;
    }

    public static <T extends Comparable<T>> com.google.firebase.database.collection.StandardComparator<T> getComparator(Class<T> class) {
        return StandardComparator.INSTANCE;
    }

    public int compare(A a, A a2) {
        return a.compareTo(a2);
    }

    @Override // java.util.Comparator
    public int compare(Object object, Object object2) {
        return compare((Comparable)object, (Comparable)object2);
    }
}
