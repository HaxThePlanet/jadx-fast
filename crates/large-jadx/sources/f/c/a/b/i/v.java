package f.c.a.b.i;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import f.c.a.b.i.a0.e;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.w.b.b;
import j.a.a;

/* loaded from: classes.dex */
public final class v implements b<f.c.a.b.i.t> {

    private final a<a> a;
    private final a<a> b;
    private final a<e> c;
    private final a<t> d;
    private final a<v> e;
    public v(a<a> a, a<a> a2, a<e> a3, a<t> a4, a<v> a5) {
        super();
        this.a = a;
        this.b = a2;
        this.c = a3;
        this.d = a4;
        this.e = a5;
    }

    public static f.c.a.b.i.v a(a<a> a, a<a> a2, a<e> a3, a<t> a4, a<v> a5) {
        super(a, a2, a3, a4, a5);
        return vVar2;
    }

    public static f.c.a.b.i.t c(a a, a a2, e e3, t t4, v v5) {
        super(a, a2, e3, t4, v5);
        return tVar3;
    }

    @Override // f.c.a.b.i.w.b.b
    public f.c.a.b.i.t b() {
        return v.c((a)this.a.get(), (a)this.b.get(), (e)this.c.get(), (t)this.d.get(), (v)this.e.get());
    }

    @Override // f.c.a.b.i.w.b.b
    public Object get() {
        return b();
    }
}
