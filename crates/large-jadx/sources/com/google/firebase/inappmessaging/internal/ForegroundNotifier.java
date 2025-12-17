package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import i.b.a;
import i.b.h;
import i.b.k0.a;
import i.b.r;
import i.b.t0.a;

/* loaded from: classes2.dex */
public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {

    public static final long DELAY_MILLIS = 1000L;
    private Runnable check;
    private boolean foreground = false;
    private final a<String> foregroundSubject;
    private final Handler handler;
    private boolean paused = true;
    public ForegroundNotifier() {
        super();
        Handler handler = new Handler();
        this.handler = handler;
        int i = 0;
        int i2 = 1;
        this.foregroundSubject = a.e();
    }

    private void a() {
        int i;
        boolean paused;
        boolean foreground = this.foreground;
        if (foreground) {
            if (!this.paused && foreground) {
                i = foreground ? 1 : 0;
            } else {
            }
        } else {
        }
        this.foreground = i;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void b() {
        a();
    }

    public a<String> foregroundFlowable() {
        return this.foregroundSubject.toFlowable(a.BUFFER).L();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle2) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Handler handler;
        this.paused = true;
        Runnable obj4 = this.check;
        if (obj4 != null) {
            this.handler.removeCallbacks(obj4);
        }
        y yVar = new y(this);
        this.check = yVar;
        this.handler.postDelayed(yVar, 1000);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Object check;
        Handler handler;
        int obj3;
        this.paused = false;
        int i = 1;
        this.foreground = i;
        check = this.check;
        if (check != null) {
            this.handler.removeCallbacks(check);
        }
        if (obj3 ^= i != 0) {
            Logging.logi("went foreground");
            this.foregroundSubject.onNext("ON_FOREGROUND");
        }
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
