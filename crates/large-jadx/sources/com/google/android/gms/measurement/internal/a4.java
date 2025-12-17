package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a4 {

    private final String a;
    private final Bundle b;
    private Bundle c;
    final com.google.android.gms.measurement.internal.g4 d;
    public a4(com.google.android.gms.measurement.internal.g4 g4, String string2, Bundle bundle3) {
        this.d = g4;
        super();
        String obj1 = "default_event_parameters";
        r.f(obj1);
        this.a = obj1;
        obj1 = new Bundle();
        this.b = obj1;
    }

    public final Bundle a() {
        Bundle bundle2;
        String string;
        Object bundle;
        int jSONArray;
        int i2;
        com.google.android.gms.measurement.internal.g4 length;
        String string3;
        String string2;
        int i3;
        boolean equals;
        String str;
        int i4;
        int i5;
        int i;
        if (this.c != null) {
        } else {
            string = this.d.o().getString(this.a, 0);
            if (string != null) {
                bundle = new Bundle();
                jSONArray = new JSONArray(string);
                string = 0;
                i2 = string;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    string3 = jSONObject.getString("n");
                    string2 = jSONObject.getString("t");
                    equals = string2.hashCode();
                    i5 = 2;
                    i = 1;
                    if (equals != 100) {
                    } else {
                    }
                    if (string2.equals("d")) {
                    } else {
                    }
                    i3 = -1;
                    str = "v";
                    if (i3 != 0) {
                    } else {
                    }
                    bundle.putString(string3, jSONObject.getString(str));
                    i2++;
                    if (i3 != i) {
                    } else {
                    }
                    bundle.putDouble(string3, Double.parseDouble(jSONObject.getString(str)));
                    if (i3 != i5) {
                    } else {
                    }
                    bundle.putLong(string3, Long.parseLong(jSONObject.getString(str)));
                    g4Var3.a.b().r().b("Unrecognized persisted bundle type. Type", string2);
                    i3 = i;
                    if (equals != 108) {
                    } else {
                    }
                    if (string2.equals("l")) {
                    } else {
                    }
                    i3 = i5;
                    if (equals != 115) {
                    } else {
                    }
                    if (string2.equals("s")) {
                    } else {
                    }
                    i3 = string;
                    length = this.d;
                    length = length.a;
                    length = length.b();
                    length = length.r();
                    length.a("Error reading value from SharedPreferences. Value dropped");
                }
                this.c = bundle;
            }
            if (this.c == null) {
                this.c = this.b;
            }
        }
        return this.c;
    }

    public final void b(Bundle bundle) {
        String str2;
        String string;
        Iterator iterator;
        Throwable next;
        Object class;
        Object jSONObject;
        String str;
        Bundle obj9;
        if (bundle == null) {
            obj9 = new Bundle();
        }
        SharedPreferences.Editor edit = this.d.o().edit();
        if (obj9.size() == 0) {
            edit.remove(this.a);
        } else {
            JSONArray jSONArray = new JSONArray();
            iterator = obj9.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                class = obj9.get((String)next);
                if (class != null) {
                }
                jSONObject = new JSONObject();
                jSONObject.put("n", next);
                jSONObject.put("v", class.toString());
                str = "t";
                if (class instanceof String != null) {
                } else {
                }
                if (class instanceof Long) {
                } else {
                }
                if (class instanceof Double) {
                } else {
                }
                g4Var2.a.b().r().b("Cannot serialize bundle value to SharedPreferences. Type", class.getClass());
                jSONObject.put(str, "d");
                jSONArray.put(jSONObject);
                jSONObject.put(str, "l");
                jSONObject.put(str, "s");
            }
            edit.putString(this.a, jSONArray.toString());
        }
        edit.apply();
        this.c = obj9;
    }
}
