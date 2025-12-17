package com.google.android.play.core.assetpacks;

import android.content.Intent;

/* loaded from: classes2.dex */
public final class g2 implements Runnable {

    public final com.google.android.play.core.assetpacks.h2 a;
    public final Intent b;
    public g2(com.google.android.play.core.assetpacks.h2 h2, Intent intent2) {
        super();
        this.a = h2;
        this.b = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i(this.b);
    }
}
