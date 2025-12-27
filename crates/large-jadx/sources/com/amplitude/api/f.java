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
import f.a.b.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
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

/* compiled from: AmplitudeClient.java */
/* loaded from: classes.dex */
public class f {

    private static final String U = "com.amplitude.api.f";
    private static final g V;
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
    o S;
    o T;
    protected Context a;
    protected Call.Factory b;
    protected i c;
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
    m n;
    m o;
    JSONObject p;
    private boolean q;
    protected String r;
    long s;
    long t;
    long u;
    long v;
    long w;
    long x;
    protected k y;
    private int z;

    class a implements Runnable {

        final /* synthetic */ f a;
        a() {
            this.a = fVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.O.set(false);
            this.a.j0();
        }
    }

    class b implements Runnable {

        final /* synthetic */ String a;
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ f v;
        b(String str, long j, long j2) {
            this.v = fVar;
            this.a = str;
            this.b = j;
            this.c = j2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.v.N(fVar.b, this.a, this.b, this.c);
        }
    }

    class c implements Runnable {

        final /* synthetic */ long a;
        final /* synthetic */ long b;
        final /* synthetic */ f c;
        c(long j, long j2) {
            this.c = fVar;
            this.a = j;
            this.b = j2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            long l3 = 0L;
            if (this.a >= l3) {
                this.c.c.v0(this.a);
            }
            if (this.b >= l3) {
                this.c.c.C0(this.b);
            }
            boolean z = false;
            this.c.P.set(z);
            long l4 = this.c.c.K();
            long l5 = (long)this.c.z;
            if (l4 > this.c.c) {
                this.c.S.a(new f.c.a(this));
            } else {
                this.c.F = z;
                this.c.G = this.c.A;
            }
        }
    }

    class d implements Runnable {

        final /* synthetic */ f a;
        d() {
            this.a = fVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.P.set(false);
            this.a.k0(true);
        }
    }

    class g implements Runnable {

        final /* synthetic */ f A;
        final /* synthetic */ String a;
        final /* synthetic */ JSONObject b;
        final /* synthetic */ JSONObject c;
        final /* synthetic */ JSONObject v;
        final /* synthetic */ JSONObject w;
        final /* synthetic */ JSONObject x;
        final /* synthetic */ long y;
        final /* synthetic */ boolean z;
        g(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
            this.A = fVar;
            this.a = str;
            this.b = jSONObject;
            this.c = jSONObject2;
            this.v = jSONObject3;
            this.w = jSONObject4;
            this.x = jSONObject5;
            this.y = j;
            this.z = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.d(this.A.d)) {
                return;
            }
            this.A.H(this.a, this.b, this.c, this.v, this.w, this.x, this.y, this.z);
        }
    }

    class h implements Runnable {

        final /* synthetic */ long a;
        final /* synthetic */ f b;
        h(long j) {
            this.b = fVar;
            this.a = j;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            if (n.d(this.b.d)) {
                return;
            }
            this.b.R(this.a);
            this.b.J = 0;
            if (this.b.K) {
                this.b.j0();
            }
            fVar6.c.e0("device_id", fVar6.g);
            fVar7.c.e0("user_id", fVar7.f);
            int obj = this.b.l ? 1 : 0;
            fVar8.c.Y((this.b.l ? 1 : 0), Long.valueOf((this.b.l ? 1 : 0), l4));
            fVar9.c.Y((this.b.l ? 1 : 0), Long.valueOf((this.b.l ? 1 : 0), l4));
            fVar10.c.Y((this.b.l ? 1 : 0), Long.valueOf((this.b.l ? 1 : 0), l4));
        }
    }

    class i implements Runnable {

        final /* synthetic */ long a;
        final /* synthetic */ f b;
        i(long j) {
            this.b = fVar;
            this.a = j;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.d(this.b.d)) {
                return;
            }
            if (this.b.N) {
                h.b().c(new f.i.a(this));
            }
            this.b.f0(this.a);
            this.b.J = 1;
        }
    }

    class j implements Runnable {

        final /* synthetic */ f a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ f v;
        j(f fVar, boolean z, String str) {
            this.v = fVar;
            this.a = fVar2;
            this.b = z;
            this.c = str;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.d(this.a.d)) {
                return;
            }
            if (this.b && f.i(this.v)) {
                str = "session_end";
                this.v.W(str);
            }
            this.a.f = this.c;
            str3 = "user_id";
            this.v.c.e0(str3, this.c);
            if (this.b) {
                long l = this.v.q();
                this.v.b0(l, this.c);
                this.v.R(l);
                if (this.v.I) {
                    str2 = "session_start";
                    this.v.W(str2);
                }
            }
        }
    }

    class e implements h.a {

        final /* synthetic */ f a;
        e() {
            this.a = fVar;
            super();
        }

        public void a() {
            this.a.Q = h.b().a();
        }
    }

    class f implements j {

        final /* synthetic */ f a;
        final /* synthetic */ f b;
        f(f fVar) {
            this.b = fVar;
            this.a = fVar2;
            super();
        }

        public void a(SQLiteDatabase sQLiteDatabase) {
            int i = 1;
            String str3 = "store";
            this.b.c.g0(sQLiteDatabase, str3, "device_id", this.a.g);
            this.b.c.g0(sQLiteDatabase, str3, "user_id", this.a.f);
            int r1 = this.a.l ? 1 : 0;
            String str4 = "long_store";
            this.b.c.g0(sQLiteDatabase, str4, "opt_out", (this.a.l ? 1 : 0));
            this.b.c.g0(sQLiteDatabase, str4, "previous_session_id", (this.a.l ? 1 : 0));
            this.b.c.g0(sQLiteDatabase, str4, "last_event_time", (this.a.l ? 1 : 0));
        }
    }
    static {
        f.V = g.d();
    }

    public f() {
        this(null);
    }

    private String A() {
        boolean endsWith;
        Set set = r();
        String str3 = this.c.L("device_id");
        final String str9 = "S";
        if (!n.d(str3) && !set.contains(str3) && !str3.endsWith(str9)) {
            return str3;
        }
        if (!this.h && this.i && !this.y.s() && !n.d(str7) && !set.contains(str7)) {
            U(str7);
            return str7;
        }
        if (this.j) {
            String str4 = this.y.e();
            if (!n.d(str4) && !set.contains(str4)) {
                StringBuilder stringBuilder = new StringBuilder();
                str = str4 + str9;
                U(str);
                return str;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String str5 = k.c();
        String str6 = "R";
        str2 = str5 + str6;
        U(str2);
        return str2;
    }

    private boolean D(long j) {
        long l;
        boolean z2 = false;
        long r0 = this.H ? this.D : this.E;
        j -= l2;
        j = l3 < r0 ? 1 : 0;
        return (l3 < r0 ? 1 : 0);
    }

    private /* synthetic */ void E(Call.Factory factory, String str, f fVar) {
        com.amplitude.api.b bVar;
        int i;
        if (!this.k && factory == null) {
            try {
                this.b = new b(a.a(c.a));
                this.b = factory;
                if (this.N) {
                    h.b().c(new f.e(this));
                }
                this.y = B();
                this.g = A();
                this.y.u();
            } catch (com.amplitude.api.CursorWindowAllocationException cursorWindowAllocation) {
                str = f.V;
                int arr = new Object[arr];
                cursorWindowAllocation = cursorWindowAllocation.getMessage();
                arr[i2] = cursorWindowAllocation;
                cursorWindowAllocation = "Failed to initialize Amplitude SDK due to: %s";
                cursorWindowAllocation = String.format(cursorWindowAllocation, arr);
                str.b(f.U, cursorWindowAllocation);
                cursorWindowAllocation = null;
                fVar.d = cursorWindowAllocation;
            }
            str = "user_id";
            if (str != null) {
                try {
                    fVar.f = str;
                    this.c.e0(str, str);
                    fVar.f = this.c.L(str);
                    Long l4 = this.c.E("opt_out");
                    if (l4 != null) {
                        long value = l4.longValue();
                        long l = 1L;
                        cursorWindowAllocation = value == l ? z2 : 0;
                    }
                    this.l = (value == l ? z2 : 0);
                    long l2 = -1L;
                    cursorWindowAllocation = s((value == l ? z2 : 0), l2);
                    this.x = cursorWindowAllocation;
                    long l3 = 0L;
                    if (cursorWindowAllocation >= l3) {
                        this.s = cursorWindowAllocation;
                    }
                    this.t = s("sequence_number", l3);
                    this.u = s("last_event_id", l2);
                    this.v = s("last_identify_id", l2);
                    this.w = s("last_event_time", l2);
                    this.c.I0(new f.f(this, fVar));
                    this.k = z2;
                } catch (com.amplitude.api.CursorWindowAllocationException cursorWindowAllocation) {
                    str = f.V;
                    arr = new Object[arr];
                    cursorWindowAllocation = cursorWindowAllocation.getMessage();
                    arr[i2] = cursorWindowAllocation;
                    cursorWindowAllocation = "Failed to initialize Amplitude SDK due to: %s";
                    cursorWindowAllocation = String.format(cursorWindowAllocation, arr);
                    str.b(f.U, cursorWindowAllocation);
                    cursorWindowAllocation = null;
                    fVar.d = cursorWindowAllocation;
                }
            }
        }
    }

    static /* synthetic */ Call G(b bVar, Request request) {
        return (Call_Factory)bVar.get().newCall(request);
    }

    private void U(String str) {
        this.c.e0("device_id", str);
    }

    private void W(String str) {
        Object[] arr = new Object[1];
        if (!o(String.format("sendSessionEvent('%s')", new Object[] { str }))) {
            return;
        }
        if (!w()) {
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("special", str);
        } catch (org.json.JSONException unused) {
            return;
        }
        this.H(str, null, jSONObject, null, null, null, this.w, false);
    }

    static /* synthetic */ boolean a(f fVar) {
        return fVar.l;
    }

    static /* synthetic */ boolean b(f fVar) {
        return fVar.F;
    }

    private void b0(long j) {
        this.s = j;
        a0(j);
    }

    static /* synthetic */ boolean c(f fVar, boolean z) {
        fVar.F = z;
        return z;
    }

    static /* synthetic */ boolean d(f fVar, boolean z) {
        fVar.J = z;
        return z;
    }

    static /* synthetic */ int e(f fVar, int i) {
        fVar.G = i;
        return i;
    }

    private void e0(long j) {
        if (this.I) {
            W("session_end");
        }
        b0(j);
        R(j);
        if (this.I) {
            W("session_start");
        }
    }

    static /* synthetic */ int f(f fVar) {
        return fVar.A;
    }

    static /* synthetic */ boolean g(f fVar) {
        return fVar.K;
    }

    public static String g0(String str) {
        String substring;
        final int i = 1024;
        if (str.length() > i) {
            int length = 0;
            substring = str.substring(length, i);
        }
        return substring;
    }

    static /* synthetic */ boolean h(f fVar) {
        return fVar.N;
    }

    static /* synthetic */ boolean i(f fVar) {
        return fVar.I;
    }

    static /* synthetic */ void j(f fVar, String str) {
        fVar.W(str);
    }

    static /* synthetic */ void k(f fVar, long j) {
        fVar.b0(j);
    }

    static /* synthetic */ AtomicBoolean l(f fVar) {
        return fVar.O;
    }

    private void l0(long j) {
        if (this.O.getAndSet(true)) {
            return;
        }
        this.S.b(new f.a(this), j);
    }

    static /* synthetic */ int m(f fVar) {
        return fVar.z;
    }

    private Set<String> r() {
        final HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        return hashSet;
    }

    private long s(String str, long j) {
        long value;
        final Long l = this.c.E(str);
        if (l != null) {
            value = l.longValue();
        }
        return value;
    }

    private boolean w() {
        boolean z = true;
        int r0 = this.s >= 0 ? 1 : 0;
        return (this.s >= 0 ? 1 : 0);
    }

    protected k B() {
        return new k(this.a, this.q);
    }

    public synchronized f C(Context context, String str, String str2, String str3, boolean z, Call.Factory factory) {
        if (context == null) {
            f.V.b(f.U, "Argument context cannot be null in initialize()");
            return this;
        }
        f.V.b(f.U, "Argument apiKey cannot be null or blank in initialize()");
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.d = str;
        this.c = i.k(applicationContext, this.e);
        if (n.d(str3)) {
            str = "Android";
        }
        this.r = str;
        T(new a(this, factory, str2, this));
        return this;
    }

    protected long H(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        String uuid;
        int i = 0;
        int i2 = -1;
        long l;
        long l2;
        String str6;
        String str7;
        final Object str10 = this;
        str3 = str;
        JSONObject jSONObject22 = jSONObject;
        JSONObject jSONObject42 = jSONObject3;
        jSONObject52 = jSONObject4;
        jSONObject62 = jSONObject5;
        long j72 = j;
        StringBuilder stringBuilder = new StringBuilder();
        str5 = "Logged event to Amplitude: ";
        str57 = str5 + str3;
        f.V.a(f.U, str57);
        i2 = -1;
        if (str10.l) {
            return i2;
        }
        if (str10.I) {
            if (!str3.equals("session_start")) {
                int r8 = str3.equals("session_end") ? 1 : 0;
            }
        }
        if (f.V == 0 && !z) {
            if (!str10.J) {
                f0(j72);
            } else {
                R(j72);
            }
        }
        JSONObject jSONObject13 = new JSONObject();
        try {
            Object obj = S(str);
            jSONObject13.put("event_type", obj);
            jSONObject13.put("timestamp", j72);
            jSONObject13.put("user_id", S(str10.f));
            jSONObject13.put("device_id", S(str10.g));
            int r13 = z ? i2 : str10.s;
            jSONObject13.put("session_id", (z ? i2 : str10.s));
            jSONObject13.put("uuid", UUID.randomUUID().toString());
            jSONObject13.put("sequence_number", (z ? i2 : str10.s));
            if (str10.o.r()) {
                jSONObject13.put("version_name", S(str10.y.q()));
            }
            if (str10.o.o()) {
                jSONObject13.put("os_name", S(str10.y.o()));
            }
            if (str10.o.p()) {
                jSONObject13.put("os_version", S(str10.y.p()));
            }
            if (str10.o.e()) {
                jSONObject13.put("api_level", S(Integer.valueOf(Build.VERSION.SDK_INT)));
            }
            if (str10.o.i()) {
                jSONObject13.put("device_brand", S(str10.y.f()));
            }
            if (str10.o.j()) {
                jSONObject13.put("device_manufacturer", S(str10.y.l()));
            }
            if (str10.o.k()) {
                jSONObject13.put("device_model", S(str10.y.m()));
            }
            if (str10.o.g()) {
                jSONObject13.put("carrier", S(str10.y.h()));
            }
            if (str10.o.h()) {
                jSONObject13.put("country", S(str10.y.i()));
            }
            if (str10.o.m()) {
                jSONObject13.put("language", S(str10.y.k()));
            }
            if (str10.o.q()) {
                jSONObject13.put("platform", str10.r);
            }
            JSONObject jSONObject12 = new JSONObject();
            if (str10.L == null) {
                str6 = "unknown-library";
            }
            jSONObject12.put("name", str6);
            if (str10.M == null) {
                str7 = "unknown-version";
            }
            jSONObject12.put("version", str7);
            jSONObject13.put("library", jSONObject12);
            int i3 = jSONObject2 == null ? new JSONObject() : jSONObject2;
            if (str10.p != null && str10.p.length() > 0) {
                jSONObject10.put("tracking_options", str10.p);
            }
            if (str10.o.n() && location != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("lat", location.getLatitude());
                jSONObject14.put("lng", location.getLongitude());
                jSONObject10.put("location", jSONObject14);
            }
            if (str10.o.d() && str10.y.d() != null) {
                jSONObject10.put("androidADID", str10.y.d());
            }
            if (str10.o.f() && str10.y.e() != null) {
                jSONObject10.put("android_app_set_id", str10.y.e());
            }
            jSONObject10.put("limit_ad_tracking", str10.y.s());
            jSONObject10.put("gps_enabled", str10.y.r());
            jSONObject13.put("api_properties", jSONObject10);
            str4 = "event_properties";
            if (jSONObject22 == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = i0(jSONObject22);
            }
            jSONObject13.put("event_properties", jSONObject);
            if (jSONObject42 == null) {
                jSONObject7 = new JSONObject();
            } else {
                jSONObject7 = i0(jSONObject42);
            }
            jSONObject13.put("user_properties", jSONObject7);
            if (jSONObject52 == null) {
                jSONObject8 = new JSONObject();
            } else {
                jSONObject8 = i0(jSONObject52);
            }
            jSONObject13.put("groups", jSONObject8);
            str2 = "group_properties";
            if (jSONObject62 == null) {
                jSONObject9 = new JSONObject();
            } else {
                jSONObject9 = i0(jSONObject62);
            }
            jSONObject13.put("group_properties", jSONObject9);
            l = V(str3, jSONObject13);
        } catch (org.json.JSONException jSON) {
            int arr = 2;
            arr = new Object[arr];
            arr[0] = obj2;
            Throwable jSON2 = jSON.toString();
            Object obj2 = 1;
            arr[obj2] = jSON2;
            jSON2 = "JSON Serialization of event type %s failed, skipping: %s";
            jSON2 = String.format(jSON2, arr);
            f.V.b(f.U, jSON2);
        }
        return l;
    }

    public void I(String str, JSONObject jSONObject) {
        L(str, jSONObject, false);
    }

    public void J(String str, JSONObject jSONObject, JSONObject jSONObject2, long j, boolean z) {
        if (n0(str)) {
            jSONObject = null;
            JSONObject jSONObject4 = null;
            JSONObject jSONObject5 = null;
            this.M(str, jSONObject, jSONObject, jSONObject4, jSONObject2, jSONObject5, j, z);
        }
    }

    public void K(String str, JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        this.J(str, jSONObject, jSONObject2, q(), z);
    }

    public void L(String str, JSONObject jSONObject, boolean z) {
        K(str, jSONObject, null, z);
    }

    protected void M(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
        JSONObject jSONObject22;
        jSONObject22 = jSONObject != null ? jSONObject22 : jSONObject;
        jSONObject22 = jSONObject2 != null ? jSONObject22 : jSONObject2;
        jSONObject22 = jSONObject3 != null ? jSONObject22 : jSONObject3;
        jSONObject22 = jSONObject4 != null ? jSONObject22 : jSONObject4;
        jSONObject22 = jSONObject5 != null ? jSONObject22 : jSONObject5;
        f.g gVar = new f.g(this, str, jSONObject22, jSONObject22, jSONObject22, jSONObject22, jSONObject22, j, z, z);
        T(gVar);
    }

    protected void N(Call.Factory factory, String str, long j, long j2) throws UnsupportedEncodingException, java.security.DigestException {
        int cmp;
        String str3;
        long l3;
        String str9 = "2";
        StringBuilder stringBuilder2 = new StringBuilder();
        String str15 = "";
        long l2 = q();
        str12 = str15 + l2;
        try {
            StringBuilder stringBuilder4 = new StringBuilder();
            str21 = str9 + this.d + str + str12;
        } catch (java.lang.IllegalArgumentException iae) {
            str = f.V;
            j = f.U;
            iae = iae.toString();
            str.b(j, iae);
            this.P.set(z3);
            return;
        }
        str3 = "e";
        boolean z4 = false;
        try {
            Request.Builder post = new Request_Builder().url(this.Q).post(new FormBody_Builder().add("v", str9).add("client", this.d).add(str3, str).add("upload_time", str12).add("checksum", n(new a().digest(str21.getBytes("UTF-8")))).build());
            if (!n.d(this.R)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str24 = "Bearer ";
                str = str24 + this.R;
                post.addHeader("Authorization", str);
            }
        } catch (java.lang.IllegalArgumentException iae) {
            str = f.V;
            j = f.U;
            iae = this.P.toString();
            str.b(j, this.P);
            this.P.set(z3);
            return;
        }
        int i = 1;
        try {
            Response execute = FirebasePerfOkHttpClient.execute(this.P.newCall(post.build()));
            String string = execute.body().string();
        } catch (java.net.ConnectException | java.net.UnknownHostException unused) {
            i = z4;
        } catch (Exception e1) {
        } catch (java.lang.AssertionError e2) {
        } catch (java.io.IOException ioException3) {
        }
        if (string.equals("success")) {
            try {
                f.c str22 = new f.c(this, j, l3, j2, obj2);
                this.S.a(str22);
            } catch (Exception e) {
            } catch (java.lang.AssertionError e1) {
            } catch (java.io.IOException ioException2) {
            } catch (java.net.ConnectException | java.net.UnknownHostException unused) {
                this.P.set(z4);
                return;
            }
        } else {
            try {
                if (string.equals("invalid_api_key")) {
                    f.V.b(f.U, "Invalid API key, make sure your API key is correct in initialize()");
                } else {
                    if (string.equals("bad_checksum")) {
                        f.V.e(f.U, "Bad checksum, post request was mangled in transit, will attempt to reupload later");
                    } else {
                        if (string.equals("request_db_write_failed")) {
                            f.V.e(f.U, "Couldn't write to request database on server, will attempt to reupload later");
                        } else {
                            cmp = 413;
                            if (execute.code() == 413) {
                                if (this.F && this.G == this.R) {
                                    long l4 = 0L;
                                    if (j >= l4) {
                                        this.c.m0(j);
                                    }
                                    if (j2 >= l4) {
                                        this.c.A0(j2);
                                    }
                                }
                                this.F = true;
                                this.G = (int)(Math.ceil((double)(Math.min((int)this.c.n(), this.G)) / 2d));
                                f.V.e(f.U, "Request too large, will decrease size and attempt to reupload");
                                this.S.a(new f.d(this));
                            } else {
                                StringBuilder stringBuilder = new StringBuilder();
                                String str6 = "Upload failed, ";
                                String str30 = ", will attempt to reupload later";
                                str4 = str6 + string + str30;
                                f.V.e(f.U, str4);
                            }
                        }
                    }
                }
            } catch (java.net.ConnectException | java.net.UnknownHostException unused) {
                i = z4;
            } catch (Exception e1) {
            } catch (java.lang.AssertionError e2) {
            } catch (java.io.IOException ioException3) {
            }
        }
    }

    protected Pair<Pair<Long, Long>, JSONArray> O(List<JSONObject> list, List<JSONObject> list2, long j) throws JSONException {
        int i = -1;
        long _long;
        long _long2;
        boolean empty;
        boolean empty2;
        String str;
        int i2 = 0;
        String str2;
        long _long3;
        final JSONArray jSONArray = new JSONArray();
        i = -1;
        long l2 = (long)jSONArray.length();
        while (l2 < j) {
            empty = list.isEmpty();
            empty2 = list2.isEmpty();
            i2 = 0;
            if (empty && empty2) {
            }
        }
        return new Pair(new Pair(Long.valueOf(i), Long.valueOf(i)), jSONArray);
    }

    void P(long j) {
        T(new f.i(this, j, r3));
    }

    void Q(long j) {
        T(new f.h(this, j, r3));
    }

    void R(long j) {
        if (!w()) {
            return;
        }
        Y(j);
    }

    protected Object S(Object object) {
        Object nULL2;
        if (object == null) {
            nULL2 = JSONObject.NULL;
        }
        return nULL2;
    }

    protected void T(Runnable runnable) {
        if (Thread.currentThread() != this.S) {
            this.S.a(runnable);
        } else {
            runnable.run();
        }
    }

    protected long V(String str, JSONObject jSONObject) throws JSONException {
        com.amplitude.api.i iVar;
        int cmp3;
        long l5;
        int cmp4;
        String jSONObject2 = jSONObject.toString();
        int i = 1;
        if (n.d(jSONObject2)) {
            Object[] arr = new Object[i];
            f.V.b(f.U, String.format("Detected empty event string for event type %s, skipping", new Object[] { str }));
            return -1;
        }
        String str3 = "$identify";
        final String str4 = "$groupidentify";
        if (str.equals(str3) || str.equals(str4)) {
            long l2 = this.c.e(jSONObject2);
            this.v = l2;
            Z(l2);
        }
        int min = Math.min(Math.max(i, this.B / 10), 20);
        long l6 = this.c.n();
        l3 = (long)this.B;
        if (l6 > this.B) {
            this.c.v0(this.c.F((long)min));
        }
        long l7 = this.c.w();
        l4 = (long)this.B;
        if (l7 > this.B) {
            this.c.C0(this.c.J((long)min));
        }
        long l = this.c.K();
        long l9 = l % (long)cmp4;
        if (this.B == 0) {
            long l10 = (long)cmp4;
            if (l >= this.B) {
                j0();
            } else {
                l0(this.C);
            }
        }
        if (str.equals(str3) || str.equals(str4)) {
        }
        return l5;
    }

    void X(long j) {
        this.u = j;
        this.c.Y("last_event_id", Long.valueOf(j));
    }

    void Y(long j) {
        this.w = j;
        this.c.Y("last_event_time", Long.valueOf(j));
    }

    void Z(long j) {
        this.v = j;
        this.c.Y("last_identify_id", Long.valueOf(j));
    }

    void a0(long j) {
        this.x = j;
        this.c.Y("previous_session_id", Long.valueOf(j));
    }

    public f c0(String str) {
        d0(str, false);
        return this;
    }

    public f d0(String str, boolean z) {
        if (!o("setUserId()")) {
            return this;
        }
        T(new f.j(this, this, z, str));
        return this;
    }

    public boolean f0(long j) {
        final boolean z4 = false;
        final boolean z5 = true;
        if (w()) {
            if (D(j)) {
                R(j);
                return false;
            }
            e0(j);
            return true;
        }
        if (D(j)) {
            if (this.x == -1) {
                e0(j);
                return true;
            }
            b0(this.x);
            R(j);
            return false;
        }
        e0(j);
        return true;
    }

    public JSONArray h0(JSONArray jSONArray) throws JSONException {
        int i = 0;
        JSONObject jSONObject;
        boolean equals;
        Class<JSONObject> obj;
        if (jSONArray == null) {
            return new JSONArray();
        }
        i = 0;
        while (i < jSONArray.length()) {
            Object obj2 = jSONArray.get(i);
            obj = String.class;
            i = i + 1;
        }
        return jSONArray;
    }

    public JSONObject i0(JSONObject jSONObject) {
        boolean equals;
        Object obj2;
        if (jSONObject == null) {
            return new JSONObject();
        }
        int i = 1000;
        if (jSONObject.length() > 1000) {
            f.V.e(f.U, "Warning: too many properties (more than 1000), ignoring");
            return new JSONObject();
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object item = keys.next();
            try {
                Object obj = jSONObject.get(item);
                obj2 = String.class;
                jSONObject.put(item, obj);
            } catch (org.json.JSONException jSON) {
                Throwable jSON2 = jSON.toString();
                f.V.b(f.U, jSON2);
            }
        }
        return jSONObject;
    }

    protected void j0() {
        k0(false);
    }

    protected void k0(boolean z) {
        int i;
    }

    void m0() {
        this.H = true;
    }

    protected String n(byte[] bArr) throws UnsupportedEncodingException {
        int i = 0;
        char[] cArr = new char[] {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        char[] cArr2 = new char[bArr.length * 2];
        i = 0;
        while (i < bArr.length) {
            int i5 = bArr[i] & 255;
            int i7 = i * 2;
            cArr2[i7] = cArr[i5 >>> 4];
            i2 = i7 + 1;
            cArr2[i2] = cArr[i5 & 15];
            i = i + 1;
        }
        return new String(cArr2);
    }

    protected boolean n0(String str) {
        if (n.d(str)) {
            f.V.b(f.U, "Argument eventType cannot be null or blank in logEvent()");
            return false;
        }
        return o("logEvent()");
    }

    protected synchronized boolean o(String str) {
        final boolean z2 = false;
        StringBuilder stringBuilder = new StringBuilder();
        String str5 = "context cannot be null, set context with initialize() before calling ";
        str7 = str5 + str;
        f.V.b(f.U, str7);
        StringBuilder stringBuilder2 = new StringBuilder();
        String str6 = "apiKey cannot be null or empty, set apiKey with initialize() before calling ";
        str8 = str6 + str;
        f.V.b(f.U, str8);
        return true;
    }

    public f p(Application application) {
        if (!this.H) {
            if (o("enableForegroundTracking()")) {
                int i = 14;
                if (Build.VERSION.SDK_INT >= 14) {
                    application.registerActivityLifecycleCallbacks(new e(this));
                }
            }
        }
        return this;
    }

    protected long q() {
        return System.currentTimeMillis();
    }

    long t() {
        this.t++;
        this.c.Y("sequence_number", Long.valueOf(l2));
        return this.t;
    }

    public void u(l lVar) {
        v(lVar, false);
    }

    public void v(l lVar, boolean z) {
        if (lVar != null) {
            if (lVar.a.length() != 0) {
                if (o("identify()")) {
                    JSONObject jSONObject = null;
                    JSONObject jSONObject2 = null;
                    JSONObject jSONObject4 = null;
                    JSONObject jSONObject5 = null;
                    str = "$identify";
                    this.M(str, jSONObject, jSONObject2, lVar.a, jSONObject4, jSONObject5, q(), z);
                }
            }
        }
    }

    public f x(Context context, String str) {
        y(context, str, null);
        return this;
    }

    public f y(Context context, String str, String str2) {
        this.z(context, str, str2, null, false);
        return this;
    }

    public synchronized f z(Context context, String str, String str2, String str3, boolean z) {
        this.C(context, str, str2, str3, z, null);
        return this;
    }

    public f(String str) {
        super();
        boolean z = false;
        this.h = z;
        this.i = z;
        this.j = z;
        this.k = z;
        this.l = z;
        this.m = z;
        com.amplitude.api.m mVar = new m();
        this.n = mVar;
        com.amplitude.api.m mVar2 = m.a(mVar);
        this.o = mVar2;
        this.p = mVar2.c();
        boolean z2 = true;
        this.q = z2;
        long l = -1L;
        this.s = l;
        this.t = 0L;
        this.u = l;
        this.v = l;
        this.w = l;
        this.x = l;
        this.z = 30;
        int i3 = 50;
        this.A = i3;
        this.B = 1000;
        this.C = 30000L;
        this.D = 300000L;
        this.E = 1800000L;
        this.F = z;
        this.G = i3;
        this.H = z;
        this.I = z;
        this.J = z;
        this.K = z2;
        this.L = "amplitude-android";
        this.M = "2.32.1";
        this.N = z;
        this.O = new AtomicBoolean(z);
        this.P = new AtomicBoolean(z);
        this.Q = "https://api2.amplitude.com/";
        this.R = null;
        this.S = new o("logThread");
        this.T = new o("httpThread");
        this.e = n.e(str);
        this.S.start();
        this.T.start();
    }

    public /* synthetic */ void F(Call.Factory factory, String str, f fVar) {
        E(factory, str, fVar);
    }
}
