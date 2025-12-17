package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigInfoImpl implements FirebaseRemoteConfigInfo {

    private final FirebaseRemoteConfigSettings configSettings;
    private final int lastFetchStatus;
    private final long lastSuccessfulFetchTimeInMillis;

    public static class Builder {

        private FirebaseRemoteConfigSettings builderConfigSettings;
        private int builderLastFetchStatus;
        private long builderLastSuccessfulFetchTimeInMillis;
        Builder(com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.1 firebaseRemoteConfigInfoImpl$1) {
            super();
        }

        public com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl build() {
            super(this.builderLastSuccessfulFetchTimeInMillis, obj2, this.builderLastFetchStatus, this.builderConfigSettings, 0);
            return firebaseRemoteConfigInfoImpl2;
        }

        com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.Builder withConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
            this.builderConfigSettings = firebaseRemoteConfigSettings;
            return this;
        }

        com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.Builder withLastFetchStatus(int i) {
            this.builderLastFetchStatus = i;
            return this;
        }

        public com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.Builder withLastSuccessfulFetchTimeInMillis(long l) {
            this.builderLastSuccessfulFetchTimeInMillis = l;
            return this;
        }
    }
    private FirebaseRemoteConfigInfoImpl(long l, int i2, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings3) {
        super();
        this.lastSuccessfulFetchTimeInMillis = l;
        this.lastFetchStatus = firebaseRemoteConfigSettings3;
        this.configSettings = obj4;
    }

    FirebaseRemoteConfigInfoImpl(long l, int i2, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings3, com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.1 firebaseRemoteConfigInfoImpl$14) {
        super(l, i2, firebaseRemoteConfigSettings3, 14);
    }

    static com.google.firebase.remoteconfig.internal.FirebaseRemoteConfigInfoImpl.Builder newBuilder() {
        FirebaseRemoteConfigInfoImpl.Builder builder = new FirebaseRemoteConfigInfoImpl.Builder(0);
        return builder;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public FirebaseRemoteConfigSettings getConfigSettings() {
        return this.configSettings;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public long getFetchTimeMillis() {
        return this.lastSuccessfulFetchTimeInMillis;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo
    public int getLastFetchStatus() {
        return this.lastFetchStatus;
    }
}
