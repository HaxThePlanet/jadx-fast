package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import f.c.a.d.b.g.b;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public abstract class z1 extends b implements com.google.android.gms.common.internal.a2 {
    public z1() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static com.google.android.gms.common.internal.a2 m(IBinder iBinder) {
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        if (localInterface instanceof a2) {
            return (a2)localInterface;
        }
        y1 y1Var = new y1(iBinder);
        return y1Var;
    }

    @Override // f.c.a.d.b.g.b
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        int obj1;
        int obj4;
        final int obj2 = 1;
        if (i != obj2) {
            if (i != 2) {
                return 0;
            }
            parcel3.writeNoException();
            parcel3.writeInt(a());
        } else {
            parcel3.writeNoException();
            c.e(parcel3, b());
        }
        return obj2;
    }
}
