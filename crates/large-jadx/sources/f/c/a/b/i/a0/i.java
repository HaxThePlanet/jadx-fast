package f.c.a.b.i.a0;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;

/* compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* loaded from: classes.dex */
public final class i implements b<x> {

    private final j.a.a<Context> a;
    private final j.a.a<i0> b;
    private final j.a.a<s> c;
    private final j.a.a<f.c.a.b.i.b0.a> d;
    public i(j.a.a<Context> aVar, j.a.a<i0> aVar2, j.a.a<s> aVar3, j.a.a<f.c.a.b.i.b0.a> aVar4) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
    }

    public static i a(j.a.a<Context> aVar, j.a.a<i0> aVar2, j.a.a<s> aVar3, j.a.a<f.c.a.b.i.b0.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, i0 i0Var, s sVar, f.c.a.b.i.b0.a aVar) {
        final x xVar = h.a(context, i0Var, sVar, aVar);
        d.c(xVar, "Cannot return null from a non-@Nullable @Provides method");
        return xVar;
    }

    public x b() {
        return i.c((Context)this.a.get(), (i0)this.b.get(), (s)this.c.get(), (a)this.d.get());
    }
}
