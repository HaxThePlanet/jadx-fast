package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.f;
import i.b.m;

/* loaded from: classes2.dex */
public final class y0 implements f {

    public final m a;
    public y0(m m) {
        super();
        this.a = m;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        InAppMessageStreamManager.P(this.a, exception);
    }
}
