package d.c.b;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import c.a.a.a;
import c.a.a.b;
import java.util.List;

/* compiled from: CustomTabsSession.java */
/* loaded from: classes.dex */
public final class e {

    private final b a;
    private final a b;
    private final ComponentName c;
    e(b bVar, a aVar, ComponentName componentName) {
        super();
        this.a = bVar;
        this.b = aVar;
        this.c = componentName;
    }

    IBinder a() {
        return this.b.asBinder();
    }

    ComponentName b() {
        return this.c;
    }

    public boolean c(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
        } catch (android.os.RemoteException unused) {
            uri = null;
            return uri;
        }
        return this.a.E(this.b, uri, bundle, list);
    }
}
