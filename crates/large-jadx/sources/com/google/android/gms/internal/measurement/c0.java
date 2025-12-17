package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes2.dex */
final class c0 implements Comparator<com.google.android.gms.internal.measurement.q> {

    final com.google.android.gms.internal.measurement.j a;
    final com.google.android.gms.internal.measurement.b5 b;
    c0(com.google.android.gms.internal.measurement.j j, com.google.android.gms.internal.measurement.b5 b52) {
        this.a = j;
        this.b = b52;
        super();
    }

    @Override // java.util.Comparator
    public final int compare(Object object, Object object2) {
        boolean arr;
        int compareTo;
        boolean obj6;
        Object obj7;
        final com.google.android.gms.internal.measurement.j jVar = this.a;
        final int i2 = 0;
        if (object instanceof v && !object2 instanceof v) {
            if (!object2 instanceof v) {
                return compareTo;
            }
            return i2;
        }
        if (object2 instanceof v) {
            compareTo = -1;
        } else {
            if (jVar == null) {
                compareTo = (q)object.zzi().compareTo((q)object2.zzi());
            } else {
                arr = new q[2];
                arr[i2] = object;
                arr[1] = object2;
                compareTo = (int)obj6;
            }
        }
    }
}
