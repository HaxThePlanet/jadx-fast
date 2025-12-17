package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AppForeground;
import com.google.firebase.inappmessaging.model.RateLimit;
import com.google.firebase.inappmessaging.model.RateLimit.Builder;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
@Module
public class RateLimitModule {

    private static final String APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY = "APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY";
    @Provides
    @AppForeground
    public RateLimit providesAppForegroundRateLimit() {
        int i = 1;
        return RateLimit.builder().setLimit(i).setLimiterKey("APP_FOREGROUND_ONE_PER_DAY_LIMITER_KEY").setTimeToLiveMillis(TimeUnit.DAYS.toMillis(i)).build();
    }
}
