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

/* compiled from: TransportRuntime.java */
/* loaded from: classes.dex */
public class t implements s {

    private static volatile u e;
    private final a a;
    private final a b;
    private final e c;
    private final t d;
    t(a aVar, a aVar2, e eVar, t tVar, v vVar) {
        super();
        this.a = aVar;
        this.b = aVar2;
        this.c = eVar;
        this.d = tVar;
        vVar.a();
    }

    private j b(o oVar) {
        final f.c.a.b.i.j.a aVar = j.a();
        aVar.i(this.a.getTime());
        aVar.k(this.b.getTime());
        aVar.j(oVar.g());
        aVar.h(new i(oVar.b(), oVar.d()));
        aVar.g(oVar.c().a());
        return aVar.d();
    }

    public static t c() {
        f.c.a.b.i.u uVar = t.e;
        if (t.e == null) {
            throw new IllegalStateException("Not initialized!");
        } else {
            return t.e.c();
        }
    }

    private static Set<b> d(g gVar) {
        if (gVar instanceof h) {
            return Collections.unmodifiableSet(gVar.a());
        }
        return Collections.singleton(b.b("proto"));
    }

    public static void f(Context context) {
        f.c.a.b.i.u uVar2;
        f.c.a.b.i.u aVar;
        if (t.e == null) {
            uVar = t.class;
            synchronized (uVar) {
                try {
                    if (t.e == null) {
                        f.c.a.b.i.u.a aVar2 = f.e();
                        aVar2.a(context);
                        t.e = aVar2.build();
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public void a(o oVar, h hVar) {
        this.c.a(oVar.f().f(oVar.c().c()), b(oVar), hVar);
    }

    public t e() {
        return this.d;
    }

    public g g(g gVar) {
        final f.c.a.b.i.p.a aVar = p.a();
        aVar.b(gVar.getName());
        aVar.c(gVar.getExtras());
        return new q(t.d(gVar), aVar.a(), this);
    }

}
