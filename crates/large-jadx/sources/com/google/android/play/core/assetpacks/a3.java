package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class a3 implements r1<com.google.android.play.core.assetpacks.z2> {

    private final r1<com.google.android.play.core.assetpacks.f0> a;
    private final r1<com.google.android.play.core.assetpacks.d4> b;
    public a3(r1<com.google.android.play.core.assetpacks.f0> r1, r1<com.google.android.play.core.assetpacks.d4> r12) {
        super();
        this.a = r1;
        this.b = r12;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        z2 z2Var = new z2((f0)this.a.zza(), p1.a(this.b));
        return z2Var;
    }
}
