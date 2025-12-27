package com.iterable.iterableapi;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.o;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterablePushNotificationUtil.java */
/* loaded from: classes2.dex */
class p0 {

    private static p0.a a;

    private static class a {

        Intent a;
        m0 b;
        e c;
        JSONObject d;
        a(Intent intent, m0 m0Var, e eVar, boolean z, JSONObject jSONObject) {
            super();
            this.a = intent;
            this.b = m0Var;
            this.c = eVar;
            this.d = jSONObject;
        }
    }
    static void a(Context context, Intent intent) {
        (NotificationManager)context.getSystemService("notification").cancel(intent.getIntExtra("requestCode", 0));
    }

    static void b(Context context) {
        try {
            context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (java.lang.SecurityException se) {
            se = se.getLocalizedMessage();
            j0.i("IterablePushNotificationUtil", se);
        }
    }

    static boolean c(Context context, p0.a aVar) {
        j.p.O(aVar.a);
        j.p.N(aVar.b);
        j.p.d0(aVar.b.c(), aVar.b.g(), aVar.b.f(), aVar.d);
        return g.a(context, aVar.c, h.PUSH);
    }

    private static e d(Bundle bundle) throws JSONException {
        final String str = "uri";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "openUrl");
            jSONObject.put("data", bundle.getString(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    static void e(Context context, Intent intent) {
        boolean equals;
        String stringExtra;
        int i2 = 0;
        int i = 1;
        int i3 = 0;
        str = "default";
        if (intent.getExtras() == null) {
            j0.c("IterablePushNotificationUtil", "handlePushAction: extras == null, can't handle push action");
            return;
        }
        final com.iterable.iterableapi.m0 m0Var = new m0(intent.getExtras());
        str2 = "actionIdentifier";
        stringExtra = intent.getStringExtra(str2);
        i2 = 0;
        final JSONObject jSONObject = new JSONObject();
        i = 1;
        if (stringExtra != null && stringExtra.equals(str)) {
            jSONObject.put(str2, str);
            if (m0Var.d() == null) {
                com.iterable.iterableapi.e eVar3 = p0.d(intent.getExtras());
            }
        }
        p0.a aVar = new p0.a(intent, m0Var, i2, i, jSONObject);
        p0.a = aVar;
        i3 = 0;
        if (j.s().t() != null) {
            boolean z3 = p0.f(context);
        }
        if (i != 0 && i3 == 0) {
            intent = n0.b(context);
            intent.setFlags(872415232);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }

    static boolean f(Context context) {
        boolean z = false;
        aVar = p0.a;
        if (p0.a != null) {
            z = p0.c(context, p0.a);
            com.iterable.iterableapi.p0.a aVar = null;
            p0.a = aVar;
        } else {
            int i = 0;
        }
        return z;
    }

}
