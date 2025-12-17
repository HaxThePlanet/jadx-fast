package com.google.android.play.core.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class b1 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.c1 {
    public b1() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    @Override // com.google.android.play.core.internal.z1
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        int obj1;
        Object obj2;
        android.os.Parcelable.Creator obj3;
        switch (i) {
            case 2:
                l1(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 3:
                J0(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 4:
                g(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 5:
                K1(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 6:
                d1((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 7:
                u(parcel2.createTypedArrayList(Bundle.CREATOR));
                break;
            case 8:
                Q((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 9:
                h((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 10:
                K0((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 11:
                w1((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 12:
                c((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 13:
                i0((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            default:
                return 0;
        }
        return 1;
    }
}
