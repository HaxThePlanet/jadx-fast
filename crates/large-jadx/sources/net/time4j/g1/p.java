package net.time4j.g1;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.time4j.f1.d;

/* loaded from: classes3.dex */
public abstract class p {

    private static final net.time4j.g1.p a;
    private static final net.time4j.g1.p b;
    private static final net.time4j.g1.p c;
    private static final net.time4j.g1.p d;
    private static final Map<String, net.time4j.g1.p> e;
    private static final Map<String, net.time4j.g1.p> f;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            p.a.a = iArr;
            iArr[k.CARDINALS.ordinal()] = 1;
            p.a.a[k.ORDINALS.ordinal()] = 2;
        }
    }

    private static class d {

        private static final net.time4j.g1.o a;
        static {
            Object bVar;
            Iterator iterator = d.c().g(o.class).iterator();
            final int i = 0;
            if (iterator.hasNext()) {
                bVar = iterator.next();
            } else {
                bVar = i;
            }
            if (bVar == null) {
                bVar = new p.b(i);
            }
            p.d.a = bVar;
        }

        static net.time4j.g1.o a() {
            return p.d.a;
        }
    }

    private static class b implements net.time4j.g1.o {
        b(net.time4j.g1.p.a p$a) {
            super();
        }

        @Override // net.time4j.g1.o
        public net.time4j.g1.p a(Locale locale, net.time4j.g1.k k2) {
            net.time4j.g1.p obj3;
            obj3 = locale.getLanguage().equals("en");
            int i = p.a.a[k2.ordinal()];
            if (i != 1) {
                if (i != 2) {
                } else {
                    if (obj3 != null) {
                        obj3 = p.c();
                    } else {
                        obj3 = p.d();
                    }
                    return obj3;
                }
                obj3 = new UnsupportedOperationException(k2.name());
                throw obj3;
            }
            if (obj3 != null) {
                obj3 = p.a();
            } else {
                obj3 = p.b();
            }
            return obj3;
        }
    }

    private static class c extends net.time4j.g1.p {

        private final net.time4j.g1.k g;
        private final boolean h;
        private c(net.time4j.g1.k k, boolean z2) {
            super();
            this.g = k;
            this.h = z2;
        }

        c(net.time4j.g1.k k, boolean z2, net.time4j.g1.p.a p$a3) {
            super(k, z2);
        }

        @Override // net.time4j.g1.p
        public net.time4j.g1.n e(long l) {
            boolean cmp;
            int cmp2;
            int cmp3;
            int i2;
            int i;
            net.time4j.g1.n obj7;
            int i3 = p.a.a[this.g.ordinal()];
            i2 = 1;
            if (i3 != 1) {
                if (i3 != 2) {
                } else {
                    int i5 = l % i4;
                    l %= i;
                    if (this.h && Long.compare(i5, i2) == 0 && Long.compare(obj7, i10) != 0) {
                        i5 = l % i4;
                        l %= i;
                        if (Long.compare(i5, i2) == 0) {
                            if (Long.compare(obj7, i10) != 0) {
                                return n.ONE;
                            }
                        }
                        if (Long.compare(i5, i8) == 0 && Long.compare(obj7, i9) != 0) {
                            if (Long.compare(obj7, i9) != 0) {
                                return n.TWO;
                            }
                        }
                        if (Long.compare(i5, i2) == 0 && Long.compare(obj7, cmp) != 0) {
                            if (Long.compare(obj7, cmp) != 0) {
                                return n.FEW;
                            }
                        }
                    }
                    return n.OTHER;
                }
                obj7 = new UnsupportedOperationException(this.g.name());
                throw obj7;
            }
            obj7 = Long.compare(l, i2) == 0 ? n.ONE : n.OTHER;
            return obj7;
        }
    }
    static {
        net.time4j.g1.k cARDINALS = k.CARDINALS;
        final int i = 1;
        final int i2 = 0;
        p.c cVar = new p.c(cARDINALS, i, i2);
        p.a = cVar;
        final int i3 = 0;
        p.c cVar2 = new p.c(cARDINALS, i3, i2);
        p.b = cVar2;
        net.time4j.g1.k oRDINALS = k.ORDINALS;
        p.c cVar3 = new p.c(oRDINALS, i, i2);
        p.c = cVar3;
        p.c cVar4 = new p.c(oRDINALS, i3, i2);
        p.d = cVar4;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        p.e = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        p.f = concurrentHashMap2;
    }

    static net.time4j.g1.p a() {
        return p.a;
    }

    static net.time4j.g1.p b() {
        return p.b;
    }

    static net.time4j.g1.p c() {
        return p.c;
    }

    static net.time4j.g1.p d() {
        return p.d;
    }

    private static Map<String, net.time4j.g1.p> f(net.time4j.g1.k k) {
        int i = p.a.a[k.ordinal()];
        if (i != 1) {
            if (i != 2) {
            } else {
                return p.f;
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(k.name());
            throw unsupportedOperationException;
        }
        return p.e;
    }

    public static net.time4j.g1.p g(Locale locale, net.time4j.g1.k k2) {
        Object map;
        boolean language;
        int i;
        String str;
        map = p.f(k2);
        i = 0;
        if (!map.isEmpty() && !locale.getCountry().equals("")) {
            if (!locale.getCountry().equals("")) {
                i = language;
            }
            if (i == 0) {
                i = map;
            }
        }
        if (i == 0) {
            i = p.d.a().a(locale, k2);
        }
        return i;
    }

    private static String h(Locale locale) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage());
        stringBuilder.append('_');
        stringBuilder.append(locale.getCountry());
        return stringBuilder.toString();
    }

    public abstract net.time4j.g1.n e(long l);
}
