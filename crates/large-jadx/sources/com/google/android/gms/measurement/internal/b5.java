package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.internal.measurement.o1;
import com.google.android.gms.internal.measurement.rc;
import com.google.android.gms.internal.measurement.uc;
import com.google.android.gms.internal.measurement.w6;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b5 implements com.google.android.gms.measurement.internal.x5 {

    private static volatile com.google.android.gms.measurement.internal.b5 H;
    private volatile Boolean A;
    protected Boolean B;
    protected Boolean C;
    private volatile boolean D = true;
    private int E;
    private final AtomicInteger F;
    final long G;
    private final Context a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final com.google.android.gms.measurement.internal.b f;
    private final com.google.android.gms.measurement.internal.g g;
    private final com.google.android.gms.measurement.internal.g4 h;
    private final com.google.android.gms.measurement.internal.q3 i;
    private final com.google.android.gms.measurement.internal.y4 j;
    private final com.google.android.gms.measurement.internal.m9 k;
    private final com.google.android.gms.measurement.internal.ia l;
    private final com.google.android.gms.measurement.internal.l3 m;
    private final e n;
    private final com.google.android.gms.measurement.internal.w7 o;
    private final com.google.android.gms.measurement.internal.i7 p;
    private final com.google.android.gms.measurement.internal.d2 q;
    private final com.google.android.gms.measurement.internal.m7 r;
    private final String s;
    private com.google.android.gms.measurement.internal.j3 t;
    private com.google.android.gms.measurement.internal.w8 u;
    private com.google.android.gms.measurement.internal.o v;
    private com.google.android.gms.measurement.internal.h3 w;
    private boolean x = false;
    private Boolean y;
    private long z;
    b5(com.google.android.gms.measurement.internal.f6 f6) {
        int i2;
        Object str;
        boolean applicationContext;
        Object o1Var;
        long currentTimeMillis;
        Bundle bundle;
        o1 g7Var;
        boolean z;
        int i;
        super();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.F = atomicInteger;
        r.j(f6);
        Context context = f6.a;
        b bVar = new b(context);
        this.f = bVar;
        z2.a = bVar;
        this.a = context;
        this.b = f6.b;
        this.c = f6.c;
        this.d = f6.d;
        this.e = f6.h;
        this.A = f6.e;
        this.s = f6.j;
        o1Var = f6.g;
        bundle = o1Var.y;
        Object obj = bundle.get("measurementEnabled");
        if (o1Var != null && bundle != null && obj instanceof Boolean) {
            bundle = o1Var.y;
            if (bundle != null) {
                obj = bundle.get("measurementEnabled");
                if (obj instanceof Boolean) {
                    this.B = (Boolean)obj;
                }
                o1Var = o1Var.y.get("measurementDeactivated");
                if (o1Var instanceof Boolean) {
                    this.C = (Boolean)o1Var;
                }
            }
        }
        w6.d(context);
        e eVar = h.b();
        this.n = eVar;
        Long num = f6.i;
        if (num != null) {
            currentTimeMillis = num.longValue();
        } else {
            currentTimeMillis = eVar.currentTimeMillis();
        }
        this.G = currentTimeMillis;
        g gVar = new g(this);
        this.g = gVar;
        g4 g4Var = new g4(this);
        g4Var.l();
        this.h = g4Var;
        q3 q3Var3 = new q3(this);
        q3Var3.l();
        this.i = q3Var3;
        ia iaVar = new ia(this);
        iaVar.l();
        this.l = iaVar;
        e6 e6Var = new e6(f6, this);
        l3 l3Var = new l3(e6Var);
        this.m = l3Var;
        d2 d2Var = new d2(this);
        this.q = d2Var;
        w7 w7Var = new w7(this);
        w7Var.j();
        this.o = w7Var;
        i7 i7Var = new i7(this);
        i7Var.j();
        this.p = i7Var;
        m9 m9Var = new m9(this);
        m9Var.j();
        this.k = m9Var;
        m7 m7Var = new m7(this);
        m7Var.l();
        this.r = m7Var;
        y4 y4Var = new y4(this);
        y4Var.l();
        this.j = y4Var;
        g7Var = f6.g;
        if (g7Var != null && Long.compare(l, i) != 0) {
            if (Long.compare(l, i) != 0) {
            } else {
                i2 = applicationContext;
            }
        } else {
        }
        if (applicationContext2 instanceof Application) {
            str = I();
            applicationContext = b5Var3.a.getApplicationContext();
            if (applicationContext3 instanceof Application && str.c == null) {
                applicationContext = b5Var3.a.getApplicationContext();
                if (str.c == null) {
                    g7Var = new g7(str, 0);
                    str.c = g7Var;
                }
                if (i2 != 0) {
                    (Application)(Application)applicationContext.unregisterActivityLifecycleCallbacks(str.c);
                    applicationContext.registerActivityLifecycleCallbacks(str.c);
                    str.a.b().v().a("Registered activity lifecycle callback");
                }
            }
        } else {
            b().w().a("Application context is not an Application");
        }
        a5 a5Var = new a5(this, f6);
        y4Var.z(a5Var);
    }

    public static com.google.android.gms.measurement.internal.b5 H(Context context, o1 o12, Long long3) {
        String o1Var;
        com.google.android.gms.measurement.internal.b5 b5Var;
        o1 f6Var;
        long l;
        long l2;
        boolean z;
        String str;
        int i2;
        int i3;
        Bundle bundle;
        int i;
        Object obj12;
        Object obj13;
        Object obj14;
        if (o12 != null) {
            if (o12.w != null) {
                if (o12.x == null) {
                    super(o12.a, obj3, o12.b, obj5, o12.c, o12.v, 0, 0, o12.y, 0);
                    obj13 = o1Var;
                }
            } else {
            }
        }
        r.j(context);
        r.j(context.getApplicationContext());
        if (b5.H == null) {
            b5Var = b5.class;
            synchronized (b5Var) {
                f6Var = new f6(context, obj13, long3);
                obj12 = new b5(f6Var);
                b5.H = obj12;
            }
        } else {
            obj12 = obj13.y;
            if (obj13 != null && obj12 != null && obj12.containsKey("dataCollectionDefaultEnabled")) {
                obj12 = obj13.y;
                if (obj12 != null) {
                    if (obj12.containsKey("dataCollectionDefaultEnabled")) {
                        r.j(b5.H);
                        obj12.A = Boolean.valueOf(obj13.y.getBoolean("dataCollectionDefaultEnabled"));
                    }
                }
            }
        }
        r.j(b5.H);
        return b5.H;
    }

    static void e(com.google.android.gms.measurement.internal.b5 b5, com.google.android.gms.measurement.internal.f6 f62) {
        boolean empty;
        int valueOf;
        String valueOf2;
        String length;
        Object obj4;
        b5.a().h();
        b5.g.w();
        o oVar = new o(b5);
        oVar.l();
        b5.v = oVar;
        h3 h3Var = new h3(b5, f62.f, obj2);
        h3Var.j();
        b5.w = h3Var;
        obj4 = new j3(b5);
        obj4.j();
        b5.t = obj4;
        obj4 = new w8(b5);
        obj4.j();
        b5.u = obj4;
        b5.l.m();
        b5.h.m();
        b5.w.k();
        b5.g.q();
        b5.b().u().b("App measurement initialized, version", Long.valueOf(46000));
        b5.b().u().a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        obj4 = h3Var.s();
        if (TextUtils.isEmpty(b5.b)) {
            if (b5.N().S(obj4)) {
                b5.b().u().a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                obj4 = String.valueOf(obj4);
                valueOf2 = "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ";
                if (obj4.length() != 0) {
                    obj4 = valueOf2.concat(obj4);
                } else {
                    obj4 = new String(valueOf2);
                }
                b5.b().u().a(obj4);
            }
        }
        b5.b().q().a("Debug-level message logging enabled");
        if (b5.E != b5.F.get()) {
            b5.b().r().c("Not all components initialized", Integer.valueOf(b5.E), Integer.valueOf(b5.F.get()));
        }
        b5.x = true;
    }

    static final void t() {
        IllegalStateException illegalStateException = new IllegalStateException("Unexpected call on client side");
        throw illegalStateException;
    }

    private static final void u(com.google.android.gms.measurement.internal.v5 v5) {
        if (v5 == null) {
        } else {
        }
        IllegalStateException obj1 = new IllegalStateException("Component not created");
        throw obj1;
    }

    private static final void v(com.google.android.gms.measurement.internal.f4 f4) {
        if (f4 == null) {
        } else {
            if (!f4.m()) {
            } else {
            }
            String obj2 = String.valueOf(f4.getClass());
            String.valueOf(obj2).length();
            IllegalStateException illegalStateException = new IllegalStateException("Component not initialized: ".concat(String.valueOf(obj2)));
            throw illegalStateException;
        }
        obj2 = new IllegalStateException("Component not created");
        throw obj2;
    }

    private static final void w(com.google.android.gms.measurement.internal.w5 w5) {
        if (w5 == null) {
        } else {
            if (!w5.n()) {
            } else {
            }
            String obj2 = String.valueOf(w5.getClass());
            String.valueOf(obj2).length();
            IllegalStateException illegalStateException = new IllegalStateException("Component not initialized: ".concat(String.valueOf(obj2)));
            throw illegalStateException;
        }
        obj2 = new IllegalStateException("Component not created");
        throw obj2;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.o A() {
        b5.w(this.v);
        return this.v;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.h3 B() {
        b5.v(this.w);
        return this.w;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.j3 C() {
        b5.v(this.t);
        return this.t;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.l3 D() {
        return this.m;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.q3 E() {
        com.google.android.gms.measurement.internal.q3 q3Var;
        q3Var = this.i;
        if (q3Var != null && q3Var.n()) {
            if (q3Var.n()) {
                return this.i;
            }
        }
        return null;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.g4 F() {
        b5.u(this.h);
        return this.h;
    }

    @SideEffectFree
    final com.google.android.gms.measurement.internal.y4 G() {
        return this.j;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.i7 I() {
        b5.v(this.p);
        return this.p;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.m7 J() {
        b5.w(this.r);
        return this.r;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.w7 K() {
        b5.v(this.o);
        return this.o;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.w8 L() {
        b5.v(this.u);
        return this.u;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.m9 M() {
        b5.v(this.k);
        return this.k;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.ia N() {
        b5.u(this.l);
        return this.l;
    }

    @Pure
    public final String O() {
        return this.b;
    }

    @Pure
    public final String P() {
        return this.c;
    }

    @Pure
    public final String Q() {
        return this.d;
    }

    @Pure
    public final String R() {
        return this.s;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.y4 a() {
        b5.w(this.j);
        return this.j;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.q3 b() {
        b5.w(this.i);
        return this.i;
    }

    @Pure
    public final e c() {
        return this.n;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.b d() {
        return this.f;
    }

    @Pure
    public final Context f() {
        return this.a;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void g() {
        this.F.incrementAndGet();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void h(String string, int i2, Throwable throwable3, byte[] b4Arr4, Map map5) {
        boolean intent;
        String doubleToRawLongBits;
        int i3;
        int i;
        Uri parse;
        String obj7;
        int obj8;
        com.google.android.gms.measurement.internal.ia obj9;
        boolean obj10;
        String obj11;
        obj7 = "timestamp";
        obj11 = "gclid";
        String str = "";
        final String str2 = "deeplink";
        int i4 = 304;
        if (i2 != 200 && i2 != 204) {
            if (i2 != 204) {
                if (i2 == i4) {
                    obj8 = i4;
                    obj8.r.a(true);
                    if (throwable3 == null && b4Arr4 != null) {
                        obj8.r.a(true);
                        if (b4Arr4 != null) {
                            if (b4Arr4.length == 0) {
                            } else {
                                obj8 = new String(b4Arr4);
                                obj9 = new JSONObject(obj8);
                                obj8 = obj9.optString(str2, str);
                                obj10 = obj9.optString(obj11, str);
                                if (TextUtils.isEmpty(obj8)) {
                                    b().q().a("Deferred Deep Link is empty.");
                                }
                                obj9 = N();
                                com.google.android.gms.measurement.internal.b5 b5Var = obj9.a;
                                if (TextUtils.isEmpty(obj8)) {
                                } else {
                                    intent = new Intent("android.intent.action.VIEW", Uri.parse(obj8));
                                    i = 0;
                                    obj9 = obj9.a.getPackageManager().queryIntentActivities(intent, i);
                                    if (obj9 != null && !obj9.isEmpty()) {
                                        if (!obj9.isEmpty()) {
                                            obj9 = new Bundle();
                                            obj9.putString(obj11, obj10);
                                            obj9.putString("_cis", "ddp");
                                            this.p.u("auto", "_cmp", obj9);
                                            obj9 = N();
                                            if (TextUtils.isEmpty(obj8)) {
                                            } else {
                                                obj10 = obj10.a.getSharedPreferences("google.analytics.deferred.deeplink.prefs", i).edit();
                                                obj10.putString(str2, obj8);
                                                obj10.putLong(obj7, Double.doubleToRawLongBits(obj9.optDouble(obj7, 0)));
                                                if (obj10.commit()) {
                                                    obj7 = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
                                                    obj8.a.sendBroadcast(obj7);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            b().w().c("Deferred Deep Link validation failed. gclid, deep link", obj10, obj8);
                        }
                        b().q().a("Deferred Deep Link response empty.");
                    }
                }
            } else {
            }
        } else {
        }
        b().w().c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(obj8), throwable3);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void i() {
        this.E = i++;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final void j() {
        Object iaVar;
        int i;
        Object systemService;
        boolean booleanValue;
        int activeNetworkInfo;
        int i3;
        Object obj;
        int i4;
        com.google.android.gms.measurement.internal.z4 z4Var;
        int i2;
        com.google.android.gms.measurement.internal.y4 y4Var;
        com.google.android.gms.measurement.internal.l7 l7Var;
        a().h();
        b5.w(J());
        String str = B().s();
        android.util.Pair pair = F().p(str);
        if (this.g.A() && !(Boolean)pair.second.booleanValue()) {
            if (!(Boolean)pair.second.booleanValue()) {
                if (TextUtils.isEmpty((CharSequence)pair.first)) {
                } else {
                    com.google.android.gms.measurement.internal.m7 m7Var2 = J();
                    m7Var2.k();
                    systemService = b5Var2.a.getSystemService("connectivity");
                    activeNetworkInfo = 0;
                    if ((ConnectivityManager)systemService != null) {
                        activeNetworkInfo = (ConnectivityManager)systemService.getActiveNetworkInfo();
                    }
                    b5Var3.g.q();
                    i3 = 46000;
                    java.net.URL url = N().r(i3, i3, str, (String)pair.first);
                    if (activeNetworkInfo != 0 && activeNetworkInfo.isConnected() && url != null) {
                        if (activeNetworkInfo.isConnected()) {
                            b5Var3.g.q();
                            i3 = 46000;
                            url = N().r(i3, i3, str, (String)pair.first);
                            if (url != null) {
                                i = J();
                                z4Var = new z4(this);
                                i.h();
                                i.k();
                                r.j(url);
                                r.j(z4Var);
                                super(i, str, url, 0, 0, z4Var, 0);
                                i.a.a().y(l7Var);
                            }
                        }
                    }
                }
                b().w().a("Network is not available for Deferred Deep Link request. Skipping");
            }
        }
        b().q().a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void k(boolean z) {
        this.A = Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final void l(boolean z) {
        a().h();
        this.D = z;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    protected final void m(o1 o1) {
        com.google.android.gms.measurement.internal.h hVar;
        long str4;
        String str3;
        String str2;
        boolean z2;
        String str;
        com.google.android.gms.measurement.internal.h equals;
        boolean empty;
        String str5;
        int i;
        Object string;
        String str6;
        boolean z;
        com.google.android.gms.measurement.internal.i7 obj11;
        a().h();
        hVar = F().q();
        com.google.android.gms.measurement.internal.g4 g4Var5 = F();
        com.google.android.gms.measurement.internal.b5 b5Var = g4Var5.a;
        g4Var5.h();
        equals = g4Var5.o().getInt("consent_source", 100);
        com.google.android.gms.measurement.internal.g gVar3 = this.g;
        com.google.android.gms.measurement.internal.b5 b5Var2 = gVar3.a;
        empty = gVar3.t("google_analytics_default_allow_ad_storage");
        com.google.android.gms.measurement.internal.g gVar4 = this.g;
        com.google.android.gms.measurement.internal.b5 b5Var3 = gVar4.a;
        string = gVar4.t("google_analytics_default_allow_analytics_storage");
        str6 = -10;
        final int i3 = 30;
        final int i4 = 0;
        if (empty == null) {
            if (string != null && F().w(str6)) {
                if (F().w(str6)) {
                    obj11 = new h(empty, string);
                    i = str6;
                } else {
                    if (!TextUtils.isEmpty(B().u())) {
                        if (equals != 0 && equals != i3 && equals != 10 && equals != i3 && equals != i3) {
                            if (equals != i3) {
                                if (equals != 10) {
                                    if (equals != i3) {
                                        if (equals != i3) {
                                            if (equals == 40) {
                                                I().G(h.c, str6, this.G);
                                                obj11 = i4;
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (obj11 != null) {
            I().G(obj11, i, this.G);
            hVar = obj11;
        }
        I().K(hVar);
        if (Long.compare(str4, str5) == 0) {
            equals = "Persisting first open";
            b().v().b(equals, Long.valueOf(this.G));
            obj11.e.b(this.G);
        }
        obj11.n.c();
        if (!r()) {
            if (o() && !N().R("android.permission.INTERNET")) {
                if (!N().R("android.permission.INTERNET")) {
                    b().r().a("App is missing INTERNET permission");
                }
                if (!N().R("android.permission.ACCESS_NETWORK_STATE")) {
                    b().r().a("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!c.a(this.a).f() && !this.g.G() && !ia.X(this.a)) {
                    if (!this.g.G()) {
                        if (!ia.X(this.a)) {
                            b().r().a("AppMeasurementReceiver not registered/enabled");
                        }
                        if (!ia.Y(this.a, false)) {
                            b().r().a("AppMeasurementService not registered/enabled");
                        }
                    }
                }
                b().r().a("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (TextUtils.isEmpty(B().u())) {
                com.google.android.gms.measurement.internal.g4 g4Var7 = F();
                g4Var7.h();
                str5 = "gmp_app_id";
                com.google.android.gms.measurement.internal.g4 g4Var8 = F();
                g4Var8.h();
                str6 = "admob_app_id";
                b().u().a("Rechecking which service to use due to a GMP App Id change");
                obj11 = F();
                obj11.h();
                Boolean bool = obj11.r();
                equals = obj11.o().edit();
                equals.clear();
                equals.apply();
                if (!TextUtils.isEmpty(B().r()) && N().b0(B().u(), g4Var7.o().getString(str5, i4), B().r(), g4Var8.o().getString(str6, i4)) && bool != null) {
                    g4Var7 = F();
                    g4Var7.h();
                    str5 = "gmp_app_id";
                    g4Var8 = F();
                    g4Var8.h();
                    str6 = "admob_app_id";
                    if (N().b0(B().u(), g4Var7.o().getString(str5, i4), B().r(), g4Var8.o().getString(str6, i4))) {
                        b().u().a("Rechecking which service to use due to a GMP App Id change");
                        obj11 = F();
                        obj11.h();
                        bool = obj11.r();
                        equals = obj11.o().edit();
                        equals.clear();
                        equals.apply();
                        if (bool != null) {
                            obj11.s(bool);
                        }
                        C().q();
                        this.u.Q();
                        this.u.P();
                        obj11.e.b(this.G);
                        obj11.g.b(i4);
                    }
                    obj11 = F();
                    obj11.h();
                    obj11 = obj11.o().edit();
                    obj11.putString(str5, B().u());
                    obj11.apply();
                    obj11 = F();
                    obj11.h();
                    obj11 = obj11.o().edit();
                    obj11.putString(str6, B().r());
                    obj11.apply();
                }
            } else {
            }
            if (!F().q().k()) {
                obj11.g.b(i4);
            }
            I().C(g4Var2.g.a());
            rc.b();
            if (this.g.B(i4, c3.i0)) {
                obj11.a.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            }
            if (TextUtils.isEmpty(B().u())) {
                obj11 = o();
                if (!TextUtils.isEmpty(B().r()) && !F().u() && !this.g.E()) {
                    obj11 = o();
                    if (!F().u()) {
                        if (!this.g.E()) {
                            F().t(obj11 ^ 1);
                        }
                    }
                    if (obj11 != null) {
                        I().g0();
                    }
                    obj11.d.a();
                    AtomicReference atomicReference = new AtomicReference();
                    L().S(atomicReference);
                    L().v(g4Var4.w.a());
                }
            } else {
            }
        }
        obj11.n.a(true);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final boolean n() {
        Boolean booleanValue;
        if (this.A != null && this.A.booleanValue()) {
            if (this.A.booleanValue()) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final boolean o() {
        if (x() == 0) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final boolean p() {
        a().h();
        return this.D;
    }

    @Pure
    public final boolean q() {
        return TextUtils.isEmpty(this.b);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    protected final boolean r() {
        Boolean booleanValue;
        boolean z;
        int i;
        boolean empty;
        int cmp;
        int i2;
        int str2;
        String str3;
        String str;
        if (!this.x) {
        } else {
            a().h();
            booleanValue = this.y;
            cmp = Long.compare(l4, str2);
            if (booleanValue != null && cmp != 0) {
                cmp = Long.compare(l4, str2);
                if (cmp != 0) {
                    if (!booleanValue.booleanValue() && Long.compare(l2, i2) > 0) {
                        if (Long.compare(l2, i2) > 0) {
                            this.z = this.n.a();
                            i2 = 0;
                            if (N().R("android.permission.INTERNET") && N().R("android.permission.ACCESS_NETWORK_STATE")) {
                                if (N().R("android.permission.ACCESS_NETWORK_STATE")) {
                                    if (!c.a(this.a).f() && !this.g.G()) {
                                        if (!this.g.G()) {
                                            if (ia.X(this.a) && ia.Y(this.a, i2)) {
                                                i = ia.Y(this.a, i2) ? cmp : i2;
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                            Boolean valueOf = Boolean.valueOf(i);
                            this.y = valueOf;
                            if (valueOf.booleanValue() && !N().K(B().u(), B().r(), B().t())) {
                                if (!N().K(B().u(), B().r(), B().t())) {
                                    if (!TextUtils.isEmpty(B().r())) {
                                    } else {
                                        cmp = i2;
                                    }
                                }
                                this.y = Boolean.valueOf(cmp);
                            }
                        }
                    }
                } else {
                }
            } else {
            }
            return this.y.booleanValue();
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppMeasurement is not initialized");
        throw illegalStateException;
    }

    @Pure
    public final boolean s() {
        return this.e;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final int x() {
        Boolean booleanValue;
        boolean z;
        a().h();
        if (this.g.E()) {
            return 1;
        }
        booleanValue = this.C;
        if (booleanValue != null && !booleanValue.booleanValue()) {
            if (!booleanValue.booleanValue()) {
            }
            return 2;
        }
        a().h();
        if (!this.D) {
            return 8;
        }
        Boolean bool = F().r();
        final int i8 = 0;
        if (bool != null && bool.booleanValue()) {
            if (bool.booleanValue()) {
                return i8;
            }
            return 3;
        }
        com.google.android.gms.measurement.internal.g gVar2 = this.g;
        com.google.android.gms.measurement.internal.b bVar = b5Var.f;
        Boolean bool2 = gVar2.t("firebase_analytics_collection_enabled");
        if (bool2 != null && bool2.booleanValue()) {
            if (bool2.booleanValue()) {
                return i8;
            }
            return 4;
        }
        Boolean bool3 = this.B;
        if (bool3 != null && bool3.booleanValue()) {
            if (bool3.booleanValue()) {
                return i8;
            }
            return 5;
        }
        if (this.g.B(0, c3.T) && this.A != null && this.A.booleanValue()) {
            if (this.A != null) {
                if (this.A.booleanValue()) {
                    return i8;
                }
                return 7;
            }
        }
        return i8;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.d2 y() {
        com.google.android.gms.measurement.internal.d2 d2Var = this.q;
        if (d2Var == null) {
        } else {
            return d2Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Component not created");
        throw illegalStateException;
    }

    @Pure
    public final com.google.android.gms.measurement.internal.g z() {
        return this.g;
    }
}
