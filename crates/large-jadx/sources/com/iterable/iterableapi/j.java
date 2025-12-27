package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableApi.java */
/* loaded from: classes2.dex */
public class j {

    static volatile j p;
    private Context a;
    q b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    k j = new k();
    private f0 k;
    private String l;
    private p m;
    private HashMap<String, String> n = new HashMap<>();
    private final i.c o = new j$c();

    class b implements Runnable {

        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String v;
        final /* synthetic */ String w;
        final /* synthetic */ HashMap x;
        final /* synthetic */ j y;
        b(String str, String str2, String str3, String str4, String str5, HashMap map) {
            this.y = jVar;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.v = str4;
            this.w = str5;
            this.x = map;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.G(this.a, this.b, this.c, this.v, this.w, null, this.x);
        }
    }

    class a implements v {
        a() {
            super();
        }

        public void a(String str) {
            final String str2 = "offlineModeBeta";
            if (str == null) {
                j0.c("IterableApi", "Remote configuration returned null");
                return;
            }
            try {
                boolean _boolean = new JSONObject(str).getBoolean(str2);
                j.p.j.p(_boolean);
                SharedPreferences.Editor edit = j.p.t().getSharedPreferences("itbl_saved_configuration", 0).edit();
                edit.putBoolean(str2, _boolean);
                edit.apply();
            } catch (org.json.JSONException unused) {
                str = "Failed to read remote configuration";
                j0.c(str3, str);
            }
        }
    }

    class c implements i.c {

        final /* synthetic */ j a;
        c() {
            this.a = jVar;
            super();
        }

        public void d() {
            this.a.C();
        }

        public void a() {
        }
    }

    private class d implements k.a {

        final /* synthetic */ j a;
        private d() {
            this.a = jVar;
            super();
        }

        public String a() {
            return this.a.p();
        }

        public String b() {
            return this.a.f;
        }

        public String c() {
            return this.a.c;
        }

        public Context getContext() {
            return this.a.a;
        }

        public String getEmail() {
            return this.a.d;
        }

        public String getUserId() {
            return this.a.e;
        }

        /* synthetic */ d(j.a aVar) {
            this(jVar);
        }
    }
    static {
        j.p = new j();
    }

    j() {
        super();
        com.iterable.iterableapi.k kVar = new k(new j.d(this, null));
        HashMap hashMap = new HashMap();
        com.iterable.iterableapi.j.c cVar = new j.c(this);
        this.b = new q.b().l();
    }

    private boolean A() {
        boolean z = true;
        if (this.c == null || this.d == null) {
            int i2 = 0;
        } else {
            int r0 = this.e != null ? 1 : 0;
        }
        return (this.e != null ? 1 : 0);
    }

    static void B(Context context) {
        final int i = 0;
        j.p.j.p(context.getSharedPreferences("itbl_saved_configuration", i).getBoolean("offlineModeBeta", false));
    }

    private void C() {
        boolean z;
        String str;
        if (!this.i) {
            this.i = true;
            if (j.p.b.d && j.p.A()) {
                str = "Performing automatic push registration";
                j0.a("IterableApi", str);
                j.p.H();
            }
            l();
        }
    }

    private void D() {
        if (!A()) {
            return;
        }
        if (this.b.d) {
            H();
        }
        q().I();
    }

    private void E() {
        if (this.b.d && this.A()) {
            j();
        }
        q().B();
        m().d();
        this.j.j();
    }

    private void I() {
        try {
            SharedPreferences sharedPreferences = v();
            String str2 = null;
            this.d = sharedPreferences.getString("itbl_email", str2);
            this.e = sharedPreferences.getString("itbl_userid", str2);
            str = "itbl_authtoken";
            String string = sharedPreferences.getString(str, str2);
            this.f = string;
            m().g(this.f);
        } catch (Exception e) {
            j0.d("IterableApi", "Error while retrieving email/userId/authToken", e);
        }
    }

    private void R() {
        try {
            SharedPreferences.Editor edit = v().edit();
            edit.putString("itbl_email", this.d);
            edit.putString("itbl_userid", this.e);
            str = "itbl_authtoken";
            edit.putString(str, this.f);
            edit.commit();
        } catch (Exception e) {
            j0.d("IterableApi", "Error while persisting email/userId", e);
        }
    }

    static /* synthetic */ String a(j jVar) {
        return jVar.d;
    }

    static /* synthetic */ void b(j jVar) {
        jVar.C();
    }

    static /* synthetic */ String c(j jVar) {
        return jVar.e;
    }

    static /* synthetic */ String d(j jVar) {
        return jVar.f;
    }

    static /* synthetic */ String e(j jVar) {
        return jVar.c;
    }

    static /* synthetic */ String f(j jVar) {
        return jVar.p();
    }

    static /* synthetic */ Context g(j jVar) {
        return jVar.a;
    }

    private boolean h() {
        if (!A()) {
            j0.c("IterableApi", "Iterable SDK must be initialized with an API key and user email/userId before calling SDK methods");
            return false;
        }
        return true;
    }

    private String p() {
        if (this.h == null) {
            String str = null;
            str2 = "itbl_deviceid";
            String string = v().getString(str2, str);
            this.h = string;
            if (string == null) {
                this.h = UUID.randomUUID().toString();
                v().edit().putString(str2, this.h).apply();
            }
        }
        return this.h;
    }

    public static j s() {
        return j.p;
    }

    static String u(Context context) {
        final String str = "iterable_notification_icon";
        return context.getSharedPreferences(str, 0).getString(str, "");
    }

    private SharedPreferences v() {
        return this.a.getSharedPreferences("com.iterable.iterableapi", 0);
    }

    private String w() {
        if (this.b.a != null) {
            return this.b.a;
        }
        return this.a.getPackageName();
    }

    public static void z(Context context, String str, q qVar) {
        j.p.a = context.getApplicationContext();
        j.p.c = str;
        j.p.b = qVar;
        if (j.p.b == null) {
            j.p.b = new q.b().l();
        }
        j.p.I();
        i.l().n(context);
        i.l().j(j.p.o);
        if (j.p.k == null) {
            j.p.k = new f0(j.p, j.p.b.f, j.p.b.g, r3);
        }
        j.B(context);
        p0.f(context);
    }

    protected void F(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) throws java.lang.IllegalThreadStateException {
        if (str5 != null) {
            j.b bVar = new j.b(this, str, str2, str3, str4, str5, hashMap);
            new Thread(bVar).start();
        }
    }

    protected void G(String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, HashMap<String, String> hashMap) {
        if (!h()) {
            return;
        }
        String str8 = "IterableApi";
        if (str5 == null) {
            j0.c(str8, "registerDeviceToken: token is null");
            return;
        }
        if (str4 == null) {
            str6 = "registerDeviceToken: applicationName is null, check that pushIntegrationName is set in IterableConfig";
            j0.c(str8, str6);
        }
        this.j.k(str, str2, str3, str4, str5, jSONObject, hashMap);
    }

    public void H() {
        if (!h()) {
            return;
        }
        r0 r0Var = new r0(this.d, this.e, this.f, w(), r0.a.ENABLE);
        q0.a(r0Var);
    }

    void J(n nVar) {
        if (this.a == null) {
            j0.c("IterableApi", "setAttributionInfo: Iterable SDK is not initialized with a context.");
            return;
        }
        z0.l(v(), "itbl_attribution_info", nVar.a(), 86400000L);
    }

    void K(String str) {
        L(str, false);
    }

    void L(String str, boolean z) {
        String str2;
        boolean equalsIgnoreCase;
        if (A() && str != null) {
            if (!str.equalsIgnoreCase(this.f) || !(this.f == null && this.f.equalsIgnoreCase(str))) {
                this.f = str;
                R();
                D();
            } else {
                if (z) {
                    D();
                }
            }
        }
    }

    public void M(String str) {
        this.l = str;
    }

    void N(m0 m0Var) {
        if (m0Var != null) {
            J(new n(m0Var.c(), m0Var.g(), m0Var.f()));
        }
    }

    void O(Intent intent) {
        final Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("itbl") && !n0.d(extras)) {
                P(extras);
            }
        }
    }

    public void Q(String str) {
        if (this.e != null && this.e.equals(str)) {
            return;
        }
        if (this.d == null && this.e == null && str == null) {
            return;
        }
        E();
        String str4 = null;
        this.d = str4;
        this.e = str;
        R();
        if (str != null) {
            m().i(false);
        } else {
            K(str4);
        }
    }

    public void S(String str, int i, int i2, JSONObject jSONObject) {
        j0.g();
        if (!h()) {
            return;
        }
        this.j.q(str, i, i2, jSONObject);
    }

    public void T(String str, JSONObject jSONObject) {
        final int i = 0;
        S(str, i, i, jSONObject);
    }

    public void U(g0 g0Var, String str, e0 e0Var) {
        if (!h()) {
            return;
        }
        if (g0Var == null) {
            j0.c("IterableApi", "trackInAppClick: message is null");
            return;
        }
        this.j.r(g0Var, str, e0Var, this.l);
    }

    public void V(String str, String str2) {
        if (!h()) {
            return;
        }
        this.j.s(str, str2);
    }

    void W(String str, String str2, e0 e0Var) {
        j0.g();
        com.iterable.iterableapi.g0 g0Var = q().k(str);
        if (g0Var != null) {
            U(g0Var, str2, e0Var);
        } else {
            V(str, str2);
        }
    }

    public void X(g0 g0Var, String str, y yVar, e0 e0Var) {
        if (!h()) {
            return;
        }
        if (g0Var == null) {
            j0.c("IterableApi", "trackInAppClose: message is null");
            return;
        }
        this.j.t(g0Var, str, yVar, e0Var, this.l);
    }

    void Y(String str, String str2, y yVar, e0 e0Var) {
        com.iterable.iterableapi.g0 g0Var = q().k(str);
        if (g0Var != null) {
            X(g0Var, str2, yVar, e0Var);
            j0.g();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            str5 = "trackInAppClose: could not find an in-app message with ID: ";
            str3 = str5 + str;
            str4 = "IterableApi";
            j0.i(str4, str3);
        }
    }

    void Z(g0 g0Var) {
        if (!h()) {
            return;
        }
        if (g0Var == null) {
            j0.c("IterableApi", "trackInAppDelivery: message is null");
            return;
        }
        this.j.u(g0Var);
    }

    public void a0(g0 g0Var, e0 e0Var) {
        if (!h()) {
            return;
        }
        if (g0Var == null) {
            j0.c("IterableApi", "trackInAppOpen: message is null");
            return;
        }
        this.j.v(g0Var, e0Var, this.l);
    }

    void b0(String str, e0 e0Var) {
        j0.g();
        com.iterable.iterableapi.g0 g0Var = q().k(str);
        if (g0Var != null) {
            a0(g0Var, e0Var);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "trackInAppOpen: could not find an in-app message with ID: ";
            str2 = str4 + str;
            str3 = "IterableApi";
            j0.i(str3, str2);
        }
    }

    public void c0(i0 i0Var) {
        if (!h()) {
            return;
        }
        String str = "IterableApi";
        if (i0Var == null) {
            j0.c(str, "trackInboxSession: session is null");
            return;
        }
        j0.c(str, "trackInboxSession: sessionStartTime and sessionEndTime must be set");
    }

    protected void d0(int i, int i2, String str, JSONObject jSONObject) {
        if (str == null) {
            j0.c("IterableApi", "messageId is null");
            return;
        }
        this.j.x(i, i2, str, jSONObject);
    }

    public void e0(JSONObject jSONObject) {
        f0(jSONObject, Boolean.FALSE);
    }

    public void f0(JSONObject jSONObject, Boolean boolean) {
        if (!h()) {
            return;
        }
        this.j.y(jSONObject, boolean);
    }

    public void i() {
        this.l = null;
    }

    public void j() {
        r0 r0Var = new r0(this.d, this.e, this.f, w(), r0.a.DISABLE);
        q0.a(r0Var);
    }

    protected void k(String str, String str2, String str3, String str4, x xVar, u uVar) {
        this.j.c(str, str2, str3, str4, xVar, uVar);
    }

    void l() {
        this.j.g(new j.a(this));
    }

    p m() {
        if (this.m == null) {
            this.m = new p(this, qVar.h, qVar.i, r4);
        }
        return this.m;
    }

    boolean n() {
        return this.g;
    }

    HashMap o() {
        return this.n;
    }

    public f0 q() {
        if (this.k == null) {
            throw new RuntimeException("IterableApi must be initialized before calling getInAppManager(). Make sure you call IterableApi#initialize() in Application#onCreate");
        } else {
            return this.k;
        }
    }

    void r(int i, v vVar) {
        if (!h()) {
            return;
        }
        this.j.f(i, vVar);
    }

    Context t() {
        return this.a;
    }

    public void x(g0 g0Var, z zVar, e0 e0Var) {
        if (!h()) {
            return;
        }
        this.j.i(g0Var, zVar, e0Var, this.l);
    }

    public void y(String str) {
        com.iterable.iterableapi.g0 g0Var = q().k(str);
        if (g0Var == null) {
            j0.c("IterableApi", "inAppConsume: message is null");
            return;
        }
        com.iterable.iterableapi.z zVar = null;
        x(g0Var, zVar, zVar);
        j0.g();
    }

    void P(Bundle bundle) {
    }
}
