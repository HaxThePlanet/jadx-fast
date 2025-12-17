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

/* loaded from: classes3.dex */
public final class o<U extends net.time4j.x>  extends a<U> implements Serializable {

    private static final char c = '\0';
    private static final long serialVersionUID = -6321211763598951499L;
    private static final net.time4j.o v;
    private static final Comparator<j0.a<? extends v>> w;
    private final transient List<j0.a<U>> a;
    private final transient boolean b = false;

    public static final class a extends w<U, net.time4j.o<U>> {
        private a(Class<U> class, String string2) {
            super(class, string2);
        }

        public static <U extends net.time4j.x> net.time4j.o.a<U> k(Class<U> class, String string2) {
            o.a aVar = new o.a(class, string2);
            return aVar;
        }

        @Override // net.time4j.g1.w
        protected Object f(char c) {
            return j(c);
        }

        protected U j(char c) {
            int i;
            Enum obj4;
            if (c != 73) {
                if (c != 77) {
                    if (c != 81) {
                        if (c != 87) {
                            if (c != 89) {
                                if (c != 102) {
                                    if (c != 104) {
                                        if (c != 109) {
                                            if (c != 115) {
                                                switch (c) {
                                                    case 67:
                                                        obj4 = f.CENTURIES;
                                                        break;
                                                    case 68:
                                                        obj4 = f.DAYS;
                                                        break;
                                                    case 69:
                                                        obj4 = f.DECADES;
                                                        break;
                                                    default:
                                                        StringBuilder stringBuilder = new StringBuilder();
                                                        stringBuilder.append("Unsupported pattern symbol: ");
                                                        stringBuilder.append(c);
                                                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                                                        throw illegalArgumentException;
                                                }
                                            }
                                            obj4 = h.SECONDS;
                                        } else {
                                            obj4 = h.MINUTES;
                                        }
                                    } else {
                                        obj4 = h.HOURS;
                                    }
                                } else {
                                    obj4 = h.NANOS;
                                }
                            } else {
                                obj4 = f.YEARS;
                            }
                        } else {
                            obj4 = f.WEEKS;
                        }
                    } else {
                        obj4 = f.QUARTERS;
                    }
                } else {
                    obj4 = f.MONTHS;
                }
            } else {
                obj4 = f.MILLENNIA;
            }
            return obj4;
        }
    }

    private static class b extends b<U, net.time4j.o<U>> {
        private b(U... uArr) {
            int i;
            if (uArr.length > 1) {
            } else {
                i = 0;
            }
            super(i, uArr);
        }

        b(net.time4j.x[] xArr, net.time4j.n n2) {
            super(xArr);
        }
    }
    static {
        int i;
        Class<net.time4j.o> obj = o.class;
        i = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? 46 : 44;
        o.c = i;
        o oVar = new o();
        o.v = oVar;
        int i2 = 1;
        int i3 = 0;
        o.e(i2, i3);
        o.e(i2, i2);
        o.e(i3, i3);
        o.e(i3, i2);
        o.f(i2);
        o.f(i3);
        o.w = o0.a();
        o0.f();
        o0.d();
        o0.e();
        int i4 = 3;
        net.time4j.f[] arr2 = new f[i4];
        arr2[i3] = f.YEARS;
        arr2[i2] = f.MONTHS;
        net.time4j.f dAYS = f.DAYS;
        final int i6 = 2;
        arr2[i6] = dAYS;
        o.g(arr2);
        net.time4j.h[] arr3 = new h[4];
        arr3[i3] = h.HOURS;
        arr3[i2] = h.MINUTES;
        arr3[i6] = h.SECONDS;
        arr3[i4] = h.NANOS;
        o.g(arr3);
        net.time4j.v[] arr = new v[i4];
        arr[i3] = f.weekBasedYears();
        arr[i2] = f.WEEKS;
        arr[i6] = dAYS;
        o.g(arr);
    }

    private o() {
        super();
        this.a = Collections.emptyList();
        int i = 0;
    }

    o(List<j0.a<U>> list, boolean z2) {
        Comparator comparator;
        List obj3;
        super();
        final boolean empty = list.isEmpty();
        if (empty) {
            this.a = Collections.emptyList();
        } else {
            Collections.sort(list, o.w);
            this.a = Collections.unmodifiableList(list);
        }
        if (!empty && z2) {
            obj3 = z2 ? 1 : obj3;
        }
        obj3 = 0;
    }

    private int d() {
        return c().size();
    }

    private static net.time4j.o.a<net.time4j.f> e(boolean z, boolean z2) {
        String obj0;
        if (z) {
            obj0 = z2 ? "YYYY-DDD" : "YYYY-MM-DD";
        } else {
            obj0 = z2 ? "YYYYDDD" : "YYYYMMDD";
        }
        return o.a.k(f.class, obj0);
    }

    private static net.time4j.o.a<net.time4j.h> f(boolean z) {
        String obj1;
        obj1 = z ? "hh[:mm[:ss[,fffffffff]]]" : "hh[mm[ss[,fffffffff]]]";
        return o.a.k(h.class, obj1);
    }

    public static <U extends net.time4j.x> h0<U, net.time4j.o<U>> g(U... uArr) {
        o.b bVar = new o.b(uArr, 0);
        return bVar;
    }

    private boolean h(net.time4j.x x) {
        int i;
        int obj2;
        obj2 = x.getSymbol();
        if (obj2 >= 49 && obj2 <= 57) {
            obj2 = obj2 <= 57 ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public static <U extends net.time4j.x> net.time4j.o<U> i() {
        return o.v;
    }

    private String j(int i) {
        int cmp2;
        int indexOf;
        int i2;
        long l;
        String str2;
        int i8;
        int cmp4;
        char symbol;
        boolean z;
        int str;
        char c;
        Object obj;
        int cmp3;
        boolean z2;
        int wEEKS;
        int i9;
        int i7;
        int i4;
        int i5;
        long l2;
        int i6;
        int i12;
        long l3;
        int i15;
        int i14;
        int i13;
        int i10;
        int i3;
        Object calendrical;
        int i11;
        final int obj2 = this;
        cmp2 = i;
        i8 = 1;
        if (cmp2 == i8) {
            if (a()) {
            } else {
            }
            ChronoException chronoException = new ChronoException("Negative sign not allowed in ISO-8601.");
            throw chronoException;
        }
        if (isEmpty()) {
            return "PT0S";
        }
        str = cmp2 == 2 ? i8 : 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        if (a()) {
            stringBuilder2.append('-');
        }
        stringBuilder2.append('P');
        wEEKS = d();
        i9 = 0;
        i7 = 0;
        i4 = 0;
        i5 = 0;
        i6 = 0;
        i14 = 0;
        while (i7 < wEEKS) {
            Object obj3 = c().get(i7);
            obj = calendrical;
            if (i5 == 0 && !(x)obj.isCalendrical()) {
            } else {
            }
            i11 = i6;
            i15 = i5;
            l2 = obj3.a();
            symbol = obj.getSymbol();
            if (obj == w0.a) {
            } else {
            }
            l3 = 48;
            i10 = 68;
            i2 = i14;
            stringBuilder2.append(l2);
            if (symbol == 0) {
            } else {
            }
            stringBuilder2.append(symbol);
            i6 = i11;
            i7++;
            i14 = i2;
            i5 = i3;
            i8 = 1;
            cmp2 = i;
            stringBuilder2.append('{');
            stringBuilder2.append(obj);
            stringBuilder2.append('}');
            i2 = i14;
            stringBuilder2.append(c.i(l2, i6));
            symbol = 89;
            i2 = i14;
            stringBuilder2.append(c.i(l2, i6));
            symbol = 77;
            i2 = i14;
            if (wEEKS == 1) {
            } else {
            }
            if (obj2.b(f.DAYS)) {
            } else {
            }
            stringBuilder2.append(c.i(l2, i6));
            symbol = i10;
            i9 = 0;
            if (str != null) {
            } else {
            }
            stringBuilder2.append(l2);
            stringBuilder2.append(c.i(l2, i6));
            symbol = i10;
            l3 = 0;
            stringBuilder2.append(c.i(l2, i6));
            i2 = i14;
            l3 = 0;
            if (Long.compare(i9, i13) != 0) {
            }
            stringBuilder2.append(l2);
            i2 = i14;
            l2 = c.f(l2, i6);
            i9 = 0;
            l3 = 0;
            stringBuilder2.append(c.i(l2, i6));
            stringBuilder2.append(l2);
            i6 = l2;
            i2 = i14;
            i4 = l2;
            i2 = i14;
            l3 = 48;
            i14 = 1;
            if (!obj.isCalendrical()) {
            } else {
            }
            stringBuilder2.append('T');
            i11 = i6;
            i15 = 1;
        }
        int i30 = i6;
        if (Long.compare(i4, i16) != 0) {
            int i18 = 1000000000;
            stringBuilder2.append(c.f(i30, l3));
            c = str != null ? 46 : o.c;
            stringBuilder2.append(c);
            String valueOf = String.valueOf(i4 %= i18);
            str = 0;
            while (str < length - 9) {
                stringBuilder2.append('0');
                str++;
            }
            stringBuilder2.append(valueOf);
            stringBuilder2.append('S');
        } else {
            i12 = i30;
            if (Long.compare(i12, i22) != 0) {
                stringBuilder2.append(i12);
                stringBuilder2.append('S');
            }
        }
        if (i14 != 0) {
            i17 ^= i5;
            if (indexOf != 0) {
                str = 0;
                while (str < d()) {
                    cmp3 = (j0.a)c().get(str).b();
                    str++;
                }
                cmp3 = indexOf;
            } else {
            }
            if (cmp3 == 0) {
                indexOf = stringBuilder2.indexOf("Y");
                stringBuilder2.replace(indexOf, indexOf + 1, "{WEEK_BASED_YEARS}");
            }
        }
        return stringBuilder2.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 6);
        return spx;
    }

    @Override // net.time4j.engine.a
    public boolean a() {
        return this.b;
    }

    @Override // net.time4j.engine.a
    public boolean b(net.time4j.x x) {
        int i;
        boolean z;
        int i2;
        Object obj;
        Object obj2;
        boolean equals;
        net.time4j.x obj8;
        i = 0;
        if (x == null) {
            return i;
        }
        i2 = i;
        while (i2 < this.a.size()) {
            obj = this.a.get(i2);
            obj2 = (j0.a)obj.b();
            i2++;
        }
        return i;
    }

    public List<j0.a<U>> c() {
        return this.a;
    }

    @Override // net.time4j.engine.a
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof o) {
            obj5 = o.class.cast(object);
            if (this.b == obj5.b && c().equals((o)obj5.c())) {
                if (c().equals(obj5.c())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.a
    public int hashCode() {
        int i;
        i = c().hashCode();
        if (this.b) {
            i ^= i;
        }
        return i;
    }

    @Override // net.time4j.engine.a
    public String toString() {
        return j(0);
    }
}
