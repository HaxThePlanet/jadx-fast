package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class u implements r1<com.google.android.play.core.assetpacks.t> {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.assetpacks.k1> b;
    private final r1<com.google.android.play.core.assetpacks.u2> c;
    public u(r1<Context> r1, r1<com.google.android.play.core.assetpacks.k1> r12, r1<com.google.android.play.core.assetpacks.u2> r13) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        t tVar = new t((z3)this.a.a(), (k1)this.b.zza(), (u2)this.c.zza());
        return tVar;
    }
}
