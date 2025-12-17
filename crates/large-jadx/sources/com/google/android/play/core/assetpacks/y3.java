package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.internal.p1;
import com.google.android.play.core.internal.q1;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class y3 implements r1<com.google.android.play.core.assetpacks.d4> {

    private final r1<Context> a;
    private final r1<com.google.android.play.core.assetpacks.t> b;
    private final r1<com.google.android.play.core.assetpacks.h2> c;
    public y3(r1<Context> r1, r1<com.google.android.play.core.assetpacks.t> r12, r1<com.google.android.play.core.assetpacks.h2> r13) {
        super();
        this.a = r1;
        this.b = r12;
        this.c = r13;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Object obj;
        if (u3.b((z3)this.a.a()) == null) {
            obj = p1.a(this.b).zza();
        } else {
            obj = p1.a(this.c).zza();
        }
        q1.a(obj);
        return obj;
    }
}
