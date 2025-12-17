package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {

    public static final String DESCRIPTOR;

    public static class Default implements androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback {
        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public IBinder asBinder() {
            return null;
        }

        public void onIsPermissionRevocationEnabledForAppResult(boolean success, boolean isEnabled) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback {

        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;
        public Stub() {
            super();
            attachInterface(this, IUnusedAppRestrictionsBackportCallback.Stub.DESCRIPTOR);
        }

        public static androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback asInterface(IBinder obj) {
            boolean z;
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(IUnusedAppRestrictionsBackportCallback.Stub.DESCRIPTOR);
            if (localInterface != null && localInterface instanceof IUnusedAppRestrictionsBackportCallback != null) {
                if (localInterface instanceof IUnusedAppRestrictionsBackportCallback != null) {
                    return (IUnusedAppRestrictionsBackportCallback)localInterface;
                }
            }
            IUnusedAppRestrictionsBackportCallback.Stub.Proxy proxy = new IUnusedAppRestrictionsBackportCallback.Stub.Proxy(obj);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i3;
            int i;
            int i2;
            final String dESCRIPTOR = IUnusedAppRestrictionsBackportCallback.Stub.DESCRIPTOR;
            int i4 = 1;
            if (code >= i4 && code <= 16777215) {
                if (code <= 16777215) {
                    data.enforceInterface(dESCRIPTOR);
                }
            }
            if (code == 1598968902) {
                reply.writeString(dESCRIPTOR);
                return i4;
            }
            if (/* condition */) {
                i = data.readInt() != 0 ? i4 : i2;
                if (data.readInt() != 0) {
                    i2 = i4;
                }
                onIsPermissionRevocationEnabledForAppResult(i, i2);
                return i4;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
    static {
        IUnusedAppRestrictionsBackportCallback.DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');
    }

    public abstract void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException;
}
