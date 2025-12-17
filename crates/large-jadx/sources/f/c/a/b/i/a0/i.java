package f.c.a.b.i.a0;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.x;
import f.c.a.b.i.a0.j.i0;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import j.a.a;

/* loaded from: classes.dex */
public final class i implements b<x> {

    private final a<Context> a;
    private final a<i0> b;
    private final a<s> c;
    private final a<a> d;
    public i(a<Context> a, a<i0> a2, a<s> a3, a<a> a4) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
        this.d = a4;
    }

    public static f.c.a.b.i.a0.i a(a<Context> a, a<i0> a2, a<s> a3, a<a> a4) {
        i iVar = new i(a, a2, a3, a4);
        return iVar;
    }

    public static x c(Context context, i0 i02, s s3, a a4) {
        final x obj0 = h.a(context, i02, s3, a4);
        d.c(obj0, "Cannot return null from a non-@Nullable @Provides method");
        return (x)obj0;
    }

    @Override // f.c.a.b.i.w.b.b
    public x b() {
        return i.c((Context)this.a.get(), (i0)this.b.get(), (s)this.c.get(), (a)this.d.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
