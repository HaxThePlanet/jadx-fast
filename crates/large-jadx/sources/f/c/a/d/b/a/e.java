package f.c.a.d.b.a;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class e extends b implements d {
    public static d j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (localInterface instanceof d) {
            return localInterface;
        }
        return new f(iBinder);
    }
}
