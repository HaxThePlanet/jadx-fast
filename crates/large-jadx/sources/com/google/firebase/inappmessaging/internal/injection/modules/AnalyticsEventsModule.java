package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.AnalyticsEventsManager;
import com.google.firebase.inappmessaging.internal.injection.qualifiers.AnalyticsListener;
import i.b.k0.a;

/* loaded from: classes2.dex */
@Module
public class AnalyticsEventsModule {
    @Provides
    @AnalyticsListener
    a<String> providesAnalyticsConnectorEvents(AnalyticsEventsManager analyticsEventsManager) {
        return analyticsEventsManager.getAnalyticsEventsFlowable();
    }

    @Provides
    AnalyticsEventsManager providesAnalyticsEventsManager(AnalyticsConnector analyticsConnector) {
        AnalyticsEventsManager analyticsEventsManager = new AnalyticsEventsManager(analyticsConnector);
        return analyticsEventsManager;
    }
}
