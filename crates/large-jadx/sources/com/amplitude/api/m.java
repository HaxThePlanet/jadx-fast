package com.amplitude.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m {

    private static final String b = "com.amplitude.api.m";
    private static String[] c;
    Set<String> a;
    static {
        m.c = /* result */;
    }

    public m() {
        super();
        HashSet hashSet = new HashSet();
        this.a = hashSet;
    }

    static com.amplitude.api.m a(com.amplitude.api.m m) {
        Object next;
        m mVar = new m();
        Iterator obj2 = m.a.iterator();
        for (String next : obj2) {
            mVar.b(next);
        }
        return mVar;
    }

    private void b(String string) {
        this.a.add(string);
    }

    private boolean l(String string) {
        return obj2 ^= 1;
    }

    protected JSONObject c() {
        int i;
        Object string;
        com.amplitude.api.g contains;
        String str;
        JSONObject jSONObject = new JSONObject();
        if (this.a.isEmpty()) {
            return jSONObject;
        }
        String[] strArr = m.c;
        final int i2 = 0;
        i = i2;
        while (i < strArr.length) {
            string = strArr[i];
            if (this.a.contains(string)) {
            }
            i++;
            jSONObject.put(string, i2);
            string = string.toString();
            g.d().b(m.b, string);
        }
        return jSONObject;
    }

    boolean d() {
        return l("adid");
    }

    boolean e() {
        return l("api_level");
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object == null) {
            return i;
        }
        if (m.class != object.getClass()) {
            return i;
        }
        return object.a.equals(this.a);
    }

    boolean f() {
        return l("app_set_id");
    }

    boolean g() {
        return l("carrier");
    }

    boolean h() {
        return l("country");
    }

    boolean i() {
        return l("device_brand");
    }

    boolean j() {
        return l("device_manufacturer");
    }

    boolean k() {
        return l("device_model");
    }

    boolean m() {
        return l("language");
    }

    boolean n() {
        return l("lat_lng");
    }

    boolean o() {
        return l("os_name");
    }

    boolean p() {
        return l("os_version");
    }

    boolean q() {
        return l("platform");
    }

    boolean r() {
        return l("version_name");
    }
}
