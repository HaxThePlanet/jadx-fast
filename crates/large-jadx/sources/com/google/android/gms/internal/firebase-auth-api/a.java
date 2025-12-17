package com.google.android.gms.internal.firebase-auth-api;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b;
    protected a(IBinder iBinder, String string2) {
        super();
        this.a = iBinder;
        this.b = string2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // android.os.IInterface
    protected final void j(int i, Parcel parcel2) {
        final Parcel obtain = Parcel.obtain();
        this.a.transact(i, parcel2, obtain, 0);
        obtain.readException();
        parcel2.recycle();
        obtain.recycle();
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

    @Override // android.os.IInterface
    protected final Parcel n() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }
}
