package f.c.a.d.b.i;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class c extends f.c.a.d.b.i.f implements f.c.a.d.b.i.d {
    public static f.c.a.d.b.i.d j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        if (localInterface instanceof d) {
            return (d)localInterface;
        }
        b bVar = new b(iBinder);
        return bVar;
    }
}
