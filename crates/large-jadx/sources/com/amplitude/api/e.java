package com.amplitude.api;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* loaded from: classes.dex */
class e implements Application.ActivityLifecycleCallbacks {

    private static final String b;
    private static com.amplitude.api.g c;
    private com.amplitude.api.f a = null;
    static {
        e.b = e.class.getName();
        e.c = g.d();
    }

    public e(com.amplitude.api.f f) {
        super();
        int i = 0;
        if (f == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
        }
        this.a = f;
        f.m0();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    protected long a() {
        return System.currentTimeMillis();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        com.amplitude.api.f obj3 = this.a;
        if (obj3 == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
        }
        obj3.Q(a());
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        com.amplitude.api.f obj3 = this.a;
        if (obj3 == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
        }
        obj3.P(a());
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
