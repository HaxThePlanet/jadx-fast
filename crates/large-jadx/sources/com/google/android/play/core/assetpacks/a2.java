package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class a2 implements r1<com.google.android.play.core.assetpacks.z1> {

    private final r1<com.google.android.play.core.assetpacks.f0> a;
    private final r1<com.google.android.play.core.assetpacks.d4> b;
    private final r1<com.google.android.play.core.assetpacks.k1> c;
    private final r1<Executor> d;
    public a2(r1<com.google.android.play.core.assetpacks.f0> r1, r1<com.google.android.play.core.assetpacks.d4> r12, r1<com.google.android.play.core.assetpacks.k1> r13, r1<Executor> r14) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        z1 z1Var = new z1((f0)this.a.zza(), p1.a(this.b), (k1)this.c.zza(), p1.a(this.d));
        return z1Var;
    }
}
