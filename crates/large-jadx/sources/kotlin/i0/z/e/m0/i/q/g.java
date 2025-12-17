package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;

/* loaded from: classes3.dex */
public abstract class g<T>  {

    private final T a;
    public g(T t) {
        super();
        this.a = t;
    }

    public abstract b0 a(c0 c0);

    public T b() {
        return this.a;
    }

    public boolean equals(Object object) {
        Object obj;
        boolean z;
        Object obj2;
        int obj4;
        if (this != object) {
            if (object instanceof g) {
            } else {
                obj4 = obj2;
            }
            if (obj4 == null) {
            } else {
                obj2 = obj4.b();
            }
            if (n.b(b(), obj2)) {
                obj4 = 1;
            } else {
                obj4 = 0;
            }
        } else {
        }
        return obj4;
    }

    public int hashCode() {
        int i;
        Object obj = b();
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return i;
    }

    public String toString() {
        return String.valueOf(b());
    }
}
