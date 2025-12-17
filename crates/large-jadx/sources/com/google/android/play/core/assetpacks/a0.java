package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.r1;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class a0 implements r1<com.google.android.play.core.assetpacks.z> {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.assetpacks.z1> b;
    private final r1<com.google.android.play.core.assetpacks.h1> c;
    private final r1<com.google.android.play.core.assetpacks.d4> d;
    private final r1<com.google.android.play.core.assetpacks.k1> e;
    private final r1<com.google.android.play.core.assetpacks.s0> f;
    private final r1<Executor> g;
    private final r1<Executor> h;
    private final r1<com.google.android.play.core.assetpacks.u2> i;
    public a0(r1<Context> r1, r1<com.google.android.play.core.assetpacks.z1> r12, r1<com.google.android.play.core.assetpacks.h1> r13, r1<com.google.android.play.core.assetpacks.d4> r14, r1<com.google.android.play.core.assetpacks.k1> r15, r1<com.google.android.play.core.assetpacks.s0> r16, r1<Executor> r17, r1<Executor> r18, r1<com.google.android.play.core.assetpacks.u2> r19) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
        this.e = r15;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        super((z3)this.a.a(), (z1)this.b.zza(), (h1)this.c.zza(), p1.a(this.d), (k1)this.e.zza(), (s0)this.f.zza(), p1.a(this.g), p1.a(this.h), (u2)this.i.zza());
        return zVar2;
    }
}
