package net.time4j.g1;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.time4j.f1.d;

/* compiled from: PluralRules.java */
/* loaded from: classes3.dex */
public abstract class p {

    private static final p a = new p$c();
    private static final p b = new p$c();
    private static final p c = new p$c();
    private static final p d = new p$c();
    private static final Map<String, p> e = new ConcurrentHashMap<>();
    private static final Map<String, p> f = new ConcurrentHashMap<>();

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[k.values().length];
            p.a.a = iArr;
            try {
                iArr[k.CARDINALS.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                p.a.a[k.ORDINALS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class d {

        private static final o a = new p$b(0);
        static {
            Object item;
            Iterator it = d.c().g(o.class).iterator();
            item = it.hasNext() ? (o)item : 0;
        }

        static /* synthetic */ o a() {
            return p.d.a;
        }
    }

    private static class b implements o {
        private b() {
            super();
        }

        public p a(Locale locale, k kVar) {
            net.time4j.g1.p pVar;
            net.time4j.g1.p pVar2;
            boolean equals = locale.getLanguage().equals("en");
            int i = p.a.a[kVar.ordinal()];
            if (p.a.a != 1) {
                if (p.a.a != 2) {
                    throw new UnsupportedOperationException(kVar.name());
                } else {
                    if (equals) {
                        pVar2 = p.c;
                    } else {
                        pVar2 = p.d;
                    }
                    return pVar2;
                }
            }
            if (equals) {
                pVar = p.a;
            } else {
                pVar = p.b;
            }
            return pVar;
        }

        /* synthetic */ b(p.a aVar) {
            this();
        }
    }

    private static class c extends p {

        private final k g;
        private final boolean h;
        /* synthetic */ c(k kVar, boolean z, p.a aVar) {
            this(kVar, z);
        }

        @Override // net.time4j.g1.p
        public n e(long j) {
            net.time4j.g1.n oNE2;
            int i = p.a.a[this.g.ordinal()];
            long l = 1L;
            if (p.a.a != 1) {
                if (p.a.a != 2) {
                    throw new UnsupportedOperationException(this.g.name());
                } else {
                    if (this.h) {
                        long l4 = j % 10L;
                        long l2 = 100L;
                        l3 = j % l2;
                        if (p.a.a == l) {
                            if (l3 != 11) {
                                return n.ONE;
                            }
                        }
                        if (p.a.a == 2) {
                            if (n.ONE != 12) {
                                return n.TWO;
                            }
                        }
                        l = 3L;
                        if (p.a.a == l) {
                            long l5 = 13L;
                            if (n.TWO != l5) {
                                return n.FEW;
                            }
                        }
                    }
                    return n.OTHER;
                }
            }
            j = n.FEW == l ? n.ONE : n.OTHER;
            return (n.FEW == l ? n.ONE : n.OTHER);
        }

        private c(k kVar, boolean z) {
            super();
            this.g = kVar;
            this.h = z;
        }
    }
    static {
    }

    static /* synthetic */ p a() {
        return p.a;
    }

    static /* synthetic */ p b() {
        return p.b;
    }

    static /* synthetic */ p c() {
        return p.c;
    }

    static /* synthetic */ p d() {
        return p.d;
    }

    private static Map<String, p> f(k kVar) {
        int i = p.a.a[kVar.ordinal()];
        if (p.a.a != 1 && p.a.a == 2) {
            return p.f;
        }
        return p.e;
    }

    public static p g(Locale locale, k kVar) {
        Map map;
        boolean equals;
        int i = 0;
        map = p.f(kVar);
        i = 0;
        if (!map.isEmpty()) {
            str = "";
            if (!locale.getCountry().equals(str)) {
            }
            if (i == 0) {
            }
        }
        if (i == 0) {
            net.time4j.g1.p pVar = p.d.a.a(locale, kVar);
        }
        return i;
    }

    private static String h(Locale locale) {
        final StringBuilder stringBuilder = new StringBuilder();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        str = language + 95 + country;
        return str;
    }

    public abstract n e(long j);
}
