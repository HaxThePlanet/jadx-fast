package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class v implements com.google.android.gms.internal.measurement.q {
    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        return q.h;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        return Boolean.FALSE;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        return object instanceof v;
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return 0;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        Object[] obj4 = new Object[1];
        IllegalStateException obj3 = new IllegalStateException(String.format("Undefined has no function %s", string));
        throw obj3;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        return Double.valueOf(9221120237041090560L);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        return "undefined";
    }
}
