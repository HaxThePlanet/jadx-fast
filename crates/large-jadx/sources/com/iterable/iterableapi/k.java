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

/* compiled from: IterableApiClient.java */
/* loaded from: classes2.dex */
class k {

    private final k.a a;
    private h1 b;

    interface a {
        String a();

        String b();

        String c();

        Context getContext();

        String getEmail();

        String getUserId();
    }
    k(k.a aVar) {
        super();
        this.a = aVar;
    }

    private void a(JSONObject jSONObject) {
        try {
            str = "email";
            jSONObject.put(str, this.a.getEmail());
            str = "userId";
            jSONObject.put(str, this.a.getUserId());
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    private void b(JSONObject jSONObject, String str) throws JSONException {
        if (str != null) {
            str = "inboxSessionId";
            jSONObject.put(str, str);
        }
    }

    private JSONObject d() throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("deviceId", this.a.a());
            jSONObject.putOpt("platform", "Android");
            str = "appPackageName";
            jSONObject.putOpt(str, this.a.getContext().getPackageName());
        } catch (Exception e) {
            j0.d("IterableApiClient", "Could not populate deviceInfo JSON", e);
        }
        return jSONObject;
    }

    private JSONObject e(g0 g0Var, e0 e0Var) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("saveToInbox", Boolean.valueOf(g0Var.o()));
            str2 = "silentInbox";
            jSONObject.putOpt(str2, Boolean.valueOf(g0Var.s()));
            str2 = "location";
            jSONObject.putOpt(str2, e0Var.toString());
        } catch (Exception e) {
            e0Var = "IterableApiClient";
            j0.d(e0Var, "Could not populate messageContext JSON", e);
        }
        return jSONObject;
    }

    private h1 h() {
        if (this.b == null) {
            this.b = new d1();
        }
        return this.b;
    }

    protected void c(String str, String str2, String str3, String str4, x xVar, u uVar) {
        String str5;
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("token", str4);
            if (str != null) {
                str6 = "email";
                jSONObject.put(str6, str);
            } else {
                if (str2 != null) {
                    str5 = "userId";
                    jSONObject.put(str5, str2);
                }
            }
            this.o("users/disableDevice", jSONObject, str3, xVar, uVar);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void f(int i, v vVar) {
        final JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        try {
            a(jSONObject);
            jSONObject.put("count", i);
            jSONObject.put("platform", "Android");
            jSONObject.put("SDKVersion", "3.4.2");
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            jSONObject.put("packageName", this.a.getContext().getPackageName());
            str = "inApp/getMessages";
            l(str, jSONObject, vVar);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    void g(v vVar) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("platform", "Android");
            jSONObject.putOpt("appPackageName", this.a.getContext().getPackageName());
            jSONObject.put("SDKVersion", "3.4.2");
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            l("mobile/getRemoteConfiguration", jSONObject, vVar);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void i(g0 g0Var, z zVar, e0 e0Var, String str) {
        String obj;
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            str = "messageId";
            jSONObject.put(str, g0Var.i());
            if (zVar != null) {
                str = "deleteAction";
                jSONObject.put(str, zVar.toString());
            }
            if (e0Var != null) {
                jSONObject.put("messageContext", e(g0Var, e0Var));
                str2 = "deviceInfo";
                jSONObject.put(str2, d());
            }
            if (e0Var == e0.INBOX) {
                b(jSONObject, str);
            }
            str3 = "events/inAppConsume";
            m(str3, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    void j() {
        h().c(this.a.getContext());
    }

    protected void k(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, HashMap<String, String> hashMap) {
        Context context = this.a.getContext();
        final JSONObject jSONObject2 = new JSONObject();
        try {
            a(jSONObject2);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            Iterator it = hashMap.entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                jSONObject.put((String)item.getKey(), item.getValue());
            }
            jSONObject.put("tokenRegistrationType", "FCM");
            boolean z2 = true;
            jSONObject.put("firebaseCompatible", z2);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.putOpt("advertisingId", z0.b(this.a.getContext()));
            jSONObject.put("systemName", Build.DEVICE);
            jSONObject.put("systemVersion", Build.VERSION.RELEASE);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("sdkVersion", Build.VERSION.SDK_INT);
            jSONObject.put("deviceId", this.a.a());
            jSONObject.put("appPackageName", context.getPackageName());
            jSONObject.put("appVersion", z0.c(context));
            jSONObject.put("appBuild", z0.d(context));
            jSONObject.put("iterableSdkVersion", "3.4.2");
            jSONObject.put("notificationsEnabled", m.c(context).a());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("token", str5);
            jSONObject3.put("platform", "GCM");
            jSONObject3.put("applicationName", str4);
            jSONObject3.putOpt("dataFields", jSONObject);
            jSONObject2.put("device", jSONObject3);
            if (str == null && str2 != null) {
                str6 = "preferUserId";
                jSONObject2.put(str6, z2);
            }
            str7 = "users/registerDeviceToken";
            n(str7, jSONObject2, str3);
        } catch (org.json.JSONException jSON) {
            str2 = "IterableApiClient";
            str3 = "registerDeviceToken: exception";
            j0.d(str2, str3, jSON);
        }
    }

    void l(String str, JSONObject jSONObject, v vVar) {
        h().b(this.a.c(), str, jSONObject, this.a.b(), vVar);
    }

    void m(String str, JSONObject jSONObject) {
        n(str, jSONObject, this.a.b());
    }

    void n(String str, JSONObject jSONObject, String str2) {
        this.o(str, jSONObject, str2, null, null);
    }

    void o(String str, JSONObject jSONObject, String str2, x xVar, u uVar) {
        h().a(this.a.c(), str, jSONObject, str2, xVar, uVar);
    }

    void p(boolean z) {
        int sDK_INT2;
        if (Build.VERSION.SDK_INT >= 21 && this.b && this.b != null) {
            if (this.b.getClass() != c1.class) {
                this.b = new c1(this.a.getContext());
            }
        }
    }

    public void q(String str, int i, int i2, JSONObject jSONObject) {
        String str2;
        jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("eventName", str);
            if (i != 0) {
                str2 = "campaignId";
                jSONObject.put(str2, i);
            }
            if (i2 != 0) {
                str2 = "templateId";
                jSONObject.put(str2, i2);
            }
            jSONObject.put("dataFields", jSONObject);
            str3 = "events/track";
            m(str3, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void r(g0 g0Var, String str, e0 e0Var, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("messageId", g0Var.i());
            jSONObject.put("clickedUrl", str);
            jSONObject.put("messageContext", e(g0Var, e0Var));
            jSONObject.put("deviceInfo", d());
            if (e0Var == e0.INBOX) {
                b(jSONObject, str2);
            }
            str = "events/trackInAppClick";
            m(str, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void s(String str, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("messageId", str);
            jSONObject.put("clickedUrl", str2);
            str3 = "events/trackInAppClick";
            m(str3, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    void t(g0 g0Var, String str, y yVar, e0 e0Var, String str2) {
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("messageId", g0Var.i());
            jSONObject.putOpt("clickedUrl", str);
            jSONObject.put("closeAction", yVar.toString());
            jSONObject.put("messageContext", e(g0Var, e0Var));
            jSONObject.put("deviceInfo", d());
            if (e0Var == e0.INBOX) {
                b(jSONObject, str2);
            }
            str = "events/trackInAppClose";
            m(str, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    void u(g0 g0Var) {
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("messageId", g0Var.i());
            jSONObject.put("messageContext", e(g0Var, e0.IN_APP));
            jSONObject.put("deviceInfo", d());
            str = "events/trackInAppDelivery";
            m(str, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void v(g0 g0Var, e0 e0Var, String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
            jSONObject.put("messageId", g0Var.i());
            jSONObject.put("messageContext", e(g0Var, e0Var));
            jSONObject.put("deviceInfo", d());
            if (e0Var == e0.INBOX) {
                b(jSONObject, str);
            }
            str = "events/trackInAppOpen";
            m(str, jSONObject);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    public void w(i0 i0Var, String str) {
        JSONObject jSONObject;
        double d;
        final JSONObject jSONObject2 = new JSONObject();
        try {
            a(jSONObject2);
            jSONObject2.put("inboxSessionStart", i0Var.a.getTime());
            jSONObject2.put("inboxSessionEnd", i0Var.b.getTime());
            jSONObject2.put("startTotalMessageCount", i0Var.c);
            jSONObject2.put("startUnreadMessageCount", i0Var.d);
            jSONObject2.put("endTotalMessageCount", i0Var.e);
            jSONObject2.put("endUnreadMessageCount", i0Var.f);
            if (i0Var.g != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = i0Var.g.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    jSONObject = new JSONObject();
                    jSONObject.put("messageId", item.a);
                    jSONObject.put("silentInbox", item.b);
                    jSONObject.put("displayCount", item.c);
                    str = "displayDuration";
                    d = (double)item.d;
                    jSONObject.put(str, d);
                    jSONArray.put(jSONObject);
                }
                str3 = "impressions";
                jSONObject2.put(str3, jSONArray);
            }
            jSONObject2.putOpt("deviceInfo", d());
            b(jSONObject2, str);
            str4 = "events/trackInboxSession";
            m(str4, jSONObject2);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }

    protected void x(int i, int i2, String str, JSONObject jSONObject) {
        final JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
                a(jSONObject2);
                jSONObject2.put("campaignId", i);
                jSONObject2.put("templateId", i2);
                jSONObject2.put("messageId", str);
                jSONObject2.putOpt("dataFields", jSONObject);
                str = "events/trackPushOpen";
                m(str, jSONObject2);
            } catch (org.json.JSONException jSON) {
                jSON.printStackTrace();
            }
            return;
        }
    }

    public void y(JSONObject jSONObject, Boolean boolean) {
        final JSONObject jSONObject2 = new JSONObject();
        try {
            a(jSONObject2);
            if (this.a.getEmail() == null && this.a.getUserId() != null) {
                userId = "preferUserId";
                boolean z = true;
                jSONObject2.put(userId, z);
            }
            jSONObject2.put("dataFields", jSONObject);
            jSONObject2.put("mergeNestedObjects", boolean);
            str = "users/update";
            m(str, jSONObject2);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
        }
    }
}
