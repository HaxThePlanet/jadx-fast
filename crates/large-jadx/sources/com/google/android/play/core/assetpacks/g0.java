package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class g0 implements r1<com.google.android.play.core.assetpacks.f0> {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.assetpacks.w2> b;
    public g0(r1<Context> r1, r1<com.google.android.play.core.assetpacks.w2> r12) {
        super();
        this.a = r1;
        this.b = r12;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        f0 f0Var = new f0((z3)this.a.a(), (w2)this.b.zza());
        return f0Var;
    }
}
