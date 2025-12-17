package com.facebook.applinks;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.e0.g;
import com.facebook.internal.a;
import com.facebook.internal.b0;
import com.facebook.internal.c0;
import com.facebook.internal.g0.i.a;
import com.facebook.o;
import com.facebook.p;
import com.facebook.s;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    private static final String d = "com.facebook.applinks.a";
    private Uri a;
    private JSONObject b;
    private Bundle c;

    static class a implements Runnable {

        final Context a;
        final String b;
        final com.facebook.applinks.a.b c;
        a(Context context, String string2, com.facebook.applinks.a.b a$b3) {
            this.a = context;
            this.b = string2;
            this.c = b3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.d(this)) {
            }
            a.a(this.a, this.b, this.c);
        }
    }

    public interface b {
        public abstract void a(com.facebook.applinks.a a);
    }
    static {
    }

    static void a(Context context, String string2, com.facebook.applinks.a.b a$b3) {
        a.e(context, string2, b3);
    }

    private static com.facebook.applinks.a b(String string) {
        String str3;
        Object jSONObject3;
        String jSONObject;
        Object str2;
        boolean parse;
        boolean z;
        Object jSONObject2;
        boolean str;
        boolean equals;
        String obj12;
        str3 = "promo_code";
        jSONObject3 = "deeplink_context";
        jSONObject = "extras";
        str2 = "fb_ref";
        final String str5 = "target_url";
        jSONObject2 = "referer_data";
        str = "ref";
        final String str6 = "Unable to parse AppLink JSON";
        final int i = 0;
        if (string == null) {
            return i;
        }
        JSONObject jSONObject11 = new JSONObject(string);
        if (jSONObject11.getJSONObject("bridge_args").getString("method").equals("applink") && jSONObject11.getString("version").equals("2")) {
            if (obj12.equals("2")) {
                obj12 = new a();
                JSONObject jSONObject12 = jSONObject11.getJSONObject("method_args");
                obj12.b = jSONObject12;
                if (jSONObject12.has(str)) {
                    obj12.b.getString(str);
                } else {
                    jSONObject2 = obj12.b.getJSONObject(jSONObject2);
                    if (obj12.b.has(jSONObject2) && jSONObject2.has(str2)) {
                        jSONObject2 = obj12.b.getJSONObject(jSONObject2);
                        if (jSONObject2.has(str2)) {
                            jSONObject2.getString(str2);
                        }
                    }
                }
                if (obj12.b.has(str5)) {
                    parse = Uri.parse(obj12.b.getString(str5));
                    obj12.a = parse;
                    a.f(parse);
                }
                jSONObject = obj12.b.getJSONObject(jSONObject);
                jSONObject3 = jSONObject.getJSONObject(jSONObject3);
                if (obj12.b.has(jSONObject) && jSONObject.has(jSONObject3) && jSONObject3.has(str3)) {
                    jSONObject = obj12.b.getJSONObject(jSONObject);
                    if (jSONObject.has(jSONObject3)) {
                        jSONObject3 = jSONObject.getJSONObject(jSONObject3);
                        if (jSONObject3.has(str3)) {
                            jSONObject3.getString(str3);
                        }
                    }
                }
                obj12.c = a.h(obj12.b);
                return obj12;
            }
        }
        return i;
    }

    public static void c(Context context, com.facebook.applinks.a.b a$b2) {
        a.d(context, 0, b2);
    }

    public static void d(Context context, String string2, com.facebook.applinks.a.b a$b3) {
        String obj3;
        c0.j(context, "context");
        c0.j(b3, "completionHandler");
        if (string2 == null) {
            obj3 = b0.D(context);
        }
        c0.j(obj3, "applicationId");
        a.a aVar = new a.a(context.getApplicationContext(), obj3, b3);
        o.n().execute(aVar);
    }

    private static void e(Context context, String string2, com.facebook.applinks.a.b a$b3) {
        JSONObject jSONObject;
        int optString;
        String str;
        boolean string;
        long optLong;
        boolean empty;
        Object obj7;
        int obj8;
        jSONObject = new JSONObject();
        jSONObject.put("event", "DEFERRED_APP_LINK");
        string = o.s(context);
        b0.v0(jSONObject, a.k(context), g.b(context), string, context);
        b0.w0(jSONObject, o.f());
        jSONObject.put("application_package_name", context.getPackageName());
        obj7 = new Object[1];
        obj8 = 0;
        obj7 = p.z(obj8, String.format("%s/activities", string2), jSONObject, obj8).i().c();
        jSONObject = obj7.optString("applink_args");
        str = -1;
        optLong = obj7.optLong("click_time", str);
        optString = obj7.optString("applink_class");
        obj7 = obj7.optString("applink_url");
        obj8 = a.b(jSONObject);
        JSONObject jSONObject4 = obj8.b;
        str = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
        if (obj7 != null && !TextUtils.isEmpty(jSONObject) && obj8 != null && Long.compare(optLong, str) != 0 && jSONObject4 != null) {
            jSONObject = obj7.optString("applink_args");
            str = -1;
            optLong = obj7.optLong("click_time", str);
            optString = obj7.optString("applink_class");
            obj7 = obj7.optString("applink_url");
            if (!TextUtils.isEmpty(jSONObject)) {
                obj8 = a.b(jSONObject);
                if (obj8 != null) {
                    if (Long.compare(optLong, str) != 0) {
                        jSONObject4 = obj8.b;
                        str = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
                        if (jSONObject4 != null) {
                            try {
                                jSONObject4.put(str, optLong);
                                jSONObject = obj8.c;
                                if (jSONObject != null) {
                                }
                                jSONObject.putString(str, Long.toString(optLong));
                                String str2 = a.d;
                                b0.d0(str2, "Unable to put tap time in AppLinkData.arguments");
                                JSONObject jSONObject3 = obj8.b;
                                str = "com.facebook.platform.APPLINK_NATIVE_CLASS";
                                if (optString != null && jSONObject3 != null) {
                                }
                                jSONObject3 = obj8.b;
                                str = "com.facebook.platform.APPLINK_NATIVE_CLASS";
                                if (jSONObject3 != null) {
                                }
                                jSONObject3.put(str, optString);
                                jSONObject = obj8.c;
                                if (jSONObject != null) {
                                }
                                jSONObject.putString(str, optString);
                                str2 = a.d;
                                b0.d0(str2, "Unable to put app link class name in AppLinkData.arguments");
                                JSONObject jSONObject2 = obj8.b;
                                optString = "com.facebook.platform.APPLINK_NATIVE_URL";
                                if (obj7 != null && jSONObject2 != null) {
                                }
                                jSONObject2 = obj8.b;
                                optString = "com.facebook.platform.APPLINK_NATIVE_URL";
                                if (jSONObject2 != null) {
                                }
                                jSONObject2.put(optString, obj7);
                                jSONObject = obj8.c;
                                if (jSONObject != null) {
                                }
                                jSONObject.putString(optString, obj7);
                                context = a.d;
                                str2 = "Unable to put app link URL in AppLinkData.arguments";
                                b0.d0(context, str2);
                                context = a.d;
                                str2 = "Unable to fetch deferred applink from server";
                                b0.d0(context, str2);
                                b3.a(obj8);
                                b3 = "An error occurred while preparing deferred app link";
                                string2 = new FacebookException(b3, context);
                                throw string2;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static JSONObject f(Uri uri) {
        final int i = 0;
        if (a.d(a.class)) {
            return i;
        }
        if (uri == null) {
            return i;
        }
        final String obj3 = uri.getQueryParameter("al_applink_data");
        if (obj3 == null) {
            return i;
        }
        JSONObject jSONObject = new JSONObject(obj3);
        return jSONObject;
    }

    private static Bundle h(JSONObject jSONObject) {
        Object next;
        Object strArr;
        boolean strArr2;
        int i;
        int length;
        boolean string;
        Bundle bundle = new Bundle();
        final Iterator keys = jSONObject.keys();
        for (String next : keys) {
            strArr = jSONObject.get(next);
            bundle.putString(next, strArr.toString());
            i = 0;
            Object obj = strArr.get(i);
            if (obj instanceof JSONObject != null) {
            } else {
            }
            strArr2 = new String[strArr.length()];
            while (i < strArr.length()) {
                strArr2[i] = strArr.get(i).toString();
                i++;
            }
            bundle.putStringArray(next, strArr2);
            strArr2[i] = strArr.get(i).toString();
            i++;
            strArr2 = new Bundle[strArr.length()];
            while (i < strArr.length()) {
                strArr2[i] = a.h(strArr.getJSONObject(i));
                i++;
            }
            bundle.putParcelableArray(next, strArr2);
            strArr2[i] = a.h(strArr.getJSONObject(i));
            i++;
            bundle.putStringArray(next, new String[i]);
            bundle.putBundle(next, a.h((JSONObject)strArr));
        }
        return bundle;
    }

    public Uri g() {
        return this.a;
    }
}
