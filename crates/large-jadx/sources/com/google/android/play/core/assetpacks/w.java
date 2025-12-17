package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class w implements Runnable {

    public final com.google.android.play.core.assetpacks.z a;
    public final Bundle b;
    public final com.google.android.play.core.assetpacks.AssetPackState c;
    public w(com.google.android.play.core.assetpacks.z z, Bundle bundle2, com.google.android.play.core.assetpacks.AssetPackState assetPackState3) {
        super();
        this.a = z;
        this.b = bundle2;
        this.c = assetPackState3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.i(this.b, this.c);
    }
}
