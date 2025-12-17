package com.google.android.play.core.splitinstall;

import android.content.Context;
import com.google.android.play.core.internal.q1;
import com.google.android.play.core.internal.r1;

/* loaded from: classes2.dex */
public final class l implements r1<Context> {

    private final com.google.android.play.core.splitinstall.k a;
    public l(com.google.android.play.core.splitinstall.k k) {
        super();
        this.a = k;
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
