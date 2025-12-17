package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class v0 implements r1<com.google.android.play.core.assetpacks.x> {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.assetpacks.f0> b;
    private final r1<com.google.android.play.core.assetpacks.q3> c;
    private final r1<com.google.android.play.core.assetpacks.e1> d;
    public v0(r1<Context> r1, r1<com.google.android.play.core.assetpacks.f0> r12, r1<com.google.android.play.core.assetpacks.q3> r13, r1<com.google.android.play.core.assetpacks.e1> r14) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        x xVar = new x((z3)this.a.a(), (f0)this.b.zza(), (q3)this.c.zza(), (e1)this.d.zza());
        return xVar;
    }
}
