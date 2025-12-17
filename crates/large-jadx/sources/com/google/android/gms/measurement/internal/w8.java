package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.n.a;
import com.google.android.gms.internal.measurement.i1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class w8 extends com.google.android.gms.measurement.internal.f4 {

    private final com.google.android.gms.measurement.internal.v8 c;
    private com.google.android.gms.measurement.internal.g3 d;
    private volatile Boolean e;
    private final com.google.android.gms.measurement.internal.n f;
    private final com.google.android.gms.measurement.internal.n9 g;
    private final List<Runnable> h;
    private final com.google.android.gms.measurement.internal.n i;
    protected w8(com.google.android.gms.measurement.internal.b5 b5) {
        super(b5);
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        n9 n9Var = new n9(b5.c());
        this.g = n9Var;
        v8 v8Var = new v8(this);
        this.c = v8Var;
        f8 f8Var = new f8(this, b5);
        this.f = f8Var;
        i8 i8Var = new i8(this, b5);
        this.i = i8Var;
    }

    private final com.google.android.gms.measurement.internal.na C(boolean z) {
        int string;
        com.google.android.gms.measurement.internal.d4 d4Var;
        int length;
        StringBuilder stringBuilder;
        Object obj6;
        this.a.d();
        string = 0;
        if (z != null) {
            obj6 = this.a.b();
            if (g4Var.d == null) {
            } else {
                obj6 = obj6.d.a();
                if (obj6 != null) {
                    if (obj6 == g4.x) {
                    } else {
                        String valueOf = String.valueOf(obj6.second);
                        obj6 = obj6.first;
                        stringBuilder = new StringBuilder(i += length);
                        stringBuilder.append(valueOf);
                        stringBuilder.append(":");
                        stringBuilder.append(obj6);
                        string = stringBuilder.toString();
                    }
                }
            }
        }
        return this.a.B().q(string);
    }

    private final void D() {
        Integer valueOf;
        String str2;
        String str;
        h();
        this.a.b().v().b("Processing queued up service tasks", Integer.valueOf(this.h.size()));
        Iterator iterator = this.h.iterator();
        for (Runnable valueOf : iterator) {
            valueOf.run();
        }
        this.h.clear();
        this.i.b();
    }

    private final void E() {
        h();
        this.g.b();
        this.a.z();
        final int i = 0;
        this.f.d((Long)c3.J.a(i).longValue());
    }

    private final void F(Runnable runnable) {
        h();
        if (z()) {
            runnable.run();
        }
        final com.google.android.gms.measurement.internal.b5 b5Var = this.a;
        b5Var.z();
        if (Long.compare(l, i2) >= 0) {
            this.a.b().r().a("Discarding data. Max runnable queue size reached");
        }
        this.h.add(runnable);
        this.i.d(60000);
        P();
    }

    private final boolean G() {
        this.a.d();
        return 1;
    }

    static com.google.android.gms.measurement.internal.g3 H(com.google.android.gms.measurement.internal.w8 w8) {
        return w8.d;
    }

    static com.google.android.gms.measurement.internal.v8 I(com.google.android.gms.measurement.internal.w8 w8) {
        return w8.c;
    }

    static void K(com.google.android.gms.measurement.internal.w8 w8, com.google.android.gms.measurement.internal.g3 g32) {
        w8.d = 0;
    }

    static void L(com.google.android.gms.measurement.internal.w8 w8) {
        w8.D();
    }

    static void M(com.google.android.gms.measurement.internal.w8 w8, ComponentName componentName2) {
        Object g3Var;
        String str;
        w8.h();
        if (w8.d != null) {
            w8.d = 0;
            w8.a.b().v().b("Disconnected from device MeasurementService", componentName2);
            w8.h();
            w8.P();
        }
    }

    static void N(com.google.android.gms.measurement.internal.w8 w8) {
        w8.E();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final boolean A() {
        h();
        i();
        final int i3 = 1;
        if (B() && this.a.N().o0() >= (Integer)c3.n0.a(0).intValue()) {
            if (this.a.N().o0() >= (Integer)c3.n0.a(0).intValue()) {
                return i3;
            }
            return 0;
        }
        return i3;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final boolean B() {
        Boolean valueOf3;
        Boolean valueOf2;
        int str;
        Object valueOf;
        String str2;
        int str3;
        boolean booleanValue;
        int i2;
        int i;
        h();
        i();
        if (this.e == null) {
            h();
            i();
            com.google.android.gms.measurement.internal.g4 g4Var = this.a.F();
            g4Var.h();
            str2 = "use_service";
            str3 = 0;
            if (!g4Var.o().contains(str2)) {
                valueOf3 = 0;
            } else {
                valueOf3 = Boolean.valueOf(g4Var.o().getBoolean(str2, str3));
            }
            str = 1;
            if (valueOf3 != null && valueOf3.booleanValue()) {
                if (valueOf3.booleanValue()) {
                } else {
                    this.a.d();
                    if (this.a.B().o() == str) {
                        str3 = str;
                    } else {
                    }
                    if (str3 == null && this.a.z().G()) {
                        if (this.a.z().G()) {
                            this.a.b().r().a("No way to upload. Consider using the full version of Analytics");
                        } else {
                            if (str != null) {
                                com.google.android.gms.measurement.internal.g4 g4Var2 = this.a.F();
                                g4Var2.h();
                                valueOf3 = g4Var2.o().edit();
                                valueOf3.putBoolean(str2, str3);
                                valueOf3.apply();
                            }
                        }
                    } else {
                    }
                    str = str3;
                }
            } else {
            }
            this.e = Boolean.valueOf(str);
        }
        return this.e.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final Boolean J() {
        return this.e;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void O() {
        h();
        i();
        this.a.C().r();
        c8 c8Var = new c8(this, C(true));
        F(c8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void P() {
        boolean z;
        List intentServices;
        String str;
        int i;
        String str2;
        h();
        i();
        if (z()) {
        }
        this.a.d();
        Intent intent2 = new Intent();
        str2 = "com.google.android.gms.measurement.AppMeasurementService";
        intentServices = this.a.f().getPackageManager().queryIntentServices(intent2.setClassName(this.a.f(), str2), 65536);
        if (!B() && !this.a.z().G() && intentServices != null && intentServices.size() > 0) {
            if (!this.a.z().G()) {
                this.a.d();
                intent2 = new Intent();
                str2 = "com.google.android.gms.measurement.AppMeasurementService";
                intentServices = this.a.f().getPackageManager().queryIntentServices(intent2.setClassName(this.a.f(), str2), 65536);
                if (intentServices != null) {
                    if (intentServices.size() > 0) {
                        Intent intent = new Intent("com.google.android.gms.measurement.START");
                        this.a.d();
                        ComponentName componentName = new ComponentName(this.a.f(), str2);
                        intent.setComponent(componentName);
                        this.c.b(intent);
                    }
                }
                this.a.b().r().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
        this.c.c();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void Q() {
        h();
        i();
        this.c.d();
        a.b().c(this.a.f(), this.c);
        this.d = 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void R(i1 i1) {
        h();
        i();
        b8 b8Var = new b8(this, C(false), i1);
        F(b8Var);
    }

    public final void S(AtomicReference<String> atomicReference) {
        h();
        i();
        a8 a8Var = new a8(this, atomicReference, C(false));
        F(a8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void T(i1 i1, String string2, String string3) {
        h();
        i();
        super(this, string2, string3, C(false), i1);
        F(o8Var);
    }

    protected final void U(AtomicReference<List<com.google.android.gms.measurement.internal.c>> atomicReference, String string2, String string3, String string4) {
        h();
        i();
        super(this, atomicReference, 0, string3, string4, C(false));
        F(obj9);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void V(i1 i1, String string2, String string3, boolean z4) {
        h();
        i();
        super(this, string2, string3, C(false), z4, i1);
        F(x7Var);
    }

    protected final void W(AtomicReference<List<com.google.android.gms.measurement.internal.ea>> atomicReference, String string2, String string3, String string4, boolean z5) {
        h();
        i();
        super(this, atomicReference, 0, string3, string4, C(false), z5);
        F(obj10);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final boolean n() {
        return 0;
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void o(com.google.android.gms.measurement.internal.u u, String string2) {
        r.j(u);
        h();
        i();
        G();
        super(this, 1, C(true), this.a.C().v(u), u, string2);
        F(l8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void p(i1 i1, com.google.android.gms.measurement.internal.u u2, String string3) {
        h();
        i();
        if (this.a.N().p0(12451000) != 0) {
            this.a.b().w().a("Not bundling data. Service unavailable or out of date");
            this.a.N().F(i1, new byte[0]);
        }
        g8 g8Var = new g8(this, u2, string3, i1);
        F(g8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void q() {
        h();
        i();
        G();
        this.a.C().q();
        z7 z7Var = new z7(this, C(false));
        F(z7Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    final void r(com.google.android.gms.measurement.internal.g3 g3, a a2, com.google.android.gms.measurement.internal.na na3) {
        int i;
        int i2;
        int size;
        int size2;
        int i3;
        Throwable th;
        com.google.android.gms.measurement.internal.b5 str;
        String str2;
        h();
        i();
        G();
        this.a.z();
        int i4 = 0;
        final int i5 = 100;
        i = i4;
        i2 = i5;
        while (i < 1001) {
            if (i2 == i5) {
            }
            ArrayList arrayList = new ArrayList();
            List list = this.a.C().p(i5);
            if (list != null) {
            } else {
            }
            size = i4;
            if (a2 != null && size < i5) {
            }
            i3 = i4;
            while (i3 < arrayList.size()) {
                th = arrayList.get(i3);
                if (th instanceof u) {
                } else {
                }
                if (th instanceof ea) {
                } else {
                }
                if (th instanceof c) {
                } else {
                }
                this.a.b().r().a("Discarding data. Unrecognized parcel type.");
                i3++;
                g3.z((c)(a)th, na3);
                g3.J1((ea)th, na3);
                g3.M0((u)th, na3);
                str = this.a;
                str = str.b();
                str = str.r();
                str2 = "Failed to send event to the service";
                str.b(str2, th);
                str = this.a;
                str = str.b();
                str = str.r();
                str2 = "Failed to send user property to the service";
                str.b(str2, th);
                str = this.a;
                str = str.b();
                str = str.r();
                str2 = "Failed to send conditional user property to the service";
                str.b(str2, th);
            }
            i++;
            i2 = size;
            th = arrayList.get(i3);
            if (th instanceof u) {
            } else {
            }
            if (th instanceof ea) {
            } else {
            }
            if (th instanceof c) {
            } else {
            }
            this.a.b().r().a("Discarding data. Unrecognized parcel type.");
            i3++;
            g3.z((c)(a)th, na3);
            g3.J1((ea)th, na3);
            g3.M0((u)th, na3);
            if (size < i5) {
            }
            arrayList.add(a2);
            arrayList.addAll(list);
            size = list.size();
            str = this.a;
            str = str.b();
            str = str.r();
            str2 = "Failed to send event to the service";
            str.b(str2, th);
            str = this.a;
            str = str.b();
            str = str.r();
            str2 = "Failed to send user property to the service";
            str.b(str2, th);
            str = this.a;
            str = str.b();
            str = str.r();
            str2 = "Failed to send conditional user property to the service";
            str.b(str2, th);
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void s(com.google.android.gms.measurement.internal.c c) {
        r.j(c);
        h();
        i();
        this.a.d();
        c cVar = new c(c);
        super(this, 1, C(true), this.a.C().u(c), cVar, c);
        F(m8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void t(boolean z) {
        com.google.android.gms.measurement.internal.k8 k8Var;
        com.google.android.gms.measurement.internal.j3 obj2;
        h();
        i();
        if (z != null) {
            G();
            this.a.C().q();
        }
        if (A()) {
            k8Var = new k8(this, C(false));
            F(k8Var);
        }
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void u(com.google.android.gms.measurement.internal.p7 p7) {
        h();
        i();
        d8 d8Var = new d8(this, p7);
        F(d8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final void v(Bundle bundle) {
        h();
        i();
        e8 e8Var = new e8(this, C(false), bundle);
        F(e8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void w() {
        h();
        i();
        j8 j8Var = new j8(this, C(true));
        F(j8Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void x(com.google.android.gms.measurement.internal.g3 g3) {
        h();
        r.j(g3);
        this.d = g3;
        E();
        D();
    }

    @Override // com.google.android.gms.measurement.internal.f4
    protected final void y(com.google.android.gms.measurement.internal.ea ea) {
        h();
        i();
        G();
        y7 y7Var = new y7(this, C(true), this.a.C().w(ea), ea);
        F(y7Var);
    }

    @Override // com.google.android.gms.measurement.internal.f4
    public final boolean z() {
        h();
        i();
        if (this.d != null) {
            return 1;
        }
        return 0;
    }
}
