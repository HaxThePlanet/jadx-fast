package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.a.a;
import f.c.a.d.b.g.a;

/* loaded from: classes2.dex */
public final class y1 extends a implements com.google.android.gms.common.internal.a2 {
    y1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override // f.c.a.d.b.g.a
    public final int a() {
        Parcel parcel2 = j(2, n());
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // f.c.a.d.b.g.a
    public final a b() {
        Parcel parcel2 = j(1, n());
        parcel2.recycle();
        return a.a.m(parcel2.readStrongBinder());
    }
}
