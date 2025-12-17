package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class i2 implements f {

    public final com.google.firebase.inappmessaging.internal.AnalyticsEventsManager a;
    public i2(com.google.firebase.inappmessaging.internal.AnalyticsEventsManager analyticsEventsManager) {
        super();
        this.a = analyticsEventsManager;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        this.a.updateContextualTriggers((e)object);
    }
}
