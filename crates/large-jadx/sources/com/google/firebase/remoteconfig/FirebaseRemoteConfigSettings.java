package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigSettings {

    private final long fetchTimeoutInSeconds;
    private final long minimumFetchInterval;

    public static class Builder {

        private long fetchTimeoutInSeconds = 60;
        private long minimumFetchInterval = 60;
        public Builder() {
            super();
            int i = 60;
            long dEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;
        }

        static long access$000(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder firebaseRemoteConfigSettings$Builder) {
            return builder.fetchTimeoutInSeconds;
        }

        static long access$100(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder firebaseRemoteConfigSettings$Builder) {
            return builder.minimumFetchInterval;
        }

        public com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings build() {
            FirebaseRemoteConfigSettings firebaseRemoteConfigSettings = new FirebaseRemoteConfigSettings(this, 0);
            return firebaseRemoteConfigSettings;
        }

        public long getFetchTimeoutInSeconds() {
            return this.fetchTimeoutInSeconds;
        }

        public long getMinimumFetchIntervalInSeconds() {
            return this.minimumFetchInterval;
        }

        public com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder setFetchTimeoutInSeconds(long l) {
            if (Long.compare(l, i) < 0) {
            } else {
                this.fetchTimeoutInSeconds = l;
                return this;
            }
            Object[] arr = new Object[1];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(l)));
            throw illegalArgumentException;
        }

        public com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder setMinimumFetchIntervalInSeconds(long l) {
            if (Long.compare(l, i) < 0) {
            } else {
                this.minimumFetchInterval = l;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Minimum interval between fetches has to be a non-negative number. ");
            stringBuilder.append(l);
            stringBuilder.append(" is an invalid argument");
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
    }
    private FirebaseRemoteConfigSettings(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder firebaseRemoteConfigSettings$Builder) {
        super();
        this.fetchTimeoutInSeconds = FirebaseRemoteConfigSettings.Builder.access$000(builder);
        this.minimumFetchInterval = FirebaseRemoteConfigSettings.Builder.access$100(builder);
    }

    FirebaseRemoteConfigSettings(com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder firebaseRemoteConfigSettings$Builder, com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.1 firebaseRemoteConfigSettings$12) {
        super(builder);
    }

    public long getFetchTimeoutInSeconds() {
        return this.fetchTimeoutInSeconds;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.minimumFetchInterval;
    }

    public com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings.Builder toBuilder() {
        FirebaseRemoteConfigSettings.Builder builder = new FirebaseRemoteConfigSettings.Builder();
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }
}
