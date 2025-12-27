package c.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

/* compiled from: ICustomTabsService.java */
/* loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements b {
        public static b j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (localInterface != null) {
                z = localInterface instanceof b;
                if (localInterface instanceof b) {
                    return localInterface;
                }
            }
            return new b.a.a(iBinder);
        }
    }
    boolean E(a aVar, Uri uri, Bundle bundle, List<Bundle> list);

    boolean i1(a aVar);

    boolean y0(long j);
}
