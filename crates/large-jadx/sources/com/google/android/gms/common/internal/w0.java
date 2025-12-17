package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
final class w0 implements com.google.android.gms.common.internal.m {

    private final IBinder a;
    w0(IBinder iBinder) {
        super();
        this.a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.m
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.m
    public final void getService(com.google.android.gms.common.internal.l l, com.google.android.gms.common.internal.g g2) {
        String str;
        IBinder obj4;
        final Parcel obtain = Parcel.obtain();
        final Parcel obtain2 = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
        if (l != null) {
            obj4 = l.asBinder();
        } else {
            obj4 = 0;
        }
        obtain.writeStrongBinder(obj4);
        obj4 = 0;
        if (g2 != null) {
            obtain.writeInt(1);
            o1.a(g2, obtain, obj4);
        } else {
            obtain.writeInt(obj4);
        }
        this.a.transact(46, obtain, obtain2, obj4);
        obtain2.readException();
        obtain2.recycle();
        obtain.recycle();
    }
}
