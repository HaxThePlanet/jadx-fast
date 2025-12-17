package com.google.firebase.auth.api.fallback.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.m.a;

/* loaded from: classes2.dex */
public class FirebaseAuthFallbackService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        synchronized (this) {
            try {
                zza obj2 = new zza(this, this);
                return obj2.asBinder();
                return null;
                throw intent;
            }
        }
    }
}
