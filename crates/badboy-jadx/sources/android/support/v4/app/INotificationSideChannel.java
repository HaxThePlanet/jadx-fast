package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface INotificationSideChannel extends IInterface {

    public static final String DESCRIPTOR;

    public static class Default implements android.support.v4.app.INotificationSideChannel {
        @Override // android.support.v4.app.INotificationSideChannel
        public IBinder asBinder() {
            return null;
        }

        public void cancel(String packageName, int id, String tag) throws RemoteException {
        }

        public void cancelAll(String packageName) throws RemoteException {
        }

        public void notify(String packageName, int id, String tag, Notification notification) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements android.support.v4.app.INotificationSideChannel {

        static final int TRANSACTION_cancel = 2;
        static final int TRANSACTION_cancelAll = 3;
        static final int TRANSACTION_notify = 1;
        public Stub() {
            super();
            attachInterface(this, INotificationSideChannel.Stub.DESCRIPTOR);
        }

        public static android.support.v4.app.INotificationSideChannel asInterface(IBinder obj) {
            boolean z;
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(INotificationSideChannel.Stub.DESCRIPTOR);
            if (localInterface != null && localInterface instanceof INotificationSideChannel) {
                if (localInterface instanceof INotificationSideChannel) {
                    return (INotificationSideChannel)localInterface;
                }
            }
            INotificationSideChannel.Stub.Proxy proxy = new INotificationSideChannel.Stub.Proxy(obj);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i;
            String string;
            int int;
            String string2;
            Object obj;
            final String dESCRIPTOR = INotificationSideChannel.Stub.DESCRIPTOR;
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
            switch (code) {
                case 1:
                    notify(data.readString(), data.readInt(), data.readString(), (Notification)INotificationSideChannel._Parcel.access$000(data, Notification.CREATOR));
                    break;
                case 2:
                    cancel(data.readString(), data.readInt(), data.readString());
                    break;
                case 3:
                    cancelAll(data.readString());
                    break;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
            return i2;
        }
    }

    public static class _Parcel {
        static Object access$000(Parcel x0, Parcelable.Creator x1) {
            return INotificationSideChannel._Parcel.readTypedObject(x0, x1);
        }

        static void access$100(Parcel x0, Parcelable x1, int x2) {
            INotificationSideChannel._Parcel.writeTypedObject(x0, x1, x2);
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
        INotificationSideChannel.DESCRIPTOR = "android$support$v4$app$INotificationSideChannel".replace('$', '.');
    }

    public abstract void cancel(String string, int i2, String string3) throws RemoteException;

    public abstract void cancelAll(String string) throws RemoteException;

    public abstract void notify(String string, int i2, String string3, Notification notification4) throws RemoteException;
}
