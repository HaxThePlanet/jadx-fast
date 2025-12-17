package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface a extends IInterface {

    public static abstract class a extends Binder implements android.support.v4.app.a {
        public static android.support.v4.app.a j(IBinder iBinder) {
            boolean z;
            if (iBinder == null) {
                return null;
            }
            IInterface localInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (localInterface != null && localInterface instanceof a) {
                if (localInterface instanceof a) {
                    return (a)localInterface;
                }
            }
            a.a.a aVar = new a.a.a(iBinder);
            return aVar;
        }

        public static android.support.v4.app.a m() {
            return a.a.a.b;
        }
    }
    @Override // android.os.IInterface
    public abstract void a2(String string, int i2, String string3, Notification notification4);

    @Override // android.os.IInterface
    public abstract void c0(String string);

    @Override // android.os.IInterface
    public abstract void c1(String string, int i2, String string3);
}
