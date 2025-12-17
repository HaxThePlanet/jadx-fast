package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: classes2.dex */
final class eb extends com.google.android.gms.internal.measurement.gb {
    eb(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final double a(Object object, long l2) {
        return Double.longBitsToDouble(k(object, l2));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final float b(Object object, long l2) {
        return Float.intBitsToFloat(j(object, l2));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void c(Object object, long l2, boolean z3) {
        if (hb.i) {
            hb.p(object, l2, z3);
        }
        hb.q(object, l2, z3);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void d(Object object, long l2, byte b3) {
        if (hb.i) {
            hb.n(object, l2, b3);
        }
        hb.o(object, l2, b3);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void e(Object object, long l2, double d3) {
        this.o(object, l2, obj3);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void f(Object object, long l2, float f3) {
        n(object, l2, f3);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final boolean g(Object object, long l2) {
        if (hb.i) {
            return hb.y(object, l2);
        }
        return hb.z(object, l2);
    }
}
