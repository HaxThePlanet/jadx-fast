package f.c.a.d.b.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-auth@@19.2.0 */
/* loaded from: classes2.dex */
public class a implements IInterface {

    private final IBinder a;
    private final String b;
    protected final Parcel j() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    protected final void m(int i, Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obj.recycle();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        }
        parcel.recycle();
        obtain.recycle();
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
