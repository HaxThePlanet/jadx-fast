package net.time4j.g1.z;

import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;
import net.time4j.b0;
import net.time4j.engine.d;
import net.time4j.engine.f0;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.q;
import net.time4j.engine.s;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.e;
import net.time4j.g1.g;
import net.time4j.g1.j;
import net.time4j.h0;
import net.time4j.i0;
import net.time4j.z0;

/* compiled from: Iso8601Format.java */
/* loaded from: classes3.dex */
public class l {

    private static final char a = 44;
    private static final l.c b = new l$c();
    private static final l.c c = new l$c();
    private static final n<o> d;
    private static final n<Character> e = new l$d<>(0);
    public static final c<g0> f;
    public static final c<g0> g;
    public static final c<g0> h;
    public static final c<g0> i;
    public static final c<g0> j;
    public static final c<g0> k;
    public static final c<g0> l;

    static class a implements e<g0> {

        final /* synthetic */ boolean a;
        a(boolean z) {
            this.a = z;
            super();
        }

        public <R> R b(g0 g0Var, java.lang.Appendable appendable, d dVar, s<o, R> sVar) {
            net.time4j.g1.z.c cVar;
            sVar = this.a ? l.g : l.f;
            (this.a ? l.g : l.f).J(g0Var, appendable, dVar);
            return null;
        }
    }

    static class b implements d<g0> {

        final /* synthetic */ boolean a;
        b(boolean z) {
            this.a = z;
            super();
        }

        public g0 a(java.lang.CharSequence charSequence, s sVar, d dVar) {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            char c = 45;
            char charAt;
            char c2;
            int length = charSequence.length();
            int i5 = sVar.f();
            i = length - i5;
            i3 = i5 + 1;
            i4 = 0;
            c = '-';
            while (i3 < length) {
                charAt = charSequence.charAt(i3);
                if (charAt != c) {
                    c2 = '/';
                }
            }
            if (this.a && i4 == 1) {
                return (g0)l.i.E(charSequence, sVar);
            }
            i2 = i - 4;
            char charAt2 = charSequence.charAt(i5);
            int r1 = charAt2 == 43 || charAt2 == c ? i - 4 - 2 : i2 - 2;
            if (i2 == 3) {
                return (g0)l.h.E(charSequence, sVar);
            }
            return (g0)l.f.E(charSequence, sVar);
        }
    }

    private static class c implements n<o> {

        private final net.time4j.engine.p<Integer> a;
        c(net.time4j.engine.p<Integer> pVar) {
            super();
            this.a = pVar;
        }

        n<o> a(l.c cVar) {
            return new l.c.a(this, cVar);
        }

        public boolean b(o oVar) {
            boolean z = true;
            oVar = oVar.e(this.a) > 0 ? 1 : 0;
            return (oVar.e(this.a) > 0 ? 1 : 0);
        }
    }

    private static class d implements n<Character> {
        private d() {
            super();
        }

        public boolean a(Character character) {
            boolean z = true;
            character = character.charValue() == 84 ? 1 : 0;
            return (character.charValue() == 84 ? 1 : 0);
        }

        /* synthetic */ d(l.a aVar) {
            this();
        }
    }
    static {
        int r0 = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
    }

    private static <T extends q<T>> void a(c.d<T> dVar, boolean z) {
        int i = 0;
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        int i4 = 2;
        dVar.g(h0.N, i4);
        dVar.X();
        char c = ':';
        if (z) {
            dVar.l(c);
        }
        dVar.g(h0.O, i4);
        dVar.Y(l.d);
        if (z) {
            dVar.l(c);
        }
        dVar.g(h0.Q, i4);
        dVar.Y(l.c);
        char c2 = '.';
        char c3 = ',';
        if (l.a == c3) {
            dVar.m(c3, '.');
        } else {
            dVar.m('.', c3);
        }
        i = 0;
        dVar.i(h0.U, i, 9, false);
        net.time4j.l0 l0Var = 5;
        while (j.ARABIC < 5) {
            dVar.L();
            i = i + 1;
            l0Var = 5;
        }
    }

    private static c<g0> b(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.H, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        char c = '-';
        if (z) {
            dVar.l(c);
        }
        int i3 = 2;
        dVar.g(g0.L, i3);
        if (z) {
            dVar.l(c);
        }
        dVar.g(g0.M, i3);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }

    private static c<g0> c(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z), l.d(z));
        return dVar.F().T(g.STRICT);
    }

    private static d<g0> d(boolean z) {
        return new l.b(z);
    }

    private static e<g0> e(boolean z) {
        return new l.a(z);
    }

    private static c<b0> f(e eVar, boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z), l.d(z));
        dVar.l('T');
        l.a(dVar, z);
        dVar.C(eVar, z, Collections.singletonList("Z"));
        return dVar.F();
    }

    private static c<b0> g(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ROOT);
        dVar.d(b0.V().E(), l.f(e.MEDIUM, z), l.f(e.SHORT, z));
        return dVar.F().T(g.STRICT).V(p.C);
    }

    private static c<g0> h(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.H, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        if (z) {
            char c = '-';
            dVar.l(c);
        }
        dVar.g(g0.O, 3);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }

    public static g0 i(java.lang.CharSequence charSequence) throws ParseException {
        net.time4j.g1.z.s sVar = new s();
        g0 g0Var = l.j(charSequence, sVar);
        if (g0Var == null) {
            throw new ParseException(sVar.d(), sVar.c());
        } else {
            if (!sVar.i()) {
                if (sVar.f() < charSequence.length()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str2 = "Trailing characters found: ";
                    charSequence = str2 + charSequence;
                    throw new ParseException(charSequence, sVar.f());
                } else {
                    return g0Var;
                }
            }
        }
    }

    public static g0 j(java.lang.CharSequence charSequence, s sVar) {
        net.time4j.g1.z.c cVar;
        net.time4j.g1.z.c cVar2;
        int i;
        int i2;
        int i3;
        int i4 = 0;
        char c = 45;
        char charAt;
        char c2;
        int length = charSequence.length();
        int i7 = sVar.f();
        i = length - i7;
        if (length - i7 < 7) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Too short to be compatible with ISO-8601: ";
            java.lang.CharSequence subSequence = charSequence.subSequence(i7, length);
            str2 = str + subSequence;
            sVar.k(length, str2);
            return null;
        }
        i3 = i7 + 1;
        i4 = 0;
        c = '-';
        while (i3 < length) {
            charAt = charSequence.charAt(i3);
            if (charAt != c) {
                c2 = '/';
            }
        }
        if (i4 == 0) {
            i2 = i - 4;
            char charAt2 = charSequence.charAt(i7);
            int r2 = charAt2 == 43 || charAt2 == c ? i - 4 - 2 : i2 - 2;
            net.time4j.g1.z.c r0 = i2 == 3 ? l.h : l.f;
            return (g0)(i2 == 3 ? l.h : l.f).E(charSequence, sVar);
        }
        if (i4 == 1) {
            return (g0)l.i.E(charSequence, sVar);
        }
        return (g0)l.g.E(charSequence, sVar);
    }

    private static c<h0> k(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(h0.class, Locale.ROOT);
        dVar.W(l.e, 1);
        l.a(dVar, z);
        return dVar.F().T(g.STRICT);
    }

    private static c<i0> l(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(i0.class, Locale.ROOT);
        dVar.d(g0.G, l.e(z), l.d(z));
        dVar.l('T');
        l.a(dVar, z);
        return dVar.F().T(g.STRICT);
    }

    private static c<g0> m(boolean z) {
        net.time4j.g1.z.c.d dVar = c.N(g0.class, Locale.ROOT);
        dVar.b0(a.l, j.ARABIC);
        dVar.Z(a.m, '0');
        dVar.k(g0.I, 4, 9, x.SHOW_WHEN_BIG_NUMBER);
        char c = '-';
        if (z) {
            dVar.l(c);
        }
        dVar.l('W');
        dVar.g(z0.D.n(), 2);
        if (z) {
            dVar.l(c);
        }
        dVar.h(g0.N, 1);
        dVar.L();
        dVar.L();
        return dVar.F().T(g.STRICT);
    }
}
