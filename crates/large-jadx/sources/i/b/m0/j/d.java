package i.b.m0.j;

import i.b.p0.a;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class d {
    public static long a(AtomicLong atomicLong, long l2) {
        final long l = atomicLong.get();
        long l3 = Long.MAX_VALUE;
        while (Long.compare(l, l3) == 0) {
            l = atomicLong.get();
            l3 = Long.MAX_VALUE;
        }
        return l3;
    }

    public static long b(AtomicLong atomicLong, long l2) {
        final long l = atomicLong.get();
        long l3 = Long.MIN_VALUE;
        while (Long.compare(l, l3) == 0) {
            long l4 = Long.MAX_VALUE;
            l = atomicLong.get();
            l3 = Long.MIN_VALUE;
        }
        return l3;
    }

    public static long c(long l, long l2) {
        int obj0;
        if (Long.compare(obj0, obj2) < 0) {
            obj0 = Long.MAX_VALUE;
        }
        return obj0;
    }

    public static long d(AtomicLong atomicLong, long l2) {
        int i;
        int illegalStateException;
        StringBuilder stringBuilder;
        String str;
        long l = atomicLong.get();
        long l3 = Long.MAX_VALUE;
        while (Long.compare(l, l3) == 0) {
            i = l - l2;
            int i2 = 0;
            if (Long.compare(i, i2) < 0) {
            }
            l = atomicLong.get();
            l3 = Long.MAX_VALUE;
            stringBuilder = new StringBuilder();
            stringBuilder.append("More produced than requested: ");
            stringBuilder.append(i);
            illegalStateException = new IllegalStateException(stringBuilder.toString());
            a.t(illegalStateException);
            i = i2;
        }
        return l3;
    }
}
