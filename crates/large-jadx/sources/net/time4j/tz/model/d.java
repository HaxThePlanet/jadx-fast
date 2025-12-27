package net.time4j.tz.model;

import java.util.Objects;
import net.time4j.f1.a;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.h;
import net.time4j.h0;
import net.time4j.k;

/* compiled from: DaylightSavingRule.java */
/* loaded from: classes3.dex */
public abstract class d {

    private final transient long a = 0;
    private final transient h0 b;
    private final transient i c;
    private final transient int v = 0;
    protected d(int i, i iVar, int i2) {
        super();
        Objects.requireNonNull(iVar, "Missing offset indicator.");
        int i4 = Integer.MAX_VALUE;
        if (i2 != Integer.MAX_VALUE && i2 >= -64800) {
            i2 = 64800;
            if (i2 > 64800) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "DST out of range: ";
                iVar = str2 + i2;
                throw new IllegalArgumentException(iVar);
            }
        }
        if (i == 86400) {
            int i6 = 0;
            this.b = h0.G0();
        } else {
            l2 = (long)i;
            k kVar = h0.H0().R0(l2, h.SECONDS);
            this.a = kVar.a();
            this.b = kVar.b();
        }
        this.c = iVar;
    }

    protected String a() {
        java.lang.annotation.Annotation annotation = getClass().getAnnotation(c.class);
        if (annotation == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot find calendar type annotation: ";
            Class cls2 = getClass();
            r1 = str + cls2;
            throw new IllegalStateException(r1);
        } else {
            return annotation.value();
        }
    }

    protected final long c() {
        return this.a;
    }

    public final i d() {
        return this.c;
    }

    public final int e() {
        return this.v;
    }

    public final h0 f() {
        return this.b;
    }

    public abstract g0 b(int i);

    int g() {
        return 0;
    }

    protected abstract int h(long j);

    protected abstract int i(a aVar);
}
