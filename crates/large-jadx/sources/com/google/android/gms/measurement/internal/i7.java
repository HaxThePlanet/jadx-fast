package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.f;
import com.google.android.gms.common.util.n;
import com.google.android.gms.internal.measurement.bd;
import com.google.android.gms.internal.measurement.me;
import com.google.android.gms.internal.measurement.rc;
import com.google.android.gms.internal.measurement.uc;
import d.e.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class i7 extends com.google.android.gms.measurement.internal.f4 {

    protected com.google.android.gms.measurement.internal.g7 c;
    private com.google.android.gms.measurement.internal.c6 d;
    private final Set<com.google.android.gms.measurement.internal.d6> e;
    private boolean f;
    private final AtomicReference<String> g;
    private final Object h;
    private com.google.android.gms.measurement.internal.h i;
    private int j = 100;
    private final AtomicLong k;
    private long l = -1;
    private int m = 100;
    final com.google.android.gms.measurement.internal.pa n;
    protected boolean o = true;
    private final com.google.android.gms.measurement.internal.ha p;
    protected i7(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.e = copyOnWriteArraySet;
        Object object = new Object();
        this.h = object;
        int i = 1;
        v6 v6Var = new v6(this);
        this.p = v6Var;
        AtomicReference atomicReference = new AtomicReference();
        this.g = atomicReference;
        int i3 = 0;
        h hVar = new h(i3, i3);
        this.i = hVar;
        int i2 = 100;
        int i4 = -1;
        AtomicLong atomicLong = new AtomicLong(0, obj2);
        this.k = atomicLong;
        pa paVar = new pa(b5);
        this.n = paVar;
    }

    private final void P(Bundle bundle, long l2) {
        boolean empty;
        uc.b();
        if (this.a.z().B(0, c3.p0) && TextUtils.isEmpty(this.a.B().u())) {
            if (TextUtils.isEmpty(this.a.B().u())) {
            }
            this.a.b().x().a("Using developer consent only; google app id found");
        }
        F(bundle, 0, l2);
    }

    private final void Q(Boolean boolean, boolean z2) {
        Object str;
        String booleanValue;
        Object obj3;
        SharedPreferences.Editor obj4;
        h();
        i();
        this.a.b().q().b("Setting app measurement enabled (FE)", boolean);
        this.a.F().s(boolean);
        if (z2 != null) {
            obj4 = this.a.F();
            com.google.android.gms.measurement.internal.b5 b5Var3 = obj4.a;
            obj4.h();
            obj4 = obj4.o().edit();
            str = "measurement_enabled_from_api";
            if (boolean != null) {
                obj4.putBoolean(str, boolean.booleanValue());
            } else {
                obj4.remove(str);
            }
            obj4.apply();
        }
        if (!this.a.p() && boolean != null && !boolean.booleanValue()) {
            if (boolean != null) {
                if (!boolean.booleanValue()) {
                }
            }
        }
        R();
    }

    private final void R() {
        Object str2;
        boolean z2;
        boolean z;
        int i;
        int equals;
        Object obj;
        String str3;
        String str;
        Long valueOf;
        long currentTimeMillis;
        h();
        str2 = g4Var.m.a();
        if (str2 != null) {
            if ("unset".equals(str2)) {
                this.N("app", "_npa", 0, this.a.c().currentTimeMillis());
            } else {
                equals = 1;
                i = equals != "true".equals(str2) ? 0 : 1;
                this.N("app", "_npa", Long.valueOf(i), this.a.c().currentTimeMillis());
            }
        }
        this.a.b().q().a("Recording app launch after enabling measurement for the first time (FE)");
        g0();
        bd.b();
        if (this.a.o() && this.o && this.a.z().B(0, c3.j0)) {
            if (this.o) {
                this.a.b().q().a("Recording app launch after enabling measurement for the first time (FE)");
                g0();
                bd.b();
                if (this.a.z().B(0, c3.j0)) {
                    m9Var.d.a();
                }
                l6 l6Var = new l6(this);
                this.a.a().z(l6Var);
            }
        }
        this.a.b().q().a("Updating Scion state (FE)");
        this.a.L().w();
    }

    static void d0(com.google.android.gms.measurement.internal.i7 i7, com.google.android.gms.measurement.internal.h h2, int i3, long l4, boolean z5, boolean z6) {
        int cmp;
        Object obj2;
        Object obj3;
        i7.h();
        i7.i();
        if (Long.compare(l4, l) <= 0 && !h.l(i7.m, i3)) {
            if (!h.l(i7.m, i3)) {
            }
            i7.a.b().u().b("Dropped out-of-date consent setting, proposed settings", h2);
        }
        com.google.android.gms.measurement.internal.g4 g4Var = i7.a.F();
        com.google.android.gms.measurement.internal.b5 b5Var2 = g4Var.a;
        g4Var.h();
        SharedPreferences.Editor edit = g4Var.o().edit();
        edit.putString("consent_settings", h2.i());
        edit.putInt("consent_source", i3);
        edit.apply();
        i7.l = l4;
        i7.m = i3;
        i7.a.L().t(z6);
        if (g4Var.w(i3) && obj8 != null) {
            edit = g4Var.o().edit();
            edit.putString("consent_settings", h2.i());
            edit.putInt("consent_source", i3);
            edit.apply();
            i7.l = l4;
            i7.m = i3;
            i7.a.L().t(z6);
            if (obj8 != null) {
                obj3 = new AtomicReference();
                i7.a.L().S(obj3);
            }
        }
        i7.a.b().u().b("Lower precedence consent source ignored, proposed source", Integer.valueOf(i3));
    }

    static void e0(com.google.android.gms.measurement.internal.i7 i7, Boolean boolean2, boolean z3) {
        i7.Q(boolean2, true);
    }

    static void f0(com.google.android.gms.measurement.internal.i7 i7) {
        i7.R();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void A(String string, String string2, long l3, Bundle bundle4, boolean z5, boolean z6, boolean z7, String string8) {
        Object length;
        boolean z;
        Object obj;
        Bundle bundle2;
        boolean bundle;
        Bundle bundle5 = new Bundle(z5);
        Iterator iterator = bundle5.keySet().iterator();
        while (iterator.hasNext()) {
            length = iterator.next();
            obj = bundle5.get((String)length);
            if (obj instanceof Bundle != null) {
            } else {
            }
            bundle2 = 0;
            if (obj instanceof Parcelable[]) {
            } else {
            }
            if (obj instanceof List != null) {
            }
            while (bundle2 < (List)obj.size()) {
                length = obj.get(bundle2);
                if (length instanceof Bundle != null) {
                }
                bundle2++;
                bundle = new Bundle((Bundle)length);
                obj.set(bundle2, bundle);
            }
            length = obj.get(bundle2);
            if (length instanceof Bundle != null) {
            }
            bundle2++;
            bundle = new Bundle((Bundle)length);
            obj.set(bundle2, bundle);
            while (bundle2 < obj.length) {
                z = (Parcelable[])obj[bundle2];
                if (z instanceof Bundle != null) {
                }
                bundle2++;
                bundle = new Bundle((Bundle)z);
                obj[bundle2] = bundle;
            }
            z = obj[bundle2];
            if (z instanceof Bundle != null) {
            }
            bundle2++;
            bundle = new Bundle((Bundle)z);
            obj[bundle2] = bundle;
            bundle2 = new Bundle((Bundle)obj);
            bundle5.putBundle(length, bundle2);
        }
        super(this, string, string2, l3, obj5, bundle5, z6, z7, string8, obj23);
        obj3.a.a().z(n6Var2);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void B(String string, String string2, long l3, Object object4) {
        super(this, string, string2, obj14, l3, obj7);
        this.a.a().z(o6Var2);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void C(String string) {
        this.g.set(string);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void D(Bundle bundle) {
        E(bundle, this.a.c().currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void E(Bundle bundle, long l2) {
        int empty2;
        int cmp;
        boolean empty;
        String str;
        Class<Long> obj = Long.class;
        Class<String> obj3 = String.class;
        r.j(bundle);
        Bundle bundle2 = new Bundle(bundle);
        String obj12 = "app_id";
        if (!TextUtils.isEmpty(bundle2.getString(obj12))) {
            this.a.b().w().a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(obj12);
        r.j(bundle2);
        int i = 0;
        y5.a(bundle2, obj12, obj3, i);
        obj12 = "origin";
        y5.a(bundle2, obj12, obj3, i);
        String str6 = "name";
        y5.a(bundle2, str6, obj3, i);
        final String str8 = "value";
        y5.a(bundle2, str8, Object.class, i);
        String str7 = "trigger_event_name";
        y5.a(bundle2, str7, obj3, i);
        Long valueOf = Long.valueOf(0);
        final String str9 = "trigger_timeout";
        y5.a(bundle2, str9, obj, valueOf);
        y5.a(bundle2, "timed_out_event_name", obj3, i);
        y5.a(bundle2, "timed_out_event_params", Bundle.class, i);
        y5.a(bundle2, "triggered_event_name", obj3, i);
        y5.a(bundle2, "triggered_event_params", Bundle.class, i);
        String str12 = "time_to_live";
        y5.a(bundle2, str12, obj, valueOf);
        y5.a(bundle2, "expired_event_name", obj3, i);
        y5.a(bundle2, "expired_event_params", Bundle.class, i);
        r.f(bundle2.getString(str6));
        r.f(bundle2.getString(obj12));
        r.j(bundle2.get(str8));
        bundle2.putLong("creation_timestamp", l2);
        obj12 = bundle2.getString(str6);
        Object obj13 = bundle2.get(str8);
        Object obj14 = this.a.N().p(obj12, obj13);
        if (this.a.N().n0(obj12) == 0 && this.a.N().j0(obj12, obj13) == 0 && obj14 == null) {
            if (this.a.N().j0(obj12, obj13) == 0) {
                obj14 = this.a.N().p(obj12, obj13);
                if (obj14 == null) {
                    this.a.b().r().c("Unable to normalize conditional user property value", this.a.D().f(obj12), obj13);
                }
                y5.b(bundle2, obj14);
                obj13 = bundle2.getLong(str9);
                int i2 = 1;
                long l = 15552000000L;
                this.a.z();
                if (!TextUtils.isEmpty(bundle2.getString(str7)) && Long.compare(obj13, l) <= 0 && Long.compare(obj13, i2) < 0) {
                    this.a.z();
                    if (Long.compare(obj13, l) <= 0) {
                        if (Long.compare(obj13, i2) < 0) {
                        }
                    }
                    this.a.b().r().c("Invalid conditional user property timeout", this.a.D().f(obj12), Long.valueOf(obj13));
                }
                obj13 = bundle2.getLong(str12);
                this.a.z();
                if (Long.compare(obj13, l) <= 0 && Long.compare(obj13, i2) < 0) {
                    if (Long.compare(obj13, i2) < 0) {
                    }
                    obj13 = new q6(this, bundle2);
                    this.a.a().z(obj13);
                }
                this.a.b().r().c("Invalid conditional user property time to live", this.a.D().f(obj12), Long.valueOf(obj13));
            }
            this.a.b().r().c("Invalid conditional user property value", this.a.D().f(obj12), obj13);
        }
        this.a.b().r().b("Invalid conditional user property name", this.a.D().f(obj12));
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void F(Bundle bundle, int i2, long l3) {
        Object str;
        String str2;
        String str3;
        i();
        str = h.h(bundle);
        if (str != null) {
            this.a.b().x().b("Ignoring invalid consent setting", str);
            this.a.b().x().a("Valid consent values are 'granted', 'denied'");
        }
        G(h.a(bundle), i2, l3);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void G(com.google.android.gms.measurement.internal.h h, int i2, long l3) {
        int i4;
        Boolean bool;
        com.google.android.gms.measurement.internal.h hVar;
        int i3;
        boolean i;
        com.google.android.gms.measurement.internal.h hVar2;
        boolean z;
        boolean z2;
        final Object obj2 = this;
        int i11 = i2;
        i();
        int i5 = -10;
        if (i11 != i5 && h.e() == null && h.f() != null) {
            if (h.e() == null) {
                if (h.f() != null) {
                }
                obj2.a.b().x().a("Discarding empty consent settings");
            }
        }
        Object obj = obj2.h;
        synchronized (obj) {
            if (h.k() && !obj2.i.k()) {
                if (!obj2.i.k()) {
                    i = i3;
                }
            }
            com.google.android.gms.measurement.internal.h hVar4 = h.d(obj2.i);
            obj2.i = hVar4;
            obj2.j = i11;
            hVar = hVar4;
            i4 = i;
            i = z2;
            if (i3 == 0) {
            }
            long andIncrement = obj2.k.getAndIncrement();
            if (i) {
                obj2.g.set(0);
                super(this, hVar, l3, i, i2, andIncrement, obj8, i4);
                obj2.a.a().A(b7Var2);
            }
            if (i11 != 30 && i11 == i5) {
                if (i11 == i5) {
                }
                super(this, hVar, i2, andIncrement, i11, i4);
                obj2.a.a().z(d7Var2);
            }
            super(this, hVar, i2, andIncrement, i11, i4);
            obj2.a.a().A(c7Var2);
        }
        obj2.a.b().u().b("Ignoring lower-priority consent settings, proposed settings", hVar);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void H(Bundle bundle, long l2) {
        uc.b();
        if (this.a.z().B(0, c3.q0)) {
            j6 j6Var = new j6(this, bundle, l2, obj6);
            this.a.a().A(j6Var);
        }
        P(bundle, l2);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void I(com.google.android.gms.measurement.internal.c6 c6) {
        int c6Var;
        String str;
        h();
        i();
        c6Var = this.d;
        if (c6 != null && c6 != c6Var) {
            c6Var = this.d;
            if (c6 != c6Var) {
                c6Var = c6Var == null ? 1 : 0;
                r.n(c6Var, "EventInterceptor already set.");
            }
        }
        this.d = c6;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void J(Boolean boolean) {
        i();
        a7 a7Var = new a7(this, boolean);
        this.a.a().z(a7Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void K(com.google.android.gms.measurement.internal.h h) {
        Boolean booleanValue;
        boolean contains;
        String str;
        boolean obj6;
        h();
        final int i = 0;
        final int i2 = 1;
        if (h.k()) {
            if (!h.j()) {
                obj6 = this.a.L().A() ? i2 : i;
            } else {
            }
        } else {
        }
        if (obj6 != this.a.p()) {
            this.a.l(obj6);
            com.google.android.gms.measurement.internal.g4 g4Var = this.a.F();
            com.google.android.gms.measurement.internal.b5 b5Var4 = g4Var.a;
            g4Var.h();
            str = "measurement_enabled_from_api";
            if (g4Var.o().contains(str)) {
                booleanValue = Boolean.valueOf(g4Var.o().getBoolean(str, i2));
            } else {
                booleanValue = 0;
            }
            if (obj6 != null && booleanValue != null) {
                if (booleanValue != null) {
                    if (booleanValue.booleanValue()) {
                        Q(Boolean.valueOf(obj6), i);
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void L(String string, String string2, Object object3, boolean z4) {
        this.M("auto", "_ldl", object3, true, this.a.c().currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void M(String string, String string2, Object object3, boolean z4, long l5) {
        Object string3;
        String str3;
        boolean z2;
        String str2;
        int i3;
        com.google.android.gms.measurement.internal.ia iaVar;
        int length;
        com.google.android.gms.measurement.internal.ia iaVar2;
        String str;
        boolean z;
        int i;
        int i2;
        final Object obj3 = this;
        str2 = string2;
        string3 = object3;
        str3 = string == null ? "app" : string;
        i3 = 6;
        length = 0;
        int i5 = 24;
        if (z4) {
            i3 = obj3.a.N().n0(str2);
            i2 = i3;
        } else {
        }
        int i4 = 1;
        obj3.a.z();
        if (i2 != 0 && str2 != null) {
            obj3.a.z();
            if (str2 != null) {
                length = string2.length();
            }
            obj3.a.N().A(obj3.p, 0, i2, "_ev", obj3.a.N().q(str2, i5, i4), length);
        }
        int i9 = obj3.a.N().j0(str2, string3);
        if (string3 != null && i9 != 0) {
            i9 = obj3.a.N().j0(str2, string3);
            if (i9 != 0) {
                obj3.a.z();
                if (string3 instanceof String == null) {
                    if (string3 instanceof CharSequence) {
                        length = object3.toString().length();
                    }
                } else {
                }
                obj3.a.N().A(obj3.p, 0, i9, "_ev", obj3.a.N().q(str2, i5, i4), length);
            }
            Object obj2 = obj3.a.N().p(str2, string3);
            if (obj2 != null) {
                this.B(str3, string2, l5, length);
            }
        }
        this.B(str3, string2, l5, length);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void N(String string, String string2, Object object3, long l4) {
        String equals;
        boolean empty;
        String str;
        long longValue;
        Object obj;
        com.google.android.gms.measurement.internal.e4 obj10;
        Object obj11;
        r.f(string);
        r.f(string2);
        h();
        i();
        if ("allow_personalized_ads".equals(string2)) {
            equals = object3;
            if (object3 instanceof String != null && !TextUtils.isEmpty((String)equals)) {
                equals = object3;
                if (!TextUtils.isEmpty((String)equals)) {
                    obj11 = "false".equals(equals.toLowerCase(Locale.ENGLISH));
                    int i = 1;
                    obj10 = 1 != obj11 ? 0 : i;
                    if (Long.compare(longValue, i) == 0) {
                        equals = "true";
                    }
                    obj10.m.b(equals);
                    obj = obj11;
                    str = str3;
                } else {
                    if (object3 == null) {
                        obj10.m.b("unset");
                    } else {
                        str = string2;
                        obj = object3;
                    }
                }
            } else {
            }
        } else {
        }
        if (!this.a.o()) {
            this.a.b().v().a("User property not set since app measurement is disabled");
        }
        if (!this.a.r()) {
        }
        super(str, l4, obj5, obj, string);
        this.a.L().y(obj10);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void O(com.google.android.gms.measurement.internal.d6 d6) {
        Object str;
        boolean obj2;
        i();
        r.j(d6);
        if (!this.e.remove(d6)) {
            this.a.b().w().a("OnEventListener had not been registered");
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final int S(String string) {
        r.f(string);
        this.a.z();
        return 25;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final Boolean T() {
        AtomicReference atomicReference = new AtomicReference();
        s6 s6Var = new s6(this, atomicReference);
        return (Boolean)this.a.a().r(atomicReference, 15000, obj3, "boolean test flag value");
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final Double U() {
        AtomicReference atomicReference = new AtomicReference();
        z6 z6Var = new z6(this, atomicReference);
        return (Double)this.a.a().r(atomicReference, 15000, obj3, "double test flag value");
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final Integer V() {
        AtomicReference atomicReference = new AtomicReference();
        y6 y6Var = new y6(this, atomicReference);
        return (Integer)this.a.a().r(atomicReference, 15000, obj3, "int test flag value");
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final Long W() {
        AtomicReference atomicReference = new AtomicReference();
        x6 x6Var = new x6(this, atomicReference);
        return (Long)this.a.a().r(atomicReference, 15000, obj3, "long test flag value");
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final String X() {
        return (String)this.g.get();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final String Y() {
        com.google.android.gms.measurement.internal.p7 p7Var = this.a.K().s();
        if (p7Var != null) {
            return p7Var.b;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final String Z() {
        com.google.android.gms.measurement.internal.p7 p7Var = this.a.K().s();
        if (p7Var != null) {
            return p7Var.a;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final String a0() {
        AtomicReference atomicReference = new AtomicReference();
        w6 w6Var = new w6(this, atomicReference);
        return (String)this.a.a().r(atomicReference, 15000, obj3, "String test flag value");
    }

    public final ArrayList<Bundle> b0(String string, String string2) {
        boolean atomicReference;
        int i3;
        com.google.android.gms.measurement.internal.y4 y4Var;
        AtomicReference atomicReference2;
        int i2;
        int i;
        String str;
        com.google.android.gms.measurement.internal.t6 t6Var;
        com.google.android.gms.measurement.internal.t6 t6Var2;
        ArrayList obj10;
        String obj11;
        i3 = 0;
        if (this.a.a().C()) {
            this.a.b().r().a("Cannot get conditional user properties from analytics worker thread");
            obj10 = new ArrayList(i3);
        } else {
            this.a.d();
            if (b.a()) {
                this.a.b().r().a("Cannot get conditional user properties from main thread");
                obj10 = new ArrayList(i3);
            } else {
                atomicReference = new AtomicReference();
                i = 0;
                super(this, atomicReference, i, string, string2);
                this.a.a().r(atomicReference, 5000, i, "get conditional user properties");
                obj10 = atomicReference.get();
                if ((List)obj10 == null) {
                    this.a.b().r().b("Timed out waiting for get conditional user properties", 0);
                    obj10 = new ArrayList();
                } else {
                    obj10 = ia.u((List)obj10);
                }
            }
        }
        return obj10;
    }

    public final Map<String, Object> c0(String string, String string2, boolean z3) {
        boolean z;
        AtomicReference atomicReference;
        int i;
        int i2;
        String str;
        com.google.android.gms.measurement.internal.u6 u6Var;
        boolean z2;
        AtomicReference atomicReference2;
        com.google.android.gms.measurement.internal.y4 y4Var;
        com.google.android.gms.measurement.internal.u6 u6Var2;
        Object obj11;
        Object obj12;
        boolean obj13;
        if (this.a.a().C()) {
            this.a.b().r().a("Cannot get user properties from analytics worker thread");
            obj11 = Collections.emptyMap();
        } else {
            this.a.d();
            if (b.a()) {
                this.a.b().r().a("Cannot get user properties from main thread");
                obj11 = Collections.emptyMap();
            } else {
                atomicReference2 = new AtomicReference();
                i2 = 0;
                super(this, atomicReference2, i2, string, string2, z3);
                this.a.a().r(atomicReference2, 5000, i2, "get user properties");
                obj11 = atomicReference2.get();
                if ((List)obj11 == null) {
                    this.a.b().r().b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z3));
                    obj11 = Collections.emptyMap();
                } else {
                    obj12 = new a((List)obj11.size());
                    obj11 = obj11.iterator();
                    while (obj11.hasNext()) {
                        obj13 = obj11.next();
                        z = (ea)obj13.j2();
                        if (z != null) {
                        }
                        obj12.put(obj13.b, z);
                    }
                    obj11 = obj12;
                }
            }
        }
        return obj11;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void g0() {
        boolean equals;
        boolean booleanValue;
        Object edit;
        String string;
        Object g6Var;
        String rELEASE;
        String str;
        boolean equals2;
        h();
        i();
        int i2 = 0;
        com.google.android.gms.measurement.internal.g gVar2 = this.a.z();
        gVar2.a.d();
        booleanValue = gVar2.t("google_analytics_deferred_deep_link_enabled");
        if (this.a.r() && this.a.z().B(i2, c3.a0) && booleanValue != null && booleanValue.booleanValue()) {
            i2 = 0;
            if (this.a.z().B(i2, c3.a0)) {
                gVar2 = this.a.z();
                gVar2.a.d();
                booleanValue = gVar2.t("google_analytics_deferred_deep_link_enabled");
                if (booleanValue != null) {
                    if (booleanValue.booleanValue()) {
                        this.a.b().q().a("Deferred Deep Link feature enabled.");
                        g6Var = new g6(this);
                        this.a.a().z(g6Var);
                    }
                }
            }
            this.a.L().O();
            this.o = false;
            edit = this.a.F();
            edit.h();
            str = "previous_os_version";
            string = edit.o().getString(str, i2);
            edit.a.A().k();
            rELEASE = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(rELEASE) && !rELEASE.equals(string)) {
                if (!rELEASE.equals(string)) {
                    edit = edit.o().edit();
                    edit.putString(str, rELEASE);
                    edit.apply();
                }
            }
            this.a.A().k();
            if (!TextUtils.isEmpty(string) && !string.equals(rELEASE)) {
                this.a.A().k();
                if (!string.equals(rELEASE)) {
                    equals = new Bundle();
                    equals.putString("_po", string);
                    u("auto", "_ou", equals);
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void h0(String string, String string2, Bundle bundle3) {
        String obj5;
        r.f(string);
        Bundle bundle = new Bundle();
        bundle.putString("name", string);
        bundle.putLong("creation_timestamp", this.a.c().currentTimeMillis());
        if (string2 != null) {
            bundle.putString("expired_event_name", string2);
            bundle.putBundle("expired_event_params", bundle3);
        }
        r6 obj6 = new r6(this, bundle);
        this.a.a().z(obj6);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void o() {
        boolean applicationContext;
        com.google.android.gms.measurement.internal.g7 g7Var;
        if (applicationContext2 instanceof Application && this.c != null) {
            if (this.c != null) {
                (Application)this.a.f().getApplicationContext().unregisterActivityLifecycleCallbacks(this.c);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void p(Bundle bundle, long l2) {
        P(bundle, l2);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void q(Bundle bundle) {
        int size;
        Object next3;
        boolean next2;
        int i5;
        Object next;
        String str;
        boolean z;
        int str2;
        Object str3;
        int i4;
        int i6;
        int i3;
        int i2;
        int i;
        int obj13;
        if (bundle == null) {
            Bundle bundle2 = new Bundle();
            obj13.w.b(bundle2);
        }
        Bundle bundle3 = g4Var.w.a();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            next = bundle.get((String)next3);
            if (next != null && next instanceof String == null && !next instanceof Long && !next instanceof Double) {
            } else {
            }
            if (ia.V(next3)) {
            } else {
            }
            if (next == null) {
            } else {
            }
            this.a.z();
            if (this.a.N().N("param", next3, 100, next)) {
            }
            this.a.N().B(bundle3, next3, next);
            bundle3.remove(next3);
            this.a.b().x().b("Invalid default event parameter name. Name", next3);
            if (next instanceof String == null) {
            } else {
            }
            if (!next instanceof Long) {
            } else {
            }
            if (!next instanceof Double) {
            } else {
            }
            if (this.a.N().T(next)) {
            }
            this.a.b().x().c("Invalid default event parameter type. Name, value", next3, next);
            this.a.N().A(this.p, 0, 27, 0, 0, 0);
        }
        this.a.N();
        obj13 = this.a.z().m();
        if (bundle3.size() <= obj13) {
        } else {
            TreeSet treeSet = new TreeSet(bundle3.keySet());
            Iterator iterator2 = treeSet.iterator();
            i5 = 0;
            while (iterator2.hasNext()) {
                if (i5++ > obj13) {
                }
                bundle3.remove((String)iterator2.next());
            }
            this.a.N().A(this.p, 0, 26, 0, 0, 0);
            this.a.b().x().a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        obj13.w.b(bundle3);
        this.a.L().v(bundle3);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void r(String string, String string2, Bundle bundle3) {
        this.s(string, string2, bundle3, true, true, this.a.c().currentTimeMillis());
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void s(String string, String string2, Bundle bundle3, boolean z4, boolean z5, long l6) {
        String bundle;
        int i;
        String str;
        Bundle bundle2;
        com.google.android.gms.measurement.internal.c6 c6Var;
        final Object obj2 = this;
        str = string == null ? bundle : string;
        if (bundle3 == null) {
            bundle = new Bundle();
            bundle2 = bundle;
        } else {
            bundle2 = bundle3;
        }
        String str3 = string2;
        if (ia.Z(string2, "screen_view")) {
            obj2.a.K().F(bundle2, l6);
        }
        long l2 = l6;
        i = 1;
        if (z5 && obj2.d != null) {
            if (obj2.d != null) {
                if (ia.V(string2)) {
                } else {
                    i = 0;
                }
            }
        }
        this.A(str, string2, l6, obj4, bundle2, z5, i, z4);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void t(String string, String string2, Bundle bundle3, String string4) {
        b5.t();
        throw 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void u(String string, String string2, Bundle bundle3) {
        h();
        this.v(string, string2, this.a.c().currentTimeMillis(), obj5);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void v(String string, String string2, long l3, Bundle bundle4) {
        int c6Var;
        int i;
        h();
        if (obj2.d != null) {
            if (ia.V(string2)) {
                i = i2;
            } else {
                i = c6Var;
            }
        } else {
        }
        this.w(string, string2, l3, obj4, obj16, true, i, 1);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void w(String string, String string2, long l3, Bundle bundle4, boolean z5, boolean z6, boolean z7, String string8) {
        Class forName;
        Object declaredMethod;
        boolean equals;
        com.google.android.gms.measurement.internal.b5 b5Var;
        int equals4;
        List contains;
        boolean classLoader;
        boolean equals3;
        com.google.android.gms.measurement.internal.p7 p7Var;
        com.google.android.gms.measurement.internal.p7 equals6;
        boolean equals5;
        boolean equals2;
        int cmp;
        int cmp2;
        ArrayList arrayList2;
        Object obj2;
        Set next;
        boolean z;
        Object str;
        String str2;
        String string3;
        int size;
        String key;
        int i2;
        String empty;
        int sVar;
        String bundle;
        long currentTimeMillis;
        boolean length;
        int arr;
        int obj;
        Object obj3;
        Bundle bundle2;
        String i3;
        int arrayList;
        int uVar;
        int i;
        long currentTimeMillis2;
        final Object obj9 = this;
        obj = string;
        obj3 = string2;
        final long l7 = l3;
        bundle2 = z5;
        declaredMethod = "com.google.android.gms.tagmanager.TagManagerService";
        r.f(string);
        r.j(z5);
        h();
        i();
        contains = obj9.a.B().v();
        if (obj9.a.o() && contains != null && contains.contains(obj3)) {
            contains = obj9.a.B().v();
            if (contains != null) {
                if (contains.contains(obj3)) {
                }
                obj9.a.b().q().c("Dropping non-safelisted event. event name, origin", obj3, obj);
            }
            i3 = 0;
            arrayList = 0;
            uVar = 1;
            if (!obj9.f) {
                obj9.f = uVar;
                if (!obj9.a.s()) {
                    forName = Class.forName(declaredMethod, uVar, obj9.a.f().getClassLoader());
                } else {
                    forName = Class.forName(declaredMethod);
                }
                Class[] arr2 = new Class[uVar];
                arr2[arrayList] = Context.class;
                equals3 = new Object[uVar];
                equals3[arrayList] = obj9.a.f();
                forName.getDeclaredMethod("initialize", arr2).invoke(i3, equals3);
            }
            equals = "gclid";
            if ("_cmp".equals(obj3) && bundle2.containsKey(equals)) {
                equals = "gclid";
                if (bundle2.containsKey(equals)) {
                    obj9.a.d();
                    this.N("auto", "_lgclid", bundle2.getString(equals), obj9.a.c().currentTimeMillis());
                }
            }
            obj9.a.d();
            if (z6 && ia.a0(string2)) {
                if (ia.a0(string2)) {
                    obj9.a.N().y(bundle2, g4Var6.w.a());
                }
            }
            equals4 = 40;
            obj9.a.d();
            if (string8 == null && !"_iap".equals(obj3)) {
                obj9.a.d();
                if (!"_iap".equals(obj3)) {
                    equals3 = obj9.a.N();
                    str = "event";
                    bundle = 2;
                    if (!equals3.Q(str, obj3)) {
                    } else {
                        if (!equals3.M(str, z5.a, z5.b, obj3)) {
                            bundle = 13;
                        } else {
                            equals3.a.z();
                            if (!equals3.L(str, equals4, obj3)) {
                            } else {
                                bundle = arrayList;
                            }
                        }
                    }
                    obj9.a.b().s().b("Invalid public event name. Event will not be logged (FE)", obj9.a.D().d(obj3));
                    obj9.a.z();
                    if (bundle != null && obj3 != null) {
                        obj9.a.b().s().b("Invalid public event name. Event will not be logged (FE)", obj9.a.D().d(obj3));
                        obj9.a.z();
                        if (obj3 != null) {
                            arrayList = string2.length();
                        }
                        obj9.a.N().A(obj9.p, 0, bundle, "_ev", obj9.a.N().q(obj3, equals4, uVar), arrayList);
                    }
                }
            }
            me.b();
            size = "_sc";
            if (obj9.a.z().B(i3, c3.x0)) {
                obj9.a.d();
                p7Var = obj9.a.K().t(arrayList);
                if (p7Var != null && !bundle2.containsKey(size)) {
                    if (!bundle2.containsKey(size)) {
                        p7Var.d = uVar;
                    }
                }
                if (z6 && string8 == null) {
                    i2 = string8 == null ? uVar : arrayList;
                } else {
                }
                ia.x(p7Var, bundle2, i2);
            } else {
                obj9.a.d();
                p7Var = obj9.a.K().t(arrayList);
                if (p7Var != null && !bundle2.containsKey(size)) {
                    if (!bundle2.containsKey(size)) {
                        p7Var.d = uVar;
                    }
                }
                if (z6 && string8 == null) {
                    i2 = string8 == null ? uVar : arrayList;
                } else {
                }
                ia.x(p7Var, bundle2, i2);
            }
            boolean equals7 = "am".equals(obj);
            if (z6 && obj9.d != null && !ia.V(string2) && equals7) {
                if (obj9.d != null) {
                    if (!ia.V(string2)) {
                        if (equals7) {
                            i = uVar;
                            int i4 = obj9.a.N().k0(obj3);
                            obj9.a.b().s().b("Invalid event name. Event will not be logged (FE)", obj9.a.D().d(obj3));
                            obj9.a.z();
                            if (obj9.a.r() && i4 != 0 && obj3 != null) {
                                i4 = obj9.a.N().k0(obj3);
                                if (i4 != 0) {
                                    obj9.a.b().s().b("Invalid event name. Event will not be logged (FE)", obj9.a.D().d(obj3));
                                    obj9.a.z();
                                    if (obj3 != null) {
                                        arrayList = string2.length();
                                    }
                                    obj9.a.N().A(obj9.p, obj28, i4, "_ev", obj9.a.N().q(obj3, equals4, uVar), arrayList);
                                }
                                String str4 = "_o";
                                length = string8;
                                bundle2 = obj9.a.N().v0(obj28, string2, z5, f.c(/* result */), length);
                                r.j(bundle2);
                                obj9.a.d();
                                currentTimeMillis = 0;
                                bundle = "_ae";
                                com.google.android.gms.measurement.internal.k9 k9Var = m9Var2.e;
                                str2 = m9Var4.a.c().a();
                                arrayList = str2 - l8;
                                k9Var.b = str2;
                                if (obj9.a.K().t(arrayList) != null && bundle.equals(obj3) && Long.compare(arrayList, currentTimeMillis) > 0) {
                                    if (bundle.equals(obj3)) {
                                        k9Var = m9Var2.e;
                                        str2 = m9Var4.a.c().a();
                                        arrayList = str2 - l8;
                                        k9Var.b = str2;
                                        if (Long.compare(arrayList, currentTimeMillis) > 0) {
                                            obj9.a.N().v(bundle2, arrayList);
                                        }
                                    }
                                }
                                rc.b();
                                string3 = "_ffr";
                                if (obj9.a.z().B(i3, c3.i0) && !"auto".equals(obj) && "_ssr".equals(obj3)) {
                                    string3 = "_ffr";
                                    if (!"auto".equals(obj)) {
                                        if ("_ssr".equals(obj3)) {
                                            com.google.android.gms.measurement.internal.ia iaVar4 = obj9.a.N();
                                            string3 = bundle2.getString(string3);
                                            if (n.b(string3)) {
                                                string3 = i3;
                                            } else {
                                                if (string3 != null) {
                                                    string3 = string3.trim();
                                                }
                                            }
                                            if (!ia.Z(string3, g4Var7.t.a())) {
                                                g4Var2.t.b(string3);
                                            }
                                            iaVar4.a.b().q().a("Not logging duplicate session_start_with_rollout event");
                                        }
                                    }
                                    equals2 = g4Var.t.a();
                                    if (bundle.equals(obj3) && !TextUtils.isEmpty(equals2)) {
                                        equals2 = g4Var.t.a();
                                        if (!TextUtils.isEmpty(equals2)) {
                                            try {
                                                bundle2.putString(string3, equals2);
                                                arrayList = new ArrayList();
                                                arrayList.add(bundle2);
                                                if (Long.compare(l, currentTimeMillis) > 0 && obj9.a.F().v(l7) && g4Var5.q.b()) {
                                                } else {
                                                }
                                                if (obj9.a.F().v(l7)) {
                                                } else {
                                                }
                                                if (g4Var5.q.b()) {
                                                } else {
                                                }
                                                obj9.a.b().v().a("Current session is expired, remove the session number, ID, and engagement time");
                                                i3 = bundle;
                                                arr = currentTimeMillis;
                                                this.N("auto", "_sid", 0, obj9.a.c().currentTimeMillis());
                                                bundle = 0;
                                                this.N("auto", "_sno", bundle, obj9.a.c().currentTimeMillis());
                                                this.N("auto", "_se", bundle, obj9.a.c().currentTimeMillis());
                                                i3 = bundle;
                                                arr = currentTimeMillis;
                                                if (Long.compare(long, i5) == 0) {
                                                }
                                                obj9.a.b().v().a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                                                m9Var3.d.b(l7, obj11);
                                                arrayList2 = new ArrayList(bundle2.keySet());
                                                Collections.sort(arrayList2);
                                                sVar = 0;
                                                while (sVar < arrayList2.size()) {
                                                    bundle = arrayList2.get(sVar);
                                                    if ((String)bundle != null) {
                                                    }
                                                    sVar++;
                                                    obj9.a.N();
                                                    currentTimeMillis = bundle2.get((String)bundle);
                                                    if (currentTimeMillis instanceof Bundle != null) {
                                                    } else {
                                                    }
                                                    if (currentTimeMillis instanceof Parcelable[]) {
                                                    } else {
                                                    }
                                                    if (currentTimeMillis instanceof ArrayList != null) {
                                                    } else {
                                                    }
                                                    arr = 0;
                                                    if (arr != null) {
                                                    }
                                                    bundle2.putParcelableArray(bundle, arr);
                                                    arr = currentTimeMillis;
                                                    arr = currentTimeMillis;
                                                    new Bundle[1][0] = (Bundle)currentTimeMillis;
                                                }
                                                bundle = arrayList2.get(sVar);
                                                if ((String)bundle != null) {
                                                }
                                                obj9.a.N();
                                                currentTimeMillis = bundle2.get((String)bundle);
                                                if (currentTimeMillis instanceof Bundle != null) {
                                                } else {
                                                }
                                                new Bundle[1][0] = (Bundle)currentTimeMillis;
                                                if (currentTimeMillis instanceof Parcelable[]) {
                                                } else {
                                                }
                                                arr = currentTimeMillis;
                                                if (currentTimeMillis instanceof ArrayList != null) {
                                                } else {
                                                }
                                                arr = currentTimeMillis;
                                                arr = 0;
                                                if (arr != null) {
                                                }
                                                bundle2.putParcelableArray(bundle, arr);
                                                sVar++;
                                                obj = 0;
                                                obj2 = arrayList.get(obj);
                                                if (obj != null) {
                                                } else {
                                                }
                                                size = "_ep";
                                                obj3 = string;
                                                obj3 = string;
                                                size = string2;
                                                (Bundle)obj2.putString(str4, obj3);
                                            } catch (Exception e) {
                                            }
                                            obj9.a.d();
                                            if (obj9.a.K().t(false) != null && i3.equals(string2)) {
                                                if (i3.equals(string2)) {
                                                    sVar = 1;
                                                    m9Var.e.d(sVar, sVar, obj9.a.c().a());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        obj9.a.b().q().c("Passing event to registered event handler (FE)", obj9.a.D().d(obj3), obj9.a.D().b(bundle2));
                        r.j(obj9.d);
                        obj9.d.a(string, string2, z5, l3);
                    }
                }
            }
            i = equals7;
        }
        obj9.a.b().q().a("Event not sent since app measurement is disabled");
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void x(com.google.android.gms.measurement.internal.d6 d6) {
        Object str;
        boolean obj2;
        i();
        r.j(d6);
        if (!this.e.add(d6)) {
            this.a.b().w().a("OnEventListener already registered");
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void y(long l) {
        this.g.set(0);
        p6 p6Var = new p6(this, l, obj4);
        this.a.a().z(p6Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void z(long l, boolean z2) {
        boolean obj6;
        h();
        i();
        this.a.b().q().a("Resetting analytics data (FE)");
        com.google.android.gms.measurement.internal.m9 m9Var = this.a.M();
        m9Var.h();
        com.google.android.gms.measurement.internal.l9 l9Var = m9Var.d;
        m9Var.e.a();
        boolean z = this.a.o();
        com.google.android.gms.measurement.internal.g4 g4Var = this.a.F();
        g4Var.e.b(l);
        final int obj7 = 0;
        if (!TextUtils.isEmpty(obj6.t.a())) {
            g4Var.t.b(obj7);
        }
        bd.b();
        com.google.android.gms.measurement.internal.b3 b3Var = c3.j0;
        final int i = 0;
        if (g4Var.a.z().B(obj7, b3Var)) {
            g4Var.o.b(i);
        }
        if (!g4Var.a.z().E()) {
            g4Var.t(z ^ 1);
        }
        g4Var.u.b(obj7);
        g4Var.v.b(i);
        g4Var.w.b(obj7);
        if (obj8 != null) {
            this.a.L().q();
        }
        bd.b();
        if (this.a.z().B(obj7, b3Var)) {
            obj6.d.a();
        }
        this.o = z ^ 1;
    }
}
