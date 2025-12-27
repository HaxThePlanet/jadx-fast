package com.amplitude.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TrackingOptions.java */
/* loaded from: classes.dex */
public class m {

    private static final String b = "com.amplitude.api.m";
    private static String[] c;
    Set<String> a = new HashSet<>();
    static {
        m.c = new String[] { "city", "country", "dma", "ip_address", "lat_lng", "region" };
    }

    public m() {
        super();
        final HashSet hashSet = new HashSet();
    }

    static m a(m mVar) {
        final com.amplitude.api.m mVar2 = new m();
        Iterator it = mVar.a.iterator();
        while (it.hasNext()) {
            mVar2.b((String)it.next());
        }
        return mVar2;
    }

    private void b(String str) {
        this.a.add(str);
    }

    private boolean l(String str) {
        return !this.a.contains(str);
    }

    protected JSONObject c() {
        int i;
        String str;
        boolean contains;
        String obj;
        final JSONObject jSONObject = new JSONObject();
        if (this.a.isEmpty()) {
            return jSONObject;
        }
        String[] strArr = m.c;
        final boolean z = false;
        i = z;
        for (String str : strArr) {
            Throwable jSONException = jSONException.toString();
            g.d().b(m.b, jSONException);
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
            return true;
        }
        boolean z = false;
        if (object == null) {
            return false;
        }
        if (m.class != object.getClass()) {
            return false;
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
