package d.c.b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import c.a.a.b;
import c.a.a.b.a;

/* compiled from: CustomTabsServiceConnection.java */
/* loaded from: classes.dex */
public abstract class d implements ServiceConnection {

    class a extends b {
        a(b bVar, ComponentName componentName) {
            super(bVar, componentName);
        }
    }
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a(componentName, new d.a(this, b.a.j(iBinder), componentName));
    }

    public abstract void a(ComponentName componentName, b bVar);
}
