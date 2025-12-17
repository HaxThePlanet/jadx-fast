package net.time4j.history;

import net.time4j.engine.ChronoException;
import net.time4j.engine.e;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g0;

/* loaded from: classes3.dex */
final class i extends e<net.time4j.history.h> {

    private static final long serialVersionUID = -5386613740709845550L;
    private final net.time4j.history.d history;

    private static class a implements y<C, net.time4j.history.h> {

        private final net.time4j.history.d a;
        a(net.time4j.history.d d) {
            super();
            this.a = d;
        }

        public p<?> b(C c) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Never called.");
            throw obj2;
        }

        public p<?> d(C c) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Never called.");
            throw obj2;
        }

        public net.time4j.history.h e(C c) {
            net.time4j.history.d obj4 = this.a;
            final int i5 = 31;
            if (obj4 == d.K) {
                return h.k(j.BYZANTINE, 999984973, 8, i5);
            }
            int i7 = 12;
            if (obj4 == d.J) {
                return h.k(j.AD, 999979465, i7, i5);
            }
            if (obj4 == d.I) {
                return h.k(j.AD, 999999999, i7, i5);
            }
            return h.k(j.AD, 9999, i7, i5);
        }

        public net.time4j.history.h f(C c) {
            net.time4j.history.d obj4 = this.a;
            final int i5 = 1;
            if (obj4 == d.K) {
                return h.k(j.BYZANTINE, 0, 9, i5);
            }
            if (obj4 == d.J) {
                return h.k(j.BC, 999979466, i5, i5);
            }
            if (obj4 == d.I) {
                return h.k(j.BC, 1000000000, i5, i5);
            }
            return h.k(j.BC, 45, i5, i5);
        }

        public net.time4j.history.h g(C c) {
            try {
                return this.a.e((g0)c.p(g0.G));
                ChronoException chronoException = new ChronoException(c.getMessage(), c);
                throw chronoException;
            }
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            b((q)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            d((q)object);
            throw 0;
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return g((q)object);
        }

        public boolean h(C c, net.time4j.history.h h2) {
            return this.a.B(h2);
        }

        public C i(C c, net.time4j.history.h h2, boolean z3) {
            if (h2 == null) {
            } else {
                return c.G(g0.G, this.a.d(h2));
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("Missing historic date.");
            throw obj1;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((q)object, (h)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return i((q)object, (h)object2, z3);
        }
    }
    i(net.time4j.history.d d) {
        super("HISTORIC_DATE");
        this.history = d;
    }

    private Object readResolve() {
        return this.history.f();
    }

    protected <T extends q<T>> y<T, net.time4j.history.h> d(w<T> w) {
        if (w.w(g0.G)) {
            i.a obj2 = new i.a(this.history);
            return obj2;
        }
        return 0;
    }

    protected boolean e(e<?> e) {
        return this.history.equals(e.history);
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMaximum() {
        return k();
    }

    @Override // net.time4j.engine.e
    public Object getDefaultMinimum() {
        return l();
    }

    public Class<net.time4j.history.h> getType() {
        return h.class;
    }

    @Override // net.time4j.engine.e
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.engine.e
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.engine.e
    public net.time4j.history.h k() {
        return h.k(j.AD, 9999, 12, 31);
    }

    @Override // net.time4j.engine.e
    public net.time4j.history.h l() {
        final int i2 = 1;
        return h.k(j.BC, 45, i2, i2);
    }
}
