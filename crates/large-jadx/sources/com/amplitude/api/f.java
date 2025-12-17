package com.amplitude.api;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory.Options;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.util.Pair;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import f.a.a.a;
import f.a.b.a;
import f.a.b.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.FormBody.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    private static final String U = "com.amplitude.api.f";
    private static final com.amplitude.api.g V;
    private int A;
    private int B;
    private long C;
    private long D;
    private long E;
    private boolean F;
    private int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private String L;
    private String M;
    private boolean N;
    private AtomicBoolean O;
    AtomicBoolean P;
    String Q;
    String R;
    com.amplitude.api.o S;
    com.amplitude.api.o T;
    protected Context a;
    protected Call.Factory b;
    protected com.amplitude.api.i c;
    protected String d;
    protected String e;
    protected String f;
    protected String g;
    private boolean h;
    private boolean i;
    private boolean j;
    protected boolean k;
    private boolean l;
    private boolean m;
    com.amplitude.api.m n;
    com.amplitude.api.m o;
    JSONObject p;
    private boolean q;
    protected String r;
    long s;
    long t;
    long u;
    long v;
    long w;
    long x;
    protected com.amplitude.api.k y;
    private int z;

    class a implements Runnable {

        final com.amplitude.api.f a;
        a(com.amplitude.api.f f) {
            this.a = f;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            f.l(this.a).set(false);
            this.a.j0();
        }
    }

    class b implements Runnable {

        final String a;
        final long b;
        final long c;
        final com.amplitude.api.f v;
        b(com.amplitude.api.f f, String string2, long l3, long l4) {
            this.v = f;
            this.a = string2;
            this.b = l3;
            this.c = obj5;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            final com.amplitude.api.f fVar = this.v;
            fVar.N(fVar.b, this.a, this.b, obj4);
        }
    }

    class c implements Runnable {

        final long a;
        final long b;
        final com.amplitude.api.f c;
        c(com.amplitude.api.f f, long l2, long l3) {
            this.c = f;
            this.a = l2;
            this.b = obj4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            int aVar;
            int cmp;
            int cmp2;
            long l = this.a;
            int i3 = 0;
            if (Long.compare(l, i3) >= 0) {
                fVar7.c.v0(l);
            }
            long l2 = this.b;
            if (Long.compare(l2, i3) >= 0) {
                fVar6.c.C0(l2);
            }
            int i2 = 0;
            fVar.P.set(i2);
            if (Long.compare(l3, l4) > 0) {
                aVar = new f.c.a(this);
                fVar5.S.a(aVar);
            } else {
                f.c(this.c, i2);
                obj = this.c;
                f.e(obj, f.f(obj));
            }
        }
    }

    class d implements Runnable {

        final com.amplitude.api.f a;
        d(com.amplitude.api.f f) {
            this.a = f;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            fVar.P.set(false);
            this.a.k0(true);
        }
    }

    class g implements Runnable {

        final com.amplitude.api.f A;
        final String a;
        final JSONObject b;
        final JSONObject c;
        final JSONObject v;
        final JSONObject w;
        final JSONObject x;
        final long y;
        final boolean z;
        g(com.amplitude.api.f f, String string2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, JSONObject jSONObject7, long l8, boolean z9) {
            this.A = f;
            this.a = string2;
            this.b = jSONObject3;
            this.c = jSONObject4;
            this.v = jSONObject5;
            this.w = jSONObject6;
            this.x = jSONObject7;
            this.y = l8;
            this.z = obj10;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.d(fVar.d)) {
            }
            this.A.H(this.a, this.b, this.c, this.v, this.w, this.x, this.y, obj9);
        }
    }

    class h implements Runnable {

        final long a;
        final com.amplitude.api.f b;
        h(com.amplitude.api.f f, long l2) {
            this.b = f;
            this.a = l2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int i;
            if (n.d(fVar.d)) {
            }
            this.b.R(this.a);
            f.d(this.b, false);
            if (f.g(this.b)) {
                this.b.j0();
            }
            com.amplitude.api.f fVar5 = this.b;
            fVar5.c.e0("device_id", fVar5.g);
            com.amplitude.api.f fVar6 = this.b;
            fVar6.c.e0("user_id", fVar6.f);
            com.amplitude.api.f fVar7 = this.b;
            i = f.a(fVar7) ? 1 : 0;
            fVar7.c.Y("opt_out", Long.valueOf(i));
            com.amplitude.api.f fVar8 = this.b;
            fVar8.c.Y("previous_session_id", Long.valueOf(fVar8.s));
            com.amplitude.api.f fVar9 = this.b;
            fVar9.c.Y("last_event_time", Long.valueOf(fVar9.w));
        }
    }

    class i implements Runnable {

        final long a;
        final com.amplitude.api.f b;
        i(com.amplitude.api.f f, long l2) {
            this.b = f;
            this.a = l2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            com.amplitude.api.f.i.a aVar;
            if (n.d(fVar.d)) {
            }
            if (f.h(this.b)) {
                aVar = new f.i.a(this);
                h.b().c(aVar);
            }
            this.b.f0(this.a);
            f.d(this.b, true);
        }
    }

    class j implements Runnable {

        final com.amplitude.api.f a;
        final boolean b;
        final String c;
        final com.amplitude.api.f v;
        j(com.amplitude.api.f f, com.amplitude.api.f f2, boolean z3, String string4) {
            this.v = f;
            this.a = f2;
            this.b = z3;
            this.c = string4;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            String str;
            String str3;
            Object str2;
            if (n.d(fVar.d)) {
            }
            if (this.b && f.i(this.v)) {
                if (f.i(this.v)) {
                    f.j(this.v, "session_end");
                }
            }
            str3 = this.c;
            fVar3.f = str3;
            fVar4.c.e0("user_id", str3);
            long l = this.v.q();
            f.k(this.v, l);
            this.v.R(l);
            if (this.b && f.i(this.v)) {
                l = this.v.q();
                f.k(this.v, l);
                this.v.R(l);
                if (f.i(this.v)) {
                    f.j(this.v, "session_start");
                }
            }
        }
    }

    class e implements com.amplitude.api.h.a {

        final com.amplitude.api.f a;
        e(com.amplitude.api.f f) {
            this.a = f;
            super();
        }

        @Override // com.amplitude.api.h$a
        public void a() {
            fVar.Q = h.b().a();
        }
    }

    class f implements com.amplitude.api.j {

        final com.amplitude.api.f a;
        final com.amplitude.api.f b;
        f(com.amplitude.api.f f, com.amplitude.api.f f2) {
            this.b = f;
            this.a = f2;
            super();
        }

        @Override // com.amplitude.api.j
        public void a(SQLiteDatabase sQLiteDatabase) {
            int i;
            String str3 = "store";
            fVar.c.g0(sQLiteDatabase, str3, "device_id", fVar6.g);
            fVar2.c.g0(sQLiteDatabase, str3, "user_id", fVar7.f);
            i = f.a(this.a) ? 1 : 0;
            String str4 = "long_store";
            fVar3.c.g0(sQLiteDatabase, str4, "opt_out", Long.valueOf(i));
            fVar4.c.g0(sQLiteDatabase, str4, "previous_session_id", Long.valueOf(fVar9.s));
            fVar5.c.g0(sQLiteDatabase, str4, "last_event_time", Long.valueOf(fVar10.w));
        }
    }
    static {
        f.V = g.d();
    }

    public f() {
        super(0);
    }

    public f(String string) {
        super();
        int i = 0;
        this.h = i;
        this.i = i;
        this.j = i;
        this.k = i;
        this.l = i;
        this.m = i;
        m mVar = new m();
        this.n = mVar;
        com.amplitude.api.m mVar2 = m.a(mVar);
        this.o = mVar2;
        this.p = mVar2.c();
        int i3 = 1;
        this.q = i3;
        int i4 = -1;
        this.s = i4;
        this.t = 0;
        this.u = i4;
        this.v = i4;
        this.w = i4;
        this.x = i4;
        this.z = 30;
        int i6 = 50;
        this.A = i6;
        this.B = 1000;
        this.C = 30000;
        this.D = 300000;
        this.E = 1800000;
        this.F = i;
        this.G = i6;
        this.H = i;
        this.I = i;
        this.J = i;
        this.K = i3;
        this.L = "amplitude-android";
        this.M = "2.32.1";
        this.N = i;
        AtomicBoolean atomicBoolean = new AtomicBoolean(i);
        this.O = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(i);
        this.P = atomicBoolean2;
        this.Q = "https://api2.amplitude.com/";
        this.R = 0;
        o oVar = new o("logThread");
        this.S = oVar;
        o oVar2 = new o("httpThread");
        this.T = oVar2;
        this.e = n.e(string);
        this.S.start();
        this.T.start();
    }

    private String A() {
        Set contains;
        boolean z;
        boolean z2;
        boolean endsWith;
        contains = r();
        String str = this.c.L("device_id");
        final String str5 = "S";
        if (!n.d(str) && !contains.contains(str) && !str.endsWith(str5)) {
            if (!contains.contains(str)) {
                if (!str.endsWith(str5)) {
                    return str;
                }
            }
        }
        z = this.y.d();
        if (!this.h && this.i && !this.y.s() && !n.d(z) && !contains.contains(z)) {
            if (this.i) {
                if (!this.y.s()) {
                    z = this.y.d();
                    if (!n.d(z)) {
                        if (!contains.contains(z)) {
                            U(z);
                            return z;
                        }
                    }
                }
            }
        }
        z2 = this.y.e();
        if (this.j && !n.d(z2) && !contains.contains(z2)) {
            z2 = this.y.e();
            if (!n.d(z2)) {
                if (!contains.contains(z2)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(z2);
                    stringBuilder.append(str5);
                    String string = stringBuilder.toString();
                    U(string);
                    return string;
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(k.c());
        stringBuilder2.append("R");
        String string2 = stringBuilder2.toString();
        U(string2);
        return string2;
    }

    private boolean D(long l) {
        long l2;
        int obj5;
        l2 = this.H ? this.D : this.E;
        obj5 = Long.compare(obj5, l2) < 0 ? 1 : 0;
        return obj5;
    }

    private void E(Call.Factory call$Factory, String string2, com.amplitude.api.f f3) {
        boolean z;
        int arr;
        String eVar;
        int i;
        int cmp;
        Object obj8;
        Object obj9;
        if (!this.k) {
            arr = 1;
            if (factory == null) {
                eVar = new b(a.a(c.a));
                this.b = eVar;
            } else {
                this.b = factory;
            }
            if (this.N) {
                eVar = new f.e(this);
                h.b().c(eVar);
            }
            this.y = B();
            this.g = A();
            this.y.u();
            obj8 = "user_id";
            if (string2 != null) {
                f3.f = string2;
                this.c.e0(obj8, string2);
            } else {
                try {
                    f3.f = this.c.L(obj8);
                    obj8 = this.c.E("opt_out");
                    if (obj8 != null && Long.compare(obj8, eVar) == 0) {
                    } else {
                    }
                    if (Long.compare(obj8, eVar) == 0) {
                    } else {
                    }
                    obj8 = arr;
                    obj8 = z;
                    this.l = obj8;
                    eVar = -1;
                    obj8 = s("previous_session_id", eVar);
                    this.x = obj8;
                    i = 0;
                    if (Long.compare(obj8, i) >= 0) {
                    }
                    this.s = obj8;
                    this.t = s("sequence_number", i);
                    this.u = s("last_event_id", eVar);
                    this.v = s("last_identify_id", eVar);
                    this.w = s("last_event_time", eVar);
                    obj9 = new f.f(this, f3);
                    this.c.I0(obj9);
                    this.k = arr;
                    string2 = f.V;
                    arr = new Object[arr];
                    factory = factory.getMessage();
                    arr[obj0] = factory;
                    factory = "Failed to initialize Amplitude SDK due to: %s";
                    factory = String.format(factory, arr);
                    string2.b(f.U, factory);
                    factory = null;
                    f3.d = factory;
                }
            }
        }
    }

    static Call G(b b, Request request2) {
        return (Call.Factory)b.get().newCall(request2);
    }

    private void U(String string) {
        this.c.e0("device_id", string);
    }

    private void W(String string) {
        Object[] arr = new Object[1];
        if (!o(String.format("sendSessionEvent('%s')", string))) {
        }
        if (!w()) {
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("special", string);
        this.H(string, 0, jSONObject, 0, 0, 0, this.w, obj9);
    }

    static boolean a(com.amplitude.api.f f) {
        return f.l;
    }

    static boolean b(com.amplitude.api.f f) {
        return f.F;
    }

    private void b0(long l) {
        this.s = l;
        a0(l);
    }

    static boolean c(com.amplitude.api.f f, boolean z2) {
        f.F = z2;
        return z2;
    }

    static boolean d(com.amplitude.api.f f, boolean z2) {
        f.J = z2;
        return z2;
    }

    static int e(com.amplitude.api.f f, int i2) {
        f.G = i2;
        return i2;
    }

    private void e0(long l) {
        boolean str;
        boolean obj2;
        if (this.I) {
            W("session_end");
        }
        b0(l);
        R(l);
        if (this.I) {
            W("session_start");
        }
    }

    static int f(com.amplitude.api.f f) {
        return f.A;
    }

    static boolean g(com.amplitude.api.f f) {
        return f.K;
    }

    public static String g0(String string) {
        int length;
        String obj2;
        final int i = 1024;
        if (string.length() <= i) {
        } else {
            obj2 = string.substring(0, i);
        }
        return obj2;
    }

    static boolean h(com.amplitude.api.f f) {
        return f.N;
    }

    static boolean i(com.amplitude.api.f f) {
        return f.I;
    }

    static void j(com.amplitude.api.f f, String string2) {
        f.W(string2);
    }

    static void k(com.amplitude.api.f f, long l2) {
        f.b0(l2);
    }

    static AtomicBoolean l(com.amplitude.api.f f) {
        return f.O;
    }

    private void l0(long l) {
        if (this.O.getAndSet(true)) {
        }
        f.a aVar = new f.a(this);
        this.S.b(aVar, l);
    }

    static int m(com.amplitude.api.f f) {
        return f.z;
    }

    private Set<String> r() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    private long s(String string, long l2) {
        long obj3;
        final Long obj2 = this.c.E(string);
        if (obj2 == null) {
        } else {
            obj3 = obj2.longValue();
        }
        return obj3;
    }

    private boolean w() {
        int i;
        i = Long.compare(l, i2) >= 0 ? 1 : 0;
        return i;
    }

    protected com.amplitude.api.k B() {
        k kVar = new k(this.a, this.q);
        return kVar;
    }

    public com.amplitude.api.f C(Context context, String string2, String string3, String string4, boolean z5, Call.Factory call$Factory6) {
        String obj4;
        synchronized (this) {
            f.V.b(f.U, "Argument context cannot be null in initialize()");
            return this;
        }
    }

    public void F(Call.Factory call$Factory, String string2, com.amplitude.api.f f3) {
        E(factory, string2, f3);
    }

    protected long H(String string, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, long l7, boolean z8) {
        JSONObject jSONObject8;
        String str4;
        String str12;
        JSONObject jSONObject13;
        JSONObject jSONObject12;
        JSONObject jSONObject10;
        JSONObject jSONObject11;
        JSONObject jSONObject7;
        boolean str17;
        boolean str18;
        boolean str11;
        boolean str20;
        boolean str19;
        boolean str3;
        boolean str2;
        boolean str13;
        boolean str14;
        boolean str;
        boolean str6;
        JSONObject jSONObject9;
        String str10;
        Object string2;
        JSONObject length;
        boolean str5;
        boolean str9;
        boolean str8;
        boolean equals;
        int i;
        int str7;
        long l2;
        String longitude;
        long l;
        String str16;
        String jSONObject;
        Object str15;
        final Object obj = this;
        str12 = string;
        JSONObject jSONObject14 = jSONObject2;
        JSONObject jSONObject15 = jSONObject4;
        jSONObject11 = jSONObject5;
        jSONObject7 = jSONObject6;
        long l3 = l7;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Logged event to Amplitude: ");
        stringBuilder.append(str12);
        String string3 = stringBuilder.toString();
        f.V.a(f.U, string3);
        str7 = -1;
        if (obj.l) {
            return str7;
        }
        if (obj.I) {
            if (!str12.equals("session_start")) {
                i = str12.equals("session_end") ? 1 : 0;
            } else {
            }
        } else {
        }
        if (i == 0 && obj24 == null) {
            if (obj24 == null) {
                if (!obj.J) {
                    f0(l3);
                } else {
                    R(l3);
                }
            }
        }
        JSONObject jSONObject17 = new JSONObject();
        str15 = S(string);
        jSONObject17.put("event_type", str15);
        jSONObject17.put("timestamp", l3);
        jSONObject17.put("user_id", S(obj.f));
        jSONObject17.put("device_id", S(obj.g));
        l = obj24 != null ? str7 : obj.s;
        jSONObject17.put("session_id", l);
        jSONObject17.put("uuid", UUID.randomUUID().toString());
        jSONObject17.put("sequence_number", t());
        if (obj.o.r()) {
            jSONObject17.put("version_name", S(obj.y.q()));
        }
        if (obj.o.o()) {
            jSONObject17.put("os_name", S(obj.y.o()));
        }
        if (obj.o.p()) {
            jSONObject17.put("os_version", S(obj.y.p()));
        }
        if (obj.o.e()) {
            jSONObject17.put("api_level", S(Integer.valueOf(Build.VERSION.SDK_INT)));
        }
        if (obj.o.i()) {
            jSONObject17.put("device_brand", S(obj.y.f()));
        }
        if (obj.o.j()) {
            jSONObject17.put("device_manufacturer", S(obj.y.l()));
        }
        if (obj.o.k()) {
            jSONObject17.put("device_model", S(obj.y.m()));
        }
        if (obj.o.g()) {
            jSONObject17.put("carrier", S(obj.y.h()));
        }
        if (obj.o.h()) {
            jSONObject17.put("country", S(obj.y.i()));
        }
        if (obj.o.m()) {
            jSONObject17.put("language", S(obj.y.k()));
        }
        if (obj.o.q()) {
            jSONObject17.put("platform", obj.r);
        }
        JSONObject jSONObject16 = new JSONObject();
        if (obj.L == null) {
            str16 = "unknown-library";
        }
        jSONObject16.put("name", str16);
        if (obj.M == null) {
            jSONObject = "unknown-version";
        }
        jSONObject16.put("version", jSONObject);
        jSONObject17.put("library", jSONObject16);
        if (jSONObject3 == null) {
            jSONObject9 = new JSONObject();
        } else {
            jSONObject9 = jSONObject3;
        }
        length = obj.p;
        if (length != null && length.length() > 0) {
            if (length.length() > 0) {
                jSONObject9.put("tracking_options", obj.p);
            }
        }
        str5 = obj.y.n();
        if (obj.o.n() && str5 != null) {
            str5 = obj.y.n();
            if (str5 != null) {
                jSONObject = new JSONObject();
                jSONObject.put("lat", str5.getLatitude());
                jSONObject.put("lng", str5.getLongitude());
                jSONObject9.put("location", jSONObject);
            }
        }
        if (obj.o.d() && obj.y.d() != null) {
            if (obj.y.d() != null) {
                jSONObject9.put("androidADID", obj.y.d());
            }
        }
        if (obj.o.f() && obj.y.e() != null) {
            if (obj.y.e() != null) {
                jSONObject9.put("android_app_set_id", obj.y.e());
            }
        }
        jSONObject9.put("limit_ad_tracking", obj.y.s());
        jSONObject9.put("gps_enabled", obj.y.r());
        jSONObject17.put("api_properties", jSONObject9);
        if (jSONObject14 == null) {
            jSONObject8 = new JSONObject();
        } else {
            jSONObject8 = i0(jSONObject14);
        }
        jSONObject17.put("event_properties", jSONObject8);
        if (jSONObject15 == null) {
            jSONObject13 = new JSONObject();
        } else {
            jSONObject13 = i0(jSONObject15);
        }
        jSONObject17.put("user_properties", jSONObject13);
        if (jSONObject11 == null) {
            jSONObject12 = new JSONObject();
        } else {
            jSONObject12 = i0(jSONObject11);
        }
        jSONObject17.put("groups", jSONObject12);
        if (jSONObject7 == null) {
            jSONObject10 = new JSONObject();
        } else {
            jSONObject10 = i0(jSONObject7);
        }
        jSONObject17.put("group_properties", jSONObject10);
        l2 = V(str12, jSONObject17);
        return l2;
    }

    public void I(String string, JSONObject jSONObject2) {
        L(string, jSONObject2, false);
    }

    public void J(String string, JSONObject jSONObject2, JSONObject jSONObject3, long l4, boolean z5) {
        Object obj;
        String str;
        JSONObject jSONObject4;
        int i;
        int i3;
        JSONObject jSONObject;
        int i2;
        long l;
        Object obj2;
        if (n0(string)) {
            this.M(string, jSONObject2, 0, 0, jSONObject3, 0, l4, obj9);
        }
    }

    public void K(String string, JSONObject jSONObject2, JSONObject jSONObject3, boolean z4) {
        this.J(string, jSONObject2, jSONObject3, q(), obj5);
    }

    public void L(String string, JSONObject jSONObject2, boolean z3) {
        K(string, jSONObject2, 0, z3);
    }

    protected void M(String string, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, long l7, boolean z8) {
        JSONObject jSONObject7;
        JSONObject jSONObject11;
        JSONObject jSONObject9;
        JSONObject jSONObject;
        JSONObject jSONObject10;
        JSONObject jSONObject8;
        if (jSONObject2 != null) {
            jSONObject11 = jSONObject7;
        } else {
            jSONObject11 = jSONObject2;
        }
        if (jSONObject3 != null) {
            jSONObject9 = jSONObject7;
        } else {
            jSONObject9 = jSONObject3;
        }
        if (jSONObject4 != null) {
            jSONObject = jSONObject7;
        } else {
            jSONObject = jSONObject4;
        }
        if (jSONObject5 != null) {
            jSONObject10 = jSONObject7;
        } else {
            jSONObject10 = jSONObject5;
        }
        if (jSONObject6 != null) {
            jSONObject8 = jSONObject7;
        } else {
            jSONObject8 = jSONObject6;
        }
        super(this, string, jSONObject11, jSONObject9, jSONObject, jSONObject10, jSONObject8, l7, obj10, obj21);
        com.amplitude.api.f fVar = this;
        T(gVar);
    }

    protected void N(Call.Factory call$Factory, String string2, long l3, long l4) {
        boolean z;
        boolean str2;
        int i;
        String string;
        int equals;
        byte[] digest;
        String str4;
        a aVar;
        String str;
        String str3;
        int i2;
        boolean obj10;
        Object obj11;
        String obj12;
        StringBuilder obj13;
        int obj14;
        final String str5 = "Exception:";
        String str6 = "2";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(q());
        String string3 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str6);
        stringBuilder3.append(this.d);
        stringBuilder3.append(string2);
        stringBuilder3.append(string3);
        aVar = new a();
        FormBody.Builder builder5 = new FormBody.Builder();
        int i3 = 0;
        Request.Builder builder3 = new Request.Builder();
        obj11 = builder3.url(this.Q).post(builder5.add("v", str6).add("client", this.d).add("e", string2).add("upload_time", string3).add("checksum", n(aVar.digest(stringBuilder3.toString().getBytes("UTF-8")))).build());
        if (!n.d(this.R)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Bearer ");
            stringBuilder2.append(this.R);
            obj11.addHeader("Authorization", stringBuilder2.toString());
        }
        i = 1;
        obj10 = FirebasePerfOkHttpClient.execute(factory.newCall(obj11.build()));
        obj11 = obj10.body().string();
        if (obj11.equals("success")) {
            super(this, l3, str3, obj14, obj8);
            this.S.a(obj11);
        } else {
            if (obj11.equals("invalid_api_key")) {
                f.V.b(f.U, "Invalid API key, make sure your API key is correct in initialize()");
            } else {
                if (obj11.equals("bad_checksum")) {
                    f.V.e(f.U, "Bad checksum, post request was mangled in transit, will attempt to reupload later");
                } else {
                    if (obj11.equals("request_db_write_failed")) {
                        f.V.e(f.U, "Couldn't write to request database on server, will attempt to reupload later");
                    } else {
                        if (obj10.code() == 413) {
                            obj10 = 0;
                            if (this.F && this.G == i && Long.compare(l3, obj10) >= 0) {
                                if (this.G == i) {
                                    obj10 = 0;
                                    if (Long.compare(l3, obj10) >= 0) {
                                        this.c.m0(l3);
                                    }
                                    if (Long.compare(obj14, obj10) >= 0) {
                                        this.c.A0(obj14);
                                    }
                                }
                            }
                            this.F = i;
                            obj11 = this.G;
                            this.G = (int)obj10;
                            f.V.e(f.U, "Request too large, will decrease size and attempt to reupload");
                            obj11 = new f.d(this);
                            this.S.a(obj11);
                        } else {
                            obj13 = new StringBuilder();
                            obj13.append("Upload failed, ");
                            obj13.append(obj11);
                            obj13.append(", will attempt to reupload later");
                            f.V.e(f.U, obj13.toString());
                        }
                    }
                }
            }
            i = i3;
        }
        if (i == 0) {
            this.P.set(i3);
        }
    }

    protected Pair<Pair<Long, Long>, JSONArray> O(List<JSONObject> list, List<JSONObject> list2, long l3) {
        int i2;
        Object remove;
        int i3;
        Object remove2;
        long long2;
        long empty;
        int cmp;
        boolean length;
        int i;
        String str;
        long long;
        com.amplitude.api.g obj12;
        String obj13;
        long obj14;
        JSONArray jSONArray = new JSONArray();
        i3 = i2;
        while (Long.compare(l, l3) < 0) {
            empty = list.isEmpty();
            length = list2.isEmpty();
            i = 0;
            if (empty) {
                break;
            } else {
            }
            str = "event_id";
            if (length) {
            } else {
            }
            if (empty) {
            } else {
            }
            length = "sequence_number";
            if ((JSONObject)list.get(i).has(length)) {
            } else {
            }
            remove = list.remove(i);
            empty = (JSONObject)remove.getLong(str);
            jSONArray.put(remove);
            i2 = empty;
            if (Long.compare(long, long3) < 0) {
            } else {
            }
            remove2 = list2.remove(i);
            long2 = (JSONObject)remove2.getLong(str);
            jSONArray.put(remove2);
            i3 = long2;
            remove2 = list2.remove(i);
            long2 = (JSONObject)remove2.getLong(str);
            jSONArray.put(remove2);
            remove = list.remove(i);
            empty = (JSONObject)remove.getLong(str);
            jSONArray.put(remove);
            if (length) {
                break;
            } else {
            }
        }
        obj13 = new Pair(Long.valueOf(i2), Long.valueOf(i3));
        obj12 = new Pair(obj13, jSONArray);
        return obj12;
    }

    void P(long l) {
        f.i iVar = new f.i(this, l, obj3);
        T(iVar);
    }

    void Q(long l) {
        f.h hVar = new f.h(this, l, obj3);
        T(hVar);
    }

    void R(long l) {
        if (!w()) {
        }
        Y(l);
    }

    protected Object S(Object object) {
        Object obj1;
        if (object == null) {
            obj1 = JSONObject.NULL;
        }
        return obj1;
    }

    protected void T(Runnable runnable) {
        final com.amplitude.api.o oVar = this.S;
        if (Thread.currentThread() != oVar) {
            oVar.a(runnable);
        } else {
            runnable.run();
        }
    }

    protected long V(String string, JSONObject jSONObject2) {
        int cmp2;
        int cmp;
        long l;
        boolean equals;
        com.amplitude.api.i iVar;
        long l2;
        long l3;
        long l4;
        int cmp3;
        long obj9;
        int obj10;
        obj10 = jSONObject2.toString();
        int i = 1;
        if (n.d(obj10)) {
            Object[] arr = new Object[i];
            arr[0] = string;
            f.V.b(f.U, String.format("Detected empty event string for event type %s, skipping", arr));
            return -1;
        }
        String str2 = "$identify";
        final String str3 = "$groupidentify";
        if (!string.equals(str2)) {
            if (string.equals(str3)) {
                l2 = this.c.e(obj10);
                this.v = l2;
                Z(l2);
            } else {
                l2 = this.c.a(obj10);
                this.u = l2;
                X(l2);
            }
        } else {
        }
        obj10 = Math.min(Math.max(i, obj10 /= 10), 20);
        if (Long.compare(l5, l3) > 0) {
            cmp2 = this.c;
            cmp2.v0(cmp2.F((long)obj10));
        }
        if (Long.compare(l6, l4) > 0) {
            cmp = this.c;
            cmp.C0(cmp.J((long)obj10));
        }
        l = this.c.K();
        obj10 = this.z;
        if (Long.compare(i6, i7) == 0 && Long.compare(l, cmp3) >= 0) {
            if (Long.compare(l, cmp3) >= 0) {
                j0();
            } else {
                l0(this.C);
            }
        } else {
        }
        if (!string.equals(str2)) {
            if (string.equals(str3)) {
                obj9 = this.v;
            } else {
                obj9 = this.u;
            }
        } else {
        }
        return obj9;
    }

    void X(long l) {
        this.u = l;
        this.c.Y("last_event_id", Long.valueOf(l));
    }

    void Y(long l) {
        this.w = l;
        this.c.Y("last_event_time", Long.valueOf(l));
    }

    void Z(long l) {
        this.v = l;
        this.c.Y("last_identify_id", Long.valueOf(l));
    }

    void a0(long l) {
        this.x = l;
        this.c.Y("previous_session_id", Long.valueOf(l));
    }

    public com.amplitude.api.f c0(String string) {
        d0(string, false);
        return this;
    }

    public com.amplitude.api.f d0(String string, boolean z2) {
        if (!o("setUserId()")) {
            return this;
        }
        f.j jVar = new f.j(this, this, z2, string);
        T(jVar);
        return this;
    }

    public boolean f0(long l) {
        final int i = 0;
        final int i2 = 1;
        if (w() && D(l)) {
            if (D(l)) {
                R(l);
                return i;
            }
            e0(l);
            return i2;
        }
        final long l2 = this.x;
        if (D(l) && Long.compare(l2, i3) == 0) {
            l2 = this.x;
            if (Long.compare(l2, i3) == 0) {
                e0(l);
                return i2;
            }
            b0(l2);
            R(l);
            return i;
        }
        e0(l);
        return i2;
    }

    public JSONArray h0(JSONArray jSONArray) {
        int i;
        JSONObject jSONObject;
        boolean equals;
        Class<JSONObject> obj;
        if (jSONArray == null) {
            JSONArray obj5 = new JSONArray();
            return obj5;
        }
        i = 0;
        while (i < jSONArray.length()) {
            jSONObject = jSONArray.get(i);
            if (jSONObject.getClass().equals(String.class)) {
            } else {
            }
            if (jSONObject.getClass().equals(JSONObject.class)) {
            } else {
            }
            if (jSONObject.getClass().equals(JSONArray.class)) {
            }
            i++;
            jSONArray.put(i, h0((JSONArray)jSONObject));
            jSONArray.put(i, i0((JSONObject)jSONObject));
            jSONArray.put(i, f.g0((String)jSONObject));
        }
        return jSONArray;
    }

    public JSONObject i0(JSONObject jSONObject) {
        int next;
        Object gVar;
        String equals;
        Class<JSONObject> obj;
        if (jSONObject == null) {
            JSONObject obj6 = new JSONObject();
            return obj6;
        }
        if (jSONObject.length() > 1000) {
            f.V.e(f.U, "Warning: too many properties (more than 1000), ignoring");
            obj6 = new JSONObject();
            return obj6;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            next = keys.next();
            gVar = jSONObject.get((String)next);
            if (!next.equals("$receipt")) {
            } else {
            }
            jSONObject.put(next, gVar);
            if (next.equals("$receiptSig")) {
            } else {
            }
            if (gVar.getClass().equals(String.class)) {
            } else {
            }
            if (gVar.getClass().equals(JSONObject.class)) {
            } else {
            }
            if (gVar.getClass().equals(JSONArray.class)) {
            }
            jSONObject.put(next, h0((JSONArray)gVar));
            jSONObject.put(next, i0((JSONObject)gVar));
            jSONObject.put(next, f.g0((String)gVar));
        }
        return jSONObject;
    }

    protected void j0() {
        k0(false);
    }

    protected void k0(boolean z) {
        boolean andSet;
        int i;
        Object bVar;
        Object str;
        Object obj;
        long string;
        long longValue2;
        long longValue;
        Object obj11;
        if (!this.l) {
            if (this.m) {
            } else {
                if (!this.P.getAndSet(true)) {
                    obj11 = z != null ? this.G : this.A;
                    long l2 = Math.min((long)obj11, obj5);
                    andSet = 0;
                    if (Long.compare(l2, i2) <= 0) {
                        this.P.set(andSet);
                    }
                    obj11 = O(this.c.q(this.u, obj5), this.c.x(this.v, obj6), l2);
                    if ((JSONArray)obj11.second.length() == 0) {
                        this.P.set(andSet);
                    }
                    super(this, (JSONArray)obj11.second.toString(), (Long)first.first.longValue(), obj7, (Long)first3.second.longValue(), obj9);
                    this.T.a(bVar);
                }
            }
        }
    }

    void m0() {
        this.H = true;
    }

    protected String n(byte[] bArr) {
        int i;
        char c;
        int i2;
        char c2;
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[length *= 2];
        i = 0;
        for (byte b : bArr) {
            b &= 255;
            int i7 = i * 2;
            cArr2[i7] = cArr[i5 >>> 4];
            cArr2[i7++] = cArr[i5 &= 15];
        }
        String obj7 = new String(cArr2);
        return obj7;
    }

    protected boolean n0(String string) {
        if (n.d(string)) {
            f.V.b(f.U, "Argument eventType cannot be null or blank in logEvent()");
            return 0;
        }
        return o("logEvent()");
    }

    protected boolean o(String string) {
        final int i = 0;
        synchronized (this) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("context cannot be null, set context with initialize() before calling ");
                stringBuilder.append(string);
                f.V.b(f.U, stringBuilder.toString());
                return i;
                if (n.d(this.d)) {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("apiKey cannot be null or empty, set apiKey with initialize() before calling ");
                stringBuilder2.append(string);
                f.V.b(f.U, stringBuilder2.toString());
                return i;
                return 1;
                throw string;
            }
        }
    }

    public com.amplitude.api.f p(Application application) {
        boolean sDK_INT;
        int i;
        if (!this.H) {
            if (!o("enableForegroundTracking()")) {
            } else {
                if (Build.VERSION.SDK_INT >= 14) {
                    sDK_INT = new e(this);
                    application.registerActivityLifecycleCallbacks(sDK_INT);
                }
            }
        }
        return this;
    }

    protected long q() {
        return System.currentTimeMillis();
    }

    long t() {
        l += i2;
        this.t = i;
        this.c.Y("sequence_number", Long.valueOf(i));
        return this.t;
    }

    public void u(com.amplitude.api.l l) {
        v(l, false);
    }

    public void v(com.amplitude.api.l l, boolean z2) {
        int length;
        Object obj;
        String str;
        int i3;
        int i4;
        JSONObject jSONObject;
        int i2;
        int i;
        long l2;
        Object obj2;
        if (l != null && l.a.length() != 0) {
            if (l.a.length() != 0) {
                if (!o("identify()")) {
                } else {
                    this.M("$identify", 0, 0, l.a, 0, 0, q(), obj9);
                }
            }
        }
    }

    public com.amplitude.api.f x(Context context, String string2) {
        y(context, string2, 0);
        return this;
    }

    public com.amplitude.api.f y(Context context, String string2, String string3) {
        this.z(context, string2, string3, 0, false);
        return this;
    }

    public com.amplitude.api.f z(Context context, String string2, String string3, String string4, boolean z5) {
        this.C(context, string2, string3, string4, z5, 0);
        return this;
        synchronized (this) {
            this.C(context, string2, string3, string4, z5, 0);
            return this;
        }
    }
}
