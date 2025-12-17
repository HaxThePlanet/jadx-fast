package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class a2 implements f {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public a2(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient) {
        super();
        this.a = rateLimiterClient;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        this.a.c((Throwable)object);
    }
}
