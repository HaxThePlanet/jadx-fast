package com.amplitude.api;

import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Method;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class n {

    private static final String a = "com.amplitude.api.n";
    private static com.amplitude.api.g b;
    static {
        n.b = g.d();
    }

    static boolean a(Context context) {
        String str;
        int obj1;
        if (!n.b(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (n.b(context, "android.permission.ACCESS_FINE_LOCATION")) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    static boolean b(Context context, String string2) {
        int i;
        i = 1;
        if (Build.VERSION.SDK_INT >= 23) {
            int i2 = 0;
            final Class[] arr2 = new Class[i];
            arr2[i2] = String.class;
            Object[] arr = new Object[i];
            arr[i2] = string2;
            if (Integer.parseInt(Activity.class.getMethod("checkSelfPermission", arr2).invoke(context, arr).toString()) == 0) {
            } else {
                i = i2;
            }
            return i;
        }
        return i;
    }

    static JSONObject c(JSONObject jSONObject) {
        JSONArray names;
        com.amplitude.api.g gVar;
        int i;
        String str;
        int length;
        String optString;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.length() == 0) {
            JSONObject obj6 = new JSONObject();
            return obj6;
        }
        names = jSONObject.names();
        if (names != null) {
            length = names.length();
        } else {
            length = i;
        }
        final String[] strArr = new String[length];
        while (i < length) {
            strArr[i] = names.optString(i);
            i++;
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject, strArr);
        return jSONObject2;
    }

    public static boolean d(String string) {
        int obj0;
        if (string != null) {
            if (string.length() == 0) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    static String e(String string) {
        String obj1;
        if (n.d(string)) {
            obj1 = "$default_instance";
        }
        return obj1.toLowerCase();
    }
}
