package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.a.a;
import f.c.a.d.b.g.a;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public final class j extends a implements IInterface {
    j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // f.c.a.d.b.g.a
    public final a p2(a a, String string2, int i3) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeInt(i3);
        Parcel obj2 = j(2, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }

    @Override // f.c.a.d.b.g.a
    public final int q2(a a, String string2, boolean z3) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        c.b(parcel, z3);
        Parcel obj2 = j(3, parcel);
        obj2.recycle();
        return obj2.readInt();
    }

    @Override // f.c.a.d.b.g.a
    public final a r2(a a, String string2, int i3) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeInt(i3);
        Parcel obj2 = j(4, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }

    @Override // f.c.a.d.b.g.a
    public final int s2(a a, String string2, boolean z3) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        c.b(parcel, z3);
        Parcel obj2 = j(5, parcel);
        obj2.recycle();
        return obj2.readInt();
    }

    @Override // f.c.a.d.b.g.a
    public final int t2() {
        Parcel parcel2 = j(6, n());
        parcel2.recycle();
        return parcel2.readInt();
    }

    @Override // f.c.a.d.b.g.a
    public final a u2(a a, String string2, boolean z3, long l4) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        c.b(parcel, z3);
        parcel.writeLong(l4);
        Parcel obj2 = j(7, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }

    @Override // f.c.a.d.b.g.a
    public final a v2(a a, String string2, int i3, a a4) {
        final Parcel parcel = n();
        c.e(parcel, a);
        parcel.writeString(string2);
        parcel.writeInt(i3);
        c.e(parcel, a4);
        Parcel obj2 = j(8, parcel);
        obj2.recycle();
        return a.a.m(obj2.readStrongBinder());
    }
}
