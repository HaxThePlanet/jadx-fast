package com.google.android.gms.internal.firebase-auth-api;

import android.os.Build.VERSION;
import java.security.KeyStore;

/* loaded from: classes2.dex */
public final class n5 {

    KeyStore a = null;
    public n5() {
        super();
        if (Build.VERSION.SDK_INT < 23) {
        } else {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            this.a = instance;
            instance.load(0);
        }
        IllegalStateException illegalStateException = new IllegalStateException("need Android Keystore on Android M or newer");
        throw illegalStateException;
    }
}
