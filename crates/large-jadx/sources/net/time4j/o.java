package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.time4j.engine.ChronoException;
import net.time4j.engine.a;
import net.time4j.engine.b;
import net.time4j.engine.h0;
import net.time4j.engine.j0.a;
import net.time4j.engine.v;
import net.time4j.f1.c;
import net.time4j.g1.w;

/* compiled from: Duration.java */
/* loaded from: classes3.dex */
public final class o<U extends x> extends a<U> implements Serializable {

    private static final char c = '\0';
    private static final long serialVersionUID = -6321211763598951499L;
    private static final o v = new o();
    private static final Comparator<j0.a<? extends v>> w;
    private final transient List<j0.a<U>> a;
    private final transient boolean b = false;

    public static final class a<U extends x> extends w<U, o<U>> {
        private a(Class<U> cls, String str) {
            super(cls, str);
        }

        public static <U extends x> o.a<U> k(Class<U> cls, String str) {
            return new o.a(cls, str);
        }

        @Override // net.time4j.g1.w
        protected U j(char c) {
            net.time4j.f mILLENNIA2;
            char c2 = 'I';
            if (c == 'I') {
                mILLENNIA2 = f.MILLENNIA;
            } else {
                c2 = 'M';
                if (c == 'M') {
                    mILLENNIA2 = f.MONTHS;
                } else {
                    c2 = 'Q';
                    if (c == 'Q') {
                        mILLENNIA2 = f.QUARTERS;
                    } else {
                        c2 = 'W';
                        if (c == 'W') {
                            mILLENNIA2 = f.WEEKS;
                        } else {
                            c2 = 'Y';
                            if (c == 'Y') {
                                mILLENNIA2 = f.YEARS;
                            } else {
                                c2 = 'f';
                                if (c == 'f') {
                                    net.time4j.h nANOS2 = h.NANOS;
                                } else {
                                    c2 = 'h';
                                    if (c == 'h') {
                                        net.time4j.h hOURS2 = h.HOURS;
                                    } else {
                                        c2 = 'm';
                                        if (c != 'm') {
                                            c2 = 's';
                                            if (c != 's') {
                                                switch (c) {
                                                    case 67:
                                                        mILLENNIA2 = f.CENTURIES;
                                                        break;
                                                    case 68:
                                                        mILLENNIA2 = f.DAYS;
                                                        break;
                                                    case 69:
                                                        mILLENNIA2 = f.DECADES;
                                                        break;
                                                    default:
                                                        final StringBuilder stringBuilder = new StringBuilder();
                                                        final String str2 = "Unsupported pattern symbol: ";
                                                        c = str2 + c;
                                                        throw new IllegalArgumentException(str2 + c);
                                                }
                                            }
                                            net.time4j.h sECONDS2 = h.SECONDS;
                                        } else {
                                            net.time4j.h mINUTES2 = h.MINUTES;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return mILLENNIA2;
        }
    }

    private static class b<U extends x> extends b<U, o<U>> {
        /* synthetic */ b(x[] xVarArr, n nVar) {
            this(xVarArr);
        }

        private b(U... uArr) {
            boolean z = true;
            if (uArr.length <= 1) {
                int i2 = 0;
            }
            super(z, uArr);
        }
    }
    static {
        int i = 46;
        int r0 = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
        o.c = (Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44);
        r0 = true;
        boolean z2 = false;
        o.e(r0, z2);
        o.e(r0, r0);
        o.e(z2, z2);
        o.e(z2, r0);
        o.f(r0);
        o.f(z2);
        o.w = o0.a();
        o0.f();
        o0.d();
        o0.e();
        int i2 = 3;
        net.time4j.f[] arr2 = new f[i2];
        arr2[z2] = f.YEARS;
        arr2[r0] = f.MONTHS;
        net.time4j.f dAYS2 = f.DAYS;
        final int i4 = 2;
        arr2[i4] = f.DAYS;
        o.g(arr2);
        net.time4j.h[] arr3 = new h[4];
        arr3[z2] = h.HOURS;
        arr3[r0] = h.MINUTES;
        arr3[i4] = h.SECONDS;
        arr3[i2] = h.NANOS;
        o.g(arr3);
        net.time4j.v[] arr = new v[i2];
        arr[z2] = f.weekBasedYears();
        arr[r0] = f.WEEKS;
        arr[i4] = f.DAYS;
        o.g(arr);
    }

    o(List<j0.a<U>> list, boolean z) {
        super();
        final boolean empty = list.isEmpty();
        if (empty) {
            this.a = Collections.emptyList();
        } else {
            Collections.sort(list, o.w);
            this.a = Collections.unmodifiableList(list);
        }
        list = !empty && z ? 1 : 0;
    }

    private int d() {
        return c().size();
    }

    private static o.a<f> e(boolean z, boolean z2) {
        String str;
        if (z) {
            z = z2 ? "YYYY-DDD" : "YYYY-MM-DD";
        } else {
            z = z2 ? "YYYYDDD" : "YYYYMMDD";
        }
        return (z2 ? "YYYY-DDD" : "YYYY-MM-DD");
    }

    private static o.a<h> f(boolean z) {
        String str;
        z = z ? "hh[:mm[:ss[,fffffffff]]]" : "hh[mm[ss[,fffffffff]]]";
        return (z ? "hh[:mm[:ss[,fffffffff]]]" : "hh[mm[ss[,fffffffff]]]");
    }

    public static <U extends x> h0<U, o<U>> g(U... uArr) {
        return new o.b(uArr, null);
    }

    private boolean h(x xVar) {
        char c = 49;
        boolean z = false;
        char symbol = xVar.getSymbol();
        c = '1';
        xVar = symbol >= '1' && symbol <= '9' ? 1 : 0;
        return (symbol >= '1' && symbol <= '9' ? 1 : 0);
    }

    public static <U extends x> o<U> i() {
        return o.v;
    }

    private String j(int i) throws ChronoException {
        int i2;
        char c = 83;
        int i3;
        String str;
        int cmp2;
        char symbol = 89;
        boolean z;
        int i4 = 0;
        char c2 = 46;
        int cmp;
        int i6;
        int i7 = 0;
        long l2 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        long l3;
        int i11 = 0;
        long l4;
        int i12 = 48;
        char c4 = 72;
        int i13 = 1000;
        int i14 = 0;
        long l5;
        int i5;
        Object obj;
        final int i15 = this;
        i2 = i;
        i4 = 1;
        if (i2 == i4) {
            if (a()) {
                throw new ChronoException("Negative sign not allowed in ISO-8601.");
            }
        }
        if (isEmpty()) {
            return "PT0S";
        }
        int r3 = i2 == 2 ? i4 : 0;
        final StringBuilder stringBuilder2 = new StringBuilder();
        if (this.a()) {
            stringBuilder2.append('-');
        }
        stringBuilder2.append('P');
        i6 = d();
        i7 = 0;
        i8 = 0;
        i9 = 0;
        i10 = 0;
        i11 = 0;
        i3 = 0;
        while (i8 < i6) {
            Object item = c().get(i8);
            str2 = item.b();
            l3 = item.a();
            symbol = str2.getSymbol();
            if (symbol > w0.a && symbol <= '9') {
            }
        }
        if (i9 != 0) {
            long l6 = 1000000000L;
            stringBuilder2.append(c.f(i11, i9 / l6));
            r3 = i4 != 0 ? 46 : o.c;
            stringBuilder2.append((i4 != 0 ? 46 : o.c));
            String str5 = String.valueOf(i9 % l6);
            cmp2 = str5.length() - 9;
            i4 = 0;
            while (i4 < str5.length() - 9) {
                stringBuilder2.append('0');
                i4 = i4 + 1;
            }
            stringBuilder2.append(str5);
            c = 'S';
            stringBuilder2.append(c);
        } else {
            c = 'S';
            if (i11 != 0) {
                stringBuilder2.append(i11);
                stringBuilder2.append('S');
            }
        }
        if (i3 != 0) {
            cmp = 1 ^ i10;
            if (cmp != 0) {
                i4 = 0;
                while (i4 < d()) {
                    Object obj2 = (j0.a)c().get(i4).b();
                    if (obj2 != w0.a && obj2 != f.WEEKS && obj2 != f.DAYS) {
                        break;
                    }
                }
            }
            if (cmp == 0) {
                int indexOf = stringBuilder2.indexOf("Y");
                cmp2 = indexOf + 1;
                stringBuilder2.replace(indexOf, cmp2, "{WEEK_BASED_YEARS}");
            }
        }
        return stringBuilder2.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 6);
    }

    @Override // net.time4j.engine.a
    public boolean a() {
        return this.b;
    }

    @Override // net.time4j.engine.a
    public boolean b(x xVar) {
        boolean z2 = false;
        int i;
        Object item;
        Object obj;
        boolean equals;
        i = 0;
        if (xVar == null) {
            return false;
        }
        while (i < this.a.size()) {
            item = this.a.get(i);
            obj = item.b();
            if (h(xVar)) {
            }
        }
        return z2;
    }

    @Override // net.time4j.engine.a
    public List<j0.a<U>> c() {
        return this.a;
    }

    @Override // net.time4j.engine.a
    public boolean equals(Object object) {
        boolean z = true;
        boolean z2;
        Object cast;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof o) {
            cast = o.class.cast(object);
            if (this.b == cast.b) {
                if (!(c().equals(cast.c()))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.engine.a
    public int hashCode() {
        int i;
        i = c().hashCode();
        if (this.b) {
            i = i ^ i;
        }
        return i;
    }

    @Override // net.time4j.engine.a
    public String toString() {
        return j(0);
    }

    private o() {
        super();
        this.a = Collections.emptyList();
    }
}
