package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.e0.m;
import com.facebook.internal.g0.i.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class o {

    private static final ScheduledExecutorService d;
    private final m a;
    private String b;
    private String c;

    class a implements Runnable {

        final Bundle a;
        final com.facebook.login.o b;
        a(com.facebook.login.o o, Bundle bundle2) {
            this.b = o;
            this.a = bundle2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.d(this)) {
            }
            o.a(this.b).g("fb_mobile_login_heartbeat", this.a);
        }
    }
    static {
        o.d = Executors.newSingleThreadScheduledExecutor();
    }

    o(Context context, String string2) {
        m mVar;
        Object obj2;
        String obj3;
        super();
        this.b = string2;
        mVar = new m(context, string2);
        this.a = mVar;
        obj2 = context.getPackageManager();
        obj2 = obj2.getPackageInfo("com.facebook.katana", 0);
        if (obj2 != null && obj2 != null) {
            obj2 = obj2.getPackageInfo("com.facebook.katana", 0);
            if (obj2 != null) {
                this.c = obj2.versionName;
            }
        }
    }

    static m a(com.facebook.login.o o) {
        if (a.d(o.class)) {
            return null;
        }
        return o.a;
    }

    private void g(String string) {
        if (a.d(this)) {
        }
        o.a aVar = new o.a(this, o.k(string));
        o.d.schedule(aVar, 5, obj2);
    }

    static Bundle k(String string) {
        final String str = "";
        if (a.d(o.class)) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("1_timestamp_ms", System.currentTimeMillis());
        bundle.putString("0_auth_logger_id", string);
        bundle.putString("3_method", str);
        bundle.putString("2_result", str);
        bundle.putString("5_error_message", str);
        bundle.putString("4_error_code", str);
        bundle.putString("6_extras", str);
        return bundle;
    }

    public String b() {
        if (a.d(this)) {
            return null;
        }
        return this.b;
    }

    public void c(String string, String string2, String string3, String string4, String string5, Map<String, String> map6, String string7) {
        boolean str;
        String obj4;
        String obj5;
        if (a.d(this)) {
        }
        final Bundle obj2 = o.k(string);
        if (string3 != null) {
            obj2.putString("2_result", string3);
        }
        if (string4 != null) {
            obj2.putString("5_error_message", string4);
        }
        if (string5 != null) {
            try {
                obj2.putString("4_error_code", string5);
                if (map6 != null && !map6.isEmpty()) {
                }
                if (!map6.isEmpty()) {
                }
                obj4 = new JSONObject(map6);
                obj2.putString("6_extras", obj4.toString());
                obj2.putString("3_method", string2);
                this.a.g(string7, obj2);
                a.b(string, this);
            }
        }
    }

    public void d(String string, String string2, String string3) {
        if (a.d(this)) {
        }
        final Bundle obj2 = o.k(string);
        obj2.putString("3_method", string2);
        this.a.g(string3, obj2);
    }

    public void e(String string, String string2, String string3) {
        if (a.d(this)) {
        }
        final Bundle obj2 = o.k(string);
        obj2.putString("3_method", string2);
        this.a.g(string3, obj2);
    }

    public void f(String string, Map<String, String> map2, com.facebook.login.l.e.b l$e$b3, Map<String, String> map4, Exception exception5, String string6) {
        String message;
        boolean empty;
        String loggingValue;
        Object obj5;
        boolean obj7;
        String obj8;
        if (a.d(this)) {
        }
        Bundle bundle = o.k(string);
        if (b3 != null) {
            bundle.putString("2_result", b3.getLoggingValue());
        }
        if (exception5 != null && exception5.getMessage() != null) {
            if (exception5.getMessage() != null) {
                bundle.putString("5_error_message", exception5.getMessage());
            }
        }
        try {
            obj8 = 0;
            if (!map2.isEmpty()) {
            }
            obj8 = new JSONObject(map2);
            if (map4 != null && obj8 == null) {
            }
            if (obj8 == null) {
            }
            obj5 = new JSONObject();
            obj8 = obj5;
            obj5 = map4.entrySet().iterator();
            for (Map.Entry obj7 : obj5) {
                obj8.put((String)obj7.getKey(), obj7.getValue());
            }
            obj7 = obj5.next();
            obj8.put((String)(Map.Entry)obj7.getKey(), obj7.getValue());
            if (obj8 != null) {
            }
            bundle.putString("6_extras", obj8.toString());
            this.a.g(string6, bundle);
            if (b3 == l.e.b.SUCCESS) {
            }
            g(string);
            a.b(string, this);
        } catch (org.json.JSONException jSON) {
        } catch (Throwable th1) {
        }
    }

    public void h(com.facebook.login.l.d l$d, String string2) {
        Object str;
        boolean str2;
        Object obj6;
        if (a.d(this)) {
        }
        Bundle bundle = o.k(d.b());
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("login_behavior", d.g().toString());
        jSONObject.put("request_code", l.p());
        jSONObject.put("permissions", TextUtils.join(",", d.k()));
        jSONObject.put("default_audience", d.d().toString());
        jSONObject.put("isReauthorize", d.p());
        String str9 = this.c;
        if (str9 != null) {
            jSONObject.put("facebookVersion", str9);
        }
        if (d.h() != null) {
            jSONObject.put("target_app", d.h().toString());
        }
        bundle.putString("6_extras", jSONObject.toString());
        this.a.h(string2, 0, bundle);
    }

    public void i(String string, String string2) {
        if (a.d(this)) {
        }
        j(string, string2, "");
    }

    public void j(String string, String string2, String string3) {
        if (a.d(this)) {
        }
        Bundle bundle = o.k("");
        bundle.putString("2_result", l.e.b.ERROR.getLoggingValue());
        bundle.putString("5_error_message", string2);
        bundle.putString("3_method", string3);
        this.a.g(string, bundle);
    }
}
