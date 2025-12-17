package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class q {

    private final com.google.common.base.u a;
    private boolean b;
    private long c;
    private long d;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            q.a.a = iArr;
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            q.a.a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            q.a.a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            q.a.a[TimeUnit.SECONDS.ordinal()] = 4;
            q.a.a[TimeUnit.MINUTES.ordinal()] = 5;
            q.a.a[TimeUnit.HOURS.ordinal()] = 6;
            q.a.a[TimeUnit.DAYS.ordinal()] = 7;
        }
    }
    q() {
        super();
        this.a = u.b();
    }

    private static String a(TimeUnit timeUnit) {
        switch (obj1) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                AssertionError obj1 = new AssertionError();
                throw obj1;
        }
    }

    private static TimeUnit b(long l) {
        TimeUnit dAYS = TimeUnit.DAYS;
        final TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
        final int i = 0;
        if (Long.compare(convert, i) > 0) {
            return dAYS;
        }
        TimeUnit hOURS = TimeUnit.HOURS;
        if (Long.compare(convert2, i) > 0) {
            return hOURS;
        }
        TimeUnit mINUTES = TimeUnit.MINUTES;
        if (Long.compare(convert3, i) > 0) {
            return mINUTES;
        }
        TimeUnit sECONDS = TimeUnit.SECONDS;
        if (Long.compare(convert4, i) > 0) {
            return sECONDS;
        }
        TimeUnit mILLISECONDS = TimeUnit.MILLISECONDS;
        if (Long.compare(convert5, i) > 0) {
            return mILLISECONDS;
        }
        TimeUnit mICROSECONDS = TimeUnit.MICROSECONDS;
        if (Long.compare(obj6, i) > 0) {
            return mICROSECONDS;
        }
        return nANOSECONDS;
    }

    public static com.google.common.base.q c() {
        q qVar = new q();
        return qVar;
    }

    private long e() {
        int i;
        long l;
        if (this.b) {
            i2 += l;
        } else {
            i = this.c;
        }
        return i;
    }

    public long d(TimeUnit timeUnit) {
        return timeUnit.convert(e(), obj1);
    }

    public com.google.common.base.q f() {
        this.c = 0;
        this.b = false;
        return this;
    }

    public com.google.common.base.q g() {
        final int i2 = 1;
        n.v(z ^= i2, "This stopwatch is already running.");
        this.b = i2;
        this.d = this.a.a();
        return this;
    }

    public String toString() {
        long l = e();
        TimeUnit time = q.b(l);
        String str = m.b(d /= d2);
        final String str3 = q.a(time);
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }
}
