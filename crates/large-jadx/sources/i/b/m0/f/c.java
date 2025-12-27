package i.b.m0.f;

import i.b.m0.c.i;
import i.b.m0.j.q;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue.java */
/* loaded from: classes3.dex */
public final class c<T> implements i<T> {

    static final int A = 0;
    private static final Object B = new Object();
    final AtomicLong a = new AtomicLong();
    int b;
    long c;
    final int v;
    AtomicReferenceArray<Object> w = new AtomicReferenceArray<>();
    final int x;
    AtomicReferenceArray<Object> y = new AtomicReferenceArray<>();
    final AtomicLong z = new AtomicLong();
    static {
        c.A = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    }

    public c(int i) {
        super();
        AtomicLong atomicLong = new AtomicLong();
        AtomicLong atomicLong2 = new AtomicLong();
        int i7 = q.a(Math.max(8, i));
        int i3 = i7 - 1;
        this.v = i3;
        a(i7);
        this.x = i3;
        this.c = (long)(i3 - 1);
        s(0L);
    }

    private void a(int i) {
        this.b = Math.min(i / 4, c.A);
    }

    private static int c(long j, int i) {
        i &= i;
        c.b(i3);
        return i3;
    }

    private long d() {
        return this.z.get();
    }

    private long e() {
        return this.a.get();
    }

    private long f() {
        return this.z.get();
    }

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        c.b(i);
        c.q(atomicReferenceArray, i, null);
        return (AtomicReferenceArray)c.g(atomicReferenceArray, i);
    }

    private long i() {
        return this.a.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.y = atomicReferenceArray;
        return c.g(atomicReferenceArray, c.c(j, i));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.y = atomicReferenceArray;
        final int i2 = c.c(j, i);
        final Object obj = c.g(atomicReferenceArray, i2);
        if (obj != null) {
            c.q(atomicReferenceArray, i2, null);
            long l = 1L;
            l2 = j + l;
            p(l2);
        }
        return obj;
    }

    private void n(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        final AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.w = atomicReferenceArray2;
        final long l = 1L;
        this.c = (j2 + j) - l;
        c.q(atomicReferenceArray2, i, t);
        r(atomicReferenceArray, atomicReferenceArray2);
        c.q(atomicReferenceArray, i, c.B);
        s(j + l);
    }

    private void p(long j) {
        this.z.lazySet(j);
    }

    private static void q(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object object) {
        atomicReferenceArray.lazySet(i, object);
    }

    private void r(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int i = atomicReferenceArray.length() - 1;
        c.b(i);
        c.q(atomicReferenceArray, i, atomicReferenceArray2);
    }

    private void s(long j) {
        this.a.lazySet(j);
    }

    private boolean t(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        c.q(atomicReferenceArray, i, t);
        s(j + 1L);
        return true;
    }

    public void clear() {
        while (poll() == null) {
        }
    }

    public boolean isEmpty() {
        boolean z = true;
        long l = i();
        final long l2 = f();
        int r0 = l == l2 ? 1 : 0;
        return (l == l2 ? 1 : 0);
    }

    public boolean l(T t, T t2) {
        long l = i();
        long l3 = 2L + l;
        if (c.g(this.w, c.c(l3, this.v)) == null) {
            int i = c.c(l, this.v);
            i2 = i + 1;
            c.q(this.w, i2, t2);
            c.q(this.w, i, t);
            s(l3);
        } else {
            AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(this.w.length());
            this.w = atomicReferenceArray;
            i = c.c(l, this.v);
            i2 = i + 1;
            c.q(atomicReferenceArray, i2, t2);
            c.q(atomicReferenceArray, i, t);
            r(this.w, atomicReferenceArray);
            c.q(this.w, i, c.B);
            s(l3);
        }
        return true;
    }

    public T m() {
        final long l = d();
        Object obj2 = c.g(this.y, c.c(l, this.x));
        if (obj2 == c.B) {
            return j(h(this.y, i + 1), l, this.x);
        }
        return obj2;
    }

    public int o() {
        long l;
        l = f();
        l = f();
        while (l == l) {
            l = f();
        }
        return (int)(i() - l);
    }

    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        final long l = e();
        int i5 = c.c(l, this.v);
        if (l < this.c) {
            return this.t(this.w, t, l, i5);
        }
        long l6 = (long)this.b + l;
        long l10 = 1L;
        if (c.g(this.w, c.c(l6, this.v)) == null) {
            this.c = l6 - 1L;
            return this.t(this.w, t, l, i5);
        }
        if (c.g(this.w, c.c(1L + l, this.v)) == null) {
            return this.t(this.w, t, l, i5);
        }
        this.n(this.w, l, i5, t, (long)i);
        return true;
    }

    public T poll() {
        int i = 0;
        long l = d();
        int i4 = c.c(l, this.x);
        final Object obj2 = c.g(this.y, i4);
        int r6 = obj2 == c.B ? 1 : 0;
        final Object obj4 = null;
        if (obj2 != null && c.B == 0) {
            c.q(this.y, i4, obj4);
            p(l + 1L);
            return obj2;
        }
        if (c.B != 0) {
            return k(h(this.y, i2 + 1), l, this.x);
        }
        return obj4;
    }

    private static int b(int i) {
        return i;
    }
}
