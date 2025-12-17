package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import f.c.a.d.b.g.b;
import f.c.a.d.b.g.c;

/* loaded from: classes2.dex */
public abstract class v0 extends b implements com.google.android.gms.common.internal.l {
    public v0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // f.c.a.d.b.g.b
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        Object strongBinder;
        android.os.Parcelable.Creator cREATOR;
        int obj3;
        android.os.Parcelable obj4;
        final int obj6 = 1;
        if (i != obj6) {
            if (i != 2) {
                if (i != 3) {
                    return 0;
                }
                s1(parcel2.readInt(), parcel2.readStrongBinder(), (l1)c.c(parcel2, l1.CREATOR));
            } else {
                g(parcel2.readInt(), (Bundle)c.c(parcel2, Bundle.CREATOR));
            }
        } else {
            L0(parcel2.readInt(), parcel2.readStrongBinder(), (Bundle)c.c(parcel2, Bundle.CREATOR));
        }
        parcel3.writeNoException();
        return obj6;
    }
}
