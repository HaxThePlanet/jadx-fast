package com.google.android.play.core.assetpacks;

import com.google.android.play.core.common.c;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class t2 implements r1<com.google.android.play.core.assetpacks.s2> {

    private final r1<com.google.android.play.core.assetpacks.f0> a;
    private final r1<com.google.android.play.core.assetpacks.d4> b;
    private final r1<com.google.android.play.core.assetpacks.z1> c;
    private final r1<Executor> d;
    private final r1<com.google.android.play.core.assetpacks.k1> e;
    private final r1<c> f;
    private final r1<com.google.android.play.core.assetpacks.u2> g;
    public t2(r1<com.google.android.play.core.assetpacks.f0> r1, r1<com.google.android.play.core.assetpacks.d4> r12, r1<com.google.android.play.core.assetpacks.z1> r13, r1<Executor> r14, r1<com.google.android.play.core.assetpacks.k1> r15, r1<c> r16, r1<com.google.android.play.core.assetpacks.u2> r17) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        super((f0)this.a.zza(), p1.a(this.b), (z1)this.c.zza(), p1.a(this.d), (k1)this.e.zza(), (c)this.f.zza(), (u2)this.g.zza());
        return s2Var2;
    }
}
