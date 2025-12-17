package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class k2 {

    private final com.google.android.gms.internal.firebase-auth-api.na a;
    private k2(com.google.android.gms.internal.firebase-auth-api.na na) {
        super();
        this.a = na;
    }

    static final com.google.android.gms.internal.firebase-auth-api.k2 a(com.google.android.gms.internal.firebase-auth-api.na na) {
        k2.f(na);
        k2 k2Var = new k2(na);
        return k2Var;
    }

    public static void f(com.google.android.gms.internal.firebase-auth-api.na na) {
        int obj1;
        if (na == 0) {
        } else {
            if (na.z() <= 0) {
            } else {
            }
        }
        obj1 = new GeneralSecurityException("empty keyset");
        throw obj1;
    }

    public static final com.google.android.gms.internal.firebase-auth-api.k2 i(com.google.android.gms.internal.firebase-auth-api.p5 p5, com.google.android.gms.internal.firebase-auth-api.u1 u12) {
        int i;
        com.google.android.gms.internal.firebase-auth-api.j9 obj2 = p5.a();
        if (obj2 == null) {
        } else {
            if (obj2.C().g() == 0) {
            } else {
                obj2 = na.E(u12.a(obj2.C().B(), new byte[0]), lr.a());
                k2.f(obj2);
                k2 k2Var = new k2(obj2);
                return k2Var;
            }
        }
        obj2 = new GeneralSecurityException("empty keyset");
        throw obj2;
    }

    public final com.google.android.gms.internal.firebase-auth-api.k2 b() {
        com.google.android.gms.internal.firebase-auth-api.xr xrVar;
        com.google.android.gms.internal.firebase-auth-api.aa aaVar;
        com.google.android.gms.internal.firebase-auth-api.la laVar;
        com.google.android.gms.internal.firebase-auth-api.z9 zzc;
        if (this.a == null) {
        } else {
            com.google.android.gms.internal.firebase-auth-api.ka kaVar = na.B();
            Iterator iterator = this.a.F().iterator();
            for (ma next2 : iterator) {
                com.google.android.gms.internal.firebase-auth-api.aa aaVar2 = next2.A();
                aaVar = c3.b(aaVar2.E(), aaVar2.D());
                c3.f(aaVar);
                laVar = ma.C();
                laVar.d(next2);
                laVar.j(aaVar);
                kaVar.m((ma)laVar.e());
            }
            kaVar.s(this.a.A());
            k2 k2Var = new k2((na)kaVar.e());
            return k2Var;
        }
        GeneralSecurityException generalSecurityException = new GeneralSecurityException("cleartext keyset is not available");
        throw generalSecurityException;
    }

    final com.google.android.gms.internal.firebase-auth-api.na c() {
        return this.a;
    }

    public final com.google.android.gms.internal.firebase-auth-api.sa d() {
        return d3.a(this.a);
    }

    public final <P> P e(Class<P> class) {
        Object next;
        Object obj;
        com.google.android.gms.internal.firebase-auth-api.ca zzb;
        String obj7;
        Class cls = c3.e(class);
        if (cls == null) {
            obj7 = String.valueOf(class.getName());
            String str = "No wrapper found for ";
            if (obj7.length() != 0) {
                obj7 = str.concat(obj7);
            } else {
                obj7 = new String(str);
            }
            GeneralSecurityException generalSecurityException = new GeneralSecurityException(obj7);
            throw generalSecurityException;
        }
        d3.b(this.a);
        com.google.android.gms.internal.firebase-auth-api.u2 u2Var = u2.b(cls);
        Iterator iterator = this.a.F().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((ma)next.B() == ca.zzb && next.z() == this.a.A()) {
            }
            if (next.z() == this.a.A()) {
            }
            u2Var.e(u2Var.a(c3.g(next.A(), cls), next));
        }
        return c3.j(u2Var, class);
    }

    public final void g(com.google.android.gms.internal.firebase-auth-api.m2 m2, com.google.android.gms.internal.firebase-auth-api.u1 u12) {
        com.google.android.gms.internal.firebase-auth-api.na naVar = this.a;
        int i = 0;
        byte[] bArr2 = u12.b(naVar.k(), new byte[i]);
        if (!na.E(u12.a(bArr2, new byte[i]), lr.a()).equals(naVar)) {
        } else {
            com.google.android.gms.internal.firebase-auth-api.i9 obj6 = j9.z();
            obj6.j(wq.v(bArr2));
            obj6.m(d3.a(naVar));
            m2.b((j9)obj6.e());
        }
        GeneralSecurityException obj5 = new GeneralSecurityException("cannot encrypt keyset");
        throw obj5;
    }

    public final void h(com.google.android.gms.internal.firebase-auth-api.m2 m2) {
        Object next;
        com.google.android.gms.internal.firebase-auth-api.z9 z9Var;
        com.google.android.gms.internal.firebase-auth-api.z9 zza;
        Iterator iterator = this.a.F().iterator();
        for (ma next : iterator) {
        }
        m2.a(this.a);
    }

    public final String toString() {
        return d3.a(this.a).toString();
    }
}
