package com.google.android.exoplayer2.util;

/* loaded from: classes2.dex */
public final class m0 {

    private long a;
    private long b;
    private long c;
    private final java.lang.ThreadLocal<Long> d;
    public m0(long l) {
        super();
        ThreadLocal threadLocal = new ThreadLocal();
        this.d = threadLocal;
        g(l);
    }

    public static long f(long l) {
        return obj2 /= i2;
    }

    public static long i(long l) {
        return obj2 /= i2;
    }

    public static long j(long l) {
        return obj2 %= l2;
    }

    public long a(long l) {
        long longValue;
        int cmp;
        long cmp2;
        long l2 = -9223372036854775807L;
        synchronized (this) {
            return l2;
        }
    }

    public long b(long l) {
        int cmp;
        long l2;
        long l3;
        int i;
        long obj9;
        long l4 = -9223372036854775807L;
        synchronized (this) {
            return l4;
        }
    }

    public long c() {
        long l;
        int cmp;
        l = this.a;
        synchronized (this) {
            try {
                if (Long.compare(l, l3) == 0) {
                }
                l = -9223372036854775807L;
            }
            return l;
        }
    }

    public long d() {
        int i;
        long cmp;
        long l = this.c;
        synchronized (this) {
            try {
                l += cmp;
                i = c();
                return i;
                throw th;
            }
        }
    }

    public long e() {
        return this.b;
        synchronized (this) {
            return this.b;
        }
    }

    public void g(long l) {
        int obj3;
        this.a = l;
        long l3 = -9223372036854775807L;
        synchronized (this) {
            try {
                obj3 = 0;
                obj3 = l3;
                this.b = obj3;
                this.c = l3;
                throw l;
            }
        }
    }

    public void h(boolean z, long l2) {
        int i;
        Throwable obj5;
        Long obj6;
        synchronized (this) {
            try {
                i = 1;
                i = 0;
                g.f(i);
                long l5 = -9223372036854775807L;
                if (Long.compare(l3, l5) != 0) {
                }
                if (z != null) {
                }
                this.d.set(Long.valueOf(l2));
                while (Long.compare(obj5, l5) == 0) {
                    wait();
                }
                wait();
                throw z;
            }
        }
    }
}
