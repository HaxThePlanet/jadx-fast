package com.google.android.exoplayer2.l2.v;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.l2.e;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.q;
import com.google.android.exoplayer2.l2.q.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
public final class i implements i {

    private final int a;
    private final com.google.android.exoplayer2.l2.v.j b;
    private final d0 c;
    private final d0 d;
    private final c0 e;
    private k f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    static {
        final com.google.android.exoplayer2.l2.v.c cVar = c.a;
    }

    public i() {
        super(0);
    }

    public i(int i) {
        super();
        this.a = i;
        j obj3 = new j(1);
        this.b = obj3;
        obj3 = new d0(2048);
        this.c = obj3;
        this.i = -1;
        this.h = -1;
        obj3 = new d0(10);
        this.d = obj3;
        c0 c0Var = new c0(obj3.d());
        this.e = c0Var;
    }

    private void e(j j) {
        long i3;
        int i;
        int i2;
        int i4;
        int i5;
        boolean z;
        int i6;
        int obj10;
        if (this.j) {
        }
        i3 = -1;
        this.i = i3;
        j.i();
        if (Long.compare(position, i4) == 0) {
            i(j);
        }
        i = 0;
        i2 = i;
        i5 = 1;
        while (j.e(this.d.d(), i, 2, i5)) {
            this.d.I(i);
            this.e.o(14);
            z = this.e.h(13);
            i4 += l;
            i5 = 1;
        }
        i = i2;
        j.i();
        if (i > 0) {
            this.i = (int)i4;
        } else {
            this.i = i3;
        }
        this.j = i5;
    }

    private static int f(int i, long l2) {
        return (int)i3;
    }

    private q g(long l) {
        super(l, obj5, this.h, obj7, i.f(this.i, this.b.k()), this.i);
        return eVar;
    }

    @RequiresNonNull("extractorOutput")
    private void h(long l, boolean z2, boolean z3) {
        int cmp;
        Object obj6;
        q.b obj7;
        int obj8;
        if (this.l) {
        }
        int i = 1;
        if (z3 != 0 && this.i > 0) {
            obj8 = this.i > 0 ? i : 0;
        } else {
        }
        final long l2 = -9223372036854775807L;
        if (obj8 != null && Long.compare(l3, l2) == 0 && obj9 == null) {
            if (Long.compare(l3, l2) == 0) {
                if (obj9 == null) {
                }
            }
        }
        if (obj8 != null && Long.compare(obj8, l2) != 0) {
            if (Long.compare(obj8, l2) != 0) {
                this.f.d(g(l));
            } else {
                obj7 = new q.b(l2, obj2);
                this.f.d(obj7);
            }
        } else {
        }
        this.l = i;
    }

    private int i(j j) {
        int i2;
        int i3;
        long l;
        int i;
        final int i4 = 0;
        i2 = i4;
        j.m(this.d.d(), i4, 10);
        this.d.I(i4);
        while (this.d.A() != 4801587) {
            this.d.J(3);
            i3 = this.d.w();
            i2 += i;
            j.g(i3);
            j.m(this.d.d(), i4, 10);
            this.d.I(i4);
        }
        j.i();
        j.g(i2);
        if (Long.compare(l, i9) == 0) {
            this.h = (long)i2;
        }
        return i2;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void a(k k) {
        this.f = k;
        e0.d dVar = new e0.d(0, 1);
        this.b.e(k, dVar);
        k.n();
    }

    @Override // com.google.android.exoplayer2.l2.i
    public boolean b(j j) {
        int i;
        int i6;
        int i5;
        int i4;
        boolean z;
        int i7;
        int i3;
        int i2;
        final int i8 = i(j);
        final int i9 = 0;
        i6 = i8;
        i5 = i;
        j.m(this.d.d(), i9, 2);
        this.d.I(i9);
        while (!j.m(this.d.D())) {
            j.i();
            j.g(i6++);
            i5 = i;
            j.m(this.d.d(), i9, 2);
            this.d.I(i9);
            int i11 = 1;
            int i12 = 4;
            j.m(this.d.d(), i9, i12);
            this.e.o(14);
            z = this.e.h(13);
            if (z <= 6) {
            } else {
            }
            j.g(z + -6);
            i5 += z;
            j.i();
            j.g(i6++);
        }
        return i11;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public int c(j j, p p2) {
        long length;
        int i;
        int i2;
        boolean obj7;
        int obj8;
        g.h(this.f);
        length = j.getLength();
        final int i3 = 1;
        final int i4 = 0;
        if (obj8 &= i3 != 0 && Long.compare(length, i) != 0) {
            obj8 = Long.compare(length, i) != 0 ? i3 : i4;
        } else {
        }
        if (obj8 != null) {
            e(j);
        }
        obj7 = j.read(this.c.d(), i4, 2048);
        int i5 = -1;
        i2 = obj7 == i5 ? i3 : i4;
        h(length, obj1, obj8);
        if (i2 != 0) {
            return i5;
        }
        this.c.I(i4);
        this.c.H(obj7);
        if (!this.k) {
            this.b.f(this.g, obj1);
            this.k = i3;
        }
        this.b.b(this.c);
        return i4;
    }

    @Override // com.google.android.exoplayer2.l2.i
    public void d(long l, long l2) {
        this.k = false;
        this.b.c();
        this.g = obj3;
    }
}
