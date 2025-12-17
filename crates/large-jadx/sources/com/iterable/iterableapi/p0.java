package com.iterable.iterableapi;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.o;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class p0 {

    private static com.iterable.iterableapi.p0.a a;

    private static class a {

        Intent a;
        com.iterable.iterableapi.m0 b;
        com.iterable.iterableapi.e c;
        JSONObject d;
        a(Intent intent, com.iterable.iterableapi.m0 m02, com.iterable.iterableapi.e e3, boolean z4, JSONObject jSONObject5) {
            super();
            this.a = intent;
            this.b = m02;
            this.c = e3;
            this.d = jSONObject5;
        }
    }
    static {
    }

    static void a(Context context, Intent intent2) {
        (NotificationManager)context.getSystemService("notification").cancel(intent2.getIntExtra("requestCode", 0));
    }

    static void b(Context context) {
        Intent intent;
        Throwable obj2;
        try {
            intent = new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS");
            context.sendBroadcast(intent);
            context = context.getLocalizedMessage();
            j0.i("IterablePushNotificationUtil", context);
        }
    }

    static boolean c(Context context, com.iterable.iterableapi.p0.a p0$a2) {
        j.p.O(a2.a);
        j.p.N(a2.b);
        j.p.d0(a2.b.c(), a2.b.g(), a2.b.f(), a2.d);
        return g.a(context, a2.c, h.PUSH);
    }

    private static com.iterable.iterableapi.e d(Bundle bundle) {
        Throwable obj4;
        final String str = "uri";
        if (bundle.containsKey(str)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "openUrl");
            jSONObject.put("data", bundle.getString(str));
            return e.c(jSONObject);
        }
        return null;
    }

    static void e(Context context, Intent intent2) {
        boolean equals;
        int resolveActivity;
        String str2;
        String stringExtra;
        int i2;
        String str;
        int i;
        boolean equals2;
        int obj10;
        equals = "default";
        if (intent2.getExtras() == null) {
            j0.c("IterablePushNotificationUtil", "handlePushAction: extras == null, can't handle push action");
        }
        m0 m0Var = new m0(intent2.getExtras());
        str2 = "actionIdentifier";
        stringExtra = intent2.getStringExtra(str2);
        i2 = 0;
        JSONObject jSONObject = new JSONObject();
        i = 1;
        if (stringExtra != null) {
            if (stringExtra.equals(equals)) {
                jSONObject.put(str2, equals);
                if (m0Var.d() == null) {
                    i2 = p0.d(intent2.getExtras());
                }
            } else {
                jSONObject.put(str2, stringExtra);
                com.iterable.iterableapi.m0.a aVar = m0Var.a(stringExtra);
                equals = o.k(intent2);
                equals = equals.getString("userInput");
                if (aVar.c.equals("textInput") && equals != null && equals != null) {
                    equals = o.k(intent2);
                    if (equals != null) {
                        equals = equals.getString("userInput");
                        if (equals != null) {
                            jSONObject.putOpt("userText", equals);
                            i2.b = equals;
                        }
                    }
                }
                i = str2;
            }
        }
        resolveActivity = i;
        super(intent2, m0Var, i2, resolveActivity, jSONObject);
        p0.a = aVar2;
        obj10 = 0;
        if (j.s().t() != null) {
            obj10 = p0.f(context);
        }
        obj10 = n0.b(context);
        obj10.setFlags(872415232);
        if (resolveActivity != null && obj10 == null && obj10.resolveActivity(context.getPackageManager()) != null) {
            if (obj10 == null) {
                obj10 = n0.b(context);
                obj10.setFlags(872415232);
                if (obj10.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(obj10);
                }
            }
        }
    }

    static boolean f(Context context) {
        int aVar;
        boolean obj1;
        aVar = p0.a;
        if (aVar != null) {
            obj1 = p0.c(context, aVar);
            p0.a = 0;
        } else {
            obj1 = 0;
        }
        return obj1;
    }
}
