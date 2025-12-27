package f.c.a.d.b.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* loaded from: classes2.dex */
public class a extends Binder implements IInterface {
    protected a(String str) {
        super();
        attachInterface(this, str);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws android.os.RemoteException {
        boolean onTransact = false;
        if (i > 16777215) {
            onTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            int i3 = 0;
        }
        if (onTransact) {
            return true;
        }
        return j(i, parcel, parcel2, i2);
    }

    @Override // android.os.Binder
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean j(int i, Parcel parcel, Parcel parcel2, int i2) {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
