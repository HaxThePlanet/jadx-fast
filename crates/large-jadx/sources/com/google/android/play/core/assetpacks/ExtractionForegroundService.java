package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes2.dex */
public class ExtractionForegroundService extends Service {

    private final IBinder a;
    public ExtractionForegroundService() {
        super();
        d1 d1Var = new d1(this);
        this.a = d1Var;
    }

    @Override // android.app.Service
    public final void a() {
        stopForeground(true);
        stopSelf();
        return;
        synchronized (this) {
            stopForeground(true);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.a;
    }
}
