package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes5.dex */
public interface IUnusedAppRestrictionsBackportService extends IInterface {

    public static final String DESCRIPTOR;

    public static class Default implements androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService {
        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public IBinder asBinder() {
            return null;
        }

        public void isPermissionRevocationEnabledForApp(androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback callback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService {

        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;
        public Stub() {
            super();
            attachInterface(this, IUnusedAppRestrictionsBackportService.Stub.DESCRIPTOR);
        }

        public static androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService asInterface(IBinder obj) {
            boolean z;
            if (obj == null) {
                return null;
            }
            IInterface localInterface = obj.queryLocalInterface(IUnusedAppRestrictionsBackportService.Stub.DESCRIPTOR);
            if (localInterface != null && localInterface instanceof IUnusedAppRestrictionsBackportService != null) {
                if (localInterface instanceof IUnusedAppRestrictionsBackportService != null) {
                    return (IUnusedAppRestrictionsBackportService)localInterface;
                }
            }
            IUnusedAppRestrictionsBackportService.Stub.Proxy proxy = new IUnusedAppRestrictionsBackportService.Stub.Proxy(obj);
            return proxy;
        }

        @Override // android.os.Binder
        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            int i;
            final String dESCRIPTOR = IUnusedAppRestrictionsBackportService.Stub.DESCRIPTOR;
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
                isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback.Stub.asInterface(data.readStrongBinder()));
                return i2;
            }
            return super.onTransact(code, data, reply, flags);
        }
    }
    static {
        IUnusedAppRestrictionsBackportService.DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');
    }

    public abstract void isPermissionRevocationEnabledForApp(androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException;
}
