package net.time4j.history;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.c;
import net.time4j.engine.f0;
import net.time4j.engine.m0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.f;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.t;
import net.time4j.g1.z.c;
import net.time4j.g1.z.l;
import net.time4j.history.q.b;

/* loaded from: classes3.dex */
public final class d implements m0, Serializable {

    public static final c<net.time4j.history.p> H = null;
    public static final net.time4j.history.d I = null;
    public static final net.time4j.history.d J = null;
    public static final net.time4j.history.d K = null;
    private static final long L = 0L;
    private static final net.time4j.history.d M = null;
    private static final net.time4j.history.d N = null;
    private static final Map<String, net.time4j.history.d> O = null;
    private static final long serialVersionUID = 4100690610730913643L;
    private final transient p<Integer> A;
    private final transient p<Integer> B;
    private final transient t<Integer> C;
    private final transient t<Integer> D;
    private final transient t<Integer> E;
    private final transient p<Integer> F;
    private final transient Set<p<?>> G;
    private final transient b a;
    private final transient List<net.time4j.history.f> b;
    private final transient net.time4j.history.a c;
    private final transient net.time4j.history.o v;
    private final transient net.time4j.history.g w;
    private final transient p<net.time4j.history.h> x;
    private final transient p<net.time4j.history.j> y;
    private final transient t<Integer> z;

    static class a {

        static final int[] a;
        static final int[] b;
        static final int[] c;
        static {
            int[] iArr = new int[values.length];
            d.a.c = iArr;
            int i2 = 1;
            iArr[p.DUAL_DATING.ordinal()] = i2;
            int i = 2;
            d.a.c[p.AFTER_NEW_YEAR.ordinal()] = i;
            int i3 = 3;
            d.a.c[p.BEFORE_NEW_YEAR.ordinal()] = i3;
            int[] iArr9 = new int[values2.length];
            d.a.b = iArr9;
            iArr9[j.HISPANIC.ordinal()] = i2;
            d.a.b[j.BYZANTINE.ordinal()] = i;
            d.a.b[j.AB_URBE_CONDITA.ordinal()] = i3;
            int[] iArr12 = new int[values3.length];
            d.a.a = iArr12;
            iArr12[b.PROLEPTIC_GREGORIAN.ordinal()] = i2;
            d.a.a[b.PROLEPTIC_JULIAN.ordinal()] = i;
            d.a.a[b.PROLEPTIC_BYZANTINE.ordinal()] = i3;
            d.a.a[b.SWEDEN.ordinal()] = 4;
            d.a.a[b.INTRODUCTION_ON_1582_10_15.ordinal()] = 5;
            d.a.a[b.SINGLE_CUTOVER_DATE.ordinal()] = 6;
        }
    }
    static {
        d.H = a.e("YEAR_DEFINITION", p.class);
        net.time4j.history.c gREGORIAN = c.GREGORIAN;
        long l = Long.MIN_VALUE;
        f fVar = new f(l, obj5, gREGORIAN, gREGORIAN);
        d dVar = new d(b.PROLEPTIC_GREGORIAN, Collections.singletonList(fVar));
        d.I = dVar;
        net.time4j.history.c jULIAN = c.JULIAN;
        f fVar2 = new f(l, obj5, jULIAN, jULIAN);
        d dVar2 = new d(b.PROLEPTIC_JULIAN, Collections.singletonList(fVar2));
        d.J = dVar2;
        b pROLEPTIC_BYZANTINE = b.PROLEPTIC_BYZANTINE;
        f fVar3 = new f(l, obj5, jULIAN, jULIAN);
        net.time4j.history.n bEGIN_OF_SEPTEMBER = n.BEGIN_OF_SEPTEMBER;
        o oVar7 = new o(bEGIN_OF_SEPTEMBER, Integer.MAX_VALUE);
        int i38 = 0;
        super(pROLEPTIC_BYZANTINE, Collections.singletonList(fVar3), i38, oVar7, g.c((g0)g0.t0().H()));
        d.K = dVar4;
        int i = 1582;
        int i6 = 10;
        long longValue = (Long)g0.K0(i, i6, 15).p(z.MODIFIED_JULIAN_DATE).longValue();
        d.L = longValue;
        d.M = d.F(longValue);
        ArrayList arrayList = new ArrayList();
        net.time4j.history.c sWEDISH = c.SWEDISH;
        f fVar4 = new f(-57959, i38, jULIAN, sWEDISH);
        arrayList.add(fVar4);
        int i29 = -53575;
        f fVar5 = new f(i29, i38, sWEDISH, jULIAN);
        arrayList.add(fVar5);
        f fVar6 = new f(-38611, i29, jULIAN, gREGORIAN);
        arrayList.add(fVar6);
        d dVar20 = new d(b.SWEDEN, Collections.unmodifiableList(arrayList));
        d.N = dVar20;
        HashMap hashMap = new HashMap();
        net.time4j.history.j aD = j.AD;
        int i44 = 12;
        int i47 = 24;
        net.time4j.history.n bEGIN_OF_JANUARY = n.BEGIN_OF_JANUARY;
        net.time4j.history.n cHRISTMAS_STYLE = n.CHRISTMAS_STYLE;
        int i23 = 1556;
        hashMap.put("ES", d.E().K(bEGIN_OF_JANUARY.until(1383).b(cHRISTMAS_STYLE.until(i23))).J(g.f(dVar2.d(h.k(aD, 1382, i44, i47)))));
        hashMap.put("PT", d.E().K(bEGIN_OF_JANUARY.until(1422).b(cHRISTMAS_STYLE.until(i23))).J(g.f(dVar2.d(h.k(aD, 1421, i44, i47)))));
        hashMap.put("FR", d.G(g0.K0(i, i44, 20)).K(n.EASTER_STYLE.until(1567)));
        int i14 = 1544;
        hashMap.put("DE", d.E().K(cHRISTMAS_STYLE.until(i14)));
        int i2 = 1583;
        hashMap.put("DE-BAYERN", d.G(g0.K0(i2, i6, 16)).K(cHRISTMAS_STYLE.until(i14)));
        int i15 = 9;
        int i32 = 1559;
        hashMap.put("DE-PREUSSEN", d.G(g0.K0(1610, i15, 2)).K(cHRISTMAS_STYLE.until(i32)));
        int i8 = 1700;
        int i45 = 1;
        hashMap.put("DE-PROTESTANT", d.G(g0.K0(i8, 3, i45)).K(cHRISTMAS_STYLE.until(i32)));
        hashMap.put("NL", d.G(g0.K0(i2, i45, i45)));
        int i33 = 1584;
        hashMap.put("AT", d.G(g0.K0(i33, i45, 17)));
        hashMap.put("CH", d.G(g0.K0(i33, i45, 22)));
        hashMap.put("HU", d.G(g0.K0(1587, 11, i45)));
        int i35 = 3;
        net.time4j.history.n mARIA_ANUNCIATA = n.MARIA_ANUNCIATA;
        int i52 = 1623;
        hashMap.put("DK", d.G(g0.K0(i8, i35, i45)).K(mARIA_ANUNCIATA.until(i52)));
        hashMap.put("NO", d.G(g0.K0(i8, i35, i45)).K(mARIA_ANUNCIATA.until(i52)));
        hashMap.put("IT", d.E().K(cHRISTMAS_STYLE.until(i2)));
        int i27 = 1749;
        hashMap.put("IT-FLORENCE", d.E().K(mARIA_ANUNCIATA.until(i27)));
        hashMap.put("IT-PISA", d.E().K(n.CALCULUS_PISANUS.until(i27)));
        net.time4j.history.n bEGIN_OF_MARCH = n.BEGIN_OF_MARCH;
        hashMap.put("IT-VENICE", d.E().K(bEGIN_OF_MARCH.until(1798)));
        int i3 = 1752;
        int i37 = 14;
        int i9 = 1155;
        hashMap.put("GB", d.G(g0.K0(i3, i15, i37)).K(cHRISTMAS_STYLE.until(1087).b(bEGIN_OF_JANUARY.until(i9)).b(mARIA_ANUNCIATA.until(i3))));
        hashMap.put("GB-SCT", d.G(g0.K0(i3, i15, i37)).K(cHRISTMAS_STYLE.until(1087).b(bEGIN_OF_JANUARY.until(i9)).b(mARIA_ANUNCIATA.until(1600))));
        hashMap.put("RU", d.G(g0.K0(1918, 2, i37)).K(bEGIN_OF_JANUARY.until(988).b(bEGIN_OF_MARCH.until(1493)).b(bEGIN_OF_SEPTEMBER.until(1700))).J(g.b(dVar2.d(h.k(aD, 988, 3, 1)), dVar2.d(h.k(aD, 1699, i44, 31)))));
        hashMap.put("SE", dVar20);
        d.O = Collections.unmodifiableMap(hashMap);
    }

    private d(b b, List<net.time4j.history.f> list2) {
        super(b, list2, 0, 0, g.d);
    }

    private d(b b, List<net.time4j.history.f> list2, net.time4j.history.a a3, net.time4j.history.o o4, net.time4j.history.g g5) {
        final Object obj3 = this;
        Object obj = b;
        Object obj2 = g5;
        super();
        if (list2.isEmpty()) {
        } else {
            Objects.requireNonNull(obj, "Missing historic variant.");
            Objects.requireNonNull(obj2, "Missing era preference.");
            obj3.a = obj;
            obj3.b = list2;
            obj3.c = a3;
            obj3.v = o4;
            obj3.w = obj2;
            i iVar = new i(obj3);
            obj3.x = iVar;
            k kVar = new k(obj3);
            obj3.y = kVar;
            int i7 = 1;
            int i8 = 999999999;
            final net.time4j.history.d dVar = this;
            super(121, i7, i8, dVar, 2);
            obj3.z = lVar8;
            int i2 = 0;
            super(i2, i7, i8, dVar, 6);
            obj3.A = lVar9;
            super(i2, i7, i8, dVar, 7);
            obj3.B = lVar10;
            super(77, i7, 12, dVar, 3);
            obj3.C = lVar11;
            super(100, i7, 31, dVar, 4);
            obj3.D = lVar12;
            super(68, i7, 365, dVar, 5);
            obj3.E = lVar13;
            super(0, i7, 10000000, dVar, 8);
            obj3.F = lVar14;
            HashSet hashSet = new HashSet();
            hashSet.add(iVar);
            hashSet.add(kVar);
            hashSet.add(lVar8);
            hashSet.add(lVar9);
            hashSet.add(lVar10);
            hashSet.add(lVar11);
            hashSet.add(lVar12);
            hashSet.add(lVar13);
            hashSet.add(lVar14);
            obj3.G = Collections.unmodifiableSet(hashSet);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("At least one cutover event must be present in chronological history.");
        throw illegalArgumentException;
    }

    private boolean A(net.time4j.history.h h) {
        int i;
        int i2;
        int obj6;
        int annoDomini = h.e().annoDomini(h.i());
        final int i5 = 999979465;
        i2 = 0;
        final int i6 = 1;
        if (this == d.K) {
            i = -5508;
            if (annoDomini >= i) {
                if (annoDomini == i) {
                    if (h.f() >= 9) {
                        if (annoDomini > i5) {
                            i2 = i6;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i2;
        }
        if (this == d.J && Math.abs(annoDomini) > i5) {
            if (Math.abs(annoDomini) > i5) {
                i2 = i6;
            }
            return i2;
        }
        if (this == d.I && Math.abs(annoDomini) > 999999999) {
            if (Math.abs(annoDomini) > 999999999) {
                i2 = i6;
            }
            return i2;
        }
        if (annoDomini >= -44) {
            if (annoDomini > 9999) {
                i2 = i6;
            }
        } else {
        }
        return i2;
    }

    public static net.time4j.history.d D(Locale locale) {
        String country;
        boolean stringBuilder;
        int obj2;
        if (!locale.getVariant().isEmpty()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(locale.getCountry());
            stringBuilder.append("-");
            stringBuilder.append(locale.getVariant());
            obj2 = d.O.get(stringBuilder.toString());
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
            obj2 = d.O.get(country);
        }
        if (obj2 == null) {
            obj2 = d.E();
        }
        return obj2;
    }

    public static net.time4j.history.d E() {
        return d.M;
    }

    private static net.time4j.history.d F(long l) {
        b sINGLE_CUTOVER_DATE;
        sINGLE_CUTOVER_DATE = Long.compare(l, l2) == 0 ? b.INTRODUCTION_ON_1582_10_15 : b.SINGLE_CUTOVER_DATE;
        f fVar = new f(l, obj6, c.JULIAN, c.GREGORIAN);
        d dVar = new d(sINGLE_CUTOVER_DATE, Collections.singletonList(fVar));
        return dVar;
    }

    public static net.time4j.history.d G(g0 g0) {
        if (g0.equals(g0.t0().H())) {
            return d.J;
        }
        if (g0.equals(g0.t0().I())) {
            return d.I;
        }
        long longValue = (Long)g0.p(z.MODIFIED_JULIAN_DATE).longValue();
        d.c(longValue);
        if (Long.compare(longValue, l) == 0) {
            return d.M;
        }
        return d.F(longValue);
    }

    public static net.time4j.history.d H() {
        return d.N;
    }

    private static void c(long l) {
        if (Long.compare(l, l2) < 0) {
        } else {
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Gregorian calendar did not exist before 1582-10-15");
        throw obj2;
    }

    public static net.time4j.history.d j(String string) {
        net.time4j.history.g substring2;
        int i5;
        net.time4j.history.d dVar;
        int i3;
        int i6;
        int equals;
        int i;
        Object substring;
        String[] split;
        Object str2;
        int i4;
        String str;
        boolean iArr;
        boolean equals2;
        int i2;
        String str3;
        int length;
        net.time4j.history.n valueOf;
        int bEGIN_OF_JANUARY;
        net.time4j.history.d obj14;
        if (!string.startsWith("historic-")) {
        } else {
            String[] split2 = string.substring(9).split(":");
            if (split2.length == 0) {
            } else {
                i5 = 0;
                b valueOf3 = b.valueOf(split2[i5]);
                int i12 = 2;
                final int i13 = 1;
                switch (i3) {
                    case 1:
                        return d.I;
                    case 2:
                        return d.J;
                    case 3:
                        return d.K;
                    case 4:
                        dVar = d.H();
                        i6 = i13;
                        str = "=";
                        substring = split2[i6].split(str);
                        String str29 = ",";
                        substring = substring[i13].substring(i13, length4 -= i13);
                        String[] split4 = substring.split(str29);
                        iArr = new int[split4.length];
                        i2 = i5;
                        iArr[i2] = int - 1;
                        i2++;
                        dVar = dVar.I(a.f(iArr));
                        split = split2[i6 + 1].split(str);
                        split = split[i13].substring(i13, length5 -= i13).split(str29);
                        equals2 = 0;
                        str3 = i5;
                        String[] split5 = split[str3].split("->");
                        valueOf = n.valueOf(split5[i5]);
                        length = Integer.parseInt(split5[i13]);
                        length = Integer.MAX_VALUE;
                        equals2 = valueOf.until(length);
                        equals2 = equals2.b(valueOf.until(length));
                        str3++;
                        dVar = dVar.K(equals2);
                        substring2 = split2[i6 += i12].split(str);
                        substring2 = substring2[i13].substring(i13, length2 -= i13);
                        String[] split3 = substring2.split(str29);
                        int i11 = 5;
                        str2 = l.i(split3[i13].substring(7));
                        g0 g0Var = l.i(split3[i12].substring(i11));
                        i5 = d.a.b[j.valueOf(split3[i5].substring(i11)).ordinal()];
                        obj14 = dVar.J(g.a(str2, g0Var));
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("BC/AD not allowed as era preference: ");
                        stringBuilder3.append(string);
                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString());
                        throw illegalArgumentException3;
                        obj14 = dVar.J(g.b(str2, g0Var));
                        obj14 = dVar.J(g.e(str2, g0Var));
                        dVar = obj14;
                        return dVar;
                    case 5:
                        dVar = d.E();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Inconsistent cutover date: ");
                        stringBuilder2.append(string);
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
                        throw illegalArgumentException2;
                    case 6:
                        dVar = d.G(d.s(split2, string));
                        break;
                    default:
                        obj14 = new UnsupportedOperationException(valueOf3.name());
                        throw obj14;
                }
                i6 = i12;
            }
            obj14 = new IllegalArgumentException("Invalid variant description.");
            throw obj14;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Variant does not start with \"historic-\": ");
        stringBuilder.append(string);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private static g0 s(String[] stringArr, String string2) {
        int i = 1;
        String[] obj3 = stringArr[i].split("=");
        if (obj3.length != 2) {
        } else {
            if (!obj3[0].equals("cutover")) {
            } else {
                return (g0)l.l.D(obj3[i]);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid cutover definition: ");
            stringBuilder.append(string2);
            obj3 = new IllegalArgumentException(stringBuilder.toString());
            throw obj3;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Invalid syntax in variant description: ");
        stringBuilder2.append(string2);
        obj3 = new IllegalArgumentException(stringBuilder2.toString());
        throw obj3;
    }

    private net.time4j.history.b u() {
        net.time4j.history.a aVar = this.c;
        if (aVar != null) {
            return aVar.d();
        }
        return c.JULIAN;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 3);
        return spx;
    }

    private static boolean z(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    @Override // net.time4j.engine.m0
    public boolean B(net.time4j.history.h h) {
        int i;
        net.time4j.history.b z;
        net.time4j.history.h obj3;
        i = 0;
        if (h != null) {
            if (A(h)) {
            } else {
                z = l(h);
                if (z != null && z.isValid(h)) {
                    if (z.isValid(h)) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    public t<Integer> C() {
        return this.C;
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.d I(net.time4j.history.a a) {
        Objects.requireNonNull(a, "Missing ancient julian leap years.");
        if (!y()) {
            return this;
        }
        super(this.a, this.b, a, this.v, this.w);
        return dVar;
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.d J(net.time4j.history.g g) {
        boolean equals;
        if (!g.equals(this.w) && !y()) {
            if (!y()) {
            }
            super(this.a, this.b, this.c, this.v, g);
            return dVar;
        }
        return this;
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.d K(net.time4j.history.o o) {
        if (o.equals(o.d) && this.v == null) {
            if (this.v == null) {
                return this;
            }
            super(this.a, this.b, this.c, 0, this.w);
            return obj8;
        }
        if (!y()) {
            return this;
        }
        super(this.a, this.b, this.c, o, this.w);
        return dVar2;
    }

    public p<Integer> L(net.time4j.history.p p) {
        int i = d.a.c[p.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return this.B;
                }
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(p.name());
                throw unsupportedOperationException;
            }
            return this.A;
        }
        return this.z;
    }

    public t<Integer> M() {
        return this.z;
    }

    @Override // net.time4j.engine.m0
    net.time4j.history.h a(net.time4j.history.h h) {
        int i2;
        int i;
        net.time4j.history.h obj4;
        net.time4j.history.b bVar = l(h);
        if (bVar == null) {
            return h;
        }
        int maximumDayOfMonth = bVar.getMaximumDayOfMonth(h);
        if (maximumDayOfMonth < h.c()) {
            obj4 = h.k(h.e(), h.i(), h.f(), maximumDayOfMonth);
        }
        return obj4;
    }

    public p<Integer> b() {
        return this.F;
    }

    @Override // net.time4j.engine.m0
    public g0 d(net.time4j.history.h h) {
        if (A(h)) {
        } else {
            net.time4j.history.b bVar = l(h);
            if (bVar == null) {
            } else {
                return g0.P0(bVar.toMJD(h), obj1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid historic date: ");
            stringBuilder.append(h);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Out of supported range: ");
        stringBuilder2.append(h);
        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
        throw illegalArgumentException2;
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.h e(g0 g0) {
        net.time4j.history.j yearOfEra;
        int i;
        int i2;
        net.time4j.history.h mJD;
        Object obj;
        int cmp;
        long longValue = (Long)g0.p(z.MODIFIED_JULIAN_DATE).longValue();
        size--;
        while (i2 >= 0) {
            obj = this.b.get(i2);
            i2--;
        }
        mJD = 0;
        if (mJD == null) {
            mJD = u().fromMJD(longValue);
        }
        net.time4j.history.j obj7 = this.w.d(mJD, g0);
        if (obj7 != mJD.e()) {
            mJD = h.k(obj7, obj7.yearOfEra(mJD.e(), mJD.i()), mJD.f(), mJD.c());
        }
        if (A(mJD)) {
        } else {
            return mJD;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Out of supported range: ");
        stringBuilder.append(mJD);
        obj7 = new IllegalArgumentException(stringBuilder.toString());
        throw obj7;
    }

    @Override // net.time4j.engine.m0
    public boolean equals(Object object) {
        int i;
        Object bVar;
        boolean equals;
        b sINGLE_CUTOVER_DATE;
        Object bVar2;
        long l;
        Object obj8;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof d && this.a == object.a && d.z(this.c, object.c) && d.z(this.v, object.v) && this.w.equals(object.w) && this.a == b.SINGLE_CUTOVER_DATE) {
            if (this.a == object.a) {
                if (d.z(this.c, object.c)) {
                    if (d.z(this.v, object.v)) {
                        if (this.w.equals(object.w)) {
                            if (this.a == b.SINGLE_CUTOVER_DATE) {
                                if (Long.compare(sINGLE_CUTOVER_DATE, l) == 0) {
                                } else {
                                    i = i2;
                                }
                            }
                            return i;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public p<net.time4j.history.h> f() {
        return this.x;
    }

    public p<Integer> g() {
        return this.D;
    }

    public p<Integer> h() {
        return this.E;
    }

    @Override // net.time4j.engine.m0
    public int hashCode() {
        b bVar = this.a;
        if (bVar == b.SINGLE_CUTOVER_DATE) {
            long l = obj.a;
            return (int)i;
        }
        return bVar.hashCode();
    }

    public p<net.time4j.history.j> i() {
        return this.y;
    }

    @Override // net.time4j.engine.m0
    public String k() {
        g0 i3;
        String str;
        Object str2;
        int i2;
        int length;
        int i;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("historic-");
        stringBuilder.append(this.a.name());
        i3 = d.a.a[this.a.ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 5 && i3 != 6) {
                        if (i3 != 6) {
                        } else {
                            stringBuilder.append(":cutover=");
                            stringBuilder.append(r());
                        }
                    } else {
                    }
                    stringBuilder.append(":ancient-julian-leap-years=");
                    net.time4j.history.a aVar = this.c;
                    if (aVar != null) {
                        int[] iArr2 = aVar.e();
                        stringBuilder.append('[');
                        stringBuilder.append(iArr2[0]);
                        for (int i : obj1) {
                            stringBuilder.append(',');
                            stringBuilder.append(i);
                        }
                        stringBuilder.append(']');
                    } else {
                        stringBuilder.append("[]");
                    }
                    stringBuilder.append(":new-year-strategy=");
                    stringBuilder.append(w());
                    stringBuilder.append(":era-preference=");
                    stringBuilder.append(p());
                } else {
                    stringBuilder.append(":no-cutover");
                }
            } else {
            }
        } else {
        }
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.m0
    net.time4j.history.b l(net.time4j.history.h h) {
        int i3;
        int i;
        int i2;
        size--;
        while (i3 >= 0) {
            Object obj = this.b.get(i3);
            i3--;
        }
        return u();
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.a m() {
        net.time4j.history.a aVar = this.c;
        if (aVar == null) {
        } else {
            return aVar;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No historic julian leap years were defined.");
        throw unsupportedOperationException;
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.h n(net.time4j.history.j j, int i2) {
        net.time4j.history.h hVar;
        net.time4j.history.g gVar;
        net.time4j.history.j obj4;
        hVar = w().d(j, i2);
        if (!B(hVar)) {
        } else {
            net.time4j.history.j obj5 = this.w.d(hVar, d(hVar));
            if (obj5 != j) {
                hVar = h.k(obj5, obj5.yearOfEra(hVar.e(), hVar.i()), hVar.f(), hVar.c());
            }
            return hVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot determine valid New Year: ");
        stringBuilder.append(j);
        stringBuilder.append("-");
        stringBuilder.append(i2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public Set<p<?>> o() {
        return this.G;
    }

    @Override // net.time4j.engine.m0
    net.time4j.history.g p() {
        return this.w;
    }

    List<net.time4j.history.f> q() {
        return this.b;
    }

    @Override // net.time4j.engine.m0
    public g0 r() {
        List list = this.b;
        size--;
        long l = obj.a;
        if (Long.compare(l, l2) == 0) {
        } else {
            return g0.P0(l, i);
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Proleptic history without any gregorian reform date.");
        throw unsupportedOperationException;
    }

    @Override // net.time4j.engine.m0
    b t() {
        return this.a;
    }

    @Override // net.time4j.engine.m0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChronoHistory[");
        stringBuilder.append(k());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override // net.time4j.engine.m0
    public int v(net.time4j.history.j j, int i2) {
        net.time4j.history.h hVar;
        int i;
        net.time4j.history.o bYZANTINE;
        net.time4j.history.j jVar;
        net.time4j.history.h obj5;
        int obj6;
        try {
            net.time4j.history.o oVar = this.v;
            i = 1;
            if (oVar == null) {
            } else {
            }
            hVar = h.k(j, i2, i, i);
            obj5 = h.k(j, i2, 12, 31);
            if (j == j.BC) {
            } else {
            }
            if (i2 == i) {
            } else {
            }
            obj5 = this.v.d(j.AD, i);
            obj5 = this.v.d(j, i2 -= i);
            if (j == j.BYZANTINE && this.v.d(j.AD, j.annoDomini(i2)).a(oVar.d(j, i2)) > 0) {
            } else {
            }
            if (this.v.d(j.AD, j.annoDomini(i2)).a(hVar) > 0) {
            } else {
            }
            obj5 = i;
            i = 0;
            return (int)obj5;
            j = -1;
            return j;
        }
    }

    @Override // net.time4j.engine.m0
    public net.time4j.history.o w() {
        net.time4j.history.o oVar;
        if (this.v == null) {
            oVar = o.d;
        }
        return oVar;
    }

    @Override // net.time4j.engine.m0
    public boolean x() {
        int i;
        i = this.c != null ? 1 : 0;
        return i;
    }

    @Override // net.time4j.engine.m0
    public boolean y() {
        int i;
        List list = this.b;
        if (Long.compare(l, l2) > 0) {
        } else {
            i = 0;
        }
        return i;
    }
}
