package f.c.a.b.i;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.t;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.v;
import f.c.a.b.b;
import f.c.a.b.c;
import f.c.a.b.g;
import f.c.a.b.h;
import f.c.a.b.i.a0.e;
import f.c.a.b.i.b0.a;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public class t implements f.c.a.b.i.s {

    private static volatile f.c.a.b.i.u e;
    private final a a;
    private final a b;
    private final e c;
    private final t d;
    static {
    }

    t(a a, a a2, e e3, t t4, v v5) {
        super();
        this.a = a;
        this.b = a2;
        this.c = e3;
        this.d = t4;
        v5.a();
    }

    private f.c.a.b.i.j b(f.c.a.b.i.o o) {
        final f.c.a.b.i.j.a aVar = j.a();
        aVar.i(this.a.getTime());
        aVar.k(this.b.getTime());
        aVar.j(o.g());
        i iVar = new i(o.b(), o.d());
        aVar.h(iVar);
        aVar.g(o.c().a());
        return aVar.d();
    }

    public static f.c.a.b.i.t c() {
        f.c.a.b.i.u uVar = t.e;
        if (uVar == null) {
        } else {
            return uVar.c();
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not initialized!");
        throw illegalStateException;
    }

    private static Set<b> d(f.c.a.b.i.g g) {
        if (g instanceof h) {
            return Collections.unmodifiableSet((h)g.a());
        }
        return Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        f.c.a.b.i.u uVar;
        Object uVar2;
        Object obj2;
        uVar = t.class;
        if (t.e == null && t.e == null) {
            uVar = t.class;
            synchronized (uVar) {
                uVar2 = f.e();
                uVar2.a(context);
                t.e = uVar2.build();
            }
        }
    }

    @Override // f.c.a.b.i.s
    public void a(f.c.a.b.i.o o, h h2) {
        this.c.a(o.f().f(o.c().c()), b(o), h2);
    }

    @Override // f.c.a.b.i.s
    public t e() {
        return this.d;
    }

    @Override // f.c.a.b.i.s
    public g g(f.c.a.b.i.g g) {
        final f.c.a.b.i.p.a aVar = p.a();
        aVar.b(g.getName());
        aVar.c(g.getExtras());
        q qVar = new q(t.d(g), aVar.a(), this);
        return qVar;
    }
}
