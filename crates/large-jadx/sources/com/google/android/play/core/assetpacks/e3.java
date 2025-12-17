package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class e3 implements r1<com.google.android.play.core.assetpacks.d3> {

    private final r1<com.google.android.play.core.assetpacks.f0> a;
    private final r1<com.google.android.play.core.assetpacks.d4> b;
    private final r1<com.google.android.play.core.assetpacks.z1> c;
    private final r1<Executor> d;
    private final r1<com.google.android.play.core.assetpacks.k1> e;
    public e3(r1<com.google.android.play.core.assetpacks.f0> r1, r1<com.google.android.play.core.assetpacks.d4> r12, r1<com.google.android.play.core.assetpacks.z1> r13, r1<Executor> r14, r1<com.google.android.play.core.assetpacks.k1> r15) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        super((f0)this.a.zza(), p1.a(this.b), (z1)this.c.zza(), p1.a(this.d), (k1)this.e.zza());
        return d3Var2;
    }
}
