package com.google.firebase.dynamiclinks.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public interface IDynamicLinksCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks {

        private static final String DESCRIPTOR = "com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks";
        static final int TRANSACTION_onCreateShortDynamicLink = 2;
        static final int TRANSACTION_onGetDynamicLink = 1;
        public Stub() {
            super();
            attachInterface(this, "com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
        }

        public static com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks asInterface(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks");
            if (localInterface != null && localInterface instanceof IDynamicLinksCallbacks) {
                if (localInterface instanceof IDynamicLinksCallbacks) {
                    return (IDynamicLinksCallbacks)localInterface;
                }
            }
            IDynamicLinksCallbacks.Stub.Proxy proxy = new IDynamicLinksCallbacks.Stub.Proxy(iBinder);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
            int i2;
            Object obj5;
            Object obj6;
            int obj7;
            i2 = 0;
            final int i5 = 1;
            final String str = "com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks";
            if (i != i5 && i != 2 && i != 1598968902) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel2, parcel3, i4);
                    }
                    parcel3.writeString(str);
                    return i5;
                }
                parcel2.enforceInterface(str);
                if (parcel2.readInt() != 0) {
                    obj5 = Status.CREATOR.createFromParcel(parcel2);
                } else {
                    obj5 = i2;
                }
                if (parcel2.readInt() != 0) {
                    i2 = obj6;
                }
                onCreateShortDynamicLink(obj5, i2);
                return i5;
            }
            parcel2.enforceInterface(str);
            if (parcel2.readInt() != 0) {
                obj5 = Status.CREATOR.createFromParcel(parcel2);
            } else {
                obj5 = i2;
            }
            if (parcel2.readInt() != 0) {
                i2 = obj6;
            }
            onGetDynamicLink(obj5, i2);
            return i5;
        }
    }
    @Override // android.os.IInterface
    public abstract void onCreateShortDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl shortDynamicLinkImpl2);

    @Override // android.os.IInterface
    public abstract void onGetDynamicLink(Status status, com.google.firebase.dynamiclinks.internal.DynamicLinkData dynamicLinkData2);
}
