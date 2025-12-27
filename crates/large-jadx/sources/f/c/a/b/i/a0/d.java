package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.w.b.b;
import java.util.concurrent.Executor;

/* compiled from: DefaultScheduler_Factory.java */
/* loaded from: classes.dex */
public final class d implements b<c> {

    private final j.a.a<Executor> a;
    private final j.a.a<e> b;
    private final j.a.a<x> c;
    private final j.a.a<i0> d;
    private final j.a.a<com.google.android.datatransport.runtime.synchronization.a> e;
    public d(j.a.a<Executor> aVar, j.a.a<e> aVar2, j.a.a<x> aVar3, j.a.a<i0> aVar4, j.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
    }

    public static d a(j.a.a<Executor> aVar, j.a.a<e> aVar2, j.a.a<x> aVar3, j.a.a<i0> aVar4, j.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        d dVar = new d(aVar, aVar2, aVar3, aVar4, aVar5);
        return dVar;
    }

    public static c c(Executor executor, e eVar, x xVar, i0 i0Var, com.google.android.datatransport.runtime.synchronization.a aVar) {
        c cVar = new c(executor, eVar, xVar, i0Var, aVar);
        return cVar;
    }

    public c b() {
        return d.c((Executor)this.a.get(), (e)this.b.get(), (x)this.c.get(), (i0)this.d.get(), (a)this.e.get());
    }
}
