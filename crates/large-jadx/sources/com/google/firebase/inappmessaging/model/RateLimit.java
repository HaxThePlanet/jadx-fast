package com.google.firebase.inappmessaging.model;

/* loaded from: classes2.dex */
public abstract class RateLimit {

    public static abstract class Builder {
        public abstract com.google.firebase.inappmessaging.model.RateLimit build();

        public abstract com.google.firebase.inappmessaging.model.RateLimit.Builder setLimit(long l);

        public abstract com.google.firebase.inappmessaging.model.RateLimit.Builder setLimiterKey(String string);

        public abstract com.google.firebase.inappmessaging.model.RateLimit.Builder setTimeToLiveMillis(long l);
    }
    public static com.google.firebase.inappmessaging.model.RateLimit.Builder builder() {
        AutoValue_RateLimit.Builder builder = new AutoValue_RateLimit.Builder();
        return builder;
    }

    public abstract long limit();

    public abstract String limiterKey();

    public abstract long timeToLiveMillis();
}
