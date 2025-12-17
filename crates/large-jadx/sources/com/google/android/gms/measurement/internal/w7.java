package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public final class w7 extends com.google.android.gms.measurement.internal.f4 {

    private volatile com.google.android.gms.measurement.internal.p7 c;
    private volatile com.google.android.gms.measurement.internal.p7 d;
    protected com.google.android.gms.measurement.internal.p7 e;
    private final Map<Activity, com.google.android.gms.measurement.internal.p7> f;
    private Activity g;
    private volatile boolean h;
    private volatile com.google.android.gms.measurement.internal.p7 i;
    private com.google.android.gms.measurement.internal.p7 j;
    private boolean k;
    private final Object l;
    private String m;
    public w7(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        Object obj1 = new Object();
        this.l = obj1;
        obj1 = new ConcurrentHashMap();
        this.f = obj1;
    }

    private final com.google.android.gms.measurement.internal.p7 H(Activity activity) {
        Object obj;
        com.google.android.gms.measurement.internal.p7 p7Var;
        int i;
        long l;
        r.j(activity);
        if ((p7)this.f.get(activity) == null) {
            p7Var = new p7(0, u(activity.getClass(), "Activity"), this.a.N().r0(), obj4);
            this.f.put(activity, p7Var);
            obj = p7Var;
        }
        if (this.i != null) {
            return this.i;
        }
        return obj;
    }

    private final void o(Activity activity, com.google.android.gms.measurement.internal.p7 p72, boolean z3) {
        com.google.android.gms.measurement.internal.p7 p7Var;
        Object p7Var2;
        int i;
        Object obj;
        String str2;
        com.google.android.gms.measurement.internal.p7 p7Var3;
        String str;
        int i2;
        long l2;
        boolean z;
        long l;
        final Object obj4 = this;
        Object obj2 = p72;
        p7Var = obj4.c == null ? obj4.d : obj4.c;
        if (obj2.b == null) {
            if (activity != null) {
                i = obj4.u(activity.getClass(), "Activity");
            } else {
                i = 0;
            }
            super(obj2.a, i, obj2.c, obj12, obj2.e, obj2.f, obj15);
            obj = p7Var2;
        } else {
            obj = obj2;
        }
        obj4.d = obj4.c;
        obj4.c = obj;
        super(this, obj, p7Var, obj4.a.c().a(), obj5, z3);
        obj4.a.a().z(r7Var2);
    }

    private final void p(com.google.android.gms.measurement.internal.p7 p7, com.google.android.gms.measurement.internal.p7 p72, long l3, boolean z4, Bundle bundle5) {
        Object str;
        boolean str5;
        String str2;
        int cmp;
        Object bundle3;
        int i;
        int cmp2;
        int i2;
        Bundle bundle2;
        String str4;
        long l;
        long currentTimeMillis;
        String str3;
        long l2;
        Bundle bundle;
        long obj20;
        final Object obj = this;
        final Object obj2 = p7;
        str = p72;
        final int i3 = l3;
        bundle3 = obj21;
        h();
        final int i4 = 1;
        if (str != null && Long.compare(l4, l) == 0 && ia.Z(str.b, obj2.b)) {
            if (Long.compare(l4, l) == 0) {
                if (ia.Z(str.b, obj2.b)) {
                    if (!ia.Z(str.a, obj2.a)) {
                        i2 = i4;
                    } else {
                        i2 = i;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (bundle5 != 0 && obj.e != null) {
            if (obj.e != null) {
                i = i4;
            }
        }
        if (i2 != 0) {
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            bundle = bundle2;
            ia.x(obj2, bundle, i4);
            String str6 = str.a;
            if (str != null && str6 != null) {
                str6 = str.a;
                if (str6 != null) {
                    bundle.putString("_pn", str6);
                }
                bundle3 = str.b;
                if (bundle3 != null) {
                    bundle.putString("_pc", bundle3);
                }
                bundle.putLong("_pi", str.c);
            }
            i2 = 0;
            com.google.android.gms.measurement.internal.k9 k9Var = m9Var.e;
            l = i3 - l5;
            k9Var.b = i3;
            if (i != 0 && Long.compare(l, i2) > 0) {
                k9Var = m9Var.e;
                l = i3 - l5;
                k9Var.b = i3;
                if (Long.compare(l, i2) > 0) {
                    obj.a.N().v(bundle, l);
                }
            }
            if (!obj.a.z().D()) {
                bundle.putLong("_mst", 1);
            }
            str2 = i4 != obj2.e ? "auto" : "app";
            currentTimeMillis = obj.a.c().currentTimeMillis();
            if (obj2.e) {
                obj20 = currentTimeMillis;
                currentTimeMillis = obj2.f;
                if (Long.compare(currentTimeMillis, i2) == 0) {
                    l2 = obj20;
                } else {
                    l2 = currentTimeMillis;
                }
            } else {
                obj20 = currentTimeMillis;
            }
            obj.a.I().v(str2, "_vs", l2, obj13);
        }
        if (i != 0) {
            q(obj.e, i4, i3);
        }
        obj.e = obj2;
        if (obj2.e) {
            obj.j = obj2;
        }
        obj.a.L().u(obj2);
    }

    private final void q(com.google.android.gms.measurement.internal.p7 p7, boolean z2, long l3) {
        long l;
        int i;
        this.a.y().n(this.a.c().a());
        int i2 = 0;
        if (p7 != null && p7.d) {
            i = p7.d ? 1 : i2;
        } else {
        }
        if (m9Var.e.d(i, z2, l3) && p7 != null) {
            if (p7 != null) {
                p7.d = i2;
            }
        }
    }

    static com.google.android.gms.measurement.internal.p7 r(com.google.android.gms.measurement.internal.w7 w7) {
        return w7.j;
    }

    static void v(com.google.android.gms.measurement.internal.w7 w7, com.google.android.gms.measurement.internal.p7 p72) {
        w7.j = 0;
    }

    static void w(com.google.android.gms.measurement.internal.w7 w7, com.google.android.gms.measurement.internal.p7 p72, com.google.android.gms.measurement.internal.p7 p73, long l4, boolean z5, Bundle bundle6) {
        w7.p(p72, p73, l4, obj4, bundle6);
    }

    static void x(com.google.android.gms.measurement.internal.w7 w7, Bundle bundle2, com.google.android.gms.measurement.internal.p7 p73, com.google.android.gms.measurement.internal.p7 p74, long l5) {
        bundle2.remove("screen_name");
        bundle2.remove("screen_class");
        final int i4 = 0;
        w7.p(p73, p74, l5, i4, 1);
    }

    static void y(com.google.android.gms.measurement.internal.w7 w7, com.google.android.gms.measurement.internal.p7 p72, boolean z3, long l4) {
        w7.q(p72, false, l4);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void A(Activity activity) {
        Activity activity2;
        Object obj = this.l;
        synchronized (obj) {
            this.g = 0;
            if (!this.a.z().D()) {
            }
            this.f.remove(activity);
        }
        try {
            this.f.remove(activity);
            throw activity;
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void B(Activity activity) {
        Object obj = this.l;
        this.k = false;
        int i2 = 1;
        this.h = i2;
        long l = this.a.c().a();
        int i3 = 0;
        synchronized (obj) {
            obj = this.l;
            this.k = false;
            i2 = 1;
            this.h = i2;
            l = this.a.c().a();
            i3 = 0;
        }
        this.c = i3;
        t7 t7Var = new t7(this, l, i2);
        this.a.a().z(t7Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void C(Activity activity) {
        Activity activity2;
        com.google.android.gms.measurement.internal.v7 v7Var;
        Object obj = this.l;
        this.k = true;
        int i3 = 0;
        synchronized (obj) {
            Object obj2 = this.l;
            this.g = activity;
            this.h = i3;
            synchronized (obj2) {
                obj2 = this.l;
                this.g = activity;
                this.h = i3;
            }
        }
        this.i = 0;
        v7Var = new v7(this);
        this.a.a().z(v7Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void D(Activity activity, Bundle bundle2) {
        if (!this.a.z().D()) {
        }
        if (bundle2 == null) {
        }
        Object obj5 = this.f.get(activity);
        if ((p7)obj5 == null) {
        }
        Bundle bundle = new Bundle();
        bundle.putLong("id", obj5.c);
        bundle.putString("name", obj5.a);
        bundle.putString("referrer_name", obj5.b);
        bundle2.putBundle("com.google.app_measurement.screen_service", bundle);
    }

    @Deprecated
    public final void E(Activity activity, String string2, String string3) {
        Object str;
        boolean length;
        String str2;
        String obj6;
        if (!this.a.z().D()) {
            this.a.b().x().a("setCurrentScreen cannot be called while screen reporting is disabled.");
        }
        com.google.android.gms.measurement.internal.p7 p7Var = this.c;
        if (p7Var == null) {
            this.a.b().x().a("setCurrentScreen cannot be called while no activity active");
        }
        if (this.f.get(activity) == null) {
            this.a.b().x().a("setCurrentScreen must be called with an activity in the activity lifecycle");
        }
        if (string3 == null) {
            obj6 = u(activity.getClass(), "Activity");
        }
        if (ia.Z(p7Var.b, obj6) && !ia.Z(p7Var.a, string2)) {
            if (!ia.Z(p7Var.a, string2)) {
            }
            this.a.b().x().a("setCurrentScreen cannot be called with the same class and name");
        }
        int i = 100;
        this.a.z();
        if (string2 != null && string2.length() > 0 && string2.length() <= i) {
            if (string2.length() > 0) {
                this.a.z();
                if (string2.length() <= i) {
                }
            }
            this.a.b().x().b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(string2.length()));
        }
        this.a.z();
        if (obj6 != null && obj6.length() > 0 && obj6.length() <= i) {
            if (obj6.length() > 0) {
                this.a.z();
                if (obj6.length() <= i) {
                }
            }
            this.a.b().x().b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(obj6.length()));
        }
        str2 = string2 == null ? "null" : string2;
        final String str5 = "Setting current screen to name, class";
        this.a.b().v().c(str5, str2, obj6);
        p7 p7Var2 = new p7(string2, obj6, this.a.N().r0(), str5);
        this.f.put(activity, p7Var2);
        o(activity, p7Var2, true);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void F(Bundle bundle, long l2) {
        com.google.android.gms.measurement.internal.p7 p7Var;
        String str2;
        com.google.android.gms.measurement.internal.p7 p7Var2;
        String str3;
        int length2;
        String string;
        boolean z;
        String str;
        com.google.android.gms.measurement.internal.b5 length;
        String str4;
        com.google.android.gms.measurement.internal.b5 b5Var;
        Object obj = this.l;
        synchronized (obj) {
            this.a.b().x().a("Cannot log screen view event when the app is in the background.");
        }
        str3 = "null";
        str = str4 == null ? "null" : str4;
        o3Var.c("Logging screen view with name, class", str3, str);
        p7Var = this.c == null ? this.d : this.c;
        super(string2, str4, this.a.N().r0(), obj6, 1, l2, obj9);
        this.c = p7Var4;
        this.d = p7Var;
        this.i = p7Var4;
        super(this, bundle, p7Var4, p7Var, this.a.c().a(), obj11);
        this.a.a().z(obj15);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void G(String string, com.google.android.gms.measurement.internal.p7 p72) {
        String equals;
        h();
        equals = this.m;
        synchronized (this) {
            if (!equals.equals(string)) {
                if (p72 != null) {
                    this.m = string;
                }
            } else {
            }
            try {
                throw string;
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final com.google.android.gms.measurement.internal.p7 s() {
        return this.c;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final com.google.android.gms.measurement.internal.p7 t(boolean z) {
        i();
        h();
        if (!z) {
            return this.e;
        }
        com.google.android.gms.measurement.internal.p7 obj1 = this.e;
        if (obj1 != null) {
            return obj1;
        }
        return this.j;
    }

    final String u(Class<?> class, String string2) {
        String obj2;
        int obj3;
        obj2 = class.getCanonicalName();
        if (obj2 == null) {
            return "Activity";
        }
        obj2 = obj2.split("\\.");
        obj3 = obj2.length;
        obj2 = obj3 > 0 ? obj2[obj3] : "";
        this.a.z();
        int i = 100;
        if (obj2.length() > i) {
            this.a.z();
            obj2 = obj2.substring(0, i);
        }
        return obj2;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void z(Activity activity, Bundle bundle2) {
        if (!this.a.z().D()) {
        }
        if (bundle2 == null) {
        }
        Bundle obj7 = bundle2.getBundle("com.google.app_measurement.screen_service");
        if (obj7 == null) {
        }
        p7 p7Var = new p7(obj7.getString("name"), obj7.getString("referrer_name"), obj7.getLong("id"), obj4);
        this.f.put(activity, p7Var);
    }
}
