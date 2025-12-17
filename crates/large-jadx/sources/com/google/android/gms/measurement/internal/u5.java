package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.h;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.o;
import com.google.android.gms.internal.measurement.b;
import com.google.android.gms.internal.measurement.c;
import com.google.android.gms.internal.measurement.c1;
import com.google.android.gms.internal.measurement.de;
import com.google.android.gms.internal.measurement.k7;
import d.e.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public final class u5 extends com.google.android.gms.measurement.internal.f3 {

    private final com.google.android.gms.measurement.internal.ba a;
    private Boolean b;
    private String c = null;
    public u5(com.google.android.gms.measurement.internal.ba ba, String string2) {
        super();
        r.j(ba);
        this.a = ba;
        final int obj1 = 0;
    }

    private final void m(String string, boolean z2) {
        int callingUid;
        boolean obj5;
        if (TextUtils.isEmpty(string)) {
        } else {
            int i = 0;
            int i2 = 1;
            if (z2 != null) {
                if (this.b == null) {
                    if (!"com.google.android.gms".equals(this.c) && !o.a(this.a.f(), Binder.getCallingUid())) {
                        if (!o.a(this.a.f(), Binder.getCallingUid())) {
                            if (i.a(this.a.f()).c(Binder.getCallingUid())) {
                                obj5 = i2;
                            } else {
                                obj5 = i;
                            }
                        } else {
                        }
                    } else {
                    }
                    this.b = Boolean.valueOf(obj5);
                }
                try {
                    if (!this.b.booleanValue() && this.c == null && h.k(this.a.f(), Binder.getCallingUid(), string)) {
                    }
                    if (this.c == null) {
                    }
                    if (h.k(this.a.f(), Binder.getCallingUid(), string)) {
                    }
                    this.c = string;
                    if (!string.equals(this.c)) {
                    } else {
                    }
                    Object[] arr = new Object[i2];
                    arr[i] = string;
                    obj5 = new SecurityException(String.format("Unknown calling package name '%s'.", arr));
                    throw obj5;
                    com.google.android.gms.measurement.internal.ba baVar = this.a;
                    baVar = baVar.b();
                    baVar = baVar.r();
                    string = q3.z(string);
                    baVar.b("Measurement Service called with invalid calling package. appId", string);
                    throw z2;
                    obj5 = "Measurement Service called without app package";
                    this.a.b().r().a(obj5);
                    SecurityException obj4 = new SecurityException(obj5);
                    throw obj4;
                }
            } else {
            }
        }
    }

    private final void n(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        this.a.e();
        this.a.i(u, na2);
    }

    static com.google.android.gms.measurement.internal.ba q2(com.google.android.gms.measurement.internal.u5 u5) {
        return u5.a;
    }

    static void r2(com.google.android.gms.measurement.internal.u5 u5, com.google.android.gms.measurement.internal.u u2, com.google.android.gms.measurement.internal.na na3) {
        u5.n(u2, na3);
    }

    private final void v2(com.google.android.gms.measurement.internal.na na, boolean z2) {
        r.j(na);
        r.f(na.a);
        m(na.a, false);
        this.a.f0().K(na.b, na.I, na.M);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void A0(com.google.android.gms.measurement.internal.na na) {
        v2(na, false);
        l5 l5Var = new l5(this, na);
        u2(l5Var);
    }

    public final List<com.google.android.gms.measurement.internal.ea> E1(com.google.android.gms.measurement.internal.na na, boolean z2) {
        int size;
        boolean eaVar;
        v2(na, false);
        String str = na.a;
        r.j(str);
        r5 r5Var = new r5(this, str);
        Object obj = this.a.a().s(r5Var).get();
        ArrayList arrayList = new ArrayList((List)obj.size());
        Iterator iterator = obj.iterator();
        while (iterator.hasNext()) {
            size = iterator.next();
            if (z2 == null) {
            } else {
            }
            eaVar = new ea((ga)size);
            arrayList.add(eaVar);
            if (!ia.V(size.c)) {
            }
        }
        return arrayList;
    }

    public final List<com.google.android.gms.measurement.internal.ea> F(String string, String string2, String string3, boolean z4) {
        int size;
        com.google.android.gms.measurement.internal.h5 h5Var;
        m(string, true);
        h5Var = new h5(this, string, string2, string3);
        Object obj4 = this.a.a().s(h5Var).get();
        ArrayList obj5 = new ArrayList((List)obj4.size());
        obj4 = obj4.iterator();
        while (obj4.hasNext()) {
            size = obj4.next();
            if (z4 == null) {
            } else {
            }
            h5Var = new ea((ga)size);
            obj5.add(h5Var);
            if (ia.V(size.c) == null) {
            }
        }
        return obj5;
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void J(com.google.android.gms.measurement.internal.na na) {
        r.f(na.a);
        m(na.a, false);
        k5 k5Var = new k5(this, na);
        u2(k5Var);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void J1(com.google.android.gms.measurement.internal.ea ea, com.google.android.gms.measurement.internal.na na2) {
        r.j(ea);
        v2(na2, false);
        q5 q5Var = new q5(this, ea, na2);
        u2(q5Var);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void M0(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        r.j(u);
        v2(na2, false);
        n5 n5Var = new n5(this, u, na2);
        u2(n5Var);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void M1(com.google.android.gms.measurement.internal.u u, String string2, String string3) {
        r.j(u);
        r.f(string2);
        m(string2, true);
        o5 obj3 = new o5(this, u, string2);
        u2(obj3);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final String R(com.google.android.gms.measurement.internal.na na) {
        v2(na, false);
        return this.a.h0(na);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void T0(com.google.android.gms.measurement.internal.na na) {
        r.f(na.a);
        r.j(na.N);
        m5 m5Var = new m5(this, na);
        r.j(m5Var);
        if (this.a.a().C()) {
            m5Var.run();
        }
        this.a.a().A(m5Var);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void U0(long l, String string2, String string3, String string4) {
        super(this, string4, obj13, string3, l, obj6);
        u2(t5Var2);
    }

    public final List<com.google.android.gms.measurement.internal.ea> Z0(String string, String string2, boolean z3, com.google.android.gms.measurement.internal.na na4) {
        int size;
        com.google.android.gms.measurement.internal.y4 eaVar;
        v2(na4, false);
        String str = na4.a;
        r.j(str);
        f5 f5Var = new f5(this, str, string, string2);
        Object obj4 = this.a.a().s(f5Var).get();
        ArrayList obj5 = new ArrayList((List)obj4.size());
        obj4 = obj4.iterator();
        while (obj4.hasNext()) {
            size = obj4.next();
            if (z3 == null) {
            } else {
            }
            eaVar = new ea((ga)size);
            obj5.add(eaVar);
            if (ia.V(size.c) == null) {
            }
        }
        return obj5;
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void a0(com.google.android.gms.measurement.internal.c c) {
        r.j(c);
        r.j(c.c);
        r.f(c.a);
        m(c.a, true);
        c cVar = new c(c);
        e5 obj3 = new e5(this, cVar);
        u2(obj3);
    }

    public final List<com.google.android.gms.measurement.internal.c> b0(String string, String string2, String string3) {
        m(string, true);
        j5 j5Var = new j5(this, string, string2, string3);
        return (List)this.a.a().s(j5Var).get();
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final byte[] f0(com.google.android.gms.measurement.internal.u u, String string2) {
        Object bArr;
        Object p5Var;
        Object obj;
        r.f(string2);
        r.j(u);
        m(string2, true);
        this.a.b().q().b("Log and bundle. event", this.a.V().d(u.a));
        int i3 = 1000000;
        p5Var = new p5(this, u, string2);
        if ((byte[])this.a.a().t(p5Var).get() == null) {
            this.a.b().r().b("Log and bundle returned null. appId", q3.z(string2));
            bArr = new byte[0];
        }
        this.a.b().q().d("Log and bundle processed. event, size, time_ms", this.a.V().d(u.a), Integer.valueOf(bArr.length), Long.valueOf(i5 -= i2));
        return bArr;
    }

    @Override // com.google.android.gms.measurement.internal.f3
    final com.google.android.gms.measurement.internal.u p2(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        String equals;
        boolean obj10;
        obj10 = u.b;
        if ("_cmp".equals(u.a) && obj10 != null) {
            obj10 = u.b;
            if (obj10 != null) {
                if (obj10.zza() == 0) {
                } else {
                    obj10 = u.b.o2("_cis");
                    if (!"referrer broadcast".equals(obj10) && "referrer API".equals(obj10)) {
                        if ("referrer API".equals(obj10)) {
                        }
                    }
                }
                this.a.b().u().b("Event has been filtered ", u.toString());
                super("_cmpx", u.b, u.c, u.v, obj7);
                return obj10;
            }
        }
        return u;
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void q0(com.google.android.gms.measurement.internal.na na) {
        v2(na, false);
        s5 s5Var = new s5(this, na);
        u2(s5Var);
    }

    public final List<com.google.android.gms.measurement.internal.c> s0(String string, String string2, com.google.android.gms.measurement.internal.na na3) {
        v2(na3, false);
        final String obj5 = na3.a;
        r.j(obj5);
        i5 i5Var = new i5(this, obj5, string, string2);
        return (List)this.a.a().s(i5Var).get();
    }

    @Override // com.google.android.gms.measurement.internal.f3
    final void s2(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        Object t4Var;
        b next;
        boolean z;
        String str2;
        boolean empty;
        b bVar;
        com.google.android.gms.measurement.internal.b3 str;
        int i;
        com.google.android.gms.measurement.internal.u obj8;
        if (!this.a.Y().u(na2.a)) {
            n(u, na2);
        }
        this.a.b().v().b("EES config found for", na2.a);
        t4Var = this.a.Y();
        String str6 = na2.a;
        de.b();
        if (t4Var.a.z().B(0, c3.r0)) {
            if (TextUtils.isEmpty(str6)) {
            } else {
                i = t4Var;
            }
        }
        if (i != 0 && z5.a(u.a) == null) {
            if (z5.a(u.a) == null) {
                str2 = u.a;
            }
            bVar = new b(str2, u.v, obj6, this.a.e0().K(u.b.k2(), true));
            if (!i.e(bVar)) {
                this.a.b().v().b("EES was not applied to event", u.a);
                n(u, na2);
            } else {
                if (i.g()) {
                    this.a.b().v().b("EES edited event", u.a);
                    n(this.a.e0().B(i.a().b()), na2);
                } else {
                    n(u, na2);
                }
                if (i.f()) {
                    obj8 = i.a().c().iterator();
                    for (b next2 : obj8) {
                        this.a.b().v().b("EES logging created event", next2.d());
                        n(this.a.e0().B(next2), na2);
                    }
                }
            }
        }
        this.a.b().v().b("EES not loaded for", na2.a);
        n(u, na2);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void t(Bundle bundle, com.google.android.gms.measurement.internal.na na2) {
        v2(na2, false);
        final String obj3 = na2.a;
        r.j(obj3);
        c5 c5Var = new c5(this, obj3, bundle);
        u2(c5Var);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    final void t2(String string, Bundle bundle2) {
        long withOnConflict;
        Object str;
        int obj14;
        com.google.android.gms.measurement.internal.k kVar = this.a.U();
        kVar.h();
        kVar.i();
        super(kVar.a, "", string, "dep", 0, obj7, 0, obj9, bundle2);
        obj14 = kVar.b.e0().C(pVar2).j();
        kVar.a.b().v().c("Saving default event parameters, appId, data size", kVar.a.D().d(string), Integer.valueOf(obj14.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("parameters", obj14);
        if (Long.compare(withOnConflict, i2) == 0) {
            kVar.a.b().r().b("Failed to insert default event parameters (got -1). appId", q3.z(string));
        }
    }

    @Override // com.google.android.gms.measurement.internal.f3
    final void u2(Runnable runnable) {
        r.j(runnable);
        if (this.a.a().C()) {
            runnable.run();
        }
        this.a.a().z(runnable);
    }

    @Override // com.google.android.gms.measurement.internal.f3
    public final void z(com.google.android.gms.measurement.internal.c c, com.google.android.gms.measurement.internal.na na2) {
        r.j(c);
        r.j(c.c);
        v2(na2, false);
        c cVar = new c(c);
        cVar.a = na2.a;
        d5 obj2 = new d5(this, cVar, na2);
        u2(obj2);
    }
}
