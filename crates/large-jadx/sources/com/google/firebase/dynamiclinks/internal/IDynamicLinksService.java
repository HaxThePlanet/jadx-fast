package com.google.firebase.dynamiclinks.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* loaded from: classes2.dex */
public interface IDynamicLinksService extends IInterface {

    public static abstract class Stub extends Binder implements com.google.firebase.dynamiclinks.internal.IDynamicLinksService {

        private static final String DESCRIPTOR = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
        static final int TRANSACTION_createShortDynamicLink = 2;
        static final int TRANSACTION_getDynamicLink = 1;
        public Stub() {
            super();
            attachInterface(this, "com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
        }

        public static com.google.firebase.dynamiclinks.internal.IDynamicLinksService asInterface(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
            if (localInterface != null && localInterface instanceof IDynamicLinksService != null) {
                if (localInterface instanceof IDynamicLinksService != null) {
                    return (IDynamicLinksService)localInterface;
                }
            }
            IDynamicLinksService.Stub.Proxy proxy = new IDynamicLinksService.Stub.Proxy(iBinder);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int obj5;
            int obj7;
            final int i2 = 1;
            final String str = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
            if (i != i2 && i != 2 && i != 1598968902) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel2, parcel3, i4);
                    }
                    parcel3.writeString(str);
                    return i2;
                }
                parcel2.enforceInterface(str);
                if (parcel2.readInt() != 0) {
                    obj5 = Bundle.CREATOR.createFromParcel(parcel2);
                } else {
                    obj5 = 0;
                }
                createShortDynamicLink(IDynamicLinksCallbacks.Stub.asInterface(parcel2.readStrongBinder()), obj5);
                parcel3.writeNoException();
                return i2;
            }
            parcel2.enforceInterface(str);
            getDynamicLink(IDynamicLinksCallbacks.Stub.asInterface(parcel2.readStrongBinder()), parcel2.readString());
            parcel3.writeNoException();
            return i2;
        }
    }
    @Override // android.os.IInterface
    public abstract void createShortDynamicLink(com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks iDynamicLinksCallbacks, Bundle bundle2);

    @Override // android.os.IInterface
    public abstract void getDynamicLink(com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks iDynamicLinksCallbacks, String string2);
}
