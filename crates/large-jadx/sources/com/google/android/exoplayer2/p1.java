package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.x;
import com.google.android.exoplayer2.source.y.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;

/* loaded from: classes.dex */
final class p1 {

    public final y.a a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    p1(y.a y$a, long l2, long l3, long l4, long l5, boolean z6, boolean z7, boolean z8, boolean z9) {
        int i3;
        int i;
        int i2;
        final Object obj = this;
        final boolean z = obj18;
        final boolean z2 = obj19;
        final boolean z3 = obj20;
        final boolean z4 = obj21;
        super();
        i3 = 0;
        final int i4 = 1;
        if (z4) {
            if (z2) {
                i = i4;
            } else {
                i = i3;
            }
        } else {
        }
        g.a(i);
        if (z3) {
            if (z2) {
                i2 = i4;
            } else {
                i2 = i3;
            }
        } else {
        }
        g.a(i2);
        if (z) {
            if (!z2 && !z3 && !z4) {
                if (!z3) {
                    i3 = !z4 ? i4 : i3;
                }
            }
        } else {
        }
        g.a(i3);
        obj.a = a;
        obj.b = l2;
        obj.c = l4;
        obj.d = z6;
        obj.e = z8;
        obj.f = z;
        obj.g = z2;
        obj.h = z3;
        obj.i = z4;
    }

    public com.google.android.exoplayer2.p1 a(long l) {
        Object p1Var2;
        boolean z3;
        com.google.android.exoplayer2.p1 p1Var;
        y.a aVar;
        long l4;
        long l2;
        long l5;
        long l3;
        boolean z;
        boolean z5;
        boolean z4;
        boolean z2;
        final Object obj = this;
        if (Long.compare(l, l6) == 0) {
            p1Var2 = obj;
        } else {
            super(obj.a, obj.b, obj6, l, obj8, obj.d, obj10, obj.e, obj12, obj.f, obj.g, obj.h, obj.i);
        }
        return p1Var2;
    }

    public com.google.android.exoplayer2.p1 b(long l) {
        Object p1Var2;
        boolean z;
        com.google.android.exoplayer2.p1 p1Var;
        y.a aVar;
        long l2;
        long l5;
        long l3;
        long l4;
        boolean z3;
        boolean z5;
        boolean z2;
        boolean z4;
        final Object obj = this;
        if (Long.compare(l, l6) == 0) {
            p1Var2 = obj;
        } else {
            super(obj.a, l, obj6, obj.c, obj8, obj.d, obj10, obj.e, obj12, obj.f, obj.g, obj.h, obj.i);
        }
        return p1Var2;
    }

    public boolean equals(Object object) {
        int i;
        int cmp;
        Class<com.google.android.exoplayer2.p1> obj;
        Class class;
        long l;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (p1.class != object.getClass()) {
            } else {
                if (Long.compare(l2, l) == 0 && Long.compare(l3, l) == 0 && Long.compare(l4, l) == 0 && Long.compare(l5, l) == 0 && this.f == object.f && this.g == object.g && this.h == object.h && this.i == object.i && p0.b(this.a, object.a)) {
                    if (Long.compare(l3, l) == 0) {
                        if (Long.compare(l4, l) == 0) {
                            if (Long.compare(l5, l) == 0) {
                                if (this.f == object.f) {
                                    if (this.g == object.g) {
                                        if (this.h == object.h) {
                                            if (this.i == object.i) {
                                                if (p0.b(this.a, object.a)) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i22 += z4;
    }
}
