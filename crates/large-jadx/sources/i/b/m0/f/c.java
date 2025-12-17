package i.b.m0.f;

import i.b.m0.c.i;
import i.b.m0.j.q;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class c<T>  implements i<T> {

    static final int A;
    private static final Object B;
    final AtomicLong a;
    int b;
    long c = 8;
    final int v = 8;
    AtomicReferenceArray<Object> w;
    final int x = 8;
    AtomicReferenceArray<Object> y;
    final AtomicLong z;
    static {
        c.A = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
        Object object = new Object();
        c.B = object;
    }

    public c(int i) {
        super();
        AtomicLong atomicLong = new AtomicLong();
        this.a = atomicLong;
        AtomicLong atomicLong2 = new AtomicLong();
        this.z = atomicLong2;
        int obj4 = q.a(Math.max(8, i));
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(obj4 + 1);
        this.w = atomicReferenceArray;
        a(obj4);
        this.y = atomicReferenceArray;
        long l = (long)i4;
        s(0);
    }

    private void a(int i) {
        this.b = Math.min(i /= 4, c.A);
    }

    private static int b(int i) {
        return i;
    }

    private static int c(long l, int i2) {
        obj0 &= obj2;
        c.b(obj0);
        return obj0;
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

    private static <E> Object g(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> h(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        c.b(i2);
        c.q(atomicReferenceArray, i2, 0);
        return (AtomicReferenceArray)c.g(atomicReferenceArray, i2);
    }

    private long i() {
        return this.a.get();
    }

    private T j(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int i3) {
        this.y = atomicReferenceArray;
        return c.g(atomicReferenceArray, c.c(l2, i3));
    }

    private T k(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int i3) {
        int i;
        int obj5;
        this.y = atomicReferenceArray;
        final int obj7 = c.c(l2, i3);
        final Object obj = c.g(atomicReferenceArray, obj7);
        if (obj != null) {
            c.q(atomicReferenceArray, obj7, 0);
            p(l2 += i);
        }
        return obj;
    }

    private void n(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int i3, T t4, long l5) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.w = atomicReferenceArray2;
        final int i = 1;
        this.c = obj10 -= i;
        c.q(atomicReferenceArray2, t4, l5);
        r(atomicReferenceArray, atomicReferenceArray2);
        c.q(atomicReferenceArray, t4, c.B);
        s(l2 += i);
    }

    private void p(long l) {
        this.z.lazySet(l);
    }

    private static void q(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object object3) {
        atomicReferenceArray.lazySet(i2, object3);
    }

    private void r(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        length--;
        c.b(i);
        c.q(atomicReferenceArray, i, atomicReferenceArray2);
    }

    private void s(long l) {
        this.a.lazySet(l);
    }

    private boolean t(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long l3, int i4) {
        c.q(atomicReferenceArray, obj5, t2);
        s(l3 += obj1);
        return 1;
    }

    @Override // i.b.m0.c.i
    public void clear() {
        Object empty;
        while (poll() == null) {
            if (!isEmpty()) {
            }
        }
    }

    @Override // i.b.m0.c.i
    public boolean isEmpty() {
        int i;
        i = Long.compare(l, l2) == 0 ? 1 : 0;
        return i;
    }

    public boolean l(T t, T t2) {
        int i;
        int i2;
        Object length;
        AtomicReferenceArray atomicReferenceArray;
        Object obj9;
        final AtomicReferenceArray atomicReferenceArray2 = this.w;
        long l = i();
        final int i3 = this.v;
        i4 += l;
        if (c.g(atomicReferenceArray2, c.c(i5, obj5)) == null) {
            i = c.c(l, obj2);
            c.q(atomicReferenceArray2, i + 1, t2);
            c.q(atomicReferenceArray2, i, t);
            s(i5);
        } else {
            atomicReferenceArray = new AtomicReferenceArray(atomicReferenceArray2.length());
            this.w = atomicReferenceArray;
            i = c.c(l, obj2);
            c.q(atomicReferenceArray, i + 1, t2);
            c.q(atomicReferenceArray, i, t);
            r(atomicReferenceArray2, atomicReferenceArray);
            c.q(atomicReferenceArray2, i, c.B);
            s(i5);
        }
        return 1;
    }

    public T m() {
        AtomicReferenceArray atomicReferenceArray = this.y;
        final long l = d();
        final int i = this.x;
        Object obj2 = c.g(atomicReferenceArray, c.c(l, obj2));
        if (obj2 == c.B) {
            return j(h(atomicReferenceArray, i + 1), l, obj2);
        }
        return obj2;
    }

    @Override // i.b.m0.c.i
    public int o() {
        long l;
        long l2;
        long l3;
        l = f();
        l3 = f();
        while (Long.compare(l, l3) == 0) {
            l = l3;
            l3 = f();
        }
        return (int)i2;
    }

    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        final AtomicReferenceArray atomicReferenceArray = this.w;
        final long l2 = e();
        int i = this.v;
        int i6 = c.c(l2, obj5);
        if (Long.compare(l2, l3) < 0) {
            return this.t(atomicReferenceArray, t, l2, obj5);
        }
        l4 += l2;
        int i9 = 1;
        if (c.g(atomicReferenceArray, c.c(i7, obj8)) == null) {
            this.c = i7 -= i9;
            return this.t(atomicReferenceArray, t, l2, obj5);
        }
        if (c.g(atomicReferenceArray, c.c(i9 += l2, obj10)) == null) {
            return this.t(atomicReferenceArray, t, l2, obj5);
        }
        this.n(atomicReferenceArray, l2, l2, i6, t);
        return 1;
    }

    public T poll() {
        int i;
        AtomicReferenceArray atomicReferenceArray = this.y;
        long l = d();
        int i3 = this.x;
        int i5 = c.c(l, obj2);
        final Object obj2 = c.g(atomicReferenceArray, i5);
        i = obj2 == c.B ? 1 : 0;
        final int i7 = 0;
        if (obj2 != null && i == 0) {
            if (i == 0) {
                c.q(atomicReferenceArray, i5, i7);
                p(l += i4);
                return obj2;
            }
        }
        if (i != 0) {
            return k(h(atomicReferenceArray, i3 + 1), l, obj2);
        }
        return i7;
    }
}
