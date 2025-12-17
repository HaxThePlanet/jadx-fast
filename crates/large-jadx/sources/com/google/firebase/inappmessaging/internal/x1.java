package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.RateLimit;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class x1 implements n {

    public final com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit a;
    public final RateLimit b;
    public x1(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit, RateLimit rateLimit2) {
        super();
        this.a = rateLimit;
        this.b = rateLimit2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return RateLimiterClient.f(this.a, this.b, (RateLimitProto.Counter)object);
    }
}
