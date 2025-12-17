package kotlin.i0.z.e.m0.j.b;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;

/* loaded from: classes3.dex */
public final class r<T>  {

    private final T a;
    private final T b;
    private final String c;
    private final a d;
    public r(T t, T t2, String string3, a a4) {
        n.f(string3, "filePath");
        n.f(a4, "classId");
        super();
        this.a = t;
        this.b = t2;
        this.c = string3;
        this.d = a4;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof r) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        if (!n.b(this.d, object.d)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i;
        int i2;
        Object obj = this.a;
        if (obj == null) {
            i = i2;
        } else {
            i = obj.hashCode();
        }
        final Object obj2 = this.b;
        if (obj2 == null) {
        } else {
            i2 = obj2.hashCode();
        }
        return i7 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IncompatibleVersionErrorData(actualVersion=");
        stringBuilder.append(this.a);
        stringBuilder.append(", expectedVersion=");
        stringBuilder.append(this.b);
        stringBuilder.append(", filePath=");
        stringBuilder.append(this.c);
        stringBuilder.append(", classId=");
        stringBuilder.append(this.d);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
