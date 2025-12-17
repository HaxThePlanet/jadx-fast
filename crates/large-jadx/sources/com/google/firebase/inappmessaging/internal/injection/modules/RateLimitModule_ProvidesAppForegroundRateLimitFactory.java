package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.internal.Factory;
import com.google.firebase.inappmessaging.dagger.internal.Preconditions;
import com.google.firebase.inappmessaging.model.RateLimit;

/* loaded from: classes2.dex */
public final class RateLimitModule_ProvidesAppForegroundRateLimitFactory implements Factory<RateLimit> {

    private final com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule module;
    public RateLimitModule_ProvidesAppForegroundRateLimitFactory(com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule rateLimitModule) {
        super();
        this.module = rateLimitModule;
    }

    public static com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule_ProvidesAppForegroundRateLimitFactory create(com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule rateLimitModule) {
        RateLimitModule_ProvidesAppForegroundRateLimitFactory rateLimitModule_ProvidesAppForegroundRateLimitFactory = new RateLimitModule_ProvidesAppForegroundRateLimitFactory(rateLimitModule);
        return rateLimitModule_ProvidesAppForegroundRateLimitFactory;
    }

    public static RateLimit providesAppForegroundRateLimit(com.google.firebase.inappmessaging.internal.injection.modules.RateLimitModule rateLimitModule) {
        return (RateLimit)Preconditions.checkNotNull(rateLimitModule.providesAppForegroundRateLimit(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public RateLimit get() {
        return RateLimitModule_ProvidesAppForegroundRateLimitFactory.providesAppForegroundRateLimit(this.module);
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
