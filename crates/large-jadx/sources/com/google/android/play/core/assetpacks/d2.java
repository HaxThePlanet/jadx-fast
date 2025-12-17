package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class d2 implements r1<com.google.android.play.core.assetpacks.c2> {

    private final r1<com.google.android.play.core.assetpacks.z1> a;
    private final r1<com.google.android.play.core.assetpacks.f0> b;
    private final r1<com.google.android.play.core.assetpacks.p0> c;
    private final r1<c> d;
    public d2(r1<com.google.android.play.core.assetpacks.z1> r1, r1<com.google.android.play.core.assetpacks.f0> r12, r1<com.google.android.play.core.assetpacks.p0> r13, r1<c> r14) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        c2 c2Var = new c2((z1)this.a.zza(), (f0)this.b.zza(), (p0)this.c.zza(), (c)this.d.zza());
        return c2Var;
    }
}
