package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.c0;
import com.google.android.gms.common.f0;
import com.google.android.gms.common.h0;
import com.google.android.gms.dynamic.a;
import f.c.a.d.b.g.a;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public final class x0 extends a implements com.google.android.gms.common.internal.z0 {
    x0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // f.c.a.d.b.g.a
    public final boolean S0(h0 h0, a a2) {
        final Parcel parcel = n();
        c.d(parcel, h0);
        c.e(parcel, a2);
        Parcel obj2 = j(5, parcel);
        obj2.recycle();
        return c.a(obj2);
    }

    @Override // f.c.a.d.b.g.a
    public final boolean d() {
        Parcel parcel2 = j(7, n());
        parcel2.recycle();
        return c.a(parcel2);
    }

    @Override // f.c.a.d.b.g.a
    public final f0 z0(c0 c0) {
        Parcel parcel = n();
        c.d(parcel, c0);
        Parcel obj2 = j(6, parcel);
        obj2.recycle();
        return (f0)c.c(obj2, f0.CREATOR);
    }
}
