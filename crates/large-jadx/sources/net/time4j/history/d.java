package net.time4j.history;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.f0;
import net.time4j.engine.m0;
import net.time4j.engine.p;
import net.time4j.engine.q;
import net.time4j.engine.z;
import net.time4j.f;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.t;
import net.time4j.g1.z.l;
import net.time4j.history.q.b;

/* compiled from: ChronoHistory.java */
/* loaded from: classes3.dex */
public final class d implements m0, Serializable {

    public static final net.time4j.engine.c<p> H;
    public static final d I = null;
    public static final d J = null;
    public static final d K;
    private static final long L = 0L;
    private static final d M;
    private static final d N = null;
    private static final Map<String, d> O;
    private static final long serialVersionUID = 4100690610730913643L;
    private final transient p<Integer> A;
    private final transient p<Integer> B;
    private final transient t<Integer> C;
    private final transient t<Integer> D;
    private final transient t<Integer> E;
    private final transient p<Integer> F;
    private final transient Set<p<?>> G;
    private final transient b a;
    private final transient List<f> b;
    private final transient a c;
    private final transient o v;
    private final transient g w;
    private final transient p<h> x;
    private final transient p<j> y;
    private final transient t<Integer> z;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static {
            int[] iArr = new int[p.values().length];
            d.a.c = iArr;
            int i2 = 1;
            try {
                iArr[p.DUAL_DATING.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int[] iArr9 = new int[j.values().length];
                d.a.b = iArr9;
                int[] iArr12 = new int[b.values().length];
                d.a.a = iArr12;
                return;
            }
            int i = 2;
            try {
                d.a.c[p.AFTER_NEW_YEAR.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                iArr12 = new int[b.values().length];
                d.a.a = iArr12;
                return;
            }
        }
    }
    static {
        d.H = a.e("YEAR_DEFINITION", p.class);
        net.time4j.history.c gREGORIAN2 = c.GREGORIAN;
        long l = Long.MIN_VALUE;
        d.I = new d(b.PROLEPTIC_GREGORIAN, Collections.singletonList(new f(l, r5, gREGORIAN2, gREGORIAN2)));
        net.time4j.history.c jULIAN2 = c.JULIAN;
        net.time4j.history.d dVar3 = new d(b.PROLEPTIC_JULIAN, Collections.singletonList(new f(l, r5, jULIAN2, jULIAN2)));
        d.J = dVar3;
        b pROLEPTIC_BYZANTINE2 = b.PROLEPTIC_BYZANTINE;
        net.time4j.history.n bEGIN_OF_SEPTEMBER2 = n.BEGIN_OF_SEPTEMBER;
        net.time4j.history.a aVar = null;
        d dVar = new d(pROLEPTIC_BYZANTINE2, Collections.singletonList(new f(l, r5, jULIAN2, jULIAN2)), aVar, new o(bEGIN_OF_SEPTEMBER2, Integer.MAX_VALUE), g.c((g0)g0.t0().H()));
        d.K = dVar;
        int i = 1582;
        int i6 = 10;
        long value = (Long)g0.K0(i, i6, 15).p(z.MODIFIED_JULIAN_DATE).longValue();
        d.L = value;
        d.M = d.F(value);
        ArrayList arrayList = new ArrayList();
        net.time4j.history.c sWEDISH2 = c.SWEDISH;
        arrayList.add(new f(-57959L, aVar, jULIAN2, sWEDISH2));
        long l2 = -53575L;
        arrayList.add(new f(l2, aVar, sWEDISH2, jULIAN2));
        arrayList.add(new f(-38611L, l2, jULIAN2, gREGORIAN2));
        net.time4j.history.d dVar20 = new d(b.SWEDEN, Collections.unmodifiableList(arrayList));
        d.N = dVar20;
        HashMap hashMap = new HashMap();
        net.time4j.history.j aD2 = j.AD;
        int i42 = 12;
        int i45 = 24;
        net.time4j.history.n bEGIN_OF_JANUARY2 = n.BEGIN_OF_JANUARY;
        net.time4j.history.n cHRISTMAS_STYLE2 = n.CHRISTMAS_STYLE;
        int i23 = 1556;
        hashMap.put("ES", d.E().K(bEGIN_OF_JANUARY2.until(1383).b(cHRISTMAS_STYLE2.until(i23))).J(g.f(dVar3.d(h.k(aD2, 1382, i42, i45)))));
        hashMap.put("PT", d.E().K(bEGIN_OF_JANUARY2.until(1422).b(cHRISTMAS_STYLE2.until(i23))).J(g.f(dVar3.d(h.k(aD2, 1421, i42, i45)))));
        hashMap.put("FR", d.G(g0.K0(i, i42, 20)).K(n.EASTER_STYLE.until(1567)));
        int i14 = 1544;
        hashMap.put("DE", d.E().K(cHRISTMAS_STYLE2.until(i14)));
        int i2 = 1583;
        hashMap.put("DE-BAYERN", d.G(g0.K0(i2, i6, 16)).K(cHRISTMAS_STYLE2.until(i14)));
        int i15 = 9;
        int i31 = 1559;
        hashMap.put("DE-PREUSSEN", d.G(g0.K0(1610, i15, 2)).K(cHRISTMAS_STYLE2.until(i31)));
        int i8 = 1700;
        int i43 = 1;
        hashMap.put("DE-PROTESTANT", d.G(g0.K0(i8, 3, i43)).K(cHRISTMAS_STYLE2.until(i31)));
        hashMap.put("NL", d.G(g0.K0(i2, i43, i43)));
        int i32 = 1584;
        hashMap.put("AT", d.G(g0.K0(i32, i43, 17)));
        hashMap.put("CH", d.G(g0.K0(i32, i43, 22)));
        hashMap.put("HU", d.G(g0.K0(1587, 11, i43)));
        int i34 = 3;
        net.time4j.history.n mARIA_ANUNCIATA2 = n.MARIA_ANUNCIATA;
        int i50 = 1623;
        hashMap.put("DK", d.G(g0.K0(i8, i34, i43)).K(mARIA_ANUNCIATA2.until(i50)));
        hashMap.put("NO", d.G(g0.K0(i8, i34, i43)).K(mARIA_ANUNCIATA2.until(i50)));
        hashMap.put("IT", d.E().K(cHRISTMAS_STYLE2.until(i2)));
        int i27 = 1749;
        hashMap.put("IT-FLORENCE", d.E().K(mARIA_ANUNCIATA2.until(i27)));
        hashMap.put("IT-PISA", d.E().K(n.CALCULUS_PISANUS.until(i27)));
        net.time4j.history.n bEGIN_OF_MARCH2 = n.BEGIN_OF_MARCH;
        hashMap.put("IT-VENICE", d.E().K(bEGIN_OF_MARCH2.until(1798)));
        int i3 = 1752;
        int i36 = 14;
        int i9 = 1155;
        hashMap.put("GB", d.G(g0.K0(i3, i15, i36)).K(cHRISTMAS_STYLE2.until(1087).b(bEGIN_OF_JANUARY2.until(i9)).b(mARIA_ANUNCIATA2.until(i3))));
        hashMap.put("GB-SCT", d.G(g0.K0(i3, i15, i36)).K(cHRISTMAS_STYLE2.until(1087).b(bEGIN_OF_JANUARY2.until(i9)).b(mARIA_ANUNCIATA2.until(1600))));
        hashMap.put("RU", d.G(g0.K0(1918, 2, i36)).K(bEGIN_OF_JANUARY2.until(988).b(bEGIN_OF_MARCH2.until(1493)).b(bEGIN_OF_SEPTEMBER2.until(1700))).J(g.b(dVar3.d(h.k(aD2, 988, 3, 1)), dVar3.d(h.k(aD2, 1699, i42, 31)))));
        hashMap.put("SE", dVar20);
        d.O = Collections.unmodifiableMap(hashMap);
    }

    private d(b bVar, List<f> list) {
        this(bVar, list, null, null, g.d);
    }

    private boolean A(h hVar) {
        int i = -5508;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3;
        int i4 = -44;
        int annoDomini = hVar.e().annoDomini(hVar.i());
        final int i7 = 999979465;
        int i8 = 0;
        final int i2 = 1;
        if (this == d.K) {
            i = -5508;
            if (annoDomini < i || annoDomini == i) {
            } else {
                i = 9;
                int r3 = i2;
            }
            return i2;
        }
        if (this == d.J && Math.abs(annoDomini) > i7) {
            return z4;
        }
        if (this == d.I) {
            if (Math.abs(annoDomini) > 999999999) {
            }
            return z2;
        }
        i4 = -44;
        r3 = i2;
        return i2;
    }

    public static d D(Locale locale) {
        String country;
        int i = 0;
        country = locale.getCountry();
        if (!locale.getVariant().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "-";
            String variant2 = locale.getVariant();
            country = country + str + variant2;
            Object value2 = d.O.get(country);
        } else {
            i = 0;
        }
        if (d.O == 0) {
            Object value = d.O.get(country);
        }
        if (d.O == 0) {
            net.time4j.history.d dVar = d.E();
        }
        return i;
    }

    public static d E() {
        return d.M;
    }

    private static d F(long j) {
        b sINGLE_CUTOVER_DATE2;
        long l = d.L;
        b r1 = j == d.L ? b.INTRODUCTION_ON_1582_10_15 : b.SINGLE_CUTOVER_DATE;
        d dVar = new d((j == d.L ? b.INTRODUCTION_ON_1582_10_15 : b.SINGLE_CUTOVER_DATE), Collections.singletonList(fVar));
        return dVar;
    }

    public static d G(g0 g0Var) {
        if (g0Var.equals(g0.t0().H())) {
            return d.J;
        }
        if (g0Var.equals(g0.t0().I())) {
            return d.I;
        }
        long value = (Long)g0Var.p(z.MODIFIED_JULIAN_DATE).longValue();
        d.c(value);
        final long l2 = d.L;
        if (value == d.L) {
            return d.M;
        }
        return d.F(value);
    }

    public static d H() {
        return d.N;
    }

    private static void c(long j) {
        final long l = d.L;
        if (j < d.L) {
            throw new IllegalArgumentException("Gregorian calendar did not exist before 1582-10-15");
        }
    }

    public static d j(String str) {
        net.time4j.history.g gVar;
        net.time4j.history.d str2;
        int i2;
        int i3 = 3;
        int i4 = 10;
        int i5 = 15;
        net.time4j.history.o until = null;
        int i;
        int length;
        net.time4j.history.n str6;
        int length2;
        net.time4j.history.n bEGIN_OF_JANUARY2;
        if (!str.startsWith("historic-")) {
            StringBuilder stringBuilder = new StringBuilder();
            String str16 = "Variant does not start with \"historic-\": ";
            str = str16 + str;
            throw new IllegalArgumentException(str);
        } else {
            String[] parts4 = str.substring(9).split(":");
            if (parts4.length == 0) {
                throw new IllegalArgumentException("Invalid variant description.");
            } else {
                i = 0;
                b str18 = b.valueOf(parts4[i]);
                i2 = 2;
                i2 = 1;
                switch (d.a.a[str18.ordinal()]) {
                    case 1: /* ordinal */
                        return d.I;
                    case 2: /* ordinal */
                        return d.J;
                    case 3: /* ordinal */
                        return d.K;
                    case 4: /* ordinal */
                        str2 = d.H();
                        str4 = "=";
                        String[] parts2 = parts4[i2].split(str4);
                        String str34 = ",";
                        String substring5 = parts2[i2].substring(i2, parts2[i2].length() - i2);
                        String[] parts6 = substring5.split(str34);
                        int[] iArr3 = new int[parts6.length];
                        length = parts6.length;
                        i6 = Integer.parseInt(parts6[i]) - 1;
                        iArr3[i] = Integer.parseInt(parts6[i]) - 1;
                        i = i + 1;
                        str2 = str2.I(a.f(parts6.length));
                        String[] parts3 = parts4[i2 + 1].split(str4);
                        str5 = "new-year-strategy";
                        parts3 = parts3[i2].substring(i2, parts3[i2].length() - i2).split(str34);
                        int i17 = 0;
                        length = parts3.length;
                        String[] parts7 = parts3[i].split("->");
                        str6 = n.valueOf(parts7[i]);
                        length2 = parts7.length;
                        length = Integer.parseInt(parts7[i2]);
                        length = Integer.MAX_VALUE;
                        length2 = 567;
                        until = str6.until(length);
                        until = until.b(str6.until(parts3.length));
                        i = i + 1;
                        str2 = str2.K(until);
                        String[] parts = parts4[i2 + i2].split(str4);
                        str3 = "era-preference";
                        String substring2 = parts[i2].substring(i2, parts[i2].length() - i2);
                        String[] parts5 = substring2.split(str34);
                        int i12 = 5;
                        g0 g0Var5 = l.i(parts5[i2].substring(7));
                        g0 g0Var2 = l.i(parts5[i2].substring(i12));
                        i = d.a.b[j.valueOf(parts5[i].substring(i12)).ordinal()];
                        i3 = 3;
                        str2 = str2.J(g.a(g0Var5, g0Var2));
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str20 = "BC/AD not allowed as era preference: ";
                        r1 = str20 + str;
                        throw new IllegalArgumentException(str20 + str);
                    case 5: /* ordinal */
                        i4 = 10;
                        i5 = 15;
                        str2 = d.E();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        String str19 = "Inconsistent cutover date: ";
                        str = str19 + str;
                        throw new IllegalArgumentException(str19 + str);
                    case 6: /* ordinal */
                        str2 = d.G(d.s(parts4, d.J));
                        break;
                    default:
                        throw new UnsupportedOperationException(str18.name());
                }
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static g0 s(String[] strArr, String str) {
        int i = 1;
        String[] parts = strArr[i].split("=");
        if (parts.length != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Invalid syntax in variant description: ";
            str = str3 + str;
            throw new IllegalArgumentException(str);
        } else {
            if (!parts[0].equals("cutover")) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str5 = "Invalid cutover definition: ";
                str = str5 + str;
                throw new IllegalArgumentException(str);
            } else {
                try {
                } catch (java.text.ParseException unused) {
                    stringBuilder2 = new StringBuilder();
                    str5 = "Invalid cutover definition: ";
                    str = str5 + str;
                    throw new IllegalArgumentException(str);
                }
                return (g0)l.l.D(parts[i]);
            }
        }
    }

    private b u() {
        if (this.c != null) {
            return this.c.d();
        }
        return c.JULIAN;
    }

    private Object writeReplace() {
        return new SPX(this, 3);
    }

    private static boolean z(Object object, Object object2) {
        boolean equals = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
        } else {
            object = object.equals(object2);
        }
        return (object2 == null ? 1 : 0);
    }

    public boolean B(h hVar) {
        boolean z = false;
        int i = 0;
        return z;
    }

    public t<Integer> C() {
        return this.C;
    }

    public d I(a aVar) {
        Objects.requireNonNull(aVar, "Missing ancient julian leap years.");
        if (!y()) {
            return this;
        }
        d dVar = new d(this.a, this.b, aVar, this.v, this.w);
        return dVar;
    }

    public d J(g gVar) {
        return this;
    }

    public d K(o oVar) {
        if (oVar.equals(o.d)) {
            if (this.v == null) {
                return this;
            }
            d oVar2 = new d(this.a, this.b, this.c, null, this.w);
            return oVar2;
        }
        if (!y()) {
            return this;
        }
        d dVar = new d(this.a, this.b, this.c, oVar, this.w);
        return dVar;
    }

    public p<Integer> L(p pVar) {
        int i = d.a.c[pVar.ordinal()];
        if (d.a.c != 1 && d.a.c != 2) {
            if (d.a.c != 3) {
                throw new UnsupportedOperationException(pVar.name());
            } else {
                return this.B;
            }
        }
        return this.z;
    }

    public t<Integer> M() {
        return this.z;
    }

    h a(h hVar) {
        net.time4j.history.h hVar2;
        net.time4j.history.b bVar = l(hVar);
        if (bVar == null) {
            return hVar;
        }
        int maximumDayOfMonth = bVar.getMaximumDayOfMonth(hVar);
        if (maximumDayOfMonth < hVar.c()) {
            hVar2 = h.k(hVar.e(), hVar.i(), hVar.f(), maximumDayOfMonth);
        }
        return hVar2;
    }

    public p<Integer> b() {
        return this.F;
    }

    public g0 d(h hVar) {
        if (A(hVar)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str2 = "Out of supported range: ";
            hVar = str2 + hVar;
            throw new IllegalArgumentException(hVar);
        } else {
            net.time4j.history.b bVar = l(hVar);
            if (bVar == null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Invalid historic date: ";
                hVar = str + hVar;
                throw new IllegalArgumentException(hVar);
            } else {
                return g0.P0(bVar.toMJD(hVar), z.MODIFIED_JULIAN_DATE);
            }
        }
    }

    public h e(g0 g0Var) {
        int i2;
        net.time4j.history.h mJD = null;
        Object item;
        int cmp;
        long value = (Long)g0Var.p(z.MODIFIED_JULIAN_DATE).longValue();
        i2 = this.b.size() - 1;
        while (this.b >= 0) {
            item = this.b.get(i2);
            if (z.MODIFIED_JULIAN_DATE >= item.a) {
                break;
            }
        }
        int i5 = 0;
        if (this.b == null) {
            mJD = u().fromMJD(value);
        }
        net.time4j.history.j jVar3 = this.w.d(mJD, g0Var);
        if (jVar3 != mJD.e()) {
            mJD = h.k(jVar3, jVar3.yearOfEra(mJD.e(), mJD.i()), mJD.f(), mJD.c());
        }
        if (A(mJD)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Out of supported range: ";
            r0 = str + mJD;
            throw new IllegalArgumentException(r0);
        } else {
            return mJD;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        equals = object instanceof d;
        final int i = 0;
        if (object instanceof d) {
            if (this.a == object.a) {
                if (d.z(this.c, object.c)) {
                    if (d.z(this.v, object.v)) {
                        if (this.w.equals(object.w)) {
                            if (this.a == b.SINGLE_CUTOVER_DATE) {
                                if (l2 != l) {
                                }
                            }
                            return z;
                        }
                    }
                }
            }
        }
        return false;
    }

    public p<h> f() {
        return this.x;
    }

    public p<Integer> g() {
        return this.D;
    }

    public p<Integer> h() {
        return this.E;
    }

    @Override // java.lang.Object
    public int hashCode() {
        if (this.a == b.SINGLE_CUTOVER_DATE) {
            return (int)(l ^ (l << 32L));
        }
        return this.a.hashCode();
    }

    public p<j> i() {
        return this.y;
    }

    public String k() {
        int i = 1;
        int length = 2;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("historic-");
        stringBuilder.append(this.a.name());
        int i4 = d.a.a[this.a.ordinal()];
        i = 1;
        if (d.a.a == 1 || d.a.a == 2 || d.a.a == 3) {
            str = ":no-cutover";
            stringBuilder.append(str);
        } else {
            length = 5;
            if (d.a.a == 5 || d.a.a == 6) {
                stringBuilder.append(":cutover=");
                stringBuilder.append(r());
            }
            stringBuilder.append(":ancient-julian-leap-years=");
            if (this.c != null) {
                int[] iArr2 = this.c.e();
                stringBuilder.append('[');
                stringBuilder.append(iArr2[0]);
                length = iArr2.length;
                for (int i2 : iArr2) {
                    stringBuilder.append(',');
                    stringBuilder.append(i2);
                    length = iArr2.length;
                }
                stringBuilder.append(']');
            } else {
                str2 = "[]";
                stringBuilder.append(str2);
            }
            stringBuilder.append(":new-year-strategy=");
            stringBuilder.append(w());
            stringBuilder.append(":era-preference=");
            stringBuilder.append(p());
        }
        return stringBuilder.toString();
    }

    b l(h hVar) {
        int i;
        i = this.b.size() - 1;
        while (this.b >= 0) {
            Object item = this.b.get(i);
            if (hVar.a(item.d) > 0) {
                return null;
            }
        }
        return u();
    }

    public a m() {
        if (this.c == null) {
            throw new UnsupportedOperationException("No historic julian leap years were defined.");
        } else {
            return this.c;
        }
    }

    public h n(j jVar, int i) {
        net.time4j.history.h hVar;
        hVar = w().d(jVar, i);
        if (!B(hVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Cannot determine valid New Year: ";
            String str2 = "-";
            jVar = str + jVar + str2 + i;
            throw new IllegalArgumentException(jVar);
        } else {
            net.time4j.history.j jVar3 = this.w.d(hVar, d(hVar));
            if (jVar3 != jVar) {
                hVar = h.k(jVar3, jVar3.yearOfEra(hVar.e(), hVar.i()), hVar.f(), hVar.c());
            }
            return hVar;
        }
    }

    public Set<p<?>> o() {
        return this.G;
    }

    g p() {
        return this.w;
    }

    List<f> q() {
        return this.b;
    }

    public g0 r() {
        int i = this.b.size() - 1;
        if (l == -9223372036854775808L) {
            throw new UnsupportedOperationException("Proleptic history without any gregorian reform date.");
        } else {
            return g0.P0(l, z.MODIFIED_JULIAN_DATE);
        }
    }

    b t() {
        return this.a;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ChronoHistory[";
        String str3 = k();
        String str4 = "]";
        str = str2 + str3 + str4;
        return str;
    }

    public int v(j jVar, int i) {
        net.time4j.history.h hVar;
        net.time4j.history.o oVar;
        net.time4j.history.j bYZANTINE2;
        net.time4j.history.j aD2;
        net.time4j.history.h hVar2;
        int i3;
        try {
            i = 1;
            if (this.v == null) {
                hVar = h.k(jVar, i, i, i);
                hVar2 = h.k(jVar, i, 12, 31);
            } else {
                if (jVar == j.BC) {
                    if (i == i) {
                        hVar2 = this.v.d(j.AD, i);
                    } else {
                        i3 = i - i;
                        hVar2 = this.v.d(jVar, i3);
                    }
                } else {
                    if (this.v == j.BYZANTINE) {
                        if (this.v.d(j.AD, jVar.annoDomini(i)).a(this.v.d(jVar, i)) <= 0) {
                        }
                    }
                }
                i = 0;
            }
        } catch (RuntimeException unused) {
            jVar = -1;
            return jVar;
        }
        return (int)(f.DAYS.between(d(hVar), d(hVar2))) + (long)i;
    }

    public o w() {
        net.time4j.history.o oVar;
        if (this.v == null) {
            oVar = o.d;
        }
        return oVar;
    }

    public boolean x() {
        boolean z = true;
        int r0 = this.c != null ? 1 : 0;
        return (this.c != null ? 1 : 0);
    }

    public boolean y() {
        boolean z = true;
        if (l <= -9223372036854775808L) {
            int i3 = 0;
        }
        return z;
    }

    private d(b bVar, List<f> list, a aVar, o oVar, g gVar) {
        final Object bVar4 = this;
        Object bVar2 = bVar;
        Object gVar52 = gVar;
        super();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("At least one cutover event must be present in chronological history.");
        } else {
            Objects.requireNonNull(bVar2, "Missing historic variant.");
            Objects.requireNonNull(gVar52, "Missing era preference.");
            bVar4.a = bVar2;
            bVar4.b = list;
            bVar4.c = aVar;
            bVar4.v = oVar;
            bVar4.w = gVar52;
            final net.time4j.history.i iVar = new i(bVar4);
            bVar4.x = iVar;
            final net.time4j.history.k kVar = new k(bVar4);
            bVar4.y = kVar;
            int i6 = 1;
            int i7 = 999999999;
            final net.time4j.history.d bVar3 = this;
            super('y', i6, i7, bVar3, 2);
            bVar4.z = lVar;
            char c = '\0';
            super(c, i6, i7, bVar3, 6);
            bVar4.A = lVar2;
            super(c, i6, i7, bVar3, 7);
            bVar4.B = lVar3;
            super('M', i6, 12, bVar3, 3);
            bVar4.C = lVar4;
            super('d', i6, 31, bVar3, 4);
            bVar4.D = lVar5;
            super('D', i6, 365, bVar3, 5);
            bVar4.E = lVar6;
            super('\0', i6, 10000000, bVar3, 8);
            bVar4.F = lVar7;
            HashSet hashSet = new HashSet();
            hashSet.add(iVar);
            hashSet.add(kVar);
            hashSet.add(lVar);
            hashSet.add(lVar2);
            hashSet.add(lVar3);
            hashSet.add(lVar4);
            hashSet.add(lVar5);
            hashSet.add(lVar6);
            hashSet.add(lVar7);
            bVar4.G = Collections.unmodifiableSet(hashSet);
            return;
        }
    }
}
