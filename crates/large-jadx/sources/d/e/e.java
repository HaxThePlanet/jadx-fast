package d.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class e<K, V>  {

    private final LinkedHashMap<K, V> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    public e(int i) {
        super();
        if (i <= 0) {
        } else {
            this.c = i;
            LinkedHashMap obj4 = new LinkedHashMap(0, 1061158912, 1);
            this.a = obj4;
        }
        obj4 = new IllegalArgumentException("maxSize <= 0");
        throw obj4;
    }

    private int f(K k, V v2) {
        int i = g(k, v2);
        if (i < 0) {
        } else {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append("=");
        stringBuilder.append(v2);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    protected V a(K k) {
        return 0;
    }

    protected void b(boolean z, K k2, V v3, V v4) {
    }

    public final V c(K k) {
        int i2;
        int i;
        Objects.requireNonNull(k, "key == null");
        Object obj = this.a.get(k);
        synchronized (this) {
            this.g = obj5++;
            return obj;
        }
        return 0;
    }

    public final V d(K k, V v2) {
        int i2;
        int i;
        if (k == null) {
        } else {
            if (v2 == null) {
            } else {
                this.d = i3++;
                this.b = i5 += i2;
                Object obj = this.a.put(k, v2);
                synchronized (this) {
                    this.b = i7 -= i;
                    if (obj != null) {
                    }
                    i(this.c);
                    return obj;
                }
                try {
                    b(false, k, obj, v2);
                    i(this.c);
                    return obj;
                    throw k;
                    NullPointerException obj4 = new NullPointerException("key == null || value == null");
                    throw obj4;
                }
            }
        }
    }

    public final V e(K k) {
        int i;
        int i2;
        Objects.requireNonNull(k, "key == null");
        Object remove = this.a.remove(k);
        synchronized (this) {
            this.b = i3 -= i2;
            if (remove != null) {
            }
            return remove;
        }
        b(false, k, remove, 0);
    }

    protected int g(K k, V v2) {
        return 1;
    }

    public final Map<K, V> h() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.a);
        return linkedHashMap;
        synchronized (this) {
            linkedHashMap = new LinkedHashMap(this.a);
            return linkedHashMap;
        }
    }

    public void i(int i) {
        boolean empty;
        int empty2;
        synchronized (this) {
            try {
                Object next = this.a.entrySet().iterator().next();
                Object key = (Map.Entry)next.getKey();
                Object value = next.getValue();
                this.a.remove(key);
                this.b = i2 -= i7;
                int i8 = 1;
                this.f = i4 += i8;
                b(i8, key, value, 0);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getClass().getName());
                stringBuilder.append(".sizeOf() is reporting inconsistent results!");
                IllegalStateException obj5 = new IllegalStateException(stringBuilder.toString());
                throw obj5;
                throw i;
            }
        }
    }

    public final String toString() {
        int i;
        int i2 = this.g;
        i4 += i2;
        int i6 = 0;
        synchronized (this) {
            try {
                i3 /= i5;
                i = i6;
                Object[] arr = new Object[4];
                arr[i6] = Integer.valueOf(this.c);
                arr[1] = Integer.valueOf(this.g);
                arr[2] = Integer.valueOf(this.h);
                arr[3] = Integer.valueOf(i);
                return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", arr);
                throw th;
            }
        }
    }
}
