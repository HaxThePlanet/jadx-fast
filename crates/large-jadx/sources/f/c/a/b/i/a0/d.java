package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.backends.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import com.google.android.datatransport.runtime.synchronization.a;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.w.b.b;
import j.a.a;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class d implements b<f.c.a.b.i.a0.c> {

    private final a<Executor> a;
    private final a<e> b;
    private final a<x> c;
    private final a<i0> d;
    private final a<a> e;
    public d(a<Executor> a, a<e> a2, a<x> a3, a<i0> a4, a<a> a5) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
        this.d = a4;
        this.e = a5;
    }

    public static f.c.a.b.i.a0.d a(a<Executor> a, a<e> a2, a<x> a3, a<i0> a4, a<a> a5) {
        super(a, a2, a3, a4, a5);
        return dVar2;
    }

    public static f.c.a.b.i.a0.c c(Executor executor, e e2, x x3, i0 i04, a a5) {
        super(executor, e2, x3, i04, a5);
        return cVar2;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.a0.c b() {
        return d.c((Executor)this.a.get(), (e)this.b.get(), (x)this.c.get(), (i0)this.d.get(), (a)this.e.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
