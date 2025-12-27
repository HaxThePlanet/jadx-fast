package i.b.m0.j;

import i.b.p0.a;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureHelper.java */
/* loaded from: classes3.dex */
public final class d {
    public static long a(AtomicLong atomicLong, long j) {
        final long l = atomicLong.get();
        long l3 = Long.MAX_VALUE;
        while (l == Long.MAX_VALUE) {
            if (atomicLong.compareAndSet(l, d.c(l, j))) {
                return l;
            }
            l = atomicLong.get();
            l3 = Long.MAX_VALUE;
        }
        return Long.MAX_VALUE;
    }

    public static long b(AtomicLong atomicLong, long j) {
        final long l = atomicLong.get();
        long l3 = Long.MIN_VALUE;
        while (l == Long.MIN_VALUE) {
            long l4 = Long.MAX_VALUE;
            if (atomicLong.compareAndSet(l, d.c(l, j))) {
                return l;
            }
            l = atomicLong.get();
            l3 = Long.MIN_VALUE;
        }
        return Long.MIN_VALUE;
    }

    public static long d(AtomicLong atomicLong, long j) {
        long l;
        long l2 = atomicLong.get();
        long l4 = Long.MAX_VALUE;
        while (l2 == Long.MAX_VALUE) {
            l = l2 - j;
            l = 0L;
            if (atomicLong.compareAndSet(l2, l)) {
                return l;
            }
            l2 = atomicLong.get();
            l4 = Long.MAX_VALUE;
        }
        return Long.MAX_VALUE;
    }

    public static long c(long j, long j2) {
        long l = 9223372036854775807L;
        l = j + j2;
        if (l < 0) {
            l = Long.MAX_VALUE;
        }
        return l;
    }
}
