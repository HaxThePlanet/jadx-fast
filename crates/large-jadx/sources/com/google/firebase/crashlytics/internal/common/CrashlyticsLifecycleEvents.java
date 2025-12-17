package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
interface CrashlyticsLifecycleEvents {
    public abstract void onBeginSession(String string, long l2);

    public abstract void onCustomKey(String string, String string2);

    public abstract void onLog(long l, String string2);

    public abstract void onUserId(String string);
}
