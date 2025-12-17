package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.n.a;
import com.google.android.gms.common.o.b;
import com.google.android.gms.common.o.c;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.d4;
import com.google.android.gms.internal.measurement.de;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.j5;
import com.google.android.gms.internal.measurement.k7;
import com.google.android.gms.internal.measurement.kd;
import com.google.android.gms.internal.measurement.me;
import com.google.android.gms.internal.measurement.o4;
import com.google.android.gms.internal.measurement.p4;
import com.google.android.gms.internal.measurement.pb;
import com.google.android.gms.internal.measurement.s4;
import com.google.android.gms.internal.measurement.t4;
import com.google.android.gms.internal.measurement.t8;
import com.google.android.gms.internal.measurement.w4;
import com.google.android.gms.internal.measurement.w8;
import com.google.android.gms.internal.measurement.x4;
import com.google.android.gms.internal.measurement.y4;
import com.google.android.gms.internal.measurement.z4;
import d.e.a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public final class ba implements com.google.android.gms.measurement.internal.x5 {

    private static volatile com.google.android.gms.measurement.internal.ba C;
    private final Map<String, com.google.android.gms.measurement.internal.h> A;
    private final com.google.android.gms.measurement.internal.ha B;
    private final com.google.android.gms.measurement.internal.t4 a;
    private final com.google.android.gms.measurement.internal.w3 b;
    private com.google.android.gms.measurement.internal.k c;
    private com.google.android.gms.measurement.internal.y3 d;
    private com.google.android.gms.measurement.internal.p9 e;
    private com.google.android.gms.measurement.internal.xa f;
    private final com.google.android.gms.measurement.internal.da g;
    private com.google.android.gms.measurement.internal.n7 h;
    private com.google.android.gms.measurement.internal.x8 i;
    private final com.google.android.gms.measurement.internal.s9 j;
    private com.google.android.gms.measurement.internal.j4 k;
    private final com.google.android.gms.measurement.internal.b5 l;
    private boolean m = false;
    private boolean n;
    long o;
    private List<Runnable> p;
    private int q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private FileLock v;
    private FileChannel w;
    private List<Long> x;
    private List<Long> y;
    private long z = -1;
    ba(com.google.android.gms.measurement.internal.ca ca, com.google.android.gms.measurement.internal.b5 b52) {
        super();
        int obj4 = 0;
        obj4 = new y9(this);
        this.B = obj4;
        r.j(ca);
        int i = 0;
        this.l = b5.H(ca.a, i, i);
        int i2 = -1;
        obj4 = new s9(this);
        this.j = obj4;
        obj4 = new da(this);
        obj4.j();
        this.g = obj4;
        obj4 = new w3(this);
        obj4.j();
        this.b = obj4;
        obj4 = new t4(this);
        obj4.j();
        this.a = obj4;
        obj4 = new HashMap();
        this.A = obj4;
        t9 t9Var = new t9(this, ca);
        a().z(t9Var);
    }

    static final void D(o4 o4, int i2, String string3) {
        int i;
        boolean equals;
        String str;
        List list = o4.H();
        i = 0;
        int size = list.size();
        str = "_err";
        while (i < size) {
            i++;
            size = list.size();
            str = "_err";
        }
        s4 s4Var = t4.A();
        s4Var.B(str);
        s4Var.A(Long.valueOf((long)i2).longValue());
        s4 s4Var2 = t4.A();
        s4Var2.B("_ev");
        s4Var2.C(string3);
        o4.x((t4)s4Var.l());
        o4.x((t4)s4Var2.l());
    }

    static final void E(o4 o4, String string2) {
        int i;
        boolean equals;
        final List list = o4.H();
        i = 0;
        while (i < list.size()) {
            i++;
        }
    }

    private final com.google.android.gms.measurement.internal.na G(String string) {
        Object g5Var;
        boolean empty;
        Boolean booleanValue;
        int i;
        final Object obj = this;
        String str = string;
        com.google.android.gms.measurement.internal.k kVar = obj.c;
        ba.Q(kVar);
        g5Var = kVar.T(str);
        int i2 = 0;
        if (g5Var != null) {
            if (TextUtils.isEmpty(g5Var.h0())) {
            } else {
                booleanValue = obj.H(g5Var);
                if (booleanValue != null && booleanValue.booleanValue()) {
                    if (booleanValue.booleanValue()) {
                    }
                    b().r().b("App version does not match; dropping. appId", q3.z(string));
                    return i2;
                }
                final long l2 = g5Var.M();
                final long l4 = g5Var.X();
                final String str13 = g5Var.i0();
                final Boolean bool2 = g5Var.b0();
                kd.b();
                boolean z = S().B(str, c3.d0);
                if (z) {
                    i = g5Var;
                } else {
                    i = i2;
                }
            }
            super(string, g5Var.k0(), g5Var.h0(), l2, l2, g5Var.g0(), l4, l4, g5Var.U(), z, 0, g5Var.K(), 0, str13, g5Var.A(), str13, 0, obj19, 0, g5Var.J(), 0, g5Var.c0(), bool2, g5Var.V(), bool2, g5Var.c(), i, T(string).i());
            return naVar2;
        }
        b().q().b("No app data available; dropping", str);
        return i2;
    }

    private final Boolean H(com.google.android.gms.measurement.internal.g5 g5) {
        String versionName;
        int i;
        String str;
        long l;
        String obj6;
        try {
            i = 0;
            if (Long.compare(l2, i2) != 0) {
            } else {
            }
            if (Long.compare(i, l) == 0) {
            }
            return Boolean.TRUE;
            obj6 = g5.h0();
            if (obj6 != null && obj6.equals(packageInfo.versionName)) {
            }
            if (obj6.equals(versionName)) {
            }
            return Boolean.TRUE;
            return Boolean.FALSE;
            g5 = 0;
            return g5;
        }
    }

    private final void I() {
        boolean z;
        String next;
        a().h();
        if (!this.s && !this.t) {
            if (!this.t) {
                if (this.u) {
                } else {
                    b().v().a("Stopping uploading service(s)");
                    List list = this.p;
                    if (list == null) {
                    }
                    Iterator iterator = list.iterator();
                    for (Runnable next : iterator) {
                        next.run();
                    }
                }
                List list2 = this.p;
                r.j(list2);
                (List)list2.clear();
            }
        }
        b().v().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.s), Boolean.valueOf(this.t), Boolean.valueOf(this.u));
    }

    private final void J(y4 y4, long l2, boolean z3) {
        String str;
        com.google.android.gms.measurement.internal.ga gaVar;
        Object str2;
        String str5;
        String str3;
        String str4;
        long currentTimeMillis;
        Long valueOf;
        com.google.android.gms.measurement.internal.ga gaVar2;
        String obj11;
        int obj12;
        long obj13;
        int obj14;
        final int i = 1;
        str = i != obj14 ? "_lte" : "_se";
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        com.google.android.gms.measurement.internal.ga gaVar3 = kVar.Z(y4.d0(), str);
        if (gaVar3 != null) {
            if (gaVar3.e == null) {
                super(y4.d0(), "auto", str, c().currentTimeMillis(), obj7, Long.valueOf(l2));
            } else {
                super(y4.d0(), "auto", str, c().currentTimeMillis(), obj7, Long.valueOf(longValue2 += l2));
            }
        } else {
        }
        i5 i5Var = j5.z();
        i5Var.x(str);
        i5Var.y(c().currentTimeMillis());
        i5Var.w((Long)gaVar2.e.longValue());
        w8 w8Var = i5Var.l();
        int i2 = da.x(y4, str);
        if (i2 >= 0) {
            y4.a0(i2, (j5)w8Var);
        } else {
            y4.u0(w8Var);
        }
        if (Long.compare(l2, i3) > 0) {
            obj11 = this.c;
            ba.Q(obj11);
            obj11.z(gaVar2);
            obj11 = i != obj14 ? "lifetime" : "session-scoped";
            b().v().c("Updated engagement user property. scope, value", obj11, gaVar2.e);
        }
    }

    private final void K(o4 o4, o4 o42) {
        Object str;
        long cmp;
        int cmp2;
        long l;
        Object obj10;
        r.a("_e".equals(o4.G()));
        ba.Q(this.g);
        String str4 = "_et";
        str = da.o((p4)o4.l(), str4);
        if (str != null && str.R()) {
            if (str.R()) {
                cmp2 = 0;
                if (Long.compare(l2, cmp2) <= 0) {
                } else {
                    ba.Q(this.g);
                    t4 t4Var = da.o((p4)o42.l(), str4);
                    if (t4Var != null && Long.compare(l, cmp2) > 0) {
                        if (Long.compare(l, cmp2) > 0) {
                            cmp += cmp2;
                        }
                    }
                    ba.Q(this.g);
                    da.m(o42, str4, Long.valueOf(cmp));
                    ba.Q(this.g);
                    da.m(o4, "_fr", Long.valueOf(1));
                }
            }
        }
    }

    private final void L() {
        int cmp3;
        long currentTimeMillis2;
        long l4;
        int cmp5;
        boolean z2;
        long currentTimeMillis;
        int cmp;
        boolean z;
        String equals;
        Object obj;
        long l3;
        long l7;
        long l6;
        int cmp2;
        int i2;
        long l8;
        int i;
        boolean empty;
        long l;
        int i3;
        long l5;
        int cmp4;
        long l2;
        final Object obj2 = this;
        a().h();
        g();
        int i8 = 0;
        i4 -= l12;
        if (Long.compare(l9, i8) > 0 && Long.compare(cmp3, i8) > 0) {
            i4 -= l12;
            if (Long.compare(cmp3, i8) > 0) {
                b().v().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(cmp3));
                X().c();
                com.google.android.gms.measurement.internal.p9 p9Var = obj2.e;
                ba.Q(p9Var);
                p9Var.m();
            }
            obj2.o = i8;
        }
        if (obj2.l.r()) {
            if (!O()) {
            } else {
                currentTimeMillis2 = c().currentTimeMillis();
                S();
                int i11 = 0;
                long l16 = Math.max(i8, obj4);
                com.google.android.gms.measurement.internal.k kVar = obj2.c;
                ba.Q(kVar);
                i = 1;
                if (!kVar.v()) {
                    com.google.android.gms.measurement.internal.k kVar2 = obj2.c;
                    ba.Q(kVar2);
                    if (kVar2.u()) {
                    } else {
                        i = 0;
                    }
                }
                if (i != 0) {
                    equals = S().u();
                    if (!TextUtils.isEmpty(equals) && !".none.".equals(equals)) {
                        if (!".none.".equals(equals)) {
                            S();
                            l = Math.max(i8, obj4);
                        } else {
                            S();
                            l = Math.max(i8, obj4);
                        }
                    } else {
                    }
                } else {
                    S();
                    l = Math.max(i8, obj4);
                }
                com.google.android.gms.measurement.internal.k kVar3 = obj2.c;
                ba.Q(kVar3);
                com.google.android.gms.measurement.internal.k kVar4 = obj2.c;
                ba.Q(kVar4);
                l7 = kVar4.P();
                l3 = Math.max(kVar3.O(), i);
                if (Long.compare(l3, i8) == 0) {
                    cmp2 = i8;
                } else {
                    l3 = currentTimeMillis2 - l14;
                    l8 = currentTimeMillis2 - l19;
                    long l10 = Math.max(currentTimeMillis2 -= l17, obj2);
                    cmp2 = l3 + l20;
                    if (i != 0 && Long.compare(l10, i8) > 0) {
                        if (Long.compare(l10, i8) > 0) {
                            l18 += l;
                        }
                    }
                    com.google.android.gms.measurement.internal.da daVar2 = obj2.g;
                    ba.Q(daVar2);
                    if (daVar2.O(l10, obj2) == 0) {
                        cmp2 = l10 + l;
                    }
                    if (Long.compare(l8, i8) != 0 && Long.compare(l8, l3) >= 0) {
                        if (Long.compare(l8, l3) >= 0) {
                            currentTimeMillis2 = 0;
                            S();
                            l7 = 0L;
                            while (currentTimeMillis2 < Math.min(20, Math.max(0L, (Integer)c3.C.a(l7).intValue()))) {
                                S();
                                if (Long.compare(cmp2, l8) <= 0) {
                                    break;
                                }
                                currentTimeMillis2++;
                                S();
                                l7 = 0L;
                            }
                        }
                    }
                }
                com.google.android.gms.measurement.internal.w3 w3Var = obj2.b;
                ba.Q(w3Var);
                l4 = x8Var.h.a();
                S();
                int i12 = 0;
                long l13 = Math.max(i8, obj4);
                com.google.android.gms.measurement.internal.da daVar = obj2.g;
                ba.Q(daVar);
                if (Long.compare(cmp2, i8) != 0 && w3Var.m() && !daVar.O(l4, currentTimeMillis)) {
                    w3Var = obj2.b;
                    ba.Q(w3Var);
                    if (w3Var.m()) {
                        l4 = x8Var.h.a();
                        S();
                        i12 = 0;
                        l13 = Math.max(i8, obj4);
                        daVar = obj2.g;
                        ba.Q(daVar);
                        if (!daVar.O(l4, currentTimeMillis)) {
                            cmp2 = Math.max(cmp2, obj8);
                        }
                        X().c();
                        if (Long.compare(i2, i8) <= 0) {
                            S();
                            int i6 = 0;
                            i2 = Math.max(i8, obj4);
                            x8Var2.i.b(c().currentTimeMillis());
                        }
                        b().v().b("Upload scheduled in approximately ms", Long.valueOf(i2));
                        com.google.android.gms.measurement.internal.p9 p9Var3 = obj2.e;
                        ba.Q(p9Var3);
                        p9Var3.n(i2);
                    }
                    b().v().a("No network");
                    X().b();
                    com.google.android.gms.measurement.internal.p9 p9Var2 = obj2.e;
                    ba.Q(p9Var2);
                    p9Var2.m();
                }
            }
            b().v().a("Next upload time is 0");
            X().c();
            com.google.android.gms.measurement.internal.p9 p9Var4 = obj2.e;
            ba.Q(p9Var4);
            p9Var4.m();
        }
        b().v().a("Nothing to upload or uploading impossible");
        X().c();
        com.google.android.gms.measurement.internal.p9 p9Var5 = obj2.e;
        ba.Q(p9Var5);
        p9Var5.m();
    }

    private final boolean M(com.google.android.gms.measurement.internal.na na) {
        boolean empty;
        Object obj4;
        kd.b();
        int i = 0;
        int i2 = 1;
        if (S().B(na.a, c3.d0) && TextUtils.isEmpty(na.b) && TextUtils.isEmpty(na.M) && !TextUtils.isEmpty(na.I)) {
            if (TextUtils.isEmpty(na.b)) {
                if (TextUtils.isEmpty(na.M)) {
                    if (!TextUtils.isEmpty(na.I)) {
                    }
                    return i;
                }
            }
            return i2;
        }
        if (TextUtils.isEmpty(na.b) && !TextUtils.isEmpty(na.I)) {
            if (!TextUtils.isEmpty(na.I)) {
            }
            return i;
        }
        return i2;
    }

    private final boolean N(String string, long l2) {
        Throwable th;
        String arrayList2;
        Object iterator2;
        int i8;
        Object daVar;
        int i23;
        com.google.android.gms.measurement.internal.aa aaVar2;
        com.google.android.gms.measurement.internal.k kVar;
        int equals6;
        String equals5;
        int i22;
        String str26;
        int equals2;
        boolean next;
        int z5;
        ArrayList arrayList;
        boolean next2;
        String str17;
        int i17;
        int i2;
        boolean z3;
        boolean equals4;
        String str23;
        t8 t8Var;
        long l;
        boolean booleanValue4;
        SQLiteDatabase sQLiteDatabase;
        t8 t8Var2;
        int z;
        boolean equalsIgnoreCase;
        com.google.android.gms.measurement.internal.aa aaVar;
        int i13;
        Object g5Var;
        d4 empty2;
        int i9;
        String[] strArr;
        List empty;
        t8 length;
        p4 longValue;
        String cmp3;
        SecureRandom secureRandom;
        int xaVar;
        int cmp2;
        long l5;
        int cmp5;
        int str9;
        boolean equals3;
        int codePointAt;
        int str14;
        String str25;
        String str8;
        String str12;
        boolean z2;
        String str;
        List insert;
        Long currentTimeMillis;
        boolean str6;
        String str7;
        String str3;
        Object str21;
        int i5;
        String str2;
        List contentValues;
        Long cmp;
        Boolean booleanValue;
        com.google.android.gms.measurement.internal.t4 t4Var;
        boolean booleanValue3;
        w8 iterator;
        com.google.android.gms.measurement.internal.b3 b3Var;
        Long valueOf3;
        boolean booleanValue2;
        com.google.android.gms.measurement.internal.o3 cmp4;
        Integer valueOf;
        String longValue4;
        String str13;
        Object str20;
        String str22;
        Long valueOf6;
        int long;
        Object valueOf4;
        String str19;
        String equals7;
        int i4;
        String longValue2;
        String str11;
        String str27;
        String str4;
        boolean loggable;
        int valueOf2;
        boolean empty3;
        int i3;
        t8 t8Var3;
        boolean valueOf5;
        int i16;
        int i;
        String letter;
        boolean equals;
        String str10;
        int i18;
        int longValue3;
        int i12;
        int i20;
        int i26;
        int i19;
        int i6;
        String str5;
        int i21;
        Object obj2;
        long l3;
        int i28;
        com.google.android.gms.measurement.internal.ia iaVar;
        boolean z4;
        Object obj;
        String str16;
        int i14;
        String str15;
        String str18;
        int i29;
        String str24;
        int i10;
        int i11;
        int i7;
        int i25;
        int i15;
        int i27;
        int i24;
        long l4;
        SecureRandom obj50;
        final Object obj3 = this;
        arrayList2 = "_sn";
        str26 = "_npa";
        str23 = "_ai";
        com.google.android.gms.measurement.internal.k kVar10 = obj3.c;
        ba.Q(kVar10);
        kVar10.g0();
        int i52 = 0;
        aaVar = new aa(obj3, i52);
        com.google.android.gms.measurement.internal.k kVar12 = obj3.c;
        ba.Q(kVar12);
        kVar12.I(0, l2, l24, obj3.z);
        empty = aaVar.c;
        if (empty != null) {
            if (empty.isEmpty()) {
            } else {
                (y4)aaVar.a.q().y0();
                z2 = S().B(aaVar.a.L1(), c3.U);
                i20 = i12;
                codePointAt = -1;
                i4 = 0;
                valueOf2 = -1;
                i16 = 0;
                longValue3 = 0;
                i26 = 0;
                str13 = "_fr";
                equals7 = "_et";
                str5 = str26;
                equals2 = "_e";
                i21 = i16;
                while (i4 < aaVar.c.size()) {
                    str2 = (p4)aaVar.c.get(i4).q();
                    com.google.android.gms.measurement.internal.t4 t4Var15 = obj3.a;
                    ba.Q(t4Var15);
                    i28 = i4;
                    letter = "_err";
                    if (t4Var15.x(aaVar.a.L1(), (o4)str2.G())) {
                    } else {
                    }
                    str2.A(str23);
                    b().v().a("Renaming ad_impression to _ai");
                    if (str2.G().equals(z5.a(str23)) && Log.isLoggable(b().C(), 5)) {
                    }
                    obj = str23;
                    com.google.android.gms.measurement.internal.t4 t4Var5 = obj3.a;
                    ba.Q(t4Var5);
                    z = t4Var5.w(aaVar.a.L1(), str2.G());
                    String str94 = "_c";
                    if (!z) {
                    } else {
                    }
                    str16 = arrayList2;
                    iaVar = z2;
                    i6 = valueOf2;
                    i22 = 0;
                    i5 = 0;
                    i18 = 0;
                    equals7 = "_r";
                    while (i22 < str2.s()) {
                        if (str94.equals(str2.F(i22).C())) {
                        } else {
                        }
                        valueOf2 = length;
                        str15 = codePointAt;
                        if (equals7.equals(str2.F(i22).C())) {
                        } else {
                        }
                        str12 = str13;
                        i22++;
                        str13 = str12;
                        length = valueOf2;
                        equals7 = i14;
                        codePointAt = str15;
                        equals7 = "_r";
                        t8 t8Var7 = str2.F(i22).q();
                        str12 = str13;
                        (s4)t8Var7.A(1);
                        str2.C(i22, (t4)t8Var7.l());
                        i18 = 1;
                        t8 t8Var8 = str2.F(i22).q();
                        valueOf2 = length;
                        str15 = codePointAt;
                        (s4)t8Var8.A(1);
                        str2.C(i22, (t4)t8Var8.l());
                        str12 = str13;
                        i5 = 1;
                    }
                    t8Var3 = length;
                    str15 = codePointAt;
                    codePointAt = str13;
                    if (i5 == 0 && z) {
                    } else {
                    }
                    str3 = codePointAt;
                    if (i18 == 0) {
                    }
                    com.google.android.gms.measurement.internal.k kVar6 = obj3.c;
                    ba.Q(kVar6);
                    longValue4 = equals2;
                    if (Long.compare(length, l10) > 0) {
                    } else {
                    }
                    i26 = 1;
                    com.google.android.gms.measurement.internal.k kVar7 = obj3.c;
                    ba.Q(kVar7);
                    if (ia.W(str2.G()) && z && Long.compare(l11, length) > 0) {
                    }
                    if (z != 0) {
                    } else {
                    }
                    i17 = -1;
                    str9 = 1000;
                    if (longValue4.equals(str2.G())) {
                    } else {
                    }
                    t8Var2 = t8Var3;
                    str22 = str15;
                    if ("_vs".equals(str2.G())) {
                    } else {
                    }
                    str9 = i6;
                    str21 = c3.g0;
                    ba.Q(obj3.g);
                    if (S().B(aaVar.a.L1(), str21) && "_ab".equals(str2.G()) && da.o((p4)str2.l(), i14) == null && i12 != 0 && Long.compare(codePointAt, t8Var3) <= 0) {
                    } else {
                    }
                    str7 = str16;
                    valueOf2 = str9;
                    codePointAt = str22;
                    if (!iaVar && longValue4.equals(str2.G())) {
                    } else {
                    }
                    i16 = i21;
                    aaVar.c.set(i28, (p4)str2.l());
                    longValue3++;
                    t8Var2.r0(str2);
                    i4 = b3Var + 1;
                    length = t8Var2;
                    arrayList2 = str7;
                    str26 = str5;
                    z2 = iaVar;
                    str23 = obj;
                    str13 = "_fr";
                    equals7 = "_et";
                    str5 = str26;
                    equals2 = "_e";
                    i21 = i16;
                    if (longValue4.equals(str2.G())) {
                    } else {
                    }
                    if (str2.s() == 0) {
                    } else {
                    }
                    ba.Q(obj3.g);
                    equals5 = da.p((p4)str2.l(), str4);
                    if ((Long)equals5 == null) {
                    } else {
                    }
                    i16 = i21 + longValue4;
                    b().w().b("Engagement event does not include duration. appId", q3.z(aaVar.a.L1()));
                    b().w().b("Engagement event does not contain any parameters. appId", q3.z(aaVar.a.L1()));
                    if ("_ab".equals(str2.G())) {
                    } else {
                    }
                    ba.Q(obj3.g);
                    if (da.o((p4)str2.l(), str4) == null) {
                    } else {
                    }
                    if (i12 != 0) {
                    } else {
                    }
                    if (Long.compare(codePointAt, t8Var3) <= 0) {
                    } else {
                    }
                    equals5 = i12.o();
                    obj3.K((o4)equals5, str2);
                    r.a(longValue4.equals(equals5.G()));
                    ba.Q(obj3.g);
                    str7 = str16;
                    t4 t4Var10 = da.o((p4)equals5.l(), str7);
                    ba.Q(obj3.g);
                    t4 t4Var13 = da.o((p4)equals5.l(), "_sc");
                    ba.Q(obj3.g);
                    letter = da.o((p4)equals5.l(), "_si");
                    if (t4Var10 != null) {
                    } else {
                    }
                    str25 = "";
                    if (!TextUtils.isEmpty(str25)) {
                    }
                    if (t4Var13 != null) {
                    } else {
                    }
                    str8 = "";
                    if (!TextUtils.isEmpty(str8)) {
                    }
                    if (letter != null) {
                    }
                    t8Var2.G(str9, equals5);
                    valueOf2 = str9;
                    codePointAt = str22;
                    i12 = 0;
                    ba.Q(obj3.g);
                    da.m(str2, "_si", Long.valueOf(letter.z()));
                    ba.Q(obj3.g);
                    da.m(str2, "_sc", str8);
                    str8 = t4Var13.D();
                    ba.Q(obj3.g);
                    da.m(str2, str7, str25);
                    str25 = t4Var10.D();
                    ba.Q(obj3.g);
                    if (da.o((p4)str2.l(), i14) == null) {
                    } else {
                    }
                    str9 = i6;
                    if (i12 != 0 && Long.compare(t8Var3, str9) <= 0) {
                    } else {
                    }
                    valueOf2 = str9;
                    i20 = str2;
                    codePointAt = longValue3;
                    str7 = str16;
                    if (Long.compare(t8Var3, str9) <= 0) {
                    } else {
                    }
                    t8 t8Var5 = i12.o();
                    if (obj3.P((o4)t8Var5, str2)) {
                    } else {
                    }
                    str9 = i6;
                    equals5 = str2;
                    codePointAt = longValue3;
                    i20 = equals5;
                    valueOf2 = str9;
                    t8Var2.G(i6, t8Var5);
                    codePointAt = str22;
                    equals5 = 0;
                    i12 = 0;
                    ba.Q(obj3.g);
                    if (da.o((p4)str2.l(), str3) == null) {
                    } else {
                    }
                    t8Var2 = t8Var3;
                    str22 = str15;
                    str9 = i6;
                    str7 = str16;
                    str4 = i14;
                    if (i20 != 0 && Long.compare(equals7, str9) <= 0) {
                    } else {
                    }
                    t8Var2 = t8Var3;
                    i12 = str2;
                    codePointAt = str22;
                    valueOf2 = longValue3;
                    str7 = str16;
                    str4 = i14;
                    if (Long.compare(equals7, str9) <= 0) {
                    } else {
                    }
                    t8 t8Var4 = i20.o();
                    if (obj3.P(str2, (o4)t8Var4)) {
                    } else {
                    }
                    t8Var2 = t8Var3;
                    str22 = str15;
                    equals5 = str2;
                    valueOf2 = longValue3;
                    i12 = equals5;
                    codePointAt = str22;
                    t8Var3.G(str15, t8Var4);
                    valueOf2 = i6;
                    equals5 = 0;
                    i20 = 0;
                    arrayList2 = new ArrayList(str2.H());
                    i2 = 0;
                    z = -1;
                    length = -1;
                    equals7 = "currency";
                    letter = "value";
                    while (i2 < arrayList2.size()) {
                        if (letter.equals((t4)arrayList2.get(i2).C())) {
                        } else {
                        }
                        if (equals7.equals((t4)arrayList2.get(i2).C())) {
                        }
                        i2++;
                        equals7 = "currency";
                        letter = "value";
                        length = i2;
                        z = i2;
                    }
                    if (z == -1) {
                    } else {
                    }
                    if (!(t4)arrayList2.get(z).R() && !(t4)arrayList2.get(z).P()) {
                    } else {
                    }
                    if (length == -1) {
                    } else {
                    }
                    arrayList2 = (t4)arrayList2.get(length).D();
                    if (arrayList2.length() == 3) {
                    } else {
                    }
                    b().x().a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                    str2.z(z);
                    ba.E(str2, str94);
                    ba.D(str2, 19, equals7);
                    length = 0;
                    while (length < arrayList2.length()) {
                        codePointAt = arrayList2.codePointAt(length);
                        if (Character.isLetter(codePointAt) == null) {
                            break loop_89;
                        } else {
                        }
                        length += codePointAt;
                    }
                    codePointAt = arrayList2.codePointAt(length);
                    if (Character.isLetter(codePointAt) != null) {
                    } else {
                    }
                    length += codePointAt;
                    if (!(t4)arrayList2.get(z).P()) {
                    } else {
                    }
                    b().x().a("Value must be specified with a numeric type.");
                    str2.z(z);
                    ba.E(str2, str94);
                    ba.D(str2, 18, letter);
                    if (letter.equals((t4)arrayList2.get(i2).C())) {
                    } else {
                    }
                    if (equals7.equals((t4)arrayList2.get(i2).C())) {
                    }
                    i2++;
                    length = i2;
                    z = i2;
                    if (z) {
                    }
                    kVar7 = obj3.c;
                    ba.Q(kVar7);
                    if (Long.compare(l11, length) > 0) {
                    }
                    b().w().b("Too many conversions. Not logging as conversion. appId", q3.z(aaVar.a.L1()));
                    arrayList2 = 0;
                    equals2 = 0;
                    length = 0;
                    codePointAt = -1;
                    while (equals2 < str2.s()) {
                        equals7 = str2.F(equals2);
                        if (str94.equals(equals7.C()) != null) {
                        } else {
                        }
                        if (letter.equals(equals7.C())) {
                        }
                        equals2++;
                        length = 1;
                        arrayList2 = equals7.q();
                        codePointAt = equals2;
                    }
                    if (length != 0) {
                    } else {
                    }
                    if (arrayList2 != null) {
                    } else {
                    }
                    b().r().b("Did not find conversion parameter. appId", q3.z(aaVar.a.L1()));
                    t8 t8Var6 = arrayList2.o();
                    (s4)t8Var6.B(letter);
                    t8Var6.A(10);
                    str2.C(codePointAt, (t4)t8Var6.l());
                    if (arrayList2 != null) {
                    } else {
                    }
                    arrayList2 = 0;
                    str2.z(codePointAt);
                    equals7 = str2.F(equals2);
                    if (str94.equals(equals7.C()) != null) {
                    } else {
                    }
                    if (letter.equals(equals7.C())) {
                    }
                    equals2++;
                    length = 1;
                    arrayList2 = equals7.q();
                    codePointAt = equals2;
                    ba.E(str2, equals7);
                    codePointAt = obj3.l.D().d(str2.G());
                    b().v().b("Marking event as real-time", codePointAt);
                    i22 = t4.A();
                    i22.B(equals7);
                    i22.A(1);
                    str2.w(i22);
                    if (z) {
                    } else {
                    }
                    b().v().b("Marking event as conversion", obj3.l.D().d(str2.G()));
                    i22 = t4.A();
                    i22.B(str94);
                    str3 = codePointAt;
                    i22.A(1);
                    str2.w(i22);
                    if (str94.equals(str2.F(i22).C())) {
                    } else {
                    }
                    valueOf2 = length;
                    str15 = codePointAt;
                    if (equals7.equals(str2.F(i22).C())) {
                    } else {
                    }
                    str12 = str13;
                    i22++;
                    str13 = str12;
                    length = valueOf2;
                    equals7 = i14;
                    codePointAt = str15;
                    t8Var7 = str2.F(i22).q();
                    str12 = str13;
                    (s4)t8Var7.A(1);
                    str2.C(i22, (t4)t8Var7.l());
                    i18 = 1;
                    t8Var8 = str2.F(i22).q();
                    valueOf2 = length;
                    str15 = codePointAt;
                    (s4)t8Var8.A(1);
                    str2.C(i22, (t4)t8Var8.l());
                    str12 = str13;
                    i5 = 1;
                    ba.Q(obj3.g);
                    equals = str2.G();
                    r.f(equals);
                    iaVar = z2;
                    z2 = equals.hashCode();
                    str16 = arrayList2;
                    if (z2 != 94660) {
                    } else {
                    }
                    if (equals.equals("_in")) {
                    } else {
                    }
                    arrayList2 = -1;
                    if (arrayList2 != null && arrayList2 != 1 && arrayList2 != 2) {
                    } else {
                    }
                    if (arrayList2 != 1) {
                    } else {
                    }
                    if (arrayList2 != 2) {
                    } else {
                    }
                    str15 = codePointAt;
                    str3 = str13;
                    i14 = equals7;
                    i6 = valueOf2;
                    z = 0;
                    longValue4 = equals2;
                    t8Var3 = length;
                    arrayList2 = 0;
                    if (z2 != 95025) {
                    } else {
                    }
                    if (equals.equals("_ug")) {
                    } else {
                    }
                    arrayList2 = 2;
                    if (z2 != 95027) {
                    } else {
                    }
                    if (equals.equals("_ui")) {
                    } else {
                    }
                    arrayList2 = 1;
                    str2.A(str23);
                    b().v().a("Renaming ad_impression to _ai");
                    if (Log.isLoggable(b().C(), 5)) {
                    }
                    loggable = 0;
                    while (loggable < str2.s()) {
                        if ("ad_platform".equals(str2.F(loggable).C()) && !TextUtils.isEmpty(str2.F(loggable).D()) && "admob".equalsIgnoreCase(str2.F(loggable).D())) {
                        }
                        loggable++;
                        str23 = obj;
                        if (!TextUtils.isEmpty(str2.F(loggable).D())) {
                        }
                        if ("admob".equalsIgnoreCase(str2.F(loggable).D())) {
                        }
                        b().x().a("AdMob ad impression logged from app. Potentially duplicative.");
                    }
                    if ("ad_platform".equals(str2.F(loggable).C()) && !TextUtils.isEmpty(str2.F(loggable).D()) && "admob".equalsIgnoreCase(str2.F(loggable).D())) {
                    }
                    loggable++;
                    str23 = obj;
                    if (!TextUtils.isEmpty(str2.F(loggable).D())) {
                    }
                    if ("admob".equalsIgnoreCase(str2.F(loggable).D())) {
                    }
                    b().x().a("AdMob ad impression logged from app. Potentially duplicative.");
                    b().w().c("Dropping blocked raw event. appId", q3.z(aaVar.a.L1()), obj3.l.D().d(str2.G()));
                    com.google.android.gms.measurement.internal.t4 t4Var3 = obj3.a;
                    ba.Q(t4Var3);
                    if (!t4Var3.v(aaVar.a.L1())) {
                    }
                    obj = str23;
                    t8Var2 = length;
                    iaVar = z2;
                    i16 = i21;
                    b3Var = i28;
                    i17 = -1;
                    str7 = arrayList2;
                    com.google.android.gms.measurement.internal.t4 t4Var4 = obj3.a;
                    ba.Q(t4Var4);
                    if (t4Var4.y(aaVar.a.L1())) {
                    } else {
                    }
                    if (!letter.equals(str2.G())) {
                    }
                    f0().A(obj3.B, aaVar.a.L1(), 11, "_ev", str2.G(), 0);
                }
                t8Var = length;
                str = str13;
                if (z2) {
                    equals2 = longValue3;
                    i = i21;
                    arrayList2 = 0;
                    while (arrayList2 < equals2) {
                        longValue = t8Var.n0(arrayList2);
                        ba.Q(obj3.g);
                        if (equals2.equals(longValue.D()) && da.o(longValue, str) != null) {
                        } else {
                        }
                        ba.Q(obj3.g);
                        longValue = da.o(longValue, equals7);
                        if (longValue != null) {
                        }
                        arrayList2 += length;
                        codePointAt = longValue.R();
                        if (codePointAt) {
                        } else {
                        }
                        longValue = 0;
                        if (longValue != 0 && Long.compare(longValue3, i19) > 0) {
                        }
                        if (Long.compare(longValue3, i19) > 0) {
                        }
                        i += longValue;
                        longValue = Long.valueOf(longValue.z());
                        ba.Q(obj3.g);
                        if (da.o(longValue, str) != null) {
                        } else {
                        }
                        t8Var.F0(arrayList2);
                        equals2--;
                        arrayList2--;
                    }
                } else {
                    i = i21;
                }
                obj3.J(t8Var, i, equals);
                iterator2 = t8Var.g0().iterator();
                length = "_se";
                while (iterator2.hasNext()) {
                    if ("_s".equals((p4)iterator2.next().D()) != 0) {
                        break;
                    } else {
                    }
                    length = "_se";
                }
                if (da.x(t8Var, "_sid") >= 0) {
                    obj3.J(t8Var, i, equals);
                } else {
                    i8 = da.x(t8Var, length);
                    if (i8 >= 0) {
                        t8Var.G0(i8);
                        b().r().b("Session engagement user property is in the bundle without session ID. appId", q3.z(aaVar.a.L1()));
                    }
                }
                daVar = obj3.g;
                ba.Q(daVar);
                daVar.a.b().v().a("Checking account type status for ad personalization signals");
                com.google.android.gms.measurement.internal.t4 t4Var2 = baVar.a;
                ba.Q(t4Var2);
                com.google.android.gms.measurement.internal.k kVar8 = baVar2.c;
                ba.Q(kVar8);
                z5 = kVar8.T(t8Var.d0());
                if (t4Var2.t(t8Var.d0()) && z5 != null && z5.J() && daVar.a.A().s()) {
                    kVar8 = baVar2.c;
                    ba.Q(kVar8);
                    z5 = kVar8.T(t8Var.d0());
                    if (z5 != null) {
                        if (z5.J()) {
                            if (daVar.a.A().s()) {
                                daVar.a.b().q().a("Turning off ad personalization due to account type");
                                i5 i5Var = j5.z();
                                cmp3 = str5;
                                i5Var.x(cmp3);
                                i5Var.y(daVar.a.A().o());
                                i5Var.w(1);
                                daVar = i5Var.l();
                                z5 = 0;
                                while (z5 < t8Var.i0()) {
                                    z5++;
                                }
                                t8Var.u0((j5)daVar);
                            }
                        }
                    }
                }
                t8Var.W(Long.MAX_VALUE);
                t8Var.F(Long.MIN_VALUE);
                i23 = 0;
                int i38 = t8Var.R();
                while (i23 < i38) {
                    z5 = t8Var.n0(i23);
                    if (Long.compare(l17, l23) < 0) {
                    }
                    if (Long.compare(l18, str) > 0) {
                    }
                    i23++;
                    i38 = t8Var.R();
                    t8Var.F(z5.z());
                    t8Var.W(z5.z());
                }
                t8Var.E0();
                t8Var.w0();
                xaVar = obj3.f;
                ba.Q(xaVar);
                t8Var.o0(xaVar.m(t8Var.d0(), t8Var.g0(), t8Var.h0(), Long.valueOf(t8Var.m0()), Long.valueOf(t8Var.k0())));
                if (S().F(aaVar.a.L1())) {
                    HashMap hashMap = new HashMap();
                    arrayList = new ArrayList();
                    secureRandom = f0().t();
                    str14 = 0;
                    while (str14 < t8Var.R()) {
                        insert = t8Var.n0(str14).q();
                        valueOf3 = "_sr";
                        if ((o4)insert.G().equals("_ep")) {
                        } else {
                        }
                        t4Var = obj3.a;
                        ba.Q(t4Var);
                        str11 = t4Var.e(aaVar.a.L1(), "measurement.account.time_zone_offset_minutes");
                        if (!TextUtils.isEmpty(str11)) {
                        } else {
                        }
                        long = 0;
                        valueOf2 = f0().s0(insert.u(), i);
                        str27 = "_dbg";
                        if (!TextUtils.isEmpty(str27)) {
                        } else {
                        }
                        com.google.android.gms.measurement.internal.t4 t4Var12 = obj3.a;
                        ba.Q(t4Var12);
                        contentValues = t4Var12.m(aaVar.a.L1(), insert.G());
                        if (contentValues <= 0) {
                        } else {
                        }
                        com.google.android.gms.measurement.internal.k kVar14 = obj3.c;
                        ba.Q(kVar14);
                        if ((q)hashMap.get(insert.G()) == null && kVar14.X(aaVar.a.L1(), insert.G()) == null) {
                        } else {
                        }
                        str5 = valueOf2;
                        ba.Q(obj3.g);
                        longValue2 = da.p((p4)insert.l(), "_eid");
                        if ((Long)longValue2 != null) {
                        } else {
                        }
                        i3 = 0;
                        valueOf2 = Boolean.valueOf(i3);
                        if (contentValues == 1) {
                        } else {
                        }
                        if (secureRandom.nextInt(contentValues) == 0) {
                        } else {
                        }
                        obj50 = secureRandom;
                        i = str5;
                        secureRandom = valueOf6.h;
                        if (secureRandom != null) {
                        } else {
                        }
                        str5 = t8Var;
                        longValue3 = aaVar;
                        obj2 = valueOf6;
                        i21 = longValue2;
                        l = f0().s0(insert.t(), aaVar);
                        if (Long.compare(l, i) != 0) {
                        } else {
                        }
                        i13 = 1;
                        if (valueOf2.booleanValue()) {
                        }
                        t8Var = str5;
                        t8Var.G(str14, insert);
                        str14++;
                        secureRandom = obj50;
                        aaVar = longValue3;
                        contentValues = 0;
                        hashMap.put(insert.G(), obj2.a(i21, contentValues, contentValues));
                        ba.Q(obj3.g);
                        da.m(insert, "_efs", Long.valueOf(1));
                        ba.Q(obj3.g);
                        Long valueOf7 = Long.valueOf((long)contentValues);
                        da.m(insert, valueOf3, valueOf7);
                        arrayList.add((p4)insert.l());
                        if (valueOf2.booleanValue()) {
                        } else {
                        }
                        valueOf6 = obj2;
                        hashMap.put(insert.G(), valueOf6.b(insert.u(), valueOf3));
                        valueOf6 = obj2.a(0, valueOf7, Boolean.TRUE);
                        str5 = t8Var;
                        obj2 = valueOf6;
                        i21 = longValue2;
                        longValue3 = aaVar;
                        l = l4;
                        ba.Q(obj3.g);
                        Long valueOf8 = Long.valueOf((long)contentValues);
                        da.m(insert, valueOf3, valueOf8);
                        arrayList.add((p4)insert.l());
                        if (valueOf2.booleanValue()) {
                        }
                        hashMap.put(insert.G(), valueOf6.b(insert.u(), valueOf2));
                        longValue3 = aaVar;
                        obj50 = secureRandom;
                        i13 = 1;
                        booleanValue2 = 0;
                        valueOf6 = valueOf6.a(booleanValue2, valueOf8, booleanValue2);
                        arrayList.add((p4)insert.l());
                        if (valueOf2.booleanValue()) {
                        }
                        t8Var.G(str14, insert);
                        longValue3 = aaVar;
                        obj50 = secureRandom;
                        i13 = 1;
                        if (valueOf6.i == null && valueOf6.j == null) {
                        } else {
                        }
                        int i49 = 0;
                        hashMap.put(insert.G(), valueOf6.a(i49, i49, i49));
                        if (valueOf6.j == null) {
                        } else {
                        }
                        if (valueOf6.k != null) {
                        }
                        i3 = 1;
                        kVar14 = obj3.c;
                        ba.Q(kVar14);
                        if (kVar14.X(aaVar.a.L1(), insert.G()) == null) {
                        } else {
                        }
                        str5 = valueOf2;
                        b().w().c("Event being bundled has no eventAggregate. appId, eventName", aaVar.a.L1(), insert.G());
                        super(aaVar.a.L1(), insert.G(), 1, i14, 1, str18, 1, obj36, insert.u(), i10, 0, i7, 0, 0, 0, 0);
                        b().w().c("Sample rate must be positive. event, rate", insert.G(), Integer.valueOf(contentValues));
                        arrayList.add((p4)insert.l());
                        t8Var.G(str14, insert);
                        iterator = (p4)insert.l().E().iterator();
                        for (t4 equals : iterator) {
                            iterator = obj50;
                        }
                        equals = iterator.next();
                        if (str27.equals((t4)equals.C())) {
                        } else {
                        }
                        iterator = obj50;
                        if (!Long.valueOf(1).equals(Long.valueOf(equals.z()))) {
                        } else {
                        }
                        contentValues = 1;
                        long = Long.parseLong(str11);
                        ba.Q(obj3.g);
                        contentValues = da.p((p4)insert.l(), "_en");
                        com.google.android.gms.measurement.internal.k kVar13 = obj3.c;
                        ba.Q(kVar13);
                        r.j(contentValues);
                        valueOf6 = kVar13.X(aaVar.a.L1(), (String)contentValues);
                        if ((q)hashMap.get((String)contentValues) == null && valueOf6 != null) {
                        }
                        cmp = valueOf6.j;
                        if (valueOf6 != null && valueOf6.i == null && cmp != null && Long.compare(longValue2, i) > 0) {
                        }
                        t8Var.G(str14, insert);
                        if (valueOf6.i == null) {
                        }
                        cmp = valueOf6.j;
                        if (cmp != null) {
                        }
                        booleanValue = valueOf6.k;
                        if (booleanValue != null && booleanValue.booleanValue()) {
                        }
                        arrayList.add((p4)insert.l());
                        if (booleanValue.booleanValue()) {
                        }
                        ba.Q(obj3.g);
                        da.m(insert, "_efs", Long.valueOf(1));
                        if (Long.compare(longValue2, i) > 0) {
                        }
                        ba.Q(obj3.g);
                        da.m(insert, valueOf3, valueOf6.j);
                        kVar13 = obj3.c;
                        ba.Q(kVar13);
                        r.j(contentValues);
                        valueOf6 = kVar13.X(aaVar.a.L1(), (String)contentValues);
                        if (valueOf6 != null) {
                        }
                        hashMap.put(contentValues, valueOf6);
                        long l24 = l24.a;
                        l24 = l24.b();
                        l24 = l24.w();
                        str22 = q3.z(str22);
                        l24.c("Unable to parse timezone offset. appId", str22, th);
                    }
                    if (arrayList.size() < t8Var.R()) {
                        t8Var.y0();
                        t8Var.p0(arrayList);
                    }
                    Iterator iterator3 = hashMap.entrySet().iterator();
                    for (Map.Entry next3 : iterator3) {
                        aaVar = obj3.c;
                        ba.Q(aaVar);
                        aaVar.r((q)next3.getValue());
                    }
                    aaVar2 = longValue3;
                } else {
                    aaVar2 = aaVar;
                }
                str17 = aaVar2.a.L1();
                com.google.android.gms.measurement.internal.k kVar11 = obj3.c;
                ba.Q(kVar11);
                g5Var = kVar11.T(str17);
                if (g5Var == null) {
                    b().r().b("Bundling raw events w/o app info. appId", q3.z(aaVar2.a.L1()));
                } else {
                    if (t8Var.R() > 0) {
                        l5 = g5Var.Y();
                        if (Long.compare(l5, i48) != 0) {
                            t8Var.P(l5);
                        } else {
                            t8Var.B0();
                        }
                        long l22 = g5Var.a0();
                        valueOf3 = 0;
                        if (Long.compare(l22, valueOf3) == 0) {
                        } else {
                            l5 = l22;
                        }
                        if (Long.compare(l5, valueOf3) != 0) {
                            t8Var.Q(l5);
                        } else {
                            t8Var.C0();
                        }
                        g5Var.e();
                        t8Var.x((int)l14);
                        g5Var.E(t8Var.m0());
                        g5Var.C(t8Var.k0());
                        String str52 = g5Var.d0();
                        if (str52 != null) {
                            t8Var.L(str52);
                        } else {
                            t8Var.z0();
                        }
                        cmp2 = obj3.c;
                        ba.Q(cmp2);
                        cmp2.q(g5Var);
                    }
                }
                if (t8Var.R() > 0) {
                    obj3.l.d();
                    com.google.android.gms.measurement.internal.t4 t4Var7 = obj3.a;
                    ba.Q(t4Var7);
                    empty2 = t4Var7.o(aaVar2.a.L1());
                    int i40 = -1;
                    if (empty2 != null) {
                        if (!empty2.L()) {
                            if (TextUtils.isEmpty(aaVar2.a.D())) {
                                t8Var.z(i40);
                            } else {
                                b().w().b("Did not find measurement config or missing version info. appId", q3.z(aaVar2.a.L1()));
                            }
                        } else {
                            t8Var.z(empty2.y());
                        }
                    } else {
                    }
                    i9 = obj3.c;
                    ba.Q(i9);
                    t8Var = t8Var.l();
                    i9.h();
                    i9.i();
                    r.j((z4)t8Var);
                    r.f(t8Var.L1());
                    r.m(t8Var.c1());
                    i9.m();
                    currentTimeMillis = i9.a.c().currentTimeMillis();
                    i9.a.z();
                    if (Long.compare(l27, longValue2) >= 0) {
                        i9.a.z();
                        if (Long.compare(l28, longValue2) > 0) {
                            i9.a.b().w().d("Storing bundle outside of the max uploading time span. appId, now, timestamp", q3.z(t8Var.L1()), Long.valueOf(currentTimeMillis), Long.valueOf(t8Var.x1()));
                        }
                    } else {
                    }
                    com.google.android.gms.measurement.internal.da daVar14 = baVar3.g;
                    ba.Q(daVar14);
                    byte[] bArr2 = daVar14.Q(t8Var.j());
                    i9.a.b().v().b("Saving bundle, size", Integer.valueOf(bArr2.length));
                    contentValues = new ContentValues();
                    contentValues.put("app_id", t8Var.L1());
                    contentValues.put("bundle_end_timestamp", Long.valueOf(t8Var.x1()));
                    contentValues.put("data", bArr2);
                    contentValues.put("has_realtime", Integer.valueOf(i26));
                    if (t8Var.i1()) {
                        contentValues.put("retry_count", Integer.valueOf(t8Var.q1()));
                    }
                    if (Long.compare(insert, i40) == 0) {
                        i9.a.b().r().b("Failed to insert bundle (got -1). appId", q3.z(t8Var.L1()));
                    }
                }
                com.google.android.gms.measurement.internal.k kVar9 = obj3.c;
                ba.Q(kVar9);
                kVar9.h0(aaVar2.b);
                kVar = obj3.c;
                ba.Q(kVar);
                strArr = new String[2];
                kVar.R().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", str17, str17);
            }
            com.google.android.gms.measurement.internal.k kVar4 = obj3.c;
            ba.Q(kVar4);
            kVar4.p();
            com.google.android.gms.measurement.internal.k kVar5 = obj3.c;
            ba.Q(kVar5);
            kVar5.i0();
            return 1;
        }
        com.google.android.gms.measurement.internal.k kVar2 = obj3.c;
        ba.Q(kVar2);
        kVar2.p();
        com.google.android.gms.measurement.internal.k kVar3 = obj3.c;
        ba.Q(kVar3);
        kVar3.i0();
        return 0;
    }

    private final boolean O() {
        boolean empty;
        a().h();
        g();
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        com.google.android.gms.measurement.internal.k kVar2 = this.c;
        ba.Q(kVar2);
        if (!kVar.t() && !TextUtils.isEmpty(kVar2.b0())) {
            kVar2 = this.c;
            ba.Q(kVar2);
            if (!TextUtils.isEmpty(kVar2.b0())) {
            }
            return 0;
        }
        return 1;
    }

    private final boolean P(o4 o4, o4 o42) {
        String equals;
        String i;
        r.a("_e".equals(o4.G()));
        ba.Q(this.g);
        t4 t4Var = da.o((p4)o4.l(), "_sc");
        if (t4Var == null) {
            equals = i;
        } else {
            equals = t4Var.D();
        }
        ba.Q(this.g);
        t4 t4Var2 = da.o((p4)o42.l(), "_pc");
        if (t4Var2 == null) {
        } else {
            i = t4Var2.D();
        }
        if (i != null && i.equals(equals)) {
            if (i.equals(equals)) {
                K(o4, o42);
                return 1;
            }
        }
        return 0;
    }

    private static final com.google.android.gms.measurement.internal.r9 Q(com.google.android.gms.measurement.internal.r9 r9) {
        if (r9 == null) {
        } else {
            if (!r9.k()) {
            } else {
                return r9;
            }
            String obj2 = String.valueOf(r9.getClass());
            String.valueOf(obj2).length();
            IllegalStateException illegalStateException = new IllegalStateException("Component not initialized: ".concat(String.valueOf(obj2)));
            throw illegalStateException;
        }
        obj2 = new IllegalStateException("Upload Component not created");
        throw obj2;
    }

    static com.google.android.gms.measurement.internal.b5 Z(com.google.android.gms.measurement.internal.ba ba) {
        return ba.l;
    }

    public static com.google.android.gms.measurement.internal.ba d0(Context context) {
        com.google.android.gms.measurement.internal.ba baVar;
        Object caVar;
        int i;
        Object obj3;
        r.j(context);
        r.j(context.getApplicationContext());
        baVar = ba.class;
        if (ba.C == null && ba.C == null) {
            baVar = ba.class;
            synchronized (baVar) {
                caVar = new ca(context);
                r.j(caVar);
                obj3 = new ba((ca)caVar, 0);
                ba.C = obj3;
            }
        }
        return ba.C;
    }

    static void i0(com.google.android.gms.measurement.internal.ba ba, com.google.android.gms.measurement.internal.ca ca2) {
        int valueOf;
        Integer valueOf2;
        String str;
        int obj4;
        ba.a().h();
        obj4 = new j4(ba);
        ba.k = obj4;
        obj4 = new k(ba);
        obj4.j();
        ba.c = obj4;
        com.google.android.gms.measurement.internal.t4 t4Var = ba.a;
        r.j(t4Var);
        ba.S().z((f)t4Var);
        obj4 = new x8(ba);
        obj4.j();
        ba.i = obj4;
        obj4 = new xa(ba);
        obj4.j();
        ba.f = obj4;
        obj4 = new n7(ba);
        obj4.j();
        ba.h = obj4;
        obj4 = new p9(ba);
        obj4.j();
        ba.e = obj4;
        obj4 = new y3(ba);
        ba.d = obj4;
        if (ba.q != ba.r) {
            ba.b().r().c("Not all upload components initialized", Integer.valueOf(ba.q), Integer.valueOf(ba.r));
        }
        ba.m = true;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void A() {
        int cmp;
        int moveToFirst3;
        boolean moveToFirst2;
        Pair create;
        Object emptyList;
        int i3;
        boolean moveToFirst;
        com.google.android.gms.measurement.internal.b5 b5Var;
        int valueOf2;
        boolean z;
        Object w4Var;
        boolean empty2;
        String str;
        int byteArrayOutputStream;
        int size;
        long currentTimeMillis;
        Object arrayList3;
        Object empty;
        int i2;
        int i4;
        boolean z2;
        int str3;
        Long valueOf;
        Object arrayList2;
        int i6;
        int byteArrayInputStream;
        int i;
        long l;
        int i5;
        int bArr;
        int rawQuery;
        String arrayList;
        int strArr;
        String long;
        String[] strArr2;
        int i7;
        int i8;
        String str2;
        String valueOf3;
        Object obj;
        final Object obj2 = this;
        a().h();
        g();
        valueOf2 = 1;
        obj2.u = valueOf2;
        byteArrayOutputStream = 0;
        obj2.l.d();
        Boolean bool = obj2.l.L().J();
        if (bool == null) {
            b().w().a("Upload data called on the client side before use of service was decided");
            obj2.u = byteArrayOutputStream;
        } else {
            if (bool.booleanValue()) {
                b().r().a("Upload called in the client side when service should be used");
                obj2.u = byteArrayOutputStream;
            } else {
                str3 = 0;
                if (Long.compare(currentTimeMillis, str3) > 0) {
                    L();
                    obj2.u = byteArrayOutputStream;
                } else {
                    a().h();
                    if (obj2.x != null) {
                        b().v().a("Uploading requested multiple times");
                        obj2.u = byteArrayOutputStream;
                    } else {
                        com.google.android.gms.measurement.internal.w3 w3Var = obj2.b;
                        ba.Q(w3Var);
                        if (!w3Var.m()) {
                            b().v().a("Network not connected, ignoring upload request");
                            L();
                            obj2.u = byteArrayOutputStream;
                        } else {
                            currentTimeMillis = c().currentTimeMillis();
                            byteArrayInputStream = 0;
                            S();
                            i6 = byteArrayOutputStream;
                            while (i6 < S().o(byteArrayInputStream, c3.Q)) {
                                if (obj2.N(byteArrayInputStream, currentTimeMillis - l4)) {
                                }
                                i6++;
                            }
                            bArr = x8Var.i.a();
                            if (Long.compare(bArr, str3) != 0) {
                                try {
                                    b().q().b("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - bArr)));
                                    com.google.android.gms.measurement.internal.k kVar = obj2.c;
                                    ba.Q(kVar);
                                    str3 = kVar.b0();
                                    valueOf = -1;
                                    if (Long.compare(l, valueOf) == 0) {
                                    }
                                    l = obj2.c;
                                    ba.Q(l);
                                    rawQuery = l.R().rawQuery("select rowid from raw_events order by rowid desc limit 1;", byteArrayInputStream);
                                    if (!rawQuery.moveToFirst()) {
                                    } else {
                                    }
                                    if (rawQuery != null) {
                                    }
                                    rawQuery.close();
                                    valueOf = rawQuery.getLong(byteArrayOutputStream);
                                    if (rawQuery != null) {
                                    }
                                    rawQuery = byteArrayInputStream;
                                    bArr = bArr.a;
                                    bArr = bArr.b();
                                    bArr = bArr.r();
                                    bArr.b("Error querying raw events", th);
                                    if (rawQuery != 0) {
                                    }
                                    obj2.z = valueOf;
                                    byteArrayInputStream = rawQuery;
                                    if (byteArrayInputStream == null) {
                                    } else {
                                    }
                                    byteArrayInputStream.close();
                                    throw th;
                                    int i10 = S().o(str3, c3.g);
                                    valueOf = Math.max(byteArrayOutputStream, S().o(str3, c3.h));
                                    i6 = obj2.c;
                                    ba.Q(i6);
                                    i6.h();
                                    i6.i();
                                    if (i10 > 0) {
                                    } else {
                                    }
                                    i5 = valueOf2;
                                    i5 = byteArrayOutputStream;
                                    r.a(i5);
                                    if (valueOf > 0) {
                                    } else {
                                    }
                                    bArr = valueOf2;
                                    bArr = byteArrayOutputStream;
                                    r.a(bArr);
                                    r.f(str3);
                                    strArr2 = new String[valueOf2];
                                    strArr2[byteArrayOutputStream] = str3;
                                    rawQuery = i6.R().query("queue", /* result */, "app_id=?", strArr2, 0, 0, "rowid", String.valueOf(i10));
                                    if (!rawQuery.moveToFirst()) {
                                    } else {
                                    }
                                    emptyList = Collections.emptyList();
                                    if (rawQuery != null) {
                                    }
                                    rawQuery.close();
                                    obj = currentTimeMillis;
                                    arrayList = new ArrayList();
                                    strArr = byteArrayOutputStream;
                                    ba.Q(baVar.g);
                                    byteArrayInputStream = new ByteArrayInputStream(rawQuery.getBlob(valueOf2));
                                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    bArr = new byte[1024];
                                    obj = currentTimeMillis;
                                } catch (android.database.sqlite.SQLiteException sQLite) {
                                } catch (Throwable th1) {
                                }
                                obj2.z = valueOf;
                                empty2 = obj2.c;
                                ba.Q(empty2);
                                S();
                                empty2.h();
                                empty2.i();
                                String[] strArr3 = new String[1];
                                byteArrayOutputStream = empty2.R().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", String.valueOf(rawQuery - l2));
                                if (!byteArrayOutputStream.moveToFirst()) {
                                    empty2.a.b().v().a("No expired configs for apps with pending events");
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                } else {
                                }
                                com.google.android.gms.measurement.internal.k kVar2 = obj2.c;
                                ba.Q(kVar2);
                                emptyList = kVar2.T(byteArrayInputStream);
                                if (!TextUtils.isEmpty(byteArrayInputStream) && emptyList != null) {
                                    kVar2 = obj2.c;
                                    ba.Q(kVar2);
                                    emptyList = kVar2.T(byteArrayInputStream);
                                    if (emptyList != null) {
                                        obj2.h(emptyList);
                                    }
                                }
                                obj2.u = false;
                            }
                        }
                    }
                }
            }
        }
        I();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void B(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        Throwable th;
        Object obj;
        int cmp7;
        com.google.android.gms.measurement.internal.q qVar;
        com.google.android.gms.measurement.internal.k kVar4;
        int cmp6;
        boolean equals2;
        Object str;
        Object str15;
        com.google.android.gms.measurement.internal.s equals4;
        int i20;
        int cmp4;
        int i19;
        Object str7;
        int i9;
        int str18;
        String str6;
        int str19;
        String longValue3;
        Object valueOf;
        long valueOf6;
        com.google.android.gms.measurement.internal.p pVar;
        int cmp3;
        String str8;
        com.google.android.gms.measurement.internal.i str5;
        int i6;
        int valueOf4;
        String str16;
        long l3;
        Object rVar2;
        String str20;
        boolean z;
        boolean equals5;
        com.google.android.gms.measurement.internal.k kVar2;
        int cmp5;
        boolean empty6;
        boolean empty9;
        boolean empty3;
        long l2;
        boolean empty2;
        boolean empty8;
        boolean empty;
        int size;
        boolean empty5;
        boolean empty7;
        com.google.android.gms.measurement.internal.k kVar3;
        w8 w8Var;
        String str2;
        int upperCase;
        Object iterator;
        boolean booleanValue;
        boolean empty4;
        com.google.android.gms.measurement.internal.g5 g5Var;
        Object sQLiteDatabase;
        int cmp;
        int cmp8;
        boolean equals6;
        String string;
        boolean equals;
        int intValue;
        Object b3Var2;
        boolean z3;
        boolean loggable;
        boolean z2;
        boolean equals3;
        boolean matches;
        Object valueOf5;
        String str9;
        SQLiteDatabase sQLiteDatabase3;
        int str17;
        Object next;
        Object str3;
        boolean z4;
        Object gaVar2;
        com.google.android.gms.measurement.internal.k kVar;
        com.google.android.gms.measurement.internal.ga gaVar;
        int i21;
        Object b3Var;
        Object rVar;
        int cmp2;
        String str11;
        String[] strArr2;
        Object b5Var;
        int startsWith;
        int length;
        SQLiteDatabase sQLiteDatabase2;
        int str10;
        int str12;
        String longValue;
        int i;
        String valueOf2;
        int i15;
        int i3;
        String str13;
        long l;
        String longValue2;
        int intValue2;
        String arrayList;
        long currentTimeMillis;
        String[] strArr;
        int i12;
        int i5;
        long l4;
        Long valueOf3;
        int i17;
        com.google.android.gms.measurement.internal.ga gaVar3;
        int i10;
        long currentTimeMillis2;
        int i2;
        Bundle bundle;
        String str14;
        int i11;
        int i4;
        long i7;
        int i13;
        int i18;
        int i14;
        int i16;
        int i8;
        String str4;
        final Object obj2 = this;
        obj = u;
        str = na2;
        String str32 = "metadata_fingerprint";
        str16 = "_sno";
        r.j(na2);
        r.f(str.a);
        a().h();
        g();
        String str85 = str.a;
        ba.Q(obj2.g);
        if (!da.n(u, na2)) {
        }
        com.google.android.gms.measurement.internal.t4 t4Var4 = obj2.a;
        ba.Q(t4Var4);
        currentTimeMillis = "_err";
        longValue2 = 0;
        if (str.z && t4Var4.x(str85, obj.a)) {
            t4Var4 = obj2.a;
            ba.Q(t4Var4);
            currentTimeMillis = "_err";
            longValue2 = 0;
            if (t4Var4.x(str85, obj.a)) {
                str7 = q3.z(str85);
                String str39 = "Dropping blocked event. appId";
                b().w().c(str39, str7, obj2.l.D().d(obj.a));
                com.google.android.gms.measurement.internal.t4 t4Var = obj2.a;
                ba.Q(t4Var);
                if (!t4Var.v(str85)) {
                    com.google.android.gms.measurement.internal.t4 t4Var2 = obj2.a;
                    ba.Q(t4Var2);
                    if (t4Var2.y(str85)) {
                        com.google.android.gms.measurement.internal.k kVar5 = obj2.c;
                        ba.Q(kVar5);
                        obj = kVar5.T(str85);
                        S();
                        if (obj != null && Long.compare(l9, longValue3) > 0) {
                            S();
                            if (Long.compare(l9, longValue3) > 0) {
                                b().q().a("Fetching config for blocked app");
                                obj2.h(obj);
                            }
                        }
                    } else {
                        if (!currentTimeMillis.equals(obj.a)) {
                            f0().A(obj2.B, str85, 11, "_ev", obj.a, 0);
                        }
                    }
                } else {
                }
            }
            com.google.android.gms.measurement.internal.r3 r3Var = r3.b(u);
            f0().z(r3Var, S().n(str85));
            com.google.android.gms.measurement.internal.u uVar = r3Var.a();
            if (Log.isLoggable(b().C(), 2)) {
                b().v().b("Logging event", obj2.l.D().c(uVar));
            }
            com.google.android.gms.measurement.internal.k kVar24 = obj2.c;
            ba.Q(kVar24);
            kVar24.g0();
            obj2.R(str);
            pb.b();
            if (!S().B(longValue2, c3.t0) && S().B(longValue2, c3.u0)) {
                if (S().B(longValue2, c3.u0)) {
                    z2 = obj2.c;
                    ba.Q(z2);
                    z2.n(str.a, "_lair");
                }
            }
            rVar = "refund";
            if (!"ecommerce_purchase".equals(uVar.a) && !"purchase".equals(uVar.a)) {
                if (!"purchase".equals(uVar.a)) {
                    if (rVar.equals(uVar.a)) {
                        upperCase = 1;
                    } else {
                        upperCase = 0;
                    }
                } else {
                }
            } else {
            }
            if (!"_iap".equals(uVar.a)) {
                if (upperCase != 0) {
                    upperCase = 1;
                    matches = uVar.b.o2("currency");
                    str13 = "value";
                    if (upperCase != 0) {
                        i9 = 2;
                    }
                    str14 = currentTimeMillis;
                    longValue = uVar.b.m2(str13).longValue();
                    if (!TextUtils.isEmpty(matches)) {
                    } else {
                    }
                } else {
                    str4 = str32;
                    str20 = currentTimeMillis;
                }
            } else {
            }
            boolean z6 = ia.W(uVar.a);
            boolean equals8 = str20.equals(uVar.a);
            f0();
            com.google.android.gms.measurement.internal.s sVar5 = uVar.b;
            if (sVar5 == null) {
                i5 = 0;
            } else {
                rVar = new r(sVar5);
                i5 = 0;
                while (rVar.hasNext()) {
                    longValue = sVar5.n2(rVar.b());
                    if (longValue instanceof Parcelable[] != null) {
                    }
                    i5 += longValue;
                }
            }
            i4 = 1;
            com.google.android.gms.measurement.internal.k kVar25 = obj2.c;
            ba.Q(kVar25);
            i11 = 0;
            str18 = 0;
            i2 = i66;
            com.google.android.gms.measurement.internal.i iVar = kVar25.W(F(), longValue, str85, i5 + i4, i5, true, z6, i2);
            S();
            int i55 = 0;
            l31 -= l13;
            cmp3 = Long.compare(cmp2, str18);
            i17 = 1000;
            if (cmp3 > 0 && Long.compare(i49, i4) == 0) {
                if (Long.compare(i49, i4) == 0) {
                    b().r().c("Data loss. Too many events logged. appId, count", q3.z(str85), Long.valueOf(iVar.b));
                }
                com.google.android.gms.measurement.internal.k kVar15 = obj2.c;
                ba.Q(kVar15);
                kVar15.p();
                com.google.android.gms.measurement.internal.k kVar16 = obj2.c;
                ba.Q(kVar16);
                kVar16.i0();
            }
            S();
            l14 -= l33;
            if (z6 && Long.compare(cmp3, str18) > 0 && Long.compare(valueOf4, i4) == 0) {
                S();
                l14 -= l33;
                if (Long.compare(cmp3, str18) > 0) {
                    if (Long.compare(valueOf4, i4) == 0) {
                        b().r().c("Data loss. Too many public events logged. appId, count", q3.z(str85), Long.valueOf(iVar.a));
                    }
                    f0().A(obj2.B, str85, 16, "_ev", uVar.a, 0);
                    com.google.android.gms.measurement.internal.k kVar13 = obj2.c;
                    ba.Q(kVar13);
                    kVar13.p();
                    com.google.android.gms.measurement.internal.k kVar14 = obj2.c;
                    ba.Q(kVar14);
                    kVar14.i0();
                }
            }
            int i29 = 1000000;
            l16 -= l32;
            if (equals8 && Long.compare(str16, str18) > 0 && Long.compare(str16, i4) == 0) {
                l16 -= l32;
                if (Long.compare(str16, str18) > 0) {
                    if (Long.compare(str16, i4) == 0) {
                        b().r().c("Too many error events logged. appId, count", q3.z(str85), Long.valueOf(iVar.d));
                    }
                    com.google.android.gms.measurement.internal.k kVar6 = obj2.c;
                    ba.Q(kVar6);
                    kVar6.p();
                    com.google.android.gms.measurement.internal.k kVar7 = obj2.c;
                    ba.Q(kVar7);
                    kVar7.i0();
                }
            }
            Bundle bundle2 = uVar.b.k2();
            f0().B(bundle2, "_o", uVar.c);
            String str112 = "_r";
            if (f0().S(str85)) {
                valueOf5 = Long.valueOf(i4);
                f0().B(bundle2, "_dbg", valueOf5);
                f0().B(bundle2, str112, valueOf5);
            }
            com.google.android.gms.measurement.internal.k kVar22 = obj2.c;
            ba.Q(kVar22);
            str11 = str123;
            equals5 = kVar22.Z(str.a, str11);
            if ("_s".equals(uVar.a) && equals5 != null && obj13 instanceof Long) {
                kVar22 = obj2.c;
                ba.Q(kVar22);
                str11 = str123;
                equals5 = kVar22.Z(str.a, str11);
                if (equals5 != null) {
                    if (obj13 instanceof Long) {
                        f0().B(bundle2, str11, equals5.e);
                    }
                }
            }
            kVar2 = obj2.c;
            ba.Q(kVar2);
            r.f(str85);
            kVar2.h();
            kVar2.i();
            i = 0;
            strArr2 = new String[2];
            strArr2[i] = str85;
            strArr2[1] = String.valueOf(Math.max(i, Math.min(i29, kVar2.a.z().o(str85, c3.p))));
            valueOf6 = (long)delete;
            if (Long.compare(valueOf6, str17) > 0) {
                b().w().c("Data lost. Too many events stored on disk, deleted. appId", q3.z(str85), Long.valueOf(valueOf6));
            }
            String str53 = uVar.a;
            int i68 = i;
            str19 = i55;
            String str116 = str53;
            super(obj2.l, uVar.c, str85, str116, uVar.v, i17, 0, i2, bundle2);
            com.google.android.gms.measurement.internal.k kVar8 = obj2.c;
            ba.Q(kVar8);
            com.google.android.gms.measurement.internal.q qVar2 = kVar8.X(str85, pVar.b);
            if (qVar2 == null) {
                com.google.android.gms.measurement.internal.k kVar11 = obj2.c;
                ba.Q(kVar11);
                if (Long.compare(l6, l18) >= 0 && z6) {
                    if (z6) {
                        b().r().d("Too many event names used, ignoring event. appId, name, supported count", q3.z(str85), obj2.l.D().d(pVar.b), Integer.valueOf(S().l(str85)));
                        f0().A(obj2.B, str85, 8, 0, 0, 0);
                        com.google.android.gms.measurement.internal.k kVar12 = obj2.c;
                        ba.Q(kVar12);
                        kVar12.i0();
                    }
                }
                super(str85, pVar.b, 0, str116, 0, i17, 0, i2, pVar.d, i11, 0, obj23, 0, 0, 0, 0);
            } else {
                qVar = qVar2.c(pVar.d);
            }
            com.google.android.gms.measurement.internal.k kVar19 = obj2.c;
            ba.Q(kVar19);
            kVar19.r(qVar);
            a().h();
            g();
            r.j(pVar);
            r.j(na2);
            r.f(pVar.a);
            Object obj4 = na2;
            r.a(pVar.a.equals(obj4.a));
            y4 y4Var2 = z4.G1();
            y4Var2.S(1);
            y4Var2.O("android");
            if (!TextUtils.isEmpty(obj4.a)) {
                y4Var2.s(obj4.a);
            }
            if (!TextUtils.isEmpty(obj4.v)) {
                y4Var2.u(obj4.v);
            }
            if (!TextUtils.isEmpty(obj4.c)) {
                y4Var2.v(obj4.c);
            }
            l2 = obj4.B;
            if (Long.compare(l2, i41) != 0) {
                y4Var2.w((int)l2);
            }
            y4Var2.K(obj4.w);
            if (!TextUtils.isEmpty(obj4.b)) {
                y4Var2.J(obj4.b);
            }
            String str59 = obj4.a;
            r.j(str59);
            y4Var2.A(obj2.T((String)str59).c(h.b(obj4.N)).i());
            kd.b();
            String str76 = obj4.a;
            if (S().B(str76, c3.d0)) {
                if (TextUtils.isEmpty(y4Var2.f0()) && !TextUtils.isEmpty(obj4.M)) {
                    if (!TextUtils.isEmpty(obj4.M)) {
                        y4Var2.I(obj4.M);
                    }
                }
                if (TextUtils.isEmpty(y4Var2.f0()) && TextUtils.isEmpty(y4Var2.e0()) && !TextUtils.isEmpty(obj4.I)) {
                    if (TextUtils.isEmpty(y4Var2.e0())) {
                        if (!TextUtils.isEmpty(obj4.I)) {
                            y4Var2.H0(obj4.I);
                        }
                    }
                }
            } else {
                if (TextUtils.isEmpty(y4Var2.f0()) && !TextUtils.isEmpty(obj4.I)) {
                    if (!TextUtils.isEmpty(obj4.I)) {
                        y4Var2.H0(obj4.I);
                    }
                }
            }
            long l20 = obj4.x;
            if (Long.compare(l20, intValue) != 0) {
                y4Var2.B(l20);
            }
            y4Var2.E(obj4.K);
            size = obj2.g;
            ba.Q(size);
            iterator = c3.c(baVar2.l.f());
            if (iterator != null) {
                if (iterator.size() == 0) {
                    arrayList = str19;
                } else {
                    arrayList = new ArrayList();
                    iterator = iterator.entrySet().iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((String)(Map.Entry)next.getKey().startsWith("measurement.id.") != 0) {
                            break;
                        } else {
                        }
                        next = Integer.parseInt((String)next.getValue());
                        if (next != null) {
                            break;
                        } else {
                        }
                        arrayList.add(Integer.valueOf(next));
                        if (arrayList.size() >= (Integer)c3.P.a(str19).intValue()) {
                            break;
                        } else {
                        }
                    }
                    if (arrayList.size() == 0) {
                    }
                }
            } else {
            }
            if (arrayList != null) {
                y4Var2.q0(arrayList);
            }
            String str66 = obj4.a;
            r.j(str66);
            com.google.android.gms.measurement.internal.h hVar4 = obj2.T((String)str66).c(h.b(obj4.N));
            booleanValue = obj2.i.n(obj4.a, hVar4);
            y4Var2.T((String)booleanValue.first);
            booleanValue = booleanValue.second;
            if (hVar4.j() && !TextUtils.isEmpty((CharSequence)booleanValue.first) && obj4.G && booleanValue != null) {
                booleanValue = obj2.i.n(obj4.a, hVar4);
                if (!TextUtils.isEmpty((CharSequence)booleanValue.first)) {
                    if (obj4.G) {
                        y4Var2.T((String)booleanValue.first);
                        booleanValue = booleanValue.second;
                        if (booleanValue != null) {
                            y4Var2.M((Boolean)booleanValue.booleanValue());
                        }
                    }
                }
            }
            obj2.l.A().k();
            y4Var2.C(Build.MODEL);
            obj2.l.A().k();
            y4Var2.N(Build.VERSION.RELEASE);
            y4Var2.X((int)l23);
            y4Var2.b0(obj2.l.A().q());
            b3Var2 = c3.m0;
            if (!S().B(str19, b3Var2)) {
                y4Var2.I0(obj4.D);
            }
            if (obj2.l.o()) {
                y4Var2.d0();
                if (!TextUtils.isEmpty(str19)) {
                } else {
                }
                y4Var2.D(str19);
                throw str19;
            }
            com.google.android.gms.measurement.internal.k kVar23 = obj2.c;
            ba.Q(kVar23);
            g5Var = new g5(obj2.l, obj4.a);
            g5Var.i(obj2.g0(hVar4));
            g5Var.w(obj4.C);
            g5Var.y(obj4.b);
            if (kVar23.T(obj4.a) == null && hVar4.j()) {
                g5Var = new g5(obj2.l, obj4.a);
                g5Var.i(obj2.g0(hVar4));
                g5Var.w(obj4.C);
                g5Var.y(obj4.b);
                if (hVar4.j()) {
                    g5Var.H(obj2.i.o(obj4.a));
                }
                int i42 = 0;
                g5Var.D(i42);
                g5Var.E(i42);
                g5Var.C(i42);
                g5Var.k(obj4.c);
                g5Var.l(obj4.B);
                g5Var.j(obj4.v);
                g5Var.z(obj4.w);
                g5Var.t(obj4.x);
                g5Var.F(obj4.z);
                str3 = S();
                if (!str3.B(str19, b3Var2)) {
                    g5Var.h(obj4.D);
                }
                g5Var.u(obj4.K);
                b3Var2 = obj2.c;
                ba.Q(b3Var2);
                b3Var2.q(g5Var);
            }
            if (hVar4.k() && !TextUtils.isEmpty(g5Var.f0())) {
                if (!TextUtils.isEmpty(g5Var.f0())) {
                    empty5 = g5Var.f0();
                    r.j(empty5);
                    y4Var2.t((String)empty5);
                }
            }
            if (!TextUtils.isEmpty(g5Var.i0())) {
                empty7 = g5Var.i0();
                r.j(empty7);
                y4Var2.H((String)empty7);
            }
            kVar3 = obj2.c;
            ba.Q(kVar3);
            List list = kVar3.e0(obj4.a);
            i15 = i68;
            while (i15 < list.size()) {
                kVar3 = j5.z();
                kVar3.x(obj8.c);
                kVar3.y(obj9.d);
                g5Var = obj2.g;
                ba.Q(g5Var);
                g5Var.M(kVar3, obj11.e);
                y4Var2.s0(kVar3);
                i15++;
            }
            com.google.android.gms.measurement.internal.k kVar20 = obj2.c;
            ba.Q(kVar20);
            w8Var = y4Var2.l();
            kVar20.h();
            kVar20.i();
            r.j((z4)w8Var);
            r.f(w8Var.L1());
            byte[] bArr2 = w8Var.j();
            com.google.android.gms.measurement.internal.da daVar2 = baVar3.g;
            ba.Q(daVar2);
            long l25 = daVar2.y(bArr2);
            ContentValues contentValues2 = new ContentValues();
            String str113 = str125;
            contentValues2.put(str113, w8Var.L1());
            String str117 = str4;
            contentValues2.put(str117, Long.valueOf(l25));
            contentValues2.put("metadata", bArr2);
            kVar20.R().insertWithOnConflict("raw_events_metadata", str19, contentValues2, 4);
            kVar4 = obj2.c;
            ba.Q(kVar4);
            rVar2 = new r(pVar.f);
            while (rVar2.hasNext()) {
            }
            com.google.android.gms.measurement.internal.t4 t4Var3 = obj2.a;
            ba.Q(t4Var3);
            com.google.android.gms.measurement.internal.k kVar21 = obj2.c;
            ba.Q(kVar21);
            i3 = t4Var3.w(pVar.a, pVar.b) ? 1 : i68;
            kVar4.h();
            kVar4.i();
            r.j(pVar);
            r.f(pVar.a);
            com.google.android.gms.measurement.internal.da daVar = baVar.g;
            ba.Q(daVar);
            ContentValues contentValues = new ContentValues();
            contentValues.put(str113, pVar.a);
            contentValues.put("name", pVar.b);
            contentValues.put("timestamp", Long.valueOf(pVar.d));
            contentValues.put(str117, Long.valueOf(l25));
            contentValues.put("data", daVar.C(pVar).j());
            contentValues.put("realtime", Integer.valueOf(i3));
            if (Long.compare(insert, i6) == 0) {
                kVar4.a.b().r().b("Failed to insert raw event (got -1). appId", q3.z(pVar.a));
            } else {
                obj2.o = 0;
            }
            com.google.android.gms.measurement.internal.k kVar9 = obj2.c;
            ba.Q(kVar9);
            kVar9.p();
            com.google.android.gms.measurement.internal.k kVar10 = obj2.c;
            ba.Q(kVar10);
            kVar10.i0();
            L();
            b().v().b("Background event processing time, ms", Long.valueOf(i24 /= i28));
        }
        obj2.R(str);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final boolean C() {
        FileLock valid;
        com.google.android.gms.measurement.internal.o3 o3Var;
        String str;
        String str2;
        a().h();
        valid = this.v;
        int i2 = 1;
        str2 = "Storage concurrent access okay";
        if (valid != null && !valid.isValid()) {
            if (!valid.isValid()) {
            }
            b().v().a(str2);
            return i2;
        }
        kVar.a.z();
        File file = new File(this.l.f().getFilesDir(), "google_app_measurement.db");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileChannel channel = randomAccessFile.getChannel();
        this.w = channel;
        FileLock tryLock = channel.tryLock();
        this.v = tryLock;
        if (tryLock != null) {
            b().v().a(str2);
            return i2;
        }
        b().r().a("Storage concurrent data access panic");
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final long F() {
        Object x8Var;
        long l;
        int i;
        int cmp;
        x8Var = this.i;
        x8Var.i();
        x8Var.h();
        if (Long.compare(l, i10) == 0) {
            i = 86400000;
            x8Var.k.b(l2 += cmp);
        }
        int i8 = 60;
        return i5 /= i9;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final com.google.android.gms.measurement.internal.g5 R(com.google.android.gms.measurement.internal.na na) {
        com.google.android.gms.measurement.internal.g5 g5Var;
        com.google.android.gms.measurement.internal.h gaVar;
        boolean z2;
        boolean empty2;
        boolean empty4;
        boolean empty;
        boolean z;
        String empty3;
        boolean z3;
        boolean equals;
        String str2;
        com.google.android.gms.measurement.internal.b3 equals2;
        String str;
        Object str3;
        long str4;
        long currentTimeMillis;
        Long valueOf;
        boolean obj12;
        a().h();
        g();
        r.j(na);
        r.f(na.a);
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        g5Var = kVar.T(na.a);
        gaVar = T(na.a).c(h.b(na.N));
        if (gaVar.j()) {
            empty3 = this.i.o(na.a);
        } else {
            empty3 = "";
        }
        int i = 0;
        if (g5Var == null) {
            g5Var = new g5(this.l, na.a);
            if (gaVar.k()) {
                g5Var.i(g0(gaVar));
            }
            if (gaVar.j()) {
                g5Var.H(empty3);
            }
        } else {
            if (gaVar.j() && empty3 != null && !empty3.equals(g5Var.b())) {
                if (empty3 != null) {
                    if (!empty3.equals(g5Var.b())) {
                        g5Var.H(empty3);
                        pb.b();
                        equals2 = c3.t0;
                        str = "00000000-0000-0000-0000-000000000000";
                        if (S().B(i, equals2) && S().B(i, c3.w0)) {
                            if (S().B(i, c3.w0)) {
                                if (!str.equals(pair2.first)) {
                                    g5Var.i(g0(gaVar));
                                }
                            } else {
                                g5Var.i(g0(gaVar));
                            }
                        } else {
                        }
                        pb.b();
                        com.google.android.gms.measurement.internal.k kVar2 = this.c;
                        ba.Q(kVar2);
                        com.google.android.gms.measurement.internal.k kVar3 = this.c;
                        ba.Q(kVar3);
                        if (S().B(i, equals2) && !str.equals(pair.first) && kVar2.Z(na.a, "_id") != null && kVar3.Z(na.a, "_lair") == null) {
                            if (!str.equals(pair.first)) {
                                kVar2 = this.c;
                                ba.Q(kVar2);
                                if (kVar2.Z(na.a, "_id") != null) {
                                    kVar3 = this.c;
                                    ba.Q(kVar3);
                                    if (kVar3.Z(na.a, "_lair") == null) {
                                        super(na.a, "auto", "_lair", c().currentTimeMillis(), obj9, Long.valueOf(1));
                                        empty3 = this.c;
                                        ba.Q(empty3);
                                        empty3.z(gaVar);
                                    }
                                }
                            }
                        }
                    } else {
                        if (TextUtils.isEmpty(g5Var.f0()) && gaVar.k()) {
                            if (gaVar.k()) {
                                g5Var.i(g0(gaVar));
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
        g5Var.y(na.b);
        g5Var.f(na.I);
        kd.b();
        String str15 = g5Var.e0();
        if (S().B(str15, c3.d0)) {
            g5Var.x(na.M);
        }
        if (!TextUtils.isEmpty(na.C)) {
            g5Var.w(na.C);
        }
        long l = na.w;
        if (Long.compare(l, i2) != 0) {
            g5Var.z(l);
        }
        if (!TextUtils.isEmpty(na.c)) {
            g5Var.k(na.c);
        }
        g5Var.l(na.B);
        String str12 = na.v;
        if (str12 != null) {
            g5Var.j(str12);
        }
        g5Var.t(na.x);
        g5Var.F(na.z);
        if (!TextUtils.isEmpty(na.y)) {
            g5Var.B(na.y);
        }
        com.google.android.gms.measurement.internal.b3 b3Var = c3.m0;
        if (!S().B(i, b3Var)) {
            g5Var.h(na.D);
        }
        g5Var.g(na.G);
        g5Var.G(na.J);
        g5Var.u(na.K);
        if (g5Var.L()) {
            obj12 = this.c;
            ba.Q(obj12);
            obj12.q(g5Var);
        }
        return g5Var;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.g S() {
        com.google.android.gms.measurement.internal.b5 b5Var = this.l;
        r.j(b5Var);
        return (b5)b5Var.z();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final com.google.android.gms.measurement.internal.h T(String string) {
        Object obj;
        String string2;
        String moveToFirst;
        int i;
        SQLiteDatabase sQLiteDatabase;
        Object str;
        Cursor rawQuery;
        a().h();
        g();
        if ((h)this.A.get(string) == null) {
            com.google.android.gms.measurement.internal.k kVar = this.c;
            ba.Q(kVar);
            r.j(string);
            kVar.h();
            kVar.i();
            String[] strArr = new String[1];
            i = 0;
            strArr[i] = string;
            int i3 = 0;
            rawQuery = kVar.R().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", strArr);
            if (rawQuery.moveToFirst()) {
                string2 = rawQuery.getString(i);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else {
                if (rawQuery != null) {
                    rawQuery.close();
                }
                string2 = "G1";
            }
            y(string, h.b(string2));
        }
        return obj;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.k U() {
        final com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        return kVar;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.l3 V() {
        return this.l.D();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.w3 W() {
        final com.google.android.gms.measurement.internal.w3 w3Var = this.b;
        ba.Q(w3Var);
        return w3Var;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.y3 X() {
        com.google.android.gms.measurement.internal.y3 y3Var = this.d;
        if (y3Var == null) {
        } else {
            return y3Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Network broadcast receiver not created");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.t4 Y() {
        final com.google.android.gms.measurement.internal.t4 t4Var = this.a;
        ba.Q(t4Var);
        return t4Var;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.y4 a() {
        com.google.android.gms.measurement.internal.b5 b5Var = this.l;
        r.j(b5Var);
        return (b5)b5Var.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final com.google.android.gms.measurement.internal.b5 a0() {
        return this.l;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.q3 b() {
        com.google.android.gms.measurement.internal.b5 b5Var = this.l;
        r.j(b5Var);
        return (b5)b5Var.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.n7 b0() {
        final com.google.android.gms.measurement.internal.n7 n7Var = this.h;
        ba.Q(n7Var);
        return n7Var;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final e c() {
        com.google.android.gms.measurement.internal.b5 b5Var = this.l;
        r.j(b5Var);
        return (b5)b5Var.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.x8 c0() {
        return this.i;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.b d() {
        throw 0;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void e() {
        int cmp;
        com.google.android.gms.measurement.internal.o3 o3Var;
        boolean z;
        int valueOf4;
        Throwable valueOf2;
        long size;
        String valueOf;
        int valueOf3;
        boolean sDK_INT;
        int i;
        int int;
        int allocate;
        String open;
        com.google.android.gms.measurement.internal.b3 b3Var;
        a().h();
        g();
        z = 1;
        this.n = z;
        if (!this.n && C()) {
            z = 1;
            this.n = z;
            if (C()) {
                FileChannel fileChannel = this.w;
                a().h();
                valueOf = "Bad channel to read from";
                valueOf3 = 0;
                i = 4;
                int = 0;
                if (fileChannel != null) {
                    if (fileChannel.isOpen() == null) {
                        b().r().a(valueOf);
                    } else {
                        allocate = ByteBuffer.allocate(i);
                        fileChannel.position(valueOf3);
                        valueOf4 = fileChannel.read(allocate);
                        if (valueOf4 != i) {
                            if (valueOf4 != -1) {
                                b().w().b("Unexpected data length. Bytes read", Integer.valueOf(valueOf4));
                            }
                        } else {
                            allocate.flip();
                            int = allocate.getInt();
                        }
                    }
                } else {
                }
                valueOf2 = this.l.B().p();
                a().h();
                if (int > valueOf2) {
                    b().r().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(int), Integer.valueOf(valueOf2));
                }
                allocate = this.w;
                a().h();
                if (int < valueOf2 && allocate != null) {
                    allocate = this.w;
                    a().h();
                    if (allocate != null) {
                        if (!allocate.isOpen()) {
                        } else {
                            ByteBuffer allocate2 = ByteBuffer.allocate(i);
                            allocate2.putInt(valueOf2);
                            allocate2.flip();
                            allocate.truncate(valueOf3);
                            if (S().B(0, c3.l0) && Build.VERSION.SDK_INT <= 19) {
                                if (Build.VERSION.SDK_INT <= 19) {
                                    allocate.position(valueOf3);
                                }
                            }
                            allocate.write(allocate2);
                            allocate.force(z);
                            final int i2 = 4;
                            if (Long.compare(size, i2) != 0) {
                                b().r().b("Error writing to channel. Bytes written", Long.valueOf(allocate.size()));
                            }
                        }
                        b().v().c("Storage version upgraded. Previous, current version", Integer.valueOf(int), Integer.valueOf(valueOf2));
                    }
                    b().r().a(valueOf);
                    b().r().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(int), Integer.valueOf(valueOf2));
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.da e0() {
        final com.google.android.gms.measurement.internal.da daVar = this.g;
        ba.Q(daVar);
        return daVar;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final Context f() {
        return this.l.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final com.google.android.gms.measurement.internal.ia f0() {
        com.google.android.gms.measurement.internal.b5 b5Var = this.l;
        r.j(b5Var);
        return (b5)b5Var.N();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void g() {
        if (!this.m) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("UploadController is not initialized");
        throw illegalStateException;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final String g0(com.google.android.gms.measurement.internal.h h) {
        if (h.k()) {
            byte[] obj5 = new byte[16];
            f0().t().nextBytes(obj5);
            final int i = 1;
            final Object[] arr = new Object[i];
            BigInteger bigInteger = new BigInteger(i, obj5);
            arr[0] = bigInteger;
            return String.format(Locale.US, "%032x", arr);
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void h(com.google.android.gms.measurement.internal.g5 g5) {
        boolean empty2;
        boolean str;
        d4 empty3;
        com.google.android.gms.measurement.internal.b3 empty;
        String str2;
        String str3;
        String concat;
        boolean empty4;
        int aVar;
        a().h();
        kd.b();
        empty = c3.d0;
        if (S().B(g5.e0(), empty)) {
            if (TextUtils.isEmpty(g5.k0()) && TextUtils.isEmpty(g5.j0()) && !TextUtils.isEmpty(g5.c0())) {
                if (TextUtils.isEmpty(g5.j0())) {
                    if (!TextUtils.isEmpty(g5.c0())) {
                    }
                    String obj13 = g5.e0();
                    r.j(obj13);
                    this.m((String)obj13, 204, 0, 0, 0);
                }
            }
        } else {
            if (TextUtils.isEmpty(g5.k0()) && TextUtils.isEmpty(g5.c0())) {
                if (TextUtils.isEmpty(g5.c0())) {
                    obj13 = g5.e0();
                    r.j(obj13);
                    this.m((String)obj13, 204, 0, 0, 0);
                }
            }
        }
        com.google.android.gms.measurement.internal.s9 s9Var = this.j;
        Uri.Builder builder = new Uri.Builder();
        if (TextUtils.isEmpty(g5.k0())) {
            kd.b();
            if (s9Var.a.z().B(g5.e0(), empty)) {
                if (TextUtils.isEmpty(g5.j0())) {
                    str3 = g5.c0();
                }
            } else {
                str3 = g5.c0();
            }
        }
        aVar = 0;
        String valueOf = String.valueOf(str3);
        String str18 = "config/app/";
        int length = valueOf.length();
        if (length != 0) {
            concat = str18.concat(valueOf);
        } else {
            concat = new String(str18);
        }
        s9Var.a.z().q();
        builder.scheme((String)c3.e.a(aVar)).encodedAuthority((String)c3.f.a(aVar)).path(concat).appendQueryParameter("app_instance_id", g5.f0()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(46000));
        de.b();
        if (s9Var.a.z().B(g5.e0(), c3.r0)) {
            builder.appendQueryParameter("runtime_version", "0");
        }
        String str11 = g5.e0();
        r.j(str11);
        final String str22 = str11;
        URL url = new URL(builder.build().toString());
        b().v().b("Fetching remote configuration", (String)str22);
        com.google.android.gms.measurement.internal.t4 t4Var = this.a;
        ba.Q(t4Var);
        com.google.android.gms.measurement.internal.t4 t4Var2 = this.a;
        ba.Q(t4Var2);
        String str15 = t4Var2.p(str22);
        if (t4Var.o(str22) != null && !TextUtils.isEmpty(str15)) {
            if (!TextUtils.isEmpty(str15)) {
                aVar = new a();
                aVar.put("If-Modified-Since", str15);
            }
        }
        this.s = true;
        com.google.android.gms.measurement.internal.w3 w3Var = this.b;
        ba.Q(w3Var);
        v9 v9Var = new v9(this);
        w3Var.h();
        w3Var.i();
        r.j(url);
        r.j(v9Var);
        super(w3Var, str22, url, 0, aVar, v9Var);
        w3Var.a.a().y(v3Var);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final String h0(com.google.android.gms.measurement.internal.na na) {
        w9 w9Var = new w9(this, na);
        return (String)a().s(w9Var).get(30000, str);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void i(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        List emptyList2;
        Object obj2;
        List emptyList3;
        List emptyList;
        Object kVar;
        int size2;
        boolean next2;
        com.google.android.gms.measurement.internal.o3 o3Var;
        boolean z;
        Object list;
        String[] strArr;
        String str3;
        int str2;
        com.google.android.gms.measurement.internal.u uVar;
        int next;
        Object valueOf2;
        String strArr3;
        String[] strArr2;
        ArrayList arrayList;
        String str7;
        Object str5;
        Object str4;
        int size;
        Long valueOf3;
        int valueOf;
        Object obj;
        String str6;
        int str;
        com.google.android.gms.measurement.internal.s sVar;
        String gaVar;
        long l;
        final Object obj4 = this;
        Object obj3 = na2;
        r.j(na2);
        r.f(obj3.a);
        a().h();
        g();
        String str9 = obj3.a;
        final long l3 = obj2.v;
        me.b();
        uVar = 0;
        int i3 = 0;
        if (S().B(uVar, c3.x0)) {
            com.google.android.gms.measurement.internal.r3 r3Var = r3.b(u);
            a().h();
            ia.x(uVar, r3Var.d, i3);
            obj2 = r3Var.a();
        }
        ba.Q(obj4.g);
        if (!da.n(obj2, obj3)) {
        }
        if (!obj3.z) {
            obj4.R(obj3);
        }
        list = obj3.L;
        if (list != null && list.contains(obj2.a)) {
            if (list.contains(obj2.a)) {
                list = obj2.b.k2();
                list.putLong("ga_safelisted", 1);
                sVar = new s(list);
                super(obj2.a, sVar, obj2.c, obj2.v, obj17);
                com.google.android.gms.measurement.internal.k kVar5 = obj4.c;
                ba.Q(kVar5);
                kVar5.g0();
                com.google.android.gms.measurement.internal.k kVar6 = obj4.c;
                ba.Q(kVar6);
                r.f(str9);
                kVar6.h();
                kVar6.i();
                int cmp = Long.compare(l3, i4);
                next = 2;
                if (cmp < 0) {
                    kVar6.a.b().w().c("Invalid time querying timed out conditional properties", q3.z(str9), Long.valueOf(l3));
                    emptyList3 = Collections.emptyList();
                } else {
                    strArr3 = new String[next];
                    strArr3[i3] = str9;
                    strArr3[1] = String.valueOf(l3);
                    emptyList3 = kVar6.d0("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", strArr3);
                }
                Iterator iterator3 = emptyList3.iterator();
                while (iterator3.hasNext()) {
                    strArr3 = iterator3.next();
                    b().v().d("User property timed out", strArr3.a, obj4.l.D().f(eaVar7.b), strArr3.c.j2());
                    com.google.android.gms.measurement.internal.u uVar4 = strArr3.y;
                    if ((c)strArr3 != null && uVar4 != null) {
                    }
                    b().v().d("User property timed out", strArr3.a, obj4.l.D().f(eaVar7.b), strArr3.c.j2());
                    uVar4 = strArr3.y;
                    if (uVar4 != null) {
                    }
                    str5 = obj4.c;
                    ba.Q(str5);
                    str5.K(str9, eaVar4.b);
                    str = 1;
                    valueOf3 = new u(uVar4, l3, obj11);
                    obj4.B(valueOf3, obj3);
                }
                com.google.android.gms.measurement.internal.k kVar7 = obj4.c;
                ba.Q(kVar7);
                r.f(str9);
                kVar7.h();
                kVar7.i();
                if (cmp < 0) {
                    kVar7.a.b().w().c("Invalid time querying expired conditional properties", q3.z(str9), Long.valueOf(l3));
                    emptyList = Collections.emptyList();
                } else {
                    strArr2 = new String[next];
                    strArr2[i3] = str9;
                    strArr2[1] = String.valueOf(l3);
                    emptyList = kVar7.d0("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", strArr2);
                }
                arrayList = new ArrayList(emptyList.size());
                Iterator iterator4 = emptyList.iterator();
                boolean next6 = iterator4.hasNext();
                while (next6) {
                    size = iterator4.next();
                    b().v().d("User property expired", size.a, obj4.l.D().f(eaVar3.b), size.c.j2());
                    com.google.android.gms.measurement.internal.k kVar9 = obj4.c;
                    ba.Q(kVar9);
                    kVar9.n(str9, eaVar6.b);
                    com.google.android.gms.measurement.internal.u uVar3 = size.C;
                    if ((c)size != 0 && uVar3 != null) {
                    }
                    next6 = iterator4.hasNext();
                    b().v().d("User property expired", size.a, obj4.l.D().f(eaVar3.b), size.c.j2());
                    kVar9 = obj4.c;
                    ba.Q(kVar9);
                    kVar9.n(str9, eaVar6.b);
                    uVar3 = size.C;
                    if (uVar3 != null) {
                    }
                    com.google.android.gms.measurement.internal.k kVar10 = obj4.c;
                    ba.Q(kVar10);
                    kVar10.K(str9, eaVar5.b);
                    next = 2;
                    arrayList.add(uVar3);
                }
                Iterator iterator5 = arrayList.iterator();
                for (u next : iterator5) {
                    arrayList = new u(next, l3, obj11);
                    obj4.B(arrayList, obj3);
                }
                kVar = obj4.c;
                ba.Q(kVar);
                valueOf2 = obj.a;
                r.f(str9);
                r.f(valueOf2);
                kVar.h();
                kVar.i();
                if (cmp < 0) {
                    kVar.a.b().w().d("Invalid time querying triggered conditional properties", q3.z(str9), kVar.a.D().d(valueOf2), Long.valueOf(l3));
                    emptyList2 = Collections.emptyList();
                } else {
                    strArr = new String[3];
                    strArr[i3] = str9;
                    strArr[1] = valueOf2;
                    strArr[2] = String.valueOf(l3);
                    emptyList2 = kVar.d0("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", strArr);
                }
                ArrayList arrayList2 = new ArrayList(emptyList2.size());
                Iterator iterator = emptyList2.iterator();
                while (iterator.hasNext()) {
                    sVar = size2;
                    if ((c)sVar != null) {
                    }
                    com.google.android.gms.measurement.internal.ea eaVar = sVar.c;
                    String str13 = sVar.a;
                    r.j(str13);
                    valueOf = eaVar.j2();
                    r.j(valueOf);
                    super((String)str13, sVar.b, eaVar.b, l3, next6, valueOf);
                    com.google.android.gms.measurement.internal.k kVar8 = obj4.c;
                    ba.Q(kVar8);
                    if (kVar8.z(gaVar)) {
                    } else {
                    }
                    b().r().d("Too many active user properties, ignoring", q3.z(sVar.a), obj4.l.D().f(gaVar.c), gaVar.e);
                    com.google.android.gms.measurement.internal.u uVar2 = sVar.A;
                    if (uVar2 != null) {
                    }
                    ea eaVar2 = new ea(gaVar);
                    sVar.c = eaVar2;
                    sVar.w = true;
                    strArr = obj4.c;
                    ba.Q(strArr);
                    strArr.y((c)sVar);
                    arrayList2.add(uVar2);
                    b().v().d("User property triggered", sVar.a, obj4.l.D().f(gaVar.c), gaVar.e);
                }
                obj4.B(obj, obj3);
                Iterator iterator2 = arrayList2.iterator();
                for (u next2 : iterator2) {
                    strArr = new u(next2, l3, obj11);
                    obj4.B(strArr, obj3);
                }
                com.google.android.gms.measurement.internal.k kVar2 = obj4.c;
                ba.Q(kVar2);
                kVar2.p();
                com.google.android.gms.measurement.internal.k kVar3 = obj4.c;
                ba.Q(kVar3);
                kVar3.i0();
            }
            b().q().d("Dropping non-safelisted event. appId, event name, origin", str9, obj2.a, obj2.c);
        }
        obj = obj2;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void j(com.google.android.gms.measurement.internal.u u, String string2) {
        int i;
        boolean booleanValue;
        boolean empty;
        Object str2;
        String str;
        final Object obj = this;
        String str4 = string2;
        com.google.android.gms.measurement.internal.k kVar = obj.c;
        ba.Q(kVar);
        com.google.android.gms.measurement.internal.g5 g5Var = kVar.T(str4);
        if (g5Var != null) {
            if (TextUtils.isEmpty(g5Var.h0())) {
            } else {
                Boolean bool = obj.H(g5Var);
                if (bool == null) {
                    if (!"_ui".equals(obj2.a)) {
                        b().w().b("Could not find package. appId", q3.z(string2));
                    }
                } else {
                    if (!bool.booleanValue()) {
                        b().r().b("App version does not match; dropping event. appId", q3.z(string2));
                    }
                }
                final Boolean bool3 = g5Var.b0();
                kd.b();
                if (S().B(g5Var.e0(), c3.d0)) {
                    i = g5Var.j0();
                } else {
                    i = 0;
                }
            }
            super(string2, g5Var.k0(), g5Var.h0(), g5Var.M(), obj7, g5Var.g0(), g5Var.X(), obj10, g5Var.U(), obj12, 0, g5Var.K(), 0, g5Var.i0(), g5Var.A(), obj18, 0, obj20, 0, g5Var.J(), 0, g5Var.c0(), bool3, g5Var.V(), bool3, g5Var.c(), i, obj.T(str4).i());
            obj.k(u, naVar3);
        }
        b().q().b("No app data available; dropping event", str4);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void j0(Runnable runnable) {
        Object arrayList;
        a().h();
        if (this.p == null) {
            arrayList = new ArrayList();
            this.p = arrayList;
        }
        this.p.add(runnable);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void k(com.google.android.gms.measurement.internal.u u, com.google.android.gms.measurement.internal.na na2) {
        boolean eaVar;
        String str4;
        Object str2;
        String str5;
        long l;
        String str;
        String str3;
        r.f(na2.a);
        com.google.android.gms.measurement.internal.r3 obj9 = r3.b(u);
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        f0().y(obj9.d, kVar.S(na2.a));
        f0().z(obj9, S().n(na2.a));
        obj9 = obj9.a();
        if (!"_cmp".equals(obj9.a)) {
        } else {
            str = obj9.b.o2("gclid");
            if ("referrer API v2".equals(obj9.b.o2("_cis")) && !TextUtils.isEmpty(str)) {
                str = obj9.b.o2("gclid");
                if (!TextUtils.isEmpty(str)) {
                    super("_lgclid", obj9.v, obj5, str, "auto");
                    z(eaVar, na2);
                }
            }
        }
        i(obj9, na2);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void l() {
        this.r = i++;
    }

    final void m(String string, int i2, Throwable throwable3, byte[] b4Arr4, Map<String, List<String>> map5) {
        com.google.android.gms.measurement.internal.g5 valueOf;
        int i3;
        int size;
        int i;
        com.google.android.gms.measurement.internal.k obj7;
        int obj8;
        boolean obj9;
        byte[] obj10;
        Object obj11;
        a().h();
        g();
        r.f(string);
        int i4 = 0;
        if (b4Arr4 == null) {
            obj10 = new byte[i4];
        }
        Integer valueOf2 = Integer.valueOf(obj10.length);
        b().v().b("onConfigFetched. Response size", valueOf2);
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        kVar.g0();
        com.google.android.gms.measurement.internal.k kVar2 = this.c;
        ba.Q(kVar2);
        valueOf = kVar2.T(string);
        final int i5 = 304;
        if (i2 != 200 && i2 != 204) {
            if (i2 != 204) {
                if (i2 == i5) {
                    obj8 = i5;
                    size = throwable3 == null ? 1 : i4;
                } else {
                }
            } else {
            }
        } else {
        }
        if (valueOf == null) {
            b().w().b("App does not exist in onConfigFetched. appId", q3.z(string));
            obj7 = this.c;
            ba.Q(obj7);
            obj7.p();
            ba.Q(this.c);
        } else {
            i = 404;
            if (size == 0) {
                if (obj8 == i) {
                    obj9 = 0;
                    if (map5 != null) {
                        obj11 = map5.get("Last-Modified");
                    } else {
                        obj11 = obj9;
                    }
                    if (obj11 != null && obj11.size() > 0) {
                        if (obj11.size() > 0) {
                            obj11 = obj11.get(i4);
                        } else {
                            obj11 = obj9;
                        }
                    } else {
                    }
                    if (obj8 != i) {
                        if (obj8 == i5) {
                            obj10 = this.a;
                            ba.Q(obj10);
                            obj10 = this.a;
                            ba.Q(obj10);
                            if (obj10.o(string) == null && !obj10.z(string, obj9, obj9)) {
                                obj10 = this.a;
                                ba.Q(obj10);
                                if (!obj10.z(string, obj9, obj9)) {
                                    ba.Q(this.c);
                                } else {
                                    valueOf.m(c().currentTimeMillis());
                                    obj9 = this.c;
                                    ba.Q(obj9);
                                    obj9.q(valueOf);
                                    if (obj8 == i) {
                                        b().x().b("Config not found. Using empty config. appId", string);
                                    } else {
                                        b().v().c("Successfully fetched config. Got network response. code, size", Integer.valueOf(obj8), valueOf2);
                                    }
                                    obj7 = this.b;
                                    ba.Q(obj7);
                                    if (obj7.m() && O()) {
                                        if (O()) {
                                            A();
                                        } else {
                                            L();
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        } else {
                            obj9 = this.a;
                            ba.Q(obj9);
                            if (!obj9.z(string, obj10, obj11)) {
                                ba.Q(this.c);
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                    valueOf.v(c().currentTimeMillis());
                    obj10 = this.c;
                    ba.Q(obj10);
                    obj10.q(valueOf);
                    obj10 = b().v();
                    obj10.c("Fetching config failed. code, error", Integer.valueOf(obj8), throwable3);
                    obj9 = this.a;
                    ba.Q(obj9);
                    obj9.r(string);
                    obj9 = c().currentTimeMillis();
                    obj7.j.b(obj9);
                    if (obj8 != 503) {
                        if (obj8 == 429) {
                            try {
                                obj7.h.b(c().currentTimeMillis());
                                L();
                                obj9 = 0;
                                if (map5 != null) {
                                } else {
                                }
                                obj11 = map5.get("Last-Modified");
                                obj11 = obj9;
                                if (obj11 != null && obj11.size() > 0) {
                                } else {
                                }
                                if (obj11.size() > 0) {
                                } else {
                                }
                                obj11 = obj11.get(i4);
                                obj11 = obj9;
                                if (obj8 != i) {
                                } else {
                                }
                                if (obj8 == i5) {
                                } else {
                                }
                                obj9 = this.a;
                                ba.Q(obj9);
                                if (!obj9.z(string, obj10, obj11)) {
                                } else {
                                }
                                ba.Q(this.c);
                                obj7.i0();
                                this.s = i4;
                                I();
                                obj10 = this.a;
                                ba.Q(obj10);
                                obj10 = this.a;
                                ba.Q(obj10);
                                if (obj10.o(string) == null && !obj10.z(string, obj9, obj9)) {
                                } else {
                                }
                                obj10 = this.a;
                                ba.Q(obj10);
                                if (!obj10.z(string, obj9, obj9)) {
                                } else {
                                }
                                ba.Q(this.c);
                                valueOf.m(c().currentTimeMillis());
                                obj9 = this.c;
                                ba.Q(obj9);
                                obj9.q(valueOf);
                                if (obj8 == i) {
                                } else {
                                }
                                b().x().b("Config not found. Using empty config. appId", string);
                                b().v().c("Successfully fetched config. Got network response. code, size", Integer.valueOf(obj8), valueOf2);
                                obj7 = this.b;
                                ba.Q(obj7);
                                if (obj7.m() && O()) {
                                } else {
                                }
                                if (O()) {
                                } else {
                                }
                                A();
                                L();
                                obj7 = this.c;
                                ba.Q(obj7);
                                obj7.p();
                                ba.Q(this.c);
                                i2 = this.c;
                                ba.Q(i2);
                                i2.i0();
                                throw string;
                                this.s = obj0;
                                I();
                                throw string;
                            } catch (Throwable th) {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void n(boolean z) {
        L();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void o(int i, Throwable throwable2, byte[] b3Arr3, String string4) {
        List delete;
        long currentTimeMillis;
        Integer valueOf;
        String str2;
        long str;
        int i2;
        String[] strArr;
        int obj9;
        int obj10;
        byte[] obj11;
        a().h();
        g();
        int obj12 = 0;
        if (b3Arr3 == null) {
            obj11 = new byte[obj12];
        }
        delete = this.x;
        r.j(delete);
        currentTimeMillis = 0;
        this.x = currentTimeMillis;
        final int i4 = 204;
        if (i != 200) {
            if (i == i4) {
                obj9 = i4;
                if (throwable2 == null) {
                    obj10.i.b(c().currentTimeMillis());
                    valueOf = 0;
                    obj10.j.b(valueOf);
                    L();
                    b().v().c("Successful upload. Got network response. code, size", Integer.valueOf(obj9), Integer.valueOf(obj11.length));
                    obj9 = this.c;
                    ba.Q(obj9);
                    obj9.g0();
                    obj9 = (List)delete.iterator();
                    for (Long obj10 : obj9) {
                        obj11 = this.c;
                        ba.Q(obj11);
                        obj11.h();
                        obj11.i();
                        i2 = 1;
                        strArr = new String[i2];
                        strArr[obj12] = String.valueOf(obj10.longValue());
                    }
                    obj9 = this.c;
                    ba.Q(obj9);
                    obj9.p();
                    obj9 = this.c;
                    ba.Q(obj9);
                    obj9.i0();
                    this.y = currentTimeMillis;
                    obj9 = this.b;
                    ba.Q(obj9);
                    if (obj9.m() && O()) {
                        if (O()) {
                            A();
                        } else {
                            this.z = -1;
                            L();
                        }
                    } else {
                    }
                    this.o = valueOf;
                } else {
                    valueOf = Integer.valueOf(obj9);
                    b().v().c("Network upload failed. Will retry later. code, error", valueOf, throwable2);
                    obj11 = c();
                    obj10.j.b(obj11.currentTimeMillis());
                    if (obj9 != 503) {
                        if (obj9 == 429) {
                            obj9.h.b(c().currentTimeMillis());
                        }
                    } else {
                    }
                    obj9 = this.c;
                    ba.Q(obj9);
                    obj9.j0(delete);
                    L();
                }
            } else {
            }
        } else {
        }
        this.t = obj12;
        I();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void p(com.google.android.gms.measurement.internal.na na) {
        String uVar;
        com.google.android.gms.measurement.internal.q qVar;
        com.google.android.gms.measurement.internal.o3 intent;
        com.google.android.gms.measurement.internal.o3 o3Var;
        android.content.pm.PackageInfo eaVar;
        boolean cmp2;
        Object uVar2;
        boolean bundle;
        int cmp;
        Object eaVar2;
        com.google.android.gms.measurement.internal.g5 bundle2;
        String uVar3;
        Object uVar4;
        int i;
        int equals;
        String str10;
        int str11;
        String str13;
        long l;
        String str6;
        com.google.android.gms.measurement.internal.b3 str4;
        String str3;
        String str17;
        Object g5Var;
        int cmp3;
        int bundle3;
        Object str2;
        int str18;
        com.google.android.gms.measurement.internal.ga equals2;
        String i4Var;
        String lastUpdateTime;
        Long valueOf2;
        boolean empty2;
        long currentTimeMillis;
        Object str5;
        Object valueOf3;
        Object packageManager;
        int firstInstallTime;
        Object str19;
        String packageName;
        long sVar;
        int sVar2;
        long str15;
        String str16;
        int i2;
        int i4;
        Object empty;
        Long num;
        Long valueOf;
        String str12;
        String str9;
        String str8;
        int i3;
        String str14;
        String str7;
        String str;
        final Object obj = this;
        final Object obj2 = na;
        eaVar2 = "_sysu";
        String str26 = "_sys";
        str4 = "com.android.vending";
        str3 = "_pfo";
        str17 = "_uwa";
        uVar = "app_id=?";
        a().h();
        g();
        r.j(na);
        r.f(obj2.a);
        com.google.android.gms.measurement.internal.k kVar8 = obj.c;
        ba.Q(kVar8);
        g5Var = kVar8.T(obj2.a);
        str18 = 0;
        if (M(na) && g5Var != null && TextUtils.isEmpty(g5Var.k0()) && !TextUtils.isEmpty(obj2.b)) {
            kVar8 = obj.c;
            ba.Q(kVar8);
            g5Var = kVar8.T(obj2.a);
            str18 = 0;
            if (g5Var != null) {
                if (TextUtils.isEmpty(g5Var.k0())) {
                    if (!TextUtils.isEmpty(obj2.b)) {
                        g5Var.m(str18);
                        com.google.android.gms.measurement.internal.k kVar11 = obj.c;
                        ba.Q(kVar11);
                        kVar11.q(g5Var);
                        g5Var = obj.a;
                        ba.Q(g5Var);
                        g5Var.s(obj2.a);
                    }
                }
            }
            if (!obj2.z) {
                R(na);
            }
            if (Long.compare(currentTimeMillis, str18) == 0) {
                currentTimeMillis = c().currentTimeMillis();
            }
            obj.l.A().r();
            bundle3 = obj2.F;
            sVar = 1;
            if (bundle3 != null && bundle3 != sVar) {
                if (bundle3 != sVar) {
                    b().w().c("Incorrect app type, assuming installed app. appId, appType", q3.z(obj2.a), Integer.valueOf(bundle3));
                    bundle3 = 0;
                }
            }
            com.google.android.gms.measurement.internal.k kVar9 = obj.c;
            ba.Q(kVar9);
            kVar9.g0();
            com.google.android.gms.measurement.internal.k kVar10 = obj.c;
            ba.Q(kVar10);
            equals2 = kVar10.Z(obj2.a, "_npa");
            if (equals2 != null) {
                if ("auto".equals(equals2.b)) {
                    valueOf2 = obj2.J;
                    if (valueOf2 != null) {
                        i3 = sVar != valueOf2.booleanValue() ? 0 : 1;
                        str14 = eaVar2;
                        str7 = str26;
                        int i7 = 1;
                        eaVar2 = eaVar6;
                        int i10 = 0;
                        str11 = sVar;
                        super("_npa", currentTimeMillis, obj16, Long.valueOf(i3), "auto");
                        if (equals2 != null) {
                            if (!equals2.e.equals(eaVar2.v)) {
                                obj.z(eaVar2, obj2);
                            }
                        } else {
                        }
                    } else {
                        str14 = eaVar2;
                        str7 = str26;
                        str11 = sVar;
                        if (equals2 != null) {
                            super("_npa", currentTimeMillis, obj16, 0, "auto");
                            obj.t(eaVar2, obj2);
                        }
                    }
                } else {
                    str14 = eaVar2;
                    str7 = str26;
                    str11 = sVar;
                }
            } else {
            }
            com.google.android.gms.measurement.internal.k kVar7 = obj.c;
            ba.Q(kVar7);
            i4Var = obj2.a;
            r.j(i4Var);
            bundle2 = kVar7.T((String)i4Var);
            b().w().b("New GMP App Id passed in. Removing cached database data. appId", q3.z(bundle2.e0()));
            i4Var = obj.c;
            ba.Q(i4Var);
            str10 = bundle2.e0();
            i4Var.i();
            i4Var.h();
            r.f(str10);
            valueOf2 = i4Var.R();
            valueOf3 = new String[str11];
            valueOf3[0] = str10;
            i25 += uVar;
            if (bundle2 != null && f0().b0(obj2.b, bundle2.k0(), obj2.I, bundle2.c0()) && str19 > 0) {
                if (f0().b0(obj2.b, bundle2.k0(), obj2.I, bundle2.c0())) {
                    b().w().b("New GMP App Id passed in. Removing cached database data. appId", q3.z(bundle2.e0()));
                    i4Var = obj.c;
                    ba.Q(i4Var);
                    str10 = bundle2.e0();
                    i4Var.i();
                    i4Var.h();
                    r.f(str10);
                    valueOf2 = i4Var.R();
                    valueOf3 = new String[str11];
                    valueOf3[0] = str10;
                    i25 += uVar;
                    if (str19 > 0) {
                        i4Var.a.b().v().c("Deleted application data. app, records", str10, Integer.valueOf(str19));
                    }
                    bundle2 = 0;
                }
            }
            if (bundle2 != null) {
                valueOf3 = Integer.MIN_VALUE;
                if (Long.compare(i4Var, valueOf3) != 0) {
                    str = str4;
                    sVar = Long.compare(i4Var, str11) != 0 ? 1 : 0;
                } else {
                    str = str4;
                }
                uVar = bundle2.h0();
                if (Long.compare(l2, valueOf3) == 0 && uVar != null && !uVar.equals(obj2.c)) {
                    if (uVar != null) {
                        i = !uVar.equals(obj2.c) ? 1 : 0;
                    } else {
                    }
                } else {
                }
                if (i |= sVar != 0) {
                    bundle2 = new Bundle();
                    bundle2.putString("_pv", uVar);
                    sVar = new s(bundle2);
                    super("_au", sVar, "auto", currentTimeMillis, str12);
                    obj.i(uVar, obj2);
                }
            } else {
                str = str4;
            }
            R(na);
            if (bundle3 == null) {
                com.google.android.gms.measurement.internal.k kVar5 = obj.c;
                ba.Q(kVar5);
                qVar = kVar5.X(obj2.a, "_f");
                sVar2 = 0;
            } else {
                com.google.android.gms.measurement.internal.k kVar4 = obj.c;
                ba.Q(kVar4);
                qVar = kVar4.X(obj2.a, "_v");
                sVar2 = 1;
            }
            if (qVar == null) {
                int i6 = 3600000;
                i13 *= i6;
                String str23 = "_dac";
                String str27 = "_r";
                str6 = "_c";
                valueOf2 = "_et";
                if (sVar2 == 0) {
                    super("_fot", currentTimeMillis, empty, Long.valueOf(bundle3), "auto");
                    obj.z(eaVar3, obj2);
                    a().h();
                    com.google.android.gms.measurement.internal.j4 j4Var = obj.k;
                    r.j(j4Var);
                    str2 = j4Var;
                    String str20 = obj2.a;
                    if (str20 != null) {
                        if (str20.isEmpty()) {
                            str2.a.b().y().a("Install Referrer Reporter was called with invalid app package name");
                        } else {
                            str2.a.a().h();
                            if (!(j4)str2.a()) {
                                str2.a.b().u().a("Install Referrer Reporter is not available");
                            } else {
                                i4Var = new i4(str2, str20);
                                str2.a.a().h();
                                intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                                str15 = str;
                                ComponentName componentName = new ComponentName(str15, "com.google.android.finsky.externalreferrer.GetInstallReferrerService");
                                intent.setComponent(componentName);
                                packageManager = str2.a.f().getPackageManager();
                                if (packageManager == null) {
                                    str2.a.b().y().a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                                } else {
                                    packageName = 0;
                                    packageManager = packageManager.queryIntentServices(intent, packageName);
                                    if (packageManager != null && !packageManager.isEmpty()) {
                                        if (!packageManager.isEmpty()) {
                                            packageManager = obj6.serviceInfo;
                                            if (packageManager != null) {
                                                if (packageManager.name != null && str15.equals(packageManager.packageName) && str2.a()) {
                                                    if (str15.equals(packageName)) {
                                                        if (str2.a()) {
                                                            Intent intent2 = new Intent(intent);
                                                            packageName = 1 != a.b().a(str2.a.f(), intent2, i4Var, 1) ? str15 : empty;
                                                            str2.a.b().v().b("Install Referrer Service is", packageName);
                                                        } else {
                                                            str2.a.b().w().a("Play Store version 8.3.73 or higher required for Install Referrer");
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            }
                                        } else {
                                            str2.a.b().u().a("Play Service for fetching Install Referrer is unavailable on device");
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    } else {
                    }
                    a().h();
                    g();
                    bundle3 = new Bundle();
                    firstInstallTime = 1;
                    bundle3.putLong(str6, firstInstallTime);
                    bundle3.putLong(str27, firstInstallTime);
                    int i8 = 0;
                    bundle3.putLong(str17, i8);
                    bundle3.putLong(str3, i8);
                    lastUpdateTime = str7;
                    bundle3.putLong(lastUpdateTime, i8);
                    str16 = str14;
                    bundle3.putLong(str16, i8);
                    int i9 = 1;
                    bundle3.putLong(valueOf2, i9);
                    if (obj2.H) {
                        bundle3.putLong(str23, i9);
                    }
                    String str21 = obj2.a;
                    r.j(str21);
                    uVar4 = str21;
                    com.google.android.gms.measurement.internal.k kVar = obj.c;
                    ba.Q(kVar);
                    r.f((String)uVar4);
                    kVar.h();
                    kVar.i();
                    if (obj.l.f().getPackageManager() == null) {
                        b().r().b("PackageManager is null, first open report might be inaccurate. appId", q3.z(uVar4));
                        str7 = valueOf2;
                    } else {
                        eaVar = c.a(obj.l.f()).e(uVar4, 0);
                        str14 = str16;
                        firstInstallTime = eaVar.firstInstallTime;
                        if (eaVar != null && Long.compare(firstInstallTime, str16) != 0) {
                            firstInstallTime = eaVar.firstInstallTime;
                            if (Long.compare(firstInstallTime, str16) != 0) {
                                str = lastUpdateTime;
                                str7 = valueOf2;
                                if (Long.compare(firstInstallTime, lastUpdateTime) != 0) {
                                    if (S().B(0, c3.h0)) {
                                        if (Long.compare(l, firstInstallTime) == 0) {
                                            bundle3.putLong(str17, 1);
                                            l = 0;
                                        }
                                    } else {
                                        bundle3.putLong(str17, 1);
                                    }
                                    i2 = 0;
                                } else {
                                    valueOf2 = 0;
                                    i2 = 1;
                                }
                                i4 = 1 != i2 ? 0 : 1;
                                str17 = str14;
                                super("_fi", currentTimeMillis, empty, Long.valueOf(i4), "auto");
                                obj.z(eaVar, obj2);
                            } else {
                                str = lastUpdateTime;
                                str7 = valueOf2;
                                str17 = str14;
                                valueOf2 = 0;
                            }
                        } else {
                        }
                        lastUpdateTime = c.a(obj.l.f()).c(uVar4, 0);
                        if (lastUpdateTime != null && flags &= uVar4 != 0) {
                            if (flags &= uVar4 != 0) {
                                bundle3.putLong(str, 1);
                            }
                            if (flags2 &= 128 != null) {
                                bundle3.putLong(str17, 1);
                            }
                        }
                    }
                    if (Long.compare(l, i4Var) >= 0) {
                        bundle3.putLong(str3, l);
                    }
                    sVar2 = new s(bundle3);
                    super("_f", sVar2, "auto", currentTimeMillis, str12);
                    obj.k(uVar2, obj2);
                    str13 = str7;
                } else {
                    str12 = "auto";
                    super("_fvt", currentTimeMillis, empty, Long.valueOf(bundle3), str12);
                    obj.z(eaVar4, obj2);
                    a().h();
                    g();
                    uVar2 = new Bundle();
                    str3 = 1;
                    uVar2.putLong(str6, str3);
                    uVar2.putLong(str27, str3);
                    uVar2.putLong(valueOf2, str3);
                    if (obj2.H) {
                        uVar2.putLong(str23, str3);
                    }
                    sVar2 = new s(uVar2);
                    super("_v", sVar2, "auto", currentTimeMillis, str12);
                    obj.k(uVar4, obj2);
                }
                if (!S().B(obj2.a, c3.U)) {
                    bundle = new Bundle();
                    str4 = 1;
                    bundle.putLong(str13, str4);
                    bundle.putLong("_fr", str4);
                    sVar2 = new s(bundle);
                    super("_e", sVar2, "auto", currentTimeMillis, str12);
                    obj.k(uVar3, obj2);
                }
            } else {
                if (obj2.A) {
                    bundle = new Bundle();
                    sVar2 = new s(bundle);
                    super("_cd", sVar2, "auto", currentTimeMillis, str12);
                    obj.k(uVar3, obj2);
                }
            }
            com.google.android.gms.measurement.internal.k kVar2 = obj.c;
            ba.Q(kVar2);
            kVar2.p();
            com.google.android.gms.measurement.internal.k kVar3 = obj.c;
            ba.Q(kVar3);
            kVar3.i0();
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void q() {
        this.q = i++;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void r(com.google.android.gms.measurement.internal.c c) {
        String str = c.a;
        r.j(str);
        com.google.android.gms.measurement.internal.na naVar = G((String)str);
        if (naVar != null) {
            s(c, naVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void s(com.google.android.gms.measurement.internal.c c, com.google.android.gms.measurement.internal.na na2) {
        Object str2;
        Object obj;
        boolean z;
        int i2;
        Object str;
        String str3;
        String str5;
        String str4;
        String str6;
        int i3;
        int i;
        Object obj11;
        Object obj12;
        r.j(c);
        r.f(c.a);
        r.j(c.c);
        r.f(eaVar2.b);
        a().h();
        g();
        if (!M(na2)) {
        }
        if (na2.z) {
            com.google.android.gms.measurement.internal.k kVar = this.c;
            ba.Q(kVar);
            kVar.g0();
            R(na2);
            String str9 = c.a;
            r.j(str9);
            str = str9;
            com.google.android.gms.measurement.internal.k kVar2 = this.c;
            ba.Q(kVar2);
            str2 = kVar2.U((String)str, eaVar3.b);
            if (str2 != null) {
                b().q().c("Removing conditional user property", c.a, this.l.D().f(eaVar6.b));
                com.google.android.gms.measurement.internal.k kVar3 = this.c;
                ba.Q(kVar3);
                kVar3.K(str, eaVar4.b);
                if (str2.w) {
                    z = this.c;
                    ba.Q(z);
                    z.n(str, eaVar5.b);
                }
                obj = c.C;
                if (obj != null) {
                    com.google.android.gms.measurement.internal.s sVar = obj.b;
                    if (sVar != null) {
                        i2 = sVar.k2();
                    } else {
                        i2 = 0;
                    }
                    com.google.android.gms.measurement.internal.u uVar = c.C;
                    r.j(uVar);
                    obj11 = f0().w0(str, uVar.a, i2, str2.b, obj11.v, obj7, true);
                    r.j(obj11);
                    B((u)obj11, na2);
                }
            } else {
                b().w().c("Conditional user property doesn't exist", q3.z(c.a), this.l.D().f(obj11.b));
            }
            obj11 = this.c;
            ba.Q(obj11);
            obj11.p();
            obj11 = this.c;
            ba.Q(obj11);
            obj11.i0();
        }
        R(na2);
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void t(com.google.android.gms.measurement.internal.ea ea, com.google.android.gms.measurement.internal.na na2) {
        boolean equals;
        boolean equals2;
        int i;
        Object b3Var;
        int str;
        a().h();
        g();
        if (!M(na2)) {
        }
        if (!na2.z) {
            R(na2);
        }
        if ("_npa".equals(ea.b) && na2.J != null) {
            if (na2.J != null) {
                b().q().a("Falling back to manifest metadata value for ad personalization");
                boolean booleanValue = na2.J.booleanValue();
                i = 1 != booleanValue ? 0 : 1;
                super("_npa", c().currentTimeMillis(), obj4, Long.valueOf(i), "auto");
                z(obj8, na2);
            }
        }
        b().q().b("Removing user property", this.l.D().f(ea.b));
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        kVar.g0();
        R(na2);
        pb.b();
        str = 0;
        if (this.l.z().B(str, c3.t0) && this.l.z().B(str, c3.v0) && "_id".equals(ea.b)) {
            if (this.l.z().B(str, c3.v0)) {
                if ("_id".equals(ea.b)) {
                    equals2 = this.c;
                    ba.Q(equals2);
                    b3Var = na2.a;
                    r.j(b3Var);
                    equals2.n((String)b3Var, "_lair");
                }
            }
        }
        com.google.android.gms.measurement.internal.k kVar2 = this.c;
        ba.Q(kVar2);
        String obj9 = na2.a;
        r.j(obj9);
        kVar2.n((String)obj9, ea.b);
        obj9 = this.c;
        ba.Q(obj9);
        obj9.p();
        b().q().b("User property removed", this.l.D().f(ea.b));
        com.google.android.gms.measurement.internal.k obj8 = this.c;
        ba.Q(obj8);
        obj8.i0();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void u(com.google.android.gms.measurement.internal.na na) {
        int delete;
        Object arrayList;
        com.google.android.gms.measurement.internal.k kVar;
        Object str3;
        String str2;
        Object str;
        String[] valueOf;
        String str4 = "app_id=?";
        if (this.x != null) {
            arrayList = new ArrayList();
            this.y = arrayList;
            arrayList.addAll(this.x);
        }
        kVar = this.c;
        ba.Q(kVar);
        str2 = na.a;
        r.j(str2);
        r.f((String)str2);
        kVar.h();
        kVar.i();
        str = kVar.R();
        valueOf = new String[1];
        i10 += delete;
        if (i11 > 0) {
            kVar.a.b().v().c("Reset analytics data. app, records", str2, Integer.valueOf(i11));
        }
        if (na.z) {
            p(na);
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    protected final void v() {
        int cmp;
        long currentTimeMillis;
        a().h();
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        kVar.m();
        final int i = 0;
        if (Long.compare(l, i) == 0) {
            x8Var2.i.b(c().currentTimeMillis());
        }
        L();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void w(com.google.android.gms.measurement.internal.c c) {
        String str = c.a;
        r.j(str);
        com.google.android.gms.measurement.internal.na naVar = G((String)str);
        if (naVar != null) {
            x(c, naVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void x(com.google.android.gms.measurement.internal.c c, com.google.android.gms.measurement.internal.na na2) {
        Object obj4;
        boolean empty;
        com.google.android.gms.measurement.internal.o3 uVar;
        Object obj;
        String equals;
        int eaVar;
        String str5;
        String str6;
        String str4;
        String str3;
        String str;
        String str2;
        Object obj2;
        Object obj3;
        String gaVar;
        int obj11;
        String obj12;
        r.j(c);
        r.f(c.a);
        r.j(c.b);
        r.j(c.c);
        r.f(eaVar3.b);
        a().h();
        g();
        if (!M(na2)) {
        }
        if (!na2.z) {
            R(na2);
        }
        c cVar = new c(c);
        cVar.w = false;
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        kVar.g0();
        com.google.android.gms.measurement.internal.k kVar2 = this.c;
        ba.Q(kVar2);
        equals = cVar.a;
        r.j(equals);
        com.google.android.gms.measurement.internal.c cVar2 = kVar2.U((String)equals, eaVar8.b);
        if (cVar2 != null && !cVar2.b.equals(cVar.b)) {
            if (!cVar2.b.equals(cVar.b)) {
                b().w().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.l.D().f(eaVar12.b), cVar.b, cVar2.b);
            }
        }
        eaVar = 1;
        if (cVar2 != null && cVar2.w) {
            if (cVar2.w) {
                cVar.b = cVar2.b;
                cVar.v = cVar2.v;
                cVar.z = cVar2.z;
                cVar.x = cVar2.x;
                cVar.A = cVar2.A;
                cVar.w = eaVar;
                str6 = cVar.c;
                super(str6.b, eaVar11.c, obj7, str6.j2(), empty.x);
                cVar.c = eaVar;
            } else {
                if (TextUtils.isEmpty(cVar.x)) {
                    com.google.android.gms.measurement.internal.ea eaVar7 = cVar.c;
                    super(eaVar7.b, cVar.v, str2, eaVar7.j2(), empty.x);
                    cVar.c = obj11;
                    cVar.w = eaVar;
                    obj11 = eaVar;
                }
            }
        } else {
        }
        if (cVar.w) {
            com.google.android.gms.measurement.internal.ea eaVar6 = cVar.c;
            String str12 = cVar.a;
            r.j(str12);
            obj3 = eaVar6.j2();
            r.j(obj3);
            ea gaVar2 = new ea((String)str12, cVar.b, eaVar6.b, eaVar6.c, obj2, obj3);
            com.google.android.gms.measurement.internal.k kVar3 = this.c;
            ba.Q(kVar3);
            if (kVar3.z(gaVar)) {
                b().q().d("User property updated immediately", cVar.a, this.l.D().f(gaVar.c), gaVar.e);
            } else {
                b().r().d("(2)Too many active user properties, ignoring", q3.z(cVar.a), this.l.D().f(gaVar.c), gaVar.e);
            }
            obj11 = cVar.A;
            if (obj11 != null && obj11 != null) {
                obj11 = cVar.A;
                if (obj11 != null) {
                    uVar = new u(obj11, cVar.v, str6);
                    B(uVar, na2);
                }
            }
        }
        obj11 = this.c;
        ba.Q(obj11);
        if (obj11.y(cVar)) {
            b().q().d("Conditional property added", cVar.a, this.l.D().f(eaVar9.b), cVar.c.j2());
        } else {
            b().r().d("Too many conditional properties, ignoring", q3.z(cVar.a), this.l.D().f(eaVar10.b), cVar.c.j2());
        }
        obj11 = this.c;
        ba.Q(obj11);
        obj11.p();
        obj11 = this.c;
        ba.Q(obj11);
        obj11.i0();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void y(String string, com.google.android.gms.measurement.internal.h h2) {
        long withOnConflict;
        Object str;
        int obj7;
        a().h();
        g();
        this.A.put(string, h2);
        com.google.android.gms.measurement.internal.k kVar = this.c;
        ba.Q(kVar);
        r.j(string);
        r.j(h2);
        kVar.h();
        kVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", string);
        contentValues.put("consent_state", h2.i());
        if (Long.compare(withOnConflict, i2) == 0) {
            kVar.a.b().r().b("Failed to insert/update consent setting (got -1). appId", q3.z(string));
        }
    }

    @Override // com.google.android.gms.measurement.internal.x5
    final void z(com.google.android.gms.measurement.internal.ea ea, com.google.android.gms.measurement.internal.na na2) {
        Object b3Var;
        Object str6;
        boolean i;
        int longValue;
        boolean equals;
        Object gaVar;
        Object gaVar2;
        Object str11;
        int str7;
        int length;
        Object str2;
        Object str10;
        Object str8;
        String str9;
        Object str3;
        String str4;
        boolean valueOf;
        String str;
        String str5;
        long l;
        String eaVar;
        int i3;
        int i2;
        Object obj;
        boolean obj14;
        a().h();
        g();
        if (!M(na2)) {
        }
        if (!na2.z) {
            R(na2);
        }
        int i5 = f0().n0(ea.b);
        i = 1;
        int i4 = 24;
        if (i5 != 0) {
            S();
            obj14 = ea.b;
            if (obj14 != null) {
                i3 = obj14;
            } else {
                i3 = length;
            }
            f0().A(this.B, na2.a, i5, "_ev", f0().q(ea.b, i4, i), i3);
        }
        Object obj4 = ea.j2();
        i2 = f0().j0(ea.b, obj4);
        S();
        obj14 = ea.j2();
        if (i2 != 0 && obj14 != null) {
            S();
            obj14 = ea.j2();
            if (obj14 != null) {
                if (obj14 instanceof String == null) {
                    if (obj14 instanceof CharSequence) {
                        length = obj14.toString().length();
                    }
                } else {
                }
            }
            f0().A(this.B, na2.a, i2, "_ev", f0().q(ea.b, i4, i), length);
        }
        Object obj2 = f0().p(ea.b, ea.j2());
        if (obj2 == null) {
        }
        if ("_sid".equals(ea.b)) {
            String str15 = na2.a;
            r.j(str15);
            com.google.android.gms.measurement.internal.k kVar = this.c;
            ba.Q(kVar);
            gaVar2 = kVar.Z((String)str15, "_sno");
            str2 = gaVar2.e;
            if (gaVar2 != null && str2 instanceof Long) {
                str2 = gaVar2.e;
                if (str2 instanceof Long) {
                    longValue = (Long)str2.longValue();
                } else {
                    if (gaVar2 != null) {
                        b().w().b("Retrieved last session number from database does not contain a valid (long) value", gaVar2.e);
                    }
                    gaVar2 = this.c;
                    ba.Q(gaVar2);
                    com.google.android.gms.measurement.internal.q qVar = gaVar2.X(str15, "_s");
                    if (qVar != null) {
                        b().v().b("Backfill the session number. Last used session number", Long.valueOf(qVar.c));
                    } else {
                        longValue = 0;
                    }
                }
            } else {
            }
            super("_sno", ea.c, obj4, Long.valueOf(longValue += i2), ea.x);
            z(eaVar, na2);
        }
        String str16 = na2.a;
        r.j(str16);
        String str17 = ea.x;
        r.j(str17);
        super((String)str16, (String)str17, ea.b, ea.c, eaVar, obj2);
        b().v().c("Setting user property", this.l.D().f(gaVar.c), obj2);
        obj14 = this.c;
        ba.Q(obj14);
        obj14.g0();
        pb.b();
        if (this.l.z().B(0, c3.t0) && "_id".equals(gaVar.c)) {
            if ("_id".equals(gaVar.c)) {
                obj14 = this.c;
                ba.Q(obj14);
                obj14.n(na2.a, "_lair");
            }
        }
        R(na2);
        obj14 = this.c;
        ba.Q(obj14);
        str6 = this.c;
        ba.Q(str6);
        str6.p();
        if (!obj14.z(gaVar)) {
            b().r().c("Too many unique user properties are set. Ignoring user property", this.l.D().f(gaVar.c), gaVar.e);
            f0().A(this.B, na2.a, 9, 0, 0, 0);
        }
        obj14 = this.c;
        ba.Q(obj14);
        obj14.i0();
    }
}
