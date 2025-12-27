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

/* compiled from: Attributes.java */
/* loaded from: classes3.dex */
public final class a implements d {

    public static final c<String> b;
    public static final c<Locale> c;
    public static final c<k> d;
    public static final c<o> e;
    public static final c<g> f;
    public static final c<v> g;
    public static final c<m> h;
    public static final c<Boolean> i;
    public static final c<Boolean> j;
    public static final c<Boolean> k;
    public static final c<j> l;
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
    private static final a y = new a();
    private final Map<String, Object> a;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[g.values().length];
            a.a.a = iArr;
            try {
                iArr[g.STRICT.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[g.SMART.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                a.a.a[g.LAX.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public static final class b {

        private final Map<String, Object> a = new HashMap<>();
        public b() {
            super();
            final HashMap hashMap = new HashMap();
        }

        private <A> void g(c<A> cVar, A a) {
            if (a == null) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Missing attribute value for key: ";
                cVar = str + cVar;
                throw new NullPointerException(cVar);
            } else {
                this.a.put(cVar.name(), a);
                return;
            }
        }

        public a a() {
            return new a(this.a, null);
        }

        public a.b b(c<Character> cVar, char c) {
            this.a.put(cVar.name(), Character.valueOf(c));
            return this;
        }

        public a.b c(c<Integer> cVar, int i) {
            this.a.put(cVar.name(), Integer.valueOf(i));
            return this;
        }

        public <A extends Enum<A>> a.b d(c<A> cVar, A a) {
            if (a == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str2 = "Missing attribute value for key: ";
                cVar = str2 + cVar;
                throw new NullPointerException(cVar);
            } else {
                if (!(a instanceof Enum)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Enum expected, but found: ";
                    a = str + a;
                    throw new ClassCastException(a);
                } else {
                    this.a.put(cVar.name(), a);
                    boolean z = false;
                    if (cVar == a.f) {
                        int i4 = a.a.a[(g)g.class.cast(a).ordinal()];
                        int i = 1;
                        if (a.a.a != i) {
                            int i2 = 2;
                            if (a.a.a != 2) {
                                if (a.a.a != 3) {
                                    throw new UnsupportedOperationException(a.name());
                                } else {
                                    e(a.i, true);
                                    e(a.j, true);
                                    e(a.r, true);
                                    e(a.k, true);
                                }
                            }
                            e(a.i, true);
                            e(a.j, z);
                            e(a.r, z);
                            e(a.k, true);
                        } else {
                            e(a.i, z);
                            e(a.j, z);
                            e(a.r, z);
                            e(a.k, z);
                        }
                    } else {
                        if (a.r == a.l) {
                            Object cast2 = j.class.cast(a);
                            if (cast2.isDecimal()) {
                                b(a.m, cast2.getDigits().charAt(z));
                            }
                        }
                    }
                    return this;
                }
            }
        }

        public a.b e(c<Boolean> cVar, boolean z) {
            this.a.put(cVar.name(), Boolean.valueOf(z));
            return this;
        }

        public a.b f(a aVar) {
            this.a.putAll(aVar.a);
            return this;
        }

        public a.b h(Locale locale) {
            g(a.c, locale);
            return this;
        }

        public a.b i(k kVar) {
            g(a.d, kVar);
            return this;
        }

        public b(w<?> wVar) {
            super();
            HashMap hashMap = new HashMap();
            g(a.b, b.a(wVar));
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
    }

    /* synthetic */ a(Map map, a.a aVar) {
        this(map);
    }

    static /* synthetic */ Map d(a aVar) {
        return aVar.a;
    }

    public static <A> c<A> e(String str, Class<A> cls) {
        return q.b(str, cls);
    }

    public static a f() {
        return a.y;
    }

    public <A> A a(c<A> cVar, A a) {
        Object value = this.a.get(cVar.name());
        if (value == null) {
            return a;
        }
        return cVar.a().cast(value);
    }

    public <A> A b(c<A> cVar) {
        Object value = this.a.get(cVar.name());
        if (value == null) {
            throw new NoSuchElementException(cVar.name());
        } else {
            return cVar.a().cast(value);
        }
    }

    public boolean c(c<?> cVar) {
        return this.a.containsKey(cVar.name());
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof a) {
            return this.a.equals(object.a);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        int i = this.a.size() * 32;
        StringBuilder stringBuilder = new StringBuilder(i);
        String name = a.class.getName();
        str = i + name + 91 + this.a + 93;
        return str;
    }

    private a() {
        super();
        this.a = Collections.emptyMap();
    }

    private a(Map<String, Object> map) {
        super();
        this.a = Collections.unmodifiableMap(new HashMap(map));
    }
}
