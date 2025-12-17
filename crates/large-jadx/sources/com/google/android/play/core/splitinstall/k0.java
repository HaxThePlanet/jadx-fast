package com.google.android.play.core.splitinstall;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class k0 {

    private final Map<String, Map<String, String>> a;
    k0(Map map, com.google.android.play.core.splitinstall.j0 j02) {
        super();
        this.a = map;
    }

    public final Map<String, Set<String>> a(Collection<String> collection) {
        Object next;
        Set unmodifiableSet;
        Iterator iterator;
        boolean value;
        boolean contains;
        HashMap hashMap = new HashMap();
        Iterator iterator2 = this.a.keySet().iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if (!this.a.containsKey((String)next)) {
            } else {
            }
            HashSet hashSet = new HashSet();
            iterator = (Map)this.a.get(next).entrySet().iterator();
            while (iterator.hasNext()) {
                value = iterator.next();
                if (collection.contains((Map.Entry)value.getKey())) {
                }
                hashSet.add((String)value.getValue());
            }
            unmodifiableSet = Collections.unmodifiableSet(hashSet);
            hashMap.put(next, unmodifiableSet);
            value = iterator.next();
            if (collection.contains((Map.Entry)value.getKey())) {
            }
            hashSet.add((String)value.getValue());
            unmodifiableSet = Collections.emptySet();
        }
        return hashMap;
    }
}
