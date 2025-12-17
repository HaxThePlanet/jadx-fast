package f.c.a.c.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import f.c.a.a.b;

/* loaded from: classes2.dex */
public interface a extends IInterface {

    public static abstract class a extends b implements f.c.a.c.a.a {
        public static f.c.a.c.a.a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (localInterface instanceof a) {
                return (a)localInterface;
            }
            a.a.a aVar = new a.a.a(iBinder);
            return aVar;
        }
    }
    @Override // android.os.IInterface
    public abstract Bundle j0(Bundle bundle);
}
