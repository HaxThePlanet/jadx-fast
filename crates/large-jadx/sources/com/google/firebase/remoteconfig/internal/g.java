package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.common.util.d;

/* loaded from: classes2.dex */
public final class g implements Runnable {

    public final d a;
    public final String b;
    public final com.google.firebase.remoteconfig.internal.ConfigContainer c;
    public g(d d, String string2, com.google.firebase.remoteconfig.internal.ConfigContainer configContainer3) {
        super();
        this.a = d;
        this.b = string2;
        this.c = configContainer3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ConfigGetParameterHandler.a(this.a, this.b, this.c);
    }
}
