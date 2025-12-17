package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes2.dex */
public class CrashlyticsOriginAnalyticsEventLogger implements com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger {

    static final String FIREBASE_ANALYTICS_ORIGIN_CRASHLYTICS = "clx";
    private final AnalyticsConnector analyticsConnector;
    public CrashlyticsOriginAnalyticsEventLogger(AnalyticsConnector analyticsConnector) {
        super();
        this.analyticsConnector = analyticsConnector;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String string, Bundle bundle2) {
        this.analyticsConnector.logEvent("clx", string, bundle2);
    }
}
