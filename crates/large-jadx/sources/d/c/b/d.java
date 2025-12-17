package d.c.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.a.a.b;
import c.a.a.b.a;

/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {

    class a extends d.c.b.b {
        a(d.c.b.d d, b b2, ComponentName componentName3) {
            super(b2, componentName3);
        }
    }
    @Override // android.content.ServiceConnection
    public abstract void a(ComponentName componentName, d.c.b.b b2);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        d.a aVar = new d.a(this, b.a.j(iBinder2), componentName);
        a(componentName, aVar);
    }
}
