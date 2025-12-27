package f.c.a.d.b.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public class c extends Binder implements IInterface {
    protected c(String str) {
        super();
        attachInterface(this, str);
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws android.os.RemoteException {
        if (i > 16777215) {
            if (super.onTransact(i, parcel, parcel2, i2)) {
                return true;
            }
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
        }
        return j(i, parcel, parcel2, i2);
    }

    @Override // android.os.Binder
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean j(int i, Parcel parcel, Parcel parcel2, int i2) {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
