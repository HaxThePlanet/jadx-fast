package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.w8;
import com.google.android.gms.internal.measurement.z4;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class aa {

    z4 a;
    List<Long> b;
    List<p4> c;
    long d;
    final com.google.android.gms.measurement.internal.ba e;
    aa(com.google.android.gms.measurement.internal.ba ba, com.google.android.gms.measurement.internal.z9 z92) {
        this.e = ba;
        super();
    }

    private static final long b(p4 p4) {
        int i5 = 60;
        return i2 /= i5;
    }

    public final boolean a(long l, p4 p42) {
        Object arrayList2;
        Object arrayList;
        int size;
        long l2;
        long l3;
        r.j(obj10);
        if (this.c == null) {
            arrayList2 = new ArrayList();
            this.c = arrayList2;
        }
        if (this.b == null) {
            arrayList = new ArrayList();
            this.b = arrayList;
        }
        final int i3 = 0;
        if (this.c.size() > 0 && Long.compare(l2, l3) == 0) {
            if (Long.compare(l2, l3) == 0) {
            }
            return i3;
        }
        l4 += l5;
        this.e.S();
        int i5 = 0;
        if (Long.compare(i4, l6) >= 0) {
            return i3;
        }
        this.d = i4;
        this.c.add(obj10);
        this.b.add(Long.valueOf(l));
        this.e.S();
        int obj10 = 1;
        if (this.c.size() >= Math.max(obj10, (Integer)c3.j.a(i5).intValue())) {
            return i3;
        }
        return obj10;
    }
}
