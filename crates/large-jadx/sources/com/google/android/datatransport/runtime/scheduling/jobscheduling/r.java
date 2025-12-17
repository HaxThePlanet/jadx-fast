package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.c0.a;
import f.c.a.b.i.p;
import f.c.a.b.i.y.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class r implements com.google.android.datatransport.runtime.scheduling.jobscheduling.x {

    private final Context a;
    private final i0 b;
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.s c;
    public r(Context context, i0 i02, com.google.android.datatransport.runtime.scheduling.jobscheduling.s s3) {
        super();
        this.a = context;
        this.b = i02;
        this.c = s3;
    }

    private boolean d(JobScheduler jobScheduler, int i2, int i3) {
        int next;
        int i;
        int int;
        String str;
        Iterator obj5 = jobScheduler.getAllPendingJobs().iterator();
        i = 0;
        while (obj5.hasNext()) {
            Object next2 = obj5.next();
            if (next2.getId() == i2) {
                break;
            } else {
            }
            i = 0;
        }
        return i;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    public void a(p p, int i2) {
        b(p, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    public void b(p p, int i2, boolean z3) {
        byte[] encodeToString;
        Object str;
        boolean obj15;
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        Object systemService = this.a.getSystemService("jobscheduler");
        int i3 = c(p);
        final String str3 = "JobInfoScheduler";
        if (!z3 && d((JobScheduler)systemService, i3, i2)) {
            if (d(systemService, i3, i2)) {
                a.a(str3, "Upload for context %s is already scheduled. Returning...", p);
            }
        }
        final long l3 = this.b.C1(p);
        obj15 = new JobInfo.Builder(i3, componentName);
        this.c.c(obj15, p.d(), l3, obj8);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i2);
        persistableBundle.putString("backendName", p.b());
        persistableBundle.putInt("priority", a.a(p.d()));
        int i7 = 0;
        if (p.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(p.c(), i7));
        }
        obj15.setExtras(persistableBundle);
        Object[] arr = new Object[5];
        arr[i7] = p;
        arr[1] = Integer.valueOf(i3);
        arr[2] = Long.valueOf(this.c.g(p.d(), l3, obj11));
        arr[3] = Long.valueOf(l3);
        arr[4] = Integer.valueOf(i2);
        a.b(str3, "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", arr);
        systemService.schedule(obj15.build());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    int c(p p) {
        byte[] obj5;
        Adler32 adler32 = new Adler32();
        String str2 = "UTF-8";
        adler32.update(this.a.getPackageName().getBytes(Charset.forName(str2)));
        adler32.update(p.b().getBytes(Charset.forName(str2)));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(p.d())).array());
        if (p.c() != null) {
            adler32.update(p.c());
        }
        return (int)value;
    }
}
