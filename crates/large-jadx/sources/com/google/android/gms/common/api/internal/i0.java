package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.j0;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.b;
import com.google.android.gms.tasks.k;
import d.e.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* loaded from: classes2.dex */
public final class i0<O extends com.google.android.gms.common.api.a.d>  implements d.a, d.b {

    private final Queue<com.google.android.gms.common.api.internal.k1> a;
    @NotOnlyInitialized
    private final a.f b;
    private final com.google.android.gms.common.api.internal.c<O> c;
    private final com.google.android.gms.common.api.internal.x d;
    private final Set<com.google.android.gms.common.api.internal.l1> e;
    private final Map<com.google.android.gms.common.api.internal.j.a<?>, com.google.android.gms.common.api.internal.w0> f;
    private final int g;
    private final com.google.android.gms.common.api.internal.a1 h;
    private boolean i;
    private final List<com.google.android.gms.common.api.internal.j0> j;
    private b k = null;
    private int l = 0;
    final com.google.android.gms.common.api.internal.g m;
    public i0(com.google.android.gms.common.api.internal.g g, c c2) {
        this.m = g;
        super();
        LinkedList linkedList = new LinkedList();
        this.a = linkedList;
        HashSet hashSet = new HashSet();
        this.e = hashSet;
        HashMap hashMap = new HashMap();
        this.f = hashMap;
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        int i2 = 0;
        a.f fVar = c2.zaa(g.D(g).getLooper(), this);
        this.b = fVar;
        this.c = c2.getApiKey();
        x xVar = new x();
        this.d = xVar;
        this.g = c2.zab();
        if (fVar.requiresSignIn()) {
            this.h = c2.zac(g.E(g), g.D(g));
        }
        this.h = 0;
    }

    static boolean J(com.google.android.gms.common.api.internal.i0 i0, boolean z2) {
        return i0.o(false);
    }

    static void K(com.google.android.gms.common.api.internal.i0 i0, com.google.android.gms.common.api.internal.j0 j02) {
        boolean obj2;
        if (!i0.j.contains(j02)) {
        } else {
            if (!i0.i && !i0.b.isConnected()) {
                if (!i0.b.isConnected()) {
                    i0.C();
                }
                i0.e();
            }
        }
    }

    static void L(com.google.android.gms.common.api.internal.i0 i0, com.google.android.gms.common.api.internal.j0 j02) {
        boolean arrayList;
        int size;
        int next;
        boolean z;
        UnsupportedApiCallException unsupportedApiCallException;
        Object obj6;
        if (i0.j.remove(j02)) {
            g.D(i0.m).removeMessages(15, j02);
            g.D(i0.m).removeMessages(16, j02);
            obj6 = j0.b(j02);
            arrayList = new ArrayList(i0.a.size());
            Iterator iterator = i0.a.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                z = (t0)(k1)next.f(i0);
                if (next instanceof t0 && z != null && b.c(z, obj6)) {
                }
                z = (t0)next.f(i0);
                if (z != null) {
                }
                if (b.c(z, obj6)) {
                }
                arrayList.add(next);
            }
            next = 0;
            while (next < arrayList.size()) {
                z = arrayList.get(next);
                i0.a.remove((k1)z);
                unsupportedApiCallException = new UnsupportedApiCallException(obj6);
                z.b(unsupportedApiCallException);
                next++;
            }
        }
    }

    static void M(com.google.android.gms.common.api.internal.i0 i0, Status status2) {
        i0.i(status2);
    }

    static com.google.android.gms.common.api.internal.c N(com.google.android.gms.common.api.internal.i0 i0) {
        return i0.c;
    }

    static void O(com.google.android.gms.common.api.internal.i0 i0) {
        i0.b();
    }

    static void P(com.google.android.gms.common.api.internal.i0 i0, int i2) {
        i0.c(i2);
    }

    static a.f a(com.google.android.gms.common.api.internal.i0 i0) {
        return i0.b;
    }

    private final void b() {
        Iterator iterator;
        Object next;
        boolean next2;
        Object obj;
        k kVar;
        x();
        p(b.w);
        k();
        iterator = this.f.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (q(next.a.c()) != null) {
            } else {
            }
            kVar = new k();
            next.a.d(this.b, kVar);
            iterator.remove();
        }
        e();
        l();
    }

    private final void c(int i) {
        Message obtain;
        x();
        this.i = true;
        this.d.e(i, this.b.getLastDisconnectMessage());
        int i3 = 9;
        g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), i3, this.c), g.F(this.m));
        int i4 = 11;
        g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), i4, this.c), g.G(this.m));
        g.H(this.m).c();
        Iterator obj4 = this.f.values().iterator();
        for (w0 next2 : obj4) {
            next2.c.run();
        }
    }

    private final boolean d(b b) {
        com.google.android.gms.common.api.internal.y contains;
        com.google.android.gms.common.api.internal.c cVar;
        final Object obj = g.I();
        synchronized (obj) {
            if (g.K(this.m).contains(this.c)) {
                g.J(this.m).f(b, this.g);
                return 1;
            }
            return 0;
        }
    }

    private final void e() {
        int i;
        Object obj;
        boolean connected;
        ArrayList arrayList = new ArrayList(this.a);
        i = 0;
        while (i < arrayList.size()) {
            obj = arrayList.get(i);
            if (!this.b.isConnected()) {
                break;
            } else {
            }
            if (f((k1)obj)) {
            }
            i++;
            this.a.remove(obj);
        }
    }

    private final boolean f(com.google.android.gms.common.api.internal.k1 k1) {
        Handler handler;
        long i;
        int i2;
        String str;
        boolean obj10;
        int i4 = 1;
        if (!k1 instanceof t0) {
            g(k1);
            return i4;
        }
        Object obj = k1;
        d dVar = q((t0)obj.f(this));
        if (dVar == null) {
            g(k1);
            return i4;
        }
        obj10 = this.b.getClass().getName();
        String str2 = dVar.j2();
        final long l2 = dVar.k2();
        StringBuilder stringBuilder = new StringBuilder(i5 += length2);
        stringBuilder.append(obj10);
        stringBuilder.append(" could not execute call because it requires feature (");
        stringBuilder.append(str2);
        stringBuilder.append(", ");
        stringBuilder.append(l2);
        stringBuilder.append(").");
        Log.w("GoogleApiManager", stringBuilder.toString());
        if (g.d(this.m) && obj.g(this)) {
            if (obj.g(this)) {
                i = 0;
                obj10 = new j0(this.c, dVar, i);
                int indexOf = this.j.indexOf(obj10);
                i2 = 15;
                if (indexOf >= 0) {
                    obj10 = this.j.get(indexOf);
                    g.D(this.m).removeMessages(i2, (j0)obj10);
                    g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), i2, obj10), g.F(this.m));
                } else {
                    this.j.add(obj10);
                    g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), i2, obj10), g.F(this.m));
                    str = 16;
                    g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), str, obj10), g.G(this.m));
                    obj10 = new b(2, i);
                    if (!d(obj10)) {
                        this.m.A(obj10, this.g);
                    }
                }
                return 0;
            }
        }
        obj10 = new UnsupportedApiCallException(dVar);
        obj.b(obj10);
        return i4;
    }

    private final void g(com.google.android.gms.common.api.internal.k1 k1) {
        k1.c(this.d, F());
        int i = 1;
        k1.d(this);
    }

    private final void h(Status status, Exception exception2, boolean z3) {
        int i;
        int next;
        int i2;
        int i3;
        r.d(g.D(this.m));
        next = 1;
        i2 = status != null ? i : next;
        if (exception2 != null) {
        } else {
            i = next;
        }
        if (i2 == i) {
        } else {
            Iterator iterator = this.a.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (z3) {
                } else {
                }
                if (status != null) {
                } else {
                }
                (k1)next.b(exception2);
                iterator.remove();
                next.a(status);
                if (next.a == 2) {
                }
            }
        }
        IllegalArgumentException obj5 = new IllegalArgumentException("Status XOR exception should be null");
        throw obj5;
    }

    private final void i(Status status) {
        r.d(g.D(this.m));
        h(status, 0, false);
    }

    private final void k() {
        boolean z;
        int i;
        com.google.android.gms.common.api.internal.c cVar;
        if (this.i) {
            g.D(this.m).removeMessages(11, this.c);
            g.D(this.m).removeMessages(9, this.c);
            this.i = false;
        }
    }

    private final void l() {
        int i = 12;
        g.D(this.m).removeMessages(i, this.c);
        final com.google.android.gms.common.api.internal.c cVar2 = this.c;
        g.D(this.m).sendMessageDelayed(g.D(this.m).obtainMessage(i, cVar2), g.f(this.m));
    }

    private final boolean o(boolean z) {
        boolean connected;
        r.d(g.D(this.m));
        final int i = 0;
        if (this.b.isConnected() && this.f.size() == 0 && this.d.c() && z) {
            if (this.f.size() == 0) {
                if (this.d.c()) {
                    if (z) {
                        l();
                    }
                    return i;
                }
                this.b.disconnect("Timing out service connection.");
                return 1;
            }
        }
        return i;
    }

    private final void p(b b) {
        Object next;
        String endpointPackageName;
        com.google.android.gms.common.api.internal.c cVar;
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            if (p.a(b, b.w)) {
            } else {
            }
            endpointPackageName = 0;
            (l1)iterator.next().b(this.c, b, endpointPackageName);
            endpointPackageName = this.b.getEndpointPackageName();
        }
        this.e.clear();
    }

    private final d q(d[] dArr) {
        d[] availableFeatures;
        int length;
        int i;
        int length2;
        a aVar;
        int cmp;
        Long valueOf;
        String str;
        long l;
        if (dArr != null) {
            if (dArr.length == 0) {
            } else {
                i = 0;
                if (this.b.getAvailableFeatures() == null) {
                    availableFeatures = new d[i];
                }
                length2 = availableFeatures.length;
                aVar = new a(length2);
                cmp = i;
                while (cmp < length2) {
                    d dVar = availableFeatures[cmp];
                    aVar.put(dVar.j2(), Long.valueOf(dVar.k2()));
                    cmp++;
                }
                while (i < dArr.length) {
                    length2 = dArr[i];
                    cmp = aVar.get(length2.j2());
                    i++;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void A() {
        Status status;
        boolean z;
        int i;
        String str2;
        String str;
        r.d(g.D(this.m));
        if (this.i) {
            k();
            if (g.e(this.m).g(g.E(this.m)) == 18) {
                status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
            } else {
                status = new Status(22, "API failed to connect while resuming due to an unknown error.");
            }
            i(status);
            this.b.disconnect("Timing out connection while resuming.");
        }
    }

    @Override // com.google.android.gms.common.api.d$a
    public final boolean B() {
        return o(true);
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void C() {
        boolean connecting;
        Throwable th;
        b bVar;
        boolean requiresSignIn;
        r.d(g.D(this.m));
        if (!this.b.isConnected()) {
            if (this.b.isConnecting()) {
            } else {
                int i = 10;
                int i2 = g.H(this.m).a(g.E(this.m), this.b);
                if (i2 != 0) {
                    int i3 = 0;
                    b bVar2 = new b(i2, i3);
                    String name = this.b.getClass().getName();
                    final String valueOf = String.valueOf(bVar2);
                    StringBuilder stringBuilder = new StringBuilder(i4 += length2);
                    stringBuilder.append("The service for ");
                    stringBuilder.append(name);
                    stringBuilder.append(" is not available: ");
                    stringBuilder.append(valueOf);
                    Log.w("GoogleApiManager", stringBuilder.toString());
                    s(bVar2, i3);
                }
                a.f fVar5 = this.b;
                l0 l0Var = new l0(this.m, fVar5, this.c);
                if (fVar5.requiresSignIn()) {
                    requiresSignIn = this.h;
                    r.j(requiresSignIn);
                    (a1)requiresSignIn.q2(l0Var);
                }
            }
            this.b.connect(l0Var);
        }
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void D(com.google.android.gms.common.api.internal.l1 l1) {
        r.d(g.D(this.m));
        this.e.add(l1);
    }

    @Override // com.google.android.gms.common.api.d$a
    final boolean E() {
        return this.b.isConnected();
    }

    @Override // com.google.android.gms.common.api.d$a
    public final boolean F() {
        return this.b.requiresSignIn();
    }

    @Override // com.google.android.gms.common.api.d$a
    public final int G() {
        return this.g;
    }

    @Override // com.google.android.gms.common.api.d$a
    final int H() {
        return this.l;
    }

    @Override // com.google.android.gms.common.api.d$a
    final void I() {
        this.l = i++;
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void j(int i) {
        if (Looper.myLooper() == g.D(this.m).getLooper()) {
            c(i);
        }
        f0 f0Var = new f0(this, i);
        g.D(this.m).post(f0Var);
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void m(b b) {
        s(b, 0);
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void n(Bundle bundle) {
        if (Looper.myLooper() == g.D(this.m).getLooper()) {
            b();
        }
        e0 e0Var = new e0(this);
        g.D(this.m).post(e0Var);
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void r(b b) {
        r.d(g.D(this.m));
        a.f fVar = this.b;
        String name = fVar.getClass().getName();
        final String valueOf = String.valueOf(b);
        StringBuilder stringBuilder = new StringBuilder(i2 += length2);
        stringBuilder.append("onSignInFailed for ");
        stringBuilder.append(name);
        stringBuilder.append(" with ");
        stringBuilder.append(valueOf);
        fVar.disconnect(stringBuilder.toString());
        s(b, 0);
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void s(b b, Exception exception2) {
        boolean i3;
        int i;
        int message;
        int i2;
        com.google.android.gms.common.internal.safeparcel.a obj6;
        boolean obj7;
        r.d(g.D(this.m));
        com.google.android.gms.common.api.internal.a1 a1Var = this.h;
        if (a1Var != null) {
            a1Var.r2();
        }
        x();
        g.H(this.m).c();
        p(b);
        int i7 = 1;
        if (fVar instanceof e && b.j2() != 24) {
            if (b.j2() != 24) {
                g.b(this.m, i7);
                g.D(this.m).sendMessageDelayed(g.D(this.m).obtainMessage(19), 300000);
            }
        }
        if (b.j2() == 4) {
            i(g.c());
        }
        if (this.a.isEmpty()) {
            this.k = b;
        }
        int i5 = 0;
        if (exception2 != null) {
            r.d(g.D(this.m));
            h(i5, exception2, false);
        }
        h(g.g(this.c, b), i5, i7);
        if (g.d(this.m) && this.a.isEmpty()) {
            h(g.g(this.c, b), i5, i7);
            if (this.a.isEmpty()) {
            }
            if (d(b)) {
            }
            if (!this.m.A(b, this.g) && b.j2() == 18) {
                if (b.j2() == 18) {
                    this.i = i7;
                }
                if (this.i) {
                    com.google.android.gms.common.api.internal.c cVar = this.c;
                    g.D(this.m).sendMessageDelayed(Message.obtain(g.D(this.m), 9, cVar), g.F(this.m));
                }
                i(g.g(this.c, b));
            }
        }
        i(g.g(this.c, b));
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void t(com.google.android.gms.common.api.internal.k1 k1) {
        b obj2;
        r.d(g.D(this.m));
        if (this.b.isConnected() && f(k1)) {
            if (f(k1)) {
                l();
            }
            this.a.add(k1);
        }
        this.a.add(k1);
        obj2 = this.k;
        if (obj2 != null && obj2.m2()) {
            if (obj2.m2()) {
                s(this.k, 0);
            }
        }
        C();
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void u() {
        boolean connected;
        int i;
        int h0Var;
        Object obj;
        com.google.android.gms.common.api.internal.j1 j1Var;
        k kVar;
        r.d(g.D(this.m));
        i(g.J);
        this.d.d();
        Object[] array = this.f.keySet().toArray(new j.a[0]);
        while (i < array.length) {
            kVar = new k();
            j1Var = new j1((j.a[])array[i], kVar);
            t(j1Var);
            i++;
        }
        b bVar = new b(4);
        p(bVar);
        if (this.b.isConnected()) {
            h0Var = new h0(this);
            this.b.onUserSignOut(h0Var);
        }
    }

    @Override // com.google.android.gms.common.api.d$a
    public final a.f v() {
        return this.b;
    }

    public final Map<com.google.android.gms.common.api.internal.j.a<?>, com.google.android.gms.common.api.internal.w0> w() {
        return this.f;
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void x() {
        r.d(g.D(this.m));
        this.k = 0;
    }

    @Override // com.google.android.gms.common.api.d$a
    public final b y() {
        r.d(g.D(this.m));
        return this.k;
    }

    @Override // com.google.android.gms.common.api.d$a
    public final void z() {
        r.d(g.D(this.m));
        if (this.i) {
            C();
        }
    }
}
