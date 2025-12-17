package com.google.android.play.core.assetpacks;

import android.app.Notification;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class e1 implements ServiceConnection {

    private final h a;
    private final List<n2> b;
    private final Context c;
    private com.google.android.play.core.assetpacks.ExtractionForegroundService v;
    private Notification w;
    e1(Context context) {
        super();
        h hVar = new h("ExtractionForegroundServiceConnection");
        this.a = hVar;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.c = context;
    }

    private final void d() {
        int i;
        Object hVar;
        Object bundle2;
        Object[] bundle;
        List list = this.b;
        ArrayList arrayList = new ArrayList(this.b);
        this.b.clear();
        i = i2;
        synchronized (list) {
            list = this.b;
            arrayList = new ArrayList(this.b);
            this.b.clear();
            i = i2;
        }
        while (i < arrayList.size()) {
            bundle2 = new Bundle();
            bundle = new Bundle();
            (n2)arrayList.get(i).p(bundle2, bundle);
            i++;
            this.a.b("Could not resolve Play Store service state update callback.", new Object[obj2]);
        }
    }

    @Override // android.content.ServiceConnection
    final void a(Notification notification) {
        this.w = notification;
    }

    @Override // android.content.ServiceConnection
    final void b() {
        this.a.a("Stopping foreground installation service.", new Object[0]);
        this.c.unbindService(this);
        com.google.android.play.core.assetpacks.ExtractionForegroundService service = this.v;
        if (service != null) {
            service.a();
        }
        d();
    }

    @Override // android.content.ServiceConnection
    final void c(n2 n2) {
        final List list = this.b;
        this.b.add(n2);
        return;
        synchronized (list) {
            list = this.b;
            this.b.add(n2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        this.a.a("Starting foreground installation service.", new Object[0]);
        com.google.android.play.core.assetpacks.ExtractionForegroundService obj3 = iBinder2.a;
        this.v = obj3;
        obj3.startForeground(-1883842196, this.w);
        d();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
