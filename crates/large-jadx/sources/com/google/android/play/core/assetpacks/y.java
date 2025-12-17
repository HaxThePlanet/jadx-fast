package com.google.android.play.core.assetpacks;

import f.c.a.f.a.c.d;

/* loaded from: classes2.dex */
public final class y implements Runnable {

    public final com.google.android.play.core.assetpacks.z a;
    public final com.google.android.play.core.assetpacks.AssetPackState b;
    public y(com.google.android.play.core.assetpacks.z z, com.google.android.play.core.assetpacks.AssetPackState assetPackState2) {
        super();
        this.a = z;
        this.b = assetPackState2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b);
    }
}
