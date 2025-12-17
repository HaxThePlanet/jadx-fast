package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inappmessaging.dagger.Lazy;
import com.google.firebase.inappmessaging.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.internal.time.Clock;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import f.c.d.a.a.a.b;
import f.c.d.a.a.a.b.a;
import f.c.f.a.a.a.e.b;
import f.c.f.a.a.a.e.c;
import f.c.f.a.a.a.e.c.b;
import f.c.f.a.a.a.e.d;
import f.c.f.a.a.a.e.d.b;
import f.c.f.a.a.a.e.e;
import f.c.f.a.a.a.e.e.b;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ApiClient {

    private static final String FETCHING_CAMPAIGN_MESSAGE = "Fetching campaigns from service.";
    private final Application application;
    private final Clock clock;
    private final FirebaseApp firebaseApp;
    private final Lazy<com.google.firebase.inappmessaging.internal.GrpcClient> grpcClient;
    private final com.google.firebase.inappmessaging.internal.ProviderInstaller providerInstaller;
    public ApiClient(Lazy<com.google.firebase.inappmessaging.internal.GrpcClient> lazy, FirebaseApp firebaseApp2, Application application3, Clock clock4, com.google.firebase.inappmessaging.internal.ProviderInstaller providerInstaller5) {
        super();
        this.grpcClient = lazy;
        this.firebaseApp = firebaseApp2;
        this.application = application3;
        this.clock = clock4;
        this.providerInstaller = providerInstaller5;
    }

    private c getClientAppInfo(com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult) {
        final c.b bVar = c.f();
        bVar.d(this.firebaseApp.getOptions().getApplicationId());
        bVar.b(installationIdResult.installationId());
        bVar.c(installationIdResult.installationTokenResult().getToken());
        return (c)bVar.build();
    }

    private b getClientSignals() {
        b.a aVar = b.g();
        aVar.d(String.valueOf(Build.VERSION.SDK_INT));
        aVar.c(Locale.getDefault().toString());
        aVar.e(TimeZone.getDefault().getID());
        String versionName = getVersionName();
        if (!TextUtils.isEmpty(versionName)) {
            aVar.b(versionName);
        }
        return (b)aVar.build();
    }

    private String getVersionName() {
        try {
            return packageInfo.versionName;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error finding versionName : ");
            Throwable th = th.getMessage();
            stringBuilder.append(th);
            th = stringBuilder.toString();
            Logging.loge(th);
            th = null;
            return th;
        }
    }

    private e withCacheExpirationSafeguards(e e) {
        int cmp;
        int i;
        TimeUnit mINUTES;
        long millis;
        final int i3 = 1;
        if (Long.compare(l, i) >= 0 && Long.compare(l2, i) > 0) {
            if (Long.compare(l2, i) > 0) {
            }
            return e;
        }
        z.a obj10 = e.toBuilder();
        (e.b)obj10.b(l3 += millis2);
        return (e)obj10.build();
    }

    e getFiams(com.google.firebase.inappmessaging.internal.InstallationIdResult installationIdResult, b b2) {
        Logging.logi("Fetching campaigns from service.");
        this.providerInstaller.install();
        final d.b bVar = d.j();
        bVar.d(this.firebaseApp.getOptions().getGcmSenderId());
        bVar.b(b2.f());
        bVar.c(getClientSignals());
        bVar.e(getClientAppInfo(installationIdResult));
        return withCacheExpirationSafeguards((GrpcClient)this.grpcClient.get().fetchEligibleCampaigns((d)bVar.build()));
    }
}
