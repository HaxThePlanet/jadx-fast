package com.google.firebase.heartbeatinfo;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_HeartBeatResult extends com.google.firebase.heartbeatinfo.HeartBeatResult {

    private final com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat heartBeat;
    private final long millis;
    private final String sdkName;
    AutoValue_HeartBeatResult(String string, long l2, com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat heartBeatInfo$HeartBeat3) {
        super();
        Objects.requireNonNull(string, "Null sdkName");
        this.sdkName = string;
        this.millis = l2;
        Objects.requireNonNull(obj5, "Null heartBeat");
        this.heartBeat = obj5;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public boolean equals(Object object) {
        int i;
        boolean heartBeat;
        String sdkName;
        long millis;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof HeartBeatResult != null) {
            if (this.sdkName.equals((HeartBeatResult)object.getSdkName()) && Long.compare(sdkName, millis) == 0 && this.heartBeat.equals(object.getHeartBeat())) {
                if (Long.compare(sdkName, millis) == 0) {
                    if (this.heartBeat.equals(object.getHeartBeat())) {
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

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat getHeartBeat() {
        return this.heartBeat;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public long getMillis() {
        return this.millis;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String getSdkName() {
        return this.sdkName;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public int hashCode() {
        int i7 = 1000003;
        long millis = this.millis;
        return i5 ^= i8;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HeartBeatResult{sdkName=");
        stringBuilder.append(this.sdkName);
        stringBuilder.append(", millis=");
        stringBuilder.append(this.millis);
        stringBuilder.append(", heartBeat=");
        stringBuilder.append(this.heartBeat);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
