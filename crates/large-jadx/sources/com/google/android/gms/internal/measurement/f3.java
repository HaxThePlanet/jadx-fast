package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

/* loaded from: classes2.dex */
final class f3 implements Application.ActivityLifecycleCallbacks {

    final com.google.android.gms.internal.measurement.g3 a;
    f3(com.google.android.gms.internal.measurement.g3 g3) {
        this.a = g3;
        super();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle2) {
        x2 x2Var = new x2(this, bundle2, activity);
        g3.M(this.a, x2Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        e3 e3Var = new e3(this, activity);
        g3.M(this.a, e3Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a3 a3Var = new a3(this, activity);
        g3.M(this.a, a3Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        z2 z2Var = new z2(this, activity);
        g3.M(this.a, z2Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        b1 b1Var = new b1();
        d3 d3Var = new d3(this, activity, b1Var);
        g3.M(this.a, d3Var);
        final Bundle obj4 = b1Var.m(50);
        if (obj4 != null) {
            bundle2.putAll(obj4);
        }
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        y2 y2Var = new y2(this, activity);
        g3.M(this.a, y2Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        c3 c3Var = new c3(this, activity);
        g3.M(this.a, c3Var);
    }
}
