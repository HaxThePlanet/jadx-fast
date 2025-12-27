package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: SchedulingConfigModule_ConfigFactory.java */
/* loaded from: classes.dex */
public final class g implements b<s> {

    private final j.a.a<f.c.a.b.i.b0.a> a;
    public g(j.a.a<f.c.a.b.i.b0.a> aVar) {
        super();
        this.a = aVar;
    }

    public static s a(f.c.a.b.i.b0.a aVar) {
        final s sVar = f.a(aVar);
        d.c(sVar, "Cannot return null from a non-@Nullable @Provides method");
        return sVar;
    }

    public static g b(j.a.a<f.c.a.b.i.b0.a> aVar) {
        return new g(aVar);
    }

    public s c() {
        return g.a((a)this.a.get());
    }
}
