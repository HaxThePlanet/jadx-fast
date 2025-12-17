package com.google.android.play.core.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class j2 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.k2 {
    public j2() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    @Override // com.google.android.play.core.internal.z1
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        java.util.ArrayList obj1;
        Object obj2;
        Object obj3;
        switch (i) {
            case 2:
                W1(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 3:
                g(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 4:
                d2(parcel2.readInt(), (Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 5:
                x(parcel2.createTypedArrayList(Bundle.CREATOR));
                break;
            case 6:
                obj1 = Bundle.CREATOR;
                o2((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 7:
                c((Bundle)a2.a(parcel2, Bundle.CREATOR));
                break;
            case 8:
                obj1 = Bundle.CREATOR;
                k1((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 9:
                return 0;
            case 10:
                obj1 = Bundle.CREATOR;
                y1((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 11:
                obj1 = Bundle.CREATOR;
                Q1((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 12:
                obj1 = Bundle.CREATOR;
                p((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 13:
                obj1 = Bundle.CREATOR;
                G0((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            case 14:
                obj1 = Bundle.CREATOR;
                k0((Bundle)a2.a(parcel2, obj1), (Bundle)a2.a(parcel2, obj1));
                break;
            default:
                h((Bundle)a2.a(parcel2, Bundle.CREATOR));
        }
        return 1;
    }
}
