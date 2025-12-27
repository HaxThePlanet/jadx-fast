package net.time4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.c;
import net.time4j.f1.d;
import net.time4j.f1.e;
import net.time4j.g1.i;
import net.time4j.g1.k;
import net.time4j.g1.n;
import net.time4j.g1.p;
import net.time4j.g1.v;

/* compiled from: PrettyTime.java */
/* loaded from: classes3.dex */
public final class k0 {

    private static final i g;
    private static final ConcurrentMap<Locale, k0> h = new ConcurrentHashMap<>();
    private static final x[] i;
    private static final x[] j;
    private final p a;
    private final Locale b;
    private final char c;
    private final String d;
    private final x e;
    private final boolean f;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static {
            int[] iArr = new int[h.values().length];
            k0.a.b = iArr;
            int i2 = 1;
            try {
                iArr[h.HOURS.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int i3 = 3;
                int i6 = 4;
                int i7 = 5;
                int i8 = 6;
                int[] iArr14 = new int[f.values().length];
                k0.a.a = iArr14;
                return;
            }
            int i = 2;
            try {
                k0.a.b[h.MINUTES.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                iArr14 = new int[f.values().length];
                k0.a.a = iArr14;
                return;
            }
        }
    }
    static {
        int i = 0;
        int length;
        i = 0;
        Iterator it = d.c().g(i.class).iterator();
        length = 0;
        while (it.hasNext()) {
            Object item = it.next();
            length = item.c().length;
        }
        if (i == 0) {
            i iVar = i.a;
        }
        k0.g = i;
        net.time4j.x[] arr = new x[7];
        net.time4j.f yEARS2 = f.YEARS;
        arr[length] = yEARS2;
        net.time4j.f mONTHS2 = f.MONTHS;
        int i3 = 1;
        arr[i3] = mONTHS2;
        final int i4 = 2;
        arr[i4] = f.WEEKS;
        net.time4j.f dAYS2 = f.DAYS;
        final int i5 = 3;
        arr[i5] = dAYS2;
        final net.time4j.h hOURS2 = h.HOURS;
        final int i6 = 4;
        arr[i6] = hOURS2;
        final net.time4j.h mINUTES2 = h.MINUTES;
        final int i7 = 5;
        arr[i7] = mINUTES2;
        final net.time4j.h sECONDS2 = h.SECONDS;
        int i8 = 6;
        arr[i8] = sECONDS2;
        k0.i = arr;
        net.time4j.x[] arr2 = new x[i8];
        arr2[length] = yEARS2;
        arr2[i3] = mONTHS2;
        arr2[i4] = dAYS2;
        arr2[i5] = hOURS2;
        arr2[i6] = mINUTES2;
        arr2[i7] = sECONDS2;
        k0.j = arr2;
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, arr);
        hashSet.add(h.NANOS);
        Collections.unmodifiableSet(hashSet);
    }

    private k0(Locale locale, e<?> eVar, char c, String str, x xVar, boolean z, boolean z2, String str2, String str3) {
        super();
        Objects.requireNonNull(xVar, "Missing zero time unit.");
        Objects.requireNonNull(eVar, "Missing reference clock.");
        this.a = p.g(locale, k.CARDINALS);
        this.b = locale;
        this.c = c;
        this.e = xVar;
        this.d = str;
        this.f = z;
    }

    private String a(long j) {
        char charAt;
        int i = 0;
        String str = String.valueOf(Math.abs(j));
        final StringBuilder stringBuilder = new StringBuilder();
        long l = 0L;
        if (j < l) {
            stringBuilder.append(this.d);
        }
        i = 0;
        while (this.d < str.length()) {
            char c = '0';
            stringBuilder.append(charAt);
            i = i + 1;
        }
        return stringBuilder.toString();
    }

    private String b(String str, long j) {
        int i = 0;
        int i2;
        char c;
        String str2;
        int length = str.length();
        i = 0;
        while (i < length) {
            i2 = length - 2;
            if (i < length - 2) {
                c = '{';
            }
        }
        if (j < 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str2 = this.d + str;
        }
        return str2;
    }

    private n c(long j) {
        return this.a.e(Math.abs(j));
    }

    public static k0 d(Locale locale) {
        Object locale2;
        final ConcurrentMap concurrentMap = k0.h;
        if ((k0)concurrentMap.get(locale) == null) {
            i iVar = k0.g;
            boolean z = false;
            boolean z2 = false;
            String str2 = null;
            String str3 = null;
            k0 k0Var = new k0(locale, p0.e, iVar.f(locale), iVar.b(locale), h.SECONDS, z, z2, str2, str3);
            locale2 = k0.h.putIfAbsent(locale, k0Var);
            if (locale2 != null) {
            }
        }
        return locale2;
    }

    public String e(long j, f fVar, v vVar) {
        long l2;
        net.time4j.f mONTHS2;
        final int ordinal = fVar.ordinal();
        switch (k0.a.a[ordinal]) {
            case 1:
                long l = 1000L;
                l2 = c.i(j, 1000L);
                mONTHS2 = f.YEARS;
                break;
            case 2:
                l = 100L;
                l2 = c.i(j, 100L);
                mONTHS2 = f.YEARS;
                break;
            case 3:
                l = 10L;
                l2 = c.i(j, 10L);
                mONTHS2 = f.YEARS;
                break;
            case 4:
                mONTHS2 = f.YEARS;
                break;
            case 5:
                l = 3L;
                l2 = c.i(j, 3L);
                mONTHS2 = f.MONTHS;
                break;
            case 6:
                mONTHS2 = f.MONTHS;
                break;
            case 7:
                l = 7L;
                l2 = c.i(j, 7L);
                mONTHS2 = f.DAYS;
                mONTHS2 = f.WEEKS;
                break;
            case 8:
                mONTHS2 = f.DAYS;
                break;
            default:
                throw new UnsupportedOperationException(f.WEEKS.name());
        }
        return b(s0.j(this.b).d(vVar, c(l2), mONTHS2), l2);
    }

    public String f(long j, h hVar, v vVar) {
        return b(s0.j(this.b).d(vVar, c(j), hVar), j);
    }
}
