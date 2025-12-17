package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.s;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public abstract class k0<K0, V0>  {

    public static abstract class d {
        public com.google.common.collect.k0.c<K0, Object> a() {
            return b(2);
        }

        public com.google.common.collect.k0.c<K0, Object> b(int i) {
            i.b(i, "expectedValuesPerKey");
            k0.d.a aVar = new k0.d.a(this, i);
            return aVar;
        }

        abstract <K extends K0, V> Map<K, Collection<V>> c();
    }

    class a extends com.google.common.collect.k0.d<K0> {

        final Comparator a;
        a(Comparator comparator) {
            this.a = comparator;
            super();
        }

        <K extends K0, V> Map<K, Collection<V>> c() {
            TreeMap treeMap = new TreeMap(this.a);
            return treeMap;
        }
    }

    private static final class b implements s<List<V>>, Serializable {

        private final int expectedValuesPerKey;
        b(int i) {
            super();
            i.b(i, "expectedValuesPerKey");
            this.expectedValuesPerKey = i;
        }

        public List<V> a() {
            ArrayList arrayList = new ArrayList(this.expectedValuesPerKey);
            return arrayList;
        }

        @Override // com.google.common.base.s
        public Object get() {
            return a();
        }
    }

    public static abstract class c extends com.google.common.collect.k0<K0, V0> {
        c() {
            super(0);
        }

        public abstract <K extends K0, V extends V0> com.google.common.collect.c0<K, V> c();
    }
    k0(com.google.common.collect.j0 j0) {
        super();
    }

    public static com.google.common.collect.k0.d<Comparable> a() {
        return k0.b(p0.c());
    }

    public static <K0> com.google.common.collect.k0.d<K0> b(Comparator<K0> comparator) {
        n.o(comparator);
        k0.a aVar = new k0.a(comparator);
        return aVar;
    }
}
