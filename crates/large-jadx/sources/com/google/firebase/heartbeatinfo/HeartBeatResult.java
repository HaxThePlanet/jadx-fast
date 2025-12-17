package com.google.firebase.heartbeatinfo;

/* loaded from: classes2.dex */
public abstract class HeartBeatResult {
    public static com.google.firebase.heartbeatinfo.HeartBeatResult create(String string, long l2, com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat heartBeatInfo$HeartBeat3) {
        AutoValue_HeartBeatResult autoValue_HeartBeatResult = new AutoValue_HeartBeatResult(string, l2, heartBeat3, obj4);
        return autoValue_HeartBeatResult;
    }

    public abstract com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat getHeartBeat();

    public abstract long getMillis();

    public abstract String getSdkName();
}
