package f.c.a.d.b.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes2.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b;
    protected a(IBinder iBinder, String string2) {
        super();
        this.a = iBinder;
        this.b = string2;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // android.os.IInterface
    protected final Parcel j(int i, Parcel parcel2) {
        final Parcel obtain = Parcel.obtain();
        this.a.transact(i, parcel2, obtain, 0);
        obtain.readException();
        parcel2.recycle();
        return obtain;
    }

    @Override // android.os.IInterface
    protected final void m(int i, Parcel parcel2) {
        final Parcel obj4 = Parcel.obtain();
        this.a.transact(1, parcel2, obj4, 0);
        obj4.readException();
        parcel2.recycle();
        obj4.recycle();
    }

    @Override // android.os.IInterface
    protected final Parcel n() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }
}
