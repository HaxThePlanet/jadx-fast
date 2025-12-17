package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes2.dex */
public class AssetPackExtractionService extends Service {

    com.google.android.play.core.assetpacks.x a;
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.a;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        u1.a(getApplicationContext()).a(this);
    }
}
