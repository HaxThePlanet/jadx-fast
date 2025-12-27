package net.time4j.g1.z;

import java.io.IOException;
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
import net.time4j.engine.d0;
import net.time4j.engine.f0;
import net.time4j.engine.l0;
import net.time4j.engine.m0;
import net.time4j.engine.n;
import net.time4j.engine.q;
import net.time4j.engine.r;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.g0;
import net.time4j.g1.a.b;
import net.time4j.g1.e;
import net.time4j.g1.v;
import net.time4j.h0;
import net.time4j.tz.k;

/* compiled from: ChronoFormatter.java */
/* loaded from: classes3.dex */
public final class c<T> implements e<T>, d<T> {

    private final w<T> a;
    private final c.e<?> b;
    private final b c;
    private final List<i> d;
    private final Map<net.time4j.engine.p<?>, Object> e;
    private final j f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final int j;
    private final net.time4j.g1.g k;
    private final boolean l;
    private final boolean m;
    private final boolean n;
    private final w<?> o;
    private final int p;
    private final boolean q;

    static class c {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[w.values().length];
            c.c.a = iArr;
            try {
                iArr[w.CLDR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.c.a[w.CLDR_24.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.c.a[w.CLDR_DATE.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                c.c.a[w.SIMPLE_DATE_FORMAT.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public static final class d<T> {

        private static final c<net.time4j.l> n;
        private final w<T> a;
        private final w<?> b;
        private final Locale c;
        private List<i> d;
        private LinkedList<b> e;
        private int f;
        private int g;
        private int h;
        private String i;
        private net.time4j.l j;
        private Map<net.time4j.engine.p<?>, Object> k;
        private w<?> l;
        private int m;
        static {
            c.d.n = a.e("CUSTOM_DAY_PERIOD", l.class);
        }

        /* synthetic */ d(w wVar, Locale locale, c.a aVar) {
            this(wVar, locale);
        }

        private i H(net.time4j.engine.p<?> pVar) {
            Object item;
            int i = 0;
            if (this.d.isEmpty()) {
            } else {
                i2 = this.d.size() - 1;
                item = this.d.get(i2);
            }
            if (this.d == null) {
                return null;
            }
            return item;
        }

        private static void I(c<?> cVar) {
            if (cVar.name().charAt(0) == 95) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Internal attribute not allowed: ";
                String name2 = cVar.name();
                cVar = str + name2;
                throw new IllegalArgumentException(cVar);
            }
        }

        private void J(net.time4j.engine.p<?> pVar) {
            final w wVar5 = c.j(this.a, this.b, pVar);
            int i = c.s(wVar5, this.a, this.b);
            if (i >= this.m) {
                this.l = wVar5;
                this.m = i;
            }
        }

        private void K() {
            if (!c.d.R(this.a)) {
                throw new IllegalStateException("Timezone names in specific non-location format can only be reliably combined with instant-like types, for example \"Moment\".");
            }
        }

        private void M() {
            int i;
            i = this.d.size() - 1;
            while (this.d >= 0) {
                Object item = this.d.get(i);
                if (item.i()) {
                    return;
                }
            }
        }

        private void N(boolean z, boolean z2) {
            M();
            if (!z && !z2) {
                int i2 = -1;
                if (this.g != -1) {
                    throw new IllegalArgumentException("Cannot add fractional element with variable width after another numerical element with variable width.");
                }
            }
        }

        private net.time4j.g1.t<?> O(boolean z, net.time4j.l lVar) {
            net.time4j.g1.a aVar;
            Object last;
            w wVar;
            Locale locale;
            char symbol;
            char c;
            if (lVar != null) {
                if (this.e.isEmpty()) {
                    net.time4j.g1.z.b bVar3 = new b(new a.b(P()).a(), this.c);
                } else {
                }
                net.time4j.g1.z.b bVar2 = last.m(c.d.n, lVar);
            }
            Iterator it2 = h0.k0().o().iterator();
            while (it2.hasNext()) {
                Object it = (r)it2.next().c(this.c, aVar).iterator();
                while (it.hasNext()) {
                    Locale item = it.next();
                    if (!z) {
                        c = 'B';
                    }
                    c = 'b';
                }
                item = it.next();
                if (!z) {
                    c = 'B';
                }
                c = 'b';
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Day periods are not supported: ";
            Class cls = P().l();
            lVar = str + cls;
            throw new IllegalStateException(lVar);
        }

        private static int Q(b bVar) {
            if (bVar == null) {
                return 0;
            }
            return bVar.g();
        }

        private static boolean R(w<?> wVar) {
            while (f.class.isAssignableFrom(wVar.l())) {
                if (wVar.b() == null) {
                    return false;
                }
            }
            return true;
        }

        private boolean S(net.time4j.engine.p<?> pVar) {
            w wVar2;
            boolean z3 = false;
            if (!pVar.name().endsWith("_DAY_PERIOD")) {
                return false;
            }
            final boolean z4 = true;
            if (this.b == null) {
                if (!this.a.x(pVar)) {
                    wVar2 = wVar2.b();
                    while (wVar2 != null) {
                        if (wVar2.x(pVar)) {
                            return true;
                        }
                        wVar2 = wVar2.b();
                    }
                    return false;
                }
            }
            return true;
        }

        private void V() {
            this.h = 0;
        }

        static /* synthetic */ void a(c.d dVar, h hVar) {
            dVar.w(hVar);
        }

        static /* synthetic */ w b(c.d dVar) {
            return dVar.a;
        }

        static /* synthetic */ boolean c(w wVar) {
            return c.d.R(wVar);
        }

        private void o(StringBuilder sb) {
            if (sb.length() > 0) {
                n(sb.toString());
                int length = 0;
                sb.setLength(length);
            }
        }

        private <V> c.d<T> s(net.time4j.engine.p<V> pVar, boolean z, int i, int i2, x xVar) {
            this.t(pVar, z, i, i2, xVar, false);
            return this;
        }

        private <V> c.d<T> t(net.time4j.engine.p<V> pVar, boolean z, int i, int i2, x xVar, boolean z2) {
            J(pVar);
            final net.time4j.g1.z.i iVar = H(pVar);
            r rVar = new r(pVar, z, i, i2, xVar, z2);
            if (!z) {
                if (iVar != null && iVar.j()) {
                    if (!iVar.i()) {
                        throw new IllegalStateException("Numerical element with variable width can't be inserted after another numerical element. Consider \"addFixedXXX()\" instead.");
                    }
                }
                w(rVar);
                i = this.d.size() - 1;
                this.g = i;
            } else {
                if (this.g == -1) {
                    w(rVar);
                } else {
                    Object item = this.d.get(this.g);
                    w(rVar);
                    if (item.f() == (i)this.d.get(this.d.size() - 1).f()) {
                        this.g = this.g;
                        this.d.set(this.g, item.t(i));
                    }
                }
            }
            return this;
        }

        private void w(h<?> hVar) {
            net.time4j.g1.z.b bVar = null;
            int i;
            net.time4j.g1.z.i iVar;
            this.g = -1;
            i = 0;
            if (!this.e.isEmpty()) {
                Object last = this.e.getLast();
                i = last.g();
                i = last.i();
            } else {
                int i3 = 0;
            }
            if (this.h > 0) {
                iVar = new i(hVar, i, i, bVar).n(this.h, i);
                this.h = i;
            }
            this.d.add(iVar);
        }

        public c.d<T> A(net.time4j.g1.t<?> tVar) {
            J(tVar);
            w(a0.a(tVar));
            return this;
        }

        public c.d<T> B() {
            if (!c.d.R(this.a)) {
                throw new IllegalStateException("Only unix timestamps can have a timezone id.");
            } else {
                w(c0.INSTANCE);
                return this;
            }
        }

        public c.d<T> C(e eVar, boolean z, List<String> list) {
            w(new e0(eVar, z, list));
            return this;
        }

        public c.d<T> D(net.time4j.engine.p<Integer> pVar) {
            J(pVar);
            H(pVar);
            net.time4j.g1.z.f0 f0Var = new f0(pVar);
            int i = -1;
            if (this.g == -1) {
                w(f0Var);
                i3 = this.d.size() - 1;
                this.g = i3;
            } else {
                Object item2 = this.d.get(this.g);
                b0(a.f, g.STRICT);
                w(f0Var);
                L();
                if (item2.f() == (i)this.d.get(this.d.size() - 1).f()) {
                    this.g = this.g;
                    int i2 = 2;
                    this.d.set(this.g, item2.t(i2));
                }
            }
            return this;
        }

        c.d<T> E(net.time4j.engine.p<Integer> pVar, int i, boolean z) {
            Object item = null;
            if (this.d.isEmpty()) {
                int i4 = 0;
            } else {
                i = this.d.size() - 1;
                item = this.d.get(i);
            }
            this.t(pVar, false, i, 10, x.SHOW_WHEN_NEGATIVE, z);
            return this;
        }

        public c<T> F() {
            return G(a.f());
        }

        public c<T> G(net.time4j.g1.a aVar) {
            net.time4j.g1.z.c cVar;
            String str;
            int i;
            net.time4j.g1.z.b bVar;
            int i2;
            boolean empty2;
            Object item;
            int value;
            Integer num;
            boolean z;
            int i3;
            int i4;
            Objects.requireNonNull(aVar, "Missing format attributes.");
            int size = this.d.size();
            i = 0;
            final net.time4j.g1.z.c.a aVar3 = null;
            i2 = aVar3;
            while (i < "Missing format attributes.") {
                item = this.d.get(i);
                if (item.i()) {
                    i3 = size - 1;
                }
            }
            if (i2 != 0) {
                Iterator it = i2.keySet().iterator();
                while (it.hasNext()) {
                    Object item2 = it.next();
                    this.d.set(item2.intValue(), i2.get(item2));
                }
            }
            cVar = new c(this.a, this.b, this.c, this.d, this.k, aVar, this.l, null);
            if (this.i == null) {
                str = "";
            }
            if (this.j != null || !this.i.isEmpty()) {
                if (!str.isEmpty()) {
                    bVar = cVar.c.m(a.x, str);
                }
                if (this.j != null) {
                    bVar = bVar.m(c.d.n, this.j);
                }
            }
            return cVar;
        }

        public c.d<T> L() {
            this.e.removeLast();
            V();
            return this;
        }

        public w<?> P() {
            w wVar;
            if (this.b == null) {
            }
            return wVar;
        }

        public c.d<T> U() {
            int i = 0;
            int i2;
            int i3 = 0;
            if (!this.e.isEmpty()) {
                i = (b)this.e.getLast().i();
            } else {
                i = 0;
            }
            i2 = -1;
            if (!this.d.isEmpty()) {
                i2 = this.d.size() - 1;
                i2 = (i)this.d.get(i2).f();
            } else {
                i3 = 0;
            }
            if (this.e != i2) {
                throw new IllegalStateException("Cannot start or-block without any previous step in current section.");
            } else {
                this.d.set(i2, i3.v());
                V();
                this.g = i2;
                return this;
            }
        }

        public c.d<T> W(n<Character> nVar, int i) {
            w(new y(nVar, i));
            return this;
        }

        public c.d<T> X() {
            Y(null);
            return this;
        }

        public c.d<T> Y(n<net.time4j.engine.o> nVar) {
            n nVar2;
            net.time4j.g1.z.b bVar2 = null;
            V();
            a.b bVar = new a.b();
            if (!this.e.isEmpty()) {
                bVar.f(last.e());
                nVar2 = last.f();
            } else {
            }
            this.f++;
            if (nVar != null) {
                n r8 = this.e == null ? nVar : new c.d.a(this, nVar2, nVar);
            } else {
            }
            b nVar3 = new b(bVar.a(), this.c, c.d.Q(bVar2) + 1, i5, (this.e == null ? nVar : new c.d.a(this, nVar2, nVar)));
            this.e.addLast(nVar3);
            return this;
        }

        public c.d<T> Z(c<Character> cVar, char c) {
            net.time4j.g1.z.b bVar2;
            c.d.I(cVar);
            V();
            if (this.e.isEmpty()) {
                a.b bVar = new a.b();
                bVar.b(cVar, c);
                bVar2 = new b(bVar.a(), this.c);
            } else {
                Object last = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f(last.e());
                bVar3.b(cVar, c);
                bVar2 = last.l(bVar3.a());
            }
            this.e.addLast(bVar2);
            return this;
        }

        public c.d<T> a0(c<Integer> cVar, int i) {
            net.time4j.g1.z.b bVar2;
            c.d.I(cVar);
            V();
            if (this.e.isEmpty()) {
                a.b bVar = new a.b();
                bVar.c(cVar, i);
                bVar2 = new b(bVar.a(), this.c);
            } else {
                Object last = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f(last.e());
                bVar3.c(cVar, i);
                bVar2 = last.l(bVar3.a());
            }
            this.e.addLast(bVar2);
            return this;
        }

        public <A extends Enum<A>> c.d<T> b0(c<A> cVar, A a) {
            net.time4j.g1.z.b bVar2;
            c.d.I(cVar);
            V();
            if (this.e.isEmpty()) {
                a.b bVar = new a.b();
                bVar.d(cVar, a);
                bVar2 = new b(bVar.a(), this.c);
            } else {
                Object last = this.e.getLast();
                a.b bVar3 = new a.b();
                bVar3.f(last.e());
                bVar3.d(cVar, a);
                bVar2 = last.l(bVar3.a());
            }
            this.e.addLast(bVar2);
            return this;
        }

        public <V> c.d<T> d(net.time4j.engine.p<V> pVar, e<V> eVar, d<V> dVar) {
            J(pVar);
            w(new f(pVar, eVar, dVar));
            return this;
        }

        public c.d<T> e() {
            A(O(false, null));
            return this;
        }

        public c.d<T> f() {
            A(O(true, null));
            return this;
        }

        public c.d<T> g(net.time4j.engine.p<Integer> pVar, int i) {
            this.s(pVar, true, i, i, x.SHOW_NEVER);
            return this;
        }

        public <V extends Enum<V>> c.d<T> h(net.time4j.engine.p<V> pVar, int i) {
            this.s(pVar, true, i, i, x.SHOW_NEVER);
            return this;
        }

        public c.d<T> i(net.time4j.engine.p<Integer> pVar, int i, int i2, boolean z) {
            J(pVar);
            i = 1;
            int r1 = !z && i == i2 ? i : 0;
            N(r1, z);
            final net.time4j.g1.z.j jVar = new j(pVar, i, i2, z);
            if (this.g == -1 || !r1) {
                w(jVar);
            } else {
                Object item = this.d.get(this.g);
                w(jVar);
                i4 = this.d.size() - i;
                if (item.f() == (i)this.d.get(i4).f()) {
                    this.g = this.g;
                    this.d.set(this.g, item.t(i));
                }
            }
            return this;
        }

        public c.d<T> j(net.time4j.engine.p<Integer> pVar, int i, int i2) {
            this.s(pVar, false, i, i2, x.SHOW_NEVER);
            return this;
        }

        public c.d<T> k(net.time4j.engine.p<Integer> pVar, int i, int i2, x xVar) {
            this.s(pVar, false, i, i2, xVar);
            return this;
        }

        public c.d<T> l(char c) {
            n(String.valueOf(c));
            return this;
        }

        public c.d<T> m(char c, char c2) {
            w(new m(c, c2));
            return this;
        }

        public c.d<T> n(String str) {
            Object item;
            int i;
            net.time4j.g1.z.m mVar = new m(str);
            int i4 = mVar.b();
            if (i4 > 0) {
                if (this.d.isEmpty()) {
                    int i7 = 0;
                } else {
                    i = this.d.size() - 1;
                    item = this.d.get(i);
                }
                if (this.d != null && this.d.g()) {
                    if (!item.i()) {
                        throw new IllegalStateException("Numerical literal can't be inserted after an element with decimal digits.");
                    }
                }
            }
            if (i4 != 0) {
                i = -1;
                if (this.g == -1) {
                    w(mVar);
                } else {
                    Object item2 = this.d.get(this.g);
                    w(mVar);
                    i3 = this.d.size() - 1;
                    if (item2.f() == (i)this.d.get(i3).f()) {
                        this.g = this.g;
                        this.d.set(this.g, item2.t(i4));
                    }
                }
            }
            return this;
        }

        public c.d<T> p() {
            w(new n(false));
            return this;
        }

        public c.d<T> q(net.time4j.engine.p<Long> pVar, int i, int i2, x xVar) {
            this.s(pVar, false, i, i2, xVar);
            return this;
        }

        public c.d<T> r() {
            K();
            w(new d0(false));
            return this;
        }

        public <V extends Enum<V>> c.d<T> u(net.time4j.engine.p<V> pVar, int i, int i2) {
            this.s(pVar, false, i, i2, x.SHOW_NEVER);
            return this;
        }

        public c.d<T> v(String str, w wVar) {
            Map registerSymbol;
            int length;
            Locale locale;
            StringBuilder stringBuilder;
            int i = 0;
            boolean empty;
            int i2;
            char charAt;
            String str2;
            char charAt2;
            char charAt3;
            String str3;
            Objects.requireNonNull(wVar, "Missing pattern type.");
            registerSymbol = Collections.emptyMap();
            length = str.length();
            stringBuilder = new StringBuilder();
            if (!this.e.isEmpty()) {
                locale = (b)this.e.getLast().h();
            }
            i = 0;
            while (i < length) {
                char charAt4 = str.charAt(i);
                if (!c.d.T(charAt4)) {
                    String str7 = "'";
                    char c = '\'';
                }
            }
            o(stringBuilder);
            if (!registerSymbol.isEmpty()) {
                while (this.e < this.d.size()) {
                    Object item = this.d.get(i);
                    net.time4j.engine.p element = item.d().getElement();
                    i = i + 1;
                }
            }
            if (this.i != null) {
                str3 = "";
            }
            this.i = str3;
            return this;
        }

        public c.d<T> x() {
            w(new n(true));
            return this;
        }

        public c.d<T> y() {
            K();
            w(new d0(true));
            return this;
        }

        public <V extends Enum<V>> c.d<T> z(net.time4j.engine.p<V> pVar) {
            int i = 0;
            Object obj;
            String obj2;
            J(pVar);
            if (pVar instanceof t) {
                hashMap = t.class;
                w(a0.a((t)hashMap.cast(pVar)));
            } else {
                HashMap hashMap = new HashMap();
                Object[] enumConstants = pVar.getType().getEnumConstants();
                length = enumConstants.length;
                i = 0;
                for (Object obj : enumConstants) {
                    hashMap.put(obj, obj.toString());
                }
                w(new o(pVar, hashMap));
            }
            return this;
        }

        private d(w<T> wVar, Locale locale) {
            this(wVar, locale, null);
        }

        private d(w<T> wVar, Locale locale, w<?> wVar2) {
            super();
            Objects.requireNonNull(wVar, "Missing chronology.");
            Objects.requireNonNull(locale, "Missing locale.");
            this.a = wVar;
            this.b = wVar2;
            this.c = locale;
            this.d = new ArrayList();
            this.e = new LinkedList();
            int i = 0;
            this.f = i;
            this.g = -1;
            this.h = i;
            String str3 = null;
            this.i = str3;
            this.j = str3;
            this.k = new HashMap();
            this.l = wVar;
            this.m = i;
        }

        private static boolean T(char c) {
            int i = 90;
            boolean z = true;
            i = 65;
            if (c < 65 || c > 90) {
                i = 97;
                c = c >= 97 && c <= 122 ? 1 : 0;
            }
            return (c >= 97 && c <= 122 ? 1 : 0);
        }
    }

    static class a implements e<k> {
        a() {
            super();
        }

        public <R> R b(k kVar, java.lang.Appendable appendable, net.time4j.engine.d dVar, net.time4j.engine.s<net.time4j.engine.o, R> sVar) {
            return null;
        }
    }

    static class b implements d<k> {

        final /* synthetic */ Map a;
        b(Map map) {
            this.a = map;
            super();
        }

        public k a(java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar) {
            final int i3 = sVar.f();
            final int i = i3 + 3;
            if (i <= charSequence.length()) {
                Object value = this.a.get(charSequence.subSequence(i3, i).toString());
                if (value != null) {
                    sVar.l(i);
                    return value;
                }
                str = "No time zone information found.";
                sVar.k(i3, str);
            }
            return null;
        }
    }

    private static class e<C> implements net.time4j.engine.t<net.time4j.s<C>> {

        private final w<C> a;
        private final List<r> b;
        private e(w<C> wVar) {
            super();
            this.a = wVar;
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(wVar.o());
            arrayList.addAll(h0.k0().o());
            this.b = Collections.unmodifiableList(arrayList);
        }

        static <C> c.e<C> j(w<C> wVar) {
            if (wVar == null) {
                return null;
            }
            return new c.e(wVar);
        }

        public d0 a() {
            return this.a.a();
        }

        public w<?> b() {
            throw new UnsupportedOperationException("Not used.");
        }

        public int d() {
            return this.a.d();
        }

        @Override // java.lang.Object
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object instanceof c.e) {
                return this.a.equals(object.a);
            }
            return false;
        }

        public String f(x xVar, Locale locale) {
            throw new UnsupportedOperationException("Not used.");
        }

        public net.time4j.s<C> g(q<?> qVar, net.time4j.engine.d dVar, boolean z, boolean z2) {
            net.time4j.s sVar;
            Object obj = this.a.c(qVar, dVar, z, z2);
            net.time4j.engine.i0 i0Var = h0.k0().D(qVar, dVar, z, z2);
            if (obj instanceof l) {
                sVar = s.b((l)l.class.cast(obj), i0Var);
                c.h(sVar);
                return sVar;
            } else {
                if (obj instanceof m) {
                    sVar = s.c((m)m.class.cast(obj), i0Var);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot determine calendar type: ";
            dVar = str + obj;
            throw new IllegalStateException(dVar);
        }

        public w<?> h() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.a.hashCode();
        }

        public List<r> i() {
            return this.b;
        }

        public net.time4j.engine.o k(net.time4j.s<C> sVar, net.time4j.engine.d dVar) {
            throw new UnsupportedOperationException("Not used.");
        }

        @Override // java.lang.Object
        public String toString() {
            return this.a.l().getName();
        }
    }

    private static class f implements net.time4j.engine.o, m0, net.time4j.f1.f {

        private final net.time4j.s<?> a;
        private final k b;
        /* synthetic */ f(net.time4j.s sVar, String str, k kVar, c.a aVar) {
            this(sVar, str, kVar);
        }

        private net.time4j.f1.f b() {
            d0 d0Var;
            try {
                d0Var = w.y(this.a.d().getClass()).a();
            } catch (RuntimeException unused) {
            }
            return this.a.a(l.N(this.b), d0Var);
        }

        public int a() {
            return b().a();
        }

        public int e(net.time4j.engine.p<Integer> pVar) {
            return this.a.e(pVar);
        }

        public <V> V p(net.time4j.engine.p<V> pVar) {
            return this.a.p(pVar);
        }

        public <V> V r(net.time4j.engine.p<V> pVar) {
            return this.a.r(pVar);
        }

        public k t() {
            return this.b;
        }

        public boolean v(net.time4j.engine.p<?> pVar) {
            return this.a.v(pVar);
        }

        public <V> V w(net.time4j.engine.p<V> pVar) {
            return this.a.w(pVar);
        }

        public long x() {
            return b().x();
        }

        private f(net.time4j.s<?> sVar, String str, k kVar) {
            super();
            this.a = sVar;
            this.b = kVar;
        }

        public boolean j() {
            return true;
        }
    }
    static {
        c.L();
    }

    /* synthetic */ c(w wVar, w wVar2, Locale locale, List list, Map map, net.time4j.g1.a aVar, w wVar3, c.a aVar2) {
        this(wVar, wVar2, locale, list, map, aVar, wVar3);
    }

    private static boolean A(w<?> wVar, w<?> wVar2, net.time4j.engine.p<?> pVar) {
        Iterator it;
        w wVar3;
        Iterator it3;
        it = wVar.o().iterator();
        boolean z2 = true;
        while (it.hasNext()) {
            if ((r)it.next().a(pVar)) {
                return true;
            }
            z2 = true;
        }
        if (wVar2 == null) {
            wVar3 = wVar3.b();
            while (wVar3 != null) {
                it3 = wVar3.o().iterator();
                while (it3.hasNext()) {
                    if ((r)it3.next().a(pVar)) {
                        return true;
                    }
                }
                wVar3 = wVar3.b();
                if ((r)it3.next().a(pVar)) {
                    return true;
                }
            }
        } else {
            if (pVar.isDateElement()) {
                Iterator it2 = wVar2.o().iterator();
                while (it2.hasNext()) {
                    if ((r)it2.next().a(pVar)) {
                        return true;
                    }
                }
            } else {
                if (pVar.isTimeElement()) {
                    if (h0.k0().x(pVar)) {
                        it2 = h0.k0().o().iterator();
                        while (it2.hasNext()) {
                            if ((r)it2.next().a(pVar)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static c<b0> B(e eVar, e eVar2, Locale locale, k kVar) {
        final net.time4j.g1.z.c.d dVar = new c.d(b0.V(), locale, null);
        dVar.w(new z(eVar, eVar2));
        return dVar.F().V(kVar);
    }

    public static <T> c<T> C(String str, w wVar, Locale locale, w<T> wVar2) {
        final net.time4j.g1.z.c.d dVar = new c.d(wVar2, locale, null);
        c.g(dVar, str, wVar);
        try {
        } catch (java.lang.IllegalStateException ise) {
            wVar = new IllegalArgumentException(ise);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) wVar;
        }
        return dVar.F();
    }

    private static <T> T F(c<?> cVar, net.time4j.engine.t<T> tVar, List<r> list, java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar, net.time4j.g1.g gVar, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        Object cVar2;
        int i;
        net.time4j.g1.z.j jVar;
        java.lang.CharSequence charSequence42;
        net.time4j.g1.z.s sVar52;
        net.time4j.engine.d dVar62;
        net.time4j.g1.z.u uVar;
        boolean z92;
        q qVar;
        cVar2 = cVar;
        sVar52 = sVar;
        dVar62 = dVar;
        final boolean z82 = z;
        final int length = charSequence.length();
        if (sVar.f() >= length) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str5 = "[";
            int i4 = sVar.f();
            String str6 = "]: ";
            String charSequence2 = charSequence.toString();
            r1 = str5 + i4 + str6 + charSequence2;
            throw new IndexOutOfBoundsException(r1);
        } else {
            final int i2 = 0;
            i = 0;
            try {
                uVar = new u();
                (i)cVar2.q(charSequence, sVar, dVar, uVar, z2);
            } catch (java.lang.ClassCastException unused) {
            } catch (net.time4j.g1.z.a e1) {
            }
            try {
            } catch (java.lang.ClassCastException unused) {
            } catch (net.time4j.g1.z.a e1) {
            }
            return i;
        }
    }

    private static <C> C G(c<?> cVar, w<C> wVar, int i, java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar, net.time4j.g1.g gVar, boolean z) {
        Object obj;
        Object obj2;
        Object stringBuilder3;
        boolean z2;
        final net.time4j.g1.z.s sVar52 = sVar;
        wVar = wVar.b();
        z2 = false;
        if (wVar != null) {
            if (wVar != cVar.o) {
                if (wVar == cVar.o) {
                    boolean z82 = true;
                    obj2 = c.F(cVar, wVar, wVar.o(), charSequence, sVar, dVar, gVar, z82, z);
                } else {
                    obj2 = c.G(cVar, wVar, i + 1, charSequence, sVar, dVar, gVar, z);
                }
                int i2 = 0;
                if (sVar.i()) {
                    return null;
                }
                if (obj2 == null) {
                    q qVar2 = sVar.g();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str5 = c.v(qVar2);
                    String str = c.t(qVar2);
                    str2 = str5 + str;
                    sVar52.k(charSequence.length(), str2);
                    return i2;
                }
                q qVar = sVar.h();
                try {
                    c.Q(qVar, (f0)f0.class.cast(wVar).E(), obj2);
                    obj = wVar.c(qVar, dVar, gVar.isLax(), z2);
                } catch (RuntimeException e) {
                }
            }
            try {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str7 = "Unsupported chronology or preparser: ";
                r0 = str7 + wVar;
                throw new IllegalStateException(r0);
            } catch (RuntimeException e) {
            }
            stringBuilder3 = new StringBuilder();
            Throwable e2 = e.getMessage();
            e2 = c.t(qVar3);
            e2 = e2 + e2;
            obj6.k(charSequence.length(), e2);
            return obj4;
        }
        boolean r8 = i > 0 ? 1 : z2;
        return c.F(cVar, wVar, wVar.o(), charSequence, sVar, dVar, gVar, (i > 0 ? 1 : z2), z);
    }

    private q<?> H(java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar, boolean z, int i) {
        net.time4j.g1.z.v vVar;
        int i3 = 0;
        java.lang.CharSequence charSequence2;
        net.time4j.g1.z.s sVar22;
        int i4;
        net.time4j.engine.d dVar32;
        int i6;
        boolean z42;
        int i7;
        final Object charSequence3 = this;
        sVar22 = sVar;
        final int i52 = i;
        vVar = new v(i52, charSequence3.l);
        vVar.f0(sVar.f());
        final Object obj3 = null;
        if (charSequence3.g) {
            LinkedList linkedList = new LinkedList();
            linkedList.push(vVar);
        } else {
            i7 = obj3;
        }
        final int size = charSequence3.d.size();
        i3 = 0;
        while (i3 < size) {
            sVar.b();
            item.q(charSequence, sVar, dVar, vVar, z);
            if (sVar.i()) {
                int i2 = item.f();
            }
        }
        while (charSequence3.d > 0) {
            (v)i7.peek().Z((v)i7.pop());
            i3 = i3 - 1;
        }
        if (i7 != 0) {
            Object peek3 = i7.peek();
        }
        vVar.e0();
        return vVar;
    }

    private static c<b0> L() {
        net.time4j.g1.z.c.d dVar = c.N(b0.class, Locale.ENGLISH);
        c.M(dVar);
        dVar.C(e.MEDIUM, false, Arrays.asList(new String[] { "GMT", "UT", "Z" }));
        dVar.U();
        c.M(dVar);
        HashMap hashMap = new HashMap();
        net.time4j.tz.f bEHIND_UTC2 = f.BEHIND_UTC;
        int i2 = 5;
        hashMap.put("EST", p.s(bEHIND_UTC2, i2));
        hashMap.put("EDT", p.s(bEHIND_UTC2, 4));
        int i5 = 6;
        hashMap.put("CST", p.s(bEHIND_UTC2, i5));
        hashMap.put("CDT", p.s(bEHIND_UTC2, i2));
        int i3 = 7;
        hashMap.put("MST", p.s(bEHIND_UTC2, i3));
        hashMap.put("MDT", p.s(bEHIND_UTC2, i5));
        hashMap.put("PST", p.s(bEHIND_UTC2, 8));
        hashMap.put("PDT", p.s(bEHIND_UTC2, i3));
        dVar.w(new f(b0.TIMEZONE_OFFSET, new c.a(), new c.b(hashMap)));
        return dVar.F().V(p.C);
    }

    private static void M(c.d<b0> dVar) {
        dVar.X();
        c cVar = a.g;
        v aBBREVIATED2 = v.ABBREVIATED;
        dVar.b0(cVar, aBBREVIATED2);
        dVar.z(g0.N);
        dVar.L();
        dVar.n(", ");
        dVar.L();
        final int i3 = 2;
        dVar.j(g0.M, 1, i3);
        char c2 = ' ';
        dVar.l(c2);
        dVar.b0(cVar, aBBREVIATED2);
        dVar.z(g0.K);
        dVar.L();
        dVar.l(c2);
        dVar.g(g0.H, 4);
        dVar.l(c2);
        dVar.g(h0.M, i3);
        char c = ':';
        dVar.l(c);
        dVar.g(h0.O, i3);
        dVar.X();
        dVar.l(c);
        dVar.g(h0.Q, i3);
        dVar.L();
        dVar.l(c2);
    }

    public static <T extends q<T>> c.d<T> N(Class<T> cls, Locale locale) {
        Objects.requireNonNull(cls, "Missing chronological type.");
        w wVar = w.y(cls);
        if (wVar == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Not formattable: ";
            cls = str2 + cls;
            throw new IllegalArgumentException(cls);
        } else {
            return new c.d(wVar, locale, null);
        }
    }

    private static <V> void O(q<?> qVar, net.time4j.engine.p<V> pVar, Object object) {
        qVar.G(pVar, pVar.getType().cast(object));
    }

    private static String P(int i, java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        if (length - i <= 10) {
            return charSequence.subSequence(i, length).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String charSequence3 = charSequence.subSequence(i, i + 10).toString();
        String str = "...";
        str2 = charSequence3 + str;
        return str2;
    }

    private static <T> void Q(q<?> qVar, net.time4j.engine.p<T> pVar, Object object) {
        qVar.G(pVar, pVar.getType().cast(object));
    }

    static /* synthetic */ w c(w wVar, w wVar2, net.time4j.engine.p pVar) {
        return c.j(wVar, wVar2, pVar);
    }

    static /* synthetic */ int d(w wVar, w wVar2, w wVar3) {
        return c.s(wVar, wVar2, wVar3);
    }

    static /* synthetic */ b e(c cVar) {
        return cVar.c;
    }

    static /* synthetic */ Object f(Object object) {
        c.h(object);
        return object;
    }

    private static <T> void g(c.d<T> dVar, String str, w wVar) {
        int i;
        char charAt;
        char charAt2;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        i = 0;
        i = 1;
        while (i < length) {
            char charAt3 = str.charAt(i);
            char c = '\'';
            if (charAt3 == c) {
                i = i + 1;
                charAt = 'Z';
            }
        }
        str = stringBuilder.toString();
        int i2 = c.c.a[wVar.ordinal()];
        if (c.c.a == i || c.c.a == 2 || c.c.a == 3 || c.c.a == 4) {
            if (!str.contains("h")) {
                if (str.contains("K") && !str.contains("a") && !str.contains("b")) {
                    if (!str.contains("B")) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str6 = "12-hour-clock requires am/pm-marker or dayperiod: ";
                        str = str6 + str;
                        throw new IllegalArgumentException(str);
                    }
                }
            }
            str3 = "L";
            str4 = "M";
            if (str.contains("Y")) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str7 = "Y as week-based-year requires a week-date-format: ";
                str = str7 + str;
                throw new IllegalArgumentException(str);
            }
            if (str.contains("D") && !str.contains(str4) && str.contains(str3)) {
                if (!str.contains("d")) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    String str8 = "D is the day of year but not the day of month: ";
                    str = str8 + str;
                    throw new IllegalArgumentException(str);
                }
            }
        }
        dVar.v(str, wVar);
    }

    private static <T> T i(q<?> qVar, T t, java.lang.CharSequence charSequence, s sVar) {
        Object t22;
        net.time4j.engine.i0 i0Var;
        int i3 = 24;
        boolean hasNext;
        Object item;
        boolean z4;
        net.time4j.f dAYS2;
        net.time4j.l0 l0Var;
        String str;
        Object obj;
        int i5;
        int i4;
        int i;
        final String str4 = "}.";
        final String str5 = "Conflict found: ";
        final int i6 = 256;
        i = 0;
        if (t instanceof f) {
            t22 = f.class.cast(t);
            tIMEZONE_ID2 = b0.TIMEZONE_ID;
            if (qVar.v(tIMEZONE_ID2) && qVar.v(b0.TIMEZONE_OFFSET) && !l.N(obj4).B(t22).equals(obj8)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str16 = "Ambivalent offset information: ";
                String str17 = " versus ";
                str8 = str16 + obj4 + str17 + obj8;
                sVar.k(charSequence.length(), str8);
                return null;
            }
            dAYLIGHT_SAVING2 = a0.DAYLIGHT_SAVING;
            if (qVar.v(dAYLIGHT_SAVING2)) {
                try {
                    boolean z6 = l.N(qVar.t()).I(t22);
                    StringBuilder stringBuilder = new StringBuilder(i6);
                    stringBuilder.append(str5);
                    str2 = "Parsed entity is ";
                    stringBuilder.append(str2);
                    if (!f.class) {
                        str2 = "not ";
                        stringBuilder.append(str2);
                    }
                    stringBuilder.append("daylight-saving, but timezone name");
                    stringBuilder.append(" has not the appropriate form in {");
                    stringBuilder.append(charSequence.toString());
                    stringBuilder.append("}.");
                    sVar.k(charSequence.length(), stringBuilder.toString());
                } catch (java.lang.IllegalArgumentException iae) {
                    t = new StringBuilder(r3);
                    t.append("Unable to check timezone name: ");
                    iae = iae.getMessage();
                    t.append(iae);
                    iae = charSequence.length();
                    t = t.toString();
                    sVar.k(iae, t);
                    return obj3;
                }
            }
        } else {
            if (t instanceof o) {
                t22 = t;
                z = t instanceof i0;
                if (t instanceof i0) {
                    if ((i0)i0.class.cast(t).s() == 0) {
                        i3 = 24;
                        if (iae.e(h0.N) != i3) {
                            net.time4j.u0 u0Var = h0.H;
                            if (iae.v(u0Var)) {
                                if ((h0)iae.p(h0.H).s() == i3) {
                                    long l = 1L;
                                    i0Var = (i0)i0.class.cast(t).h0().L(l, f.DAYS);
                                } else {
                                }
                            }
                        }
                    }
                }
                Iterator it = iae.A().iterator();
                while (it.hasNext()) {
                    item = it.next();
                    l0Var = h0.Q;
                    if (item != h0.Q) {
                    }
                }
            }
        }
        return i;
    }

    private static w<?> j(w<?> wVar, w<?> wVar2, net.time4j.engine.p<?> pVar) {
        w wVar3;
        boolean z;
        if (wVar.x(pVar)) {
            return wVar;
        }
        if (wVar2 == null) {
            wVar3 = wVar3.b();
            while (wVar3 != null) {
                if (wVar3.x(pVar)) {
                    return wVar3;
                }
                wVar3 = wVar3.b();
            }
        } else {
            if (pVar.isDateElement() && wVar2.x(pVar)) {
                return wVar2;
            }
            if (pVar.isTimeElement()) {
                if (h0.k0().x(pVar)) {
                    return h0.k0();
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Unsupported element: ";
        final String name = pVar.name();
        wVar2 = str + name;
        throw new IllegalArgumentException(wVar2);
    }

    private net.time4j.engine.o k(T t, net.time4j.engine.d dVar) {
        String dVar22;
        net.time4j.s sVar;
        if (this.b == null) {
            return this.a.e(t, dVar);
        }
        try {
            Class cls = this.b.h().l();
            Object obj = dVar.a(a.u, this.b.a());
            Object cast = b0.class.cast(t);
            Object obj3 = dVar.b(a.d);
            dVar22 = "";
            if (l.class.isAssignableFrom(cls)) {
                w wVar = this.b.h();
                c.h(wVar);
                sVar = cast.s0(wVar, (String)dVar.b(a.t), obj3, obj);
                return new c.f(sVar, dVar22, obj3, null);
            } else {
                if (m.class.isAssignableFrom(cls)) {
                    sVar = cast.t0(this.b.h(), obj3, obj);
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            String str2 = "Unexpected calendar override: ";
            r0 = str2 + cls;
            throw new IllegalStateException(r0);
        } catch (java.util.NoSuchElementException noSuchElement) {
            String illegalArgumentException = noSuchElement.getMessage();
            dVar = new IllegalArgumentException(illegalArgumentException, noSuchElement);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) dVar;
        } catch (java.lang.ClassCastException cce1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Not formattable: ";
            noSuchElement = str + noSuchElement;
            illegalArgumentException = new IllegalArgumentException(noSuchElement, cce1);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) illegalArgumentException;
        }
    }

    private String m(net.time4j.engine.o oVar) {
        final StringBuilder stringBuilder = new StringBuilder(this.d.size() * 8);
        try {
            K(oVar, stringBuilder, this.c, false);
        } catch (java.io.IOException ioException) {
            throw new IllegalStateException(ioException);
        }
        return stringBuilder.toString();
    }

    private List<i> n(List<i> list) {
        final ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((i)it.next().s(this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static int s(w<?> wVar, w<?> wVar2, w<?> wVar3) {
        int i = 0;
        w wVar4;
        if (wVar3 != null) {
            return -1;
        }
        i = 0;
        if (wVar.equals(wVar2)) {
            return 0;
        }
        wVar4 = wVar4.b();
        while (wVar4 != null) {
            i = i + 1;
            if (wVar.equals(wVar4)) {
                return i + 1;
            }
            wVar4 = wVar4.b();
        }
        return 0x7fffffff /* Unknown resource */;
    }

    private static String t(q<?> qVar) {
        int i = 1;
        char c = 61;
        Set set = qVar.A();
        final StringBuilder stringBuilder = new StringBuilder(set.size() * 16);
        stringBuilder.append(" [parsed={");
        Iterator it = set.iterator();
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            stringBuilder.append(item.name());
            c = '=';
            stringBuilder.append(c);
            stringBuilder.append(qVar.p(item));
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    private static String v(q<?> qVar) {
        String str;
        final l0 eRROR_MESSAGE2 = l0.ERROR_MESSAGE;
        if (qVar.v(eRROR_MESSAGE2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Validation failed => ";
            Object obj2 = qVar.p(l0.ERROR_MESSAGE);
            str = str2 + obj2;
            Object obj = null;
            qVar.G(l0.ERROR_MESSAGE, obj);
        } else {
            str = "Insufficient data:";
        }
        return str;
    }

    private boolean w() {
        boolean z;
        final int i = 0;
        if (z()) {
            net.time4j.g1.z.h hVar = (i)this.d.get(i).d();
            z3 = hVar instanceof f;
            if (hVar instanceof f) {
                z = (f)f.class.cast(hVar).b();
            } else {
                z2 = hVar instanceof z;
                if (!(hVar instanceof z)) {
                }
            }
        }
        return z;
    }

    private boolean x() {
        boolean z = false;
        int r0 = this.a.b() == null && this.b == null ? 1 : 0;
        return (this.a.b() == null && this.b == null ? 1 : 0);
    }

    private static boolean y(Object object, Object object2) {
        boolean equals = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
        } else {
            object = object.equals(object2);
        }
        return (object2 == null ? 1 : 0);
    }

    public T D(java.lang.CharSequence charSequence) throws ParseException {
        net.time4j.g1.z.s sVar = new s();
        Object obj = E(charSequence, sVar);
        if (obj == null) {
            throw new ParseException(sVar.d(), sVar.c());
        } else {
            int i = sVar.f();
            return obj;
        }
    }

    public T E(java.lang.CharSequence charSequence, s sVar) {
        if (this.n) {
            return c.F(this, this.a, this.a.o(), charSequence, sVar, this.c, this.k, false, true);
        }
        return b(charSequence, sVar, this.c);
    }

    public String I(T t) {
        return m(k(t, this.c));
    }

    public Set<g> J(T t, java.lang.Appendable appendable, net.time4j.engine.d dVar) {
        return K(k(t, dVar), appendable, dVar, true);
    }

    Set<g> K(net.time4j.engine.o oVar, java.lang.Appendable appendable, net.time4j.engine.d dVar, boolean z) throws IOException {
        LinkedHashSet linkedHashSet = null;
        Object peek;
        Throwable th2 = null;
        int i = 0;
        LinkedList linkedList;
        StringBuilder stringBuilder2;
        int i3;
        boolean empty2;
        java.lang.Appendable appendable22;
        int i4;
        net.time4j.engine.d dVar32;
        Set set;
        Object obj;
        boolean z2;
        boolean z3;
        Object item;
        Object item2;
        Object peek2;
        final Object oVar3 = this;
        final String oVar2 = oVar;
        final Object appendable23 = appendable;
        Objects.requireNonNull(appendable23, "Missing text result buffer.");
        final int size = oVar3.d.size();
        i = 0;
        int r13 = dVar == oVar3.c ? 1 : i;
        Throwable th = z ? new inkedHashSet(size) : 0;
        final String str5 = "Not formattable: ";
        if (oVar3.h) {
            i4 = size << 2;
            new LinkedList().push(new StringBuilder(i4));
            if (z) {
                LinkedList linkedList2 = new LinkedList();
                linkedList2.push(linkedHashSet);
            } else {
                i4 = 0;
            }
            while (i < size) {
                i = item2.b();
                while (oVar3.h > i) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append((CharSequence)linkedList.peek());
                    linkedList.push(stringBuilder6);
                    i = i - 1;
                }
                while (oVar3.h < i) {
                    linkedList.pop();
                    linkedList.push((StringBuilder)linkedList.pop());
                    i = i + 1;
                }
                linkedList.pop();
                linkedList.push((StringBuilder)linkedList.pop());
                i = i + 1;
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append((CharSequence)linkedList.peek());
                linkedList.push(stringBuilder6);
                i = i - 1;
                try {
                    i3 = item2.r(appendable25, (StringBuilder)linkedList.peek(), dVar32, obj, z9);
                } catch (net.time4j.engine.ChronoException chrono) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder = str4 + str3;
                    throw new IllegalArgumentException(stringBuilder, (z ? new inkedHashSet(size) : 0));
                }
                int i6 = 0;
                if (oVar3.h == i) {
                }
            }
            linkedList.clear();
            appendable23.append((StringBuilder)linkedList.peek());
            if (z) {
                peek = i4.peek();
                i4.clear();
            }
        } else {
            while (i < size) {
                try {
                    item.r(oVar, appendable, dVar, linkedHashSet, i);
                    i = item.u();
                } catch (net.time4j.engine.ChronoException chrono) {
                    stringBuilder = new StringBuilder();
                    stringBuilder = str4 + str3;
                    throw new IllegalArgumentException(stringBuilder, chrono);
                }
                i = 1;
                i = i + i;
            }
        }
        if (z) {
            return Collections.unmodifiableSet(peek);
        }
        return null;
    }

    c<T> R(Map<net.time4j.engine.p<?>, Object> map, b bVar) {
        final net.time4j.g1.z.b bVar3 = b.k(bVar, this.c);
        return new c(new c(this, map), bVar3, (d)bVar3.a(a.a, null));
    }

    public <A extends Enum<A>> c<T> S(c<A> cVar, A a) {
        final a.b bVar = new a.b();
        bVar.f(this.c.e());
        bVar.d(cVar, a);
        return new c(this, bVar.a());
    }

    public c<T> T(net.time4j.g1.g gVar) {
        return S(a.f, gVar);
    }

    public c<T> U(net.time4j.tz.l lVar) {
        Objects.requireNonNull(lVar, "Missing timezone id.");
        a.b bVar = new a.b();
        bVar.f(this.c.e());
        bVar.i(lVar.z());
        return new c(this, this.c.l(bVar.a()).m(a.e, lVar.E()));
    }

    public c<T> V(k kVar) {
        return U(l.N(kVar));
    }

    public <R> R a(T t, java.lang.Appendable appendable, net.time4j.engine.d dVar, net.time4j.engine.s<net.time4j.engine.o, R> sVar) {
        net.time4j.engine.o oVar = k(t, dVar);
        K(oVar, appendable, dVar, false);
        return sVar.apply(oVar);
    }

    public T b(java.lang.CharSequence charSequence, s sVar, net.time4j.engine.d dVar) {
        b0 b0Var;
        k kVar;
        net.time4j.g1.z.s sVar22;
        net.time4j.tz.g eARLIER_OFFSET2;
        boolean z2;
        net.time4j.g1.z.p pVar;
        Object obj;
        final Object charSequence4 = this;
        sVar22 = sVar;
        final net.time4j.g1.z.b dVar32 = dVar;
        if (dVar32 != charSequence4.c) {
            pVar = new p(dVar32, bVar);
            int i3 = 0;
        } else {
        }
        if (charSequence4.b != null) {
            boolean z = true;
            Object obj2 = c.F(this, eVar, charSequence4.b.i(), charSequence, sVar, pVar, obj, z, z2);
            int i = 0;
            if (sVar.i()) {
                return null;
            }
            q qVar = sVar.h();
            if (qVar.j()) {
                kVar = qVar.t();
            } else {
                c cVar2 = a.d;
                Object obj4 = pVar.c(cVar2) ? (k)obj4 : i;
            }
            if (a.d == null) {
            } else {
                Object obj5 = dVar32.a(a.u, charSequence4.b.a());
                a0 dAYLIGHT_SAVING2 = a0.DAYLIGHT_SAVING;
                if (qVar.v(dAYLIGHT_SAVING2)) {
                    net.time4j.tz.g r5 = (Boolean)qVar.p(a0.DAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET;
                    b0Var = obj2.a(l.N(a.d).Q(((Boolean)qVar.p(a0.DAYLIGHT_SAVING).booleanValue() ? g.EARLIER_OFFSET : g.LATER_OFFSET)), obj5);
                } else {
                    c cVar4 = a.e;
                    if (pVar.c(cVar4)) {
                        b0Var = obj2.a(l.N(kVar).Q((o)pVar.b(a.e)), obj5);
                    } else {
                        b0Var = obj2.a(l.N(kVar), obj5);
                    }
                }
            }
            if (charSequence4.b == null) {
                sVar22.k(charSequence.length(), "Missing timezone or offset.");
                return i;
            }
            qVar.G(b0.V().E(), b0Var);
            c.h(b0Var);
            if (obj.isStrict()) {
                c.i(qVar, b0Var, charSequence, sVar22);
            }
            return b0Var;
        }
        return c.G(this, charSequence4.a, 0, charSequence, sVar, pVar, obj, z2);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        w wVar;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof c) {
            if (this.a.equals(object.a)) {
                if (c.y(this.b, object.b)) {
                    if (this.c.equals(object.c)) {
                        if (this.e.equals(object.e)) {
                            if (!(this.d.equals(object.d))) {
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 7) + (this.c.hashCode() * 31) + (this.d.hashCode() * 37);
    }

    public String l(T t) {
        return I(t);
    }

    public net.time4j.engine.d o() {
        return this.c;
    }

    b p() {
        return this.c;
    }

    public w<T> q() {
        return this.a;
    }

    Map<net.time4j.engine.p<?>, Object> r() {
        return this.e;
    }

    @Override // java.lang.Object
    public String toString() {
        int i = 1;
        char c = 124;
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
        i = 1;
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            stringBuilder.append((i)it.next());
        }
        stringBuilder.append("}]");
        return stringBuilder.toString();
    }

    public Locale u() {
        return this.c.h();
    }

    boolean z() {
        int i;
        boolean z2 = false;
        if (this.p != 1 || this.g) {
            int i3 = 0;
        }
        return z2;
    }

    /* synthetic */ c(c cVar, b bVar, c.a aVar) {
        this(cVar, bVar);
    }

    private c(w<T> wVar, w<?> wVar2, Locale locale, List<i> list, Map<net.time4j.engine.p<?>, Object> map, net.time4j.g1.a aVar, w<?> wVar3) {
        int wVar72;
        boolean z;
        int i = 0;
        w wVar22;
        super();
        Objects.requireNonNull(wVar, "Missing chronology.");
        if (list.isEmpty()) {
            throw new IllegalStateException("No format processors defined.");
        } else {
            this.a = wVar;
            this.b = c.e.j(wVar2);
            this.o = wVar3;
            wVar3 = wVar2 == null ? wVar : wVar2;
            net.time4j.g1.z.b bVar2 = b.d((wVar2 == null ? wVar : wVar2), aVar, locale);
            this.c = bVar2;
            this.k = (g)bVar2.a(a.f, (wVar2 == null ? wVar : wVar2));
            this.e = Collections.unmodifiableMap(map);
            i = 0;
            final Iterator it = list.iterator();
            wVar72 = 1;
            wVar3 = 0;
            while (it.hasNext()) {
                Object item = it.next();
                net.time4j.engine.p element = item.d().getElement();
            }
            this.f = i;
            this.g = wVar72;
            this.h = wVar72;
            this.i = wVar72;
            this.j = wVar72;
            this.l = wVar72;
            this.m = (Boolean)this.c.a(a.r, Boolean.FALSE).booleanValue();
            this.n = x();
            this.p = list.size();
            this.d = n(list);
            this.q = w();
            return;
        }
    }

    private c(c<T> cVar, net.time4j.g1.a aVar) {
        this(cVar, cVar.c.l(aVar), null);
    }

    private c(c<T> cVar, b bVar) {
        this(cVar, bVar, null);
    }

    private c(c<T> cVar, b bVar, net.time4j.history.d dVar) {
        int i = 1;
        boolean z;
        net.time4j.engine.p pVar = null;
        w wVar;
        net.time4j.d0 d0Var;
        net.time4j.l0 l0Var;
        f0 f0Var;
        boolean contains;
        super();
        Objects.requireNonNull(bVar, "Missing global format attributes.");
        this.a = cVar.a;
        this.b = cVar.b;
        this.o = cVar.o;
        this.c = bVar;
        this.k = (g)bVar.a(a.f, g.SMART);
        this.e = Collections.unmodifiableMap(new q(cVar.e));
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        i = 0;
        if (cVar.i || dVar != null) {
            i = 1;
        }
        this.i = i;
        this.j = cVar.j;
        final ArrayList arrayList = new ArrayList(cVar.d);
        while (i < cVar.d.size()) {
            Object item = arrayList.get(i);
            net.time4j.engine.p element = item.d().getElement();
            i = i + 1;
        }
        this.l = z;
        this.m = (Boolean)this.c.a(a.r, Boolean.FALSE).booleanValue();
        this.n = x();
        this.p = arrayList.size();
        this.d = n(arrayList);
        this.q = w();
    }

    private c(c<T> cVar, Map<net.time4j.engine.p<?>, Object> map) {
        w wVar = null;
        boolean z = true;
        w item2;
        super();
        if (cVar.b == null) {
            int i2 = 0;
        } else {
            wVar = cVar.b.h();
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            c.j(cVar.a, wVar, (p)it.next());
        }
        this.a = cVar.a;
        this.b = cVar.b;
        this.o = cVar.o;
        this.c = cVar.c;
        this.k = cVar.k;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
        this.j = cVar.j;
        this.m = cVar.m;
        HashMap hashMap = new HashMap(cVar.e);
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            item2 = it2.next();
            Object value = map.get(item2);
        }
        this.e = Collections.unmodifiableMap(hashMap);
        this.l = z;
        this.n = x();
        this.p = cVar.p;
        this.d = n(cVar.d);
        this.q = w();
    }

    private static <T> T h(Object object) {
        return object;
    }
}
