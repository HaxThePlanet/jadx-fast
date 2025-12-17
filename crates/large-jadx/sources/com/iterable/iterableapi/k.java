package com.iterable.iterableapi;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import androidx.core.app.m;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class k {

    private final com.iterable.iterableapi.k.a a;
    private com.iterable.iterableapi.h1 b;

    interface a {
        public abstract String a();

        public abstract String b();

        public abstract String c();

        public abstract Context getContext();

        public abstract String getEmail();

        public abstract String getUserId();
    }
    k(com.iterable.iterableapi.k.a k$a) {
        super();
        this.a = a;
    }

    private void a(JSONObject jSONObject) {
        String str;
        String userId;
        Throwable obj3;
        try {
            if (this.a.getEmail() != null) {
            } else {
            }
            jSONObject.put("email", this.a.getEmail());
            jSONObject.put("userId", this.a.getUserId());
            jSONObject.printStackTrace();
        }
    }

    private void b(JSONObject jSONObject, String string2) {
        String str;
        if (string2 != null) {
            jSONObject.put("inboxSessionId", string2);
        }
    }

    private JSONObject d() {
        String str;
        String packageName;
        String str2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("deviceId", this.a.a());
        jSONObject.putOpt("platform", "Android");
        jSONObject.putOpt("appPackageName", this.a.getContext().getPackageName());
        return jSONObject;
    }

    private JSONObject e(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.e0 e02) {
        Boolean valueOf;
        String obj4;
        String obj5;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("saveToInbox", Boolean.valueOf(g0.o()));
        jSONObject.putOpt("silentInbox", Boolean.valueOf(g0.s()));
        if (e02 != null) {
            jSONObject.putOpt("location", e02.toString());
        }
        return jSONObject;
    }

    private com.iterable.iterableapi.h1 h() {
        com.iterable.iterableapi.h1 d1Var;
        if (this.b == null) {
            d1Var = new d1();
            this.b = d1Var;
        }
        return this.b;
    }

    protected void c(String string, String string2, String string3, String string4, com.iterable.iterableapi.x x5, com.iterable.iterableapi.u u6) {
        Object obj7;
        Object obj8;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", string4);
        if (string != null) {
            jSONObject.put("email", string);
        } else {
            if (string2 != null) {
                jSONObject.put("userId", string2);
            }
        }
        this.o("users/disableDevice", jSONObject, string3, x5, u6);
    }

    public void f(int i, com.iterable.iterableapi.v v2) {
        String obj3;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        a(jSONObject);
        jSONObject.put("count", i);
        jSONObject.put("platform", "Android");
        jSONObject.put("SDKVersion", "3.4.2");
        jSONObject.put("systemVersion", Build.VERSION.RELEASE);
        jSONObject.put("packageName", this.a.getContext().getPackageName());
        l("inApp/getMessages", jSONObject, v2);
    }

    void g(com.iterable.iterableapi.v v) {
        com.iterable.iterableapi.v obj4;
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("platform", "Android");
        jSONObject.putOpt("appPackageName", this.a.getContext().getPackageName());
        jSONObject.put("SDKVersion", "3.4.2");
        jSONObject.put("systemVersion", Build.VERSION.RELEASE);
        l("mobile/getRemoteConfiguration", jSONObject, v);
    }

    public void i(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.z z2, com.iterable.iterableapi.e0 e03, String string4) {
        String str;
        Object obj4;
        String obj5;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", g0.i());
        if (z2 != null) {
            jSONObject.put("deleteAction", z2.toString());
        }
        if (e03 != null) {
            jSONObject.put("messageContext", e(g0, e03));
            jSONObject.put("deviceInfo", d());
        }
        if (e03 == e0.INBOX) {
            try {
                b(jSONObject, string4);
                m("events/inAppConsume", jSONObject);
                g0.printStackTrace();
            }
        }
    }

    void j() {
        h().c(this.a.getContext());
    }

    protected void k(String string, String string2, String string3, String string4, String string5, JSONObject jSONObject6, HashMap<String, String> hashMap7) {
        Object value;
        Object key;
        Object obj5;
        String obj6;
        String obj7;
        JSONObject obj10;
        Context context = this.a.getContext();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        if (jSONObject6 == null) {
            obj10 = new JSONObject();
        }
        Iterator obj11 = hashMap7.entrySet().iterator();
        for (Map.Entry next2 : obj11) {
            obj10.put((String)next2.getKey(), next2.getValue());
        }
        obj10.put("tokenRegistrationType", "FCM");
        int i = 1;
        obj10.put("firebaseCompatible", i);
        obj10.put("brand", Build.BRAND);
        obj10.put("manufacturer", Build.MANUFACTURER);
        obj10.putOpt("advertisingId", z0.b(this.a.getContext()));
        obj10.put("systemName", Build.DEVICE);
        obj10.put("systemVersion", Build.VERSION.RELEASE);
        obj10.put("model", Build.MODEL);
        obj10.put("sdkVersion", Build.VERSION.SDK_INT);
        obj10.put("deviceId", this.a.a());
        obj10.put("appPackageName", context.getPackageName());
        obj10.put("appVersion", z0.c(context));
        obj10.put("appBuild", z0.d(context));
        obj10.put("iterableSdkVersion", "3.4.2");
        obj10.put("notificationsEnabled", m.c(context).a());
        obj11 = new JSONObject();
        obj11.put("token", string5);
        obj11.put("platform", "GCM");
        obj11.put("applicationName", string4);
        obj11.putOpt("dataFields", obj10);
        jSONObject.put("device", obj11);
        if (string == null && string2 != null) {
            if (string2 != null) {
                jSONObject.put("preferUserId", i);
            }
        }
        n("users/registerDeviceToken", jSONObject, string3);
    }

    void l(String string, JSONObject jSONObject2, com.iterable.iterableapi.v v3) {
        h().b(this.a.c(), string, jSONObject2, this.a.b(), v3);
    }

    void m(String string, JSONObject jSONObject2) {
        n(string, jSONObject2, this.a.b());
    }

    void n(String string, JSONObject jSONObject2, String string3) {
        this.o(string, jSONObject2, string3, 0, 0);
    }

    void o(String string, JSONObject jSONObject2, String string3, com.iterable.iterableapi.x x4, com.iterable.iterableapi.u u5) {
        h().a(this.a.c(), string, jSONObject2, string3, x4, u5);
    }

    void p(boolean z) {
        int sDK_INT;
        Object obj3;
        if (Build.VERSION.SDK_INT >= 21) {
            if (z != null) {
                obj3 = this.b;
                if (obj3 != null) {
                    if (obj3.getClass() != c1.class) {
                        obj3 = new c1(this.a.getContext());
                        this.b = obj3;
                    }
                } else {
                }
            } else {
                obj3 = this.b;
                if (obj3 != null) {
                    if (obj3.getClass() != d1.class) {
                        obj3 = new d1();
                        this.b = obj3;
                    }
                } else {
                }
            }
        }
    }

    public void q(String string, int i2, int i3, JSONObject jSONObject4) {
        Object obj3;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("eventName", string);
        if (i2 != 0) {
            jSONObject.put("campaignId", i2);
        }
        if (i3 != 0) {
            jSONObject.put("templateId", i3);
        }
        jSONObject.put("dataFields", jSONObject4);
        m("events/track", jSONObject);
    }

    public void r(com.iterable.iterableapi.g0 g0, String string2, com.iterable.iterableapi.e0 e03, String string4) {
        String obj4;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", g0.i());
        jSONObject.put("clickedUrl", string2);
        jSONObject.put("messageContext", e(g0, e03));
        jSONObject.put("deviceInfo", d());
        if (e03 == e0.INBOX) {
            b(jSONObject, string4);
        }
        m("events/trackInAppClick", jSONObject);
    }

    public void s(String string, String string2) {
        String obj3;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", string);
        jSONObject.put("clickedUrl", string2);
        m("events/trackInAppClick", jSONObject);
    }

    void t(com.iterable.iterableapi.g0 g0, String string2, com.iterable.iterableapi.y y3, com.iterable.iterableapi.e0 e04, String string5) {
        String obj4;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", g0.i());
        jSONObject.putOpt("clickedUrl", string2);
        jSONObject.put("closeAction", y3.toString());
        jSONObject.put("messageContext", e(g0, e04));
        jSONObject.put("deviceInfo", d());
        if (e04 == e0.INBOX) {
            b(jSONObject, string5);
        }
        m("events/trackInAppClose", jSONObject);
    }

    void u(com.iterable.iterableapi.g0 g0) {
        String obj4;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", g0.i());
        jSONObject.put("messageContext", e(g0, 0));
        jSONObject.put("deviceInfo", d());
        m("events/trackInAppDelivery", jSONObject);
    }

    public void v(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.e0 e02, String string3) {
        String obj4;
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        jSONObject.put("messageId", g0.i());
        jSONObject.put("messageContext", e(g0, e02));
        jSONObject.put("deviceInfo", d());
        if (e02 == e0.INBOX) {
            b(jSONObject, string3);
        }
        m("events/trackInAppOpen", jSONObject);
    }

    public void w(com.iterable.iterableapi.i0 i0, String string2) {
        Object jSONArray;
        int next;
        JSONObject jSONObject;
        String str;
        double d;
        Object obj8;
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2);
        jSONObject2.put("inboxSessionStart", i0.a.getTime());
        jSONObject2.put("inboxSessionEnd", i0.b.getTime());
        jSONObject2.put("startTotalMessageCount", i0.c);
        jSONObject2.put("startUnreadMessageCount", i0.d);
        jSONObject2.put("endTotalMessageCount", i0.e);
        jSONObject2.put("endUnreadMessageCount", i0.f);
        if (i0.g != null) {
            jSONArray = new JSONArray();
            obj8 = i0.g.iterator();
            for (i0.a next2 : obj8) {
                jSONObject = new JSONObject();
                jSONObject.put("messageId", next2.a);
                jSONObject.put("silentInbox", next2.b);
                jSONObject.put("displayCount", next2.c);
                jSONObject.put("displayDuration", (double)next);
                jSONArray.put(jSONObject);
            }
            jSONObject2.put("impressions", jSONArray);
        }
        try {
            jSONObject2.putOpt("deviceInfo", d());
            b(jSONObject2, string2);
            m("events/trackInboxSession", jSONObject2);
            i0.printStackTrace();
        }
    }

    protected void x(int i, int i2, String string3, JSONObject jSONObject4) {
        String obj3;
        JSONObject obj6;
        JSONObject jSONObject = new JSONObject();
        if (jSONObject4 == null) {
            obj6 = new JSONObject();
        }
        a(jSONObject);
        jSONObject.put("campaignId", i);
        jSONObject.put("templateId", i2);
        jSONObject.put("messageId", string3);
        jSONObject.putOpt("dataFields", obj6);
        m("events/trackPushOpen", jSONObject);
    }

    public void y(JSONObject jSONObject, Boolean boolean2) {
        String userId;
        int i;
        String obj4;
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2);
        if (this.a.getEmail() == null && this.a.getUserId() != null) {
            if (this.a.getUserId() != null) {
                jSONObject2.put("preferUserId", true);
            }
        }
        jSONObject2.put("dataFields", jSONObject);
        jSONObject2.put("mergeNestedObjects", boolean2);
        m("users/update", jSONObject2);
        try {
        }
    }
}
