package com.google.common.collect;

import com.google.common.base.n;
import com.google.common.base.s;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l0 {

    private static class a extends com.google.common.collect.c<K, V> {

        private static final long serialVersionUID;
        transient s<? extends List<V>> x;
        a(Map<K, Collection<V>> map, s<? extends List<V>> s2) {
            super(map);
            n.o(s2);
            this.x = (s)s2;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            objectInputStream.defaultReadObject();
            this.x = (s)objectInputStream.readObject();
            v((Map)objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.x);
            objectOutputStream.writeObject(o());
        }

        Map<K, Collection<V>> c() {
            return r();
        }

        Set<K> d() {
            return s();
        }

        @Override // com.google.common.collect.c
        protected Collection p() {
            return z();
        }

        protected List<V> z() {
            return (List)this.x.get();
        }
    }
    static boolean a(com.google.common.collect.i0<?, ?> i0, Object object2) {
        if (object2 == i0) {
            return 1;
        }
        if (object2 instanceof i0) {
            return i0.a().equals((i0)object2.a());
        }
        return 0;
    }

    public static <K, V> com.google.common.collect.c0<K, V> b(Map<K, Collection<V>> map, s<? extends List<V>> s2) {
        l0.a aVar = new l0.a(map, s2);
        return aVar;
    }
}
