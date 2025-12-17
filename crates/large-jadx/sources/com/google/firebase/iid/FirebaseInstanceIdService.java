package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes2.dex */
@Deprecated
public class FirebaseInstanceIdService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Deprecated
    public void onTokenRefresh() {
    }
}
