package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.l.a;
import com.google.android.gms.common.util.c;
import com.google.android.gms.internal.firebase-auth-api.s1;
import com.google.android.gms.internal.firebase-auth-api.zzll;
import d.e.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class zzaz {

    private static final a zza;
    static {
        a aVar = new a("JSONParser", new String[0]);
        zzaz.zza = aVar;
    }

    static List<Object> zza(JSONArray jSONArray) {
        int i;
        List list;
        boolean z;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < jSONArray.length()) {
            list = jSONArray.get(i);
            if (list instanceof JSONArray != null) {
            } else {
            }
            if (list instanceof JSONObject != null) {
            }
            arrayList.add(list);
            i++;
            list = zzaz.zzd((JSONObject)list);
            list = zzaz.zza((JSONArray)list);
        }
        return arrayList;
    }

    public static Map<String, Object> zzb(String string) {
        Object obj4;
        r.f(string);
        List list = s1.b('.').d(string);
        if (list.size() < 2) {
            obj4 = String.valueOf(string);
            String str2 = "Invalid idToken ";
            if (obj4.length() != 0) {
                obj4 = str2.concat(obj4);
            } else {
                obj4 = new String(str2);
            }
            zzaz.zza.c(obj4, new Object[0]);
            obj4 = new HashMap();
            return obj4;
        }
        String string2 = new String(c.b((String)list.get(1)), "UTF-8");
        if (zzaz.zzc(string2) == null) {
            obj4 = new HashMap();
        }
        return obj4;
    }

    public static Map<String, Object> zzc(String string) {
        final int i = 0;
        if (TextUtils.isEmpty(string)) {
            return i;
        }
        JSONObject jSONObject = new JSONObject(string);
        if (jSONObject != JSONObject.NULL) {
            return zzaz.zzd(jSONObject);
        }
        return i;
    }

    static Map<String, Object> zzd(JSONObject jSONObject) {
        Object next;
        List list;
        boolean z;
        a aVar = new a();
        final Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            next = keys.next();
            list = jSONObject.get((String)next);
            if (list instanceof JSONArray != null) {
            } else {
            }
            if (list instanceof JSONObject != null) {
            }
            aVar.put(next, list);
            list = zzaz.zzd((JSONObject)list);
            list = zzaz.zza((JSONArray)list);
        }
        return aVar;
    }
}
