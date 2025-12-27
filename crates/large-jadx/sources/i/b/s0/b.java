package i.b.s0;

import i.b.m0.b.b;
import java.util.concurrent.TimeUnit;

/* compiled from: Timed.java */
/* loaded from: classes3.dex */
public final class b<T> {

    final T a;
    final long b;
    final TimeUnit c;
    public b(T t, long j, TimeUnit timeUnit) {
        super();
        this.a = t;
        this.b = j;
        b.e(timeUnit, "unit is null");
        this.c = timeUnit;
    }

    public long a() {
        return this.b;
    }

    public T b() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z3 = false;
        z = object instanceof b;
        int i = 0;
        if (object instanceof b) {
            if (b.c(this.a, object.a)) {
                if (this.b == object.b) {
                    if (b.c(this.c, object.c)) {
                        int i2 = 1;
                    }
                }
            }
        }
        return z3;
    }

    public int hashCode() {
        int i = 0;
        if (this.a != null) {
            i = this.a.hashCode();
        } else {
            i = 0;
        }
        int i6 = 31;
        return (i * i6) + (int)(l ^ (l >>> i6)) * i6 + this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Timed[time=";
        String str3 = ", unit=";
        String str4 = ", value=";
        String str5 = "]";
        str = str2 + this.b + str3 + this.c + str4 + this.a + str5;
        return str;
    }
}
