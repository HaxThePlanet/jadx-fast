package com.iterable.iterableapi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class j {

    static volatile com.iterable.iterableapi.j p;
    private Context a;
    com.iterable.iterableapi.q b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    com.iterable.iterableapi.k j;
    private com.iterable.iterableapi.f0 k;
    private String l;
    private com.iterable.iterableapi.p m;
    private HashMap<String, String> n;
    private final com.iterable.iterableapi.i.c o;

    class b implements Runnable {

        final String a;
        final String b;
        final String c;
        final String v;
        final String w;
        final HashMap x;
        final com.iterable.iterableapi.j y;
        b(com.iterable.iterableapi.j j, String string2, String string3, String string4, String string5, String string6, HashMap hashMap7) {
            this.y = j;
            this.a = string2;
            this.b = string3;
            this.c = string4;
            this.v = string5;
            this.w = string6;
            this.x = hashMap7;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.y.G(this.a, this.b, this.c, this.v, this.w, 0, this.x);
        }
    }

    class a implements com.iterable.iterableapi.v {
        a(com.iterable.iterableapi.j j) {
            super();
        }

        @Override // com.iterable.iterableapi.v
        public void a(String string) {
            boolean obj6;
            final String str = "offlineModeBeta";
            if (string == null) {
                j0.c("IterableApi", "Remote configuration returned null");
            }
            JSONObject jSONObject = new JSONObject(string);
            obj6 = jSONObject.getBoolean(str);
            jVar.j.p(obj6);
            SharedPreferences.Editor edit = j.p.t().getSharedPreferences("itbl_saved_configuration", 0).edit();
            edit.putBoolean(str, obj6);
            edit.apply();
        }
    }

    class c implements com.iterable.iterableapi.i.c {

        final com.iterable.iterableapi.j a;
        c(com.iterable.iterableapi.j j) {
            this.a = j;
            super();
        }

        @Override // com.iterable.iterableapi.i$c
        public void a() {
        }

        @Override // com.iterable.iterableapi.i$c
        public void d() {
            j.b(this.a);
        }
    }

    private class d implements com.iterable.iterableapi.k.a {

        final com.iterable.iterableapi.j a;
        private d(com.iterable.iterableapi.j j) {
            this.a = j;
            super();
        }

        d(com.iterable.iterableapi.j j, com.iterable.iterableapi.j.a j$a2) {
            super(j);
        }

        @Override // com.iterable.iterableapi.k$a
        public String a() {
            return j.f(this.a);
        }

        @Override // com.iterable.iterableapi.k$a
        public String b() {
            return j.d(this.a);
        }

        @Override // com.iterable.iterableapi.k$a
        public String c() {
            return j.e(this.a);
        }

        @Override // com.iterable.iterableapi.k$a
        public Context getContext() {
            return j.g(this.a);
        }

        @Override // com.iterable.iterableapi.k$a
        public String getEmail() {
            return j.a(this.a);
        }

        @Override // com.iterable.iterableapi.k$a
        public String getUserId() {
            return j.c(this.a);
        }
    }
    static {
        j jVar = new j();
        j.p = jVar;
    }

    j() {
        super();
        j.d dVar = new j.d(this, 0);
        k kVar = new k(dVar);
        this.j = kVar;
        HashMap hashMap = new HashMap();
        this.n = hashMap;
        j.c cVar = new j.c(this);
        this.o = cVar;
        q.b bVar = new q.b();
        this.b = bVar.l();
    }

    private boolean A() {
        String str;
        int i;
        if (this.c != null) {
            if (this.d == null) {
                i = this.e != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    static void B(Context context) {
        final int i = 0;
        jVar.j.p(context.getSharedPreferences("itbl_saved_configuration", i).getBoolean("offlineModeBeta", i));
    }

    private void C() {
        boolean z;
        String str;
        this.i = true;
        if (!this.i && qVar.d && j.p.A()) {
            this.i = true;
            if (qVar.d) {
                if (j.p.A()) {
                    j0.a("IterableApi", "Performing automatic push registration");
                    j.p.H();
                }
            }
            l();
        }
    }

    private void D() {
        if (!A()) {
        }
        if (qVar.d) {
            H();
        }
        q().I();
    }

    private void E() {
        boolean z;
        if (qVar.d && A()) {
            if (A()) {
                j();
            }
        }
        q().B();
        m().d();
        this.j.j();
    }

    private void I() {
        Object string;
        String str;
        int i;
        try {
            SharedPreferences sharedPreferences = v();
            i = 0;
            this.d = sharedPreferences.getString("itbl_email", i);
            this.e = sharedPreferences.getString("itbl_userid", i);
            string = sharedPreferences.getString("itbl_authtoken", i);
            this.f = string;
            if (string != null) {
            }
            m().g(this.f);
            j0.d("IterableApi", "Error while retrieving email/userId/authToken", th);
        }
    }

    private void R() {
        SharedPreferences.Editor edit;
        String str2;
        String str;
        try {
            edit = v().edit();
            edit.putString("itbl_email", this.d);
            edit.putString("itbl_userid", this.e);
            edit.putString("itbl_authtoken", this.f);
            edit.commit();
            j0.d("IterableApi", "Error while persisting email/userId", th);
        }
    }

    static String a(com.iterable.iterableapi.j j) {
        return j.d;
    }

    static void b(com.iterable.iterableapi.j j) {
        j.C();
    }

    static String c(com.iterable.iterableapi.j j) {
        return j.e;
    }

    static String d(com.iterable.iterableapi.j j) {
        return j.f;
    }

    static String e(com.iterable.iterableapi.j j) {
        return j.c;
    }

    static String f(com.iterable.iterableapi.j j) {
        return j.p();
    }

    static Context g(com.iterable.iterableapi.j j) {
        return j.a;
    }

    private boolean h() {
        if (!A()) {
            j0.c("IterableApi", "Iterable SDK must be initialized with an API key and user email/userId before calling SDK methods");
            return 0;
        }
        return 1;
    }

    private String p() {
        Object string;
        int i;
        String str;
        str = "itbl_deviceid";
        string = v().getString(str, 0);
        this.h = string;
        if (this.h == null && string == null) {
            str = "itbl_deviceid";
            string = v().getString(str, 0);
            this.h = string;
            if (string == null) {
                this.h = UUID.randomUUID().toString();
                v().edit().putString(str, this.h).apply();
            }
        }
        return this.h;
    }

    public static com.iterable.iterableapi.j s() {
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
        String str = qVar.a;
        if (str != null) {
            return str;
        }
        return this.a.getPackageName();
    }

    public static void z(Context context, String string2, com.iterable.iterableapi.q q3) {
        com.iterable.iterableapi.j jVar;
        Object applicationContext;
        double d;
        Object obj5;
        com.iterable.iterableapi.q obj6;
        jVar2.a = context.getApplicationContext();
        jVar.c = string2;
        obj5.b = q3;
        if (obj5.b == null) {
            obj6 = new q.b();
            obj5.b = obj6.l();
        }
        j.p.I();
        i.l().n(context);
        i.l().j(obj6.o);
        if (obj5.k == null) {
            obj6 = new f0(j.p, qVar.f, qVar2.g, obj3);
            obj5.k = obj6;
        }
        j.B(context);
        p0.f(context);
    }

    protected void F(String string, String string2, String string3, String string4, String string5, HashMap<String, String> hashMap6) {
        com.iterable.iterableapi.j.b bVar2;
        com.iterable.iterableapi.j jVar;
        String str;
        String str5;
        String str3;
        String str4;
        String str2;
        HashMap map;
        Thread thread;
        com.iterable.iterableapi.j.b bVar;
        if (string5 != null) {
            super(this, string, string2, string3, string4, string5, hashMap6);
            thread = new Thread(bVar);
            thread.start();
        }
    }

    protected void G(String string, String string2, String string3, String string4, String string5, JSONObject jSONObject6, HashMap<String, String> hashMap7) {
        String str;
        if (!h()) {
        }
        String str2 = "IterableApi";
        if (string5 == null) {
            j0.c(str2, "registerDeviceToken: token is null");
        }
        if (string4 == null) {
            j0.c(str2, "registerDeviceToken: applicationName is null, check that pushIntegrationName is set in IterableConfig");
        }
        obj.j.k(string, string2, string3, string4, string5, jSONObject6, hashMap7);
    }

    public void H() {
        if (!h()) {
        }
        super(this.d, this.e, this.f, w(), r0.a.ENABLE);
        q0.a(r0Var);
    }

    void J(com.iterable.iterableapi.n n) {
        if (this.a == null) {
            j0.c("IterableApi", "setAttributionInfo: Iterable SDK is not initialized with a context.");
        }
        z0.l(v(), "itbl_attribution_info", n.a(), 86400000);
    }

    void K(String string) {
        L(string, false);
    }

    void L(String string, boolean z2) {
        boolean equalsIgnoreCase;
        if (A()) {
            if (string != null) {
                if (string.equalsIgnoreCase(this.f)) {
                    equalsIgnoreCase = this.f;
                    if (equalsIgnoreCase != null && !equalsIgnoreCase.equalsIgnoreCase(string)) {
                        if (!equalsIgnoreCase.equalsIgnoreCase(string)) {
                            this.f = string;
                            R();
                            D();
                        } else {
                            if (z2) {
                                D();
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    public void M(String string) {
        this.l = string;
    }

    void N(com.iterable.iterableapi.m0 m0) {
        com.iterable.iterableapi.n nVar;
        int i2;
        int i;
        String obj4;
        if (m0 != null) {
            nVar = new n(m0.c(), m0.g(), m0.f());
            J(nVar);
        }
    }

    void O(Intent intent) {
        boolean key;
        final Bundle obj2 = intent.getExtras();
        if (obj2 != null && obj2.containsKey("itbl") && !n0.d(obj2)) {
            if (obj2.containsKey("itbl")) {
                if (!n0.d(obj2)) {
                    P(obj2);
                }
            }
        }
    }

    void P(Bundle bundle) {
    }

    public void Q(String string) {
        String equals;
        String str;
        int i;
        Object obj2;
        equals = this.e;
        if (equals != null && equals.equals(string)) {
            if (equals.equals(string)) {
            }
        }
        if (this.d == null && this.e == null && string == null) {
            if (this.e == null) {
                if (string == null) {
                }
            }
        }
        E();
        i = 0;
        this.d = i;
        this.e = string;
        R();
        if (string != null) {
            m().i(false);
        } else {
            K(i);
        }
    }

    public void S(String string, int i2, int i3, JSONObject jSONObject4) {
        j0.g();
        if (!h()) {
        }
        this.j.q(string, i2, i3, jSONObject4);
    }

    public void T(String string, JSONObject jSONObject2) {
        final int i = 0;
        S(string, i, i, jSONObject2);
    }

    public void U(com.iterable.iterableapi.g0 g0, String string2, com.iterable.iterableapi.e0 e03) {
        if (!h()) {
        }
        if (g0 == null) {
            j0.c("IterableApi", "trackInAppClick: message is null");
        }
        this.j.r(g0, string2, e03, this.l);
    }

    public void V(String string, String string2) {
        if (!h()) {
        }
        this.j.s(string, string2);
    }

    void W(String string, String string2, com.iterable.iterableapi.e0 e03) {
        j0.g();
        com.iterable.iterableapi.g0 g0Var = q().k(string);
        if (g0Var != null) {
            U(g0Var, string2, e03);
        } else {
            V(string, string2);
        }
    }

    public void X(com.iterable.iterableapi.g0 g0, String string2, com.iterable.iterableapi.y y3, com.iterable.iterableapi.e0 e04) {
        if (!h()) {
        }
        if (g0 == null) {
            j0.c("IterableApi", "trackInAppClose: message is null");
        }
        this.j.t(g0, string2, y3, e04, this.l);
    }

    void Y(String string, String string2, com.iterable.iterableapi.y y3, com.iterable.iterableapi.e0 e04) {
        String obj2;
        String obj3;
        Object obj4;
        com.iterable.iterableapi.g0 g0Var = q().k(string);
        if (g0Var != null) {
            X(g0Var, string2, y3, e04);
            j0.g();
        } else {
            obj3 = new StringBuilder();
            obj3.append("trackInAppClose: could not find an in-app message with ID: ");
            obj3.append(string);
            j0.i("IterableApi", obj3.toString());
        }
    }

    void Z(com.iterable.iterableapi.g0 g0) {
        if (!h()) {
        }
        if (g0 == null) {
            j0.c("IterableApi", "trackInAppDelivery: message is null");
        }
        this.j.u(g0);
    }

    public void a0(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.e0 e02) {
        if (!h()) {
        }
        if (g0 == null) {
            j0.c("IterableApi", "trackInAppOpen: message is null");
        }
        this.j.v(g0, e02, this.l);
    }

    void b0(String string, com.iterable.iterableapi.e0 e02) {
        Object str;
        String obj2;
        Object obj3;
        j0.g();
        str = q().k(string);
        if (str != null) {
            a0(str, e02);
        } else {
            obj3 = new StringBuilder();
            obj3.append("trackInAppOpen: could not find an in-app message with ID: ");
            obj3.append(string);
            j0.i("IterableApi", obj3.toString());
        }
    }

    public void c0(com.iterable.iterableapi.i0 i0) {
        java.util.Date date;
        if (!h()) {
        }
        String str = "IterableApi";
        if (i0 == null) {
            j0.c(str, "trackInboxSession: session is null");
        }
        if (i0.a != null && i0.b == null) {
            if (i0.b == null) {
            }
            this.j.w(i0, this.l);
        }
        j0.c(str, "trackInboxSession: sessionStartTime and sessionEndTime must be set");
    }

    protected void d0(int i, int i2, String string3, JSONObject jSONObject4) {
        if (string3 == null) {
            j0.c("IterableApi", "messageId is null");
        }
        this.j.x(i, i2, string3, jSONObject4);
    }

    public void e0(JSONObject jSONObject) {
        f0(jSONObject, Boolean.FALSE);
    }

    public void f0(JSONObject jSONObject, Boolean boolean2) {
        if (!h()) {
        }
        this.j.y(jSONObject, boolean2);
    }

    public void i() {
        this.l = 0;
    }

    public void j() {
        super(this.d, this.e, this.f, w(), r0.a.DISABLE);
        q0.a(r0Var2);
    }

    protected void k(String string, String string2, String string3, String string4, com.iterable.iterableapi.x x5, com.iterable.iterableapi.u u6) {
        this.j.c(string, string2, string3, string4, x5, u6);
    }

    void l() {
        j.a aVar = new j.a(this);
        this.j.g(aVar);
    }

    com.iterable.iterableapi.p m() {
        com.iterable.iterableapi.p pVar;
        com.iterable.iterableapi.q qVar;
        com.iterable.iterableapi.o oVar;
        long l;
        if (this.m == null) {
            qVar = this.b;
            pVar = new p(this, qVar.h, qVar.i, obj4);
            this.m = pVar;
        }
        return this.m;
    }

    boolean n() {
        return this.g;
    }

    HashMap o() {
        return this.n;
    }

    public com.iterable.iterableapi.f0 q() {
        com.iterable.iterableapi.f0 f0Var = this.k;
        if (f0Var == null) {
        } else {
            return f0Var;
        }
        RuntimeException runtimeException = new RuntimeException("IterableApi must be initialized before calling getInAppManager(). Make sure you call IterableApi#initialize() in Application#onCreate");
        throw runtimeException;
    }

    void r(int i, com.iterable.iterableapi.v v2) {
        if (!h()) {
        }
        this.j.f(i, v2);
    }

    Context t() {
        return this.a;
    }

    public void x(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.z z2, com.iterable.iterableapi.e0 e03) {
        if (!h()) {
        }
        this.j.i(g0, z2, e03, this.l);
    }

    public void y(String string) {
        com.iterable.iterableapi.g0 obj2 = q().k(string);
        if (obj2 == null) {
            j0.c("IterableApi", "inAppConsume: message is null");
        }
        int i = 0;
        x(obj2, i, i);
        j0.g();
    }
}
