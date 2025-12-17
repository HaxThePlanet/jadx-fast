package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.util.e;

/* loaded from: classes2.dex */
final class g7 implements Application.ActivityLifecycleCallbacks {

    final com.google.android.gms.measurement.internal.i7 a;
    g7(com.google.android.gms.measurement.internal.i7 i7, com.google.android.gms.measurement.internal.f7 f72) {
        this.a = i7;
        super();
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle2) {
        String stringExtra;
        int i;
        String str3;
        com.google.android.gms.measurement.internal.b5 b5Var;
        boolean equals;
        String hierarchical;
        Object str2;
        int i2;
        Uri data;
        String str;
        String queryParameter;
        com.google.android.gms.measurement.internal.e7 e7Var;
        try {
            i7Var.a.b().v().a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent == null) {
            } else {
            }
            b5Var = i7Var5.a;
            b5Var.K().z(activity, bundle2);
            data = intent.getData();
            if (data != null) {
            } else {
            }
            if (!data.isHierarchical()) {
            } else {
            }
            i7Var7.a.N();
            stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
            int i3 = 0;
            i2 = 1;
            if (!"android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) && !"https://www.google.com".equals(stringExtra)) {
            } else {
            }
            if (!"https://www.google.com".equals(stringExtra)) {
            } else {
            }
            if ("android-app://com.google.appcrawler".equals(stringExtra)) {
            } else {
            }
            i = i3;
            i = i2;
            if (i2 != i) {
            } else {
            }
            str3 = "auto";
            str3 = "gs";
            if (bundle2 == null) {
            } else {
            }
            i2 = i3;
            super(this, i2, data, str3, data.getQueryParameter("referrer"));
            i7Var2.a.a().z(e7Var);
            b5Var = i7Var3.a;
            b5Var = i7Var4.a;
        } catch (Throwable th) {
        }
        com.google.android.gms.measurement.internal.i7 i7Var6 = this.a;
        i7Var6 = i7Var6.a;
        i7Var6 = i7Var6.K();
        i7Var6.z(activity, bundle2);
        throw th;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        i7Var.a.K().A(activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        i7Var.a.K().B(activity);
        com.google.android.gms.measurement.internal.m9 obj5 = obj5.a.M();
        e9 e9Var = new e9(obj5, obj5.a.c().a(), obj1);
        obj5.a.a().z(e9Var);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.google.android.gms.measurement.internal.m9 m9Var = i7Var.a.M();
        d9 d9Var = new d9(m9Var, m9Var.a.c().a(), obj2);
        m9Var.a.a().z(d9Var);
        i7Var2.a.K().C(activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
        i7Var.a.K().D(activity, bundle2);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
