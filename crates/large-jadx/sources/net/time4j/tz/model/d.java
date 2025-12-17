package net.time4j.tz.model;

import java.util.Objects;
import net.time4j.f1.a;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.h;
import net.time4j.h0;
import net.time4j.k;

/* loaded from: classes3.dex */
public abstract class d {

    private final transient long a = 0;
    private final transient h0 b;
    private final transient net.time4j.tz.model.i c;
    private final transient int v = 0;
    protected d(int i, net.time4j.tz.model.i i2, int i3) {
        int i4;
        long l2;
        long l;
        h0 obj5;
        super();
        Objects.requireNonNull(i2, "Missing offset indicator.");
        int i5 = Integer.MAX_VALUE;
        if (i3 != i5) {
            if (i3 < -64800) {
            } else {
                if (i3 > 64800) {
                } else {
                }
            }
            StringBuilder obj6 = new StringBuilder();
            obj6.append("DST out of range: ");
            obj6.append(i3);
            obj5 = new IllegalArgumentException(obj6.toString());
            throw obj5;
        }
        if (i == 86400) {
            l2 = 0;
            this.b = h0.G0();
        } else {
            obj5 = h0.H0().R0((long)i, obj3);
            this.a = obj5.a();
            this.b = obj5.b();
        }
        this.c = i2;
        final int obj7 = 0;
    }

    protected String a() {
        java.lang.annotation.Annotation annotation = getClass().getAnnotation(c.class);
        if ((c)annotation == null) {
        } else {
            return (c)annotation.value();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find calendar type annotation: ");
        stringBuilder.append(getClass());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public abstract g0 b(int i);

    protected final long c() {
        return this.a;
    }

    public final net.time4j.tz.model.i d() {
        return this.c;
    }

    public final int e() {
        return this.v;
    }

    public final h0 f() {
        return this.b;
    }

    int g() {
        return 0;
    }

    protected abstract int h(long l);

    protected abstract int i(a a);
}
