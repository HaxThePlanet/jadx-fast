package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b5 {

    public final com.google.android.gms.internal.measurement.b5 a;
    final com.google.android.gms.internal.measurement.y b;
    final Map<String, com.google.android.gms.internal.measurement.q> c;
    final Map<String, Boolean> d;
    public b5(com.google.android.gms.internal.measurement.b5 b5, com.google.android.gms.internal.measurement.y y2) {
        super();
        HashMap hashMap = new HashMap();
        this.c = hashMap;
        HashMap hashMap2 = new HashMap();
        this.d = hashMap2;
        this.a = b5;
        this.b = y2;
    }

    public final com.google.android.gms.internal.measurement.b5 a() {
        b5 b5Var = new b5(this, this.b);
        return b5Var;
    }

    public final com.google.android.gms.internal.measurement.q b(com.google.android.gms.internal.measurement.q q) {
        return this.b.a(this, q);
    }

    public final com.google.android.gms.internal.measurement.q c(com.google.android.gms.internal.measurement.f f) {
        com.google.android.gms.internal.measurement.q qVar;
        boolean next;
        qVar = q.h;
        final Iterator it = f.u();
        while (it.hasNext()) {
            if (!qVar instanceof h) {
            }
        }
        return qVar;
    }

    public final com.google.android.gms.internal.measurement.q d(String string) {
        if (this.c.containsKey(string)) {
            return (q)this.c.get(string);
        }
        com.google.android.gms.internal.measurement.b5 b5Var = this.a;
        if (b5Var == null) {
        } else {
            return b5Var.d(string);
        }
        Object[] arr = new Object[1];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("%s is not defined", string));
        throw illegalArgumentException;
    }

    public final void e(String string, com.google.android.gms.internal.measurement.q q2) {
        if (this.d.containsKey(string)) {
        }
        if (q2 == null) {
            this.c.remove(string);
        }
        this.c.put(string, q2);
    }

    public final void f(String string, com.google.android.gms.internal.measurement.q q2) {
        e(string, q2);
        this.d.put(string, Boolean.TRUE);
    }

    public final void g(String string, com.google.android.gms.internal.measurement.q q2) {
        boolean key;
        key = this.a;
        if (!this.c.containsKey(string) && key != null && !key.h(string)) {
            key = this.a;
            if (key != null) {
                if (!key.h(string)) {
                }
                this.a.g(string, q2);
            }
        }
        if (this.d.containsKey(string)) {
        }
        if (q2 == null) {
            this.c.remove(string);
        }
        this.c.put(string, q2);
    }

    public final boolean h(String string) {
        if (this.c.containsKey(string)) {
            return 1;
        }
        com.google.android.gms.internal.measurement.b5 b5Var = this.a;
        if (b5Var != null) {
            return b5Var.h(string);
        }
        return 0;
    }
}
