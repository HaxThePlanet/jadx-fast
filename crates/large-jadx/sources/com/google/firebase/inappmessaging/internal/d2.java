package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.RateLimit;
import i.b.l0.o;

/* loaded from: classes2.dex */
public final class d2 implements o {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public final RateLimit b;
    public d2(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient, RateLimit rateLimit2) {
        super();
        this.a = rateLimiterClient;
        this.b = rateLimit2;
    }

    @Override // i.b.l0.o
    public final boolean test(Object object) {
        return this.a.e(this.b, (RateLimitProto.Counter)object);
    }
}
