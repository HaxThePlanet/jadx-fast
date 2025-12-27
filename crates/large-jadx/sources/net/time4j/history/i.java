package net.time4j.history;

import net.time4j.engine.ChronoException;
import net.time4j.engine.e;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g0;

/* compiled from: HistoricDateElement.java */
/* loaded from: classes3.dex */
final class i extends e<h> {

    private static final long serialVersionUID = -5386613740709845550L;
    private final d history;

    private static class a<C extends q<C>> implements y<C, h> {

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

        public h e(C c) {
            final int i5 = 31;
            if (this.a == d.K) {
                return h.k(j.BYZANTINE, 999984973, 8, i5);
            }
            int i7 = 12;
            if (this.a == d.J) {
                return h.k(j.AD, 999979465, i7, i5);
            }
            if (this.a == d.I) {
                return h.k(j.AD, 999999999, i7, i5);
            }
            return h.k(j.AD, 9999, i7, i5);
        }

        public h f(C c) {
            final int i5 = 1;
            if (this.a == d.K) {
                return h.k(j.BYZANTINE, 0, 9, i5);
            }
            if (this.a == d.J) {
                return h.k(j.BC, 999979466, i5, i5);
            }
            if (this.a == d.I) {
                return h.k(j.BC, 1000000000, i5, i5);
            }
            return h.k(j.BC, 45, i5, i5);
        }

        public h g(C c) throws ChronoException {
            try {
            } catch (java.lang.IllegalArgumentException iae) {
                throw new ChronoException(iae.getMessage(), iae);
            }
            return this.a.e((g0)c.p(g0.G));
        }

        public boolean h(C c, h hVar) {
            return this.a.B(hVar);
        }

        public C i(C c, h hVar, boolean z) {
            if (hVar == null) {
                throw new IllegalArgumentException("Missing historic date.");
            } else {
                return c.G(g0.G, this.a.d(hVar));
            }
        }
    }
    i(d dVar) {
        super("HISTORIC_DATE");
        this.history = dVar;
    }

    private Object readResolve() {
        return this.history.f();
    }

    @Override // net.time4j.engine.e
    protected <T extends q<T>> y<T, h> d(w<T> wVar) {
        if (wVar.w(g0.G)) {
            return new i.a(this.history);
        }
        return null;
    }

    @Override // net.time4j.engine.e
    protected boolean e(e<?> eVar) {
        return this.history.equals(eVar.history);
    }

    @Override // net.time4j.engine.e
    public Class<h> getType() {
        return h.class;
    }

    @Override // net.time4j.engine.e
    public h k() {
        return h.k(j.AD, 9999, 12, 31);
    }

    @Override // net.time4j.engine.e
    public h l() {
        final int i2 = 1;
        return h.k(j.BC, 45, i2, i2);
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return true;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return false;
    }
}
