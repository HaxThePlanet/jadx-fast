package net.time4j;

import java.util.Iterator;
import net.time4j.f1.c;
import net.time4j.i1.f;

/* compiled from: SystemClock.java */
/* loaded from: classes3.dex */
public final class p0 implements net.time4j.f1.e<b0> {

    private static final net.time4j.i1.e c = new p0$b(0);
    private static final boolean d = false;
    public static final p0 e = new p0();
    private final boolean a;
    private final long b;

    static class a {
    }

    private static class b implements net.time4j.i1.e {
        private b() {
            super();
        }

        public long a() {
            return System.nanoTime();
        }

        /* synthetic */ b(p0.a aVar) {
            this();
        }

        public String b() {
            return "";
        }
    }
    static {
        int i;
        boolean equals;
        item = e.class;
        Iterator it = d.c().g(item).iterator();
        i = 0;
        while (it.hasNext()) {
            if (System.getProperty("java.vm.name").equals((e)it.next().b())) {
                break;
            }
            i = 0;
        }
        p0.d = Boolean.getBoolean("net.time4j.systemclock.nanoTime");
        p0.a();
    }

    private p0(boolean z, long j) {
        super();
        this.a = z;
        this.b = j;
    }

    private static long a() {
        long time;
        int i = 0;
        int i2 = 0;
        long l9;
        int cmp;
        time = System.currentTimeMillis();
        i = 0;
        i2 = 0;
        int i3 = 10;
        while (i2 < 10) {
            time = System.currentTimeMillis();
            if (time == time) {
                break;
            }
        }
        int i7 = 1000;
        return c.m((c.i(d.w().g(c.b(time, i7)), 1000000000L)) + (long)(c.d(time, i7)) * 1000000, i);
    }

    public static b0 b() {
        return p0.e.c();
    }

    private long d() {
        long time;
        if (p0.d) {
            time = System.nanoTime();
        } else {
            time = p0.c.a();
        }
        return c.f(time, this.b);
    }

    public b0 c() {
        if (this.a || p0.d) {
            if (d.w().A()) {
                long l = d();
                int i6 = 1000000000;
                return b0.o0(c.b(l, i6), c.d(l, i6), f.UTC);
            }
        }
        long time = System.currentTimeMillis();
        int i5 = 1000;
        return b0.o0(c.b(time, i5), (c.d(time, i5)) * 1000000, f.POSIX);
    }
}
