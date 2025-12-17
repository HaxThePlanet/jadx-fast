package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.b9;
import com.google.android.gms.measurement.internal.c9;
import d.o.a.a;

/* loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements b9 {

    private c9<com.google.android.gms.measurement.AppMeasurementService> a;
    private final c9<com.google.android.gms.measurement.AppMeasurementService> d() {
        c9 c9Var;
        if (this.a == null) {
            c9Var = new c9(this);
            this.a = c9Var;
        }
        return this.a;
    }

    @Override // android.app.Service
    public final boolean a(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final void b(Intent intent) {
        a.b(intent);
    }

    @Override // android.app.Service
    public final void c(JobParameters jobParameters, boolean z2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return d().b(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        d().e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        d().g(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        d().a(intent, i2, i3);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return 1;
    }
}
