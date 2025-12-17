package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.internal.measurement.c1;
import com.google.android.gms.internal.measurement.c4;
import com.google.android.gms.internal.measurement.cf;
import com.google.android.gms.internal.measurement.d4;
import com.google.android.gms.internal.measurement.de;
import com.google.android.gms.internal.measurement.f4;
import com.google.android.gms.internal.measurement.ic;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.m5;
import com.google.android.gms.internal.measurement.o5;
import com.google.android.gms.internal.measurement.q5;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.w8;
import com.google.android.gms.internal.measurement.wd;
import com.google.android.gms.internal.measurement.z3;
import d.e.a;
import d.e.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class t4 extends com.google.android.gms.measurement.internal.r9 implements com.google.android.gms.measurement.internal.f {

    private final Map<String, Map<String, String>> d;
    final Map<String, Map<String, Boolean>> e;
    final Map<String, Map<String, Boolean>> f;
    private final Map<String, d4> g;
    private final Map<String, Map<String, Integer>> h;
    final e<String, c1> i;
    final cf j;
    private final Map<String, String> k;
    t4(com.google.android.gms.measurement.internal.ba ba) {
        super(ba);
        a obj2 = new a();
        this.d = obj2;
        obj2 = new a();
        this.e = obj2;
        obj2 = new a();
        this.f = obj2;
        obj2 = new a();
        this.g = obj2;
        obj2 = new a();
        this.k = obj2;
        obj2 = new a();
        this.h = obj2;
        obj2 = new q4(this, 20);
        this.i = obj2;
        obj2 = new r4(this);
        this.j = obj2;
    }

    private final d4 A(String string, byte[] b2Arr2) {
        Long valueOf;
        int i;
        long l;
        final String str = "Unable to merge remote config. appId";
        if (b2Arr2 == null) {
            return d4.C();
        }
        c4 c4Var = d4.A();
        da.D(c4Var, b2Arr2);
        final w8 obj9 = (c4)c4Var.l();
        if ((d4)obj9.L()) {
            valueOf = Long.valueOf(obj9.y());
        } else {
            valueOf = i;
        }
        if (obj9.K()) {
            i = obj9.D();
        }
        this.a.b().v().c("Parsed config. version, gmp_app_id", valueOf, i);
        return obj9;
    }

    private final void B(String string, c4 c42) {
        int i;
        com.google.android.gms.measurement.internal.o3 valueOf;
        String str;
        boolean z;
        int i2;
        boolean valueOf2;
        com.google.android.gms.measurement.internal.b3 str2;
        int i3;
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        if (c42 != null) {
            i = 0;
            while (i < c42.s()) {
                valueOf = c42.t(i).q();
                if (TextUtils.isEmpty((z3)valueOf.u())) {
                } else {
                }
                String str4 = valueOf.u();
                String str6 = z5.b(valueOf.u());
                if (!TextUtils.isEmpty(str6)) {
                }
                ic.b();
                str2 = c3.z0;
                i3 = 0;
                if (!this.a.z().B(i3, str2)) {
                } else {
                }
                if (valueOf.x() && valueOf.v()) {
                }
                ic.b();
                if (!this.a.z().B(i3, str2)) {
                } else {
                }
                if (valueOf.y() && valueOf.w()) {
                }
                if (valueOf.z()) {
                }
                i++;
                if (valueOf.s() >= 2) {
                } else {
                }
                this.a.b().w().c("Invalid sampling rate. Event name, sample rate", valueOf.u(), Integer.valueOf(valueOf.s()));
                if (valueOf.s() > 65535) {
                } else {
                }
                aVar3.put(valueOf.u(), Integer.valueOf(valueOf.s()));
                if (valueOf.w()) {
                }
                aVar2.put(valueOf.u(), Boolean.TRUE);
                aVar2.put(valueOf.u(), Boolean.valueOf(valueOf.w()));
                if (valueOf.v()) {
                }
                aVar.put(str4, Boolean.TRUE);
                aVar.put(str4, Boolean.valueOf(valueOf.v()));
                valueOf.t(str6);
                c42.v(i, valueOf);
                this.a.b().w().a("EventConfig contained null event name");
            }
        }
        this.e.put(string, aVar);
        this.f.put(string, aVar2);
        this.h.put(string, aVar3);
    }

    private final void C(String string) {
        com.google.android.gms.measurement.internal.k kVar;
        Object t8Var;
        Throwable th3;
        Throwable th;
        Cursor query;
        Throwable th2;
        byte[] moveToFirst;
        String strArr2;
        Pair pair;
        boolean moveToNext;
        String[] strArr;
        int i;
        i();
        h();
        r.f(string);
        if (this.g.get(string) == null) {
            kVar = this.b.U();
            r.f(string);
            kVar.h();
            kVar.i();
            int i2 = 0;
            final int i5 = 1;
            strArr = new String[i5];
            final int i6 = 0;
            strArr[i6] = string;
            query = kVar.R().query("apps", /* result */, "app_id=?", strArr, 0, 0, 0);
            if (!query.moveToFirst()) {
                if (query != null) {
                    query.close();
                }
                pair = i2;
            } else {
                moveToFirst = query.getBlob(i6);
                if (query.moveToNext()) {
                    kVar.a.b().r().b("Got multiple records for app config, expected one. appId", q3.z(string));
                }
                if (moveToFirst == null) {
                    if (query != null) {
                    }
                } else {
                    pair = new Pair(moveToFirst, query.getString(i5));
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (pair == null) {
                this.d.put(string, i2);
                this.e.put(string, i2);
                this.f.put(string, i2);
                this.g.put(string, i2);
                this.k.put(string, i2);
                this.h.put(string, i2);
            }
            t8Var = A(string, (byte[])pair.first).q();
            B(string, (c4)t8Var);
            this.d.put(string, t4.E((d4)t8Var.l()));
            this.g.put(string, (d4)t8Var.l());
            de.b();
            if (this.a.z().B(i2, c3.r0)) {
                D(string, (d4)t8Var.l());
            }
            wd.b();
            if (this.a.z().B(i2, c3.o0)) {
                this.k.put(string, (String)pair.second);
            }
            this.k.put(string, i2);
        }
    }

    private final void D(String string, d4 d42) {
        com.google.android.gms.measurement.internal.o3 o3Var;
        String str;
        Integer valueOf;
        if (d42.w() != 0) {
            this.a.b().v().b("EES programs found", Integer.valueOf(d42.w()));
            Object obj5 = d42.F().get(0);
            c1 c1Var = new c1();
            n4 n4Var = new n4(this, string);
            c1Var.d("internal.remoteConfig", n4Var);
            p4 p4Var = new p4(this, string);
            c1Var.d("internal.appMetadata", p4Var);
            m4 m4Var = new m4(this);
            c1Var.d("internal.logger", m4Var);
            c1Var.c((q5)obj5);
            this.i.d(string, c1Var);
            this.a.b().v().c("EES program loaded for appId, activities", string, Integer.valueOf(obj5.w().w()));
            obj5 = obj5.w().z().iterator();
            for (o5 next2 : obj5) {
                this.a.b().v().b("EES program activity", next2.x());
            }
        }
        this.i.e(string);
    }

    private static final Map<String, String> E(d4 d4) {
        String next;
        String str;
        Iterator obj3;
        a aVar = new a();
        if (d4 != null) {
            obj3 = d4.G().iterator();
            for (f4 next2 : obj3) {
                aVar.put(next2.x(), next2.y());
            }
        }
        return aVar;
    }

    static c1 n(com.google.android.gms.measurement.internal.t4 t4, String string2) {
        boolean key;
        int i;
        Object obj3;
        t4.i();
        r.f(string2);
        de.b();
        if (!t4.a.z().B(0, c3.r0)) {
        } else {
            if (!t4.u(string2)) {
            } else {
                if (t4.g.containsKey(string2) && t4.g.get(string2) != null) {
                    if (t4.g.get(string2) != null) {
                        t4.D(string2, (d4)t4.g.get(string2));
                    } else {
                        t4.C(string2);
                    }
                } else {
                }
                i = obj3;
            }
        }
        return i;
    }

    static Map q(com.google.android.gms.measurement.internal.t4 t4) {
        return t4.d;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final String e(String string, String string2) {
        h();
        C(string);
        Object obj2 = this.d.get(string);
        if ((Map)obj2 != null) {
            return (String)(Map)obj2.get(string2);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean l() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final int m(String string, String string2) {
        h();
        C(string);
        Object obj2 = this.h.get(string);
        int i = 1;
        obj2 = (Map)obj2.get(string2);
        if (obj2 != null && (Integer)obj2 == null) {
            obj2 = obj2.get(string2);
            if ((Integer)(Integer)obj2 == null) {
                return i;
            }
            return (Integer)(Integer)obj2.intValue();
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final d4 o(String string) {
        i();
        h();
        r.f(string);
        C(string);
        return (d4)this.g.get(string);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final String p(String string) {
        h();
        return (String)this.k.get(string);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final void r(String string) {
        h();
        this.k.put(string, 0);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final void s(String string) {
        h();
        this.g.remove(string);
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean t(String string) {
        h();
        d4 obj1 = o(string);
        if (obj1 == null) {
            return 0;
        }
        return obj1.J();
    }

    @Override // com.google.android.gms.measurement.internal.r9
    public final boolean u(String string) {
        boolean z;
        java.lang.CharSequence obj4;
        de.b();
        int i = 0;
        if (this.a.z().B(0, c3.r0) && TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(string)) {
                return i;
            }
            obj4 = this.g.get(string);
            if ((d4)obj4 == null) {
                return i;
            }
            if ((d4)obj4.w() != 0) {
                return 1;
            }
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean v(String string) {
        return "1".equals(e(string, "measurement.upload.blacklist_internal"));
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean w(String string, String string2) {
        boolean equals;
        h();
        C(string);
        final int i2 = 1;
        if ("ecommerce_purchase".equals(string2)) {
            return i2;
        }
        if (!"purchase".equals(string2)) {
            if ("refund".equals(string2)) {
            } else {
                Object obj3 = this.f.get(string);
                int i = 0;
                obj3 = (Map)obj3.get(string2);
                if (obj3 != null && (Boolean)obj3 == null) {
                    obj3 = obj3.get(string2);
                    if ((Boolean)(Boolean)obj3 == null) {
                        return i;
                    }
                    return (Boolean)(Boolean)obj3.booleanValue();
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean x(String string, String string2) {
        boolean z;
        boolean z2;
        h();
        C(string);
        final int i2 = 1;
        if (v(string) && !ia.V(string2)) {
            if (!ia.V(string2)) {
            }
            return i2;
        }
        if (y(string) && !ia.W(string2)) {
            if (!ia.W(string2)) {
            }
            return i2;
        }
        Object obj3 = this.e.get(string);
        int i = 0;
        obj3 = (Map)obj3.get(string2);
        if (obj3 != null && (Boolean)obj3 == null) {
            obj3 = obj3.get(string2);
            if ((Boolean)(Boolean)obj3 == null) {
                return i;
            }
            return (Boolean)(Boolean)obj3.booleanValue();
        }
        return i;
    }

    @Override // com.google.android.gms.measurement.internal.r9
    final boolean y(String string) {
        return "1".equals(e(string, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.r9
    protected final boolean z(String string, byte[] b2Arr2, String string3) {
        boolean z;
        w8 w8Var;
        com.google.android.gms.measurement.internal.k z2;
        ArrayList arrayList;
        List list;
        String str;
        Object obj9;
        i();
        h();
        r.f(string);
        t8 t8Var = A(string, b2Arr2).q();
        if ((c4)t8Var == null) {
            return 0;
        }
        B(string, (c4)t8Var);
        de.b();
        final int i = 0;
        if (this.a.z().B(i, c3.r0)) {
            D(string, (d4)t8Var.l());
        }
        this.g.put(string, (d4)t8Var.l());
        this.k.put(string, string3);
        this.d.put(string, t4.E((d4)t8Var.l()));
        arrayList = new ArrayList(t8Var.w());
        this.b.U().o(string, arrayList);
        t8Var.u();
        byte[] obj8 = (d4)t8Var.l().j();
        wd.b();
        if (this.a.z().B(i, c3.o0)) {
            this.b.U().s(string, obj8, string3);
        } else {
            this.b.U().s(string, obj8, i);
        }
        this.g.put(string, (d4)t8Var.l());
        return 1;
    }
}
