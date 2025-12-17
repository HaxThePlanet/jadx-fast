package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l0<V>  {

    private long[] a;
    private V[] b;
    private int c;
    private int d;
    public l0() {
        super(10);
    }

    public l0(int i) {
        super();
        this.a = new long[i];
        this.b = l0.f(i);
    }

    private void b(long l, V v2) {
        int i4 = this.d;
        final Object[] objArr = this.b;
        i2 %= length;
        this.a[i3] = l;
        objArr[i3] = obj7;
        this.d = i4++;
    }

    private void d(long l) {
        int i;
        long l2;
        long obj4;
        i = this.d;
        if (i > 0 && Long.compare(l, l2) <= 0) {
            if (Long.compare(l, l2) <= 0) {
                c();
            }
        }
    }

    private void e() {
        int i;
        int i2;
        int length = objArr.length;
        if (this.d < length) {
        }
        int i5 = length * 2;
        final long[] lArr = new long[i5];
        Object[] objArr2 = l0.f(i5);
        int i6 = this.c;
        length -= i6;
        final int i7 = 0;
        System.arraycopy(this.a, i6, lArr, i7, i3);
        System.arraycopy(this.b, this.c, objArr2, i7, i3);
        i = this.c;
        if (i > 0) {
            System.arraycopy(this.a, i7, lArr, i3, i);
            System.arraycopy(this.b, i7, objArr2, i3, this.c);
        }
        this.a = lArr;
        this.b = objArr2;
        this.c = i7;
    }

    private static <V> V[] f(int i) {
        return new Object[i];
    }

    private V h(long l, boolean z2) {
        int i;
        long cmp2;
        int i2;
        long l2;
        int cmp;
        i = 0;
        cmp2 = Long.MAX_VALUE;
        while (this.d > 0) {
            i2 = l - l2;
            if (Long.compare(i2, i4) < 0) {
                break;
            } else {
            }
            i = k();
            cmp2 = i2;
            if (obj10 == null) {
                break;
            }
            if (Long.compare(cmp, cmp2) >= 0) {
                break;
            } else {
            }
        }
        return i;
    }

    private V k() {
        int i;
        final int i5 = 1;
        i = this.d > 0 ? i5 : 0;
        g.f(i);
        Object[] objArr = this.b;
        int i6 = this.c;
        objArr[i6] = 0;
        this.c = i7 %= length;
        this.d = i3 -= i5;
        return objArr[i6];
    }

    public void a(long l, V v2) {
        d(l);
        e();
        b(l, v2);
        return;
        synchronized (this) {
            d(l);
            e();
            b(l, v2);
        }
    }

    public void c() {
        int i = 0;
        this.c = i;
        this.d = i;
        Arrays.fill(this.b, 0);
        return;
        synchronized (this) {
            i = 0;
            this.c = i;
            this.d = i;
            Arrays.fill(this.b, 0);
        }
    }

    public V g(long l) {
        return h(l, obj3);
        synchronized (this) {
            return h(l, obj3);
        }
    }

    public V i() {
        int i;
        synchronized (this) {
            try {
                i = 0;
                i = k();
                return i;
                throw th;
            }
        }
    }

    public V j(long l) {
        return h(l, obj3);
        synchronized (this) {
            return h(l, obj3);
        }
    }

    public int l() {
        return this.d;
        synchronized (this) {
            return this.d;
        }
    }
}
