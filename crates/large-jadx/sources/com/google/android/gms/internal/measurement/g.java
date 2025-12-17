package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class g implements com.google.android.gms.internal.measurement.q {

    private final boolean a = false;
    public g(Boolean boolean) {
        super();
        if (boolean != null) {
            boolean obj1 = boolean.booleanValue();
        }
        obj1 = 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        g gVar = new g(Boolean.valueOf(this.a));
        return gVar;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        return Boolean.valueOf(this.a);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (this.a == object.a) {
            return i;
        }
        return i2;
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        return Boolean.valueOf(this.a).hashCode();
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        if (!"toString".equals(string)) {
        } else {
            u obj3 = new u(Boolean.toString(this.a));
            return obj3;
        }
        Object[] obj5 = new Object[2];
        IllegalArgumentException obj4 = new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.a), string));
        throw obj4;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String toString() {
        return String.valueOf(this.a);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        int i;
        final int i2 = 1;
        i = i2 != this.a ? 0 : 4607182418800017408L;
        return Double.valueOf(i);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        return Boolean.toString(this.a);
    }
}
