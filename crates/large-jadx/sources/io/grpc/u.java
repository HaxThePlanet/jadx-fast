package io.grpc;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class u implements Comparable<io.grpc.u> {

    private static final io.grpc.u.b v;
    private static final long w;
    private static final long x;
    private static final long y;
    private final io.grpc.u.c a;
    private final long b;
    private volatile boolean c;

    static class a {
    }

    public static abstract class c {
        public abstract long a();
    }

    private static class b extends io.grpc.u.c {
        b(io.grpc.u.a u$a) {
            super();
        }

        @Override // io.grpc.u$c
        public long a() {
            return System.nanoTime();
        }
    }
    static {
        u.b bVar = new u.b(0);
        u.v = bVar;
        long nanos = TimeUnit.DAYS.toNanos(36500);
        u.w = nanos;
        u.x = -nanos;
        u.y = TimeUnit.SECONDS.toNanos(1);
    }

    private u(io.grpc.u.c u$c, long l2, long l3, boolean z4) {
        io.grpc.u.c obj5;
        super();
        this.a = c;
        long obj8 = Math.min(u.w, obj1);
        this.b = l2 += obj8;
        if (obj10 != null && Long.compare(obj8, obj5) <= 0) {
            obj5 = Long.compare(obj8, obj5) <= 0 ? 1 : 0;
        } else {
        }
        this.c = obj5;
    }

    private u(io.grpc.u.c u$c, long l2, boolean z3) {
        super(c, c.a(), obj3, l2, obj5, obj11);
    }

    public static io.grpc.u a(long l, TimeUnit timeUnit2) {
        return u.c(l, timeUnit2, obj3);
    }

    public static io.grpc.u c(long l, TimeUnit timeUnit2, io.grpc.u.c u$c3) {
        u.e(c3, "units");
        u uVar = new u(obj4, c3.toNanos(l), timeUnit2, 1);
        return uVar;
    }

    private static <T> T e(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }

    private void f(io.grpc.u u) {
        if (this.a != u.a) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tickers (");
        stringBuilder.append(this.a);
        stringBuilder.append(" and ");
        stringBuilder.append(u.a);
        stringBuilder.append(") don't match. Custom Ticker should only be used in tests!");
        AssertionError assertionError = new AssertionError(stringBuilder.toString());
        throw assertionError;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return i((u)object);
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        io.grpc.u.c cVar;
        io.grpc.u.c cVar2;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof u) {
            return i2;
        }
        cVar = this.a;
        if (cVar == null) {
            if (object.a != null) {
                return i2;
            }
        } else {
            if (cVar != object.a) {
            }
        }
        if (Long.compare(l, l2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        Object[] arr = new Object[2];
        int i3 = 0;
        arr[i3] = this.a;
        arr[1] = Long.valueOf(this.b);
        return Arrays.asList(arr).hashCode();
    }

    @Override // java.lang.Comparable
    public int i(io.grpc.u u) {
        f(u);
        int obj5 = Long.compare(i, i2);
        if (obj5 < 0) {
            return -1;
        }
        if (obj5 > 0) {
            return 1;
        }
        return 0;
    }

    @Override // java.lang.Comparable
    public boolean j(io.grpc.u u) {
        int obj5;
        f(u);
        obj5 = Long.compare(i, i2) < 0 ? 1 : 0;
        return obj5;
    }

    @Override // java.lang.Comparable
    public boolean k() {
        boolean cmp;
        int i;
        int i2;
        final int i4 = 1;
        if (!this.c && Long.compare(i, i2) <= 0) {
            if (Long.compare(i, i2) <= 0) {
                this.c = i4;
            }
            return 0;
        }
        return i4;
    }

    @Override // java.lang.Comparable
    public io.grpc.u m(io.grpc.u u) {
        io.grpc.u obj2;
        f(u);
        if (j(u)) {
            obj2 = this;
        }
        return obj2;
    }

    @Override // java.lang.Comparable
    public long n(TimeUnit timeUnit) {
        boolean cmp;
        int i;
        long l = this.a.a();
        if (!this.c && Long.compare(i3, i) <= 0) {
            if (Long.compare(i3, i) <= 0) {
                this.c = true;
            }
        }
        return timeUnit.convert(l2 -= l, obj3);
    }

    @Override // java.lang.Comparable
    public String toString() {
        int cmp;
        int format;
        Object string;
        long arr;
        Object str;
        int str2;
        Long valueOf;
        long l = n(TimeUnit.NANOSECONDS);
        long l3 = u.y;
        l4 %= l3;
        StringBuilder stringBuilder2 = new StringBuilder();
        final int i4 = 0;
        if (Long.compare(l, i4) < 0) {
            stringBuilder2.append('-');
        }
        stringBuilder2.append(l2 /= l3);
        if (Long.compare(i3, i4) > 0) {
            arr = new Object[1];
            stringBuilder2.append(String.format(Locale.US, ".%09d", Long.valueOf(i3)));
        }
        stringBuilder2.append("s from now");
        if (this.a != u.v) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" (ticker=");
            stringBuilder.append(this.a);
            stringBuilder.append(")");
            stringBuilder2.append(stringBuilder.toString());
        }
        return stringBuilder2.toString();
    }
}
