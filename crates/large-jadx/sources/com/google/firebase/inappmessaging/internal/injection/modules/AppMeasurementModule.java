package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.ProxyAnalyticsConnector;
import com.google.firebase.inject.Deferred;

/* loaded from: classes2.dex */
@Module
public class AppMeasurementModule {

    private final AnalyticsConnector analyticsConnector;
    private final Subscriber firebaseEventsSubscriber;
    public AppMeasurementModule(Deferred<AnalyticsConnector> deferred, Subscriber subscriber2) {
        super();
        ProxyAnalyticsConnector proxyAnalyticsConnector = new ProxyAnalyticsConnector(deferred);
        this.analyticsConnector = proxyAnalyticsConnector;
        this.firebaseEventsSubscriber = subscriber2;
    }

    @Provides
    AnalyticsConnector providesAnalyticsConnector() {
        return this.analyticsConnector;
    }

    @Provides
    Subscriber providesSubsriber() {
        return this.firebaseEventsSubscriber;
    }
}
