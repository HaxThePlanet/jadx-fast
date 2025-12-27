package com.amplitude.api;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* loaded from: classes.dex */
public class n {

    private static final String a = "com.amplitude.api.n";
    private static g b;
    static {
        n.b = g.d();
    }

    static boolean a(Context context) {
        boolean z;
        boolean z3 = false;
        if (!n.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            str = "android.permission.ACCESS_FINE_LOCATION";
            if (n.b(context, str)) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z3;
    }

    static boolean b(Context context, String str) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException {
        int i = 1;
        i = 1;
        if (Build.VERSION.SDK_INT >= 23) {
            i = 0;
            try {
                final Class[] arr2 = new Class[i];
                arr2[i] = String.class;
                Object[] arr = new Object[i];
                arr[i] = str;
            } catch (Exception unused) {
                return z;
            }
            if (Integer.parseInt(Activity.class.getMethod("checkSelfPermission", arr2).invoke(context, arr).toString()) != 0) {
            }
        }
        return true;
    }

    static JSONObject c(JSONObject jSONObject) {
        JSONArray names;
        int length = 0;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.length() == 0) {
            return new JSONObject();
        }
        try {
            names = jSONObject.names();
        } catch (org.json.JSONException jSON) {
            Throwable th = n.b;
            com.amplitude.api.g gVar = n.a;
            jSON = jSON.toString();
            th.b(gVar, jSON);
            return th;
        }
        length = 0;
        if (names != null) {
            length = names.length();
        } else {
        }
        final String[] strArr = new String[length];
        while (length < length) {
            strArr[length] = names.optString(length);
            length = length + 1;
        }
        try {
        } catch (org.json.JSONException jSON) {
            th = n.b;
            gVar = n.a;
            jSON = jSON.toString();
            th.b(gVar, jSON);
            return th;
        }
        return new JSONObject(jSON, strArr);
    }

    public static boolean d(String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            int i2 = 1;
        }
        return z;
    }

    static String e(String str) {
        String str2;
        if (n.d(str)) {
            str2 = "$default_instance";
        }
        return str2.toLowerCase();
    }
}
