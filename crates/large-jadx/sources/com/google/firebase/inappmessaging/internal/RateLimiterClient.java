package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.protobuf.z.a;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.l;
import i.b.r;

/* loaded from: classes2.dex */
public class RateLimiterClient {

    private static final com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit EMPTY_RATE_LIMITS;
    private l<com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit> cachedRateLimts;
    private final Clock clock;
    private final com.google.firebase.inappmessaging.internal.ProtoStorageClient storageClient;
    static {
        RateLimiterClient.EMPTY_RATE_LIMITS = RateLimitProto.RateLimit.getDefaultInstance();
    }

    RateLimiterClient(com.google.firebase.inappmessaging.internal.ProtoStorageClient protoStorageClient, Clock clock2) {
        super();
        this.cachedRateLimts = l.i();
        this.storageClient = protoStorageClient;
        this.clock = clock2;
    }

    public static void a(com.google.firebase.inappmessaging.internal.RateLimiterClient rateLimiterClient, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        rateLimiterClient.initInMemCache(rateLimit2);
    }

    private void b(Throwable throwable) {
        clearInMemCache();
    }

    private void clearInMemCache() {
        this.cachedRateLimts = l.i();
    }

    private boolean d(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2) {
        return obj1 ^= 1;
    }

    static com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit f(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit, RateLimit rateLimit2, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter3) {
        return (RateLimitProto.RateLimit)RateLimitProto.RateLimit.newBuilder(rateLimit).putLimits(rateLimit2.limiterKey(), RateLimiterClient.increment(counter3)).build();
    }

    private void g(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
        initInMemCache(rateLimit);
    }

    private l<com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit> getRateLimits() {
        c2 c2Var = new c2(this);
        a2 a2Var = new a2(this);
        return this.cachedRateLimts.z(this.storageClient.read(RateLimitProto.RateLimit.parser()).h(c2Var)).g(a2Var);
    }

    private f i(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
        y1 y1Var = new y1(this, rateLimit);
        return this.storageClient.write(rateLimit).j(y1Var);
    }

    private static com.google.firebase.inappmessaging.internal.RateLimitProto.Counter increment(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter) {
        return (RateLimitProto.Counter)RateLimitProto.Counter.newBuilder(counter).clearValue().setValue(value += i2).build();
    }

    private void initInMemCache(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
        this.cachedRateLimts = l.p(rateLimit);
    }

    private boolean isLimitExpired(com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter, RateLimit rateLimit2) {
        int obj5;
        obj5 = Long.compare(i, obj5) > 0 ? 1 : 0;
        return obj5;
    }

    private f k(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        d2 d2Var = new d2(this, rateLimit);
        x1 x1Var = new x1(rateLimit2, rateLimit);
        b2 obj4 = new b2(this);
        return r.just(rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter())).filter(d2Var).switchIfEmpty(r.just(newCounter())).map(x1Var).flatMapCompletable(obj4);
    }

    private com.google.firebase.inappmessaging.internal.RateLimitProto.Counter m(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        return rateLimit2.getLimitsOrDefault(rateLimit.limiterKey(), newCounter());
    }

    private com.google.firebase.inappmessaging.internal.RateLimitProto.Counter newCounter() {
        return (RateLimitProto.Counter)RateLimitProto.Counter.newBuilder().setValue(0).setStartTimeEpoch(this.clock.now()).build();
    }

    private boolean o(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2) {
        long limitExpired;
        int obj3;
        if (!isLimitExpired(counter2, rateLimit)) {
            if (Long.compare(limitExpired, obj3) < 0) {
                obj3 = 1;
            } else {
                obj3 = 0;
            }
        } else {
        }
        return obj3;
    }

    public void c(Throwable throwable) {
        b(throwable);
    }

    public boolean e(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2) {
        return d(rateLimit, counter2);
    }

    public void h(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
        g(rateLimit);
    }

    public b increment(RateLimit rateLimit) {
        v1 v1Var = new v1(this, rateLimit);
        return getRateLimits().f(RateLimiterClient.EMPTY_RATE_LIMITS).l(v1Var);
    }

    public a0<Boolean> isRateLimited(RateLimit rateLimit) {
        z1 z1Var = new z1(this, rateLimit);
        w1 w1Var = new w1(this, rateLimit);
        return getRateLimits().z(l.p(RateLimitProto.RateLimit.getDefaultInstance())).q(z1Var).j(w1Var).o();
    }

    public f j(com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit) {
        return i(rateLimit);
    }

    public f l(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        return k(rateLimit, rateLimit2);
    }

    public com.google.firebase.inappmessaging.internal.RateLimitProto.Counter n(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.RateLimit rateLimitProto$RateLimit2) {
        return m(rateLimit, rateLimit2);
    }

    public boolean p(RateLimit rateLimit, com.google.firebase.inappmessaging.internal.RateLimitProto.Counter rateLimitProto$Counter2) {
        return o(rateLimit, counter2);
    }
}
