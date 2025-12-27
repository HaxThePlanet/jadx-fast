package f.c.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: BaseProxy.java */
/* loaded from: classes.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";
    protected final Parcel j() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    protected final Parcel m(Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(1, parcel, obtain, 0);
            obtain.readException();
        } catch (Throwable th) {
        }
        parcel.recycle();
        return obtain;
    }

    protected a(IBinder iBinder) {
        super();
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
