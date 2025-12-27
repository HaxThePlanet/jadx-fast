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

/* compiled from: TransitionResolver.java */
/* loaded from: classes3.dex */
final class n implements o, Serializable {

    private static final Map<Integer, n> c = null;
    private static final long serialVersionUID = 1790434289322009750L;
    private final transient b a;
    private final transient g b;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[b.values().length];
            n.a.a = iArr;
            try {
                iArr[b.PUSH_FORWARD.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[b.NEXT_VALID_TIME.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                n.a.a[b.ABORT.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        int i;
        Map map;
        net.time4j.tz.n nVar;
        Integer num;
        n.c = new HashMap();
        net.time4j.tz.b[] values2 = b.values();
        i = 0;
        for (net.time4j.tz.b bVar : values2) {
            net.time4j.tz.g[] values = g.values();
            length = values.length;
            for (net.time4j.tz.g gVar : values) {
                n.c.put(Integer.valueOf((bVar.ordinal() * 2) + gVar.ordinal()), new n(bVar, gVar));
            }
            net.time4j.tz.g gVar = values[i];
            n.c.put(Integer.valueOf((bVar.ordinal() * 2) + gVar.ordinal()), new n(bVar, gVar));
            i = i + 1;
        }
    }

    private n(b bVar, g gVar) {
        super();
        this.a = bVar;
        this.b = gVar;
    }

    static n d(b bVar, g gVar) {
        return (n)n.c.get(Integer.valueOf((bVar.ordinal() * 2) + gVar.ordinal()));
    }

    private static void e(a aVar, g gVar, l lVar) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Invalid local timestamp due to timezone transition: local-date=";
        String str2 = ", local-time=";
        String str3 = " [";
        String str4 = lVar.z().a();
        String str5 = "]";
        aVar = str + aVar + str2 + gVar + str3 + str4 + str5;
        throw new IllegalArgumentException(aVar);
    }

    private static long f(int i, int i2, int i3, int i4, int i5, int i6) {
        return (c.i(c.m(b.j(i, i2, i3), 40587L), 86400L)) + (long)(i4 * 3600) + (i5 * 60) + i6;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 13);
    }

    public o a(g gVar) {
        if (gVar == this.b) {
            return this;
        }
        return this.a.and(gVar);
    }

    public long b(a aVar, g gVar, l lVar) {
        long l;
        int i;
        int i4;
        long l2;
        net.time4j.tz.g lATER_OFFSET2;
        final Object aVar3 = this;
        a aVar2 = aVar;
        g gVar22 = gVar;
        int ordinal = aVar.m();
        final int i2 = aVar.o();
        final int i5 = aVar.q();
        final int i6 = gVar.s();
        final int i7 = gVar.i();
        final int i8 = gVar.u();
        net.time4j.tz.m mVar = lVar.y();
        final int i26 = 0;
        ordinal = 0;
        if (mVar == null) {
            if (aVar3.b == g.LATER_OFFSET) {
                if (aVar3.a == b.PUSH_FORWARD || aVar3.a == b.ABORT) {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(lVar.z().a()));
                    gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE, r5));
                    gregorianCalendar.set(14, ordinal);
                    gregorianCalendar.set(ordinal, i2 - 1, i5, i6, i7, i8);
                    int i12 = 1;
                    i2 = gregorianCalendar.get(i12);
                    i5 = gregorianCalendar.get(2) + i12;
                    int i23 = gregorianCalendar.get(5);
                    i7 = gregorianCalendar.get(11);
                    i8 = gregorianCalendar.get(12);
                    int i25 = gregorianCalendar.get(13);
                    if (aVar3.a == b.ABORT) {
                        if (ordinal != i2) {
                            n.e(aVar, gVar, lVar);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i26;
                        }
                    }
                    l2 = n.f(i2, i5, i23, i7, i8, i25);
                    i = lVar.A(aVar, gVar22).o();
                }
                return l2 - (long)i;
            }
        }
        throw new UnsupportedOperationException("Timezone provider does not expose its transition history.");
    }

    int c() {
        return (this.a.ordinal() * 2) + this.b.ordinal();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = n.class.getName();
        String str2 = ":[gap=";
        String str3 = ",overlap=";
        str = 32 + name + str2 + this.a + str3 + this.b + 93;
        return str;
    }
}
