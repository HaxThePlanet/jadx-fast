package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class v2 implements r1<com.google.android.play.core.assetpacks.u2> {

    private final r1<com.google.android.play.core.assetpacks.f0> a;
    private final r1<com.google.android.play.core.assetpacks.w2> b;
    private final r1<c> c;
    public v2(r1<com.google.android.play.core.assetpacks.f0> r1, r1<com.google.android.play.core.assetpacks.w2> r12, r1<c> r13) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        u2 u2Var = new u2((f0)this.a.zza(), (w2)this.b.zza(), (c)this.c.zza());
        return u2Var;
    }
}
