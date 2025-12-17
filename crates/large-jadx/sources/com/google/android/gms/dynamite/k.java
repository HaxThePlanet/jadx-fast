package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.a.a;
import f.c.a.d.b.g.a;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public final class k extends a implements IInterface {
    k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    @Override // f.c.a.d.b.g.a
    public final a p2(a a, String string2, int i3, a a4) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeInt(i3);
        c.e(parcel, a4);
        Parcel obj2 = j(2, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }

    @Override // f.c.a.d.b.g.a
    public final a q2(a a, String string2, int i3, a a4) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeInt(i3);
        c.e(parcel, a4);
        Parcel obj2 = j(3, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }
}
