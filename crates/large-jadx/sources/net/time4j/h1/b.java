package net.time4j.h1;

import java.util.Locale;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.g;
import net.time4j.history.d;
import net.time4j.history.h;
import net.time4j.history.j;
import net.time4j.history.p;
import net.time4j.history.q.a;
import net.time4j.history.q.c;

/* loaded from: classes3.dex */
public class b implements r {
    private static d e(Locale locale, d d2) {
        boolean equals;
        String str;
        net.time4j.engine.c cVar = a.b;
        String str2 = "iso8601";
        if ((String)d2.a(cVar, str2).equals("julian")) {
            return d.J;
        }
        net.time4j.engine.c cVar2 = a.a;
        if (d2.c(cVar2)) {
            return (d)d2.b(cVar2);
        }
        equals = a.t;
        if ((String)d2.a(cVar, str2).equals("historic") && d2.c(equals)) {
            equals = a.t;
            if (d2.c(equals)) {
                return d.j((String)d2.b(equals));
            }
        }
        return d.D(locale);
    }

    public boolean a(p<?> p) {
        return p instanceof c;
    }

    public q<?> b(q<?> q, Locale locale2, d d3) {
        return f(q, b.e(locale2, d3), d3);
    }

    public Set<p<?>> c(Locale locale, d d2) {
        return b.e(locale, d2).o();
    }

    public boolean d(Class<?> class) {
        int obj2;
        obj2 = class == g0.class ? 1 : 0;
        return obj2;
    }

    public q<?> f(q<?> q, d d2, d d3) {
        boolean lax;
        int i;
        int i2;
        g sMART;
        int i3;
        q obj9;
        q obj10;
        boolean obj11;
        i = 0;
        if (q.v(d2.i())) {
            lax = q.p(d2.i());
            i2 = lax;
        } else {
        }
        if (i2 != 0 && q.v(d2.M()) && q.v(d2.C()) && q.v(d2.g())) {
            if (q.v(d2.M())) {
                if (q.v(d2.C())) {
                    if (q.v(d2.g())) {
                        q.G(d2.i(), i);
                        q.G(d2.M(), i);
                        q.G(d2.C(), i);
                        q.G(d2.g(), i);
                        return q.G(g0.G, d2.d(h.m(i2, q.e(d2.M()), q.e(d2.C()), q.e(d2.g()), (p)d3.a(d.H, p.DUAL_DATING), d2.w())));
                    }
                }
                p pVar2 = c.w;
                if (q.v(d2.h()) && q.v(pVar2)) {
                    pVar2 = c.w;
                    if (q.v(pVar2)) {
                        i3 = q.e(pVar2);
                    }
                    obj9 = q.G(g0.G, (g0)d2.d(d2.n(i2, i3)).E(d2.h(), q.e(d2.h())));
                }
            }
        }
        return obj9;
    }
}
