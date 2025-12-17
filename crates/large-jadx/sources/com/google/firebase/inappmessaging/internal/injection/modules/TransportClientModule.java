package com.google.firebase.inappmessaging.internal.injection.modules;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inappmessaging.dagger.Module;
import com.google.firebase.inappmessaging.dagger.Provides;
import com.google.firebase.inappmessaging.internal.DeveloperListenerManager;
import com.google.firebase.inappmessaging.internal.MetricsLoggerClient;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.FirebaseInstallationsApi;
import f.c.a.b.c;
import f.c.a.b.f;
import f.c.a.b.g;

/* loaded from: classes2.dex */
@Module
public class TransportClientModule {

    private static final String TRANSPORT_NAME = "FIREBASE_INAPPMESSAGING";
    static byte[] a(byte[] bArr) {
        return bArr;
    }

    static void b(f f, byte[] b2Arr2) {
        f.a(c.d(b2Arr2));
    }

    @Provides
    static MetricsLoggerClient providesMetricsLoggerClient(FirebaseApp firebaseApp, g g2, AnalyticsConnector analyticsConnector3, FirebaseInstallationsApi firebaseInstallationsApi4, Clock clock5, DeveloperListenerManager developerListenerManager6) {
        d dVar = new d(g2.a("FIREBASE_INAPPMESSAGING", byte[].class, c.a));
        super(dVar, analyticsConnector3, firebaseApp, firebaseInstallationsApi4, clock5, developerListenerManager6);
        return metricsLoggerClient;
    }
}
