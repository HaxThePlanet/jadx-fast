package net.time4j.history;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.ChronoException;
import net.time4j.engine.e;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g0;
import net.time4j.g1.b;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: HistoricEraElement.java */
/* loaded from: classes3.dex */
final class k extends net.time4j.g1.d<j> implements t<j> {

    private static final Locale b = null;
    private static final long serialVersionUID = 5200533417265981438L;
    private final d history;

    private static class a<C extends q<C>> implements y<C, j> {

        private final d a;
        a(d dVar) {
            super();
            this.a = dVar;
        }

        public p<?> b(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public p<?> d(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public j e(C c) {
            net.time4j.history.j aD2;
            if (g(c) == j.BC) {
                aD2 = j.AD;
            }
            return aD2;
        }

        public j f(C c) {
            net.time4j.history.j bC2;
            if (g(c) == j.AD) {
                bC2 = j.BC;
            }
            return bC2;
        }

        public j g(C c) throws ChronoException {
            try {
            } catch (java.lang.IllegalArgumentException iae) {
                throw new ChronoException(iae.getMessage(), iae);
            }
            return this.a.e((g0)c.p(g0.G)).e();
        }

        public boolean h(C c, j jVar) {
            if (jVar == null) {
                return false;
            }
            try {
            } catch (java.lang.IllegalArgumentException unused) {
                return z;
            }
            if (this.a.e((g0)c.p(g0.G)).e() == jVar) {
                int i = 1;
            }
        }

        public C i(C c, j jVar, boolean z) {
            if (jVar == null) {
                throw new IllegalArgumentException("Missing era value.");
            } else {
                if (this.a.e((g0)c.p(g0.G)).e() != jVar) {
                    throw new IllegalArgumentException(jVar.name());
                } else {
                    return c;
                }
            }
        }
    }
    static {
        k.b = new Locale("la");
    }

    k(d dVar) {
        super("ERA");
        this.history = dVar;
    }

    private s k(net.time4j.engine.d dVar) {
        String str;
        final v wIDE2 = v.WIDE;
        Object obj = dVar.a(a.g, wIDE2);
        final Boolean fALSE2 = Boolean.FALSE;
        str = "w";
        str = "a";
        final int i = 0;
        final int i2 = 1;
        if ((Boolean)dVar.a(a.c, fALSE2).booleanValue()) {
            String[] strArr = new String[i2];
            if (obj != v.WIDE) {
            }
            return b.c("historic", k.b).o(this, str);
        }
        b bVar = b.d((Locale)dVar.a(a.c, Locale.ROOT));
        if ((Boolean)dVar.a(a.b, Boolean.FALSE).booleanValue()) {
            String[] strArr2 = new String[2];
            if (obj != v.WIDE) {
            }
            return bVar.o(this, str, "alt");
        }
        return bVar.b(obj);
    }

    private Object readResolve() {
        return this.history.i();
    }

    @Override // net.time4j.g1.d
    protected <T extends q<T>> y<T, j> d(w<T> wVar) {
        if (wVar.w(g0.G)) {
            return new k.a(this.history);
        }
        return null;
    }

    @Override // net.time4j.g1.d
    protected boolean e(e<?> eVar) {
        return this.history.equals(eVar.history);
    }

    @Override // net.time4j.g1.d
    public Class<j> getType() {
        return j.class;
    }

    @Override // net.time4j.g1.d
    public j l() {
        return j.AD;
    }

    @Override // net.time4j.g1.d
    public j n() {
        return j.BC;
    }

    @Override // net.time4j.g1.d
    public j o(java.lang.CharSequence charSequence, ParsePosition parsePosition, net.time4j.engine.d dVar) {
        return (j)k(dVar).d(charSequence, parsePosition, getType(), dVar);
    }

    @Override // net.time4j.g1.d
    public void print(o oVar, java.lang.Appendable appendable, net.time4j.engine.d dVar) throws java.io.IOException {
        appendable.append(k(dVar).g((Enum)oVar.p(this)));
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return 71;
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return false;
    }
}
