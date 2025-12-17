package com.iterable.iterableapi;

import android.graphics.Rect;
import d.h.k.c;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g0 {

    private final String a;
    private final com.iterable.iterableapi.g0.a b;
    private final JSONObject c;
    private final Date d;
    private final Date e;
    private final com.iterable.iterableapi.g0.f f;
    private final double g;
    private final Boolean h;
    private final com.iterable.iterableapi.g0.d i;
    private final Long j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private com.iterable.iterableapi.h0 p;
    private com.iterable.iterableapi.g0.e q;

    public static class a {

        public String a;
        public final Rect b;
        public final double c;
        public final com.iterable.iterableapi.g0.c d;
        a(String string, Rect rect2, double d3, boolean z4, com.iterable.iterableapi.g0.c g0$c5) {
            super();
            this.a = string;
            this.b = rect2;
            this.c = d3;
            this.d = obj6;
        }

        public boolean equals(Object object) {
            int i;
            boolean z;
            double str;
            double d;
            int obj8;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof g0.a) {
                return i2;
            }
            if (c.a(this.a, object.a) && c.a(this.b, object.b) && Double.compare(str, d) == 0) {
                if (c.a(this.b, object.b)) {
                    if (Double.compare(str, d) == 0) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
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
        public b(String string, double d2) {
            super();
            this.a = string;
            this.b = d2;
        }
    }

    public static class c {

        boolean a;
        com.iterable.iterableapi.g0.b b;
        public c(boolean z, com.iterable.iterableapi.g0.b g0$b2) {
            super();
            this.a = z;
            this.b = b2;
        }
    }

    public static class d {

        public final String a;
        public final String b;
        public final String c;
        public d(String string, String string2, String string3) {
            super();
            this.a = string;
            this.b = string2;
            this.c = string3;
        }

        static com.iterable.iterableapi.g0.d a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            g0.d dVar = new g0.d(jSONObject.optString("title"), jSONObject.optString("subtitle"), jSONObject.optString("icon"));
            return dVar;
        }

        JSONObject b() {
            String str3;
            String str2;
            String str;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("title", this.a);
            jSONObject.putOpt("subtitle", this.b);
            jSONObject.putOpt("icon", this.c);
            return jSONObject;
        }

        public boolean equals(Object object) {
            int i;
            String z;
            String str;
            boolean obj5;
            if (object == this) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof g0.d) {
                return i2;
            }
            if (c.a(this.a, object.a) && c.a(this.b, object.b) && c.a(this.c, object.c)) {
                if (c.a(this.b, object.b)) {
                    if (c.a(this.c, object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            Object[] arr = new Object[3];
            return c.b(this.a, this.b, this.c);
        }
    }

    interface e {
        public abstract void e(com.iterable.iterableapi.g0 g0);
    }

    static class f {

        final JSONObject a;
        final com.iterable.iterableapi.g0.f.a b;
        f(com.iterable.iterableapi.g0.f.a g0$f$a) {
            super();
            this.a = 0;
            this.b = a;
        }

        private f(JSONObject jSONObject) {
            String equals;
            com.iterable.iterableapi.g0.f.a obj2;
            super();
            this.a = jSONObject;
            obj2 = jSONObject.optString("type");
            obj2.hashCode();
            if (!obj2.equals("never")) {
                if (!obj2.equals("immediate")) {
                    this.b = g0.f.a.NEVER;
                } else {
                    this.b = g0.f.a.IMMEDIATE;
                }
            } else {
                this.b = g0.f.a.NEVER;
            }
        }

        static com.iterable.iterableapi.g0.f a(JSONObject jSONObject) {
            if (jSONObject == null) {
                g0.f obj1 = new g0.f(g0.f.a.IMMEDIATE);
                return obj1;
            }
            g0.f fVar = new g0.f(jSONObject);
            return fVar;
        }

        JSONObject b() {
            return this.a;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return 1;
            }
            if (!object instanceof g0.f) {
                return 0;
            }
            return c.a(this.a, object.a);
        }

        public int hashCode() {
            Object[] arr = new Object[1];
            return c.b(this.a);
        }
    }
    g0(String string, com.iterable.iterableapi.g0.a g0$a2, JSONObject jSONObject3, Date date4, Date date5, com.iterable.iterableapi.g0.f g0$f6, Double double7, Boolean boolean8, com.iterable.iterableapi.g0.d g0$d9, Long long10) {
        super();
        final int i = 0;
        this.a = string;
        this.b = a2;
        this.c = jSONObject3;
        this.d = date4;
        this.e = date5;
        this.f = f6;
        this.g = double7.doubleValue();
        this.h = boolean8;
        this.i = d9;
        this.j = long10;
    }

    static int a(JSONObject jSONObject) {
        int optInt;
        String equalsIgnoreCase;
        String str;
        if (jSONObject != null) {
            if ("AutoExpand".equalsIgnoreCase(jSONObject.optString("displayOption"))) {
                optInt = -1;
            } else {
                optInt = jSONObject.optInt("percentage", 0);
            }
        }
        return optInt;
    }

    static JSONObject b(int i) {
        String str;
        Object obj2;
        JSONObject jSONObject = new JSONObject();
        if (i == -1) {
            jSONObject.putOpt("displayOption", "AutoExpand");
        } else {
            jSONObject.putOpt("percentage", Integer.valueOf(i));
        }
        return jSONObject;
    }

    static JSONObject c(Rect rect) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("top", g0.b(rect.top));
        jSONObject.putOpt("left", g0.b(rect.left));
        jSONObject.putOpt("bottom", g0.b(rect.bottom));
        jSONObject.putOpt("right", g0.b(rect.right));
        return jSONObject;
    }

    static com.iterable.iterableapi.g0 d(JSONObject jSONObject, com.iterable.iterableapi.h0 h02) {
        int valueOf;
        JSONObject optJSONObject;
        com.iterable.iterableapi.h0 h0Var;
        int date2;
        String optString;
        JSONObject optJSONObject2;
        int date;
        int i;
        double optDouble;
        JSONObject jSONObject2 = jSONObject;
        valueOf = 0;
        if (jSONObject2 == null) {
            return valueOf;
        }
        optJSONObject = jSONObject2.optJSONObject("content");
        if (optJSONObject == null) {
            return valueOf;
        }
        long optLong = jSONObject2.optLong("createdAt");
        int i3 = 0;
        if (Long.compare(optLong, i3) != 0) {
            date = new Date(optLong, obj4);
        } else {
            date = valueOf;
        }
        long optLong2 = jSONObject2.optLong("expiresAt");
        if (Long.compare(optLong2, i3) != 0) {
            date2 = new Date(optLong2, obj4);
            i = date2;
        } else {
            i = valueOf;
        }
        String optString2 = optJSONObject.optString("html", valueOf);
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("inAppDisplaySettings");
        int i5 = 0;
        boolean optBoolean5 = optJSONObject4.optBoolean("shouldAnimate", i5);
        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("bgColor");
        if (optJSONObject5 != null) {
            optString = optJSONObject5.optString("hex");
            optDouble = optJSONObject5.optDouble("alpha");
        } else {
            optString = valueOf;
        }
        g0.b bVar = new g0.b(optString, optDouble, obj11);
        g0.c cVar = new g0.c(optBoolean5, bVar);
        if (jSONObject2.optJSONObject("customPayload") == null) {
            optJSONObject2 = optJSONObject.optJSONObject("payload");
        }
        if (optJSONObject2 == null) {
            optJSONObject = new JSONObject();
            optJSONObject2 = optJSONObject;
        }
        String str3 = "saveToInbox";
        if (jSONObject2.has(str3)) {
            valueOf = Boolean.valueOf(jSONObject2.optBoolean(str3));
        }
        g0 aVar2 = new g0(optString2, g0.j(optJSONObject4), optJSONObject.optDouble("backgroundAlpha", 0), obj19, optBoolean5, cVar);
        com.iterable.iterableapi.g0 g0Var = g0Var3;
        int i2 = i5;
        super(jSONObject2.optString("messageId"), aVar3, optJSONObject2, date, i, g0.f.a(jSONObject2.optJSONObject("trigger")), Double.valueOf(jSONObject2.optDouble("priorityLevel", 4643994068097957888L)), valueOf, g0.d.a(jSONObject2.optJSONObject("inboxMetadata")), z0.k(jSONObject2, "campaignId"));
        g0Var.p = h02;
        if (optString2 != null) {
            g0Var.w(true);
        }
        g0Var.k = jSONObject2.optBoolean("processed", i2);
        g0Var.l = jSONObject2.optBoolean("consumed", i2);
        g0Var.m = jSONObject2.optBoolean("read", i2);
        return g0Var;
    }

    static Rect j(JSONObject jSONObject) {
        Rect rect = new Rect();
        rect.top = g0.a(jSONObject.optJSONObject("top"));
        rect.left = g0.a(jSONObject.optJSONObject("left"));
        rect.bottom = g0.a(jSONObject.optJSONObject("bottom"));
        rect.right = g0.a(jSONObject.optJSONObject("right"));
        return rect;
    }

    private void u() {
        final com.iterable.iterableapi.g0.e eVar = this.q;
        if (eVar != null) {
            eVar.e(this);
        }
    }

    JSONObject A() {
        Object dVar;
        String str4;
        Long str5;
        Object valueOf4;
        Object valueOf;
        double valueOf3;
        Object str6;
        Boolean valueOf2;
        Object str2;
        Object jSONObject;
        String str3;
        long time;
        boolean str;
        int cmp;
        long l;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        str2 = this.a;
        jSONObject2.putOpt("messageId", str2);
        str5 = this.j;
        if (str5 != null && z0.i(str5.longValue())) {
            if (z0.i(str5.longValue())) {
                jSONObject2.put("campaignId", this.j);
            }
        }
        valueOf4 = this.d;
        if (valueOf4 != null) {
            jSONObject2.putOpt("createdAt", Long.valueOf(valueOf4.getTime()));
        }
        valueOf = this.e;
        if (valueOf != null) {
            jSONObject2.putOpt("expiresAt", Long.valueOf(valueOf.getTime()));
        }
        jSONObject2.putOpt("trigger", this.f.b());
        jSONObject2.putOpt("priorityLevel", Double.valueOf(this.g));
        JSONObject jSONObject4 = g0.c(aVar.b);
        jSONObject4.put("shouldAnimate", cVar2.a);
        jSONObject = cVar.b;
        if (jSONObject != null && jSONObject.a != null) {
            if (jSONObject.a != null) {
                jSONObject = new JSONObject();
                jSONObject.put("alpha", bVar.b);
                jSONObject.putOpt("hex", bVar2.a);
                jSONObject4.put("bgColor", jSONObject);
            }
        }
        try {
            str3 = "inAppDisplaySettings";
            jSONObject3.putOpt(str3, jSONObject4);
            valueOf3 = aVar2.c;
            if (Double.compare(valueOf3, i) != 0) {
            }
            jSONObject3.putOpt("backgroundAlpha", Double.valueOf(valueOf3));
            jSONObject2.putOpt("content", jSONObject3);
            jSONObject2.putOpt("customPayload", this.c);
            Boolean bool = this.h;
            if (bool != null) {
            }
            jSONObject2.putOpt("saveToInbox", bool);
            dVar = this.i;
            if (dVar != null) {
            }
            jSONObject2.putOpt("inboxMetadata", dVar.b());
            jSONObject2.putOpt("processed", Boolean.valueOf(this.k));
            jSONObject2.putOpt("consumed", Boolean.valueOf(this.l));
            jSONObject2.putOpt("read", Boolean.valueOf(this.m));
            j0.d("IterableInAppMessage", "Error while serializing an in-app message", th);
            return jSONObject2;
        }
    }

    public com.iterable.iterableapi.g0.a e() {
        String str;
        String str2;
        com.iterable.iterableapi.g0.a aVar = this.b;
        if (aVar.a == null) {
            aVar.a = this.p.c(this.a);
        }
        return this.b;
    }

    public Date f() {
        return this.d;
    }

    public Date g() {
        return this.e;
    }

    public com.iterable.iterableapi.g0.d h() {
        return this.i;
    }

    public String i() {
        return this.a;
    }

    public double k() {
        return this.g;
    }

    com.iterable.iterableapi.g0.f.a l() {
        return fVar.b;
    }

    boolean m() {
        return this.n;
    }

    boolean n() {
        return this.l;
    }

    public boolean o() {
        boolean booleanValue;
        Boolean bool = this.h;
        if (bool != null) {
            booleanValue = bool.booleanValue();
        } else {
            booleanValue = 0;
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
        boolean z;
        int i;
        com.iterable.iterableapi.g0.f.a nEVER;
        if (o() && l() == g0.f.a.NEVER) {
            i = l() == g0.f.a.NEVER ? 1 : 0;
        } else {
        }
        return i;
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

    void x(com.iterable.iterableapi.g0.e g0$e) {
        this.q = e;
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
