package com.google.firebase.inappmessaging.display.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class DaggerCollections {

    private static final int MAX_POWER_OF_TWO = 1073741824;
    private static int calculateInitialCapacity(int i) {
        if (i < 3) {
            return i++;
        }
        if (i < 1073741824) {
            return (int)obj1;
        }
        return Integer.MAX_VALUE;
    }

    public static boolean hasDuplicates(List<?> list) {
        int i;
        if (list.size() < 2) {
            return 0;
        }
        HashSet hashSet = new HashSet(list);
        if (list.size() != hashSet.size()) {
            i = 1;
        }
        return i;
    }

    static <T> HashSet<T> newHashSetWithExpectedSize(int i) {
        HashSet hashSet = new HashSet(DaggerCollections.calculateInitialCapacity(i));
        return hashSet;
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(DaggerCollections.calculateInitialCapacity(i));
        return linkedHashMap;
    }

    public static <T> List<T> presizedList(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(i);
        return arrayList;
    }
}
