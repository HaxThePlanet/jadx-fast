package com.iterable.iterableapi;

import android.graphics.Rect;
import d.h.k.c;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableInAppMessage.java */
/* loaded from: classes2.dex */
public class g0 {

    private final String a;
    private final g0.a b;
    private final JSONObject c;
    private final Date d;
    private final Date e;
    private final g0.f f;
    private final double g;
    private final Boolean h;
    private final g0.d i;
    private final Long j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private h0 p;
    private g0.e q;

    public static class a {

        public String a;
        public final Rect b;
        public final double c;
        public final g0.c d;
        a(String str, Rect rect, double d, boolean z, g0.c cVar) {
            super();
            this.a = str;
            this.b = rect;
            this.c = d;
            this.d = cVar;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean z2;
            String str;
            double d2;
            int cmp;
            z = true;
            if (object == this) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof g0.a)) {
                return false;
            }
            if (c.a(this.a, object.a)) {
                if (c.a(this.b, object.b)) {
                    if (this.c != object.c) {
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            Object[] arr = new Object[3];
            int i4 = 1;
            arr[i4] = this.b;
            arr[2] = Double.valueOf(this.c);
            return c.b(arr);
        }
    }

    public static class b {

        String a;
        double b;
        public b(String str, double d) {
            super();
            this.a = str;
            this.b = d;
        }
    }

    public static class c {

        boolean a;
        g0.b b;
        public c(boolean z, g0.b bVar) {
            super();
            this.a = z;
            this.b = bVar;
        }
    }

    public static class d {

        public final String a;
        public final String b;
        public final String c;
        public d(String str, String str2, String str3) {
            super();
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        static g0.d a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new g0.d(jSONObject.optString("title"), jSONObject.optString("subtitle"), jSONObject.optString("icon"));
        }

        JSONObject b() {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("title", this.a);
                jSONObject.putOpt("subtitle", this.b);
                str = "icon";
                jSONObject.putOpt(str, this.c);
            } catch (org.json.JSONException jSON) {
                j0.d("IterableInAppMessage", "Error while serializing inbox metadata", jSON);
            }
            return jSONObject;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean z2;
            String str2;
            boolean z3;
            z = true;
            if (object == this) {
                return true;
            }
            final int i = 0;
            if (!(object instanceof g0.d)) {
                return false;
            }
            if (c.a(this.a, object.a)) {
                if (c.a(this.b, object.b)) {
                    if (!(c.a(this.c, object.c))) {
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            Object[] arr = new Object[3];
            return c.b(new Object[] { this.a, this.b, this.c });
        }
    }

    interface e {
        void e(g0 g0Var);
    }

    static class f {

        final JSONObject a;
        final g0.f.a b;
        private f(JSONObject jSONObject) {
            super();
            this.a = jSONObject;
            String optString = jSONObject.optString("type");
            optString.hashCode();
            if (optString.equals("never")) {
                this.b = g0.f.a.NEVER;
            } else {
                str = "immediate";
                if (!optString.equals(str)) {
                    this.b = g0.f.a.NEVER;
                } else {
                    this.b = g0.f.a.IMMEDIATE;
                }
            }
        }

        static g0.f a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return new g0.f(g0.f.a.IMMEDIATE);
            }
            return new g0.f(jSONObject);
        }

        JSONObject b() {
            return this.a;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof g0.f)) {
                return false;
            }
            return c.a(this.a, object.a);
        }

        public int hashCode() {
            Object[] arr = new Object[1];
            return c.b(new Object[] { this.a });
        }

        f(g0.f.a aVar) {
            super();
            this.a = null;
            this.b = aVar;
        }
    }
    g0(String str, g0.a aVar, JSONObject jSONObject, Date date, Date date2, g0.f fVar, Double double, Boolean boolean, g0.d dVar, Long long) {
        super();
        this.a = str;
        this.b = aVar;
        this.c = jSONObject;
        this.d = date;
        this.e = date2;
        this.f = fVar;
        this.g = double.doubleValue();
        this.h = boolean;
        this.i = dVar;
        this.j = long;
    }

    static int a(JSONObject jSONObject) {
        int optInt = 0;
        optInt = 0;
        if (jSONObject != null) {
            str2 = "AutoExpand";
            if (str2.equalsIgnoreCase(jSONObject.optString("displayOption"))) {
                optInt = -1;
            } else {
                str = "percentage";
                optInt = jSONObject.optInt(str, 0);
            }
        }
        return optInt;
    }

    static JSONObject b(int i) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        if (i == -1) {
            str2 = "displayOption";
            str = "AutoExpand";
            jSONObject.putOpt(str2, str);
        } else {
            str = "percentage";
            jSONObject.putOpt(str, Integer.valueOf(i));
        }
        return jSONObject;
    }

    static JSONObject c(Rect rect) throws JSONException {
        final JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("top", g0.b(rect.top));
        jSONObject.putOpt("left", g0.b(rect.left));
        jSONObject.putOpt("bottom", g0.b(rect.bottom));
        jSONObject.putOpt("right", g0.b(rect.right));
        return jSONObject;
    }

    static g0 d(JSONObject jSONObject, h0 h0Var) throws JSONException {
        String optString = null;
        JSONObject optJSONObject;
        Date date2;
        Date date;
        double optDouble = 0;
        JSONObject jSONObject2 = jSONObject;
        optString = null;
        if (jSONObject2 == null) {
            return optString;
        }
        optJSONObject = jSONObject2.optJSONObject("content");
        if (optJSONObject == null) {
            return optString;
        }
        long optLong = jSONObject2.optLong("createdAt");
        long l = 0L;
        Date r8 = optLong != l ? new Date(optLong, r4) : optString;
        long optLong2 = jSONObject2.optLong("expiresAt");
        Date r9 = optLong2 != l ? new Date(optLong2, r4) : optString;
        String optString2 = optJSONObject.optString("html", optString);
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("inAppDisplaySettings");
        optDouble = 0.0d;
        boolean z = false;
        boolean optBoolean5 = optJSONObject3.optBoolean("shouldAnimate", z);
        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("bgColor");
        if (optJSONObject4 != null) {
            optString = optJSONObject4.optString("hex");
            optDouble = optJSONObject4.optDouble("alpha");
        } else {
        }
        com.iterable.iterableapi.g0.b bVar = new g0.b(optString, optDouble, obj);
        if (jSONObject2.optJSONObject("customPayload") == null) {
            optJSONObject = optJSONObject.optJSONObject("payload");
        }
        if (optJSONObject == null) {
        }
        String str4 = "saveToInbox";
        if (jSONObject2.has(str4)) {
            Boolean str = Boolean.valueOf(jSONObject2.optBoolean(str4));
        }
        g0 aVar = new g0(optString2, g0.j(optJSONObject3), optJSONObject.optDouble("backgroundAlpha", 0.0d, obj), z4, optBoolean5, cVar);
        g0 g0Var = new g0(jSONObject2.optString("messageId"), aVar, optJSONObject, date2, date, g0.f.a(jSONObject2.optJSONObject("trigger")), Double.valueOf(jSONObject2.optDouble("priorityLevel", 300.5d)), optString, dVar, z0.k(jSONObject2, "campaignId"));
        g0Var.p = h0Var;
        if (optString2 != null) {
            g0Var.w(true);
        }
        g0Var.k = jSONObject2.optBoolean("processed", z);
        g0Var.l = jSONObject2.optBoolean("consumed", z);
        g0Var.m = jSONObject2.optBoolean("read", z);
        return g0Var;
    }

    static Rect j(JSONObject jSONObject) {
        final Rect rect = new Rect();
        rect.top = g0.a(jSONObject.optJSONObject("top"));
        rect.left = g0.a(jSONObject.optJSONObject("left"));
        rect.bottom = g0.a(jSONObject.optJSONObject("bottom"));
        rect.right = g0.a(jSONObject.optJSONObject("right"));
        return rect;
    }

    private void u() {
        if (this.q != null) {
            this.q.e(this);
        }
    }

    JSONObject A() {
        JSONObject jSONObject;
        String str3;
        long time;
        final JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.putOpt("messageId", this.a);
            if (this.j != null && z0.i(this.j.longValue(), this.a)) {
                jSONObject2.put("campaignId", this.j);
            }
            if (this.d != null) {
                str3 = "createdAt";
                jSONObject2.putOpt(str3, Long.valueOf(this.d.getTime()));
            }
            if (this.e != null) {
                str3 = "expiresAt";
                jSONObject2.putOpt(str3, Long.valueOf(this.e.getTime()));
            }
            jSONObject2.putOpt("trigger", this.f.b());
            jSONObject2.putOpt("priorityLevel", Double.valueOf(this.g));
            JSONObject jSONObject5 = g0.c(this.b.b);
            jSONObject5.put("shouldAnimate", this.b.d.a);
            if (this.b.d.b != null && bVar.a != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("alpha", this.b.d.b.b);
                jSONObject7.putOpt("hex", this.b.d.b.a);
                jSONObject5.put("bgColor", jSONObject7);
            }
            jSONObject3.putOpt("backgroundAlpha", Double.valueOf(d));
            jSONObject2.putOpt("content", jSONObject3);
            jSONObject2.putOpt("customPayload", this.c);
            if (this.h != null) {
                jSONObject2.putOpt("saveToInbox", this.h);
            }
            if (this.i != null) {
                jSONObject2.putOpt("inboxMetadata", this.i.b());
            }
            jSONObject2.putOpt("processed", Boolean.valueOf(this.k));
            jSONObject2.putOpt("consumed", Boolean.valueOf(this.l));
            str = "read";
            jSONObject2.putOpt(str, Boolean.valueOf(this.m));
        } catch (org.json.JSONException jSON) {
            j0.d("IterableInAppMessage", "Error while serializing an in-app message", jSON);
        }
        return jSONObject2;
    }

    public g0.a e() {
        if (aVar.a == null) {
            this.b.a = this.p.c(this.a);
        }
        return this.b;
    }

    public Date f() {
        return this.d;
    }

    public Date g() {
        return this.e;
    }

    public g0.d h() {
        return this.i;
    }

    public String i() {
        return this.a;
    }

    public double k() {
        return this.g;
    }

    g0.f.a l() {
        return this.f.b;
    }

    boolean m() {
        return this.n;
    }

    boolean n() {
        return this.l;
    }

    public boolean o() {
        boolean booleanValue = false;
        if (this.h != null) {
            booleanValue = this.h.booleanValue();
        } else {
            int i = 0;
        }
        return booleanValue;
    }

    public boolean p() {
        return this.o;
    }

    boolean q() {
        return this.k;
    }

    public boolean r() {
        return this.m;
    }

    public boolean s() {
        boolean z2 = false;
        com.iterable.iterableapi.g0.f.a nEVER2;
        if (o()) {
            int r0 = l() == g0.f.a.NEVER ? 1 : 0;
        }
        return (l() == g0.f.a.NEVER ? 1 : 0);
    }

    public void t(boolean z) {
        this.o = z;
    }

    void v(boolean z) {
        this.l = z;
        u();
    }

    void w(boolean z) {
        this.n = z;
    }

    void x(g0.e eVar) {
        this.q = eVar;
    }

    void y(boolean z) {
        this.k = z;
        u();
    }

    void z(boolean z) {
        this.m = z;
        u();
    }
}
