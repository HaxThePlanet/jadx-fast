package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class BlockingAnalyticsEventLogger implements com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger {

    static final String APP_EXCEPTION_EVENT_NAME = "_ae";
    private final com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    private boolean callbackReceived = false;
    private CountDownLatch eventLatch;
    private final Object latchLock;
    private final TimeUnit timeUnit;
    private final int timeout;
    public BlockingAnalyticsEventLogger(com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, int i2, TimeUnit timeUnit3) {
        super();
        Object object = new Object();
        this.latchLock = object;
        int i = 0;
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeout = i2;
        this.timeUnit = timeUnit3;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    boolean isCallbackReceived() {
        return this.callbackReceived;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void logEvent(String string, Bundle bundle2) {
        Logger obj6;
        String obj7;
        final Object latchLock = this.latchLock;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logging event ");
        stringBuilder.append(string);
        stringBuilder.append(" to Firebase Analytics with params ");
        stringBuilder.append(bundle2);
        Logger.getLogger().v(stringBuilder.toString());
        int i2 = 1;
        CountDownLatch countDownLatch = new CountDownLatch(i2);
        this.eventLatch = countDownLatch;
        this.callbackReceived = false;
        this.baseAnalyticsEventLogger.logEvent(string, bundle2);
        Logger.getLogger().v("Awaiting app exception callback from Analytics...");
        synchronized (latchLock) {
            this.callbackReceived = i2;
            Logger.getLogger().v("App exception callback received from Analytics listener.");
            this.eventLatch = 0;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public void onEvent(String string, Bundle bundle2) {
        final CountDownLatch obj3 = this.eventLatch;
        if (obj3 == null) {
        }
        if ("_ae".equals(string)) {
            obj3.countDown();
        }
    }
}
