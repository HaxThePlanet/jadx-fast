package android.support.v4.media.session;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface b extends IInterface {

    public static abstract class a extends Binder implements android.support.v4.media.session.b {
        public static android.support.v4.media.session.b j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (localInterface != null && localInterface instanceof b) {
                if (localInterface instanceof b) {
                    return (b)localInterface;
                }
            }
            b.a.a aVar = new b.a.a(iBinder);
            return aVar;
        }

        public static android.support.v4.media.session.b m() {
            return b.a.a.b;
        }
    }
    @Override // android.os.IInterface
    public abstract void s(android.support.v4.media.session.a a);
}
