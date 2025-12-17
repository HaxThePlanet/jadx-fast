package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class r implements com.google.android.gms.internal.measurement.q {

    private final String a;
    private final ArrayList<com.google.android.gms.internal.measurement.q> b;
    public r(String string, List<com.google.android.gms.internal.measurement.q> list2) {
        super();
        this.a = string;
        ArrayList obj1 = new ArrayList();
        this.b = obj1;
        obj1.addAll(list2);
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        return this;
    }

    public final ArrayList<com.google.android.gms.internal.measurement.q> c() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        IllegalStateException illegalStateException = new IllegalStateException("Statement cannot be cast as Boolean");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        String equals;
        String str;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (!object instanceof r) {
            return i;
        }
        String str2 = this.a;
        if (str2 != null) {
            if (!str2.equals(object.a)) {
                return i;
            }
        } else {
            if (object.a != null) {
            }
        }
        return this.b.equals(object.b);
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        int i;
        String str = this.a;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        return i2 += i4;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        IllegalStateException obj1 = new IllegalStateException("Statement is not an evaluated entity");
        throw obj1;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        IllegalStateException illegalStateException = new IllegalStateException("Statement cannot be cast as Double");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        IllegalStateException illegalStateException = new IllegalStateException("Statement cannot be cast as String");
        throw illegalStateException;
    }
}
