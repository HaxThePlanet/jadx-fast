package f.c.a.d.b.i;

import android.os.IBinder;

/* compiled from: com.android.billingclient:billing@@4.0.0 */
/* loaded from: classes2.dex */
public abstract class c extends f implements d {
    public static d j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
        if (localInterface instanceof d) {
            return localInterface;
        }
        return new b(iBinder);
    }
}
