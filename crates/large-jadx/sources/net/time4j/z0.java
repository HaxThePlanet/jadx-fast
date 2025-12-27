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
import net.time4j.engine.e;
import net.time4j.engine.f0;
import net.time4j.engine.k;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.w;
import net.time4j.f1.c;
import net.time4j.g1.l;
import net.time4j.g1.s;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: Weekmodel.java */
/* loaded from: classes3.dex */
public final class z0 implements Serializable {

    private static final Map<Locale, z0> C = null;
    public static final z0 D = null;
    private static final net.time4j.g1.y E = null;
    private static final long serialVersionUID = 7794495882610436763L;
    private final transient d0<x0> A = new z0$f<>();
    private final transient Set<p<?>> B;
    private final transient x0 a;
    private final transient int b;
    private final transient x0 c;
    private final transient x0 v;
    private final transient c<Integer, g0> w = new z0$d<>();
    private final transient c<Integer, g0> x = new z0$d<>();
    private final transient c<Integer, g0> y = new z0$d<>();
    private final transient c<Integer, g0> z = new z0$d<>();

    class a implements n<net.time4j.f1.a> {
    }

    private static class b<T extends q<T>> implements net.time4j.engine.y<T, Integer> {

        private final z0.d a;
        /* synthetic */ b(z0.d dVar, z0.a aVar) {
            this(dVar);
        }

        private p<?> b(T t, boolean z) {
            int i2 = 4;
            Object obj = t.p(g0.F);
            net.time4j.d0 d0Var = this.a.u().i();
            int value = k(t).intValue();
            if (z) {
                z = this.a.w() ? 52 : 4;
                if (value >= this.a) {
                    q qVar = obj.G(d0Var, t.r(d0Var));
                    if (this.a.w()) {
                        if (qVar.D0() < obj.D0()) {
                            return g0.O;
                        }
                    } else {
                        if (qVar.q() < obj.q()) {
                            return g0.M;
                        }
                    }
                }
            } else {
                i2 = 1;
                if (value <= 1) {
                    q qVar2 = obj.G(d0Var, t.w(d0Var));
                    if (this.a.w()) {
                        if (qVar2.D0() > obj.D0()) {
                            return g0.O;
                        }
                    } else {
                        if (qVar2.q() > obj.q()) {
                            return g0.M;
                        }
                    }
                }
            }
            return d0Var;
        }

        private int f(g0 g0Var) {
            int i = 365;
            if (this.a.w()) {
                g0Var = b.e(g0Var.m()) ? 366 : 365;
                return (b.e(g0Var.m()) ? 366 : 365);
            }
            return b.d(g0Var.m(), g0Var.o());
        }

        private int g(g0 g0Var) {
            return m(g0Var, 1);
        }

        private int i(g0 g0Var) {
            return m(g0Var, -1);
        }

        private int l(g0 g0Var) {
            return m(g0Var, 0);
        }

        private int m(g0 g0Var, int i) {
            int i3;
            if (this.a.w()) {
                i = g0Var.D0();
            } else {
                i = g0Var.q();
            }
            int value = z0.c((g0Var.E0() - (long)i) + 1L).getValue(this.a.u());
            int r1 = value <= this.a.u().g() - 8 ? value - 2 : value - 9;
            i = 1;
            if (i == -1) {
            } else {
                if (i != 0 && i == i) {
                    i = f(g0Var);
                }
            }
            return (c.a(i - i3, 7)) + i;
        }

        private g0 o(g0 g0Var, int i) {
            i = l(g0Var);
            if (i == i) {
                return g0Var;
            }
            return g0Var.V0(g0Var.E0() + (long)(i - i) * 7);
        }

        public p<?> d(T t) {
            return b(t, true);
        }

        public p<?> e(T t) {
            return b(t, false);
        }

        public Integer h(T t) {
            return Integer.valueOf(g((g0)t.p(g0.F)));
        }

        public Integer j(T t) {
            return Integer.valueOf(i((g0)t.p(g0.F)));
        }

        public Integer k(T t) {
            return Integer.valueOf(l((g0)t.p(g0.F)));
        }

        public boolean n(T t, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            Object obj = t.p(g0.F);
            if (value >= i(obj) && value <= this.g(obj)) {
                int i = 1;
            }
            return z;
        }

        public T p(T t, Integer integer, boolean z) {
            p pVar = g0.F;
            if (integer == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid value: ";
                String str3 = " (context=";
                String str2 = ")";
                t = str + integer + str3 + t + str2;
                throw new IllegalArgumentException(t);
            } else {
                return t.G(g0.F, o((g0)t.p(pVar), integer.intValue()));
            }
        }

        private b(z0.d dVar) {
            super();
            this.a = dVar;
        }
    }

    private static class c<T extends q<T>> implements net.time4j.engine.y<T, Integer> {

        private final z0.d a;
        /* synthetic */ c(z0.d dVar, z0.a aVar) {
            this(dVar);
        }

        private int b(g0 g0Var) {
            int i;
            int i2 = 1;
            int i3 = 5;
            int i4;
            if (this.a.w()) {
                i = g0Var.D0();
            } else {
                i = g0Var.q();
            }
            int i9 = 0;
            int i11 = g(g0Var, i9);
            i2 = 1;
            if (i11 <= this.a) {
                i2 = (i - i11) / 7 + i2;
                i3 = 53;
                if (i2 < 53) {
                    if (!this.a.w() && i2 >= 5) {
                        i3 = (g(g0Var, i2)) + (h(g0Var, i9));
                        if (this.g(g0Var, i2) + this.h(g0Var, i9) > this.a) {
                        }
                    }
                }
                return i2;
            }
            int i10 = -1;
            return (i + (h(g0Var, i10))) - (g(g0Var, i10)) / 7 + i2;
        }

        private p<?> d() {
            return this.a.u().i();
        }

        private int g(g0 g0Var, int i) {
            net.time4j.z0 z0Var = this.a.u();
            int value = m(g0Var, i).getValue(z0Var);
            g0Var = value <= z0Var.g() - 8 ? value - 2 : value - 9;
            return (value <= z0Var.g() - 8 ? value - 2 : value - 9);
        }

        private int h(g0 g0Var, int i) {
            int i3 = 1;
            int i4 = 365;
            if (this.a.w()) {
                g0Var = b.e(g0Var.m() + i) ? 366 : 365;
                return (b.e(g0Var.m() + i) ? 366 : 365);
            }
            i = g0Var.m();
            i3 = g0Var.o() + i;
            if (i3 == 0) {
                i3 = 12;
                i = i - 1;
            } else {
                int i5 = 13;
                if (i3 == 13) {
                    i = i + 1;
                    i3 = 1;
                }
            }
            return b.d(i, i3);
        }

        private int i(g0 g0Var) {
            int i;
            int i3;
            if (this.a.w()) {
                i = g0Var.D0();
            } else {
                i = g0Var.q();
            }
            int i6 = 0;
            i = g(g0Var, i6);
            if (i <= this.a) {
                final int i12 = 1;
                i3 = (g(g0Var, i12)) + (h(g0Var, i6));
                if (this.g(g0Var, i12) + this.h(g0Var, i6) <= this.a) {
                    try {
                    } catch (RuntimeException unused) {
                    }
                    i3 = (g(g0Var, 2)) + (h(g0Var, i12));
                }
                return (i3 - i) / 7;
            }
            int i5 = -1;
            return (i + (h(g0Var, i5))) - (g(g0Var, i5)) / 7;
        }

        private x0 m(g0 g0Var, int i) {
            int i3 = 12;
            i3 = 1;
            if (this.a.w()) {
                return x0.valueOf(b.c(g0Var.m() + i, i3, i3));
            }
            i = g0Var.m();
            i3 = g0Var.o() + i;
            if (i3 == 0) {
                i3 = 12;
                i = i - 1;
            } else {
                int i4 = 13;
                if (i3 == 13) {
                    i = i + 1;
                } else {
                    i4 = 14;
                    if (i3 == 14) {
                        i3 = 2;
                        i = i + 1;
                    }
                }
            }
            return x0.valueOf(b.c(i, i3, i3));
        }

        private g0 o(g0 g0Var, int i) {
            i = b(g0Var);
            if (i == i) {
                return g0Var;
            }
            return g0Var.V0(g0Var.E0() + (long)(i - i) * 7);
        }

        public p<?> e(T t) {
            return d();
        }

        public p<?> f(T t) {
            return d();
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

        public boolean n(T t, Integer integer) {
            boolean z = false;
            z = false;
            if (integer == null) {
                return false;
            }
            final int value = integer.intValue();
            final int i = 1;
            if (this.a.w() && value >= i && value <= 52) {
                return true;
            }
            if (value >= i && value <= this.i((g0)t.p(g0.F))) {
            }
            return z;
        }

        public T p(T t, Integer integer, boolean z) {
            p pVar = g0.F;
            if (integer == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid value: ";
                String str3 = " (context=";
                String str2 = ")";
                t = str + integer + str3 + t + str2;
                throw new IllegalArgumentException(t);
            } else {
                return t.G(g0.F, o((g0)t.p(pVar), integer.intValue()));
            }
        }

        private c(z0.d dVar) {
            super();
            this.a = dVar;
        }
    }

    private static class e<T extends q<T>> implements net.time4j.engine.y<T, x0> {

        final z0.f a;
        /* synthetic */ e(z0.f fVar, z0.a aVar) {
            this(fVar);
        }

        private p<?> b(T t) {
            final p pVar = h0.G;
            if (t.v(pVar)) {
                return h0.G;
            }
            return null;
        }

        public p<?> d(T t) {
            return b(t);
        }

        public p<?> e(T t) {
            return b(t);
        }

        public x0 f(T t) {
            Object obj = t.p(g0.F);
            long l3 = (obj.c() + 7L) - (long)obj.C0().getValue(this.a.u());
            long l5 = g0.t0().j().c();
            if (this.a > l5) {
                return x0.FRIDAY;
            }
            return this.a.o();
        }

        public x0 g(T t) {
            Object obj = t.p(g0.F);
            long l3 = (obj.c() + 1L) - (long)obj.C0().getValue(this.a.u());
            long l5 = g0.t0().j().d();
            if (this.a < l5) {
                return x0.MONDAY;
            }
            return this.a.r();
        }

        public x0 h(T t) {
            return (g0)t.p(g0.F).C0();
        }

        public boolean i(T t, x0 x0Var) {
            final boolean z2 = false;
            if (x0Var == null) {
                return false;
            }
            try {
                j(t, x0Var, z2);
            } catch (RuntimeException unused) {
                return z;
            }
            return true;
        }

        public T j(T t, x0 x0Var, boolean z) {
            if (x0Var == null) {
                throw new IllegalArgumentException("Missing weekday.");
            } else {
                final p pVar = g0.F;
                final Object obj = t.p(pVar);
                long l = obj.E0();
                x0Var = z0.c(l);
                if (x0Var == x0Var) {
                    return t;
                }
                return t.G(g0.F, obj.V0((l + (long)x0Var.getValue(this.a.u())) - (long)x0Var.getValue(this.a.u())));
            }
        }

        private e(z0.f fVar) {
            super();
            this.a = fVar;
        }
    }

    private class d extends a<Integer> {

        private static final long serialVersionUID = -5936254509996557266L;
        private final int category;
        d(String str, int i) {
            super(str);
            this.category = i;
        }

        static /* synthetic */ z0 l(z0.d dVar) {
            return dVar.u();
        }

        static /* synthetic */ boolean n(z0.d dVar) {
            return dVar.w();
        }

        private Object readResolve() throws InvalidObjectException {
            net.time4j.z0 z0Var = u();
            if (this.category != 0 && this.category != 1) {
                if (this.category != 2 && this.category == 3) {
                    return z0Var.a();
                }
                return z0Var.b();
            }
            return z0Var.n();
        }

        private z0 u() {
            return z0.this;
        }

        private boolean v() {
            boolean z = true;
            int r0 = this.category >= 2 ? 1 : 0;
            return (this.category >= 2 ? 1 : 0);
        }

        private boolean w() {
            boolean z = true;
            int r0 = this.category % 2 == 0 ? 1 : 0;
            return (this.category % 2 == 0 ? 1 : 0);
        }

        @Override // net.time4j.a
        protected <T extends q<T>> net.time4j.engine.y<T, Integer> d(w<T> wVar) {
            net.time4j.z0.a aVar = null;
            if (wVar.w(g0.F) && this.v()) {
                return new z0.b(this, aVar);
            }
            return aVar;
        }

        @Override // net.time4j.a
        protected boolean e(e<?> eVar) {
            return u().equals(eVar.u());
        }

        @Override // net.time4j.a
        protected p<?> f() {
            return g0.Q;
        }

        @Override // net.time4j.a
        public char getSymbol() {
            if (this.category != 0 && this.category != 1) {
                return super.getSymbol();
            }
            return 119;
        }

        @Override // net.time4j.a
        public Class<Integer> getType() {
            return Integer.class;
        }

        @Override // net.time4j.a
        public Integer o() {
            int i = 52;
            int r0 = w() ? 52 : 5;
            return (w() ? 52 : 5);
        }

        @Override // net.time4j.a
        public Integer r() {
            return 1;
        }

        @Override // net.time4j.a
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.a
        public boolean isLenient() {
            return true;
        }

        @Override // net.time4j.a
        public boolean isTimeElement() {
            return false;
        }
    }

    private class f extends a<x0> implements d0<x0>, l<x0>, t<x0> {

        private static final long serialVersionUID = 1945670789283677398L;
        f() {
            super("LOCAL_DAY_OF_WEEK");
        }

        static /* synthetic */ z0 l(z0.f fVar) {
            return fVar.u();
        }

        private s n(net.time4j.engine.d dVar, net.time4j.g1.m mVar) {
            return b.d((Locale)dVar.a(a.c, Locale.ROOT)).p((v)dVar.a(a.g, v.WIDE), mVar);
        }

        private Object readResolve() {
            return z0.this.i();
        }

        private z0 u() {
            return z0.this;
        }

        @Override // net.time4j.a
        public int b(o oVar, o oVar2) {
            int i = -1;
            int value = (x0)oVar.p(this).getValue(z0.this);
            int value2 = (x0)oVar2.p(this).getValue(z0.this);
            if (value < value2) {
                i = -1;
            } else {
                oVar = value == value2 ? 0 : 1;
            }
            return (value == value2 ? 0 : 1);
        }

        @Override // net.time4j.a
        protected <T extends q<T>> net.time4j.engine.y<T, x0> d(w<T> wVar) {
            net.time4j.z0.a aVar = null;
            if (wVar.w(g0.F)) {
                return new z0.e(this, aVar);
            }
            return aVar;
        }

        @Override // net.time4j.a
        protected boolean e(e<?> eVar) {
            return u().equals(eVar.u());
        }

        @Override // net.time4j.a
        protected p<?> f() {
            return g0.N;
        }

        @Override // net.time4j.a
        public Class<x0> getType() {
            return x0.class;
        }

        @Override // net.time4j.a
        public x0 o() {
            return z0.this.f().roll(6);
        }

        @Override // net.time4j.a
        public void print(o oVar, java.lang.Appendable appendable, net.time4j.engine.d dVar) throws java.io.IOException {
            appendable.append(n(dVar, (m)dVar.a(a.h, m.FORMAT)).g((Enum)oVar.p(this)));
        }

        @Override // net.time4j.a
        public x0 r() {
            return z0.this.f();
        }

        @Override // net.time4j.a
        public boolean s(q<?> qVar, int i) {
            final net.time4j.x0[] values = x0.values();
            i = 0;
            for (net.time4j.x0 x0Var : values) {
                if (x0Var.getValue(z0.this) == i) {
                    qVar.G(this, x0Var);
                    return true;
                }
            }
            return false;
        }

        @Override // net.time4j.a
        public int v(x0 x0Var) {
            return x0Var.getValue(z0.this);
        }

        @Override // net.time4j.a
        public x0 w(java.lang.CharSequence charSequence, ParsePosition parsePosition, net.time4j.engine.d dVar) {
            net.time4j.g1.m fORMAT2;
            Enum charSequence2;
            fORMAT2 = m.FORMAT;
            Object obj = dVar.a(a.h, fORMAT2);
            if ((x0)n(dVar, obj).d(charSequence, parsePosition, getType(), dVar) == null) {
                if ((Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                    parsePosition.setErrorIndex(-1);
                    parsePosition.setIndex(parsePosition.getIndex());
                    if (obj == m.FORMAT) {
                        fORMAT2 = m.STANDALONE;
                    }
                }
            }
            return charSequence2;
        }

        @Override // net.time4j.a
        public int x(x0 x0Var, o oVar, net.time4j.engine.d dVar) {
            return v(x0Var);
        }

        @Override // net.time4j.a
        public char getSymbol() {
            return 101;
        }

        @Override // net.time4j.a
        public boolean isDateElement() {
            return true;
        }

        @Override // net.time4j.a
        public boolean isTimeElement() {
            return false;
        }
    }
    static {
        Object item = null;
        z0.C = new ConcurrentHashMap();
        z0.D = new z0(x0.MONDAY, 4, x0.SATURDAY, x0.SUNDAY);
        Iterator it = d.c().g(y.class).iterator();
        item = it.hasNext() ? (y)item : 0;
        z0.E = item;
    }

    private z0(x0 x0Var, int i, x0 x0Var2, x0 x0Var3) {
        super();
        Objects.requireNonNull(x0Var, "Missing first day of week.");
        int i3 = 1;
        if (i < i3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str8 = "Minimal days in first week out of range: ";
            i = str8 + i;
            throw new IllegalArgumentException(i);
        } else {
            i = 7;
            if (i <= 7) {
                Objects.requireNonNull(x0Var2, "Missing start of weekend.");
                Objects.requireNonNull(x0Var3, "Missing end of weekend.");
                this.a = x0Var;
                this.b = i;
                this.c = x0Var2;
                this.v = x0Var3;
                HashSet hashSet = new HashSet();
                hashSet.add(new z0.d(this, "WEEK_OF_YEAR", 0));
                hashSet.add(new z0.d(this, "WEEK_OF_MONTH", i3));
                hashSet.add(new z0.f(this));
                hashSet.add(new z0.d(this, "BOUNDED_WEEK_OF_YEAR", 2));
                hashSet.add(new z0.d(this, "BOUNDED_WEEK_OF_MONTH", 3));
                this.B = Collections.unmodifiableSet(hashSet);
                return;
            }
        }
    }

    static x0 c(long j) {
        return x0.valueOf((c.d(j + 5L, 7)) + 1);
    }

    public static z0 j(Locale locale) {
        int i = 7;
        if (locale.getCountry().isEmpty()) {
            return z0.D;
        }
        Map map = z0.C;
        Object value = map.get(locale);
        if (value != null) {
            return value;
        }
        net.time4j.g1.y yVar = z0.E;
        if (z0.E == null) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(locale);
            int firstDayOfWeek = gregorianCalendar.getFirstDayOfWeek();
            int i3 = 1;
            locale = firstDayOfWeek == i3 ? 7 : firstDayOfWeek - i3;
            return (firstDayOfWeek == i3 ? 7 : firstDayOfWeek - i3);
        }
        final net.time4j.z0 z0Var = new z0(x0.valueOf(z0.E.d(locale)), z0.E.b(locale), x0.valueOf(z0.E.c(locale)), x0.valueOf(z0.E.a(locale)));
        if (z0.C.size() > 150) {
            z0.C.clear();
        }
        z0.C.put(locale, z0Var);
        return z0Var;
    }

    public static z0 k(x0 x0Var, int i) {
        return z0.l(x0Var, i, x0.SATURDAY, x0.SUNDAY);
    }

    public static z0 l(x0 x0Var, int i, x0 x0Var2, x0 x0Var3) {
        if (x0Var == x0.MONDAY && i == 4 && x0Var2 == x0.SATURDAY && x0Var3 == x0.SUNDAY) {
            return z0.D;
        }
        return new z0(x0Var, i, x0Var2, x0Var3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 3);
    }

    public c<Integer, g0> a() {
        return this.z;
    }

    public c<Integer, g0> b() {
        return this.y;
    }

    Set<p<?>> d() {
        return this.B;
    }

    public x0 e() {
        return this.v;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        net.time4j.x0 x0Var;
        net.time4j.x0 x0Var2;
        net.time4j.x0 x0Var3;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof z0) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v != object.v) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public x0 f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public x0 h() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.name().hashCode() * 17) + (this.b * 37);
    }

    public d0<x0> i() {
        return this.A;
    }

    public c<Integer, g0> m() {
        return this.x;
    }

    public c<Integer, g0> n() {
        return this.w;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = z0.class.getName();
        String str2 = "[firstDayOfWeek=";
        String str3 = ",minimalDaysInFirstWeek=";
        String str4 = ",startOfWeekend=";
        String str5 = ",endOfWeekend=";
        str = 64 + name + str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.v + 93;
        return str;
    }
}
