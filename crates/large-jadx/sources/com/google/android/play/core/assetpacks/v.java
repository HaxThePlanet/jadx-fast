package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class v implements Runnable {

    public final com.google.android.play.core.assetpacks.z a;
    public final Bundle b;
    public v(com.google.android.play.core.assetpacks.z z, Bundle bundle2) {
        super();
        this.a = z;
        this.b = bundle2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b);
    }
}
