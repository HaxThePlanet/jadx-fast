package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

/* loaded from: classes2.dex */
public final class b implements AnalyticsEventLogger {

    public final com.google.firebase.crashlytics.AnalyticsDeferredProxy a;
    public b(com.google.firebase.crashlytics.AnalyticsDeferredProxy analyticsDeferredProxy) {
        super();
        this.a = analyticsDeferredProxy;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public final void logEvent(String string, Bundle bundle2) {
        this.a.b(string, bundle2);
    }
}
