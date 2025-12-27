package net.time4j.g1.z;

import android.app.ActivityManager.MemoryInfo;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.engine.p;
import net.time4j.engine.r;
import net.time4j.engine.w;
import net.time4j.engine.z;
import net.time4j.g0;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;
import net.time4j.h0;
import net.time4j.history.d;
import net.time4j.z0;

/* compiled from: PatternType.java */
/* loaded from: classes3.dex */
public enum w {

    CLDR,
    CLDR_24,
    CLDR_DATE,
    DYNAMIC,
    SIMPLE_DATE_FORMAT;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[w.values().length];
            w.a.a = iArr;
            try {
                iArr[w.CLDR.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                w.a.a[w.SIMPLE_DATE_FORMAT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                w.a.a[w.CLDR_24.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                w.a.a[w.CLDR_DATE.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                w.a.a[w.DYNAMIC.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    private static void addEnumElementAsInteger(c.d<?> dVar, p<? extends Enum> pVar, int i) {
        dVar.u(pVar, i, 9);
    }

    private static void addEnumElementAsText(c.d<?> dVar, p<? extends Enum> pVar) {
        dVar.z(pVar);
    }

    private static void addMonth(c.d<?> dVar, int i) {
        i = 1;
        int i6 = 2;
        if (i != i) {
            if (i != i6) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str = "Too many pattern letters for month: ";
                            i = str + i;
                            throw new IllegalArgumentException(i);
                        } else {
                            dVar.b0(a.g, v.NARROW);
                            dVar.z(g0.K);
                            dVar.L();
                        }
                    }
                    dVar.b0(a.g, v.WIDE);
                    dVar.z(g0.K);
                    dVar.L();
                } else {
                    dVar.b0(a.g, v.ABBREVIATED);
                    dVar.z(g0.K);
                    dVar.L();
                }
            } else {
                dVar.g(g0.L, i6);
            }
        } else {
            dVar.j(g0.L, i, i6);
        }
    }

    private static void addNumber(p<Integer> pVar, char c, c.d<?> dVar, int i, boolean z) {
        i = 2;
        final int i2 = 1;
        if (i != i2) {
            if (i != i) {
                if (!z) {
                    final StringBuilder stringBuilder = new StringBuilder();
                    final String str2 = "Too many pattern letters (";
                    String str = "): ";
                    c = str2 + c + str + i;
                    throw new IllegalArgumentException(c);
                }
            }
            dVar.g(pVar, i);
        } else {
            dVar.j(pVar, i2, i);
        }
    }

    private static void addOffset(c.d<?> dVar, char c, int i, boolean z) {
        String str;
        z = false;
        final int i4 = 1;
        str = "Z";
        if (i != i4) {
            i = 2;
            str = "+0000";
            if (i != 2) {
                i = 3;
                str = "+00:00";
                if (i != 3) {
                    i = 4;
                    if (i != 4) {
                        if (i != 5) {
                            final StringBuilder stringBuilder = new StringBuilder();
                            String str2 = "Too many pattern letters (";
                            String str3 = "): ";
                            c = str2 + c + str3 + i;
                            throw new IllegalArgumentException(c);
                        } else {
                            if (!(z)) {
                            }
                            dVar.C(e.LONG, true, Collections.singletonList(str));
                        }
                    }
                    if (!(z)) {
                    }
                    dVar.C(e.LONG, z, Collections.singletonList(str));
                } else {
                    if (!(z)) {
                    }
                    dVar.C(e.MEDIUM, true, Collections.singletonList(str));
                }
            } else {
                if (!(z)) {
                }
                dVar.C(e.MEDIUM, z, Collections.singletonList(str));
            }
        } else {
            if (!(z)) {
                str = "+00";
            }
            dVar.C(e.SHORT, z, Collections.singletonList(str));
        }
    }

    private static void addQuarterOfYear(c.d<?> dVar, int i) {
        i = 1;
        if (i == 1 || i == 2) {
            dVar.h(g0.J, i);
        } else {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        final String str = "Too many pattern letters for quarter-of-year: ";
                        i = str + i;
                        throw new IllegalArgumentException(i);
                    } else {
                        dVar.b0(a.g, v.NARROW);
                        dVar.z(g0.J);
                        dVar.L();
                    }
                }
                dVar.b0(a.g, v.WIDE);
                dVar.z(g0.J);
                dVar.L();
            } else {
                dVar.b0(a.g, v.ABBREVIATED);
                dVar.z(g0.J);
                dVar.L();
            }
        }
    }

    private Map<p<?>, p<?>> cldr(c.d<?> dVar, Locale locale, char c, int i) {
        final w effectiveChronology = w.getEffectiveChronology(dVar);
        if (w.isGeneralSymbol(c) && !w.isISO(effectiveChronology)) {
            return this.general(dVar, effectiveChronology, c, i, locale);
        }
        c = 'h';
        if (c == 'h') {
            str = "ethiopic";
            if (w.getCalendarType(effectiveChronology).equals(str) && ethiopianHour != null) {
                w.addNumber(ethiopianHour, c, dVar, i, false);
                return Collections.emptyMap();
            }
        }
        return this.cldrISO(dVar, effectiveChronology, locale, c, i, false);
    }

    private Map<p<?>, p<?>> cldr24(c.d<?> dVar, Locale locale, char c, int i) {
        if (c == 72) {
            w.addNumber(h0.N, c, dVar, i, false);
            return Collections.emptyMap();
        }
        return cldr(dVar, locale, c, i);
    }

    private Map<p<?>, p<?>> cldrISO(c.d<?> dVar, w<?> wVar, Locale locale, char c, int i, boolean z) {
        net.time4j.d0 d0Var;
        v wIDE2;
        v periodWidth;
        v wIDE22;
        net.time4j.g1.z.c.d dVar2;
        net.time4j.c cVar;
        w wVar22 = null;
        Locale locale32;
        boolean hasNext;
        int i2 = 2;
        int i52;
        boolean z62;
        dVar2 = dVar;
        c42 = c;
        i52 = i;
        z62 = z;
        int i4 = 5;
        z = false;
        i = 3;
        i2 = 2;
        i52 = 4;
        final boolean z2 = true;
        switch (c42) {
            case 65:
                dVar.j(h0.V, i, 8);
                break;
            case 66:
                dVar.b0(a.g, w.getPeriodWidth(i));
                dVar.e();
                dVar.L();
                break;
            case 67:
                StringBuilder stringBuilder11 = new StringBuilder();
                String str17 = "Unsupported pattern symbol: ";
                r1 = str17 + c;
                throw new IllegalArgumentException(str17 + c);
            case 68:
                dVar.j(g0.O, i, i);
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "Too many pattern letters (D): ";
                r1 = str5 + i;
                throw new IllegalArgumentException(str5 + i);
                break;
            case 69:
                wIDE22 = v.ABBREVIATED;
                wIDE22 = v.NARROW;
                wIDE22 = v.SHORT;
                StringBuilder stringBuilder10 = new StringBuilder();
                String str16 = "Too many pattern letters (E): ";
                r1 = str16 + i;
                throw new IllegalArgumentException(str16 + i);
                break;
            case 70:
                StringBuilder stringBuilder6 = new StringBuilder();
                String str12 = "Too many pattern letters (F): ";
                r1 = str12 + i;
                throw new IllegalArgumentException(str12 + i);
                break;
            case 71:
                wIDE2 = v.ABBREVIATED;
                wIDE2 = v.NARROW;
                StringBuilder stringBuilder4 = new StringBuilder();
                String str10 = "Too many pattern letters (G): ";
                r1 = str10 + i;
                throw new IllegalArgumentException(str10 + i);
            case 72:
                w.addNumber(h0.M, c, dVar, i, z62);
                break;
            case 73:
                w.addNumber(h0.L, c, dVar, i, z62);
                break;
            case 74:
                dVar.b0(a.h, m.STANDALONE);
                w.addMonth(dVar, Math.min(i, i52));
                dVar.L();
                break;
            case 75:
                w.addMonth(dVar, Math.min(i, i52));
                break;
            case 76:
                dVar.x();
                dVar.p();
                StringBuilder stringBuilder5 = new StringBuilder();
                String str11 = "Count of pattern letters is not 1 or 4: ";
                r1 = str11 + i;
                throw new IllegalArgumentException(str11 + i);
            case 77:
                w.addQuarterOfYear(dVar, i);
                break;
            case 78:
                dVar.i(h0.U, i, i, z);
                break;
            case 79:
                dVar.B();
                StringBuilder stringBuilder9 = new StringBuilder();
                String str15 = "Count of pattern letters is not 2: ";
                r1 = str15 + i;
                throw new IllegalArgumentException(str15 + i);
            case 80:
                dVar.g(z0.j(locale).m(), z2);
                StringBuilder stringBuilder3 = new StringBuilder();
                String str9 = "Too many pattern letters (W): ";
                r1 = str9 + i;
                throw new IllegalArgumentException(str9 + i);
            case 81:
                w.addOffset(dVar, c, i, z2);
                break;
            case 82:
                dVar.D(g0.I);
                dVar.E(g0.I, i, z);
                break;
            case 83:
                dVar.C(e.LONG, z, Collections.singletonList("+0000"));
                dVar.p();
                dVar.C(e.LONG, z2, Collections.singletonList("Z"));
                StringBuilder stringBuilder2 = new StringBuilder();
                String str6 = "Too many pattern letters (Z): ";
                r1 = str6 + i;
                throw new IllegalArgumentException(str6 + i);
            case 84:
                periodWidth = v.ABBREVIATED;
                periodWidth = w.getPeriodWidth(i);
                dVar.b0(a.g, periodWidth);
                dVar.z(h0.I);
                dVar.L();
                p ethiopianHour = w.findEthiopianHour(wVar);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(ethiopianHour, h0.J);
                return hashMap2;
            case 85:
                dVar.b0(a.g, w.getPeriodWidth(i));
                dVar.f();
                dVar.L();
                break;
            case 86:
                dVar.b0(a.h, m.STANDALONE);
                dVar.h(z0.j(locale).i(), z2);
                c = 'E';
                this.cldrISO(dVar, wVar, locale, 'E', i, z);
                dVar.L();
                throw new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
            case 87:
                w.addNumber(g0.M, c, dVar, i, z62);
                break;
            case 88:
                dVar.h(z0.j(locale).i(), i);
                this.cldrISO(dVar, wVar, locale, 'E', i, z);
                break;
            case 89:
                dVar.q(z.MODIFIED_JULIAN_DATE, i, 18, x.SHOW_WHEN_NEGATIVE);
                break;
            case 90:
                w.addNumber(h0.J, c, dVar, i, z62);
                break;
            case 91:
                w.addNumber(h0.K, c, dVar, i, z62);
                break;
            case 92:
                w.addNumber(h0.O, c, dVar, i, z62);
                break;
            case 93:
                dVar.b0(a.h, m.STANDALONE);
                w.addQuarterOfYear(dVar, i);
                dVar.L();
                break;
            case 94:
                dVar.b0(a.l, j.ARABIC);
                dVar.Z(a.m, '0');
                dVar.E(g0.H, i, z2);
                dVar.L();
                dVar.L();
                break;
            case 95:
                w.addNumber(h0.Q, c, dVar, i, z62);
                break;
            case 96:
                dVar.E(g0.H, i, z2);
                break;
            case 97:
                cVar = z0.j(locale).n();
                Iterator it = wVar.u().iterator();
                Object item = it.next();
                z0 z0Var5 = z0.D;
                cVar = z0.D.n();
                w.addNumber(cVar, c, dVar, i, z62);
                StringBuilder stringBuilder7 = new StringBuilder();
                String str13 = "Too many pattern letters (w): ";
                r1 = str13 + i;
                throw new IllegalArgumentException(str13 + i);
            case 98:
                w.addOffset(dVar, c, i, z);
                break;
            case 99:
                dVar.D(g0.H);
                dVar.E(g0.H, i, z);
                break;
            default:
                dVar.y();
                StringBuilder stringBuilder8 = new StringBuilder();
                String str14 = "Too many pattern letters (z): ";
                r1 = str14 + i;
                throw new IllegalArgumentException(str14 + i);
        }
        return Collections.emptyMap();
    }

    private Map<p<?>, p<?>> dynamic(c.d<?> dVar, char c, int i, Locale locale) {
        int i2 = 0;
        w effectiveChronology;
        Object cast;
        v sHORT2;
        Class<Enum> obj = Enum.class;
        i2 = 1;
        int i4 = 65;
        int r2 = c >= 65 && c <= 90 ? i2 : 0;
        p dynamicElement = w.findDynamicElement(w.getEffectiveChronology(dVar), locale, c);
        if (dynamicElement == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str2 = "Cannot resolve symbol: ";
            c = str2 + c;
            throw new IllegalArgumentException(c);
        } else {
            if (i2 != 0) {
                z = dynamicElement instanceof t;
                if (!z) {
                    if (obj.isAssignableFrom(dynamicElement.getType())) {
                        if (i != i2) {
                            i = 2;
                            if (i != 2) {
                                i = 3;
                                if (i != 3) {
                                    i = 4;
                                    if (i != 4) {
                                        StringBuilder stringBuilder3 = new StringBuilder();
                                        String str3 = "Illegal count of symbols: ";
                                        c = str3 + c;
                                        throw new IllegalArgumentException(c);
                                    } else {
                                        dVar.b0(a.g, v.WIDE);
                                    }
                                }
                                dVar.b0(a.g, v.ABBREVIATED);
                            } else {
                                dVar.b0(a.g, v.SHORT);
                            }
                        } else {
                            dVar.b0(a.g, v.NARROW);
                        }
                        if (z) {
                            dVar.A((t)w.cast(dynamicElement));
                        } else {
                            w.addEnumElementAsText(dVar, (p)w.cast(dynamicElement));
                        }
                        dVar.L();
                    } else {
                        if (dynamicElement.getType() == Integer.class) {
                            dVar.j((p)w.cast(dynamicElement), i, 9);
                        } else {
                            if (obj.isAssignableFrom(dynamicElement.getType())) {
                                w.addEnumElementAsInteger(dVar, (p)w.cast(dynamicElement), i);
                            }
                        }
                    }
                }
                return Collections.emptyMap();
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Can only handle enum or integer elements in a numerical way: ";
            c = str + dynamicElement;
            throw new IllegalArgumentException(c);
        }
    }

    private static p<?> find(Set<p<?>> set, char c, String str) {
        int c22 = 101;
        Object obj;
        c22 = 77;
        if (c == 76) {
        } else {
            int r1 = c == 99 ? 101 : c;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.isDateElement() && item.getSymbol() == c22) {
            }
        }
        int i = 121;
        if (c != 121) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Cannot find any chronological date element for symbol ";
            String str5 = " in \"";
            String str6 = "\".";
            c = str + c + str5 + str + str6;
            throw new IllegalArgumentException(c);
        } else {
            if (str.equals("net.time4j.PlainDate")) {
                return g0.H;
            }
        }
    }

    private static p<?> findDynamicElement(w<?> wVar, Locale locale, int i) {
        p dynamicElement;
        if (w.findDynamicElement(wVar, locale, i, false) == null) {
            dynamicElement = w.findDynamicElement(wVar, locale, i, true);
        }
        return dynamicElement;
    }

    private static p<Integer> findEthiopianHour(w<?> wVar) {
        net.time4j.g1.a aVar;
        Object obj;
        Iterator it2 = wVar.o().iterator();
        while (it2.hasNext()) {
            Iterator it = (r)it2.next().c(Locale.ROOT, a.f()).iterator();
            while (it.hasNext()) {
                Locale item = it.next();
                if (item.name().equals("ETHIOPIAN_HOUR")) {
                    return (p)w.cast(item);
                }
            }
            item = it.next();
            if (item.name().equals("ETHIOPIAN_HOUR")) {
                return (p)w.cast(item);
            }
        }
        return null;
    }

    private Map<p<?>, p<?>> general(c.d<?> dVar, w<?> wVar, char c, int i, Locale locale) {
        v nARROW2;
        v nARROW22;
        v sHORT2;
        Object cast;
        net.time4j.engine.c cVar;
        boolean equals;
        net.time4j.engine.c cVar2;
        j eTHIOPIC2;
        String str2;
        w wVar22;
        p pVar;
        m sTANDALONE2;
        int c32;
        int i3 = 1;
        int i2 = 0;
        t tVar;
        net.time4j.g1.z.c.d dVar2 = dVar;
        wVar22 = wVar;
        c32 = c;
        c32 = i;
        if (c32 == 103) {
            dVar2.q(z.MODIFIED_JULIAN_DATE, c32, 18, x.SHOW_WHEN_NEGATIVE);
            return Collections.emptyMap();
        }
        i = 71;
        if (c32 == 71 && x.SHOW_WHEN_NEGATIVE == g0.t0()) {
            return this.cldrISO(dVar, wVar, locale, c, i, false);
        }
        String name = dVar.P().l().getName();
        p find = w.find(w.getElements(wVar22, c32, locale), c32, name);
        str3 = "\"";
        str4 = " in \"";
        str5 = "Implementation error: ";
        i2 = 0;
        if (Integer.class.isAssignableFrom(find.getType())) {
            z = find instanceof a;
            if (find instanceof a) {
            }
            Object cast5 = w.cast(find);
            int i5 = 76;
            if (c32 != 76) {
                i5 = 77;
                if (c32 != 77 && c32 != 85) {
                    i3 = 1;
                    if (c32 != 87) {
                        if (c32 != 114) {
                            boolean z2 = false;
                            if (c32 != 119) {
                                int i18 = 2;
                                if (c32 != 121) {
                                    switch (c32) {
                                        case 68:
                                            dVar2.j(pVar, c32, i8);
                                            dVar2.g(pVar, c32);
                                            StringBuilder stringBuilder3 = new StringBuilder();
                                            String str9 = "Too many pattern letters (D): ";
                                            r1 = str9 + c32;
                                            throw new IllegalArgumentException(str9 + c32);
                                        case 69:
                                            sHORT2 = v.ABBREVIATED;
                                            sHORT2 = v.WIDE;
                                            sHORT2 = v.NARROW;
                                            sHORT2 = v.SHORT;
                                            dVar2.b0(a.g, sHORT2);
                                            dVar2.A(tVar);
                                            dVar.L();
                                            StringBuilder stringBuilder6 = new StringBuilder();
                                            String str12 = "Too many pattern letters (E): ";
                                            r1 = str12 + c32;
                                            throw new IllegalArgumentException(str12 + c32);
                                        case 70:
                                            dVar2.g(pVar, c32);
                                            StringBuilder stringBuilder4 = new StringBuilder();
                                            String str10 = "Too many pattern letters (F): ";
                                            r1 = str10 + c32;
                                            throw new IllegalArgumentException(str10 + c32);
                                        case 71:
                                            nARROW22 = v.ABBREVIATED;
                                            nARROW22 = v.WIDE;
                                            nARROW22 = v.NARROW;
                                            dVar2.b0(a.g, nARROW22);
                                            dVar2.A(tVar);
                                            dVar.L();
                                            StringBuilder stringBuilder5 = new StringBuilder();
                                            String str11 = "Too many pattern letters (G): ";
                                            r1 = str11 + c32;
                                            throw new IllegalArgumentException(str11 + c32);
                                        default:
                                            dVar2.h((p)w.cast(find), c32);
                                            this.general(dVar, wVar, 'E', i, locale);
                                            dVar2.a0(a.u, c32);
                                            dVar2.A(tVar);
                                            dVar.L();
                                            StringBuilder stringBuilder7 = new StringBuilder();
                                            String str13 = "Too many pattern letters for day-of-month: ";
                                            r1 = str13 + c32;
                                            throw new IllegalArgumentException(str13 + c32);
                                    }
                                    StringBuilder stringBuilder8 = new StringBuilder();
                                    String str14 = "Unsupported pattern symbol: ";
                                    r1 = str14 + c32;
                                    throw new IllegalArgumentException(r1);
                                }
                                str2 = "am";
                                if (locale.getLanguage().equals(str2)) {
                                    str2 = "ethiopic";
                                    if (w.getCalendarType(wVar).equals(str2)) {
                                        dVar2.b0(a.l, j.ETHIOPIC);
                                    } else {
                                    }
                                }
                                if (c32 == i18) {
                                    dVar2.D(pVar);
                                } else {
                                    dVar2.E(pVar, c32, z2);
                                }
                                if (i3 != 0) {
                                    dVar.L();
                                }
                            } else {
                                w.addNumber(pVar, c32, dVar2, c32, z2);
                            }
                        } else {
                            dVar2.b0(a.l, j.ARABIC);
                            dVar2.Z(a.m, '0');
                            dVar2.E(pVar, c32, true);
                            dVar.L();
                            dVar.L();
                        }
                    } else {
                        if (c32 == i3) {
                            dVar2.g(pVar, i3);
                        }
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str8 = "Too many pattern letters (W): ";
                    r1 = str8 + c32;
                    throw new IllegalArgumentException(r1);
                }
                w.addMonth(dVar2, c32, tVar);
            } else {
                dVar2.b0(a.h, m.STANDALONE);
                w.addMonth(dVar2, c32, tVar);
                dVar.L();
            }
        } else {
            if (find instanceof t) {
            }
        }
        StringBuilder stringBuilder10 = new StringBuilder();
        r0 = str5 + find + str4 + name + str3;
        throw new IllegalStateException(r0);
    }

    private static String getCalendarType(w<?> wVar) {
        String value;
        java.lang.annotation.Annotation annotation = wVar.l().getAnnotation(c.class);
        if (annotation == null) {
            value = "iso8601";
        } else {
            value = annotation.value();
        }
        return value;
    }

    private static w<?> getEffectiveChronology(c.d<?> dVar) {
        return dVar.P();
    }

    private static Set<p<?>> getElements(w<?> wVar, char c, Locale locale) {
        boolean equals;
        Object obj;
        final int i = 99;
        final int i2 = 101;
        final int i3 = 87;
        final int i4 = 119;
        Iterator it2 = wVar.o().iterator();
        while (it2.hasNext()) {
            Iterator it = (r)it2.next().c(locale, a.f()).iterator();
            while (it.hasNext()) {
                net.time4j.g1.a item = it.next();
            }
            item = it.next();
        }
        return Collections.emptySet();
    }

    private static v getPeriodWidth(int i) {
        if (i <= 3) {
            return v.ABBREVIATED;
        }
        if (v.ABBREVIATED == 4) {
            return v.WIDE;
        }
        if (v.WIDE != 5) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str = "Too many pattern letters: ";
            i = str + i;
            throw new IllegalArgumentException(i);
        } else {
            return v.NARROW;
        }
    }

    private static boolean isISO(w<?> wVar) {
        return w.getCalendarType(wVar).equals("iso8601");
    }

    private Map<p<?>, p<?>> sdf(c.d<?> dVar, w<?> wVar, Locale locale, char c, int i) {
        c = 'B';
        if (c == 'B') {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str2 = "CLDR pattern symbol not supported in SimpleDateFormat-style: ";
            wVar = str2 + c;
            throw new IllegalArgumentException(wVar);
        } else {
            c = 'O';
            if (c != 'O') {
                c = 'Q';
                if (c != 'Q') {
                    c = 'S';
                    if (c == 'S') {
                        dVar.g(h0.S, i);
                    } else {
                        c = 'Z';
                        if (c == 'Z') {
                            i = 2;
                            boolean z = false;
                            w.addOffset(dVar, c, i, z);
                        } else {
                            c = 'e';
                            if (c != 'e') {
                                c = 'g';
                                if (c != 'g') {
                                    c = 'u';
                                    if (c == 'u') {
                                        dVar.h(g0.N, i);
                                    } else {
                                        c = 'x';
                                        if (c != 'x') {
                                            c = 'b';
                                            if (c != 'b') {
                                                c = 'c';
                                                if (c != 'c') {
                                                    c = 'q';
                                                    if (c != 'q') {
                                                        c = 'r';
                                                        if (c != 'r') {
                                                            switch (c) {
                                                                case 85:
                                                                    stringBuilder2 = new StringBuilder();
                                                                    str2 = "CLDR pattern symbol not supported in SimpleDateFormat-style: ";
                                                                    wVar = str2 + c;
                                                                    throw new IllegalArgumentException(str2 + c);
                                                                case 86:
                                                                    dVar.g(z0.j(locale).a(), i);
                                                                    break;
                                                                case 87:
                                                                    return this.cldrISO(dVar, wVar, locale, 88, i, 1);
                                                                default:
                                                                    return this.cldrISO(dVar, wVar, locale, c, i, 1);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return Collections.emptyMap();
                }
            }
        }
    }

    @Override // java.lang.Enum
    Map<p<?>, p<?>> registerSymbol(c.d<?> dVar, Locale locale, char c, int i) {
        final w effectiveChronology = w.getEffectiveChronology(dVar);
        i = w.a.a[ordinal()];
        if (w.a.a != 1 && w.a.a != 2) {
            if (w.a.a != 3 && w.a.a != 4) {
                if (w.a.a != 5) {
                    throw new UnsupportedOperationException(name());
                } else {
                    return dynamic(dVar, c, i, locale);
                }
            }
            return cldr24(dVar, locale, c, i);
        }
        return cldr(dVar, locale, c, i);
    }

    private static p<?> findDynamicElement(w<?> wVar, Locale locale, int i, boolean z) {
        char symbol;
        int capitalized;
        if (z) {
            capitalized = w.capitalized(i);
        }
        Iterator it = wVar.u().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (symbol == capitalized) {
                return item;
            }
        }
        Iterator it2 = wVar.o().iterator();
        while (it2.hasNext()) {
            it = (r)it2.next().c(locale, a.f()).iterator();
            while (it.hasNext()) {
                net.time4j.g1.a item2 = it.next();
                if (symbol == capitalized) {
                    return item2;
                }
            }
            item2 = it.next();
            if (symbol == capitalized) {
                return item2;
            }
        }
        return null;
    }

    private static <V extends Enum<V>> void addMonth(c.d<?> dVar, int i, t<?> tVar) {
        i = 1;
        final int i6 = 2;
        if (i == i || i == i6) {
            if (!Enum.class.isAssignableFrom(tVar.getType())) {
                dVar.a0(a.u, i);
                dVar.A(tVar);
                dVar.L();
            } else {
                Object cast = w.cast(tVar);
                if (i == i) {
                    dVar.u(cast, i, i6);
                } else {
                    if (i == i6) {
                        dVar.h(cast, i6);
                    }
                }
            }
        } else {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = "Too many pattern letters for month: ";
                        i = str + i;
                        throw new IllegalArgumentException(i);
                    } else {
                        dVar.b0(a.g, v.NARROW);
                        dVar.A(tVar);
                        dVar.L();
                    }
                }
                dVar.b0(a.g, v.WIDE);
                dVar.A(tVar);
                dVar.L();
            } else {
                dVar.b0(a.g, v.ABBREVIATED);
                dVar.A(tVar);
                dVar.L();
            }
        }
    }

    private static int capitalized(int i) {
        final int i3 = 65;
        if (i >= i3 && i <= 90) {
            return i;
        }
        return (i + i3) - 97;
    }

    private static <T> T cast(Object object) {
        return object;
    }

    private static boolean isGeneralSymbol(char c) {
        int i2 = 76;
        if (c != 76 && c != 77 && c != 85 && c != 87 && c != 103 && c != 114 && c != 119 && c != 121 && /* condition */) {
            return false;
        }
        return true;
    }
}
