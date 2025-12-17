package net.time4j.history;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.ChronoException;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.d;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;
import net.time4j.history.q.a;

/* loaded from: classes3.dex */
final class k extends d<net.time4j.history.j> implements t<net.time4j.history.j> {

    private static final Locale b = null;
    private static final long serialVersionUID = 5200533417265981438L;
    private final net.time4j.history.d history;

    private static class a implements y<C, net.time4j.history.j> {

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

        public net.time4j.history.j e(C c) {
            net.time4j.history.j obj2;
            if (g(c) == j.BC) {
                obj2 = j.AD;
            }
            return obj2;
        }

        public net.time4j.history.j f(C c) {
            net.time4j.history.j obj2;
            if (g(c) == j.AD) {
                obj2 = j.BC;
            }
            return obj2;
        }

        public net.time4j.history.j g(C c) {
            try {
                return this.a.e((g0)c.p(g0.G)).e();
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

        public boolean h(C c, net.time4j.history.j j2) {
            int i;
            if (j2 == null) {
                return 0;
            }
            if (this.a.e((g0)c.p(g0.G)).e() == j2) {
                i = 1;
            }
            try {
                return i;
            }
        }

        public C i(C c, net.time4j.history.j j2, boolean z3) {
            if (j2 == null) {
            } else {
                if (this.a.e((g0)c.p(g0.G)).e() != j2) {
                } else {
                    return c;
                }
                IllegalArgumentException obj2 = new IllegalArgumentException(j2.name());
                throw obj2;
            }
            obj2 = new IllegalArgumentException("Missing era value.");
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((q)object, (j)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            i((q)object, (j)object2, z3);
            return object;
        }
    }
    static {
        Locale locale = new Locale("la");
        k.b = locale;
    }

    k(net.time4j.history.d d) {
        super("ERA");
        this.history = d;
    }

    private s k(d d) {
        String str;
        final v wIDE = v.WIDE;
        Object obj = d.a(a.g, wIDE);
        final Boolean fALSE = Boolean.FALSE;
        str = "w";
        final String str4 = "a";
        final int i = 0;
        final int i2 = 1;
        if ((Boolean)d.a(a.c, fALSE).booleanValue()) {
            String[] strArr = new String[i2];
            if ((v)obj == wIDE) {
            } else {
                str = str4;
            }
            strArr[i] = str;
            return b.c("historic", k.b).o(this, strArr);
        }
        b bVar = b.d((Locale)d.a(a.c, Locale.ROOT));
        if ((Boolean)d.a(a.b, fALSE).booleanValue()) {
            String[] obj10 = new String[2];
            if ((v)obj == wIDE) {
            } else {
                str = str4;
            }
            obj10[i] = str;
            obj10[i2] = "alt";
            return bVar.o(this, obj10);
        }
        return bVar.b((v)obj);
    }

    private Object readResolve() {
        return this.history.i();
    }

    protected <T extends q<T>> y<T, net.time4j.history.j> d(w<T> w) {
        if (w.w(g0.G)) {
            k.a obj2 = new k.a(this.history);
            return obj2;
        }
        return 0;
    }

    protected boolean e(e<?> e) {
        return this.history.equals(e.history);
    }

    @Override // net.time4j.g1.d
    public Object getDefaultMaximum() {
        return l();
    }

    @Override // net.time4j.g1.d
    public Object getDefaultMinimum() {
        return n();
    }

    @Override // net.time4j.g1.d
    public char getSymbol() {
        return 71;
    }

    public Class<net.time4j.history.j> getType() {
        return j.class;
    }

    @Override // net.time4j.g1.d
    public boolean isDateElement() {
        return 1;
    }

    @Override // net.time4j.g1.d
    public boolean isTimeElement() {
        return 0;
    }

    @Override // net.time4j.g1.d
    public net.time4j.history.j l() {
        return j.AD;
    }

    @Override // net.time4j.g1.d
    public net.time4j.history.j n() {
        return j.BC;
    }

    @Override // net.time4j.g1.d
    public net.time4j.history.j o(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return (j)k(d3).d(charSequence, parsePosition2, getType(), d3);
    }

    @Override // net.time4j.g1.d
    public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
        return o(charSequence, parsePosition2, d3);
    }

    @Override // net.time4j.g1.d
    public void print(o o, java.lang.Appendable appendable2, d d3) {
        appendable2.append(k(d3).g((Enum)o.p(this)));
    }
}
