package com.google.firebase.inappmessaging.internal;

import i.b.l0.n;

/* loaded from: classes2.dex */
public final class b2 implements n {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public b2(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient) {
        super();
        this.a = rateLimiterClient;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.j((RateLimitProto.RateLimit)object);
    }
}
