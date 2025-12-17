package f.c.a.b.i.a0;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.w.b.b;
import f.c.a.b.i.w.b.d;
import j.a.a;

/* loaded from: classes.dex */
public final class g implements b<s> {

    private final a<a> a;
    public g(a<a> a) {
        super();
        this.a = a;
    }

    public static s a(a a) {
        final s obj1 = f.a(a);
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (s)obj1;
    }

    public static f.c.a.b.i.a0.g b(a<a> a) {
        g gVar = new g(a);
        return gVar;
    }

    @Override // f.c.a.b.i.w.b.b
    public s c() {
        return g.a((a)this.a.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return c();
    }
}
