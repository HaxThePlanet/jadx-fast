package com.google.firebase.inappmessaging.internal;

import i.b.l0.a;

/* loaded from: classes2.dex */
public final class y1 implements a {

    public final com.google.firebase.inappmessaging.internal.RateLimiterClient a;
    public final com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit b;
    public y1(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        super();
        this.a = rateLimiterClient;
        this.b = rateLimit2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.h(this.b);
    }
}
