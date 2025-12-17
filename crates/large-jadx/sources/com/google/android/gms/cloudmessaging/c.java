package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;

/* loaded from: classes2.dex */
interface c extends IInterface {

    public static class a implements com.google.android.gms.cloudmessaging.c {

        private final IBinder a;
        a(IBinder iBinder) {
            super();
            this.a = iBinder;
        }

        @Override // com.google.android.gms.cloudmessaging.c
        public void L(Message message) {
            final Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
            int i = 1;
            obtain.writeInt(i);
            message.writeToParcel(obtain, 0);
            this.a.transact(i, obtain, 0, i);
            obtain.recycle();
        }

        @Override // com.google.android.gms.cloudmessaging.c
        public IBinder asBinder() {
            return this.a;
        }
    }
    @Override // android.os.IInterface
    public abstract void L(Message message);
}
