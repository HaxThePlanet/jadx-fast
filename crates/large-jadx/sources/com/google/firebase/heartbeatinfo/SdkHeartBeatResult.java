package com.google.firebase.heartbeatinfo;

/* loaded from: classes2.dex */
public abstract class SdkHeartBeatResult implements Comparable<com.google.firebase.heartbeatinfo.SdkHeartBeatResult> {
    public static com.google.firebase.heartbeatinfo.SdkHeartBeatResult create(String string, long l2) {
        AutoValue_SdkHeartBeatResult autoValue_SdkHeartBeatResult = new AutoValue_SdkHeartBeatResult(string, l2, obj3);
        return autoValue_SdkHeartBeatResult;
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.firebase.heartbeatinfo.SdkHeartBeatResult sdkHeartBeatResult) {
        int obj5;
        obj5 = Long.compare(millis, millis2) < 0 ? -1 : 1;
        return obj5;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return compareTo((SdkHeartBeatResult)object);
    }

    @Override // java.lang.Comparable
    public abstract long getMillis();

    @Override // java.lang.Comparable
    public abstract String getSdkName();
}
