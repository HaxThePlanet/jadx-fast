package net.time4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.f1.e;
import net.time4j.g1.i;
import net.time4j.g1.k;
import net.time4j.g1.n;
import net.time4j.g1.p;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
public final class k0 {

    private static final i g;
    private static final ConcurrentMap<Locale, net.time4j.k0> h;
    private static final net.time4j.x[] i;
    private static final net.time4j.x[] j;
    private final p a;
    private final Locale b;
    private final char c;
    private final String d;
    private final net.time4j.x e;
    private final boolean f;

    static class a {

        static final int[] a;
        static final int[] b;
        static {
            int[] iArr = new int[values.length];
            k0.a.b = iArr;
            int i2 = 1;
            iArr[h.HOURS.ordinal()] = i2;
            int i = 2;
            k0.a.b[h.MINUTES.ordinal()] = i;
            int i3 = 3;
            k0.a.b[h.SECONDS.ordinal()] = i3;
            int i6 = 4;
            k0.a.b[h.MILLIS.ordinal()] = i6;
            int i7 = 5;
            k0.a.b[h.MICROS.ordinal()] = i7;
            int i8 = 6;
            k0.a.b[h.NANOS.ordinal()] = i8;
            int[] iArr14 = new int[values2.length];
            k0.a.a = iArr14;
            iArr14[f.MILLENNIA.ordinal()] = i2;
            k0.a.a[f.CENTURIES.ordinal()] = i;
            k0.a.a[f.DECADES.ordinal()] = i3;
            k0.a.a[f.YEARS.ordinal()] = i6;
            k0.a.a[f.QUARTERS.ordinal()] = i7;
            k0.a.a[f.MONTHS.ordinal()] = i8;
            k0.a.a[f.WEEKS.ordinal()] = 7;
            k0.a.a[f.DAYS.ordinal()] = 8;
        }
    }
    static {
        int i;
        int i2;
        Object next;
        int length;
        i = 0;
        Iterator iterator = d.c().g(i.class).iterator();
        int i4 = 0;
        i2 = i4;
        while (iterator.hasNext()) {
            next = iterator.next();
            length = objArr.length;
            if (length >= i2) {
            }
            i = next;
            i2 = length;
        }
        if (i == 0) {
            i = i.a;
        }
        k0.g = i;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        k0.h = concurrentHashMap;
        net.time4j.x[] arr = new x[7];
        net.time4j.f yEARS = f.YEARS;
        arr[i4] = yEARS;
        net.time4j.f mONTHS = f.MONTHS;
        int i5 = 1;
        arr[i5] = mONTHS;
        final int i6 = 2;
        arr[i6] = f.WEEKS;
        net.time4j.f dAYS = f.DAYS;
        final int i7 = 3;
        arr[i7] = dAYS;
        final net.time4j.h hOURS = h.HOURS;
        final int i8 = 4;
        arr[i8] = hOURS;
        final net.time4j.h mINUTES = h.MINUTES;
        final int i9 = 5;
        arr[i9] = mINUTES;
        final net.time4j.h sECONDS = h.SECONDS;
        int i10 = 6;
        arr[i10] = sECONDS;
        k0.i = arr;
        net.time4j.x[] arr2 = new x[i10];
        arr2[i4] = yEARS;
        arr2[i5] = mONTHS;
        arr2[i6] = dAYS;
        arr2[i7] = hOURS;
        arr2[i8] = mINUTES;
        arr2[i9] = sECONDS;
        k0.j = arr2;
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, arr);
        hashSet.add(h.NANOS);
        Collections.unmodifiableSet(hashSet);
    }

    private k0(Locale locale, e<?> e2, char c3, String string4, net.time4j.x x5, boolean z6, boolean z7, String string8, String string9) {
        super();
        Objects.requireNonNull(x5, "Missing zero time unit.");
        Objects.requireNonNull(e2, "Missing reference clock.");
        this.a = p.g(locale, k.CARDINALS);
        this.b = locale;
        this.c = c3;
        this.e = x5;
        this.d = string4;
        this.f = z6;
    }

    private String a(long l) {
        int charAt;
        int i;
        int obj6;
        String valueOf = String.valueOf(Math.abs(l));
        final char c = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        if (Long.compare(l, charAt) < 0) {
            stringBuilder.append(this.d);
        }
        obj6 = 0;
        while (obj6 < valueOf.length()) {
            i = 48;
            if (c != i) {
            }
            stringBuilder.append(charAt);
            obj6++;
            charAt = (char)i3;
        }
        return stringBuilder.toString();
    }

    private String b(String string, long l2) {
        int i2;
        int charAt;
        int i;
        String obj5;
        int obj6;
        String obj7;
        int length = string.length();
        i2 = 0;
        while (i2 < length) {
            i2++;
        }
        if (Long.compare(l2, i3) < 0) {
            obj6 = new StringBuilder();
            obj6.append(this.d);
            obj6.append(string);
            obj5 = obj6.toString();
        }
        return obj5;
    }

    private n c(long l) {
        return this.a.e(Math.abs(l));
    }

    public static net.time4j.k0 d(Locale locale) {
        Object k0Var;
        net.time4j.k0 k0Var2;
        Object obj;
        net.time4j.p0 p0Var;
        char c;
        String str;
        net.time4j.h sECONDS;
        int i;
        int i3;
        int i2;
        int i4;
        Object obj12;
        final ConcurrentMap map = k0.h;
        i iVar = k0.g;
        super(locale, p0.e, iVar.f(locale), iVar.b(locale), h.SECONDS, 0, 0, 0, 0);
        obj12 = map.putIfAbsent(locale, k0Var);
        if ((k0)map.get(locale) == null && (k0)obj12 != null) {
            iVar = k0.g;
            super(locale, p0.e, iVar.f(locale), iVar.b(locale), h.SECONDS, 0, 0, 0, 0);
            obj12 = map.putIfAbsent(locale, k0Var);
            if ((k0)(k0)obj12 != null) {
                k0Var = obj12;
            }
        }
        return k0Var;
    }

    public String e(long l, net.time4j.f f2, v v3) {
        int i2;
        long obj4;
        net.time4j.f obj6;
        final int ordinal = v3.ordinal();
        switch (i2) {
            case 1:
                obj4 = c.i(l, f2);
                obj6 = f.YEARS;
                break;
            case 2:
                obj4 = c.i(l, f2);
                obj6 = f.YEARS;
                break;
            case 3:
                obj4 = c.i(l, f2);
                obj6 = f.YEARS;
                break;
            case 4:
                obj6 = f.YEARS;
                break;
            case 5:
                obj4 = c.i(l, f2);
                obj6 = f.MONTHS;
                break;
            case 6:
                obj6 = f.MONTHS;
                break;
            case 7:
                obj4 = c.i(l, f2);
                obj6 = f.DAYS;
                obj6 = f.WEEKS;
                break;
            case 8:
                obj6 = f.DAYS;
                break;
            default:
                obj4 = new UnsupportedOperationException(v3.name());
                throw obj4;
        }
        return b(s0.j(this.b).d(obj7, c(obj4), obj6), obj4);
    }

    public String f(long l, net.time4j.h h2, v v3) {
        return b(s0.j(this.b).d(obj6, c(l), v3), l);
    }
}
