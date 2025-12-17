package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IResultReceiver2 extends IInterface {

    public static final String DESCRIPTOR;

    public static class Default implements android.support.v4.os.IResultReceiver2 {
        @Override // android.support.v4.os.IResultReceiver2
        public IBinder asBinder() {
            return null;
        }

        public void send(int resultCode, Bundle resultData) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements android.support.v4.os.IResultReceiver2 {

        static final int TRANSACTION_send = 1;
        public Stub() {
            super();
            attachInterface(this, IResultReceiver2.Stub.DESCRIPTOR);
        }

        public static android.support.v4.os.IResultReceiver2 asInterface(IBinder obj) {
            boolean z;
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(IResultReceiver2.Stub.DESCRIPTOR);
            if (localInterface != null && localInterface instanceof IResultReceiver2) {
                if (localInterface instanceof IResultReceiver2) {
                    return (IResultReceiver2)localInterface;
                }
            }
            IResultReceiver2.Stub.Proxy proxy = new IResultReceiver2.Stub.Proxy(obj);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i;
            final String dESCRIPTOR = IResultReceiver2.Stub.DESCRIPTOR;
            int i2 = 1;
            if (code >= i2 && code <= 16777215) {
                if (code <= 16777215) {
                    data.enforceInterface(dESCRIPTOR);
                }
            }
            if (code == 1598968902) {
                reply.writeString(dESCRIPTOR);
                return i2;
            }
            if (/* condition */) {
                send(data.readInt(), (Bundle)IResultReceiver2._Parcel.access$000(data, Bundle.CREATOR));
                return i2;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }

    public static class _Parcel {
        static Object access$000(Parcel x0, Parcelable.Creator x1) {
            return IResultReceiver2._Parcel.readTypedObject(x0, x1);
        }

        static void access$100(Parcel x0, Parcelable x1, int x2) {
            IResultReceiver2._Parcel.writeTypedObject(x0, x1, x2);
        }

        private static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> parcelable$Creator2) {
            if (parcel.readInt() != 0) {
                return creator2.createFromParcel(parcel);
            }
            return 0;
        }

        private static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t2, int parcelableFlags) {
            int i;
            if (t2 != 0) {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, parcelableFlags);
            } else {
                parcel.writeInt(0);
            }
        }
    }
    static {
        IResultReceiver2.DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace('$', '.');
    }

    public abstract void send(int i, Bundle bundle2) throws RemoteException;
}
