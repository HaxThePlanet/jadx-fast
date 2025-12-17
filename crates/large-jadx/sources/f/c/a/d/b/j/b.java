package f.c.a.d.b.j;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public class b extends Binder implements IInterface {
    protected b(String string) {
        super();
        attachInterface(this, string);
    }

    @Override // android.os.Binder
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        throw 0;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
        boolean onTransact;
        if (i > 16777215) {
            onTransact = super.onTransact(i, parcel2, parcel3, i4);
        } else {
            parcel2.enforceInterface(getInterfaceDescriptor());
            onTransact = 0;
        }
        if (onTransact) {
            return 1;
        }
        return j(i, parcel2, parcel3, i4);
    }
}
