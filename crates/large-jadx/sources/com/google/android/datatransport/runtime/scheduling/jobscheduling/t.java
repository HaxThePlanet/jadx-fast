package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.f.a;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.g.a;
import com.google.android.datatransport.runtime.backends.m;
import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.b;
import f.c.a.b.i.a0.j.h0;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.a0.j.p0;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.i;
import f.c.a.b.i.j;
import f.c.a.b.i.j.a;
import f.c.a.b.i.p;
import f.c.a.b.i.x.a.a;
import f.c.a.b.i.x.a.c.b;
import f.c.a.b.i.y.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class t {

    private final Context a;
    private final e b;
    private final i0 c;
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.x d;
    private final Executor e;
    private final a f;
    private final a g;
    private final a h;
    private final h0 i;
    public t(Context context, e e2, i0 i03, com.google.android.datatransport.runtime.scheduling.jobscheduling.x x4, Executor executor5, a a6, a a7, a a8, h0 h09) {
        super();
        this.a = context;
        this.b = e2;
        this.c = i03;
        this.d = x4;
        this.e = executor5;
        this.f = a6;
        this.g = a7;
        this.h = a8;
        this.i = h09;
    }

    private Boolean b(p p) {
        return Boolean.valueOf(this.c.L1(p));
    }

    private Iterable d(p p) {
        return this.c.R(p);
    }

    private Object f(Iterable iterable, p p2, long l3) {
        this.c.R1(iterable);
        this.c.Z(p2, time += l3);
        return null;
    }

    private Object h(Iterable iterable) {
        this.c.v(iterable);
        return null;
    }

    private Object j(Map map) {
        Object key;
        h0 h0Var;
        long l;
        c.b iNVALID_PAYLOD;
        Iterator obj6 = map.entrySet().iterator();
        for (Map.Entry next2 : obj6) {
            this.i.e((long)intValue, obj3, c.b.INVALID_PAYLOD);
        }
        return null;
    }

    private Object l(p p, long l2) {
        this.c.Z(p, time += l2);
        return null;
    }

    private Object n(p p, int i2) {
        this.d.a(p, i2++);
        return null;
    }

    private void p(p p, int i2, Runnable runnable3) {
        a z;
        Object jVar;
        int obj5;
        try {
            jVar = this.c;
            Objects.requireNonNull(jVar);
            b bVar = new b(jVar);
            this.f.a(bVar);
            if (!a()) {
            } else {
            }
            jVar = new j(this, p, i2);
            this.f.a(jVar);
            r(p, i2);
            i2++;
            this.d.a(p, i2);
            runnable3.run();
            runnable3.run();
            throw p;
        } catch (Throwable th) {
        }
    }

    boolean a() {
        NetworkInfo activeNetworkInfo;
        int i;
        activeNetworkInfo = (ConnectivityManager)this.a.getSystemService("connectivity").getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            i = activeNetworkInfo.isConnected() ? 1 : 0;
        } else {
        }
        return i;
    }

    public Boolean c(p p) {
        return b(p);
    }

    public Iterable e(p p) {
        return d(p);
    }

    public Object g(Iterable iterable, p p2, long l3) {
        return f(iterable, p2, l3);
    }

    public Object i(Iterable iterable) {
        return h(iterable);
    }

    public Object k(Map map) {
        return j(map);
    }

    public Object m(p p, long l2) {
        return l(p, l2);
    }

    public Object o(p p, int i2) {
        return n(p, i2);
    }

    public void q(p p, int i2, Runnable runnable3) {
        p(p, i2, runnable3);
    }

    void r(p p, int i2) {
        int hashMap;
        g gVar;
        g.a iNVALID_PAYLOAD;
        boolean z;
        Object str;
        g.a kVar;
        i valueOf;
        Object obj;
        b bVar;
        int i;
        int time;
        m mVar = this.b.get(p.b());
        hashMap = 0;
        while (/* condition */) {
            f fVar2 = new f(this, p);
            while ((Boolean)this.f.a(fVar2).booleanValue()) {
                g gVar2 = new g(this, p);
                obj = obj3;
                if (mVar == null) {
                } else {
                }
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = obj.iterator();
                for (p0 next2 : iterator2) {
                    arrayList.add(next2.b());
                }
                if (p.e()) {
                }
                str = f.a();
                str.b(arrayList);
                str.c(p.c());
                gVar = mVar.a(str.a());
                time = 1;
                i iVar = new i(this, obj);
                this.f.a(iVar);
                iNVALID_PAYLOAD = gVar.c();
                if (iNVALID_PAYLOAD == g.a.OK) {
                    break loop_2;
                } else {
                }
                if (gVar.c() == g.a.INVALID_PAYLOAD) {
                }
                fVar2 = new f(this, p);
                hashMap = new HashMap();
                Iterator iterator3 = obj.iterator();
                while (iterator3.hasNext()) {
                    kVar = (p0)iterator3.next().b().j();
                    if (!hashMap.containsKey(kVar)) {
                    } else {
                    }
                    hashMap.put(kVar, Integer.valueOf(intValue += time));
                    hashMap.put(kVar, Integer.valueOf(time));
                }
                kVar = new k(this, hashMap);
                this.f.a(kVar);
                kVar = (p0)iterator3.next().b().j();
                if (!hashMap.containsKey(kVar)) {
                } else {
                }
                hashMap.put(kVar, Integer.valueOf(intValue += time));
                hashMap.put(kVar, Integer.valueOf(time));
                h0 h0Var = this.i;
                Objects.requireNonNull(h0Var);
                n nVar = new n(h0Var);
                kVar = j.a();
                kVar.i(this.g.getTime());
                kVar.k(this.h.getTime());
                kVar.j("GDT_CLIENT_METRICS");
                valueOf = new i(b.b("proto"), (a)this.f.a(nVar).f());
                kVar.h(valueOf);
                arrayList.add(mVar.b(kVar.d()));
                arrayList.add((p0)iterator2.next().b());
                a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", p);
                gVar = g.a();
            }
            gVar2 = new g(this, p);
            obj = obj3;
            if (mVar == null) {
            } else {
            }
            arrayList = new ArrayList();
            iterator2 = obj.iterator();
            for (p0 next2 : iterator2) {
                arrayList.add(next2.b());
            }
            if (p.e()) {
            }
            str = f.a();
            str.b(arrayList);
            str.c(p.c());
            gVar = mVar.a(str.a());
            time = 1;
            iVar = new i(this, obj);
            this.f.a(iVar);
            iNVALID_PAYLOAD = gVar.c();
            if (iNVALID_PAYLOAD == g.a.OK) {
            } else {
            }
            if (gVar.c() == g.a.INVALID_PAYLOAD) {
            }
            hashMap = new HashMap();
            iterator3 = obj.iterator();
            while (iterator3.hasNext()) {
                kVar = (p0)iterator3.next().b().j();
                if (!hashMap.containsKey(kVar)) {
                } else {
                }
                hashMap.put(kVar, Integer.valueOf(intValue += time));
                hashMap.put(kVar, Integer.valueOf(time));
            }
            kVar = new k(this, hashMap);
            this.f.a(kVar);
            kVar = (p0)iterator3.next().b().j();
            if (!hashMap.containsKey(kVar)) {
            } else {
            }
            hashMap.put(kVar, Integer.valueOf(intValue += time));
            hashMap.put(kVar, Integer.valueOf(time));
            hashMap = Math.max(i, obj8);
            i = hashMap;
            h0Var = this.i;
            Objects.requireNonNull(h0Var);
            nVar = new n(h0Var);
            kVar = j.a();
            kVar.i(this.g.getTime());
            kVar.k(this.h.getTime());
            kVar.j("GDT_CLIENT_METRICS");
            valueOf = new i(b.b("proto"), (a)this.f.a(nVar).f());
            kVar.h(valueOf);
            arrayList.add(mVar.b(kVar.d()));
            arrayList.add((p0)iterator2.next().b());
            a.a("Uploader", "Unknown backend for %s, deleting event batch for it...", p);
            gVar = g.a();
        }
        d dVar = new d(this, p, i, obj8);
        this.f.a(dVar);
    }

    public void s(p p, int i2, Runnable runnable3) {
        e eVar = new e(this, p, i2, runnable3);
        this.e.execute(eVar);
    }
}
