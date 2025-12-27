package f.c.a.d.b.e;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public class b extends Binder implements IInterface {
    protected b(String str) {
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
        return p2(i, parcel, parcel2, i2);
    }

    @Override // android.os.Binder
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean p2(int i, Parcel parcel, Parcel parcel2, int i2) {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
