package com.google.firebase.installations.time;

/* loaded from: classes2.dex */
public class SystemClock implements com.google.firebase.installations.time.Clock {

    private static com.google.firebase.installations.time.SystemClock singleton;
    public static com.google.firebase.installations.time.SystemClock getInstance() {
        com.google.firebase.installations.time.SystemClock systemClock;
        if (SystemClock.singleton == null) {
            systemClock = new SystemClock();
            SystemClock.singleton = systemClock;
        }
        return SystemClock.singleton;
    }

    @Override // com.google.firebase.installations.time.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
