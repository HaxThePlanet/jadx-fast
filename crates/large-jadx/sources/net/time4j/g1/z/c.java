package net.time4j.g1.z;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import net.time4j.b0;
import net.time4j.engine.ChronoException;
import net.time4j.engine.a0;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.i0;
import net.time4j.engine.l0;
import net.time4j.engine.m0;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.s;
import net.time4j.engine.t;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.f;
import net.time4j.f1.f;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.a.b;
import net.time4j.g1.e;
import net.time4j.g1.g;
import net.time4j.g1.t;
import net.time4j.g1.v;
import net.time4j.h0;
import net.time4j.history.d;
import net.time4j.history.q.a;
import net.time4j.i0;
import net.time4j.l;
import net.time4j.s;
import net.time4j.tz.f;
import net.time4j.tz.g;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.o;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
public final class c<T>  implements net.time4j.g1.z.e<T>, net.time4j.g1.z.d<T> {

    private final w<T> a;
    private final net.time4j.g1.z.c.e<?> b;
    private final net.time4j.g1.z.b c;
    private final List<net.time4j.g1.z.i> d;
    private final Map<p<?>, Object> e;
    private final net.time4j.g1.z.j f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int j;
    private final g k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final w<?> o;
    private final int p;
    private final boolean q;

    static class c {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            c.c.a = iArr;
            iArr[w.CLDR.ordinal()] = 1;
            c.c.a[w.CLDR_24.ordinal()] = 2;
            c.c.a[w.CLDR_DATE.ordinal()] = 3;
            c.c.a[w.SIMPLE_DATE_FORMAT.ordinal()] = 4;
        }
    }

    public static final class d {

        private static final c<l> n;
        private final w<T> a;
        private final w<?> b;
        private final Locale c;
        private List<net.time4j.g1.z.i> d;
        private LinkedList<net.time4j.g1.z.b> e;
        private int f;
        private int g;
        private int h;
        private String i;
        private l j;
        private Map<p<?>, Object> k;
        private w<?> l;
        private int m;
        static {
            c.d.n = a.e("CUSTOM_DAY_PERIOD", l.class);
        }

        private d(w<T> w, Locale locale2) {
            super(w, locale2, 0);
        }

        private d(w<T> w, Locale locale2, w<?> w3) {
            super();
            Objects.requireNonNull(w, "Missing chronology.");
            Objects.requireNonNull(locale2, "Missing locale.");
            this.a = w;
            this.b = w3;
            this.c = locale2;
            ArrayList obj3 = new ArrayList();
            this.d = obj3;
            obj3 = new LinkedList();
            this.e = obj3;
            obj3 = 0;
            this.f = obj3;
            this.g = -1;
            this.h = obj3;
            int obj4 = 0;
            this.i = obj4;
            this.j = obj4;
            obj4 = new HashMap();
            this.k = obj4;
            this.l = w;
            this.m = obj3;
        }

        d(w w, Locale locale2, net.time4j.g1.z.c.a c$a3) {
            super(w, locale2);
        }

        private net.time4j.g1.z.i H(p<?> p) {
            Object obj;
            boolean z;
            int i;
            int i2 = 0;
            if (this.d.isEmpty()) {
                obj = i2;
            } else {
                List list2 = this.d;
                obj = list2.get(size--);
            }
            if (obj == null) {
                return i2;
            }
            if (obj.g()) {
                if (!obj.i()) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(p.name());
                stringBuilder.append(" can't be inserted after an element");
                stringBuilder.append(" with decimal digits.");
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
            }
            return obj;
        }

        private static void I(c<?> c) {
            if (c.name().charAt(0) == 95) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Internal attribute not allowed: ");
            stringBuilder.append(c.name());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        private void J(p<?> p) {
            final w obj3 = c.c(this.a, this.b, p);
            int i = c.d(obj3, this.a, this.b);
            if (i >= this.m) {
                this.l = obj3;
                this.m = i;
            }
        }

        private void K() {
            if (!c.d.R(this.a)) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Timezone names in specific non-location format can only be reliably combined with instant-like types, for example \"Moment\".");
            throw illegalStateException;
        }

        private void M() {
            int i;
            boolean z;
            boolean z2;
            size--;
            while (i >= 0) {
                Object obj = this.d.get(i);
                i--;
            }
        }

        private void N(boolean z, boolean z2) {
            int obj1;
            int obj2;
            M();
            if (z == 0 && z2 == 0) {
                if (z2 == 0) {
                    if (this.g != -1) {
                    } else {
                    }
                    obj1 = new IllegalArgumentException("Cannot add fractional element with variable width after another numerical element with variable width.");
                    throw obj1;
                }
            }
        }

        private t<?> O(boolean z, l l2) {
            Object last;
            Object bVar;
            Locale next;
            Locale next2;
            char symbol;
            int i;
            a.b bVar2 = new a.b(P());
            if (l2 != null) {
                if (this.e.isEmpty()) {
                    bVar = new b(bVar2.a(), this.c);
                } else {
                    bVar = last;
                }
                last = bVar.m(c.d.n, l2);
            }
            Iterator obj7 = h0.k0().o().iterator();
            for (r next4 : obj7) {
                bVar = next4.c(this.c, last).iterator();
                for (p next2 : bVar) {
                }
                next2 = bVar.next();
            }
            obj7 = new StringBuilder();
            obj7.append("Day periods are not supported: ");
            obj7.append(P().l());
            IllegalStateException obj6 = new IllegalStateException(obj7.toString());
            throw obj6;
        }

        private static int Q(net.time4j.g1.z.b b) {
            if (b == null) {
                return 0;
            }
            return b.g();
        }

        private static boolean R(w<?> w) {
            while (f.class.isAssignableFrom(w.l())) {
            }
            return 1;
        }

        private boolean S(p<?> p) {
            w wVar2;
            w wVar;
            boolean z;
            int i = 0;
            if (!p.name().endsWith("_DAY_PERIOD")) {
                return i;
            }
            final int i2 = 1;
            if (this.b == null && !this.a.x(p)) {
                if (!this.a.x(p)) {
                    wVar2 = this.a;
                    wVar2 = wVar2.b();
                    while (wVar2 != null) {
                        wVar2 = wVar2.b();
                    }
                    return i;
                }
            }
            return i2;
        }

        private static boolean T(char c) {
            int i;
            int obj1;
            if (c >= 65) {
                if (c > 90) {
                    if (c >= 97 && c <= 122) {
                        obj1 = c <= 122 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
            return obj1;
        }

        private void V() {
            this.h = 0;
        }

        static void a(net.time4j.g1.z.c.d c$d, net.time4j.g1.z.h h2) {
            d.w(h2);
        }

        static w b(net.time4j.g1.z.c.d c$d) {
            return d.a;
        }

        static boolean c(w w) {
            return c.d.R(w);
        }

        private void o(StringBuilder stringBuilder) {
            int length;
            if (stringBuilder.length() > 0) {
                n(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }

        private <V> net.time4j.g1.z.c.d<T> s(p<V> p, boolean z2, int i3, int i4, net.time4j.g1.z.x x5) {
            this.t(p, z2, i3, i4, x5, false);
            return this;
        }

        private <V> net.time4j.g1.z.c.d<T> t(p<V> p, boolean z2, int i3, int i4, net.time4j.g1.z.x x5, boolean z6) {
            int obj10;
            Object obj11;
            int obj13;
            int obj14;
            J(p);
            final net.time4j.g1.z.i iVar = H(p);
            super(p, z2, i3, i4, x5, z6);
            if (z2) {
                obj10 = this.g;
                if (obj10 == -1) {
                    w(rVar2);
                } else {
                    obj11 = this.d.get(obj10);
                    w(rVar2);
                    obj13 = this.d;
                    if ((i)obj11.f() == (i)obj13.get(obj14--).f()) {
                        this.g = obj10;
                        this.d.set(obj10, obj11.t(i3));
                    }
                }
            } else {
                if (iVar != null && iVar.j()) {
                    if (iVar.j()) {
                        if (!iVar.i()) {
                        } else {
                        }
                        obj10 = new IllegalStateException("Numerical element with variable width can't be inserted after another numerical element. Consider \"addFixedXXX()\" instead.");
                        throw obj10;
                    }
                }
                w(rVar2);
                this.g = obj10--;
            }
            return this;
        }

        private void w(net.time4j.g1.z.h<?> h) {
            Object last;
            int i;
            int i2;
            net.time4j.g1.z.i iVar;
            this.g = -1;
            final int i4 = 0;
            if (!this.e.isEmpty()) {
                last = this.e.getLast();
                i = (b)last.g();
                i2 = last.i();
            } else {
                last = 0;
                i2 = i;
            }
            iVar = new i(h, i, i2, last);
            int obj6 = this.h;
            if (obj6 > 0) {
                iVar = iVar.n(obj6, i4);
                this.h = i4;
            }
            this.d.add(iVar);
        }

        public net.time4j.g1.z.c.d<T> A(t<?> t) {
            J(t);
            w(a0.a(t));
            return this;
        }

        public net.time4j.g1.z.c.d<T> B() {
            if (!c.d.R(this.a)) {
            } else {
                w(c0.INSTANCE);
                return this;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Only unix timestamps can have a timezone id.");
            throw illegalStateException;
        }

        public net.time4j.g1.z.c.d<T> C(e e, boolean z2, List<String> list3) {
            e0 e0Var = new e0(e, z2, list3);
            w(e0Var);
            return this;
        }

        public net.time4j.g1.z.c.d<T> D(p<Integer> p) {
            net.time4j.g1.z.f0 f0Var;
            int i2;
            int i;
            g sTRICT;
            int obj5;
            J(p);
            H(p);
            f0Var = new f0(p);
            obj5 = this.g;
            if (obj5 == -1) {
                w(f0Var);
                this.g = obj5--;
            } else {
                i2 = this.d.get(obj5);
                b0(a.f, g.STRICT);
                w(f0Var);
                L();
                List list = this.d;
                if ((i)i2.f() == (i)list.get(size--).f()) {
                    this.g = obj5;
                    this.d.set(obj5, i2.t(2));
                }
            }
            return this;
        }

        net.time4j.g1.z.c.d<T> E(p<Integer> p, int i2, boolean z3) {
            Object obj;
            int i;
            if (this.d.isEmpty()) {
                obj = 0;
            } else {
                List list2 = this.d;
                obj = list2.get(size--);
            }
            if (obj != null && !obj.i() && obj.j() && i2 != 4) {
                if (!obj.i()) {
                    if (obj.j()) {
                        if (i2 != 4) {
                        }
                        this.t(p, true, 4, 4, x.SHOW_NEVER, z3);
                        return this;
                    }
                }
            }
            this.t(p, false, i2, 10, x.SHOW_WHEN_NEGATIVE, z3);
            return this;
        }

        public net.time4j.g1.z.c<T> F() {
            return G(a.f());
        }

        public net.time4j.g1.z.c<T> G(a a) {
            int iterator;
            net.time4j.g1.z.c cVar2;
            int next;
            String cVar;
            int i;
            boolean empty;
            int hashMap;
            w empty2;
            Object intValue;
            boolean valueOf;
            int i2;
            int i3;
            Objects.requireNonNull(a, "Missing format attributes.");
            iterator = this.d.size();
            next = 0;
            final int i5 = 0;
            i = next;
            hashMap = i5;
            while (i < iterator) {
                intValue = this.d.get(i);
                if ((i)intValue.i()) {
                } else {
                }
                i++;
                i2 = iterator + -1;
                while (i2 > i) {
                    i2--;
                }
                intValue = next;
                if ((i)this.d.get(i2).f() == intValue.f()) {
                } else {
                }
                i2--;
                if (hashMap == null) {
                }
                hashMap.put(Integer.valueOf(i), intValue.m(i2));
                intValue = 1;
                hashMap = new HashMap();
            }
            if (hashMap != null) {
                iterator = hashMap.keySet().iterator();
                for (Integer next2 : iterator) {
                    this.d.set(next2.intValue(), hashMap.get(next2));
                }
            }
            super(this.a, this.b, this.c, this.d, this.k, a, this.l, 0);
            if (this.i == null) {
                cVar = "";
            }
            if (this.j == null) {
                if (!cVar.isEmpty() && !cVar.isEmpty()) {
                    if (!cVar.isEmpty()) {
                        empty = c.e(cVar2).m(a.x, cVar);
                    }
                    l lVar = this.j;
                    if (lVar != null) {
                        empty = empty.m(c.d.n, lVar);
                    }
                    cVar = new c(cVar2, empty, i5);
                    cVar2 = cVar;
                }
            } else {
            }
            return cVar2;
        }

        public net.time4j.g1.z.c.d<T> L() {
            this.e.removeLast();
            V();
            return this;
        }

        public w<?> P() {
            w wVar;
            if (this.b == null) {
                wVar = this.a;
            }
            return wVar;
        }

        public net.time4j.g1.z.c.d<T> U() {
            int i2;
            int i3;
            int i4;
            int i;
            if (!this.e.isEmpty()) {
                i2 = (b)this.e.getLast().i();
            } else {
                i2 = 0;
            }
            final int i5 = -1;
            if (!this.d.isEmpty()) {
                i = (i)this.d.get(size--).f();
            } else {
                i4 = 0;
                i = i3;
            }
            if (i2 != i) {
            } else {
                this.d.set(i3, i4.v());
                V();
                this.g = i5;
                return this;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot start or-block without any previous step in current section.");
            throw illegalStateException;
        }

        public net.time4j.g1.z.c.d<T> W(n<Character> n, int i2) {
            y yVar = new y(n, i2);
            w(yVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> X() {
            Y(0);
            return this;
        }

        public net.time4j.g1.z.c.d<T> Y(n<o> n) {
            int i2;
            int i;
            int aVar;
            int i3;
            V();
            a.b bVar = new a.b();
            if (!this.e.isEmpty()) {
                i = last;
                bVar.f((b)i.e());
                i2 = i.f();
            } else {
                i2 = i;
            }
            final int i6 = aVar + 1;
            this.f = i6;
            if (n != null) {
                if (i2 == 0) {
                    i3 = n;
                } else {
                    aVar = new c.d.a(this, i2, n);
                    i3 = aVar;
                }
            } else {
                i3 = i2;
            }
            super(bVar.a(), this.c, i4 + 1, i6, i3);
            this.e.addLast(obj10);
            return this;
        }

        public net.time4j.g1.z.c.d<T> Z(c<Character> c, char c2) {
            Object bVar2;
            net.time4j.g1.z.b bVar;
            a aVar;
            a obj4;
            Locale obj5;
            c.d.I(c);
            V();
            if (this.e.isEmpty()) {
                bVar2 = new a.b();
                bVar2.b(c, c2);
                bVar = new b(bVar2.a(), this.c);
            } else {
                bVar2 = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f((b)bVar2.e());
                bVar3.b(c, c2);
                bVar = bVar2.l(bVar3.a());
            }
            this.e.addLast(bVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> a0(c<Integer> c, int i2) {
            Object bVar2;
            net.time4j.g1.z.b bVar;
            a aVar;
            a obj4;
            Locale obj5;
            c.d.I(c);
            V();
            if (this.e.isEmpty()) {
                bVar2 = new a.b();
                bVar2.c(c, i2);
                bVar = new b(bVar2.a(), this.c);
            } else {
                bVar2 = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f((b)bVar2.e());
                bVar3.c(c, i2);
                bVar = bVar2.l(bVar3.a());
            }
            this.e.addLast(bVar);
            return this;
        }

        public <A extends Enum<A>> net.time4j.g1.z.c.d<T> b0(c<A> c, A a2) {
            Object bVar;
            net.time4j.g1.z.b bVar2;
            a aVar;
            a obj4;
            Object obj5;
            c.d.I(c);
            V();
            if (this.e.isEmpty()) {
                bVar = new a.b();
                bVar.d(c, a2);
                bVar2 = new b(bVar.a(), this.c);
            } else {
                bVar = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f((b)bVar.e());
                bVar3.d(c, a2);
                bVar2 = bVar.l(bVar3.a());
            }
            this.e.addLast(bVar2);
            return this;
        }

        public <V> net.time4j.g1.z.c.d<T> d(p<V> p, net.time4j.g1.z.e<V> e2, net.time4j.g1.z.d<V> d3) {
            J(p);
            f fVar = new f(p, e2, d3);
            w(fVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> e() {
            A(O(false, 0));
            return this;
        }

        public net.time4j.g1.z.c.d<T> f() {
            A(O(true, 0));
            return this;
        }

        public net.time4j.g1.z.c.d<T> g(p<Integer> p, int i2) {
            this.s(p, true, i2, i2, x.SHOW_NEVER);
            return this;
        }

        public <V extends Enum<V>> net.time4j.g1.z.c.d<T> h(p<V> p, int i2) {
            this.s(p, true, i2, i2, x.SHOW_NEVER);
            return this;
        }

        public net.time4j.g1.z.c.d<T> i(p<Integer> p, int i2, int i3, boolean z4) {
            int i;
            int i4;
            int obj5;
            Object obj6;
            int obj7;
            J(p);
            i = 1;
            if (!z4 && i2 == i3) {
                i4 = i2 == i3 ? i : 0;
            } else {
            }
            N(i4, z4);
            j jVar = new j(p, i2, i3, z4);
            final int obj4 = this.g;
            if (obj4 != -1 && i4 != 0) {
                if (i4 != 0) {
                    obj6 = this.d.get(obj4);
                    w(jVar);
                    obj7 = this.d;
                    if ((i)obj6.f() == (i)obj7.get(size -= i).f()) {
                        this.g = obj4;
                        this.d.set(obj4, obj6.t(i2));
                    }
                } else {
                    w(jVar);
                }
            } else {
            }
            return this;
        }

        public net.time4j.g1.z.c.d<T> j(p<Integer> p, int i2, int i3) {
            this.s(p, false, i2, i3, x.SHOW_NEVER);
            return this;
        }

        public net.time4j.g1.z.c.d<T> k(p<Integer> p, int i2, int i3, net.time4j.g1.z.x x4) {
            this.s(p, false, i2, i3, x4);
            return this;
        }

        public net.time4j.g1.z.c.d<T> l(char c) {
            n(String.valueOf(c));
            return this;
        }

        public net.time4j.g1.z.c.d<T> m(char c, char c2) {
            m mVar = new m(c, c2);
            w(mVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> n(String string) {
            net.time4j.g1.z.m mVar;
            Object obj;
            int i;
            int i3;
            int i2;
            int obj6;
            mVar = new m(string);
            obj6 = mVar.b();
            if (obj6 > 0) {
                if (this.d.isEmpty()) {
                    obj = 0;
                } else {
                    List list2 = this.d;
                    obj = list2.get(size--);
                }
                if (obj != null && obj.g()) {
                    if (obj.g()) {
                        if (!obj.i()) {
                        } else {
                        }
                        obj6 = new IllegalStateException("Numerical literal can't be inserted after an element with decimal digits.");
                        throw obj6;
                    }
                }
            }
            if (obj6 != null) {
                obj = this.g;
                if (obj == -1) {
                    w(mVar);
                } else {
                    i = this.d.get(obj);
                    w(mVar);
                    List list4 = this.d;
                    if ((i)i.f() == (i)list4.get(size2--).f()) {
                        this.g = obj;
                        this.d.set(obj, i.t(obj6));
                    }
                }
            } else {
            }
            return this;
        }

        public net.time4j.g1.z.c.d<T> p() {
            n nVar = new n(0);
            w(nVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> q(p<Long> p, int i2, int i3, net.time4j.g1.z.x x4) {
            this.s(p, false, i2, i3, x4);
            return this;
        }

        public net.time4j.g1.z.c.d<T> r() {
            K();
            d0 d0Var = new d0(0);
            w(d0Var);
            return this;
        }

        public <V extends Enum<V>> net.time4j.g1.z.c.d<T> u(p<V> p, int i2, int i3) {
            this.s(p, false, i2, i3, x.SHOW_NEVER);
            return this;
        }

        public net.time4j.g1.z.c.d<T> v(String string, net.time4j.g1.z.w w2) {
            Map emptyMap;
            int length;
            Locale element;
            StringBuilder stringBuilder;
            int i2;
            int i;
            String replace;
            boolean hashMap;
            int str;
            char charAt;
            int charAt2;
            char charAt3;
            String obj12;
            boolean obj13;
            Objects.requireNonNull(w2, "Missing pattern type.");
            emptyMap = Collections.emptyMap();
            length = string.length();
            element = this.c;
            stringBuilder = new StringBuilder();
            if (!this.e.isEmpty()) {
                element = (b)this.e.getLast().h();
            }
            i = i2;
            while (i < length) {
                hashMap = string.charAt(i);
                str = "'";
                charAt = 39;
                stringBuilder.append(hashMap);
                i++;
                o(stringBuilder);
                U();
                o(stringBuilder);
                L();
                o(stringBuilder);
                X();
                o(stringBuilder);
                i++;
                hashMap = replace;
                while (hashMap < length) {
                    if (string.charAt(hashMap) == charAt) {
                    } else {
                    }
                    hashMap++;
                    charAt2 = hashMap + 1;
                    if (charAt2 < length) {
                    }
                    if (string.charAt(charAt2) == charAt) {
                    }
                    hashMap = charAt2;
                }
                if (replace == hashMap) {
                } else {
                }
                n(string.substring(replace, hashMap).replace("''", str));
                i = hashMap;
                l(charAt);
                if (string.charAt(hashMap) == charAt) {
                } else {
                }
                hashMap++;
                charAt2 = hashMap + 1;
                if (charAt2 < length) {
                }
                if (string.charAt(charAt2) == charAt) {
                }
                hashMap = charAt2;
                o(stringBuilder);
                str = i + 1;
                while (str < length) {
                    if (string.charAt(str) == hashMap) {
                    }
                    str++;
                }
                Map registerSymbol = w2.registerSymbol(this, element, hashMap, str - i);
                if (!registerSymbol.isEmpty()) {
                }
                i = str + -1;
                if (emptyMap.isEmpty()) {
                } else {
                }
                hashMap = new HashMap(emptyMap);
                hashMap.putAll(registerSymbol);
                emptyMap = hashMap;
                emptyMap = registerSymbol;
                if (string.charAt(str) == hashMap) {
                }
                str++;
            }
            o(stringBuilder);
            if (!emptyMap.isEmpty()) {
                while (i2 < this.d.size()) {
                    length = this.d.get(i2);
                    element = (i)length.d().getElement();
                    if (emptyMap.containsKey(element)) {
                    }
                    i2++;
                    this.d.set(i2, length.x((p)emptyMap.get(element)));
                }
            }
            if (this.i == null) {
            } else {
                obj12 = "";
            }
            this.i = obj12;
            return this;
        }

        public net.time4j.g1.z.c.d<T> x() {
            n nVar = new n(1);
            w(nVar);
            return this;
        }

        public net.time4j.g1.z.c.d<T> y() {
            K();
            d0 d0Var = new d0(1);
            w(d0Var);
            return this;
        }

        public <V extends Enum<V>> net.time4j.g1.z.c.d<T> z(p<V> p) {
            Class<t> hashMap;
            net.time4j.g1.z.o oVar;
            int length;
            int i;
            Object obj;
            String string;
            Object obj7;
            J(p);
            if (p instanceof t) {
                w(a0.a((t)t.class.cast(p)));
            } else {
                hashMap = new HashMap();
                Object[] enumConstants = p.getType().getEnumConstants();
                i = 0;
                while (i < enumConstants.length) {
                    obj = (Enum[])enumConstants[i];
                    hashMap.put(obj, obj.toString());
                    i++;
                }
                oVar = new o(p, hashMap);
                w(oVar);
            }
            return this;
        }
    }

    static class a implements net.time4j.g1.z.e<k> {
        @Override // net.time4j.g1.z.e
        public Object a(Object object, java.lang.Appendable appendable2, d d3, s s4) {
            return b((k)object, appendable2, d3, s4);
        }

        public <R> R b(k k, java.lang.Appendable appendable2, d d3, s<o, R> s4) {
            return 0;
        }
    }

    static class b implements net.time4j.g1.z.d<k> {

        final Map a;
        b(Map map) {
            this.a = map;
            super();
        }

        @Override // net.time4j.g1.z.d
        public k a(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3) {
            int length;
            String obj3;
            final int obj5 = s2.f();
            final int i = obj5 + 3;
            obj3 = this.a.get(charSequence.subSequence(obj5, i).toString());
            if (i <= charSequence.length() && (k)obj3 != null) {
                obj3 = this.a.get(charSequence.subSequence(obj5, i).toString());
                if ((k)(k)obj3 != null) {
                    s2.l(i);
                    return (k)(k)obj3;
                }
                s2.k(obj5, "No time zone information found.");
            }
            return null;
        }

        @Override // net.time4j.g1.z.d
        public Object b(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3) {
            return a(charSequence, s2, d3);
        }
    }

    private static class e implements t<s<C>> {

        private final w<C> a;
        private final List<r> b;
        private e(w<C> w) {
            super();
            this.a = w;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(w.o());
            arrayList.addAll(h0.k0().o());
            this.b = Collections.unmodifiableList(arrayList);
        }

        static <C> net.time4j.g1.z.c.e<C> j(w<C> w) {
            if (w == null) {
                return 0;
            }
            c.e eVar = new c.e(w);
            return eVar;
        }

        @Override // net.time4j.engine.t
        public d0 a() {
            return this.a.a();
        }

        public w<?> b() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not used.");
            throw unsupportedOperationException;
        }

        @Override // net.time4j.engine.t
        public Object c(q q, d d2, boolean z3, boolean z4) {
            return g(q, d2, z3, z4);
        }

        @Override // net.time4j.engine.t
        public int d() {
            return this.a.d();
        }

        @Override // net.time4j.engine.t
        public o e(Object object, d d2) {
            k((s)object, d2);
            throw 0;
        }

        @Override // net.time4j.engine.t
        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            if (object instanceof c.e) {
                return this.a.equals(object.a);
            }
            return 0;
        }

        @Override // net.time4j.engine.t
        public String f(x x, Locale locale2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Not used.");
            throw obj1;
        }

        public s<C> g(q<?> q, d d2, boolean z3, boolean z4) {
            s obj3;
            Object obj4;
            Object obj = this.a.c(q, d2, z3, z4);
            obj3 = h0.k0().D(q, d2, z3, z4);
            if (obj instanceof l) {
                obj3 = s.b((l)l.class.cast(obj), (h0)obj3);
                c.f(obj3);
                return (s)obj3;
            } else {
                if (!obj instanceof m) {
                } else {
                    obj3 = s.c((m)m.class.cast(obj), obj3);
                }
            }
            obj4 = new StringBuilder();
            obj4.append("Cannot determine calendar type: ");
            obj4.append(obj);
            obj3 = new IllegalStateException(obj4.toString());
            throw obj3;
        }

        public w<?> h() {
            return this.a;
        }

        @Override // net.time4j.engine.t
        public int hashCode() {
            return this.a.hashCode();
        }

        public List<r> i() {
            return this.b;
        }

        public o k(s<C> s, d d2) {
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Not used.");
            throw obj1;
        }

        @Override // net.time4j.engine.t
        public String toString() {
            return this.a.l().getName();
        }
    }

    private static class f implements o, m0, f {

        private final s<?> a;
        private final k b;
        private f(s<?> s, String string2, k k3) {
            super();
            this.a = s;
            this.b = k3;
        }

        f(s s, String string2, k k3, net.time4j.g1.z.c.a c$a4) {
            super(s, string2, k3);
        }

        private f b() {
            d0 d0Var;
            try {
                d0Var = w.y(this.a.d().getClass()).a();
                d0 d0Var2 = d0.a;
                return this.a.a(l.N(this.b), d0Var);
            }
        }

        @Override // net.time4j.engine.o
        public int a() {
            return b().a();
        }

        public int e(p<Integer> p) {
            return this.a.e(p);
        }

        @Override // net.time4j.engine.o
        public boolean j() {
            return 1;
        }

        public <V> V p(p<V> p) {
            return this.a.p(p);
        }

        public <V> V r(p<V> p) {
            return this.a.r(p);
        }

        @Override // net.time4j.engine.o
        public k t() {
            return this.b;
        }

        public boolean v(p<?> p) {
            return this.a.v(p);
        }

        public <V> V w(p<V> p) {
            return this.a.w(p);
        }

        @Override // net.time4j.engine.o
        public long x() {
            return b().x();
        }
    }
    static {
        c.L();
    }

    private c(w<T> w, w<?> w2, Locale locale3, List<net.time4j.g1.z.i> list4, Map<p<?>, Object> map5, a a6, w<?> w7) {
        int i4;
        int i2;
        int i5;
        int i;
        int i3;
        p element;
        boolean z;
        int obj10;
        Object obj14;
        super();
        Objects.requireNonNull(w, "Missing chronology.");
        if (list4.isEmpty()) {
        } else {
            this.a = w;
            this.b = c.e.j(w2);
            this.o = w7;
            obj14 = w2 == null ? w : w2;
            obj10 = b.d(obj14, a6, locale3);
            this.c = obj10;
            this.k = (g)obj10.a(a.f, g.SMART);
            this.e = Collections.unmodifiableMap(map5);
            obj10 = 0;
            final Iterator obj12 = list4.iterator();
            int obj13 = 1;
            obj14 = 0;
            i3 = obj13;
            i = i5;
            while (obj12.hasNext()) {
                Object next2 = obj12.next();
                if ((i)next2.i()) {
                }
                if (obj10 == null && hVar2 instanceof j) {
                }
                if (i4 == 0 && next2.b() > 0) {
                }
                element = next2.d().getElement();
                i++;
                if (element != null && i3 != 0 && !v.V(element)) {
                }
                i++;
                if (i3 != 0) {
                }
                if (i5 == 0) {
                }
                i5 = c.A(w, w2, element);
                if (!v.V(element)) {
                }
                i3 = obj14;
                if (next2.b() > 0) {
                }
                i4 = obj13;
                if (hVar2 instanceof j) {
                }
                obj10 = j.class.cast(next2.d());
                i2 = obj13;
            }
            this.f = obj10;
            this.g = i4;
            this.h = i2;
            this.i = i5;
            this.j = i;
            this.l = i3;
            this.m = (Boolean)this.c.a(a.r, Boolean.FALSE).booleanValue();
            this.n = x();
            this.p = list4.size();
            this.d = n(list4);
            this.q = w();
        }
        IllegalStateException obj8 = new IllegalStateException("No format processors defined.");
        throw obj8;
    }

    c(w w, w w2, Locale locale3, List list4, Map map5, a a6, w w7, net.time4j.g1.z.c.a c$a8) {
        super(w, w2, locale3, list4, map5, a6, w7);
    }

    private c(net.time4j.g1.z.c<T> c, Map<p<?>, Object> map2) {
        int i;
        boolean z;
        Object next2;
        w next;
        Object obj;
        super();
        net.time4j.g1.z.c.e eVar = c.b;
        if (eVar == null) {
            i = 0;
        } else {
            i = eVar.h();
        }
        Iterator iterator = map2.keySet().iterator();
        for (p next2 : iterator) {
            c.j(c.a, i, next2);
        }
        this.a = c.a;
        this.b = c.b;
        this.o = c.o;
        this.c = c.c;
        this.k = c.k;
        this.f = c.f;
        this.g = c.g;
        this.h = c.h;
        this.i = c.i;
        this.j = c.j;
        this.m = c.m;
        HashMap hashMap = new HashMap(c.e);
        z = c.l;
        Iterator iterator2 = map2.keySet().iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            obj = map2.get((p)next);
            if (obj == null) {
            } else {
            }
            hashMap.put(next, obj);
            if (z && v.V(next)) {
            } else {
            }
            z = false;
            if (v.V(next)) {
            } else {
            }
            z = true;
            hashMap.remove(next);
        }
        this.e = Collections.unmodifiableMap(hashMap);
        this.l = z;
        this.n = x();
        this.p = c.p;
        this.d = n(c.d);
        this.q = w();
    }

    private c(net.time4j.g1.z.c<T> c, a a2) {
        super(c, c.c.l(a2), 0);
    }

    private c(net.time4j.g1.z.c<T> c, net.time4j.g1.z.b b2) {
        super(c, b2, 0);
    }

    c(net.time4j.g1.z.c c, net.time4j.g1.z.b b2, net.time4j.g1.z.c.a c$a3) {
        super(c, b2);
    }

    private c(net.time4j.g1.z.c<T> c, net.time4j.g1.z.b b2, d d3) {
        int i;
        boolean z;
        int i3;
        int i2;
        Object obj;
        p element;
        w iterator;
        f0 next;
        boolean contains;
        net.time4j.g1.z.b name;
        super();
        Objects.requireNonNull(b2, "Missing global format attributes.");
        this.a = c.a;
        this.b = c.b;
        this.o = c.o;
        this.c = b2;
        this.k = (g)b2.a(a.f, g.SMART);
        q qVar = new q(c.e);
        this.e = Collections.unmodifiableMap(qVar);
        this.f = c.f;
        this.g = c.g;
        this.h = c.h;
        int i5 = 0;
        if (!c.i) {
            if (d3 != null) {
                i = 1;
            } else {
                i = i5;
            }
        } else {
        }
        this.i = i;
        this.j = c.j;
        ArrayList arrayList = new ArrayList(c.d);
        z = c.l;
        i2 = i5;
        while (i2 < c.d.size()) {
            obj = arrayList.get(i2);
            element = (i)obj.d().getElement();
            iterator = this.a;
            if (iterator == b0.V()) {
            }
            if (element != null && !iterator.w(element)) {
            }
            if (d3 != null) {
            }
            i2++;
            i3 = 0;
            if (element == g0.H) {
            } else {
            }
            if (element != g0.K) {
            } else {
            }
            i3 = d3.C();
            if (i3 != 0) {
            }
            z = i5;
            arrayList.set(i2, obj.x(i3));
            if (element == g0.L) {
            } else {
            }
            if (element == g0.M) {
            } else {
            }
            if (element == g0.O) {
            }
            i3 = d3.h();
            i3 = d3.g();
            i3 = d3.M();
            if (!iterator.w(element)) {
            }
            iterator = iterator.o().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((r)next.c(c.u(), c.c).contains(element)) {
                    break loop_12;
                } else {
                }
            }
            next = iterator.next();
            if ((r)next.c(c.u(), c.c).contains(element)) {
            } else {
            }
            iterator = next.c(b2.h(), b2).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((p)next.name().equals(element.name())) {
                    break loop_15;
                } else {
                }
            }
            next = iterator.next();
            if ((p)next.name().equals(element.name())) {
            } else {
            }
            if (next != element) {
            }
            arrayList.set(i2, obj.x(next));
            z = i5;
            iterator = iterator.b();
        }
        this.l = z;
        this.m = (Boolean)this.c.a(a.r, Boolean.FALSE).booleanValue();
        this.n = x();
        this.p = arrayList.size();
        this.d = n(arrayList);
        this.q = w();
    }

    private static boolean A(w<?> w, w<?> w2, p<?> p3) {
        Iterator iterator;
        boolean z;
        int i;
        Iterator obj3;
        boolean obj4;
        iterator = w.o().iterator();
        i = 1;
        for (r next3 : iterator) {
            i = 1;
        }
        if (!w2) {
        } else {
            if (p3.isDateElement()) {
                obj3 = w2.o().iterator();
                for (r obj4 : obj3) {
                }
            } else {
                if (p3.isTimeElement() && h0.k0().x(p3)) {
                    if (h0.k0().x(p3)) {
                        obj3 = h0.k0().o().iterator();
                        for (r obj4 : obj3) {
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static net.time4j.g1.z.c<b0> B(e e, e e2, Locale locale3, k k4) {
        c.d dVar = new c.d(b0.V(), locale3, 0);
        z obj5 = new z(e, e2);
        c.d.a(dVar, obj5);
        return dVar.F().V(k4);
    }

    public static <T> net.time4j.g1.z.c<T> C(String string, net.time4j.g1.z.w w2, Locale locale3, w<T> w4) {
        c.d dVar = new c.d(w4, locale3, 0);
        c.g(dVar, string, w2);
        return dVar.F();
    }

    private static <T> T F(net.time4j.g1.z.c<?> c, t<T> t2, List<r> list3, java.lang.CharSequence charSequence4, net.time4j.g1.z.s s5, d d6, g g7, boolean z8, boolean z9) {
        Object z;
        boolean iterator2;
        boolean iterator;
        Object string;
        Object next;
        net.time4j.g1.z.j jVar;
        boolean strict;
        java.lang.CharSequence next2;
        net.time4j.g1.z.s symbol2;
        d dVar;
        net.time4j.g1.z.u iterator3;
        boolean symbol;
        q qVar;
        q uVar;
        final Object obj4 = c;
        final net.time4j.g1.z.s sVar = s5;
        final d dVar2 = d6;
        final boolean z3 = z8;
        final int length = charSequence4.length();
        if (s5.f() >= length) {
        } else {
            final int i3 = 0;
            final int i4 = 0;
            if (obj4.q && !z3) {
                if (!z3) {
                    uVar = new u();
                    (i)obj4.d.get(i3).q(charSequence4, s5, d6, uVar, z9);
                    if (s5.i()) {
                        return i4;
                    }
                    z = uVar.I();
                    if (z != null) {
                        return z;
                    }
                    sVar.m(uVar);
                } else {
                    sVar.m(c.H(charSequence4, s5, d6, z9, obj4.j));
                }
            } else {
            }
            if (uVar != null) {
                if (s5.i()) {
                } else {
                    if (!obj4.e.isEmpty()) {
                        iterator2 = obj4.e.keySet().iterator();
                        next = i4;
                        while (iterator2.hasNext()) {
                            next2 = iterator2.next();
                            symbol2 = next2.getSymbol();
                            dVar = 1;
                            if (uVar.v((p)next2) == null && symbol2 != null && next == 0) {
                            }
                            symbol2 = next2.getSymbol();
                            dVar = 1;
                            if (symbol2 != null) {
                            }
                            if (dVar != null) {
                            }
                            c.O(uVar, next2, obj4.e.get(next2));
                            if (next == 0) {
                            }
                            iterator3 = next.iterator();
                            while (iterator3.hasNext()) {
                                if ((p)iterator3.next().getSymbol() == symbol2) {
                                    break loop_24;
                                } else {
                                }
                            }
                            if ((p)iterator3.next().getSymbol() == symbol2) {
                            } else {
                            }
                            dVar = i3;
                            next = uVar.A();
                        }
                    }
                    if (obj4.i) {
                        iterator = list3.iterator();
                        for (r next : iterator) {
                            uVar = next.b(uVar, c.u(), dVar2);
                        }
                    }
                    string = t2.c(uVar, dVar2, g7.isLax(), z3);
                    if (obj4.f != null && string instanceof q) {
                        if (string instanceof q) {
                            c.h(obj4.f.d((q)q.class.cast(string), uVar));
                        }
                    }
                    if (string == null && !z3) {
                        if (!z3) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(c.v(uVar));
                            stringBuilder.append(c.t(uVar));
                            sVar.k(length, stringBuilder.toString());
                        }
                        return i4;
                    }
                    if (g7.isStrict()) {
                        string = c.i(uVar, string, charSequence4, sVar);
                    }
                }
                return string;
            }
            return i4;
        }
        java.lang.CharSequence charSequence = charSequence4;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("[");
        stringBuilder3.append(s5.f());
        stringBuilder3.append("]: ");
        stringBuilder3.append(charSequence4.toString());
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder3.toString());
        throw indexOutOfBoundsException;
    }

    private static <C> C G(net.time4j.g1.z.c<?> c, w<C> w2, int i3, java.lang.CharSequence charSequence4, net.time4j.g1.z.s s5, d d6, g g7, boolean z8) {
        boolean length;
        Object obj;
        Object obj2;
        boolean string2;
        w wVar;
        Object qVar;
        w wVar2;
        List list;
        StringBuilder stringBuilder;
        java.lang.CharSequence charSequence;
        Object pVar;
        net.time4j.g1.z.s sVar;
        d dVar;
        g gVar;
        int i2;
        int i;
        boolean z;
        final net.time4j.g1.z.s sVar3 = s5;
        final w wVar4 = w2.b();
        final int i6 = 0;
        if (wVar4 != null) {
            wVar2 = obj4.o;
            if (w2 == wVar2) {
            } else {
                if (wVar4 == wVar2) {
                    obj2 = c.F(c, wVar4, wVar4.o(), charSequence4, s5, d6, g7, true, z8);
                } else {
                    obj2 = c.G(c, wVar4, i3 + 1, charSequence4, s5, d6, g7, z8);
                }
                int i5 = 0;
                if (s5.i()) {
                    return i5;
                }
                if (obj2 == null) {
                    q qVar2 = s5.g();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(c.v(qVar2));
                    stringBuilder3.append(c.t(qVar2));
                    sVar3.k(charSequence4.length(), stringBuilder3.toString());
                    return i5;
                }
                qVar = s5.h();
                if (!wVar4 instanceof f0) {
                } else {
                    c.Q(qVar, (f0)f0.class.cast(wVar4).E(), obj2);
                    obj = w2.c(qVar, d6, g7.isLax(), i6);
                    if (obj == null && !s5.i()) {
                        if (!s5.i()) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(c.v(qVar));
                            stringBuilder2.append(c.t(qVar));
                            sVar3.k(charSequence4.length(), stringBuilder2.toString());
                        }
                        return i5;
                    }
                    if (g7.isStrict()) {
                        obj = c.i(qVar, obj, charSequence4, sVar3);
                    }
                    return obj;
                }
            }
            java.lang.CharSequence charSequence5 = charSequence4;
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Unsupported chronology or preparser: ");
            stringBuilder4.append(w2);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }
        java.lang.CharSequence charSequence2 = charSequence4;
        d dVar2 = d6;
        i2 = i3 > 0 ? i4 : i6;
        return c.F(c, w2, w2.o(), charSequence4, s5, d6, g7, i2, z8);
    }

    private q<?> H(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, boolean z4, int i5) {
        net.time4j.g1.z.v vVar2;
        boolean eRROR_MESSAGE;
        int i7;
        int peek3;
        boolean linkedList;
        int i3;
        java.lang.CharSequence key;
        int i2;
        int i8;
        int peek;
        net.time4j.g1.z.s sVar;
        d dVar;
        int obj;
        net.time4j.g1.z.v peek2;
        boolean z;
        int i4;
        int i;
        Object obj2;
        net.time4j.g1.z.v vVar;
        net.time4j.g1.z.v vVar3;
        int i9;
        int i6;
        final Object obj3 = this;
        final net.time4j.g1.z.s sVar2 = s2;
        final int i13 = i5;
        vVar2 = new v(i13, obj3.l);
        vVar2.f0(s2.f());
        final int i14 = 0;
        if (obj3.g) {
            linkedList = new LinkedList();
            linkedList.push(vVar2);
            i4 = linkedList;
        } else {
            i4 = i14;
        }
        final int size = obj3.d.size();
        i = peek;
        while (i < size) {
            obj2 = obj;
            if (i4 == 0) {
            } else {
            }
            i3 = (i)obj2.b();
            obj = i3;
            while (obj > peek) {
                vVar2 = new v(i13 >>> 1, obj3.l);
                vVar2.f0(s2.f());
                i4.push(vVar2);
                obj--;
            }
            while (obj < peek) {
                (v)i4.peek().Z((v)i4.pop());
                obj++;
            }
            vVar3 = vVar2;
            i9 = i3;
            vVar = peek;
            s2.b();
            obj2.q(charSequence, s2, d3, vVar, z4);
            eRROR_MESSAGE = obj2.d().getElement();
            if (s2.j() && eRROR_MESSAGE != null && obj3.e.containsKey(eRROR_MESSAGE)) {
            }
            if (obj2.i()) {
            }
            vVar2 = vVar3;
            i++;
            i3 = peek;
            i = obj2.u();
            peek3 = obj2.f();
            if (!obj2.i()) {
            } else {
            }
            key = i;
            if (i4 != 0) {
            }
            s2.a();
            sVar2.l(vVar3.U());
            vVar3.d0();
            if (i4 != 0) {
            }
            i = key;
            i4.push(vVar3);
            vVar3 = peek3;
            dVar = key;
            i2 = i15;
            while (i2 < size) {
                if ((i)obj3.d.get(i2).b() > obj2.b()) {
                }
                dVar = i2;
                i2 = i6;
            }
            i8 = size + -1;
            while (i8 > dVar) {
                if ((i)obj3.d.get(i8).f() == peek3) {
                    break loop_38;
                } else {
                }
                i8--;
            }
            i9--;
            s2.a();
            sVar2.l((v)i4.pop().U());
            i = dVar;
            if ((i)obj3.d.get(i8).f() == peek3) {
            } else {
            }
            i8--;
            dVar = i8;
            if ((i)obj3.d.get(i2).b() > obj2.b()) {
            }
            dVar = i2;
            i2 = i6;
            key = i + 1;
            while (key < size) {
                sVar = obj3.d.get(key);
                key++;
            }
            sVar = obj3.d.get(key);
            if ((i)sVar.i() != null) {
            } else {
            }
            key++;
            if (sVar.f() == peek3) {
            } else {
            }
            eRROR_MESSAGE = obj2.d().getElement();
            if (eRROR_MESSAGE != null) {
            }
            if (obj3.e.containsKey(eRROR_MESSAGE)) {
            }
            vVar.K(eRROR_MESSAGE, obj3.e.get(eRROR_MESSAGE));
            vVar.N(l0.ERROR_MESSAGE, i14);
            s2.a();
            s2.b();
            (v)i4.peek().Z((v)i4.pop());
            obj++;
            vVar2 = new v(i13 >>> 1, obj3.l);
            vVar2.f0(s2.f());
            i4.push(vVar2);
            obj--;
            vVar3 = vVar;
            i9 = i3;
        }
        while (i3 > 0) {
            (v)i4.peek().Z((v)i4.pop());
            i3--;
        }
        if (i4 != 0) {
            vVar2 = i4.peek();
        }
        vVar2.e0();
        return vVar2;
    }

    private static net.time4j.g1.z.c<b0> L() {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ENGLISH);
        c.M(dVar);
        dVar.C(e.MEDIUM, false, Arrays.asList(/* result */));
        dVar.U();
        c.M(dVar);
        HashMap hashMap = new HashMap();
        f bEHIND_UTC = f.BEHIND_UTC;
        int i2 = 5;
        hashMap.put("EST", p.s(bEHIND_UTC, i2));
        hashMap.put("EDT", p.s(bEHIND_UTC, 4));
        int i5 = 6;
        hashMap.put("CST", p.s(bEHIND_UTC, i5));
        hashMap.put("CDT", p.s(bEHIND_UTC, i2));
        int i3 = 7;
        hashMap.put("MST", p.s(bEHIND_UTC, i3));
        hashMap.put("MDT", p.s(bEHIND_UTC, i5));
        hashMap.put("PST", p.s(bEHIND_UTC, 8));
        hashMap.put("PDT", p.s(bEHIND_UTC, i3));
        c.a aVar = new c.a();
        c.b bVar = new c.b(hashMap);
        f fVar = new f(b0.TIMEZONE_OFFSET, aVar, bVar);
        c.d.a(dVar, fVar);
        return dVar.F().V(p.C);
    }

    private static void M(net.time4j.g1.z.c.d<b0> c$d) {
        d.X();
        c cVar = a.g;
        v aBBREVIATED = v.ABBREVIATED;
        d.b0(cVar, aBBREVIATED);
        d.z(g0.N);
        d.L();
        d.n(", ");
        d.L();
        final int i5 = 2;
        d.j(g0.M, 1, i5);
        int i3 = 32;
        d.l(i3);
        d.b0(cVar, aBBREVIATED);
        d.z(g0.K);
        d.L();
        d.l(i3);
        d.g(g0.H, 4);
        d.l(i3);
        d.g(h0.M, i5);
        int i = 58;
        d.l(i);
        d.g(h0.O, i5);
        d.X();
        d.l(i);
        d.g(h0.Q, i5);
        d.L();
        d.l(i3);
    }

    public static <T extends q<T>> net.time4j.g1.z.c.d<T> N(Class<T> class, Locale locale2) {
        Objects.requireNonNull(class, "Missing chronological type.");
        w wVar = w.y(class);
        if (wVar == null) {
        } else {
            c.d obj2 = new c.d(wVar, locale2, 0);
            return obj2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not formattable: ");
        stringBuilder.append(class);
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private static <V> void O(q<?> q, p<V> p2, Object object3) {
        q.G(p2, p2.getType().cast(object3));
    }

    private static String P(int i, java.lang.CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length - i <= 10) {
            return charSequence2.subSequence(i, length).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence2.subSequence(i, i + 10).toString());
        stringBuilder.append("...");
        return stringBuilder.toString();
    }

    private static <T> void Q(q<?> q, p<T> p2, Object object3) {
        q.G(p2, p2.getType().cast(object3));
    }

    static w c(w w, w w2, p p3) {
        return c.j(w, w2, p3);
    }

    static int d(w w, w w2, w w3) {
        return c.s(w, w2, w3);
    }

    static net.time4j.g1.z.b e(net.time4j.g1.z.c c) {
        return c.c;
    }

    static Object f(Object object) {
        c.h(object);
        return object;
    }

    private static <T> void g(net.time4j.g1.z.c.d<T> c$d, String string2, net.time4j.g1.z.w w3) {
        String contains2;
        boolean contains3;
        boolean contains;
        boolean contains4;
        String ordinal;
        int str;
        int i;
        int charAt3;
        int i3;
        int i2;
        int charAt2;
        char charAt;
        int length = string2.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i4 = 0;
        str = i4;
        i = 1;
        while (str < length) {
            charAt3 = string2.charAt(str);
            i3 = 39;
            if (charAt3 == i3) {
            } else {
            }
            stringBuilder.append(charAt3);
            str += i;
            i = 1;
            if (string2.charAt(str + 1) == 90) {
            } else {
            }
            i2 = i4;
            while (charAt3 < length) {
                charAt3 += i;
                charAt2 = charAt3 + 1;
                charAt3 = charAt2;
            }
            str = charAt3;
            charAt3 += i;
            charAt2 = charAt3 + 1;
            charAt3 = charAt2;
            i2 = i;
        }
        contains2 = stringBuilder.toString();
        contains3 = c.c.a[w3.ordinal()];
        if (contains3 != i && contains3 != 2 && contains3 != 3 && contains3 != 4) {
            if (contains3 != 2) {
                if (contains3 != 3) {
                    if (contains3 != 4) {
                    } else {
                        if (!contains2.contains("h")) {
                            if (contains2.contains("K") && !contains2.contains("a") && !contains2.contains("b")) {
                                if (!contains2.contains("a")) {
                                    if (!contains2.contains("b")) {
                                        if (!contains2.contains("B")) {
                                        } else {
                                        }
                                        StringBuilder obj12 = new StringBuilder();
                                        obj12.append("12-hour-clock requires am/pm-marker or dayperiod: ");
                                        obj12.append(string2);
                                        IllegalArgumentException obj10 = new IllegalArgumentException(obj12.toString());
                                        throw obj10;
                                    }
                                }
                            }
                        } else {
                        }
                        ordinal = "L";
                        str = "M";
                        if (contains2.contains("Y")) {
                            if (!contains2.contains(str)) {
                                if (contains2.contains(ordinal)) {
                                    if (!contains2.contains("w")) {
                                    } else {
                                    }
                                }
                            } else {
                            }
                            obj12 = new StringBuilder();
                            obj12.append("Y as week-based-year requires a week-date-format: ");
                            obj12.append(string2);
                            obj10 = new IllegalArgumentException(obj12.toString());
                            throw obj10;
                        }
                        if (contains2.contains("D")) {
                            if (!contains2.contains(str)) {
                                if (contains2.contains(ordinal)) {
                                    if (!contains2.contains("d")) {
                                    } else {
                                    }
                                }
                            } else {
                            }
                            obj12 = new StringBuilder();
                            obj12.append("D is the day of year but not the day of month: ");
                            obj12.append(string2);
                            obj10 = new IllegalArgumentException(obj12.toString());
                            throw obj10;
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        d.v(string2, w3);
    }

    private static <T> T h(Object object) {
        return object;
    }

    private static <T> T i(q<?> q, T t2, java.lang.CharSequence charSequence3, net.time4j.g1.z.s s4) {
        boolean cast;
        int dAYLIGHT_SAVING;
        boolean z;
        Object tIMEZONE_ID;
        Iterator iterator;
        boolean tIMEZONE_OFFSET;
        boolean equals;
        f dateElement;
        int i;
        int i2;
        int i3;
        Throwable obj12;
        Object obj13;
        final String str2 = "}.";
        final String str3 = "Conflict found: ";
        final int i4 = 256;
        final int i5 = 0;
        if (t2 instanceof f) {
            cast = f.class.cast(t2);
            tIMEZONE_ID = b0.TIMEZONE_ID;
            tIMEZONE_OFFSET = b0.TIMEZONE_OFFSET;
            tIMEZONE_ID = q.p(tIMEZONE_ID);
            tIMEZONE_OFFSET = q.p(tIMEZONE_OFFSET);
            if (q.v(tIMEZONE_ID) && q.v(tIMEZONE_OFFSET) && !l.N((k)tIMEZONE_ID).B((f)cast).equals((k)tIMEZONE_OFFSET)) {
                tIMEZONE_OFFSET = b0.TIMEZONE_OFFSET;
                if (q.v(tIMEZONE_OFFSET)) {
                    tIMEZONE_ID = q.p(tIMEZONE_ID);
                    tIMEZONE_OFFSET = q.p(tIMEZONE_OFFSET);
                    if (!l.N((k)tIMEZONE_ID).B(cast).equals((k)tIMEZONE_OFFSET)) {
                        obj13 = new StringBuilder();
                        obj13.append("Ambivalent offset information: ");
                        obj13.append(tIMEZONE_ID);
                        obj13.append(" versus ");
                        obj13.append(tIMEZONE_OFFSET);
                        s4.k(charSequence3.length(), obj13.toString());
                        return i5;
                    }
                }
            }
            dAYLIGHT_SAVING = a0.DAYLIGHT_SAVING;
            cast = l.N(q.t()).I(cast);
            obj12 = new StringBuilder(i4);
            obj12.append(str3);
            obj12.append("Parsed entity is ");
            if (q.v(dAYLIGHT_SAVING) && cast != (Boolean)q.p(dAYLIGHT_SAVING).booleanValue() && !cast) {
                cast = l.N(q.t()).I(cast);
                if (cast != (Boolean)q.p(dAYLIGHT_SAVING).booleanValue()) {
                    obj12 = new StringBuilder(i4);
                    obj12.append(str3);
                    obj12.append("Parsed entity is ");
                    if (!cast) {
                        obj12.append("not ");
                    }
                    obj12.append("daylight-saving, but timezone name");
                    obj12.append(" has not the appropriate form in {");
                    obj12.append(charSequence3.toString());
                    obj12.append(str2);
                    s4.k(charSequence3.length(), obj12.toString());
                    obj13 = i5;
                }
            }
        } else {
            if (t2 instanceof o) {
                cast = t2;
                if (t2 instanceof i0 && (i0)i0.class.cast(t2).s() == 0) {
                    if ((i0)i0.class.cast(t2).s() == 0) {
                        iterator = 24;
                        if (q.e(h0.N) != iterator) {
                            z = h0.H;
                            if (q.v(z) && (h0)q.p(z).s() == iterator) {
                                if ((h0)q.p(z).s() == iterator) {
                                    dAYLIGHT_SAVING = (i0)i0.class.cast(t2).h0().L(1, equals);
                                } else {
                                    dAYLIGHT_SAVING = i5;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                iterator = q.A().iterator();
                for (p equals : iterator) {
                    dateElement = h0.Q;
                    if (dAYLIGHT_SAVING != 0) {
                    }
                    dateElement = 1;
                    if (equals.getType() == Integer.class) {
                    } else {
                    }
                    dateElement = cast.p(equals).equals(q.p(equals));
                    c.h(equals);
                    boolean z3 = equals;
                    i2 = q.e((p)z3);
                    if (cast.e(z3) != i2) {
                    } else {
                    }
                    i = i5;
                    i = valueOf;
                    dateElement = i3;
                    if (equals.isDateElement()) {
                    } else {
                    }
                    if (equals.isTimeElement()) {
                    }
                    cast = h0.G0();
                    cast = dAYLIGHT_SAVING;
                }
            }
        }
        return obj13;
    }

    private static w<?> j(w<?> w, w<?> w2, p<?> p3) {
        w obj1;
        boolean obj2;
        if (w.x(p3)) {
            return w;
        }
        if (!w2) {
        } else {
            if (p3.isDateElement() && w2.x(p3)) {
                if (w2.x(p3)) {
                    return w2;
                }
            }
            if (!p3.isTimeElement()) {
            } else {
                if (!h0.k0().x(p3)) {
                } else {
                    return h0.k0();
                }
            }
        }
        obj2 = new StringBuilder();
        obj2.append("Unsupported element: ");
        obj2.append(p3.name());
        obj1 = new IllegalArgumentException(obj2.toString());
        throw obj1;
    }

    private o k(T t, d d2) {
        Object cls;
        Object str;
        s obj8;
        net.time4j.g1.z.c.e eVar = this.b;
        if (eVar == null) {
            return this.a.e(t, d2);
        }
        cls = eVar.h().l();
        Object obj = d2.a(a.u, this.b.a());
        Object cast = b0.class.cast(t);
        Object obj3 = d2.b(a.d);
        str = "";
        if (l.class.isAssignableFrom(cls)) {
            cls = this.b.h();
            c.h(cls);
            obj8 = (b0)cast.s0((j)cls, (String)d2.b(a.t), (k)obj3, (d0)obj);
            c.f fVar = new c.f(obj8, str, obj3, 0);
            return fVar;
        } else {
            if (!m.class.isAssignableFrom(cls)) {
            } else {
                obj8 = cast.t0(this.b.h(), obj3, obj);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unexpected calendar override: ");
        stringBuilder2.append(cls);
        obj8 = new IllegalStateException(stringBuilder2.toString());
        throw obj8;
    }

    private String m(o o) {
        StringBuilder stringBuilder = new StringBuilder(size *= 8);
        K(o, stringBuilder, this.c, false);
        return stringBuilder.toString();
    }

    private List<net.time4j.g1.z.i> n(List<net.time4j.g1.z.i> list) {
        int size;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj3 = list.iterator();
        for (i next2 : obj3) {
            arrayList.add(next2.s(this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static int s(w<?> w, w<?> w2, w<?> w3) {
        int i;
        Object obj2;
        boolean obj3;
        if (w3 != null) {
            return -1;
        }
        if (w.equals(w2)) {
            return 0;
        }
        obj2 = obj2.b();
        while (obj2 != null) {
            obj2 = obj2.b();
        }
        return Integer.MAX_VALUE;
    }

    private static String t(q<?> q) {
        int i;
        Object obj;
        int str;
        Set set = q.A();
        StringBuilder stringBuilder = new StringBuilder(size *= 16);
        stringBuilder.append(" [parsed={");
        Iterator iterator = set.iterator();
        i = 1;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            if (i != 0) {
            } else {
            }
            stringBuilder.append(", ");
            stringBuilder.append((p)next2.name());
            stringBuilder.append('=');
            stringBuilder.append(q.p(next2));
            i = 0;
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    private static String v(q<?> q) {
        String string;
        int i;
        final l0 eRROR_MESSAGE = l0.ERROR_MESSAGE;
        if (q.v(eRROR_MESSAGE)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Validation failed => ");
            stringBuilder.append((String)q.p(eRROR_MESSAGE));
            string = stringBuilder.toString();
            q.G(eRROR_MESSAGE, 0);
        } else {
            string = "Insufficient data:";
        }
        return string;
    }

    private boolean w() {
        boolean z2;
        boolean hVar;
        boolean z;
        final int i = 0;
        if (z()) {
            hVar = (i)this.d.get(i).d();
            if (hVar instanceof f) {
                z2 = (f)f.class.cast(hVar).b();
            } else {
                if (!hVar instanceof z) {
                    z2 = i;
                }
            }
        }
        return z2;
    }

    private boolean x() {
        Object wVar;
        int i;
        if (this.a.b() == null && this.b == null) {
            i = this.b == null ? 1 : 0;
        } else {
        }
        return i;
    }

    private static boolean y(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    public T D(java.lang.CharSequence charSequence) {
        boolean length;
        s sVar = new s();
        Object obj = E(charSequence, sVar);
        if (obj == null) {
        } else {
            int i = sVar.f();
            if (!this.m) {
                if (i < charSequence.length()) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unparsed trailing characters: ");
                stringBuilder.append(c.P(i, charSequence));
                ParseException parseException = new ParseException(stringBuilder.toString(), i);
                throw parseException;
            }
            return obj;
        }
        ParseException obj5 = new ParseException(sVar.d(), sVar.c());
        throw obj5;
    }

    public T E(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2) {
        if (this.n) {
            final w wVar = this.a;
            return c.F(this, wVar, wVar.o(), charSequence, s2, this.c, this.k, false, true);
        }
        return b(charSequence, s2, this.c);
    }

    public String I(T t) {
        return m(k(t, this.c));
    }

    public Set<net.time4j.g1.z.g> J(T t, java.lang.Appendable appendable2, d d3) {
        return K(k(t, d3), appendable2, d3, true);
    }

    Set<net.time4j.g1.z.g> K(o o, java.lang.Appendable appendable2, d d3, boolean z4) {
        int linkedHashSet;
        int i6;
        boolean stringBuilder3;
        int i10;
        int i8;
        boolean empty2;
        LinkedList list2;
        boolean peek2;
        Object stringBuilder2;
        int i;
        int i5;
        int empty;
        java.lang.Appendable appendable;
        int stringBuilder;
        Object obj3;
        d dVar2;
        int dVar;
        int i2;
        int i3;
        int linkedList;
        int i11;
        int i4;
        Object obj2;
        Object obj;
        int i9;
        Object peek;
        int i12;
        int i7;
        LinkedList list;
        final Object obj4 = this;
        final Object obj9 = o;
        final Object obj10 = appendable2;
        Objects.requireNonNull(obj10, "Missing text result buffer.");
        final int size = obj4.d.size();
        i10 = 0;
        i4 = d3 == obj4.c ? 1 : i10;
        if (z4) {
            linkedHashSet = new LinkedHashSet(size);
        } else {
            linkedHashSet = 0;
        }
        final String str2 = "Not formattable: ";
        if (obj4.h) {
            linkedList = new LinkedList();
            stringBuilder2 = new StringBuilder(size << 2);
            linkedList.push(stringBuilder2);
            if (z4) {
                stringBuilder2 = new LinkedList();
                stringBuilder2.push(linkedHashSet);
                i2 = stringBuilder2;
            } else {
                i2 = 0;
            }
            dVar2 = i10;
            while (dVar2 < size) {
                obj = obj8;
                i9 = (i)obj.b();
                i = i9;
                while (i > i10) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append((CharSequence)linkedList.peek());
                    linkedList.push(stringBuilder);
                    if (z4) {
                    }
                    i--;
                    linkedHashSet = new LinkedHashSet();
                    linkedHashSet.addAll((Collection)i2.peek());
                    i2.push(linkedHashSet);
                }
                while (i < i10) {
                    linkedList.pop();
                    linkedList.push((StringBuilder)linkedList.pop());
                    if (z4) {
                    }
                    i++;
                    i2.pop();
                    i2.push((Set)i2.pop());
                }
                if (z4) {
                }
                obj2 = linkedHashSet;
                i12 = dVar2;
                i7 = i2;
                list = linkedList;
                i5 = obj.r(o, (StringBuilder)linkedList.peek(), d3, obj2, i4);
                i6 = 0;
                stringBuilder = i7;
                list2 = list;
                if (obj.i()) {
                } else {
                }
                dVar = empty;
                dVar += stringBuilder2;
                linkedList = list2;
                i2 = stringBuilder;
                linkedHashSet = obj2;
                i10 = i9;
                dVar = obj.u();
                if (!obj.i()) {
                } else {
                }
                empty = i12;
                dVar = empty;
                list.pop();
                stringBuilder3 = new StringBuilder();
                if (!list.isEmpty()) {
                }
                list.push(stringBuilder3);
                if (z4) {
                } else {
                }
                stringBuilder = i7;
                i7.pop();
                stringBuilder3 = new LinkedHashSet();
                if (!i7.isEmpty()) {
                }
                i7.push(stringBuilder3);
                stringBuilder3.addAll((Collection)i7.peek());
                stringBuilder3.append((CharSequence)list.peek());
                dVar = empty + 1;
                while (dVar < size) {
                    obj3 = obj4.d.get(dVar);
                    dVar++;
                }
                obj3 = obj4.d.get(dVar);
                if ((i)obj3.i() != 0) {
                } else {
                }
                dVar++;
                if (obj3.f() == obj.f()) {
                } else {
                }
                linkedHashSet = i2.peek();
                linkedList.pop();
                linkedList.push((StringBuilder)linkedList.pop());
                if (z4) {
                }
                i++;
                i2.pop();
                i2.push((Set)i2.pop());
                stringBuilder = new StringBuilder();
                stringBuilder.append((CharSequence)linkedList.peek());
                linkedList.push(stringBuilder);
                if (z4) {
                }
                i--;
                linkedHashSet = new LinkedHashSet();
                linkedHashSet.addAll((Collection)i2.peek());
                i2.push(linkedHashSet);
                StringBuilder string2 = obj11;
            }
            appendable = i2;
            i10 = linkedList;
            i10.clear();
            obj10.append((StringBuilder)i10.peek());
            if (z4) {
                linkedHashSet = appendable.peek();
                appendable.clear();
            }
        } else {
            i11 = i10;
            while (i11 < size) {
                obj2 = obj5;
                (i)obj2.r(o, appendable2, d3, linkedHashSet, i4);
                if (obj2.i()) {
                }
                i11 += i10;
                i11 = obj2.u();
            }
        }
        if (z4) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return 0;
    }

    net.time4j.g1.z.c<T> R(Map<p<?>, Object> map, net.time4j.g1.z.b b2) {
        final net.time4j.g1.z.b obj5 = b.k(b2, this.c);
        c cVar2 = new c(this, map);
        c cVar = new c(cVar2, obj5, (d)obj5.a(a.a, 0));
        return cVar;
    }

    public <A extends Enum<A>> net.time4j.g1.z.c<T> S(c<A> c, A a2) {
        a.b bVar = new a.b();
        bVar.f(this.c.e());
        bVar.d(c, a2);
        c obj4 = new c(this, bVar.a());
        return obj4;
    }

    public net.time4j.g1.z.c<T> T(g g) {
        return S(a.f, g);
    }

    public net.time4j.g1.z.c<T> U(l l) {
        Objects.requireNonNull(l, "Missing timezone id.");
        a.b bVar = new a.b();
        bVar.f(this.c.e());
        bVar.i(l.z());
        c cVar = new c(this, this.c.l(bVar.a()).m(a.e, l.E()));
        return cVar;
    }

    public net.time4j.g1.z.c<T> V(k k) {
        return U(l.N(k));
    }

    public <R> R a(T t, java.lang.Appendable appendable2, d d3, s<o, R> s4) {
        o obj2 = k(t, d3);
        K(obj2, appendable2, d3, false);
        return s4.apply(obj2);
    }

    public T b(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3) {
        Object pVar2;
        int i2;
        Object obj3;
        int i;
        k kVar;
        net.time4j.g1.z.s sVar;
        g eARLIER_OFFSET;
        Object pVar;
        Object obj2;
        int i3;
        int i4;
        Object obj4;
        Object obj;
        final Object obj9 = this;
        final net.time4j.g1.z.s sVar3 = s2;
        final net.time4j.g1.z.b bVar2 = d3;
        net.time4j.g1.z.b bVar = obj9.c;
        if (bVar2 != bVar) {
            pVar2 = new p(bVar2, bVar);
            obj4 = pVar2;
            obj = obj3;
            i4 = i;
        } else {
            obj = pVar2;
            i4 = obj3;
            obj4 = bVar2;
        }
        net.time4j.g1.z.c.e eVar = obj9.b;
        final net.time4j.g1.z.c.e eVar3 = obj9.b;
        Object obj5 = c.F(this, eVar3, eVar.i(), charSequence, s2, obj4, obj, true, i4);
        int i5 = 0;
        if (eVar != null && s2.i()) {
            eVar3 = obj9.b;
            obj5 = c.F(this, eVar3, eVar.i(), charSequence, s2, obj4, obj, true, i4);
            i5 = 0;
            if (s2.i()) {
                return i5;
            }
            q qVar = s2.h();
            if (qVar.j()) {
                kVar = qVar.t();
            } else {
                c cVar4 = a.d;
                if (obj4.c(cVar4)) {
                    kVar = obj4.b(cVar4);
                } else {
                    kVar = i5;
                }
            }
            if (kVar != null) {
                sVar = bVar2.a(a.u, eVar3.a());
                a0 dAYLIGHT_SAVING = a0.DAYLIGHT_SAVING;
                if (qVar.v(dAYLIGHT_SAVING)) {
                    eARLIER_OFFSET = (Boolean)qVar.p(dAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET;
                    i2 = (s)(s)obj5.a(l.N(kVar).Q((o)obj4.a(a.e, l.c).a(eARLIER_OFFSET)), (d0)sVar);
                } else {
                    pVar = a.e;
                    if (obj4.c(pVar)) {
                        i2 = obj5.a(l.N(kVar).Q((o)obj4.b(pVar)), sVar);
                    } else {
                        i2 = obj5.a(l.N(kVar), sVar);
                    }
                }
            } else {
                i2 = i5;
            }
            if (i2 == 0) {
                sVar3.k(charSequence.length(), "Missing timezone or offset.");
                return i5;
            }
            qVar.G(b0.V().E(), i2);
            c.h(i2);
            if (obj.isStrict()) {
                c.i(qVar, i2, charSequence, sVar3);
            }
            return i2;
        }
        return c.G(this, obj9.a, 0, charSequence, s2, obj4, obj, i4);
    }

    @Override // net.time4j.g1.z.e
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object wVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof c) {
            if (this.a.equals(object.a) && c.y(this.b, object.b) && this.c.equals(object.c) && this.e.equals(object.e) && this.d.equals(object.d)) {
                if (c.y(this.b, object.b)) {
                    if (this.c.equals(object.c)) {
                        if (this.e.equals(object.e)) {
                            if (this.d.equals(object.d)) {
                            } else {
                                i = i2;
                            }
                        } else {
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

    @Override // net.time4j.g1.z.e
    public int hashCode() {
        return i3 += i8;
    }

    public String l(T t) {
        return I(t);
    }

    @Override // net.time4j.g1.z.e
    public d o() {
        return this.c;
    }

    @Override // net.time4j.g1.z.e
    net.time4j.g1.z.b p() {
        return this.c;
    }

    public w<T> q() {
        return this.a;
    }

    Map<p<?>, Object> r() {
        return this.e;
    }

    @Override // net.time4j.g1.z.e
    public String toString() {
        net.time4j.g1.z.c.e eVar;
        int i2;
        Object next;
        int i;
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("net.time4j.format.ChronoFormatter[chronology=");
        stringBuilder.append(this.a.l().getName());
        if (this.b != null) {
            stringBuilder.append(", override=");
            stringBuilder.append(this.b);
        }
        stringBuilder.append(", default-attributes=");
        stringBuilder.append(this.c);
        stringBuilder.append(", default-values=");
        stringBuilder.append(this.e);
        stringBuilder.append(", processors=");
        i2 = 1;
        Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            if (i2 != 0) {
            } else {
            }
            stringBuilder.append('|');
            stringBuilder.append((i)iterator.next());
            i2 = 0;
            stringBuilder.append('{');
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    @Override // net.time4j.g1.z.e
    public Locale u() {
        return this.c.h();
    }

    @Override // net.time4j.g1.z.e
    boolean z() {
        int i2;
        int i;
        if (this.p == 1 && !this.g) {
            if (!this.g) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
