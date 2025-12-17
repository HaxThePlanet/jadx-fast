package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public abstract class l2 extends com.google.android.play.core.internal.z1 implements com.google.android.play.core.internal.m2 {
    public l2() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService");
    }

    @Override // com.google.android.play.core.internal.z1
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        android.os.Parcelable obj2;
        IBinder obj3;
        android.os.IInterface obj4;
        android.os.IInterface obj5;
        obj5 = 0;
        final String str = "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback";
        if (i != 2) {
            if (i != 3) {
                return 0;
            }
            obj3 = parcel2.readStrongBinder();
            if (obj3 == null) {
            } else {
                obj4 = obj3.queryLocalInterface(str);
                if (obj4 instanceof n2) {
                    obj5 = obj4;
                } else {
                    obj5 = new n2(obj3);
                }
            }
            h1((Bundle)a2.a(parcel2, Bundle.CREATOR), obj5);
        } else {
            obj3 = parcel2.readStrongBinder();
            if (obj3 == null) {
            } else {
                obj4 = obj3.queryLocalInterface(str);
                if (obj4 instanceof n2) {
                    obj5 = obj4;
                } else {
                    obj5 = new n2(obj3);
                }
            }
            u1((Bundle)a2.a(parcel2, Bundle.CREATOR), obj5);
        }
        return 1;
    }
}
