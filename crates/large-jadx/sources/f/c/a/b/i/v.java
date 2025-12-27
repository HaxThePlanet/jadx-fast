package f.c.a.b.i;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import f.c.a.b.i.a0.e;
import f.c.a.b.i.w.b.b;

/* compiled from: TransportRuntime_Factory.java */
/* loaded from: classes.dex */
public final class v implements b<t> {

    private final j.a.a<f.c.a.b.i.b0.a> a;
    private final j.a.a<f.c.a.b.i.b0.a> b;
    private final j.a.a<e> c;
    private final j.a.a<t> d;
    private final j.a.a<v> e;
    public v(j.a.a<f.c.a.b.i.b0.a> aVar, j.a.a<f.c.a.b.i.b0.a> aVar2, j.a.a<e> aVar3, j.a.a<t> aVar4, j.a.a<v> aVar5) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static v a(j.a.a<f.c.a.b.i.b0.a> aVar, j.a.a<f.c.a.b.i.b0.a> aVar2, j.a.a<e> aVar3, j.a.a<t> aVar4, j.a.a<v> aVar5) {
        v vVar = new v(aVar, aVar2, aVar3, aVar4, aVar5);
        return vVar;
    }

    public static t c(f.c.a.b.i.b0.a aVar, f.c.a.b.i.b0.a aVar2, e eVar, t tVar, v vVar) {
        tVar = new t(aVar, aVar2, eVar, tVar, vVar);
        return tVar;
    }

    public t b() {
        return v.c((a)this.a.get(), (a)this.b.get(), (e)this.c.get(), (t)this.d.get(), (v)this.e.get());
    }
}
