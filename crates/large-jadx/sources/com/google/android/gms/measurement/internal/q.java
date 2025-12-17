package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
final class q {

    final String a;
    final String b;
    final long c;
    final long d;
    final long e;
    final long f;
    final long g;
    final Long h;
    final Long i;
    final Long j;
    final Boolean k;
    q(String string, String string2, long l3, long l4, long l5, long l6, long l7, Long long8, Long long9, Long long10, Boolean boolean11) {
        int i;
        int i2;
        int i4;
        int i3;
        final Object obj = this;
        int i5 = l3;
        final int i6 = l5;
        final int i7 = l7;
        final int i8 = boolean11;
        super();
        r.f(string);
        r.f(string2);
        int i9 = 0;
        i3 = 1;
        final int i10 = 0;
        i = Long.compare(i5, i9) >= 0 ? i3 : i10;
        r.a(i);
        i2 = Long.compare(i6, i9) >= 0 ? i3 : i10;
        r.a(i2);
        i4 = Long.compare(i7, i9) >= 0 ? i3 : i10;
        r.a(i4);
        if (Long.compare(i8, i9) >= 0) {
        } else {
            i3 = i10;
        }
        r.a(i3);
        obj.a = string;
        obj.b = string2;
        obj.c = i5;
        obj.d = i6;
        obj.e = i7;
        obj.f = long9;
        obj.g = i8;
        obj.h = obj27;
        obj.i = obj28;
        obj.j = obj29;
        obj.k = obj30;
    }

    final com.google.android.gms.measurement.internal.q a(Long long, Long long2, Boolean boolean3) {
        boolean booleanValue;
        int i;
        final Object obj = this;
        if (boolean3 != 0 && !boolean3.booleanValue()) {
            i = !boolean3.booleanValue() ? booleanValue : boolean3;
        } else {
        }
        super(obj.a, obj.b, obj.c, obj6, obj.d, obj8, obj.e, obj10, obj.f, obj12, obj.g, obj14, obj.h, long, long2, i);
        return qVar;
    }

    final com.google.android.gms.measurement.internal.q b(long l, long l2) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj9, obj.f, obj11, l, obj13, Long.valueOf(obj22), obj.i, obj.j, obj.k);
        return qVar3;
    }

    final com.google.android.gms.measurement.internal.q c(long l) {
        final Object obj = this;
        super(obj.a, obj.b, obj.c, obj5, obj.d, obj7, obj.e, obj9, l, obj11, obj.g, obj13, obj.h, obj.i, obj.j, obj.k);
        return qVar3;
    }
}
