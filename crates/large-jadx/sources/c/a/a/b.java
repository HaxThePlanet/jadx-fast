package c.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import java.util.List;

/* loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements c.a.a.b {
        public static c.a.a.b j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            if (localInterface != null && localInterface instanceof b) {
                if (localInterface instanceof b) {
                    return (b)localInterface;
                }
            }
            b.a.a aVar = new b.a.a(iBinder);
            return aVar;
        }
    }
    public abstract boolean E(c.a.a.a a, Uri uri2, Bundle bundle3, List<Bundle> list4);

    @Override // android.os.IInterface
    public abstract boolean i1(c.a.a.a a);

    @Override // android.os.IInterface
    public abstract boolean y0(long l);
}
