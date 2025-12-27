package f.c.a.d.b.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
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

    protected final void n(int i, Parcel parcel) {
        try {
            final int i3 = 1;
            this.a.transact(i3, parcel, null, i3);
        } finally {
            parcel.recycle();
            throw i;
        }
        parcel.recycle();
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
