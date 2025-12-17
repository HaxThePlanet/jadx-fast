package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class n<E>  implements Iterable<E> {

    private final Object a;
    private final Map<E, Integer> b;
    private Set<E> c;
    private List<E> v;
    public n() {
        super();
        Object object = new Object();
        this.a = object;
        HashMap hashMap = new HashMap();
        this.b = hashMap;
        this.c = Collections.emptySet();
        this.v = Collections.emptyList();
    }

    public Set<E> H() {
        final Object obj = this.a;
        return this.c;
        synchronized (obj) {
            obj = this.a;
            return this.c;
        }
    }

    public void b(E e) {
        Object intValue;
        Object unmodifiableSet;
        Set set;
        int i;
        final Object obj = this.a;
        ArrayList arrayList = new ArrayList(this.v);
        arrayList.add(e);
        this.v = Collections.unmodifiableList(arrayList);
        intValue = this.b.get(e);
        synchronized (obj) {
            HashSet hashSet = new HashSet(this.c);
            hashSet.add(e);
            this.c = Collections.unmodifiableSet(hashSet);
            if ((Integer)intValue != null) {
                try {
                    i += intValue;
                    this.b.put(e, Integer.valueOf(i));
                    throw e;
                }
            }
        }
    }

    public int d(E e) {
        Map key;
        int obj3;
        final Object obj = this.a;
        synchronized (obj) {
            obj3 = (Integer)this.b.get(e).intValue();
            try {
                return obj3;
                throw e;
            }
        }
    }

    public void g(E e) {
        Object hashSet;
        Object set;
        Object obj5;
        final Object obj = this.a;
        Object obj2 = this.b.get(e);
        synchronized (obj) {
        }
    }

    public Iterator<E> iterator() {
        final Object obj = this.a;
        return this.v.iterator();
        synchronized (obj) {
            obj = this.a;
            return this.v.iterator();
        }
    }
}
