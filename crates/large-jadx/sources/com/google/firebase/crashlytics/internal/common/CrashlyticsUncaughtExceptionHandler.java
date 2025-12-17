package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
class CrashlyticsUncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {

    private final com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener crashListener;
    private final java.lang.Thread.UncaughtExceptionHandler defaultHandler;
    private final AtomicBoolean isHandlingException;
    private final CrashlyticsNativeComponent nativeComponent;
    private final SettingsDataProvider settingsDataProvider;

    interface CrashListener {
        public abstract void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread2, Throwable throwable3);
    }
    public CrashlyticsUncaughtExceptionHandler(com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler.CrashListener crashlyticsUncaughtExceptionHandler$CrashListener, SettingsDataProvider settingsDataProvider2, java.lang.Thread.UncaughtExceptionHandler thread$UncaughtExceptionHandler3, CrashlyticsNativeComponent crashlyticsNativeComponent4) {
        super();
        this.crashListener = crashListener;
        this.settingsDataProvider = settingsDataProvider2;
        this.defaultHandler = uncaughtExceptionHandler3;
        AtomicBoolean obj1 = new AtomicBoolean(0);
        this.isHandlingException = obj1;
        this.nativeComponent = crashlyticsNativeComponent4;
    }

    private boolean shouldRecordUncaughtException(Thread thread, Throwable throwable2) {
        final int i = 0;
        if (thread == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null thread");
            return i;
        }
        if (throwable2 == null) {
            Logger.getLogger().e("Crashlytics will not record uncaught exception; null throwable");
            return i;
        }
        if (this.nativeComponent.hasCrashDataForCurrentSession()) {
            Logger.getLogger().d("Crashlytics will not record uncaught exception; native crash exists for session.");
            return i;
        }
        return 1;
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    boolean isHandlingException() {
        return this.isHandlingException.get();
    }

    @Override // java.lang.Thread$UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable2) {
        Object crashListener;
        Object settingsDataProvider;
        String str;
        this.isHandlingException.set(true);
        if (shouldRecordUncaughtException(thread, throwable2)) {
            this.crashListener.onUncaughtException(this.settingsDataProvider, thread, throwable2);
        } else {
            Logger.getLogger().d("Uncaught exception will not be recorded by Crashlytics.");
        }
        Logger.getLogger().d("Completed exception processing. Invoking default exception handler.");
        this.defaultHandler.uncaughtException(thread, throwable2);
        this.isHandlingException.set(false);
    }
}
