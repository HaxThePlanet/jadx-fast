package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.h;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.measurement.a.a;
import com.google.android.gms.measurement.internal.c6;
import com.google.android.gms.measurement.internal.d6;
import com.google.android.gms.measurement.internal.o7;
import com.google.android.gms.measurement.internal.u4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class g3 {

    private static volatile com.google.android.gms.internal.measurement.g3 i;
    private final String a;
    protected final e b;
    protected final ExecutorService c;
    private final a d;
    private final List<Pair<d6, com.google.android.gms.internal.measurement.w2>> e;
    private int f;
    private boolean g = true;
    private volatile com.google.android.gms.internal.measurement.f1 h;
    protected g3(Context context, String string2, String string3, String string4, Bundle bundle5) {
        boolean z;
        int str;
        int i;
        String obj9;
        super();
        if (string2 != null) {
            if (!g3.u(string3, string4)) {
                this.a = "FA";
            } else {
                this.a = string2;
            }
        } else {
        }
        this.b = h.b();
        j2 j2Var = new j2(this);
        i = 1;
        this.c = z0.a().a(j2Var, i);
        obj9 = new a(this);
        this.d = obj9;
        obj9 = new ArrayList();
        this.e = obj9;
        if (o7.c(context, "google_app_id", u4.a(context)) != null) {
        }
        if (!g3.u(string3, string4)) {
            if (string3 != null && string4 != null) {
                if (string4 != null) {
                    Log.v(this.a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
                } else {
                    obj9 = 0;
                    str = string3 == null ? i : obj9;
                    if (string4 == null) {
                    } else {
                        i = obj9;
                    }
                    if (str ^ i != 0) {
                        Log.w(this.a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                    }
                }
            } else {
            }
        }
        super(this, string3, string4, context, bundle5);
        t(obj9);
        Context obj8 = context.getApplicationContext();
        if ((Application)obj8 == null) {
            Log.w(this.a, "Unable to register lifecycle notifications. Application null.");
        }
        obj9 = new f3(this);
        (Application)obj8.registerActivityLifecycleCallbacks(obj9);
    }

    public static com.google.android.gms.internal.measurement.g3 A(Context context, String string2, String string3, String string4, Bundle bundle5) {
        com.google.android.gms.internal.measurement.g3 g3Var3;
        com.google.android.gms.internal.measurement.g3 g3Var2;
        com.google.android.gms.internal.measurement.g3 g3Var;
        Object obj;
        String str2;
        String str;
        String str3;
        Bundle bundle;
        r.j(context);
        g3Var3 = g3.class;
        if (g3.i == null && g3.i == null) {
            g3Var3 = g3.class;
            synchronized (g3Var3) {
                super(context, string2, string3, string4, bundle5);
                g3.i = g3Var2;
            }
        }
        return g3.i;
    }

    static String C(com.google.android.gms.internal.measurement.g3 g3) {
        return g3.a;
    }

    static void K(com.google.android.gms.internal.measurement.g3 g3, com.google.android.gms.internal.measurement.f1 f12) {
        g3.h = f12;
    }

    static void L(com.google.android.gms.internal.measurement.g3 g3, Exception exception2, boolean z3, boolean z4) {
        g3.r(exception2, z3, z4);
    }

    static void M(com.google.android.gms.internal.measurement.g3 g3, com.google.android.gms.internal.measurement.u2 u22) {
        g3.t(u22);
    }

    static boolean o(com.google.android.gms.internal.measurement.g3 g3) {
        return g3.g;
    }

    static boolean p(com.google.android.gms.internal.measurement.g3 g3, String string2, String string3) {
        return g3.u(string2, string3);
    }

    protected static final boolean q() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return 1;
            return 0;
        }
    }

    private final void r(Exception exception, boolean z2, boolean z3) {
        int i2;
        int i;
        String str;
        Throwable th;
        int i3;
        int i4;
        this.g = z |= z2;
        if (z2) {
            Log.w(this.a, "Data collection startup failed. No data will be collected.", exception);
        }
        String obj8 = "Error with data collection. Data lost.";
        if (z3) {
            this.a(5, obj8, exception, 0, 0);
        }
        Log.w(this.a, obj8, exception);
    }

    private final void s(String string, String string2, Bundle bundle3, boolean z4, boolean z5, Long long6) {
        super(this, long6, string, string2, bundle3, z4, z5);
        t(s2Var2);
    }

    private final void t(com.google.android.gms.internal.measurement.u2 u2) {
        this.c.execute(u2);
    }

    private static final boolean u(String string, String string2) {
        boolean obj0;
        if (string2 != null && string != null && !g3.q()) {
            if (string != null) {
                if (!g3.q()) {
                    return 1;
                }
            }
        }
        return 0;
    }

    static com.google.android.gms.internal.measurement.f1 y(com.google.android.gms.internal.measurement.g3 g3) {
        return g3.h;
    }

    public final Object B(int i) {
        b1 b1Var = new b1();
        m2 m2Var = new m2(this, b1Var, i);
        t(m2Var);
        return b1.p2(b1Var.m(15000), Object.class);
    }

    public final String D() {
        b1 b1Var = new b1();
        l2 l2Var = new l2(this, b1Var);
        t(l2Var);
        return b1Var.n(120000);
    }

    public final String E() {
        b1 b1Var = new b1();
        d2 d2Var = new d2(this, b1Var);
        t(d2Var);
        return b1Var.n(50);
    }

    public final String F() {
        b1 b1Var = new b1();
        g2 g2Var = new g2(this, b1Var);
        t(g2Var);
        return b1Var.n(500);
    }

    public final String G() {
        b1 b1Var = new b1();
        f2 f2Var = new f2(this, b1Var);
        t(f2Var);
        return b1Var.n(500);
    }

    public final String H() {
        b1 b1Var = new b1();
        c2 c2Var = new c2(this, b1Var);
        t(c2Var);
        return b1Var.n(500);
    }

    public final List<Bundle> I(String string, String string2) {
        Object obj3;
        b1 b1Var = new b1();
        s1 s1Var = new s1(this, string, string2, b1Var);
        t(s1Var);
        if ((List)b1.p2(b1Var.m(5000), List.class) == null) {
            obj3 = Collections.emptyList();
        }
        return obj3;
    }

    public final Map<String, Object> J(String string, String string2, boolean z3) {
        com.google.android.gms.internal.measurement.h2 next;
        com.google.android.gms.internal.measurement.g3 g3Var;
        String str;
        int obj10;
        b1 b1Var2 = new b1();
        super(this, string, string2, z3, b1Var2);
        t(h2Var);
        Bundle obj9 = b1Var2.m(5000);
        if (obj9 != null) {
            if (obj9.size() == 0) {
            } else {
                obj10 = new HashMap(obj9.size());
                Iterator obj11 = obj9.keySet().iterator();
                while (obj11.hasNext()) {
                    next = obj11.next();
                    g3Var = obj9.get((String)next);
                    if (!g3Var instanceof Double && !g3Var instanceof Long) {
                    } else {
                    }
                    obj10.put(next, g3Var);
                    if (!g3Var instanceof Long) {
                    } else {
                    }
                    if (g3Var instanceof String != null) {
                    }
                }
            }
            return obj10;
        }
        return Collections.emptyMap();
    }

    public final void N(String string) {
        a2 a2Var = new a2(this, string);
        t(a2Var);
    }

    public final void O(String string, String string2, Bundle bundle3) {
        r1 r1Var = new r1(this, string, string2, bundle3);
        t(r1Var);
    }

    public final void P(String string) {
        b2 b2Var = new b2(this, string);
        t(b2Var);
    }

    public final void Q(String string, Bundle bundle2) {
        this.s(0, string, bundle2, false, true, 0);
    }

    public final void R(String string, String string2, Bundle bundle3) {
        this.s(string, string2, bundle3, true, true, 0);
    }

    public final void S(String string, String string2, Bundle bundle3, long l4) {
        this.s(string, string2, bundle3, true, false, Long.valueOf(l4));
    }

    public final void a(int i, String string2, Object object3, Object object4, Object object5) {
        super(this, 0, 5, string2, object3, 0, 0);
        t(obj9);
    }

    public final void b(d6 d6) {
        List list;
        int i;
        boolean equals;
        com.google.android.gms.internal.measurement.f1 obj5;
        r.j(d6);
        list = this.e;
        i = 0;
        synchronized (list) {
            while (i < this.e.size()) {
                i++;
            }
            w2 w2Var = new w2(d6);
            Pair pair = new Pair(d6, w2Var);
            this.e.add(pair);
            if (this.h != null) {
            }
            obj5 = new q2(this, w2Var);
            t(obj5);
        }
        this.h.registerOnMeasurementEventListener(w2Var);
    }

    public final void c() {
        x1 x1Var = new x1(this);
        t(x1Var);
    }

    public final void d(Bundle bundle) {
        q1 q1Var = new q1(this, bundle);
        t(q1Var);
    }

    public final void e(Bundle bundle) {
        w1 w1Var = new w1(this, bundle);
        t(w1Var);
    }

    public final void f(Activity activity, String string2, String string3) {
        u1 u1Var = new u1(this, activity, string2, string3);
        t(u1Var);
    }

    public final void g(boolean z) {
        n2 n2Var = new n2(this, z);
        t(n2Var);
    }

    public final void h(Bundle bundle) {
        o2 o2Var = new o2(this, bundle);
        t(o2Var);
    }

    public final void i(c6 c6) {
        String str;
        com.google.android.gms.internal.measurement.f1 obj3;
        v2 v2Var = new v2(c6);
        if (this.h != null) {
            this.h.setEventInterceptor(v2Var);
        }
        obj3 = new p2(this, v2Var);
        t(obj3);
    }

    public final void j(Boolean boolean) {
        v1 v1Var = new v1(this, boolean);
        t(v1Var);
    }

    public final void k(long l) {
        y1 y1Var = new y1(this, l, obj3);
        t(y1Var);
    }

    public final void l(String string) {
        t1 t1Var = new t1(this, string);
        t(t1Var);
    }

    public final void m(String string, String string2, Object object3, boolean z4) {
        super(this, string, string2, object3, z4);
        t(t2Var2);
    }

    public final void n(d6 d6) {
        com.google.android.gms.internal.measurement.f1 f1Var;
        int i;
        List list;
        boolean equals;
        Object obj4;
        r.j(d6);
        List list2 = this.e;
        i = 0;
        synchronized (list2) {
            while (i < this.e.size()) {
                i++;
            }
            obj4 = 0;
            if (obj4 == null) {
                try {
                    Log.w(this.a, "OnEventListener had not been registered.");
                    this.e.remove(obj4);
                    obj4 = obj4.second;
                    if (this.h != null) {
                    }
                    this.h.unregisterOnMeasurementEventListener((w2)obj4);
                    String str = this.a;
                    Log.w(str, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                    r2 r2Var = new r2(this, obj4);
                    t(r2Var);
                    throw d6;
                } catch (android.os.RemoteException remote) {
                } catch (android.os.BadParcelableException badParcelable1) {
                } catch (java.lang.IllegalArgumentException iae2) {
                } catch (java.lang.IllegalStateException ise3) {
                } catch (android.os.NetworkOnMainThreadException networkOnMainThread4) {
                } catch (java.lang.NullPointerException npe5) {
                } catch (java.lang.SecurityException se6) {
                } catch (java.lang.UnsupportedOperationException unsupportedOperation7) {
                }
            }
        }
    }

    public final int v(String string) {
        b1 b1Var = new b1();
        k2 k2Var = new k2(this, string, b1Var);
        t(k2Var);
        Object obj4 = b1.p2(b1Var.m(10000), Integer.class);
        if ((Integer)obj4 == null) {
            return 25;
        }
        return (Integer)obj4.intValue();
    }

    public final long w() {
        int longValue;
        int obj;
        long l;
        long currentTimeMillis;
        b1 b1Var = new b1();
        e2 e2Var = new e2(this, b1Var);
        t(e2Var);
        Object obj2 = b1.p2(b1Var.m(500), Long.class);
        if ((Long)obj2 == null) {
            Random random = new Random(nanoTime ^= currentTimeMillis, obj2);
            i2++;
            this.f = i3;
            nextLong += l;
        } else {
            longValue = (Long)obj2.longValue();
        }
        return longValue;
    }

    public final a x() {
        return this.d;
    }

    protected final com.google.android.gms.internal.measurement.f1 z(Context context, boolean z2) {
        try {
            return e1.asInterface(DynamiteModule.e(context, DynamiteModule.b, "com.google.android.gms.measurement.dynamite").d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
            z2 = 1;
            r(context, z2, false);
            context = null;
            return context;
        }
    }
}
