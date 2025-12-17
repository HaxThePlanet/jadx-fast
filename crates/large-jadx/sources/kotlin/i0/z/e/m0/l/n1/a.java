package kotlin.i0.z.e.m0.l.n1;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class a<T>  {

    private final T a;
    private final T b;
    public a(T t, T t2) {
        super();
        this.a = t;
        this.b = t2;
    }

    public final T a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof a) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i2;
        int i;
        Object obj = this.a;
        if (obj == null) {
            i2 = i;
        } else {
            i2 = obj.hashCode();
        }
        final Object obj2 = this.b;
        if (obj2 == null) {
        } else {
            i = obj2.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ApproximationBounds(lower=");
        stringBuilder.append(this.a);
        stringBuilder.append(", upper=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
