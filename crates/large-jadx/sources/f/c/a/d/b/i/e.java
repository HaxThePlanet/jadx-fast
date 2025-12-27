package f.c.a.d.b.i;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes2.dex */
public class e implements IInterface {

    private final IBinder a;
    private final String b = "com.android.vending.billing.IInAppBillingService";
    protected final Parcel j() {
        final Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.b);
        return obtain;
    }

    protected final Parcel m(int i, Parcel parcel) {
        final Parcel obtain = Parcel.obtain();
        try {
            this.a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } catch (Throwable th) {
        }
        parcel.recycle();
        return obtain;
    }

    protected e(IBinder iBinder, String str) {
        super();
        this.a = iBinder;
    }

    public final IBinder asBinder() {
        return this.a;
    }
}
