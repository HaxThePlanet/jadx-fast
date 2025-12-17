package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

/* loaded from: classes2.dex */
public interface CrashlyticsNativeComponent {
    public abstract void finalizeSession(String string);

    public abstract com.google.firebase.crashlytics.internal.NativeSessionFileProvider getSessionFileProvider(String string);

    public abstract boolean hasCrashDataForCurrentSession();

    public abstract boolean hasCrashDataForSession(String string);

    public abstract void prepareNativeSession(String string, String string2, long l3, StaticSessionData staticSessionData4);
}
