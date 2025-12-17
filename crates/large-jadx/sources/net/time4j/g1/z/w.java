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
import net.time4j.g1.a;
import net.time4j.g1.a0.a;
import net.time4j.g1.c;
import net.time4j.g1.e;
import net.time4j.g1.j;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;
import net.time4j.h0;
import net.time4j.history.d;
import net.time4j.z0;

/* loaded from: classes3.dex */
public enum w {

    CLDR,
    SIMPLE_DATE_FORMAT,
    CLDR_24,
    CLDR_DATE,
    DYNAMIC;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            w.a.a = iArr;
            iArr[w.CLDR.ordinal()] = 1;
            w.a.a[w.SIMPLE_DATE_FORMAT.ordinal()] = 2;
            w.a.a[w.CLDR_24.ordinal()] = 3;
            w.a.a[w.CLDR_DATE.ordinal()] = 4;
            w.a.a[w.DYNAMIC.ordinal()] = 5;
        }
    }
    private static void addEnumElementAsInteger(net.time4j.g1.z.c.d<?> c$d, p<? extends Enum> p2, int i3) {
        d.u(p2, i3, 9);
    }

    private static void addEnumElementAsText(net.time4j.g1.z.c.d<?> c$d, p<? extends Enum> p2) {
        d.z(p2);
    }

    private static void addMonth(net.time4j.g1.z.c.d<?> c$d, int i2) {
        int aBBREVIATED;
        Object obj3;
        aBBREVIATED = 1;
        int i5 = 2;
        if (i2 != aBBREVIATED) {
            if (i2 != i5) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                        } else {
                            d.b0(a.g, v.NARROW);
                            d.z(g0.K);
                            d.L();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Too many pattern letters for month: ");
                        stringBuilder.append(i2);
                        IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder.toString());
                        throw obj2;
                    }
                    d.b0(a.g, v.WIDE);
                    d.z(g0.K);
                    d.L();
                } else {
                    d.b0(a.g, v.ABBREVIATED);
                    d.z(g0.K);
                    d.L();
                }
            } else {
                d.g(g0.L, i5);
            }
        } else {
            d.j(g0.L, aBBREVIATED, i5);
        }
    }

    private static <V extends Enum<V>> void addMonth(net.time4j.g1.z.c.d<?> c$d, int i2, t<?> t3) {
        net.time4j.engine.c aBBREVIATED;
        boolean assignableFrom;
        Class type;
        int obj5;
        Object obj6;
        aBBREVIATED = 1;
        final int i5 = 2;
        if (i2 != aBBREVIATED && i2 != i5) {
            if (i2 != i5) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                        } else {
                            d.b0(a.g, v.NARROW);
                            d.A(t3);
                            d.L();
                        }
                        obj6 = new StringBuilder();
                        obj6.append("Too many pattern letters for month: ");
                        obj6.append(i2);
                        IllegalArgumentException obj4 = new IllegalArgumentException(obj6.toString());
                        throw obj4;
                    }
                    d.b0(a.g, v.WIDE);
                    d.A(t3);
                    d.L();
                } else {
                    d.b0(a.g, v.ABBREVIATED);
                    d.A(t3);
                    d.L();
                }
            } else {
                if (Enum.class.isAssignableFrom(t3.getType())) {
                    obj6 = w.cast(t3);
                    if (i2 == aBBREVIATED) {
                        d.u((p)obj6, aBBREVIATED, i5);
                    } else {
                        if (i2 == i5) {
                            d.h(obj6, i5);
                        }
                    }
                } else {
                    d.a0(a.u, i2);
                    d.A(t3);
                    d.L();
                }
            }
        } else {
        }
    }

    private static void addNumber(p<Integer> p, char c2, net.time4j.g1.z.c.d<?> c$d3, int i4, boolean z5) {
        final int i = 2;
        final int i2 = 1;
        if (i4 == i2) {
            d3.j(p, i2, i);
        } else {
            if (i4 != i) {
                if (!z5) {
                } else {
                }
                StringBuilder obj4 = new StringBuilder();
                obj4.append("Too many pattern letters (");
                obj4.append(c2);
                obj4.append("): ");
                obj4.append(i4);
                IllegalArgumentException obj2 = new IllegalArgumentException(obj4.toString());
                throw obj2;
            }
            d3.g(p, i4);
        }
    }

    private static void addOffset(net.time4j.g1.z.c.d<?> c$d, char c2, int i3, boolean z4) {
        int i2;
        String str;
        int i;
        String str2;
        String str3;
        e obj7;
        List obj8;
        i2 = 0;
        final int i4 = 1;
        str = "Z";
        if (i3 != i4) {
            str2 = "+0000";
            if (i3 != 2) {
                str3 = "+00:00";
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                        } else {
                            if (z4) {
                            } else {
                                str = str3;
                            }
                            d.C(e.LONG, i4, Collections.singletonList(str));
                        }
                        StringBuilder obj9 = new StringBuilder();
                        obj9.append("Too many pattern letters (");
                        obj9.append(c2);
                        obj9.append("): ");
                        obj9.append(i3);
                        IllegalArgumentException obj6 = new IllegalArgumentException(obj9.toString());
                        throw obj6;
                    }
                    if (z4) {
                    } else {
                        str = str2;
                    }
                    d.C(e.LONG, i2, Collections.singletonList(str));
                } else {
                    if (z4) {
                    } else {
                        str = str3;
                    }
                    d.C(e.MEDIUM, i4, Collections.singletonList(str));
                }
            } else {
                if (z4) {
                } else {
                    str = str2;
                }
                d.C(e.MEDIUM, i2, Collections.singletonList(str));
            }
        } else {
            if (z4) {
            } else {
                str = "+00";
            }
            d.C(e.SHORT, i2, Collections.singletonList(str));
        }
    }

    private static void addQuarterOfYear(net.time4j.g1.z.c.d<?> c$d, int i2) {
        Object aBBREVIATED;
        int i;
        int obj3;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                        } else {
                            d.b0(a.g, v.NARROW);
                            d.z(g0.J);
                            d.L();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Too many pattern letters for quarter-of-year: ");
                        stringBuilder.append(i2);
                        IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder.toString());
                        throw obj2;
                    }
                    d.b0(a.g, v.WIDE);
                    d.z(g0.J);
                    d.L();
                } else {
                    d.b0(a.g, v.ABBREVIATED);
                    d.z(g0.J);
                    d.L();
                }
            } else {
                d.h(g0.J, i2);
            }
        } else {
        }
    }

    private static int capitalized(int i) {
        int i2;
        final int i3 = 65;
        if (i >= i3 && i <= 90) {
            if (i <= 90) {
                return i;
            }
        }
        return obj2 += -97;
    }

    private static <T> T cast(Object object) {
        return object;
    }

    private Map<p<?>, p<?>> cldr(net.time4j.g1.z.c.d<?> c$d, Locale locale2, char c3, int i4) {
        boolean generalSymbol;
        int equals;
        String str;
        final w effectiveChronology = w.getEffectiveChronology(d);
        if (w.isGeneralSymbol(c3) && !w.isISO(effectiveChronology)) {
            if (!w.isISO(effectiveChronology)) {
                return this.general(d, effectiveChronology, c3, i4, locale2);
            }
        }
        if (c3 == 104 && w.getCalendarType(effectiveChronology).equals("ethiopic")) {
            if (w.getCalendarType(effectiveChronology).equals("ethiopic")) {
                p obj9 = w.findEthiopianHour(effectiveChronology);
                if (obj9 == null) {
                } else {
                    w.addNumber(obj9, c3, d, i4, false);
                    return Collections.emptyMap();
                }
                IllegalArgumentException obj8 = new IllegalArgumentException("Ethiopian time not available.");
                throw obj8;
            }
        }
        return this.cldrISO(d, effectiveChronology, locale2, c3, i4, false);
    }

    private Map<p<?>, p<?>> cldr24(net.time4j.g1.z.c.d<?> c$d, Locale locale2, char c3, int i4) {
        if (c3 == 72) {
            w.addNumber(h0.N, c3, d, i4, false);
            return Collections.emptyMap();
        }
        return cldr(d, locale2, c3, i4);
    }

    private Map<p<?>, p<?>> cldrISO(net.time4j.g1.z.c.d<?> c$d, w<?> w2, Locale locale3, char c4, int i5, boolean z6) {
        boolean equals2;
        v aBBREVIATED;
        net.time4j.d0 mODIFIED_JULIAN_DATE;
        v aBBREVIATED2;
        v periodWidth;
        Object singletonList;
        int sHOW_WHEN_NEGATIVE;
        int equals;
        int symbol;
        int i;
        boolean z;
        int i2;
        equals2 = d;
        mODIFIED_JULIAN_DATE = c4;
        i = i5;
        z = z6;
        singletonList = 5;
        sHOW_WHEN_NEGATIVE = 0;
        equals = 3;
        symbol = 2;
        i2 = 4;
        final int i6 = 1;
        switch (mODIFIED_JULIAN_DATE) {
            case 65:
                d.j(h0.V, i5, 8);
                break;
            case 66:
                d.b0(a.g, w.getPeriodWidth(i5));
                d.e();
                d.L();
                break;
            case 67:
                StringBuilder stringBuilder11 = new StringBuilder();
                stringBuilder11.append("Unsupported pattern symbol: ");
                stringBuilder11.append(c4);
                IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException(stringBuilder11.toString());
                throw illegalArgumentException12;
            case 68:
                d.j(g0.O, i5, equals);
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Too many pattern letters (D): ");
                stringBuilder3.append(i5);
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString());
                throw illegalArgumentException3;
                d.g(g0.O, i5);
                break;
            case 69:
                aBBREVIATED = v.ABBREVIATED;
                aBBREVIATED = v.NARROW;
                aBBREVIATED = v.SHORT;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Too many pattern letters (E): ");
                stringBuilder2.append(i5);
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException2;
                aBBREVIATED = v.WIDE;
                d.b0(a.g, aBBREVIATED);
                d.z(g0.N);
                d.L();
                break;
            case 70:
                StringBuilder stringBuilder7 = new StringBuilder();
                stringBuilder7.append("Too many pattern letters (F): ");
                stringBuilder7.append(i5);
                IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException(stringBuilder7.toString());
                throw illegalArgumentException8;
                d.g(g0.Q, i5);
                break;
            case 71:
                aBBREVIATED2 = v.ABBREVIATED;
                aBBREVIATED2 = v.NARROW;
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("Too many pattern letters (G): ");
                stringBuilder5.append(i5);
                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(stringBuilder5.toString());
                throw illegalArgumentException6;
                aBBREVIATED2 = v.WIDE;
                d.b0(a.g, aBBREVIATED2);
                d dVar = d.D(locale3);
                d.A((t)t.class.cast(dVar.i()));
                d.L();
                HashMap hashMap = new HashMap();
                hashMap.put(g0.H, dVar.M());
                hashMap.put(g0.K, dVar.C());
                hashMap.put(g0.L, dVar.C());
                hashMap.put(g0.M, dVar.g());
                hashMap.put(g0.O, dVar.h());
                return hashMap;
            case 72:
                w.addNumber(h0.M, c4, d, i5, z);
                break;
            case 73:
                w.addNumber(h0.L, c4, d, i5, z);
                break;
            case 74:
                d.b0(a.h, m.STANDALONE);
                i2 = i;
                w.addMonth(d, Math.min(i5, i2));
                d.L();
                break;
            case 75:
                i2 = i;
                w.addMonth(d, Math.min(i5, i2));
                break;
            case 76:
                d.x();
                d.p();
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append("Count of pattern letters is not 1 or 4: ");
                stringBuilder6.append(i5);
                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(stringBuilder6.toString());
                throw illegalArgumentException7;
            case 77:
                w.addQuarterOfYear(d, i5);
                break;
            case 78:
                d.i(h0.U, i5, i5, sHOW_WHEN_NEGATIVE);
                break;
            case 79:
                d.B();
                StringBuilder stringBuilder10 = new StringBuilder();
                stringBuilder10.append("Count of pattern letters is not 2: ");
                stringBuilder10.append(i5);
                IllegalArgumentException illegalArgumentException13 = new IllegalArgumentException(stringBuilder10.toString());
                throw illegalArgumentException13;
            case 80:
                d.g(z0.j(locale3).m(), i6);
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Too many pattern letters (W): ");
                stringBuilder4.append(i5);
                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(stringBuilder4.toString());
                throw illegalArgumentException5;
            case 81:
                w.addOffset(d, c4, i5, i6);
                break;
            case 82:
                d.D(g0.I);
                d.E(g0.I, i5, sHOW_WHEN_NEGATIVE);
                break;
            case 83:
                d.C(e.LONG, sHOW_WHEN_NEGATIVE, Collections.singletonList("+0000"));
                d.p();
                d.C(e.LONG, i6, Collections.singletonList("Z"));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many pattern letters (Z): ");
                stringBuilder.append(i5);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            case 84:
                periodWidth = v.ABBREVIATED;
                periodWidth = w.getPeriodWidth(i5);
                d.b0(a.g, periodWidth);
                d.z(h0.I);
                d.L();
                p ethiopianHour = w.findEthiopianHour(w2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(ethiopianHour, h0.J);
                return hashMap2;
                IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("Ethiopian time not available.");
                throw illegalArgumentException9;
            case 85:
                d.b0(a.g, w.getPeriodWidth(i5));
                d.f();
                d.L();
                break;
            case 86:
                d.b0(a.h, m.STANDALONE);
                d.h(z0.j(locale3).i(), i6);
                this.cldrISO(d, w2, locale3, 'E', i5, z6);
                d.L();
                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
                throw illegalArgumentException4;
            case 87:
                w.addNumber(g0.M, c4, d, i5, z);
                break;
            case 88:
                d.h(z0.j(locale3).i(), i5);
                this.cldrISO(d, w2, locale3, 'E', i5, z6);
                break;
            case 89:
                d.q(z.MODIFIED_JULIAN_DATE, i5, 18, x.SHOW_WHEN_NEGATIVE);
                break;
            case 90:
                w.addNumber(h0.J, c4, d, i5, z);
                break;
            case 91:
                w.addNumber(h0.K, c4, d, i5, z);
                break;
            case 92:
                w.addNumber(h0.O, c4, d, i5, z);
                break;
            case 93:
                d.b0(a.h, m.STANDALONE);
                w.addQuarterOfYear(d, i5);
                d.L();
                break;
            case 94:
                d.b0(a.l, j.ARABIC);
                d.Z(a.m, '0');
                d.E(g0.H, i5, i6);
                d.L();
                d.L();
                break;
            case 95:
                w.addNumber(h0.Q, c4, d, i5, z);
                break;
            case 96:
                d.E(g0.H, i5, i6);
                break;
            case 97:
                singletonList = z0.j(locale3).n();
                sHOW_WHEN_NEGATIVE = w2.u().iterator();
                equals = sHOW_WHEN_NEGATIVE.next();
                symbol = z0.D;
                singletonList = symbol.n();
                w.addNumber(singletonList, c4, d, i5, z);
                StringBuilder stringBuilder8 = new StringBuilder();
                stringBuilder8.append("Too many pattern letters (w): ");
                stringBuilder8.append(i5);
                IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(stringBuilder8.toString());
                throw illegalArgumentException10;
            case 98:
                w.addOffset(d, c4, i5, sHOW_WHEN_NEGATIVE);
                break;
            case 99:
                d.D(g0.H);
                d.E(g0.H, i5, sHOW_WHEN_NEGATIVE);
                break;
            default:
                d.y();
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append("Too many pattern letters (z): ");
                stringBuilder9.append(i5);
                IllegalArgumentException illegalArgumentException11 = new IllegalArgumentException(stringBuilder9.toString());
                throw illegalArgumentException11;
                d.r();
        }
        return Collections.emptyMap();
    }

    private Map<p<?>, p<?>> dynamic(net.time4j.g1.z.c.d<?> c$d, char c2, int i3, Locale locale4) {
        int obj;
        int i4;
        int i2;
        int i;
        w effectiveChronology;
        net.time4j.engine.c obj6;
        v obj7;
        p obj8;
        obj = Enum.class;
        i4 = 1;
        if (c2 >= 65 && c2 <= 90) {
            i = c2 <= 90 ? i4 : 0;
        } else {
        }
        obj8 = w.findDynamicElement(w.getEffectiveChronology(d), locale4, c2);
        if (obj8 == null) {
        } else {
            if (i != 0) {
                i = obj8 instanceof t;
                if (!i) {
                    if (obj.isAssignableFrom(obj8.getType())) {
                        if (i3 != i4) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 4) {
                                    } else {
                                        d.b0(a.g, v.WIDE);
                                    }
                                    obj7 = new StringBuilder();
                                    obj7.append("Illegal count of symbols: ");
                                    obj7.append(c2);
                                    IllegalArgumentException obj5 = new IllegalArgumentException(obj7.toString());
                                    throw obj5;
                                }
                                d.b0(a.g, v.ABBREVIATED);
                            } else {
                                d.b0(a.g, v.SHORT);
                            }
                        } else {
                            d.b0(a.g, v.NARROW);
                        }
                        if (i) {
                            d.A((t)w.cast(obj8));
                        } else {
                            w.addEnumElementAsText(d, (p)w.cast(obj8));
                        }
                        d.L();
                    } else {
                        if (obj8.getType() == Integer.class) {
                            d.j((p)w.cast(obj8), i3, 9);
                        } else {
                            if (!obj.isAssignableFrom(obj8.getType())) {
                            } else {
                                w.addEnumElementAsInteger(d, (p)w.cast(obj8), i3);
                            }
                        }
                    }
                } else {
                }
                return Collections.emptyMap();
            } else {
            }
            obj6 = new StringBuilder();
            obj6.append("Can only handle enum or integer elements in a numerical way: ");
            obj6.append(obj8);
            obj5 = new IllegalArgumentException(obj6.toString());
            throw obj5;
        }
        obj7 = new StringBuilder();
        obj7.append("Cannot resolve symbol: ");
        obj7.append(c2);
        obj5 = new IllegalArgumentException(obj7.toString());
        throw obj5;
    }

    private static p<?> find(Set<p<?>> set, char c2, String string3) {
        int i;
        Object next;
        boolean dateElement;
        String str;
        int obj5;
        int i2 = 77;
        i = c2 == 76 ? i2 : c2 == i4 ? 101 : c2;
        obj5 = set.iterator();
        for (p next : obj5) {
        }
        if (c2 != 121) {
        } else {
            if (!string3.equals("net.time4j.PlainDate")) {
            } else {
                return g0.H;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find any chronological date element for symbol ");
        stringBuilder.append(c2);
        stringBuilder.append(" in \"");
        stringBuilder.append(string3);
        stringBuilder.append("\".");
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    private static p<?> findDynamicElement(w<?> w, Locale locale2, int i3) {
        p dynamicElement;
        if (w.findDynamicElement(w, locale2, i3, false) == null) {
            dynamicElement = w.findDynamicElement(w, locale2, i3, true);
        }
        return dynamicElement;
    }

    private static p<?> findDynamicElement(w<?> w, Locale locale2, int i3, boolean z4) {
        Iterator iterator;
        Object next2;
        boolean next3;
        a next;
        char capitalized;
        int obj5;
        if (z4) {
            obj5 = w.capitalized(i3);
        }
        iterator = w.u().iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if (z4) {
            }
            capitalized = w.capitalized((p)next2.getSymbol());
        }
        Iterator obj3 = w.o().iterator();
        for (r next5 : obj3) {
            iterator = next5.c(locale2, a.f()).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (z4) {
                }
                capitalized = w.capitalized((p)next.getSymbol());
            }
            next = iterator.next();
            if (z4) {
            }
            capitalized = w.capitalized((p)next.getSymbol());
        }
        return 0;
    }

    private static p<Integer> findEthiopianHour(w<?> w) {
        Iterator iterator;
        boolean next;
        Locale rOOT;
        a equals;
        String str;
        Iterator obj4 = w.o().iterator();
        for (r next3 : obj4) {
            iterator = next3.c(Locale.ROOT, a.f()).iterator();
            for (p rOOT : iterator) {
            }
            rOOT = iterator.next();
        }
        return 0;
    }

    private Map<p<?>, p<?>> general(net.time4j.g1.z.c.d<?> c$d, w<?> w2, char c3, int i4, Locale locale5) {
        int i;
        v aBBREVIATED;
        int length;
        Object sTANDALONE2;
        w f0Var;
        boolean cast;
        Object sTANDALONE;
        int i8;
        int i10;
        int str3;
        String str4;
        String str;
        int i5;
        int i9;
        int i2;
        int i6;
        int i3;
        int i7;
        net.time4j.g1.z.c.d dVar2 = d;
        f0Var = w2;
        i8 = c3;
        i10 = i4;
        if (i8 == 103) {
            dVar2.q(z.MODIFIED_JULIAN_DATE, i10, 18, x.SHOW_WHEN_NEGATIVE);
            return Collections.emptyMap();
        }
        if (i8 == 71 && f0Var == g0.t0()) {
            if (f0Var == g0.t0()) {
                return this.cldrISO(d, w2, locale5, c3, i4, false);
            }
        }
        sTANDALONE2 = d.P().l().getName();
        aBBREVIATED = w.find(w.getElements(f0Var, i8, locale5), i8, sTANDALONE2);
        str3 = "\"";
        str4 = " in \"";
        str = "Implementation error: ";
        if (Integer.class.isAssignableFrom(aBBREVIATED.getType())) {
            if (aBBREVIATED instanceof a) {
                i5 = cast;
            }
            sTANDALONE = w.cast(aBBREVIATED);
            if (i8 != 76) {
                i2 = 5;
                i6 = 4;
                i3 = 3;
                if (i8 != 77 && i8 != 85) {
                    i2 = 5;
                    i6 = 4;
                    i3 = 3;
                    if (i8 != 85) {
                        str3 = 1;
                        if (i8 != 87) {
                            if (i8 != 114) {
                                str4 = 0;
                                if (i8 != 119) {
                                    str = 2;
                                    if (i8 != 121) {
                                        switch (i8) {
                                            case 68:
                                                dVar2.j(sTANDALONE, i10, i3);
                                                dVar2.g(sTANDALONE, i10);
                                                StringBuilder stringBuilder3 = new StringBuilder();
                                                stringBuilder3.append("Too many pattern letters (D): ");
                                                stringBuilder3.append(i10);
                                                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString());
                                                throw illegalArgumentException3;
                                                return Collections.emptyMap();
                                            case 69:
                                                aBBREVIATED = v.ABBREVIATED;
                                                aBBREVIATED = v.WIDE;
                                                aBBREVIATED = v.NARROW;
                                                aBBREVIATED = v.SHORT;
                                                dVar2.b0(a.g, aBBREVIATED);
                                                dVar2.A(i5);
                                                d.L();
                                                StringBuilder stringBuilder6 = new StringBuilder();
                                                stringBuilder6.append("Too many pattern letters (E): ");
                                                stringBuilder6.append(i10);
                                                IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException(stringBuilder6.toString());
                                                throw illegalArgumentException6;
                                                return Collections.emptyMap();
                                            case 70:
                                                dVar2.g(sTANDALONE, i10);
                                                StringBuilder stringBuilder4 = new StringBuilder();
                                                stringBuilder4.append("Too many pattern letters (F): ");
                                                stringBuilder4.append(i10);
                                                IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder4.toString());
                                                throw illegalArgumentException4;
                                                return Collections.emptyMap();
                                            case 71:
                                                aBBREVIATED = v.ABBREVIATED;
                                                aBBREVIATED = v.WIDE;
                                                aBBREVIATED = v.NARROW;
                                                dVar2.b0(a.g, aBBREVIATED);
                                                dVar2.A(i5);
                                                d.L();
                                                StringBuilder stringBuilder5 = new StringBuilder();
                                                stringBuilder5.append("Too many pattern letters (G): ");
                                                stringBuilder5.append(i10);
                                                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(stringBuilder5.toString());
                                                throw illegalArgumentException5;
                                                return Collections.emptyMap();
                                            default:
                                                dVar2.h((p)w.cast(aBBREVIATED), i10);
                                                this.general(d, w2, 'E', i4, locale5);
                                                dVar2.a0(a.u, i10);
                                                dVar2.A(i5);
                                                d.L();
                                                StringBuilder stringBuilder7 = new StringBuilder();
                                                stringBuilder7.append("Too many pattern letters for day-of-month: ");
                                                stringBuilder7.append(i10);
                                                IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException(stringBuilder7.toString());
                                                throw illegalArgumentException7;
                                                w.addNumber(sTANDALONE, i8, dVar2, i10, str4);
                                                dVar2.b0(a.h, m.STANDALONE);
                                                dVar2.h((p)w.cast(aBBREVIATED), str3);
                                                this.general(d, w2, 'E', i4, locale5);
                                                d.L();
                                                IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("Invalid pattern count of 2 for symbol 'c'.");
                                                throw illegalArgumentException8;
                                                return Collections.emptyMap();
                                        }
                                        StringBuilder stringBuilder8 = new StringBuilder();
                                        stringBuilder8.append("Unsupported pattern symbol: ");
                                        stringBuilder8.append(i8);
                                        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException(stringBuilder8.toString());
                                        throw illegalArgumentException9;
                                    }
                                    if (locale5.getLanguage().equals("am") && w.getCalendarType(w2).equals("ethiopic")) {
                                        if (w.getCalendarType(w2).equals("ethiopic")) {
                                            dVar2.b0(a.l, j.ETHIOPIC);
                                        } else {
                                            str3 = str4;
                                        }
                                    } else {
                                    }
                                    if (i10 == str) {
                                        dVar2.D(sTANDALONE);
                                    } else {
                                        dVar2.E(sTANDALONE, i10, str4);
                                    }
                                    if (str3 != null) {
                                        d.L();
                                    }
                                } else {
                                    w.addNumber(sTANDALONE, i8, dVar2, i10, str4);
                                }
                            } else {
                                dVar2.b0(a.l, j.ARABIC);
                                dVar2.Z(a.m, '0');
                                dVar2.E(sTANDALONE, i10, str3);
                                d.L();
                                d.L();
                            }
                        } else {
                            if (i10 != str3) {
                            } else {
                                dVar2.g(sTANDALONE, str3);
                            }
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Too many pattern letters (W): ");
                        stringBuilder2.append(i10);
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                        throw illegalArgumentException2;
                    }
                    if (i5 == 0) {
                    } else {
                        if (i10 <= i3) {
                            aBBREVIATED = v.ABBREVIATED;
                            dVar2.b0(a.g, aBBREVIATED);
                            dVar2.A(i5);
                            d.L();
                        } else {
                            if (i10 == i6) {
                                aBBREVIATED = v.WIDE;
                            } else {
                                if (i10 != i2) {
                                } else {
                                    aBBREVIATED = v.NARROW;
                                }
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Too many pattern letters (U): ");
                        stringBuilder.append(i10);
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                        throw illegalArgumentException;
                    }
                    StringBuilder stringBuilder9 = new StringBuilder();
                    stringBuilder9.append(str);
                    stringBuilder9.append(aBBREVIATED);
                    stringBuilder9.append(str4);
                    stringBuilder9.append(sTANDALONE2);
                    stringBuilder9.append(str3);
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder9.toString());
                    throw illegalStateException;
                }
                w.addMonth(dVar2, i10, i5);
            } else {
                dVar2.b0(a.h, m.STANDALONE);
                w.addMonth(dVar2, i10, i5);
                d.L();
            }
        } else {
            if (!aBBREVIATED instanceof t) {
            } else {
                i5 = cast2;
                sTANDALONE = i7;
            }
        }
        StringBuilder stringBuilder10 = new StringBuilder();
        stringBuilder10.append(str);
        stringBuilder10.append(aBBREVIATED);
        stringBuilder10.append(str4);
        stringBuilder10.append(sTANDALONE2);
        stringBuilder10.append(str3);
        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder10.toString());
        throw illegalStateException2;
    }

    private static String getCalendarType(w<?> w) {
        String obj1;
        obj1 = w.l().getAnnotation(c.class);
        if ((c)obj1 == null) {
            obj1 = "iso8601";
        } else {
            obj1 = (c)obj1.value();
        }
        return obj1;
    }

    private static w<?> getEffectiveChronology(net.time4j.g1.z.c.d<?> c$d) {
        return d.P();
    }

    private static Set<p<?>> getElements(w<?> w, char c2, Locale locale3) {
        Iterator iterator;
        boolean next2;
        a next;
        boolean equals;
        String str;
        final int i = 99;
        final int i2 = 101;
        final int i3 = 87;
        final int i4 = 119;
        if (c2 != i4 && c2 != i3 && c2 != i2 && c2 == i) {
            if (c2 != i3) {
                if (c2 != i2) {
                    if (c2 == i) {
                    }
                    return w.u();
                }
            }
        }
        Iterator obj8 = w.o().iterator();
        for (r next4 : obj8) {
            iterator = next4.c(locale3, a.f()).iterator();
            for (p next : iterator) {
            }
            next = iterator.next();
        }
        return Collections.emptySet();
    }

    private static v getPeriodWidth(int i) {
        if (i <= 3) {
            return v.ABBREVIATED;
        }
        if (i == 4) {
            return v.WIDE;
        }
        if (i != 5) {
        } else {
            return v.NARROW;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Too many pattern letters: ");
        stringBuilder.append(i);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static boolean isGeneralSymbol(char c) {
        int i;
        if (c != 76 && c != 77 && c != 85 && c != 87 && c != 103 && c != 114 && c != 119 && c != 121) {
            if (c != 77) {
                if (c != 85) {
                    if (c != 87) {
                        if (c != 103) {
                            if (c != 114) {
                                if (c != 119) {
                                    if (c != 121) {
                                        if (/* condition */) {
                                        } else {
                                            if (/* condition */) {
                                            }
                                        }
                                        return 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }

    private static boolean isISO(w<?> w) {
        return w.getCalendarType(w).equals("iso8601");
    }

    private Map<p<?>, p<?>> sdf(net.time4j.g1.z.c.d<?> c$d, w<?> w2, Locale locale3, char c4, int i5) {
        int i;
        int obj10;
        int obj11;
        if (c4 == 66) {
        } else {
            if (c4 == 79) {
            } else {
                if (c4 == 81) {
                } else {
                    if (c4 != 83) {
                        if (c4 != 90) {
                            if (c4 == 101) {
                            } else {
                                if (c4 == 103) {
                                } else {
                                    if (c4 != 117) {
                                        if (c4 == 120) {
                                        } else {
                                            if (c4 == 98) {
                                            } else {
                                                if (c4 == 99) {
                                                } else {
                                                    if (c4 == 113) {
                                                    } else {
                                                        if (c4 == 114) {
                                                        } else {
                                                            switch (c4) {
                                                                case 85:
                                                                    obj10 = new StringBuilder();
                                                                    obj10.append("CLDR pattern symbol not supported in SimpleDateFormat-style: ");
                                                                    obj10.append(c4);
                                                                    IllegalArgumentException obj9 = new IllegalArgumentException(obj10.toString());
                                                                    throw obj9;
                                                                case 86:
                                                                    d.g(z0.j(locale3).a(), i5);
                                                                    break;
                                                                case 87:
                                                                    return this.cldrISO(d, w2, locale3, 'X', i5, true);
                                                                    obj10 = new StringBuilder();
                                                                    obj10.append("Too many pattern letters (X): ");
                                                                    obj10.append(i5);
                                                                    obj9 = new IllegalArgumentException(obj10.toString());
                                                                    throw obj9;
                                                                default:
                                                                    return this.cldrISO(d, w2, locale3, c4, i5, true);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        d.h(g0.N, i5);
                                    }
                                }
                            }
                        } else {
                            w.addOffset(d, c4, 2, false);
                        }
                    } else {
                        d.g(h0.S, i5);
                    }
                    return Collections.emptyMap();
                }
            }
        }
    }

    Map<p<?>, p<?>> registerSymbol(net.time4j.g1.z.c.d<?> c$d, Locale locale2, char c3, int i4) {
        Class assignableFrom2;
        boolean assignableFrom;
        final w effectiveChronology = w.getEffectiveChronology(d);
        int i = w.a.a[ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                        } else {
                            return dynamic(d, c3, i4, locale2);
                        }
                        UnsupportedOperationException obj7 = new UnsupportedOperationException(name());
                        throw obj7;
                    }
                    assignableFrom2 = effectiveChronology.l();
                    if (!m.class.isAssignableFrom(assignableFrom2)) {
                        if (!l.class.isAssignableFrom(assignableFrom2)) {
                        } else {
                        }
                        obj7 = new IllegalArgumentException("No calendar chronology.");
                        throw obj7;
                    }
                    return this.general(d, effectiveChronology, c3, i4, locale2);
                }
                return cldr24(d, locale2, c3, i4);
            }
            return this.sdf(d, effectiveChronology, locale2, c3, i4);
        }
        return cldr(d, locale2, c3, i4);
    }
}
