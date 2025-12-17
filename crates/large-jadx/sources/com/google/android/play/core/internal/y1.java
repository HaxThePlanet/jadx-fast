package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public class y1 implements IInterface {

    private final IBinder a;
    private final String b;
    protected y1(IBinder iBinder, String string2) {
        super();
        this.a = iBinder;
        this.b = string2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // android.os.IInterface
    protected final Parcel j() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    @Override // android.os.IInterface
    protected final void m(int i, Parcel parcel2) {
        try {
            this.a.transact(i, parcel2, 0, 1);
            parcel2.recycle();
            parcel2.recycle();
            throw i;
        }
    }
}
