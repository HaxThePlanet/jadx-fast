package com.google.firebase.perf.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.r;
import com.google.firebase.perf.FirebasePerformanceInitializer;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.metrics.AppStartTrace.StartFromBackgroundRunnable;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;

/* loaded from: classes2.dex */
public class FirebasePerfProvider extends ContentProvider {

    private static final Timer APP_START_TIME = null;
    static final String EMPTY_APPLICATION_ID_PROVIDER_AUTHORITY = "com.google.firebase.firebaseperfprovider";
    private final Handler mainHandler;
    static {
        Clock clock = new Clock();
        FirebasePerfProvider.APP_START_TIME = clock.getTime();
    }

    public FirebasePerfProvider() {
        super();
        Handler handler = new Handler(Looper.getMainLooper());
        this.mainHandler = handler;
    }

    private static void checkContentProviderAuthority(ProviderInfo providerInfo) {
        r.k(providerInfo, "FirebasePerfProvider ProviderInfo cannot be null.");
        if ("com.google.firebase.firebaseperfprovider".equals(providerInfo.authority)) {
        } else {
        }
        IllegalStateException obj1 = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        throw obj1;
    }

    public static Timer getAppStartTime() {
        return FirebasePerfProvider.APP_START_TIME;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo2) {
        FirebasePerfProvider.checkContentProviderAuthority(providerInfo2);
        super.attachInfo(context, providerInfo2);
        ConfigResolver.getInstance().setContentProviderContext(getContext());
        AppStateMonitor obj2 = AppStateMonitor.getInstance();
        obj2.registerActivityLifecycleCallbacks(getContext());
        FirebasePerformanceInitializer obj3 = new FirebasePerformanceInitializer();
        obj2.registerForAppColdStart(obj3);
        obj2 = AppStartTrace.getInstance();
        obj2.registerActivityLifecycleCallbacks(getContext());
        AppStartTrace.StartFromBackgroundRunnable startFromBackgroundRunnable = new AppStartTrace.StartFromBackgroundRunnable(obj2);
        this.mainHandler.post(startFromBackgroundRunnable);
        SessionManager.getInstance().updatePerfSession(ApplicationProcessState.FOREGROUND);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String string2, String[] string3Arr3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues2, String string3, String[] string4Arr4) {
        return 0;
    }
}
