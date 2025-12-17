package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class h implements com.google.android.gms.internal.measurement.q {

    private final com.google.android.gms.internal.measurement.q a;
    private final String b;
    public h() {
        super();
        throw 0;
    }

    public h(String string) {
        super();
        this.a = q.h;
        this.b = string;
    }

    public h(String string, com.google.android.gms.internal.measurement.q q2) {
        super();
        this.a = q2;
        this.b = string;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final com.google.android.gms.internal.measurement.q b() {
        h hVar = new h(this.b, this.a.b());
        return hVar;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String c() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Boolean d() {
        IllegalStateException illegalStateException = new IllegalStateException("Control is not a boolean");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final boolean equals(Object object) {
        boolean equals;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof h) {
            return i2;
        }
        if (this.b.equals(object.b) && this.a.equals(object.a)) {
            if (this.a.equals(object.a)) {
                return i;
            }
        }
        return i2;
    }

    public final Iterator<com.google.android.gms.internal.measurement.q> h() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final int hashCode() {
        return i2 += i4;
    }

    public final com.google.android.gms.internal.measurement.q m(String string, com.google.android.gms.internal.measurement.b5 b52, List<com.google.android.gms.internal.measurement.q> list3) {
        IllegalStateException obj1 = new IllegalStateException("Control does not have functions");
        throw obj1;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final Double zzh() {
        IllegalStateException illegalStateException = new IllegalStateException("Control is not a double");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.internal.measurement.q
    public final String zzi() {
        IllegalStateException illegalStateException = new IllegalStateException("Control is not a String");
        throw illegalStateException;
    }
}
