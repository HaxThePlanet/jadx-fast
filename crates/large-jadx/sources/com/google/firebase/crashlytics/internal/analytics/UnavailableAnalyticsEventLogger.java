package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
public class UnavailableAnalyticsEventLogger implements com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger {
    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public void logEvent(String string, Bundle bundle2) {
        Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, no Firebase Analytics");
    }
}
