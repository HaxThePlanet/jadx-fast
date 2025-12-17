package net.time4j.g1.z;

import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;
import net.time4j.b0;
import net.time4j.engine.d;
import net.time4j.engine.f0;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.s;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.e;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.h0;
import net.time4j.i0;
import net.time4j.tz.p;
import net.time4j.z0;

/* loaded from: classes3.dex */
public class l {

    private static final char a = 44;
    private static final net.time4j.g1.z.l.c b;
    private static final net.time4j.g1.z.l.c c;
    private static final n<o> d;
    private static final n<Character> e;
    public static final net.time4j.g1.z.c<g0> f;
    public static final net.time4j.g1.z.c<g0> g;
    public static final net.time4j.g1.z.c<g0> h;
    public static final net.time4j.g1.z.c<g0> i;
    public static final net.time4j.g1.z.c<g0> j;
    public static final net.time4j.g1.z.c<g0> k;
    public static final net.time4j.g1.z.c<g0> l;

    static class a implements net.time4j.g1.z.e<g0> {

        final boolean a;
        a(boolean z) {
            this.a = z;
            super();
        }

        @Override // net.time4j.g1.z.e
        public Object a(Object object, java.lang.Appendable appendable2, d d3, s s4) {
            return b((g0)object, appendable2, d3, s4);
        }

        public <R> R b(g0 g0, java.lang.Appendable appendable2, d d3, s<o, R> s4) {
            net.time4j.g1.z.c obj4;
            obj4 = this.a ? l.g : l.f;
            obj4.J(g0, appendable2, d3);
            return 0;
        }
    }

    static class b implements net.time4j.g1.z.d<g0> {

        final boolean a;
        b(boolean z) {
            this.a = z;
            super();
        }

        @Override // net.time4j.g1.z.d
        public g0 a(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3) {
            int i2;
            int i5;
            int i6;
            int i;
            int i4;
            char charAt;
            int i3;
            int obj10 = charSequence.length();
            int i7 = s2.f();
            i2 = obj10 - i7;
            i6 = i7 + 1;
            i = 0;
            i4 = 45;
            while (i6 < obj10) {
                charAt = charSequence.charAt(i6);
                i++;
                i6++;
                i4 = 45;
            }
            if (this.a && i == 1) {
                if (i == 1) {
                    return (g0)l.i.E(charSequence, s2);
                }
                return (g0)l.g.E(charSequence, s2);
            }
            obj10 = charSequence.charAt(i7);
            if (obj10 != 43) {
                if (obj10 == i4) {
                    i5 += -2;
                }
            } else {
            }
            if (i5 == 3) {
                return (g0)l.h.E(charSequence, s2);
            }
            return (g0)l.f.E(charSequence, s2);
        }

        @Override // net.time4j.g1.z.d
        public Object b(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3) {
            return a(charSequence, s2, d3);
        }
    }

    private static class c implements n<o> {

        private final p<Integer> a;
        c(p<Integer> p) {
            super();
            this.a = p;
        }

        n<o> a(net.time4j.g1.z.l.c l$c) {
            l.c.a aVar = new l.c.a(this, c);
            return aVar;
        }

        @Override // net.time4j.engine.n
        public boolean b(o o) {
            int obj2;
            obj2 = o.e(this.a) > 0 ? 1 : 0;
            return obj2;
        }

        @Override // net.time4j.engine.n
        public boolean test(Object object) {
            return b((o)object);
        }
    }

    private static class d implements n<Character> {
        d(net.time4j.g1.z.l.a l$a) {
            super();
        }

        @Override // net.time4j.engine.n
        public boolean a(Character character) {
            int obj2;
            obj2 = character.charValue() == 84 ? 1 : 0;
            return obj2;
        }

        @Override // net.time4j.engine.n
        public boolean test(Object object) {
            return a((Character)object);
        }
    }
    static {
        if (Boolean.getBoolean("net.time4j.format.iso.decimal.dot")) {
            int i = 46;
        }
        int i2 = 44;
        l.c cVar = new l.c(h0.Q);
        l.b = cVar;
        l.c cVar2 = new l.c(h0.U);
        l.c = cVar2;
        l.d = cVar.a(cVar2);
        l.d dVar = new l.d(0);
        l.e = dVar;
        int i3 = 0;
        l.f = l.b(i3);
        int i5 = 1;
        l.g = l.b(i5);
        l.h = l.h(i3);
        l.i = l.h(i5);
        l.j = l.m(i3);
        l.k = l.m(i5);
        l.c(i3);
        l.l = l.c(i5);
        l.k(i3);
        l.k(i5);
        l.l(i3);
        l.l(i5);
        l.g(i3);
        l.g(i5);
    }

    private static <T extends net.time4j.engine.q<T>> void a(net.time4j.g1.z.c.d<T> c$d, boolean z2) {
        int i;
        net.time4j.l0 obj4;
        d.b0(a.l, j.ARABIC);
        d.Z(a.m, '0');
        int i6 = 2;
        d.g(h0.N, i6);
        d.X();
        int i2 = 58;
        if (z2) {
            d.l(i2);
        }
        d.g(h0.O, i6);
        d.Y(l.d);
        if (z2) {
            d.l(i2);
        }
        d.g(h0.Q, i6);
        d.Y(l.c);
        int i3 = 46;
        int i7 = 44;
        if (l.a == i7) {
            d.m(i7, i3);
        } else {
            d.m(i3, i7);
        }
        i = 0;
        d.i(h0.U, i, 9, i);
        while (i < 5) {
            d.L();
            i++;
        }
    }

    private static net.time4j.g1.z.c<g0> b(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.H, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        int i = 45;
        if (z) {
            dVar.l(i);
        }
        int i4 = 2;
        dVar.g(g0.L, i4);
        if (z) {
            dVar.l(i);
        }
        dVar.g(g0.M, i4);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }

    private static net.time4j.g1.z.c<g0> c(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z), l.d(z));
        return dVar.F().T(g.STRICT);
    }

    private static net.time4j.g1.z.d<g0> d(boolean z) {
        l.b bVar = new l.b(z);
        return bVar;
    }

    private static net.time4j.g1.z.e<g0> e(boolean z) {
        l.a aVar = new l.a(z);
        return aVar;
    }

    private static net.time4j.g1.z.c<b0> f(e e, boolean z2) {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z2), l.d(z2));
        dVar.l('T');
        l.a(dVar, z2);
        dVar.C(e, z2, Collections.singletonList("Z"));
        return dVar.F();
    }

    private static net.time4j.g1.z.c<b0> g(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ROOT);
        dVar.d(b0.V().E(), l.f(e.MEDIUM, z), l.f(e.SHORT, z));
        return dVar.F().T(g.STRICT).V(p.C);
    }

    private static net.time4j.g1.z.c<g0> h(boolean z) {
        int obj5;
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.H, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        if (z != 0) {
            dVar.l('-');
        }
        dVar.g(g0.O, 3);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }

    public static g0 i(java.lang.CharSequence charSequence) {
        boolean z;
        s sVar = new s();
        g0 g0Var = l.j(charSequence, sVar);
        if (g0Var == null) {
        } else {
            if (sVar.i()) {
            } else {
                if (sVar.f() < charSequence.length()) {
                } else {
                    return g0Var;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Trailing characters found: ");
                stringBuilder.append(charSequence);
                ParseException parseException = new ParseException(stringBuilder.toString(), sVar.f());
                throw parseException;
            }
        }
        ParseException obj4 = new ParseException(sVar.d(), sVar.c());
        throw obj4;
    }

    public static g0 j(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2) {
        net.time4j.g1.z.c cVar2;
        net.time4j.g1.z.c cVar;
        int i4;
        int i3;
        int i;
        int i5;
        int i6;
        char charAt;
        int i2;
        int length = charSequence.length();
        int i9 = s2.f();
        if (length - i9 < 7) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Too short to be compatible with ISO-8601: ");
            stringBuilder.append(charSequence.subSequence(i9, length));
            s2.k(length, stringBuilder.toString());
            return null;
        }
        i = i9 + 1;
        i5 = 0;
        i6 = 45;
        while (i < length) {
            charAt = charSequence.charAt(i);
            i5++;
            i++;
            i6 = 45;
        }
        if (i5 == 0) {
            char charAt2 = charSequence.charAt(i9);
            if (charAt2 != 43) {
                if (charAt2 == i6) {
                    i3 += -2;
                }
            } else {
            }
            cVar = i3 == 3 ? l.h : l.f;
            return (g0)cVar.E(charSequence, s2);
        }
        if (i5 == 1) {
            return (g0)l.i.E(charSequence, s2);
        }
        return (g0)l.g.E(charSequence, s2);
    }

    private static net.time4j.g1.z.c<h0> k(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(h0.class, Locale.ROOT);
        dVar.W(l.e, 1);
        l.a(dVar, z);
        return dVar.F().T(g.STRICT);
    }

    private static net.time4j.g1.z.c<i0> l(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(i0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z), l.d(z));
        dVar.l('T');
        l.a(dVar, z);
        return dVar.F().T(g.STRICT);
    }

    private static net.time4j.g1.z.c<g0> m(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.I, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        int i = 45;
        if (z) {
            dVar.l(i);
        }
        dVar.l('W');
        dVar.g(z0.D.n(), 2);
        if (z) {
            dVar.l(i);
        }
        dVar.h(g0.N, 1);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }
}
