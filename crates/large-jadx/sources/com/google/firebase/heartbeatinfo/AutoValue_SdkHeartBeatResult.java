package com.google.firebase.heartbeatinfo;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_SdkHeartBeatResult extends com.google.firebase.heartbeatinfo.SdkHeartBeatResult {

    private final long millis;
    private final String sdkName;
    AutoValue_SdkHeartBeatResult(String string, long l2) {
        super();
        Objects.requireNonNull(string, "Null sdkName");
        this.sdkName = string;
        this.millis = l2;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public boolean equals(Object object) {
        int i;
        String sdkName;
        long millis;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof SdkHeartBeatResult != null) {
            if (this.sdkName.equals((SdkHeartBeatResult)object.getSdkName()) && Long.compare(sdkName, millis) == 0) {
                if (Long.compare(sdkName, millis) == 0) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public long getMillis() {
        return this.millis;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public String getSdkName() {
        return this.sdkName;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public int hashCode() {
        int i5 = 1000003;
        long millis = this.millis;
        return i3 ^= i7;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SdkHeartBeatResult{sdkName=");
        stringBuilder.append(this.sdkName);
        stringBuilder.append(", millis=");
        stringBuilder.append(this.millis);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
