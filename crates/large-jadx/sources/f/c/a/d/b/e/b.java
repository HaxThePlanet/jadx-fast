package f.c.a.d.b.e;

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
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel2, Parcel parcel3, int i4) {
        String interfaceDescriptor;
        if (i > 16777215) {
            if (super.onTransact(i, parcel2, parcel3, i4)) {
                return 1;
            }
        } else {
            parcel2.enforceInterface(getInterfaceDescriptor());
        }
        return p2(i, parcel2, parcel3, i4);
    }

    @Override // android.os.Binder
    protected boolean p2(int i, Parcel parcel2, Parcel parcel3, int i4) {
        throw 0;
    }
}
