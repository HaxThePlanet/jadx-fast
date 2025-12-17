package net.time4j.calendar;

import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.d;
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
import net.time4j.g1.d;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public enum k implements i {

    DANGI;

    private final transient p<net.time4j.calendar.k> eraElement;
    private final transient p<Integer> yearOfEraElement;

    static class a {
    }

    private static class c implements y<q<?>, net.time4j.calendar.k> {
        c(net.time4j.calendar.k.a k$a) {
            super();
        }

        public p<?> b(q<?> q) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public p<?> d(q<?> q) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public net.time4j.calendar.k e(q<?> q) {
            return k.DANGI;
        }

        public net.time4j.calendar.k f(q<?> q) {
            return k.DANGI;
        }

        public net.time4j.calendar.k g(q<?> q) {
            return k.DANGI;
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

        public boolean h(q<?> q, net.time4j.calendar.k k2) {
            int obj1;
            obj1 = k2 == k.DANGI ? 1 : 0;
            return obj1;
        }

        public q<?> i(q<?> q, net.time4j.calendar.k k2, boolean z3) {
            if (!h(q, k2)) {
            } else {
                return q;
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Invalid Korean era: ");
            obj4.append(k2);
            IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
            throw obj2;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return h((q)object, (k)object2);
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            i((q)object, (k)object2, z3);
            return object;
        }
    }

    private static class d implements y<q<?>, Integer> {
        d(net.time4j.calendar.k.a k$a) {
            super();
        }

        private int e(q<?> q) {
            return obj2 += 2333;
        }

        public p<?> b(q<?> q) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public p<?> d(q<?> q) {
            AbstractMethodError obj2 = new AbstractMethodError("Never called.");
            throw obj2;
        }

        public Integer f(q<?> q) {
            return 1000002332;
        }

        public Integer g(q<?> q) {
            return -999997666;
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
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return g((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return h((q)object);
        }

        public Integer h(q<?> q) {
            return Integer.valueOf(e(q));
        }

        public boolean i(q<?> q, Integer integer2) {
            int i;
            int obj5;
            if (integer2 == 0) {
                return 0;
            }
            if (integer2.intValue() >= g(q).intValue() && integer2.intValue() <= f(q).intValue()) {
                if (integer2.intValue() <= f(q).intValue()) {
                    i = 1;
                }
            }
            return i;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((q)object, (Integer)object2);
        }

        public q<?> j(q<?> q, Integer integer2, boolean z3) {
            if (integer2 == null) {
            } else {
                if (!i(q, integer2)) {
                } else {
                    int obj6 = e(q);
                    net.time4j.e eVar = g0.G;
                    return q.G(eVar, (g0)(g0)q.p(eVar).M((long)obj5, obj6));
                }
                obj6 = new StringBuilder();
                obj6.append("Invalid year of era: ");
                obj6.append(integer2);
                IllegalArgumentException obj4 = new IllegalArgumentException(obj6.toString());
                throw obj4;
            }
            obj4 = new IllegalArgumentException("Missing year of era.");
            throw obj4;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return j((q)object, (Integer)object2, z3);
        }
    }

    private static class b extends d<net.time4j.calendar.k> implements t<net.time4j.calendar.k> {

        private static final long serialVersionUID = -5179188137244162427L;
        private b() {
            super("ERA");
        }

        b(net.time4j.calendar.k.a k$a) {
            super();
        }

        private Object readResolve() {
            return k.DANGI.era();
        }

        protected <T extends q<T>> y<T, net.time4j.calendar.k> d(w<T> w) {
            int i = 0;
            if (w.w(g0.G)) {
                k.c obj2 = new k.c(i);
                return obj2;
            }
            return i;
        }

        @Override // net.time4j.g1.d
        public Object getDefaultMaximum() {
            return k();
        }

        @Override // net.time4j.g1.d
        public Object getDefaultMinimum() {
            return l();
        }

        @Override // net.time4j.g1.d
        public char getSymbol() {
            return 71;
        }

        public Class<net.time4j.calendar.k> getType() {
            return k.class;
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
        protected boolean j() {
            return 1;
        }

        @Override // net.time4j.g1.d
        public net.time4j.calendar.k k() {
            return k.DANGI;
        }

        @Override // net.time4j.g1.d
        public net.time4j.calendar.k l() {
            return k.DANGI;
        }

        @Override // net.time4j.g1.d
        public net.time4j.calendar.k n(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            Object equals;
            String obj8;
            String obj10;
            equals = d3.a(a.c, Locale.ROOT);
            int index = parsePosition2.getIndex();
            net.time4j.calendar.k dANGI = k.DANGI;
            obj10 = dANGI.getDisplayName((Locale)equals, (v)d3.a(a.g, v.WIDE));
            int i3 = Math.max(Math.min(length += index, charSequence.length()), index);
            if (i3 > index && (Boolean)d3.a(a.i, Boolean.TRUE).booleanValue()) {
                if ((Boolean)d3.a(a.i, Boolean.TRUE).booleanValue()) {
                    obj10 = obj10.toLowerCase(equals);
                    obj8 = charSequence.subSequence(index, i3).toString().toLowerCase(equals);
                }
                if (!obj10.equals(obj8) && (Boolean)d3.a(a.j, Boolean.FALSE).booleanValue() && obj10.startsWith(obj8)) {
                    if ((Boolean)d3.a(a.j, Boolean.FALSE).booleanValue()) {
                        if (obj10.startsWith(obj8)) {
                        }
                    }
                }
                parsePosition2.setIndex(i3);
                return dANGI;
            }
            parsePosition2.setErrorIndex(index);
            return null;
        }

        @Override // net.time4j.g1.d
        public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            return n(charSequence, parsePosition2, d3);
        }

        @Override // net.time4j.g1.d
        public void print(o o, java.lang.Appendable appendable2, d d3) {
            appendable2.append(k.DANGI.getDisplayName((Locale)d3.a(a.c, Locale.ROOT), (v)d3.a(a.g, v.WIDE)));
        }
    }

    private static class e extends d<Integer> {

        private static final long serialVersionUID = -7864513245908399367L;
        private e() {
            super("YEAR_OF_ERA");
        }

        e(net.time4j.calendar.k.a k$a) {
            super();
        }

        private Object readResolve() {
            return k.DANGI.yearOfEra();
        }

        protected <T extends q<T>> y<T, Integer> d(w<T> w) {
            int i;
            boolean obj2;
            if (w.w(g0.G)) {
                obj2 = new k.d(0);
                i = obj2;
            }
            return i;
        }

        @Override // net.time4j.g1.d
        public Object getDefaultMaximum() {
            return k();
        }

        @Override // net.time4j.g1.d
        public Object getDefaultMinimum() {
            return l();
        }

        @Override // net.time4j.g1.d
        public char getSymbol() {
            return 121;
        }

        public Class<Integer> getType() {
            return Integer.class;
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
        protected boolean j() {
            return 1;
        }

        @Override // net.time4j.g1.d
        public Integer k() {
            return 5332;
        }

        @Override // net.time4j.g1.d
        public Integer l() {
            return 3978;
        }
    }
    p<net.time4j.calendar.k> era() {
        return this.eraElement;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, v.WIDE);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale, v v2) {
        return b.c("dangi", locale).b(v2).g(this);
    }

    p<Integer> yearOfEra() {
        return this.yearOfEraElement;
    }
}
