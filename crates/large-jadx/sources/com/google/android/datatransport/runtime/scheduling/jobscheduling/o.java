package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.util.Base64;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.c0.a;
import f.c.a.b.i.p;
import f.c.a.b.i.y.a;

/* loaded from: classes.dex */
public class o implements com.google.android.datatransport.runtime.scheduling.jobscheduling.x {

    private final Context a;
    private final i0 b;
    private AlarmManager c;
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.s d;
    private final a e;
    o(Context context, i0 i02, AlarmManager alarmManager3, a a4, com.google.android.datatransport.runtime.scheduling.jobscheduling.s s5) {
        super();
        this.a = context;
        this.b = i02;
        this.c = alarmManager3;
        this.e = a4;
        this.d = s5;
    }

    public o(Context context, i0 i02, a a3, com.google.android.datatransport.runtime.scheduling.jobscheduling.s s4) {
        super(context, i02, (AlarmManager)context.getSystemService("alarm"), a3, s4);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    public void a(p p, int i2) {
        b(p, i2, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    public void b(p p, int i2, boolean z3) {
        byte[] encodeToString;
        String str;
        boolean obj11;
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", p.b());
        builder.appendQueryParameter("priority", String.valueOf(a.a(p.d())));
        int i4 = 0;
        if (p.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(p.c(), i4));
        }
        final Class<com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver> obj = AlarmManagerSchedulerBroadcastReceiver.class;
        Intent intent = new Intent(this.a, obj);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i2);
        String str3 = "AlarmManagerScheduler";
        if (!z3 && c(intent)) {
            if (c(intent)) {
                a.a(str3, "Upload for context %s is already scheduled. Returning...", p);
            }
        }
        long l = this.b.C1(p);
        long l2 = this.d.g(p.d(), l, obj);
        obj11 = new Object[4];
        obj11[i4] = p;
        obj11[1] = Long.valueOf(l2);
        obj11[2] = Long.valueOf(l);
        int obj10 = 3;
        obj11[obj10] = Integer.valueOf(i2);
        a.b(str3, "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", obj11);
        this.c.set(obj10, time += l2, intent);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.x
    boolean c(Intent intent) {
        int i;
        if (PendingIntent.getBroadcast(this.a, 0, intent, 536870912) != null) {
            i = 1;
        }
        return i;
    }
}
