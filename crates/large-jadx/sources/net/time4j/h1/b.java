package net.time4j.h1;

import java.util.Locale;
import java.util.Set;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.g0;
import net.time4j.g1.g;
import net.time4j.history.h;
import net.time4j.history.j;
import net.time4j.history.q.c;

/* compiled from: HistoricExtension.java */
/* loaded from: classes3.dex */
public class b implements r {
    private static net.time4j.history.d e(Locale locale, net.time4j.engine.d dVar) {
        net.time4j.engine.c cVar = a.b;
        String str2 = "iso8601";
        if ((String)dVar.a(cVar, str2).equals("julian")) {
            return d.J;
        }
        net.time4j.engine.c cVar3 = a.a;
        if (dVar.c(cVar3)) {
            return (d)dVar.b(a.a);
        }
        str = "historic";
        if ((String)dVar.a(a.b, str2).equals(str)) {
            net.time4j.engine.c cVar2 = a.t;
            if (dVar.c(cVar2)) {
                return d.j((String)dVar.b(a.t));
            }
        }
        return d.D(locale);
    }

    public boolean a(net.time4j.engine.p<?> pVar) {
        return pVar instanceof c;
    }

    public q<?> b(q<?> qVar, Locale locale, net.time4j.engine.d dVar) {
        return f(qVar, b.e(locale, dVar), dVar);
    }

    public Set<net.time4j.engine.p<?>> c(Locale locale, net.time4j.engine.d dVar) {
        return b.e(locale, dVar).o();
    }

    public boolean d(Class<?> cls) {
        boolean z = true;
        cls = cls == g0.class ? 1 : 0;
        return (cls == g0.class ? 1 : 0);
    }

    public q<?> f(q<?> qVar, net.time4j.history.d dVar, net.time4j.engine.d dVar2) {
        boolean lax;
        j aD2;
        int i;
        q qVar2;
        Object obj = null;
        if (qVar.v(dVar.i())) {
            Object obj3 = qVar.p(dVar.i());
        }
        if (aD2 != null) {
            if (qVar.v(dVar.M())) {
                if (qVar.v(dVar.C()) && qVar.v(dVar.g())) {
                    qVar.G(dVar.i(), obj);
                    qVar.G(dVar.M(), obj);
                    qVar.G(dVar.C(), obj);
                    qVar.G(dVar.g(), obj);
                    return qVar.G(g0.G, dVar.d(h.m(aD2, qVar.e(dVar.M()), qVar.e(dVar.C()), qVar.e(dVar.g()), (p)dVar2.a(d.H, p.DUAL_DATING), dVar.w())));
                }
                if (qVar.v(dVar.h())) {
                    net.time4j.engine.p pVar2 = c.w;
                    if (qVar.v(pVar2)) {
                        i = qVar.e(c.w);
                    }
                    qVar2 = qVar.G(g0.G, (g0)dVar.d(dVar.n(aD2, i)).E(dVar.h(), qVar.e(dVar.h())));
                }
            }
        }
        return qVar2;
    }
}
