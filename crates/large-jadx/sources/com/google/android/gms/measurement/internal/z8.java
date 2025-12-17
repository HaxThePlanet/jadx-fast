package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* loaded from: classes2.dex */
public final class z8 implements Runnable {

    public final com.google.android.gms.measurement.internal.c9 a;
    public final com.google.android.gms.measurement.internal.q3 b;
    public final JobParameters c;
    public z8(com.google.android.gms.measurement.internal.c9 c9, com.google.android.gms.measurement.internal.q3 q32, JobParameters jobParameters3) {
        super();
        this.a = c9;
        this.b = q32;
        this.c = jobParameters3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d(this.b, this.c);
    }
}
