package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.r;
import d.e.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class d2 extends com.google.android.gms.measurement.internal.e3 {

    private final Map<String, Long> b;
    private final Map<String, Integer> c;
    private long d;
    public d2(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        a obj1 = new a();
        this.c = obj1;
        obj1 = new a();
        this.b = obj1;
    }

    static void i(com.google.android.gms.measurement.internal.d2 d2, String string2, long l3) {
        d2.h();
        r.f(string2);
        if (d2.c.isEmpty()) {
            d2.d = l3;
        }
        Object obj = d2.c.get(string2);
        int i = 1;
        if ((Integer)obj != null) {
            d2.c.put(string2, Integer.valueOf(obj5 += i));
        }
        if (d2.c.size() >= 100) {
            d2.a.b().w().a("Too many ads visible");
        }
        d2.c.put(string2, Integer.valueOf(i));
        d2.b.put(string2, Long.valueOf(l3));
    }

    static void j(com.google.android.gms.measurement.internal.d2 d2, String string2, long l3) {
        Object str;
        int i;
        int i2;
        Object obj7;
        int obj8;
        d2.h();
        r.f(string2);
        Object obj = d2.c.get(string2);
        com.google.android.gms.measurement.internal.p7 p7Var = d2.a.K().t(false);
        intValue--;
        if (obj != null && i3 == 0) {
            p7Var = d2.a.K().t(false);
            intValue--;
            if (i3 == 0) {
                d2.c.remove(string2);
                Object obj2 = d2.b.get(string2);
                if ((Long)obj2 == null) {
                    d2.a.b().r().a("First ad unit exposure time was never set");
                } else {
                    d2.b.remove(string2);
                    d2.p(string2, l3 - longValue, obj3);
                }
                i = d2.d;
                i2 = 0;
                if (d2.c.isEmpty() && Long.compare(i, i2) == 0) {
                    i = d2.d;
                    i2 = 0;
                    if (Long.compare(i, i2) == 0) {
                        d2.a.b().r().a("First ad exposure time was never set");
                    }
                    d2.o(l3 -= i, obj9);
                    d2.d = i2;
                }
            }
            d2.c.put(string2, Integer.valueOf(i3));
        }
        d2.a.b().r().b("Call to endAdUnitExposure for unknown ad unit id", string2);
    }

    static void k(com.google.android.gms.measurement.internal.d2 d2, long l2) {
        d2.q(l2);
    }

    private final void o(long l, com.google.android.gms.measurement.internal.p7 p72) {
        if (obj5 == null) {
            this.a.b().v().a("Not logging ad exposure. No active activity");
        }
        if (Long.compare(l, i) < 0) {
            this.a.b().v().b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(l));
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", l);
        ia.x(obj5, bundle, true);
        this.a.I().u("am", "_xa", bundle);
    }

    private final void p(String string, long l2, com.google.android.gms.measurement.internal.p7 p73) {
        if (obj6 == null) {
            this.a.b().v().a("Not logging ad unit exposure. No active activity");
        }
        if (Long.compare(l2, i) < 0) {
            this.a.b().v().b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(l2));
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", string);
        bundle.putLong("_xt", l2);
        ia.x(obj6, bundle, true);
        this.a.I().u("am", "_xu", bundle);
    }

    private final void q(long l) {
        Object next;
        Map map;
        Long valueOf;
        Iterator iterator = this.b.keySet().iterator();
        for (String next : iterator) {
            this.b.put(next, Long.valueOf(l));
        }
        if (!this.b.isEmpty()) {
            this.d = l;
        }
    }

    @Override // com.google.android.gms.measurement.internal.e3
    public final void l(String string, long l2) {
        int length;
        if (string != null && string.length() == 0) {
            if (string.length() == 0) {
            }
            a aVar = new a(this, string, l2, obj5);
            this.a.a().z(aVar);
        }
        this.a.b().r().a("Ad unit id must be a non-empty string");
    }

    @Override // com.google.android.gms.measurement.internal.e3
    public final void m(String string, long l2) {
        int length;
        if (string != null && string.length() == 0) {
            if (string.length() == 0) {
            }
            b0 b0Var = new b0(this, string, l2, obj5);
            this.a.a().z(b0Var);
        }
        this.a.b().r().a("Ad unit id must be a non-empty string");
    }

    @Override // com.google.android.gms.measurement.internal.e3
    public final void n(long l) {
        boolean empty;
        Object next;
        int i;
        com.google.android.gms.measurement.internal.p7 p7Var = this.a.K().t(false);
        Iterator iterator = this.b.keySet().iterator();
        boolean next2 = iterator.hasNext();
        for (String next : iterator) {
            p(next, l - longValue, obj4);
            next2 = iterator.hasNext();
        }
        if (!this.b.isEmpty()) {
            o(l - l2, next2);
        }
        q(l);
    }
}
