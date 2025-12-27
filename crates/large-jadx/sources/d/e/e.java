package d.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/* compiled from: LruCache.java */
/* loaded from: classes.dex */
public class e<K, V> {

    private final LinkedHashMap<K, V> a = new LinkedHashMap<>(0, 1061158912, 1);
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
            throw new IllegalArgumentException("maxSize <= 0");
        } else {
            this.c = i;
            LinkedHashMap linkedHashMap = new LinkedHashMap(0, 0.75f, true);
            return;
        }
    }

    private int f(K k, V v) {
        int i = g(k, v);
        if (i < 0) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Negative size: ";
            String str2 = "=";
            k = str + k + str2 + v;
            throw new IllegalStateException(k);
        } else {
            return i;
        }
    }

    public final V c(K k) {
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            try {
                Object value = this.a.get(k);
                if (value != null) {
                    this.g++;
                    return value;
                }
                this.h++;
            } catch (Throwable th) {
            }
        }
        Object obj = a(th);
        if (obj == null) {
            return null;
        }
        synchronized (this) {
            try {
                this.e++;
                Object obj2 = this.a.put(th, obj);
                if (obj2 != null) {
                    this.a.put(th, obj2);
                } else {
                    this.b += i2;
                }
            } catch (Throwable th) {
            }
        }
        if (obj2 != null) {
            b(false, th, obj, obj2);
            return obj2;
        }
        i(this.c);
        return obj;
    }

    public final V d(K k, V v) {
        int i;
        if (k == null) {
            throw new NullPointerException("key == null || value == null");
        } else {
            if (v != null) {
                synchronized (this) {
                    try {
                        this.d++;
                        this.b += i;
                        Object obj = this.a.put(k, v);
                        if (obj != null) {
                            this.b -= i2;
                        }
                    } catch (Throwable th) {
                    }
                }
                if (obj != null) {
                    b(false, th, obj, v);
                }
                i(this.c);
                return obj;
            }
        }
    }

    public final V e(K k) {
        int i;
        int i2;
        Objects.requireNonNull(k, "key == null");
        synchronized (this) {
            try {
                Object remove = this.a.remove(k);
                if (remove != null) {
                    this.b -= i2;
                }
            } catch (Throwable th) {
            }
        }
        if (remove != null) {
            b(false, th, remove, null);
        }
        return remove;
    }

    public final synchronized Map<K, V> h() {
        return new LinkedHashMap(this.a);
    }

    public void i(int i) {
        synchronized (this) {
            try {
                Object item = this.a.entrySet().iterator().next();
                Object key = item.getKey();
                Object value = item.getValue();
                this.a.remove(key);
                this.b -= i9;
                int i10 = 1;
                this.f += i10;
            } catch (Throwable unused) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            String name = getClass().getName();
            String str = ".sizeOf() is reporting inconsistent results!";
            r0 = name + str;
            throw new IllegalStateException(r0);
        }
        b(true, key, value, null);
    }

    public final synchronized String toString() {
        int i;
        int i5 = this.h + i2;
        i = 0;
        i = this.h != 0 ? i3 / i5 : i;
        Object[] arr = new Object[4];
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(i) });
    }

    protected V a(K k) {
        return null;
    }

    protected void b(boolean z, K k, V v, V v2) {
    }

    protected int g(K k, V v) {
        return 1;
    }
}
