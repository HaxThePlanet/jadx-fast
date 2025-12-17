package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class df extends com.google.android.gms.internal.measurement.j {

    final boolean c;
    final boolean v;
    final com.google.android.gms.internal.measurement.ef w;
    public df(com.google.android.gms.internal.measurement.ef ef, boolean z2, boolean z3) {
        this.w = ef;
        super("log");
        this.c = z2;
        this.v = z3;
    }

    public final com.google.android.gms.internal.measurement.q a(com.google.android.gms.internal.measurement.b5 b5, List<com.google.android.gms.internal.measurement.q> list2) {
        int size;
        int i2;
        int i4;
        int i;
        int i3;
        final int i7 = 1;
        b6.i("log", i7, list2);
        int i8 = 0;
        if (list2.size() == i7) {
            ef.e(this.w).a(3, b5.b((q)list2.get(i8)).zzi(), Collections.emptyList(), this.c, this.v);
            return q.h;
        }
        int i5 = b6.b(b5.b((q)list2.get(i8)).zzh().doubleValue());
        int i9 = 5;
        i4 = 2;
        if (i5 != i4) {
            if (i5 != 3) {
                if (i5 != i9) {
                    if (i5 != 6) {
                        i3 = i2;
                    } else {
                        i3 = i4;
                    }
                } else {
                    i3 = i9;
                }
            } else {
                i3 = i7;
            }
        } else {
            i2 = 4;
        }
        String str3 = b5.b((q)list2.get(i7)).zzi();
        if (list2.size() == i4) {
            ef.e(this.w).a(i3, str3, Collections.emptyList(), this.c, this.v);
            return q.h;
        }
        ArrayList arrayList = new ArrayList();
        while (i4 < Math.min(list2.size(), i9)) {
            arrayList.add(b5.b((q)list2.get(i4)).zzi());
            i4++;
        }
        ef.e(this.w).a(i3, str3, arrayList, this.c, this.v);
        return q.h;
    }
}
