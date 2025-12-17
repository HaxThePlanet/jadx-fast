package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class c2 implements f {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public c2(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient) {
        super();
        this.a = rateLimiterClient;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        RateLimiterClient.a(this.a, (RateLimitProto.RateLimit)object);
    }
}
