package com.google.android.play.core.assetpacks;

import android.content.Context;
import com.google.android.play.core.internal.q1;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class z3 implements r1<Context> {

    private final com.google.android.play.core.assetpacks.u3 a;
    public z3(com.google.android.play.core.assetpacks.u3 u3) {
        super();
        this.a = u3;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Context a() {
        Context context = this.a.a();
        q1.a(context);
        return context;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Context context = this.a.a();
        q1.a(context);
        return context;
    }
}
