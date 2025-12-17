package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import f.c.a.b.i.c0.a;
import f.c.a.b.i.p;
import f.c.a.b.i.p.a;
import f.c.a.b.i.t;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    static void a() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        f.c.a.b.d decode;
        String queryParameter2 = intent2.getData().getQueryParameter("extras");
        t.f(context);
        p.a obj5 = p.a();
        obj5.b(intent2.getData().getQueryParameter("backendName"));
        obj5.d(a.b(Integer.valueOf(intent2.getData().getQueryParameter("priority")).intValue()));
        if (queryParameter2 != null) {
            obj5.c(Base64.decode(queryParameter2, 0));
        }
        t.c().e().s(obj5.a(), intent2.getExtras().getInt("attemptNumber"), a.a);
    }
}
