package f.c.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b;
    protected a(IBinder iBinder) {
        super();
        this.a = iBinder;
        this.b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.a;
    }

    @Override // android.os.IInterface
    protected final Parcel j() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    @Override // android.os.IInterface
    protected final Parcel m(Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        this.a.transact(1, parcel, obtain, 0);
        obtain.readException();
        parcel.recycle();
        return obtain;
    }
}
