package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.b9;
import com.google.android.gms.measurement.internal.c9;

/* loaded from: classes2.dex */
public final class AppMeasurementJobService extends JobService implements b9 {

    private c9<com.google.android.gms.measurement.AppMeasurementJobService> a;
    private final c9<com.google.android.gms.measurement.AppMeasurementJobService> d() {
        c9 c9Var;
        if (this.a == null) {
            c9Var = new c9(this);
            this.a = c9Var;
        }
        return this.a;
    }

    @Override // android.app.job.JobService
    public final boolean a(int i) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // android.app.job.JobService
    public final void b(Intent intent) {
    }

    @Override // android.app.job.JobService
    public final void c(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.job.JobService
    public void onCreate() {
        super.onCreate();
        d().e();
    }

    @Override // android.app.job.JobService
    public void onDestroy() {
        d().f();
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public void onRebind(Intent intent) {
        d().g(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        d().i(jobParameters);
        return 1;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return 0;
    }

    @Override // android.app.job.JobService
    public boolean onUnbind(Intent intent) {
        d().j(intent);
        return 1;
    }
}
