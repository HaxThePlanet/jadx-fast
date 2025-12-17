package net.time4j.g1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.d0;
import net.time4j.engine.w;
import net.time4j.i1.f;
import net.time4j.tz.k;
import net.time4j.tz.o;

/* loaded from: classes3.dex */
public final class a implements d {

    public static final c<String> b;
    public static final c<Locale> c;
    public static final c<k> d;
    public static final c<o> e;
    public static final c<net.time4j.g1.g> f;
    public static final c<net.time4j.g1.v> g;
    public static final c<net.time4j.g1.m> h;
    public static final c<Boolean> i;
    public static final c<Boolean> j;
    public static final c<Boolean> k;
    public static final c<net.time4j.g1.j> l;
    public static final c<Character> m;
    public static final c<Boolean> n;
    public static final c<Character> o;
    public static final c<Character> p;
    public static final c<Integer> q;
    public static final c<Boolean> r;
    public static final c<Integer> s;
    public static final c<String> t;
    public static final c<d0> u;
    public static final c<Boolean> v;
    public static final c<f> w;
    public static final c<String> x;
    private static final net.time4j.g1.a y;
    private final Map<String, Object> a;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            a.a.a = iArr;
            iArr[g.STRICT.ordinal()] = 1;
            a.a.a[g.SMART.ordinal()] = 2;
            a.a.a[g.LAX.ordinal()] = 3;
        }
    }

    public static final class b {

        private final Map<String, Object> a;
        public b() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
        }

        public b(w<?> w) {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            g(a.b, b.a(w));
        }

        private <A> void g(c<A> c, A a2) {
            if (a2 == null) {
            } else {
                this.a.put(c.name(), a2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing attribute value for key: ");
            stringBuilder.append(c);
            NullPointerException obj4 = new NullPointerException(stringBuilder.toString());
            throw obj4;
        }

        public net.time4j.g1.a a() {
            a aVar = new a(this.a, 0);
            return aVar;
        }

        public net.time4j.g1.a.b b(c<Character> c, char c2) {
            this.a.put(c.name(), Character.valueOf(c2));
            return this;
        }

        public net.time4j.g1.a.b c(c<Integer> c, int i2) {
            c cVar;
            if (c == a.q) {
                if (i2 < 100) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Pivot year in far past not supported: ");
                stringBuilder.append(i2);
                IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
                throw obj3;
            }
            this.a.put(c.name(), Integer.valueOf(i2));
            return this;
        }

        public <A extends Enum<A>> net.time4j.g1.a.b d(c<A> c, A a2) {
            int i;
            int i3;
            int i2;
            c obj4;
            Object obj5;
            if (a2 == null) {
            } else {
                if (!a2 instanceof Enum) {
                } else {
                    this.a.put(c.name(), a2);
                    i3 = 0;
                    if (c == a.f) {
                        obj4 = a.a.a[(g)g.class.cast(a2).ordinal()];
                        i = 1;
                        if (obj4 != i) {
                            if (obj4 != 2) {
                                if (obj4 != 3) {
                                } else {
                                    e(a.i, i);
                                    e(a.j, i);
                                    e(a.r, i);
                                    e(a.k, i);
                                }
                                obj4 = new UnsupportedOperationException(a2.name());
                                throw obj4;
                            }
                            e(a.i, i);
                            e(a.j, i3);
                            e(a.r, i3);
                            e(a.k, i);
                        } else {
                            e(a.i, i3);
                            e(a.j, i3);
                            e(a.r, i3);
                            e(a.k, i3);
                        }
                    } else {
                        obj4 = j.class.cast(a2);
                        if (c == a.l && (j)obj4.isDecimal()) {
                            obj4 = j.class.cast(a2);
                            if ((j)obj4.isDecimal()) {
                                b(a.m, obj4.getDigits().charAt(i3));
                            }
                        }
                    }
                    return this;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Enum expected, but found: ");
                stringBuilder.append(a2);
                obj4 = new ClassCastException(stringBuilder.toString());
                throw obj4;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing attribute value for key: ");
            stringBuilder2.append(c);
            obj5 = new NullPointerException(stringBuilder2.toString());
            throw obj5;
        }

        public net.time4j.g1.a.b e(c<Boolean> c, boolean z2) {
            this.a.put(c.name(), Boolean.valueOf(z2));
            return this;
        }

        public net.time4j.g1.a.b f(net.time4j.g1.a a) {
            this.a.putAll(a.d(a));
            return this;
        }

        public net.time4j.g1.a.b h(Locale locale) {
            g(a.c, locale);
            return this;
        }

        public net.time4j.g1.a.b i(k k) {
            g(a.d, k);
            return this;
        }
    }
    static {
        Class<Integer> obj = Integer.class;
        Class<Character> obj4 = Character.class;
        final Class<String> obj5 = String.class;
        final Class<Boolean> obj6 = Boolean.class;
        a.b = q.b("CALENDAR_TYPE", obj5);
        a.c = q.b("LANGUAGE", Locale.class);
        a.d = q.b("TIMEZONE_ID", k.class);
        a.e = q.b("TRANSITION_STRATEGY", o.class);
        a.f = q.b("LENIENCY", g.class);
        a.g = q.b("TEXT_WIDTH", v.class);
        a.h = q.b("OUTPUT_CONTEXT", m.class);
        a.i = q.b("PARSE_CASE_INSENSITIVE", obj6);
        a.j = q.b("PARSE_PARTIAL_COMPARE", obj6);
        a.k = q.b("PARSE_MULTIPLE_CONTEXT", obj6);
        a.l = q.b("NUMBER_SYSTEM", j.class);
        a.m = q.b("ZERO_DIGIT", obj4);
        a.n = q.b("NO_GMT_PREFIX", obj6);
        a.o = q.b("DECIMAL_SEPARATOR", obj4);
        a.p = q.b("PAD_CHAR", obj4);
        a.q = q.b("PIVOT_YEAR", obj);
        a.r = q.b("TRAILING_CHARACTERS", obj6);
        a.s = q.b("PROTECTED_CHARACTERS", obj);
        a.t = q.b("CALENDAR_VARIANT", obj5);
        a.u = q.b("START_OF_DAY", d0.class);
        a.v = q.b("FOUR_DIGIT_YEAR", obj6);
        a.w = q.b("TIME_SCALE", f.class);
        a.x = q.b("FORMAT_PATTERN", obj5);
        a aVar = new a();
        a.y = aVar;
    }

    private a() {
        super();
        this.a = Collections.emptyMap();
    }

    private a(Map<String, Object> map) {
        super();
        HashMap hashMap = new HashMap(map);
        this.a = Collections.unmodifiableMap(hashMap);
    }

    a(Map map, net.time4j.g1.a.a a$a2) {
        super(map);
    }

    static Map d(net.time4j.g1.a a) {
        return a.a;
    }

    public static <A> c<A> e(String string, Class<A> class2) {
        return q.b(string, class2);
    }

    public static net.time4j.g1.a f() {
        return a.y;
    }

    public <A> A a(c<A> c, A a2) {
        Object obj = this.a.get(c.name());
        if (obj == null) {
            return a2;
        }
        return c.a().cast(obj);
    }

    public <A> A b(c<A> c) {
        Object obj = this.a.get(c.name());
        if (obj == null) {
        } else {
            return c.a().cast(obj);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException(c.name());
        throw noSuchElementException;
    }

    public boolean c(c<?> c) {
        return this.a.containsKey(c.name());
    }

    @Override // net.time4j.engine.d
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof a) {
            return this.a.equals(object.a);
        }
        return 0;
    }

    @Override // net.time4j.engine.d
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // net.time4j.engine.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(size *= 32);
        stringBuilder.append(a.class.getName());
        stringBuilder.append('[');
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
