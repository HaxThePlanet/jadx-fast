package i.b.s0;

import i.b.m0.b.b;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class b<T>  {

    final T a;
    final long b;
    final TimeUnit c;
    public b(T t, long l2, TimeUnit timeUnit3) {
        super();
        this.a = t;
        this.b = l2;
        b.e(obj4, "unit is null");
        this.c = (TimeUnit)obj4;
    }

    public long a() {
        return this.b;
    }

    public T b() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean cmp;
        int i;
        Object obj;
        long l;
        Object obj7;
        i = 0;
        if (object instanceof b && b.c(this.a, object.a) && Long.compare(obj, l) == 0 && b.c(this.c, object.c)) {
            if (b.c(this.a, object.a)) {
                if (Long.compare(obj, l) == 0) {
                    if (b.c(this.c, object.c)) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public int hashCode() {
        int i;
        Object obj = this.a;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        int i6 = 31;
        long l = this.b;
        return i4 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Timed[time=");
        stringBuilder.append(this.b);
        stringBuilder.append(", unit=");
        stringBuilder.append(this.c);
        stringBuilder.append(", value=");
        stringBuilder.append(this.a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
