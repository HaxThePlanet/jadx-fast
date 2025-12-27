package net.time4j.calendar;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.i;
import net.time4j.engine.i0;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.f;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: KoreanEra.java */
/* loaded from: classes3.dex */
public enum k implements i {

    DANGI;

    private final transient p<k> eraElement = new k$b<>(0);
    private final transient p<Integer> yearOfEraElement = new k$e<>(0);

    static class a {
    }

    private static class c implements y<q<?>, k> {
        private c() {
            super();
        }

        public p<?> b(q<?> qVar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public p<?> d(q<?> qVar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public k e(q<?> qVar) {
            return k.DANGI;
        }

        public k f(q<?> qVar) {
            return k.DANGI;
        }

        public k g(q<?> qVar) {
            return k.DANGI;
        }

        public boolean h(q<?> qVar, k kVar) {
            boolean z = true;
            qVar = kVar == k.DANGI ? 1 : 0;
            return (kVar == k.DANGI ? 1 : 0);
        }

        public q<?> i(q<?> qVar, k kVar, boolean z) {
            if (!h(qVar, kVar)) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Invalid Korean era: ";
                kVar = str + kVar;
                throw new IllegalArgumentException(kVar);
            } else {
                return qVar;
            }
        }

        /* synthetic */ c(k.a aVar) {
            this();
        }
    }

    private static class d implements y<q<?>, Integer> {
        private d() {
            super();
        }

        private int e(q<?> qVar) {
            return (g0)qVar.p(g0.G).m() + 2333;
        }

        public p<?> b(q<?> qVar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public p<?> d(q<?> qVar) throws java.lang.AbstractMethodError {
            throw new AbstractMethodError("Never called.");
        }

        public Integer f(q<?> qVar) {
            return 1000002332;
        }

        public Integer g(q<?> qVar) {
            return -999997666;
        }

        public Integer h(q<?> qVar) {
            return Integer.valueOf(e(qVar));
        }

        public boolean i(q<?> qVar, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            if (integer.intValue() >= g(qVar).intValue() && integer.intValue() <= f(qVar).intValue()) {
                int i = 1;
            }
            return z;
        }

        public q<?> j(q<?> qVar, Integer integer, boolean z) {
            if (integer == null) {
                throw new IllegalArgumentException("Missing year of era.");
            } else {
                if (!i(qVar, integer)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid year of era: ";
                    integer = str + integer;
                    throw new IllegalArgumentException(integer);
                } else {
                    int i2 = e(qVar);
                    net.time4j.e eVar = g0.G;
                    return qVar.G(eVar, (g0)(g0)qVar.p(eVar).M((long)(integer.intValue() - i2), f.YEARS));
                }
            }
        }

        /* synthetic */ d(k.a aVar) {
            this();
        }
    }

    private static class b extends net.time4j.g1.d<k> implements t<k> {

        private static final long serialVersionUID = -5179188137244162427L;
        /* synthetic */ b(k.a aVar) {
            this();
        }

        private Object readResolve() {
            return k.DANGI.era();
        }

        @Override // net.time4j.g1.d
        protected <T extends q<T>> y<T, k> d(w<T> wVar) {
            net.time4j.calendar.k.a aVar = null;
            if (wVar.w(g0.G)) {
                return new k.c(aVar);
            }
            return aVar;
        }

        @Override // net.time4j.g1.d
        public Class<k> getType() {
            return k.class;
        }

        @Override // net.time4j.g1.d
        public k k() {
            return k.DANGI;
        }

        @Override // net.time4j.g1.d
        public k l() {
            return k.DANGI;
        }

        @Override // net.time4j.g1.d
        public k n(java.lang.CharSequence charSequence, ParsePosition parsePosition, net.time4j.engine.d dVar) {
            String charSequence2;
            String displayName;
            Object obj = dVar.a(a.c, Locale.ROOT);
            int index = parsePosition.getIndex();
            net.time4j.calendar.k dANGI2 = k.DANGI;
            displayName = dANGI2.getDisplayName(obj, (v)dVar.a(a.g, v.WIDE));
            int max = Math.max(Math.min(displayName.length() + index, charSequence.length()), index);
            if (max > index) {
                if ((Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue()) {
                    displayName = displayName.toLowerCase(obj);
                    charSequence2 = charSequence.subSequence(index, max).toString().toLowerCase(obj);
                }
                parsePosition.setIndex(max);
                return k.DANGI;
            }
            parsePosition.setErrorIndex(index);
            return null;
        }

        @Override // net.time4j.g1.d
        public void print(o oVar, java.lang.Appendable appendable, net.time4j.engine.d dVar) throws java.io.IOException {
            appendable.append(k.DANGI.getDisplayName((Locale)dVar.a(a.c, Locale.ROOT), (v)dVar.a(a.g, v.WIDE)));
        }

        private b() {
            super("ERA");
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

        @Override // net.time4j.g1.d
        protected boolean j() {
            return true;
        }
    }

    private static class e extends net.time4j.g1.d<Integer> {

        private static final long serialVersionUID = -7864513245908399367L;
        /* synthetic */ e(k.a aVar) {
            this();
        }

        private Object readResolve() {
            return k.DANGI.yearOfEra();
        }

        @Override // net.time4j.g1.d
        protected <T extends q<T>> y<T, Integer> d(w<T> wVar) {
            net.time4j.calendar.k.a aVar = null;
            aVar = null;
            if (wVar.w(g0.G)) {
            }
            return aVar;
        }

        @Override // net.time4j.g1.d
        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // net.time4j.g1.d
        public Integer k() {
            return 5332;
        }

        @Override // net.time4j.g1.d
        public Integer l() {
            return 3978;
        }

        private e() {
            super("YEAR_OF_ERA");
        }

        @Override // net.time4j.g1.d
        public char getSymbol() {
            return 121;
        }

        @Override // net.time4j.g1.d
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.g1.d
        public boolean isTimeElement() {
            return false;
        }

        @Override // net.time4j.g1.d
        protected boolean j() {
            return true;
        }
    }
    @Override // java.lang.Enum
    p<k> era() {
        return this.eraElement;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE);
    }

    @Override // java.lang.Enum
    p<Integer> yearOfEra() {
        return this.yearOfEraElement;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v vVar) {
        return b.c("dangi", locale).b(vVar).g(this);
    }
}
