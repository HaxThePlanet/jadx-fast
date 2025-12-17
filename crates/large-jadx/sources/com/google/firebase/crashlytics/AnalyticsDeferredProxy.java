package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle;
import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.analytics.UnavailableAnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.breadcrumbs.DisabledBreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AnalyticsDeferredProxy {

    private final Deferred<AnalyticsConnector> analyticsConnectorDeferred;
    private volatile AnalyticsEventLogger analyticsEventLogger;
    private final List<BreadcrumbHandler> breadcrumbHandlerList;
    private volatile BreadcrumbSource breadcrumbSource;
    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred) {
        DisabledBreadcrumbSource disabledBreadcrumbSource = new DisabledBreadcrumbSource();
        UnavailableAnalyticsEventLogger unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        super(deferred, disabledBreadcrumbSource, unavailableAnalyticsEventLogger);
    }

    public AnalyticsDeferredProxy(Deferred<AnalyticsConnector> deferred, BreadcrumbSource breadcrumbSource2, AnalyticsEventLogger analyticsEventLogger3) {
        super();
        this.analyticsConnectorDeferred = deferred;
        this.breadcrumbSource = breadcrumbSource2;
        ArrayList obj1 = new ArrayList();
        this.breadcrumbHandlerList = obj1;
        this.analyticsEventLogger = analyticsEventLogger3;
        init();
    }

    private void a(String string, Bundle bundle2) {
        this.analyticsEventLogger.logEvent(string, bundle2);
    }

    private void c(BreadcrumbHandler breadcrumbHandler) {
        boolean breadcrumbHandlerList;
        synchronized (this) {
            try {
                this.breadcrumbHandlerList.add(breadcrumbHandler);
                this.breadcrumbSource.registerBreadcrumbHandler(breadcrumbHandler);
                throw breadcrumbHandler;
            }
        }
    }

    private void e(Provider provider) {
        Object iterator;
        BlockingAnalyticsEventLogger blockingAnalyticsEventLogger;
        boolean next;
        int next2;
        TimeUnit mILLISECONDS;
        Object obj6;
        Logger.getLogger().d("AnalyticsConnector now available.");
        obj6 = provider.get();
        CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger((AnalyticsConnector)obj6);
        CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
        if (AnalyticsDeferredProxy.subscribeToAnalyticsEvents(obj6, crashlyticsAnalyticsListener) != null) {
            Logger.getLogger().d("Registered Firebase Analytics listener.");
            obj6 = new BreadcrumbAnalyticsEventReceiver();
            blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
            iterator = this.breadcrumbHandlerList.iterator();
            synchronized (this) {
                for (BreadcrumbHandler next2 : iterator) {
                    obj6.registerBreadcrumbHandler(next2);
                }
                crashlyticsAnalyticsListener.setBreadcrumbEventReceiver(obj6);
                crashlyticsAnalyticsListener.setCrashlyticsOriginEventReceiver(blockingAnalyticsEventLogger);
                this.breadcrumbSource = obj6;
                this.analyticsEventLogger = blockingAnalyticsEventLogger;
            }
        } else {
            Logger.getLogger().w("Could not register Firebase Analytics listener; a listener is already registered.");
        }
    }

    private void init() {
        a aVar = new a(this);
        this.analyticsConnectorDeferred.whenAvailable(aVar);
    }

    private static AnalyticsConnector.AnalyticsConnectorHandle subscribeToAnalyticsEvents(AnalyticsConnector analyticsConnector, com.google.firebase.crashlytics.CrashlyticsAnalyticsListener crashlyticsAnalyticsListener2) {
        AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener;
        String str;
        Logger obj2;
        Object obj3;
        Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
        if (analyticsConnector.registerAnalyticsConnectorListener("clx", crashlyticsAnalyticsListener2) == null && analyticsConnector.registerAnalyticsConnectorListener("crash", crashlyticsAnalyticsListener2) != null) {
            Logger.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            if (analyticsConnector.registerAnalyticsConnectorListener("crash", crashlyticsAnalyticsListener2) != null) {
                Logger.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return registerAnalyticsConnectorListener;
    }

    public void b(String string, Bundle bundle2) {
        a(string, bundle2);
    }

    public void d(BreadcrumbHandler breadcrumbHandler) {
        c(breadcrumbHandler);
    }

    public void f(Provider provider) {
        e(provider);
    }

    public AnalyticsEventLogger getAnalyticsEventLogger() {
        b bVar = new b(this);
        return bVar;
    }

    public BreadcrumbSource getDeferredBreadcrumbSource() {
        c cVar = new c(this);
        return cVar;
    }
}
