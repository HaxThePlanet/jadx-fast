package f.c.a.c.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import f.c.a.a.b;

/* compiled from: IGetInstallReferrerService.java */
/* loaded from: classes2.dex */
public interface a extends IInterface {

    public static abstract class a extends b implements a {
        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (localInterface instanceof a) {
                return localInterface;
            }
            return new a.a.a(iBinder);
        }
    }
    Bundle j0(Bundle bundle);
}
