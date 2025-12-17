package com.google.android.play.core.assetpacks;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class q1 implements com.google.android.play.core.assetpacks.y1 {

    public final com.google.android.play.core.assetpacks.z1 a;
    public final Bundle b;
    public q1(com.google.android.play.core.assetpacks.z1 z1, Bundle bundle2) {
        super();
        this.a = z1;
        this.b = bundle2;
    }

    @Override // com.google.android.play.core.assetpacks.y1
    public final Object zza() {
        return this.a.b(this.b);
    }
}
