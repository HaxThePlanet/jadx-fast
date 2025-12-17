package f.c.a.d.b.a;

import android.os.IBinder;

/* loaded from: classes2.dex */
public abstract class e extends f.c.a.d.b.a.b implements f.c.a.d.b.a.d {
    public static f.c.a.d.b.a.d j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        android.os.IInterface localInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (localInterface instanceof d) {
            return (d)localInterface;
        }
        f fVar = new f(iBinder);
        return fVar;
    }
}
