package f.c.a.d.b.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes2.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b;
    protected final Parcel j(int i, Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } catch (Throwable th) {
        }
        parcel.recycle();
        return obtain;
    }

    protected final void m(int i, Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            i.recycle();
            throw th;
        }
        parcel.recycle();
        obtain.recycle();
    }

    protected final Parcel n() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    protected a(IBinder iBinder, String str) {
        super();
        this.a = iBinder;
        this.b = str;
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
