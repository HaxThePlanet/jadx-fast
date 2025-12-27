package com.amplitude.api;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* compiled from: AmplitudeCallbacks.java */
/* loaded from: classes.dex */
class e implements Application.ActivityLifecycleCallbacks {

    private static final String b;
    private static g c;
    private f a = null;
    static {
        e.b = e.class.getName();
        e.c = g.d();
    }

    public e(f fVar) {
        super();
        if (fVar == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
            return;
        }
        this.a = fVar;
        fVar.m0();
    }

    protected long a() {
        return System.currentTimeMillis();
    }

    public void onActivityPaused(Activity activity) {
        if (this.a == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
            return;
        }
        this.a.Q(a());
    }

    public void onActivityResumed(Activity activity) {
        if (this.a == null) {
            e.c.b(e.b, "Need to initialize AmplitudeCallbacks with AmplitudeClient instance");
            return;
        }
        this.a.P(a());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
