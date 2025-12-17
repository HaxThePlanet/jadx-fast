package kotlin.i0.z.e.n0;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class e<K, V>  implements Serializable {

    public final K key;
    public final V value;
    public e(K k, V v2) {
        super();
        this.key = k;
        this.value = v2;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        Object equals;
        int i;
        Object key;
        Object obj4;
        if (!object instanceof e) {
            return 0;
        }
        Object key2 = this.key;
        if (key2 == null) {
            if (object.key == null) {
                equals = this.value;
                obj4 = object.value;
                if (equals == null) {
                    if (obj4 == null) {
                        i = 1;
                    }
                } else {
                    if (equals.equals(obj4)) {
                    }
                }
            }
        } else {
            if (key2.equals(object.key)) {
            }
        }
        return i;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        int i2;
        Object key = this.key;
        if (key == null) {
            i = i2;
        } else {
            i = key.hashCode();
        }
        final Object value = this.value;
        if (value == null) {
        } else {
            i2 = value.hashCode();
        }
        return i ^= i2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.key);
        stringBuilder.append("=");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }
}
