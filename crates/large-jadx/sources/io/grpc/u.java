package io.grpc;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Deadline.java */
/* loaded from: classes2.dex */
public final class u implements Comparable<u> {

    private static final u.b v = new u$b(0);
    private static final long w = 0L;
    private static final long x = 0L;
    private static final long y = 0L;
    private final u.c a;
    private final long b;
    private volatile boolean c;

    static class a {
    }

    public static abstract class c {
        public abstract long a();
    }

    private static class b extends u.c {
        private b() {
            super();
        }

        @Override // io.grpc.u$c
        public long a() {
            return System.nanoTime();
        }

        /* synthetic */ b(u.a aVar) {
            this();
        }
    }
    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        u.w = nanos;
        u.x = -nanos;
        u.y = TimeUnit.SECONDS.toNanos(1L);
    }

    private u(u.c cVar, long j, boolean z) {
        this(cVar, cVar.a(), l2, j, obj, z);
    }

    public static u a(long j, TimeUnit timeUnit) {
        return u.c(j, timeUnit, u.v);
    }

    public static u c(long j, TimeUnit timeUnit, u.c cVar) {
        u.e(timeUnit, "units");
        return new u(cVar, timeUnit.toNanos(j), r2, 1);
    }

    private static <T> T e(T t, Object object) {
        if (t == 0) {
            throw new NullPointerException(String.valueOf(object));
        } else {
            return t;
        }
    }

    private void f(u uVar) {
        if (this.a != uVar.a) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Tickers (";
            String str2 = " and ";
            String str3 = ") don't match. Custom Ticker should only be used in tests!";
            uVar = str + this.a + str2 + uVar.a + str3;
            throw new AssertionError(uVar);
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        final boolean z = true;
        if (object == this) {
            return true;
        }
        final boolean z3 = false;
        if (!(object instanceof u)) {
            return false;
        }
        if (this.a == null) {
            if (object.a != null) {
                return false;
            }
        }
        return this.b != object.b ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Object[] arr = new Object[2];
        int i3 = 0;
        arr[i3] = this.a;
        arr[1] = Long.valueOf(this.b);
        return Arrays.asList(arr).hashCode();
    }

    public int i(u uVar) {
        f(uVar);
        long l2 = this.b - uVar.b;
        if (this.b < 0) {
            return -1;
        }
        if (this.b > 0) {
            return 1;
        }
        return 0;
    }

    public boolean j(u uVar) {
        boolean z = true;
        f(uVar);
        long l2 = this.b - uVar.b;
        uVar = this.b < 0 ? 1 : 0;
        return (this.b < 0 ? 1 : 0);
    }

    public boolean k() {
        final boolean z2 = true;
        if (!this.c) {
            l = this.b - this.a.a();
            long l2 = 0L;
            if (this.b <= l2) {
                this.c = z2;
            }
            return false;
        }
        return true;
    }

    public u m(u uVar) {
        io.grpc.u obj;
        f(uVar);
        if (j(uVar)) {
            obj = this;
        }
        return obj;
    }

    public long n(TimeUnit timeUnit) {
        long l2 = this.a.a();
        if (!this.c) {
            long l6 = this.b - l2;
            long l = 0L;
            if (this.c <= l) {
                boolean z = true;
                this.c = z;
            }
        }
        return timeUnit.convert(this.b - l2, TimeUnit.NANOSECONDS);
    }

    @Override // java.lang.Object
    public String toString() {
        long l2 = n(TimeUnit.NANOSECONDS);
        long l4 = u.y;
        l = Math.abs(l2) / l4;
        long l5 = Math.abs(l2) % l4;
        StringBuilder stringBuilder2 = new StringBuilder();
        final long l7 = 0L;
        if (l2 < l7) {
            stringBuilder2.append('-');
        }
        stringBuilder2.append(Math.abs(l2, l3) / u.y);
        if (l5 > l7) {
            Object[] arr = new Object[1];
            stringBuilder2.append(String.format(Locale.US, ".%09d", new Object[] { Long.valueOf(l5) }));
        }
        stringBuilder2.append("s from now");
        if (this.a != u.v) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = " (ticker=";
            String str5 = ")";
            str2 = str4 + this.a + str5;
            stringBuilder2.append(str2);
        }
        return stringBuilder2.toString();
    }

    private u(u.c cVar, long j, long j2, boolean z) {
        int i = 0;
        super();
        this.a = cVar;
        long min = Math.min(u.w, Math.max(u.x, j2));
        this.b = j + min;
        if (z) {
            cVar = min <= 0 ? 1 : 0;
        }
        this.c = (min <= 0 ? 1 : 0);
    }
}
