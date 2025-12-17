package net.time4j;

import java.util.Iterator;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.f1.e;
import net.time4j.i1.d;
import net.time4j.i1.e;
import net.time4j.i1.f;

/* loaded from: classes3.dex */
public final class p0 implements e<net.time4j.b0> {

    private static final e c;
    private static final boolean d;
    public static final net.time4j.p0 e;
    private final boolean a;
    private final long b;

    static class a {
    }

    private static class b implements e {
        b(net.time4j.p0.a p0$a) {
            super();
        }

        @Override // net.time4j.i1.e
        public long a() {
            return System.nanoTime();
        }

        @Override // net.time4j.i1.e
        public String b() {
            return "";
        }
    }
    static {
        Class<e> bVar;
        int i;
        boolean equals;
        Iterator iterator = d.c().g(e.class).iterator();
        i = 0;
        for (e bVar : iterator) {
            i = 0;
        }
        bVar = i;
        if (bVar == null) {
            bVar = new p0.b(i);
        }
        p0.c = bVar;
        p0.d = Boolean.getBoolean("net.time4j.systemclock.nanoTime");
        p0 p0Var = new p0(0, p0.a(), i);
        p0.e = p0Var;
        p0.a();
    }

    private p0(boolean z, long l2) {
        super();
        this.a = z;
        this.b = l2;
    }

    private static long a() {
        long currentTimeMillis;
        int nanoTime;
        int i;
        long currentTimeMillis2;
        int cmp;
        currentTimeMillis = System.currentTimeMillis();
        nanoTime = 0;
        i = 0;
        while (i < 10) {
            if (p0.d) {
            } else {
            }
            nanoTime = p0.c.a();
            currentTimeMillis2 = System.currentTimeMillis();
            if (Long.compare(currentTimeMillis, currentTimeMillis2) == 0) {
                break;
            } else {
            }
            i++;
            currentTimeMillis = currentTimeMillis2;
            nanoTime = System.nanoTime();
        }
        int i5 = 1000;
        return c.m(l5 += l, cmp);
    }

    public static net.time4j.b0 b() {
        return p0.e.c();
    }

    private long d() {
        long nanoTime;
        if (p0.d) {
            nanoTime = System.nanoTime();
        } else {
            nanoTime = p0.c.a();
        }
        return c.f(nanoTime, obj1);
    }

    @Override // net.time4j.f1.e
    public net.time4j.b0 c() {
        boolean z;
        if (!this.a) {
            if (p0.d && d.w().A()) {
                if (d.w().A()) {
                    long l = d();
                    int i6 = 1000000000;
                    return b0.o0(c.b(l, obj1), obj4, c.d(l, obj1));
                }
            }
        } else {
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = 1000;
        return b0.o0(c.b(currentTimeMillis, obj1), obj4, i *= i4);
    }
}
