package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class w<K, V>  extends com.google.common.collect.y<K, V> implements com.google.common.collect.c0<K, V> {

    private static final long serialVersionUID;

    public static final class a extends com.google.common.collect.y.b<K, V> {
        @Override // com.google.common.collect.y$b
        public com.google.common.collect.y.b c(Object object, Iterable iterable2) {
            f(object, iterable2);
            return this;
        }

        public com.google.common.collect.w<K, V> e() {
            return (w)super.a();
        }

        public com.google.common.collect.w.a<K, V> f(K k, Iterable<? extends V> iterable2) {
            super.c(k, iterable2);
            return this;
        }

        public com.google.common.collect.w.a<K, V> g(K k, V... v2Arr2) {
            super.d(k, v2Arr2);
            return this;
        }
    }
    w(com.google.common.collect.x<K, com.google.common.collect.v<V>> x, int i2) {
        super(x, i2);
    }

    public static <K, V> com.google.common.collect.w.a<K, V> l() {
        w.a aVar = new w.a();
        return aVar;
    }

    static <K, V> com.google.common.collect.w<K, V> m(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator2) {
        int i;
        com.google.common.collect.v size;
        Object key;
        boolean empty;
        if (collection.isEmpty()) {
            return w.o();
        }
        x.a aVar = new x.a(collection.size());
        i = 0;
        Iterator obj5 = collection.iterator();
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            Object value = next2.getValue();
            if (comparator2 == null) {
            } else {
            }
            size = v.D(comparator2, (Collection)value);
            if (!size.isEmpty()) {
            }
            aVar.c((Map.Entry)next2.getKey(), size);
            i += size;
            size = v.u(value);
        }
        obj5 = new w(aVar.a(), i);
        return obj5;
    }

    public static <K, V> com.google.common.collect.w<K, V> o() {
        return o.x;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        int i;
        int i3;
        Object object2;
        int int;
        com.google.common.collect.v vVar;
        int i2;
        Object object;
        objectInputStream.defaultReadObject();
        int int2 = objectInputStream.readInt();
        if (int2 < 0) {
        } else {
            com.google.common.collect.x.a aVar = x.a();
            int i6 = 0;
            i3 = i;
            while (i < int2) {
                int = objectInputStream.readInt();
                com.google.common.collect.v.a aVar2 = v.s();
                i2 = i6;
                while (i2 < int) {
                    aVar2.d(objectInputStream.readObject());
                    i2++;
                }
                aVar.c(objectInputStream.readObject(), aVar2.e());
                i3 += int;
                i++;
                aVar2.d(objectInputStream.readObject());
                i2++;
            }
            y.c.a.b(this, aVar.a());
            y.c.b.a(this, i3);
        }
        StringBuilder stringBuilder2 = new StringBuilder(29);
        stringBuilder2.append("Invalid key count ");
        stringBuilder2.append(int2);
        InvalidObjectException obj11 = new InvalidObjectException(stringBuilder2.toString());
        throw obj11;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        w0.b(this, objectOutputStream);
    }

    public com.google.common.collect.v<V> n(K k) {
        Object obj2;
        if ((v)this.v.get(k) == null) {
            obj2 = v.z();
        }
        return obj2;
    }
}
