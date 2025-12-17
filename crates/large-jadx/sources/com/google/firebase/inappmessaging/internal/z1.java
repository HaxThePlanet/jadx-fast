package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.RateLimit;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class z1 implements n {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public final RateLimit b;
    public z1(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient, RateLimit rateLimit2) {
        super();
        this.a = rateLimiterClient;
        this.b = rateLimit2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.n(this.b, (RateLimitProto.RateLimit)object);
    }
}
