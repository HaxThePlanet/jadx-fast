package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class y implements r1<com.google.android.play.core.splitinstall.x> {

    private final r1<Context> a;
    public y(r1<Context> r1) {
        super();
        this.a = r1;
    }

    @Override // com.google.android.play.core.internal.r1
    public final Object zza() {
        Context context = (l)this.a.a();
        x xVar = new x(context, context.getPackageName());
        return xVar;
    }
}
