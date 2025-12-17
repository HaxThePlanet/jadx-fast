package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class c9<T extends android.content.Context & com.google.android.gms.measurement.internal.b9>  {

    private final T a;
    public c9(T t) {
        super();
        r.j(t);
        this.a = t;
    }

    private final com.google.android.gms.measurement.internal.q3 k() {
        final int i = 0;
        return b5.H(this.a, i, i).b();
    }

    public final int a(Intent intent, int i2, int i3) {
        boolean obj7;
        int i = 0;
        obj7 = b5.H(this.a, i, i);
        com.google.android.gms.measurement.internal.q3 q3Var = obj7.b();
        final int i4 = 2;
        if (intent == null) {
            q3Var.w().a("AppMeasurementService started with null intent");
            return i4;
        }
        final String action = intent.getAction();
        obj7.d();
        q3Var.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i3), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            obj7 = new y8(this, i3, q3Var, intent);
            h(obj7);
        }
        return i4;
    }

    public final IBinder b(Intent intent) {
        final int i = 0;
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return i;
        }
        String obj4 = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(obj4)) {
            obj4 = new u5(ba.d0(this.a), i);
            return obj4;
        }
        k().w().b("onBind received unknown action", obj4);
        return i;
    }

    final void c(int i, com.google.android.gms.measurement.internal.q3 q32, Intent intent3) {
        boolean str;
        int obj2;
        String obj3;
        if ((b9)this.a.a(i)) {
            q32.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            k().v().a("Completed wakeful intent.");
            (b9)this.a.b(intent3);
        }
    }

    final void d(com.google.android.gms.measurement.internal.q3 q3, JobParameters jobParameters2) {
        q3.v().a("AppMeasurementJobService processed last upload request.");
        (b9)this.a.c(jobParameters2, false);
    }

    public final void e() {
        int i = 0;
        com.google.android.gms.measurement.internal.b5 b5Var = b5.H(this.a, i, i);
        b5Var.d();
        b5Var.b().v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        int i = 0;
        com.google.android.gms.measurement.internal.b5 b5Var = b5.H(this.a, i, i);
        b5Var.d();
        b5Var.b().v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
        }
        k().v().b("onRebind called. action", intent.getAction());
    }

    public final void h(Runnable runnable) {
        com.google.android.gms.measurement.internal.ba baVar = ba.d0(this.a);
        a9 a9Var = new a9(this, baVar, runnable);
        baVar.a().z(a9Var);
    }

    public final boolean i(JobParameters jobParameters) {
        boolean z8Var;
        int i = 0;
        com.google.android.gms.measurement.internal.b5 b5Var = b5.H(this.a, i, i);
        com.google.android.gms.measurement.internal.q3 q3Var = b5Var.b();
        String string = jobParameters.getExtras().getString("action");
        b5Var.d();
        q3Var.v().b("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            z8Var = new z8(this, q3Var, jobParameters);
            h(z8Var);
        }
        return 1;
    }

    public final boolean j(Intent intent) {
        final int i = 1;
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return i;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return i;
    }
}
