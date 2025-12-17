package com.google.firebase.heartbeatinfo;

import com.google.android.gms.tasks.j;
import java.util.List;

/* loaded from: classes2.dex */
public interface HeartBeatInfo {

    public static enum HeartBeat {

        NONE(false),
        SDK(true),
        GLOBAL(2),
        COMBINED(3);

        private final int code;
        @Override // java.lang.Enum
        public int getCode() {
            return this.code;
        }
    }
    public abstract j<List<com.google.firebase.heartbeatinfo.HeartBeatResult>> getAndClearStoredHeartBeatInfo();

    public abstract com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat getHeartBeatCode(String string);

    public abstract j<Void> storeHeartBeatInfo(String string);
}
