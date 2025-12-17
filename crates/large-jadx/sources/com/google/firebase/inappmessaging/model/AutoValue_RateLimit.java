package com.google.firebase.inappmessaging.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_RateLimit extends com.google.firebase.inappmessaging.model.RateLimit {

    private final long limit;
    private final String limiterKey;
    private final long timeToLiveMillis;

    static final class Builder extends com.google.firebase.inappmessaging.model.RateLimit.Builder {

        private Long limit;
        private String limiterKey;
        private Long timeToLiveMillis;
        @Override // com.google.firebase.inappmessaging.model.RateLimit$Builder
        public com.google.firebase.inappmessaging.model.RateLimit build() {
            Object stringBuilder2;
            Object stringBuilder;
            Object timeToLiveMillis;
            String string;
            if (this.limiterKey == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" limiterKey");
                string = stringBuilder2.toString();
            }
            if (this.limit == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" limit");
                string = stringBuilder.toString();
            }
            if (this.timeToLiveMillis == null) {
                timeToLiveMillis = new StringBuilder();
                timeToLiveMillis.append(string);
                timeToLiveMillis.append(" timeToLiveMillis");
                string = timeToLiveMillis.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.limiterKey, this.limit.longValue(), obj5, this.timeToLiveMillis.longValue(), obj7, 0);
                return autoValue_RateLimit;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit$Builder
        public com.google.firebase.inappmessaging.model.RateLimit.Builder setLimit(long l) {
            this.limit = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit$Builder
        public com.google.firebase.inappmessaging.model.RateLimit.Builder setLimiterKey(String string) {
            Objects.requireNonNull(string, "Null limiterKey");
            this.limiterKey = string;
            return this;
        }

        @Override // com.google.firebase.inappmessaging.model.RateLimit$Builder
        public com.google.firebase.inappmessaging.model.RateLimit.Builder setTimeToLiveMillis(long l) {
            this.timeToLiveMillis = Long.valueOf(l);
            return this;
        }
    }
    private AutoValue_RateLimit(String string, long l2, long l3) {
        super();
        this.limiterKey = string;
        this.limit = l2;
        this.timeToLiveMillis = obj4;
    }

    AutoValue_RateLimit(String string, long l2, long l3, com.google.firebase.inappmessaging.model.AutoValue_RateLimit.1 autoValue_RateLimit$14) {
        super(string, l2, l3, 14, obj5);
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public boolean equals(Object object) {
        int i;
        boolean equals;
        String timeToLiveMillis2;
        long timeToLiveMillis;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof RateLimit) {
            if (this.limiterKey.equals((RateLimit)object.limiterKey()) && Long.compare(timeToLiveMillis2, timeToLiveMillis) == 0 && Long.compare(timeToLiveMillis2, timeToLiveMillis) == 0) {
                if (Long.compare(timeToLiveMillis2, timeToLiveMillis) == 0) {
                    if (Long.compare(timeToLiveMillis2, timeToLiveMillis) == 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public int hashCode() {
        int i7 = 1000003;
        long limit = this.limit;
        final int i13 = 32;
        long timeToLiveMillis = this.timeToLiveMillis;
        return i5 ^= i9;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long limit() {
        return this.limit;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public String limiterKey() {
        return this.limiterKey;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public long timeToLiveMillis() {
        return this.timeToLiveMillis;
    }

    @Override // com.google.firebase.inappmessaging.model.RateLimit
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RateLimit{limiterKey=");
        stringBuilder.append(this.limiterKey);
        stringBuilder.append(", limit=");
        stringBuilder.append(this.limit);
        stringBuilder.append(", timeToLiveMillis=");
        stringBuilder.append(this.timeToLiveMillis);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
