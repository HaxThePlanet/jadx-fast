package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.engine.d;
import net.time4j.engine.e;
import net.time4j.engine.f0;
import net.time4j.engine.k;
import net.time4j.engine.m;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.engine.y;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.g1.l;
import net.time4j.g1.m;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;
import net.time4j.g1.y;

/* loaded from: classes3.dex */
public final class z0 implements Serializable {

    private static final Map<Locale, net.time4j.z0> C = null;
    public static final net.time4j.z0 D = null;
    private static final y E = null;
    private static final long serialVersionUID = 7794495882610436763L;
    private final transient net.time4j.d0<net.time4j.x0> A;
    private final transient Set<p<?>> B;
    private final transient net.time4j.x0 a;
    private final transient int b;
    private final transient net.time4j.x0 c;
    private final transient net.time4j.x0 v;
    private final transient net.time4j.c<Integer, net.time4j.g0> w;
    private final transient net.time4j.c<Integer, net.time4j.g0> x;
    private final transient net.time4j.c<Integer, net.time4j.g0> y;
    private final transient net.time4j.c<Integer, net.time4j.g0> z;

    class a implements n<a> {
    }

    private static class b implements y<T, Integer> {

        private final net.time4j.z0.d a;
        private b(net.time4j.z0.d z0$d) {
            super();
            this.a = d;
        }

        b(net.time4j.z0.d z0$d, net.time4j.z0.a z0$a2) {
            super(d);
        }

        private p<?> b(T t, boolean z2) {
            q obj4;
            int obj5;
            Object obj = t.p(g0.F);
            net.time4j.d0 d0Var = z0.d.l(this.a).i();
            int intValue = k(t).intValue();
            if (z2) {
                obj5 = z0.d.n(this.a) ? 52 : 4;
                if (intValue >= obj5) {
                    obj4 = (g0)obj.G(d0Var, t.r(d0Var));
                    if (z0.d.n(this.a)) {
                        if ((g0)obj4.D0() < obj.D0()) {
                            return g0.O;
                        }
                    } else {
                        if (obj4.q() < obj.q()) {
                            return g0.M;
                        }
                    }
                }
            } else {
                if (intValue <= 1) {
                    obj4 = obj.G(d0Var, t.w(d0Var));
                    if (z0.d.n(this.a)) {
                        if ((g0)obj4.D0() > obj.D0()) {
                            return g0.O;
                        }
                    } else {
                        if (obj4.q() > obj.q()) {
                            return g0.M;
                        }
                    }
                }
            }
            return d0Var;
        }

        private int f(net.time4j.g0 g0) {
            int obj2;
            if (z0.d.n(this.a)) {
                obj2 = b.e(g0.m()) ? 366 : 365;
                return obj2;
            }
            return b.d(g0.m(), g0.o());
        }

        private int g(net.time4j.g0 g0) {
            return m(g0, 1);
        }

        private int i(net.time4j.g0 g0) {
            return m(g0, -1);
        }

        private int l(net.time4j.g0 g0) {
            return m(g0, 0);
        }

        private int m(net.time4j.g0 g0, int i2) {
            int i;
            int i3;
            if (z0.d.n(this.a)) {
                i = g0.D0();
            } else {
                i = g0.q();
            }
            int value = z0.c(i5 += i10).getValue(z0.d.l(this.a));
            i3 = value <= i7 - 8 ? value - 2 : value - 9;
            int i11 = 1;
            if (i2 != -1) {
                if (i2 != 0) {
                    if (i2 != i11) {
                    } else {
                        i = f(g0);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unexpected: ");
                    stringBuilder.append(i2);
                    AssertionError obj6 = new AssertionError(stringBuilder.toString());
                    throw obj6;
                }
            } else {
                i = i11;
            }
            return obj6 += i11;
        }

        private net.time4j.g0 o(net.time4j.g0 g0, int i2) {
            int i = l(g0);
            if (i2 == i) {
                return g0;
            }
            return g0.V0(l += l2);
        }

        public p<?> d(T t) {
            return b(t, true);
        }

        public p<?> e(T t) {
            return b(t, false);
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return h((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return j((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return k((q)object);
        }

        public Integer h(T t) {
            return Integer.valueOf(g((g0)t.p(g0.F)));
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return n((q)object, (Integer)object2);
        }

        public Integer j(T t) {
            return Integer.valueOf(i((g0)t.p(g0.F)));
        }

        public Integer k(T t) {
            return Integer.valueOf(l((g0)t.p(g0.F)));
        }

        public boolean n(T t, Integer integer2) {
            int i;
            Object obj3;
            if (integer2 == null) {
                return 0;
            }
            final int obj4 = integer2.intValue();
            obj3 = t.p(g0.F);
            if (obj4 >= i((g0)obj3) && obj4 <= g(obj3)) {
                if (obj4 <= g(obj3)) {
                    i = 1;
                }
            }
            return i;
        }

        public T p(T t, Integer integer2, boolean z3) {
            boolean obj5;
            p pVar = g0.F;
            if (integer2 == null) {
            } else {
                if (!z3) {
                    if (!n(t, integer2)) {
                    } else {
                    }
                }
                return t.G(pVar, o((g0)t.p(pVar), integer2.intValue()));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(integer2);
            stringBuilder.append(" (context=");
            stringBuilder.append(t);
            stringBuilder.append(")");
            obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return p((q)object, (Integer)object2, z3);
        }
    }

    private static class c implements y<T, Integer> {

        private final net.time4j.z0.d a;
        private c(net.time4j.z0.d z0$d) {
            super();
            this.a = d;
        }

        c(net.time4j.z0.d z0$d, net.time4j.z0.a z0$a2) {
            super(d);
        }

        private int b(net.time4j.g0 g0) {
            int i3;
            int i;
            int i2;
            int obj6;
            if (z0.d.n(this.a)) {
                i3 = g0.D0();
            } else {
                i3 = g0.q();
            }
            int i8 = 0;
            int i10 = g(g0, i8);
            i = 1;
            if (i10 <= i3) {
                i13 += i;
                if (i14 < 53) {
                    if (!z0.d.n(this.a) && i14 >= 5 && i15 += obj6 <= i3) {
                        if (i14 >= 5) {
                            if (i15 += obj6 <= i3) {
                            } else {
                                i = i14;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            int i9 = -1;
            return i6 += i;
        }

        private p<?> d() {
            return z0.d.l(this.a).i();
        }

        private int g(net.time4j.g0 g0, int i2) {
            int obj1;
            net.time4j.z0 obj2 = z0.d.l(this.a);
            obj1 = m(g0, i2).getValue(obj2);
            obj1 = obj1 <= obj2 - 8 ? obj1 - 2 : obj1 - 9;
            return obj1;
        }

        private int h(net.time4j.g0 g0, int i2) {
            int i;
            int obj2;
            int obj3;
            if (z0.d.n(this.a)) {
                obj2 = b.e(obj2 += i2) ? 366 : 365;
                return obj2;
            }
            i = g0.m();
            obj2 += i2;
            if (obj2 == null) {
                obj2 = 12;
                i--;
            } else {
                if (obj2 == 13) {
                    i++;
                    obj2 = 1;
                }
            }
            return b.d(i, obj2);
        }

        private int i(net.time4j.g0 g0) {
            int i4;
            int i2;
            int i;
            int i3;
            net.time4j.g0 obj6;
            if (z0.d.n(this.a)) {
                i4 = g0.D0();
            } else {
                i4 = g0.q();
            }
            int i6 = 0;
            i = g(g0, i6);
            final int i12 = 1;
            if (i <= i4 && i14 += i2 <= i4) {
                i12 = 1;
                if (i14 += i2 <= i4) {
                    i3 = i2 + obj6;
                    i = i4;
                }
                return i15 /= 7;
            }
            int i5 = -1;
            return i10 /= 7;
        }

        private net.time4j.x0 m(net.time4j.g0 g0, int i2) {
            int i;
            int obj3;
            int obj4;
            final int i3 = 1;
            if (z0.d.n(this.a)) {
                return x0.valueOf(b.c(obj3 += i2, i3, i3));
            }
            i = g0.m();
            obj3 += i2;
            if (obj3 == null) {
                obj3 = 12;
                i--;
            } else {
                if (obj3 == 13) {
                    i++;
                    obj3 = i3;
                } else {
                    if (obj3 == 14) {
                        obj3 = 2;
                        i++;
                    }
                }
            }
            return x0.valueOf(b.c(i, obj3, i3));
        }

        private net.time4j.g0 o(net.time4j.g0 g0, int i2) {
            int i = b(g0);
            if (i2 == i) {
                return g0;
            }
            return g0.V0(l += l2);
        }

        public p<?> e(T t) {
            return d();
        }

        public p<?> f(T t) {
            return d();
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return e((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return f((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMaximum(Object object) {
            return j((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getMinimum(Object object) {
            return k((q)object);
        }

        @Override // net.time4j.engine.y
        public Object getValue(Object object) {
            return l((q)object);
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return n((q)object, (Integer)object2);
        }

        public Integer j(T t) {
            return Integer.valueOf(i((g0)t.p(g0.F)));
        }

        public Integer k(T t) {
            return 1;
        }

        public Integer l(T t) {
            return Integer.valueOf(b((g0)t.p(g0.F)));
        }

        public boolean n(T t, Integer integer2) {
            int i;
            boolean z2;
            boolean z;
            Object obj4;
            i = 0;
            if (integer2 == null) {
                return i;
            }
            final int obj5 = integer2.intValue();
            final int i2 = 1;
            if (z0.d.n(this.a) && obj5 >= i2 && obj5 <= 52) {
                if (obj5 >= i2) {
                    if (obj5 <= 52) {
                        return i2;
                    }
                }
            }
            if (z0.d.n(this.a) && obj5 == 53) {
                if (obj5 == 53) {
                }
                return i;
            }
            if (obj5 >= i2 && obj5 <= i((g0)t.p(g0.F))) {
                if (obj5 <= i(obj4)) {
                    i = i2;
                }
            }
            return i;
        }

        public T p(T t, Integer integer2, boolean z3) {
            boolean obj5;
            p pVar = g0.F;
            if (integer2 == null) {
            } else {
                if (!z3) {
                    if (!n(t, integer2)) {
                    } else {
                    }
                }
                return t.G(pVar, o((g0)t.p(pVar), integer2.intValue()));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid value: ");
            stringBuilder.append(integer2);
            stringBuilder.append(" (context=");
            stringBuilder.append(t);
            stringBuilder.append(")");
            obj5 = new IllegalArgumentException(stringBuilder.toString());
            throw obj5;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return p((q)object, (Integer)object2, z3);
        }
    }

    private static class e implements y<T, net.time4j.x0> {

        final net.time4j.z0.f a;
        private e(net.time4j.z0.f z0$f) {
            super();
            this.a = f;
        }

        e(net.time4j.z0.f z0$f, net.time4j.z0.a z0$a2) {
            super(f);
        }

        private p<?> b(T t) {
            final p pVar = h0.G;
            if (t.v(pVar)) {
                return pVar;
            }
            return 0;
        }

        public p<?> d(T t) {
            return b(t);
        }

        public p<?> e(T t) {
            return b(t);
        }

        public net.time4j.x0 f(T t) {
            Object obj6 = t.p(g0.F);
            if (Long.compare(i2, l3) > 0) {
                return x0.FRIDAY;
            }
            return this.a.o();
        }

        public net.time4j.x0 g(T t) {
            Object obj6 = t.p(g0.F);
            if (Long.compare(i2, l3) < 0) {
                return x0.MONDAY;
            }
            return this.a.r();
        }

        @Override // net.time4j.engine.y
        public p getChildAtCeiling(Object object) {
            return d((q)object);
        }

        @Override // net.time4j.engine.y
        public p getChildAtFloor(Object object) {
            return e((q)object);
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

        public net.time4j.x0 h(T t) {
            return (g0)t.p(g0.F).C0();
        }

        public boolean i(T t, net.time4j.x0 x02) {
            final int i = 0;
            if (x02 == null) {
                return i;
            }
            j(t, x02, i);
            return 1;
        }

        @Override // net.time4j.engine.y
        public boolean isValid(Object object, Object object2) {
            return i((q)object, (x0)object2);
        }

        public T j(T t, net.time4j.x0 x02, boolean z3) {
            if (x02 == null) {
            } else {
                final p obj9 = g0.F;
                final Object obj = t.p(obj9);
                long l = (g0)obj.E0();
                net.time4j.x0 x0Var = z0.c(l);
                if (x02 == x0Var) {
                    return t;
                }
                return t.G(obj9, obj.V0(i -= l2));
            }
            IllegalArgumentException obj7 = new IllegalArgumentException("Missing weekday.");
            throw obj7;
        }

        @Override // net.time4j.engine.y
        public Object withValue(Object object, Object object2, boolean z3) {
            return j((q)object, (x0)object2, z3);
        }
    }

    private class d extends net.time4j.a<Integer> {

        private static final long serialVersionUID = -5936254509996557266L;
        private final int category;
        final net.time4j.z0 this$0;
        d(net.time4j.z0 z0, String string2, int i3) {
            this.this$0 = z0;
            super(string2);
            this.category = i3;
        }

        static net.time4j.z0 l(net.time4j.z0.d z0$d) {
            return d.u();
        }

        static boolean n(net.time4j.z0.d z0$d) {
            return d.w();
        }

        private Object readResolve() {
            net.time4j.z0 z0Var = u();
            int category = this.category;
            if (category != 0 && category != 1 && category != 2) {
                if (category != 1) {
                    if (category != 2) {
                        if (category != 3) {
                        } else {
                            return z0Var.a();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown category: ");
                        stringBuilder.append(this.category);
                        InvalidObjectException invalidObjectException = new InvalidObjectException(stringBuilder.toString());
                        throw invalidObjectException;
                    }
                    return z0Var.b();
                }
                return z0Var.m();
            }
            return z0Var.n();
        }

        private net.time4j.z0 u() {
            return this.this$0;
        }

        private boolean v() {
            int i;
            i = this.category >= 2 ? 1 : 0;
            return i;
        }

        private boolean w() {
            int i;
            i = category %= 2 == 0 ? 1 : 0;
            return i;
        }

        protected <T extends q<T>> y<T, Integer> d(w<T> w) {
            int i = 0;
            if (w.w(g0.F) && v()) {
                if (v()) {
                    z0.b obj2 = new z0.b(this, i);
                    return obj2;
                }
                obj2 = new z0.c(this, i);
                return obj2;
            }
            return i;
        }

        protected boolean e(e<?> e) {
            return u().equals((z0.d)e.u());
        }

        protected p<?> f() {
            return g0.Q;
        }

        @Override // net.time4j.a
        public Object getDefaultMaximum() {
            return o();
        }

        @Override // net.time4j.a
        public Object getDefaultMinimum() {
            return r();
        }

        @Override // net.time4j.a
        public char getSymbol() {
            int category = this.category;
            if (category != 0 && category != 1) {
                if (category != 1) {
                    return super.getSymbol();
                }
                return 87;
            }
            return 119;
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // net.time4j.a
        public boolean isDateElement() {
            return 1;
        }

        @Override // net.time4j.a
        public boolean isLenient() {
            return 1;
        }

        @Override // net.time4j.a
        public boolean isTimeElement() {
            return 0;
        }

        @Override // net.time4j.a
        public Integer o() {
            int i;
            i = w() ? 52 : 5;
            return Integer.valueOf(i);
        }

        @Override // net.time4j.a
        public Integer r() {
            return 1;
        }
    }

    private class f extends net.time4j.a<net.time4j.x0> implements net.time4j.d0<net.time4j.x0>, l<net.time4j.x0>, t<net.time4j.x0> {

        private static final long serialVersionUID = 1945670789283677398L;
        final net.time4j.z0 this$0;
        f(net.time4j.z0 z0) {
            this.this$0 = z0;
            super("LOCAL_DAY_OF_WEEK");
        }

        static net.time4j.z0 l(net.time4j.z0.f z0$f) {
            return f.u();
        }

        private s n(d d, m m2) {
            return b.d((Locale)d.a(a.c, Locale.ROOT)).p((v)d.a(a.g, v.WIDE), m2);
        }

        private Object readResolve() {
            return this.this$0.i();
        }

        private net.time4j.z0 u() {
            return this.this$0;
        }

        @Override // net.time4j.a
        public int b(o o, o o2) {
            int obj2;
            obj2 = (x0)o.p(this).getValue(this.this$0);
            int obj3 = (x0)o2.p(this).getValue(this.this$0);
            obj2 = obj2 < obj3 ? -1 : obj2 == obj3 ? 0 : 1;
            return obj2;
        }

        @Override // net.time4j.a
        public int compare(Object object, Object object2) {
            return b((o)object, (o)object2);
        }

        protected <T extends q<T>> y<T, net.time4j.x0> d(w<T> w) {
            int i = 0;
            if (w.w(g0.F)) {
                z0.e obj2 = new z0.e(this, i);
                return obj2;
            }
            return i;
        }

        protected boolean e(e<?> e) {
            return u().equals((z0.f)e.u());
        }

        protected p<?> f() {
            return g0.N;
        }

        @Override // net.time4j.a
        public Object getDefaultMaximum() {
            return o();
        }

        @Override // net.time4j.a
        public Object getDefaultMinimum() {
            return r();
        }

        @Override // net.time4j.a
        public char getSymbol() {
            return 101;
        }

        public Class<net.time4j.x0> getType() {
            return x0.class;
        }

        @Override // net.time4j.a
        public boolean isDateElement() {
            return 1;
        }

        @Override // net.time4j.a
        public boolean isTimeElement() {
            return 0;
        }

        @Override // net.time4j.a
        public net.time4j.x0 o() {
            return this.this$0.f().roll(6);
        }

        @Override // net.time4j.a
        public int p(Object object, o o2, d d3) {
            return x((x0)object, o2, d3);
        }

        @Override // net.time4j.a
        public Object parse(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            return w(charSequence, parsePosition2, d3);
        }

        @Override // net.time4j.a
        public void print(o o, java.lang.Appendable appendable2, d d3) {
            appendable2.append(n(d3, (m)d3.a(a.h, m.FORMAT)).g((Enum)o.p(this)));
        }

        @Override // net.time4j.a
        public net.time4j.x0 r() {
            return this.this$0.f();
        }

        public boolean s(q<?> q, int i2) {
            int i;
            net.time4j.x0 x0Var;
            int value;
            final net.time4j.x0[] values = x0.values();
            final int i3 = 0;
            i = i3;
            while (i < values.length) {
                x0Var = values[i];
                i++;
            }
            return i3;
        }

        @Override // net.time4j.a
        public int v(net.time4j.x0 x0) {
            return x0.getValue(this.this$0);
        }

        @Override // net.time4j.a
        public net.time4j.x0 w(java.lang.CharSequence charSequence, ParsePosition parsePosition2, d d3) {
            int index;
            Object type;
            m sTANDALONE;
            Enum obj;
            Class booleanValue;
            Boolean tRUE;
            Object obj7;
            sTANDALONE = m.FORMAT;
            type = d3.a(a.h, sTANDALONE);
            parsePosition2.setErrorIndex(-1);
            parsePosition2.setIndex(parsePosition2.getIndex());
            if ((x0)n(d3, (m)type).d(charSequence, parsePosition2, getType(), d3) == null && (Boolean)d3.a(a.k, Boolean.TRUE).booleanValue() && type == sTANDALONE) {
                if ((Boolean)d3.a(a.k, Boolean.TRUE).booleanValue()) {
                    parsePosition2.setErrorIndex(-1);
                    parsePosition2.setIndex(index);
                    if (type == sTANDALONE) {
                        sTANDALONE = m.STANDALONE;
                    }
                    obj = obj7;
                }
            }
            return obj;
        }

        @Override // net.time4j.a
        public int x(net.time4j.x0 x0, o o2, d d3) {
            return v(x0);
        }
    }
    static {
        Object next;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        z0.C = concurrentHashMap;
        z0 z0Var = new z0(x0.MONDAY, 4, x0.SATURDAY, x0.SUNDAY);
        z0.D = z0Var;
        Iterator iterator = d.c().g(y.class).iterator();
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            next = 0;
        }
        z0.E = next;
    }

    private z0(net.time4j.x0 x0, int i2, net.time4j.x0 x03, net.time4j.x0 x04) {
        int i;
        super();
        Objects.requireNonNull(x0, "Missing first day of week.");
        int i3 = 1;
        if (i2 < i3) {
        } else {
            if (i2 > 7) {
            } else {
                Objects.requireNonNull(x03, "Missing start of weekend.");
                Objects.requireNonNull(x04, "Missing end of weekend.");
                this.a = x0;
                this.b = i2;
                this.c = x03;
                this.v = x04;
                z0.d obj3 = new z0.d(this, "WEEK_OF_YEAR", 0);
                this.w = obj3;
                z0.d obj4 = new z0.d(this, "WEEK_OF_MONTH", i3);
                this.x = obj4;
                z0.d obj5 = new z0.d(this, "BOUNDED_WEEK_OF_YEAR", 2);
                this.y = obj5;
                z0.d obj6 = new z0.d(this, "BOUNDED_WEEK_OF_MONTH", 3);
                this.z = obj6;
                z0.f fVar = new z0.f(this);
                this.A = fVar;
                HashSet hashSet = new HashSet();
                hashSet.add(obj3);
                hashSet.add(obj4);
                hashSet.add(fVar);
                hashSet.add(obj5);
                hashSet.add(obj6);
                this.B = Collections.unmodifiableSet(hashSet);
            }
        }
        obj5 = new StringBuilder();
        obj5.append("Minimal days in first week out of range: ");
        obj5.append(i2);
        obj3 = new IllegalArgumentException(obj5.toString());
        throw obj3;
    }

    static net.time4j.x0 c(long l) {
        return x0.valueOf(obj2++);
    }

    public static net.time4j.z0 j(Locale locale) {
        int obj6;
        if (locale.getCountry().isEmpty()) {
            return z0.D;
        }
        Map map = z0.C;
        Object obj = map.get(locale);
        if ((z0)obj != null) {
            return (z0)obj;
        }
        y yVar = z0.E;
        if (yVar == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(locale);
            obj6 = gregorianCalendar.getFirstDayOfWeek();
            int i2 = 1;
            obj6 = obj6 == i2 ? 7 : obj6 - i2;
            return z0.k(x0.valueOf(obj6), gregorianCalendar.getMinimalDaysInFirstWeek());
        }
        z0 z0Var = new z0(x0.valueOf(yVar.d(locale)), yVar.b(locale), x0.valueOf(yVar.c(locale)), x0.valueOf(yVar.a(locale)));
        if (map.size() > 150) {
            map.clear();
        }
        map.put(locale, z0Var);
        return z0Var;
    }

    public static net.time4j.z0 k(net.time4j.x0 x0, int i2) {
        return z0.l(x0, i2, x0.SATURDAY, x0.SUNDAY);
    }

    public static net.time4j.z0 l(net.time4j.x0 x0, int i2, net.time4j.x0 x03, net.time4j.x0 x04) {
        net.time4j.x0 sATURDAY;
        if (x0 == x0.MONDAY && i2 == 4 && x03 == x0.SATURDAY && x04 == x0.SUNDAY) {
            if (i2 == 4) {
                if (x03 == x0.SATURDAY) {
                    if (x04 == x0.SUNDAY) {
                        return z0.D;
                    }
                }
            }
        }
        z0 z0Var = new z0(x0, i2, x03, x04);
        return z0Var;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 3);
        return spx;
    }

    public net.time4j.c<Integer, net.time4j.g0> a() {
        return this.z;
    }

    public net.time4j.c<Integer, net.time4j.g0> b() {
        return this.y;
    }

    Set<p<?>> d() {
        return this.B;
    }

    @Override // java.io.Serializable
    public net.time4j.x0 e() {
        return this.v;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        net.time4j.x0 x0Var;
        net.time4j.x0 x0Var2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof z0) {
            if (this.a == object.a && this.b == object.b && this.c == object.c && this.v == object.v) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // java.io.Serializable
    public net.time4j.x0 f() {
        return this.a;
    }

    @Override // java.io.Serializable
    public int g() {
        return this.b;
    }

    @Override // java.io.Serializable
    public net.time4j.x0 h() {
        return this.c;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return i2 += i5;
    }

    public net.time4j.d0<net.time4j.x0> i() {
        return this.A;
    }

    public net.time4j.c<Integer, net.time4j.g0> m() {
        return this.x;
    }

    public net.time4j.c<Integer, net.time4j.g0> n() {
        return this.w;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(z0.class.getName());
        stringBuilder.append("[firstDayOfWeek=");
        stringBuilder.append(this.a);
        stringBuilder.append(",minimalDaysInFirstWeek=");
        stringBuilder.append(this.b);
        stringBuilder.append(",startOfWeekend=");
        stringBuilder.append(this.c);
        stringBuilder.append(",endOfWeekend=");
        stringBuilder.append(this.v);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
