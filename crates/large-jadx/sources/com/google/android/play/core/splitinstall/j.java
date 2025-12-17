package com.google.android.play.core.splitinstall;

import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class j implements r1<com.google.android.play.core.splitinstall.i> {

    private final r1<com.google.android.play.core.splitinstall.x> a;
    private final r1<com.google.android.play.core.splitinstall.x0> b;
    private final r1<com.google.android.play.core.splitinstall.s0> c;
    private final r1<com.google.android.play.core.splitinstall.z> d;
    public j(r1<com.google.android.play.core.splitinstall.x> r1, r1<com.google.android.play.core.splitinstall.x0> r12, r1<com.google.android.play.core.splitinstall.s0> r13, r1<com.google.android.play.core.splitinstall.z> r14) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
        this.d = r14;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        i iVar = new i((x)this.a.zza(), (x0)this.b.zza(), (s0)this.c.zza(), (z)this.d.zza());
        return iVar;
    }
}
