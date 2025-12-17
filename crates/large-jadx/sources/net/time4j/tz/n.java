package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
final class n implements net.time4j.tz.o, Serializable {

    private static final Map<Integer, net.time4j.tz.n> c = null;
    private static final long serialVersionUID = 1790434289322009750L;
    private final transient net.time4j.tz.b a;
    private final transient net.time4j.tz.g b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            n.a.a = iArr;
            iArr[b.PUSH_FORWARD.ordinal()] = 1;
            n.a.a[b.NEXT_VALID_TIME.ordinal()] = 2;
            n.a.a[b.ABORT.ordinal()] = 3;
        }
    }
    static {
        int i2;
        net.time4j.tz.b bVar;
        net.time4j.tz.g[] values;
        int length;
        int i;
        Map map;
        net.time4j.tz.n nVar;
        Integer valueOf;
        HashMap hashMap = new HashMap();
        n.c = hashMap;
        net.time4j.tz.b[] values2 = b.values();
        final int i3 = 0;
        i2 = i3;
        while (i2 < values2.length) {
            bVar = values2[i2];
            values = g.values();
            i = i3;
            while (i < values.length) {
                net.time4j.tz.g gVar = values[i];
                nVar = new n(bVar, gVar);
                n.c.put(Integer.valueOf(i4 += ordinal), nVar);
                i++;
            }
            i2++;
            gVar = values[i];
            nVar = new n(bVar, gVar);
            n.c.put(Integer.valueOf(i4 += ordinal), nVar);
            i++;
        }
    }

    private n(net.time4j.tz.b b, net.time4j.tz.g g2) {
        super();
        this.a = b;
        this.b = g2;
    }

    static net.time4j.tz.n d(net.time4j.tz.b b, net.time4j.tz.g g2) {
        return (n)n.c.get(Integer.valueOf(obj0 += obj1));
    }

    private static void e(a a, g g2, net.time4j.tz.l l3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid local timestamp due to timezone transition: local-date=");
        stringBuilder.append(a);
        stringBuilder.append(", local-time=");
        stringBuilder.append(g2);
        stringBuilder.append(" [");
        stringBuilder.append(l3.z().a());
        stringBuilder.append("]");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    private static long f(int i, int i2, int i3, int i4, int i5, int i6) {
        return obj2 += obj4;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 13);
        return spx;
    }

    @Override // net.time4j.tz.o
    public net.time4j.tz.o a(net.time4j.tz.g g) {
        if (g == this.b) {
            return this;
        }
        return this.a.and(g);
    }

    @Override // net.time4j.tz.o
    public long b(a a, g g2, net.time4j.tz.l l3) {
        int i4;
        int i7;
        int i13;
        Enum obj;
        int i;
        int i2;
        long l;
        Enum lATER_OFFSET;
        int i11;
        int i5;
        int eARLIER_OFFSET;
        int i9;
        int i8;
        net.time4j.tz.l i6;
        int ordinal;
        int i3;
        int i10;
        net.time4j.tz.m mVar;
        int i12;
        final Object obj2 = this;
        a aVar = a;
        g gVar = g2;
        i12 = a.m();
        final int i46 = a.o();
        final int i47 = a.q();
        final int i48 = g2.s();
        final int i49 = g2.i();
        final int i50 = g2.u();
        mVar = l3.y();
        final int i51 = 0;
        ordinal = 0;
        int i38 = 1;
        if (mVar == null && obj2.b == g.LATER_OFFSET) {
            if (obj2.b == g.LATER_OFFSET) {
                obj = obj2.a;
                if (obj != b.PUSH_FORWARD) {
                    if (obj == b.ABORT) {
                        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(l3.z().a()));
                        Date date = new Date(Long.MIN_VALUE, obj5);
                        gregorianCalendar.setGregorianChange(date);
                        gregorianCalendar.set(14, ordinal);
                        int i17 = i41;
                        GregorianCalendar calendar = gregorianCalendar;
                        gregorianCalendar.set(i12, i46 + -1, i47, i48, i49, i50);
                        int i25 = 1;
                        i5 = calendar.get(i25);
                        i37 += i25;
                        int i40 = calendar.get(5);
                        i3 = calendar.get(11);
                        i10 = calendar.get(12);
                        mVar = calendar.get(13);
                        if (obj2.a == b.ABORT) {
                            if (i12 != i5) {
                            } else {
                                if (i46 != i9) {
                                } else {
                                    if (i47 != i40) {
                                    } else {
                                        if (i48 != i3) {
                                        } else {
                                            if (i49 != i10) {
                                            } else {
                                                if (i50 != mVar) {
                                                } else {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            n.e(a, g2, l3);
                            throw i51;
                        }
                        l = n.f(i5, i9, i40, i3, i10, mVar);
                        i7 = l3.A(a, gVar).o();
                    } else {
                    }
                } else {
                }
                return l -= l5;
            } else {
            }
        } else {
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Timezone provider does not expose its transition history.");
        throw unsupportedOperationException;
    }

    @Override // net.time4j.tz.o
    int c() {
        return i += ordinal2;
    }

    @Override // net.time4j.tz.o
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(n.class.getName());
        stringBuilder.append(":[gap=");
        stringBuilder.append(this.a);
        stringBuilder.append(",overlap=");
        stringBuilder.append(this.b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
