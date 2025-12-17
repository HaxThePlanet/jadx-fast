package com.google.common.collect;

import com.google.common.base.k;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
abstract class e<K, V>  implements Map.Entry<K, V> {
    @Override // java.util.Map$Entry
    public boolean equals(Object object) {
        boolean value;
        int i;
        Object key;
        Object obj4;
        i = 0;
        if (object instanceof Map.Entry && k.a(getKey(), (Map.Entry)object.getKey()) && k.a(getValue(), object.getValue())) {
            if (k.a(getKey(), (Map.Entry)object.getKey())) {
                if (k.a(getValue(), object.getValue())) {
                    i = 1;
                }
            }
        }
        return i;
    }

    public abstract K getKey();

    public abstract V getValue();

    @Override // java.util.Map$Entry
    public int hashCode() {
        int i;
        int i2;
        Object key = getKey();
        final Object value = getValue();
        if (key == null) {
            i = i2;
        } else {
            i = key.hashCode();
        }
        if (value == null) {
        } else {
            i2 = value.hashCode();
        }
        return i ^= i2;
    }

    @Override // java.util.Map$Entry
    public String toString() {
        String valueOf = String.valueOf(getKey());
        String valueOf2 = String.valueOf(getValue());
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append(valueOf);
        stringBuilder.append("=");
        stringBuilder.append(valueOf2);
        return stringBuilder.toString();
    }
}
