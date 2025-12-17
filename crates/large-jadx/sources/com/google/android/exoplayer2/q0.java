package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.source.h0;
import com.google.android.exoplayer2.util.g;

/* loaded from: classes.dex */
public abstract class q0 extends com.google.android.exoplayer2.g2 {

    private final int b;
    private final h0 c;
    private final boolean d;
    public q0(boolean z, h0 h02) {
        super();
        this.d = z;
        this.c = h02;
        this.b = h02.getLength();
    }

    private int B(int i, boolean z2) {
        int obj1;
        h0 obj2;
        if (z2) {
            obj1 = this.c.d(i);
        } else {
            obj1 = i < obj2-- ? i + 1 : -1;
        }
        return obj1;
    }

    private int C(int i, boolean z2) {
        int obj1;
        h0 obj2;
        if (z2 != null) {
            obj1 = this.c.c(i);
        } else {
            obj1 = i > 0 ? i + -1 : -1;
        }
        return obj1;
    }

    public static Object v(Object object) {
        return object.second;
    }

    public static Object w(Object object) {
        return object.first;
    }

    public static Object y(Object object, Object object2) {
        return Pair.create(object, object2);
    }

    @Override // com.google.android.exoplayer2.g2
    protected abstract int A(int i);

    @Override // com.google.android.exoplayer2.g2
    protected abstract com.google.android.exoplayer2.g2 D(int i);

    @Override // com.google.android.exoplayer2.g2
    public int a(boolean z) {
        boolean z2;
        int i;
        int obj4;
        int i5 = -1;
        if (this.b == 0) {
            return i5;
        }
        if (this.d) {
            obj4 = i;
        }
        if (obj4 != null) {
            i = this.c.b();
        }
        while (D(i).q()) {
        }
        return i3 += obj4;
    }

    @Override // com.google.android.exoplayer2.g2
    public final int b(Object object) {
        int i2;
        int i;
        i = -1;
        if (!object instanceof Pair) {
            return i;
        }
        i2 = s(q0.w(object));
        if (i2 == i) {
            return i;
        }
        int obj4 = D(i2).b(q0.v(object));
        if (obj4 == i) {
        } else {
            i = i2 + obj4;
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.g2
    public int c(boolean z) {
        int i;
        boolean z2;
        int obj4;
        int i2 = this.b;
        int i3 = -1;
        if (i2 == 0) {
            return i3;
        }
        if (this.d) {
            obj4 = 0;
        }
        if (obj4 != null) {
            i = this.c.f();
        } else {
            i2--;
        }
        while (D(i).q()) {
        }
        return i4 += obj4;
    }

    @Override // com.google.android.exoplayer2.g2
    public int e(int i, int i2, boolean z3) {
        int i3;
        int i4;
        int obj6;
        int obj7;
        int obj8;
        final int i6 = 2;
        if (this.d && i2 == 1) {
            if (i2 == 1) {
                obj7 = i6;
            }
            obj8 = i4;
        }
        i3 = u(i);
        int i7 = A(i3);
        if (obj7 == i6) {
        } else {
            i4 = obj7;
        }
        obj6 = D(i3).e(i -= i7, i4, obj8);
        int i5 = -1;
        if (obj6 != i5) {
            return i7 += obj6;
        }
        obj6 = B(i3, obj8);
        while (obj6 != i5) {
            if (D(obj6).q() != 0) {
            }
            obj6 = B(obj6, obj8);
        }
        if (obj6 != i5) {
            return obj7 += obj6;
        }
        if (obj7 == i6) {
            return a(obj8);
        }
        return i5;
    }

    @Override // com.google.android.exoplayer2.g2
    public final com.google.android.exoplayer2.g2.b g(int i, com.google.android.exoplayer2.g2.b g2$b2, boolean z3) {
        int obj5;
        boolean obj7;
        final int i2 = t(i);
        D(i2).g(i -= i4, b2, z3);
        b2.c = obj5 += i3;
        if (z3) {
            obj7 = b2.b;
            g.e(obj7);
            b2.b = q0.y(x(i2), obj7);
        }
        return b2;
    }

    @Override // com.google.android.exoplayer2.g2
    public final com.google.android.exoplayer2.g2.b h(Object object, com.google.android.exoplayer2.g2.b g2$b2) {
        int i = s(q0.w(object));
        D(i).h(q0.v(object), b2);
        b2.c = i2 += i4;
        b2.b = object;
        return b2;
    }

    @Override // com.google.android.exoplayer2.g2
    public int l(int i, int i2, boolean z3) {
        int i3;
        int i4;
        int obj6;
        int obj7;
        int obj8;
        final int i6 = 2;
        if (this.d && i2 == 1) {
            if (i2 == 1) {
                obj7 = i6;
            }
            obj8 = i4;
        }
        i3 = u(i);
        int i7 = A(i3);
        if (obj7 == i6) {
        } else {
            i4 = obj7;
        }
        obj6 = D(i3).l(i -= i7, i4, obj8);
        int i5 = -1;
        if (obj6 != i5) {
            return i7 += obj6;
        }
        obj6 = C(i3, obj8);
        while (obj6 != i5) {
            if (D(obj6).q() != 0) {
            }
            obj6 = C(obj6, obj8);
        }
        if (obj6 != i5) {
            return obj7 += obj6;
        }
        if (obj7 == i6) {
            return c(obj8);
        }
        return i5;
    }

    @Override // com.google.android.exoplayer2.g2
    public final Object m(int i) {
        int i2 = t(i);
        return q0.y(x(i2), D(i2).m(i -= i3));
    }

    @Override // com.google.android.exoplayer2.g2
    public final com.google.android.exoplayer2.g2.c o(int i, com.google.android.exoplayer2.g2.c g2$c2, long l3) {
        Object obj5;
        boolean obj7;
        final int i2 = u(i);
        final int i4 = z(i2);
        D(i2).o(i -= i3, c2, l3);
        if (g2.c.r.equals(c2.a)) {
        } else {
            obj5 = q0.y(x(i2), c2.a);
        }
        c2.a = obj5;
        c2.o = obj5 += i4;
        c2.p = obj5 += i4;
        return c2;
    }

    @Override // com.google.android.exoplayer2.g2
    protected abstract int s(Object object);

    @Override // com.google.android.exoplayer2.g2
    protected abstract int t(int i);

    @Override // com.google.android.exoplayer2.g2
    protected abstract int u(int i);

    @Override // com.google.android.exoplayer2.g2
    protected abstract Object x(int i);

    @Override // com.google.android.exoplayer2.g2
    protected abstract int z(int i);
}
