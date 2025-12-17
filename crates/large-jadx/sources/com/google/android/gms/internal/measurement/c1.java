package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class c1 {

    final com.google.android.gms.internal.measurement.a4 a;
    com.google.android.gms.internal.measurement.b5 b;
    final com.google.android.gms.internal.measurement.c c;
    private final com.google.android.gms.internal.measurement.kf d;
    public c1() {
        a4 a4Var = new a4();
        super();
        this.a = a4Var;
        this.b = a4Var.b.a();
        c cVar = new c();
        this.c = cVar;
        kf kfVar = new kf();
        this.d = kfVar;
        a aVar = new a(this);
        a4Var.d.a("internal.registerCallback", aVar);
        b0 b0Var = new b0(this);
        a4Var.d.a("internal.eventLogger", b0Var);
    }

    public final com.google.android.gms.internal.measurement.c a() {
        return this.c;
    }

    final com.google.android.gms.internal.measurement.j b() {
        gf gfVar = new gf(this.d);
        return gfVar;
    }

    public final void c(com.google.android.gms.internal.measurement.q5 q5) {
        boolean z;
        String string;
        String string2;
        com.google.android.gms.internal.measurement.a4 iterator;
        com.google.android.gms.internal.measurement.b5 singletonList;
        com.google.android.gms.internal.measurement.u5[] arr;
        com.google.android.gms.internal.measurement.b5 b5Var;
        boolean z2;
        com.google.android.gms.internal.measurement.u5[] arr2;
        try {
            this.b = a4Var.b.a();
            final int i = 0;
            if (qVar instanceof h) {
            } else {
            }
            Iterator obj8 = q5.w().z().iterator();
            for (o5 next2 : obj8) {
                z = next2.x();
                iterator = next2.y().iterator();
                for (u5 next3 : iterator) {
                    arr2 = new u5[1];
                    arr2[i] = next3;
                    com.google.android.gms.internal.measurement.q qVar2 = this.a.a(this.b, arr2);
                    com.google.android.gms.internal.measurement.b5 b5Var4 = this.b;
                    arr.a(this.b, Collections.singletonList(qVar2));
                    arr = 0;
                }
                arr2 = new u5[1];
                arr2[i] = (u5)iterator.next();
                qVar2 = this.a.a(this.b, arr2);
                b5Var4 = this.b;
                arr.a(this.b, Collections.singletonList(qVar2));
                arr = 0;
            }
            Object next2 = obj8.next();
            z = next2.x();
            iterator = (o5)next2.y().iterator();
            for (u5 next3 : iterator) {
                arr2 = new u5[1];
                arr2[i] = next3;
                qVar2 = this.a.a(this.b, arr2);
                b5Var4 = this.b;
                arr.a(this.b, Collections.singletonList(qVar2));
                arr = 0;
            }
            arr2 = new u5[1];
            arr2[i] = (u5)iterator.next();
            qVar2 = this.a.a(this.b, arr2);
            if (!qVar2 instanceof n) {
            } else {
            }
            b5Var4 = this.b;
            if (!b5Var4.h(z)) {
            } else {
            }
            arr = 0;
            if (!arr instanceof j) {
            } else {
            }
            String str4 = "Invalid function name: ";
            String valueOf2 = String.valueOf(z);
            if (valueOf2.length() != 0) {
            } else {
            }
            string2 = str4.concat(valueOf2);
            string2 = new String(str4);
            obj8 = new IllegalStateException(string2);
            throw obj8;
            if (arr == null) {
            } else {
            }
            String str3 = "Rule function is undefined: ";
            String valueOf = String.valueOf(z);
            if (valueOf.length() != 0) {
            } else {
            }
            string = str3.concat(valueOf);
            string = new String(str3);
            obj8 = new IllegalStateException(string);
            throw obj8;
            arr.a(this.b, Collections.singletonList(qVar2));
            obj8 = new IllegalArgumentException("Invalid rule definition");
            throw obj8;
            obj8 = new IllegalStateException("Program loading failed");
            throw obj8;
            zzd zzd = new zzd(q5);
            throw zzd;
        }
    }

    public final void d(String string, Callable<? extends com.google.android.gms.internal.measurement.j> callable2) {
        a4Var.d.a(string, callable2);
    }

    public final boolean e(com.google.android.gms.internal.measurement.b b) {
        boolean obj4;
        try {
            this.c.d(b);
            i iVar = new i(Double.valueOf(0));
            obj4.c.g("runtime.counter", iVar);
            this.d.b(this.b.a(), this.c);
            if (!g() && f()) {
            }
            if (f()) {
            }
            return 0;
            return 1;
            zzd zzd = new zzd(b);
            throw zzd;
        }
    }

    public final boolean f() {
        if (!this.c.c().isEmpty()) {
            return 1;
        }
        return 0;
    }

    public final boolean g() {
        if (!this.c.b().equals(this.c.a())) {
            return 1;
        }
        return 0;
    }
}
