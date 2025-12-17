package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.u0;
import com.google.android.gms.internal.measurement.v0;

/* loaded from: classes2.dex */
public final class p9 extends com.google.android.gms.measurement.internal.r9 {

    private final AlarmManager d;
    private com.google.android.gms.measurement.internal.n e;
    private Integer f;
    protected p9(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
        this.d = (AlarmManager)this.a.f().getSystemService("alarm");
    }

    private final int o() {
        String string;
        Integer valueOf;
        String str;
        int length;
        if (this.f == null) {
            String valueOf2 = String.valueOf(this.a.f().getPackageName());
            str = "measurement";
            if (valueOf2.length() != 0) {
                string = str.concat(valueOf2);
            } else {
                string = new String(str);
            }
            this.f = Integer.valueOf(string.hashCode());
        }
        return this.f.intValue();
    }

    private final PendingIntent p() {
        Context context = this.a.f();
        Intent intent2 = new Intent();
        return u0.a(context, 0, intent2.setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), u0.a);
    }

    private final com.google.android.gms.measurement.internal.n q() {
        com.google.android.gms.measurement.internal.n o9Var;
        com.google.android.gms.measurement.internal.b5 b5Var;
        if (this.e == null) {
            o9Var = new o9(this, this.b.a0());
            this.e = o9Var;
        }
        return this.e;
    }

    private final void r() {
        String str;
        Object systemService = this.a.f().getSystemService("jobscheduler");
        if ((JobScheduler)systemService != null) {
            (JobScheduler)systemService.cancel(o());
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        PendingIntent intent;
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        if (Build.VERSION.SDK_INT >= 24) {
            r();
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void m() {
        Object str;
        i();
        this.a.b().v().a("Unscheduling upload");
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        q().b();
        if (Build.VERSION.SDK_INT >= 24) {
            r();
        }
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final void n(long l) {
        boolean z2;
        int cmp;
        int sDK_INT;
        boolean z;
        int str2;
        int i2;
        String str;
        int i;
        long longValue;
        PendingIntent intent;
        i();
        this.a.d();
        Context context = this.a.f();
        if (!ia.X(context)) {
            this.a.b().q().a("Receiver not registered/enabled");
        }
        if (!ia.Y(context, false)) {
            this.a.b().q().a("Service not registered/enabled");
        }
        m();
        Long valueOf = Long.valueOf(l);
        this.a.b().v().b("Scheduling upload, millis", valueOf);
        this.a.z();
        i = 0;
        if (Long.compare(l, l3) < 0 && !q().e()) {
            if (!q().e()) {
                q().d(l);
            }
        }
        this.a.d();
        if (Build.VERSION.SDK_INT >= 24) {
            Context context2 = this.a.f();
            ComponentName componentName = new ComponentName(context2, "com.google.android.gms.measurement.AppMeasurementJobService");
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
            JobInfo.Builder builder = new JobInfo.Builder(o(), componentName);
            v0.a(context2, builder.setMinimumLatency(l).setOverrideDeadline(l += l).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
        }
        AlarmManager alarmManager = this.d;
        if (alarmManager != null) {
            this.a.z();
            alarmManager.setInexactRepeating(2, l2 + l, obj5, Math.max((Long)c3.s.a(i).longValue(), obj7));
        }
    }
}
