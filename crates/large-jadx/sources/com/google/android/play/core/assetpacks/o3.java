package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.c;

/* loaded from: classes2.dex */
public final class o3 implements c {

    public final com.google.android.play.core.assetpacks.f0 a;
    public o3(com.google.android.play.core.assetpacks.f0 f0) {
        super();
        this.a = f0;
    }

    @Override // com.google.android.play.core.tasks.c
    public final void onSuccess(Object object) {
        this.a.c((List)object);
    }
}
