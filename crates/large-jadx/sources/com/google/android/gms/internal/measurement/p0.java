package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public class p0 extends Binder implements IInterface {
    protected p0(String string) {
        super();
        attachInterface(this, string);
    }

    @Override // android.os.Binder
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        throw 0;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
        String interfaceDescriptor;
        if (i > 16777215) {
            if (super.onTransact(i, parcel2, parcel3, i4)) {
                return 1;
            }
        } else {
            parcel2.enforceInterface(getInterfaceDescriptor());
        }
        return j(i, parcel2, parcel3, i4);
    }
}
