package c.a.b.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: IResultReceiver.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements a {
        public a() {
            super();
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (localInterface != null) {
                z = localInterface instanceof a;
                if (localInterface instanceof a) {
                    return localInterface;
                }
            }
            return new a.a.a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws android.os.RemoteException {
            Bundle bundle = null;
            i2 = 1;
            final String str = "android.support.v4.os.IResultReceiver";
            if (i != i2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
            if (parcel.readInt() != 0) {
                Object fromParcel = Bundle.CREATOR.createFromParcel(parcel);
            } else {
                int i5 = 0;
            }
            l2(parcel.readInt(), bundle);
            return true;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }
    }
    void l2(int i, Bundle bundle);
}
