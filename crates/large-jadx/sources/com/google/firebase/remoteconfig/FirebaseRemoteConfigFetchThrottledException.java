package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigFetchThrottledException extends com.google.firebase.remoteconfig.FirebaseRemoteConfigException {

    private final long throttleEndTimeMillis;
    public FirebaseRemoteConfigFetchThrottledException(long l) {
        super("Fetch was throttled.", l, obj3);
    }

    public FirebaseRemoteConfigFetchThrottledException(String string, long l2) {
        super(string);
        this.throttleEndTimeMillis = l2;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigException
    public long getThrottleEndTimeMillis() {
        return this.throttleEndTimeMillis;
    }
}
