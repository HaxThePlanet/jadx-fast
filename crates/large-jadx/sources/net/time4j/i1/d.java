package net.time4j.i1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.d;

/* compiled from: LeapSeconds.java */
/* loaded from: classes3.dex */
public final class d implements Iterable<b>, Comparator<b> {

    private static final d A = new d();
    public static final boolean x = false;
    public static final boolean y = false;
    private static final a[] z;
    private final c a;
    private final List<a> b = new CopyOnWriteArrayList<>();
    private final a[] c;
    private volatile a[] v;
    private final boolean w;

    private static class a implements a, Serializable {

        private static final long serialVersionUID = 5986185471610524587L;
        private final long _raw;
        private final long _utc;
        private final a date;
        private final int shift;
        a(a aVar, long j, long j2, int i) {
            super();
            this.date = aVar;
            this.shift = i;
            this._utc = j;
            this._raw = j2;
        }

        public long a() {
            return this._raw;
        }

        public int b() {
            return this.shift;
        }

        public long c() {
            return this._utc;
        }

        public a getDate() {
            return this.date;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            String name = b.class.getName();
            String str2 = d.l(this.date);
            String str3 = ": utc=";
            String str4 = ", raw=";
            String str5 = " (shift=";
            String str6 = ")]";
            str = 128 + name + 91 + str2 + str3 + this._utc + str4 + this._raw + str5 + this.shift + str6;
            return str;
        }

        a(a aVar, int i) {
            super();
            this.date = aVar.getDate();
            this.shift = aVar.b();
            this._utc = aVar.a() + (long)i;
            this._raw = aVar.a();
        }
    }
    static {
        d.x = Boolean.getBoolean("net.time4j.scale.leapseconds.suppressed");
        d.y = Boolean.getBoolean("net.time4j.scale.leapseconds.final");
        System.getProperty("net.time4j.scale.leapseconds.path", "data/leapseconds.data");
        d.z = new a[0];
    }

    private d() {
        boolean z2;
        int i = 0;
        int i2;
        boolean hasNext;
        int size;
        CopyOnWriteArrayList copyOnWriteArrayList;
        boolean hasNext2;
        a aVar;
        long l = -9223372036854775808L;
        int i3;
        int value;
        net.time4j.i1.d.a aVar2;
        super();
        net.time4j.i1.c cVar = null;
        boolean z3 = false;
        if (!d.x) {
            Iterator it = d.c().g(c.class).iterator();
            i2 = cVar;
            size = z3;
            while (it.hasNext()) {
                Object item = it.next();
                size = item.g().size();
            }
        } else {
            i2 = cVar;
            size = z3;
        }
        if (c.class == 0 || size == 0) {
            this.a = cVar;
            this.b = Collections.emptyList();
            net.time4j.i1.a[] objArr2 = d.z;
            this.c = objArr2;
            this.v = objArr2;
            this.w = z3;
        }
    }

    private static long E(a aVar) {
        return c.i(c.m(b.k(aVar), 40587L), 86400L);
    }

    static /* synthetic */ String b(a aVar) {
        return d.l(aVar);
    }

    private static void h(SortedSet<a> sortedSet) {
        int i = 0;
        final ArrayList arrayList = new ArrayList(sortedSet.size());
        Iterator it = sortedSet.iterator();
        i = 0;
        while (it.hasNext()) {
            Object item = it.next();
            long l2 = item.c();
            long l = Long.MIN_VALUE;
        }
        sortedSet.clear();
        sortedSet.addAll(arrayList);
    }

    private static String l(a aVar) {
        Object[] arr = new Object[3];
        return String.format("%1$04d-%2$02d-%3$02d", new Object[] { Integer.valueOf(aVar.m()), Integer.valueOf(aVar.o()), Integer.valueOf(aVar.q()) });
    }

    private a[] v() {
        return this.c;
    }

    public static d w() {
        return d.A;
    }

    private a[] z() {
        ArrayList arrayList = new ArrayList(this.b.size());
        arrayList.addAll(this.b);
        Collections.reverse(arrayList);
        return (a[])arrayList.toArray(new a[arrayList.size()]);
    }

    public boolean A() {
        return !this.b.isEmpty();
    }

    public boolean B(long j) {
        boolean z = false;
        int i;
        i = 0;
        if (j <= 0) {
            return false;
        }
        net.time4j.i1.a[] objArr = v();
        length = objArr.length;
        for (net.time4j.i1.a aVar : objArr) {
            long l = aVar.c();
            if (objArr.length < j) {
                break;
            }
        }
        return false;
    }

    public long C(long j) {
        int i = 0;
        int cmp;
        long l;
        long l2;
        final long l3 = 63072000L;
        if (j <= 0) {
            return j + 63072000L;
        }
        net.time4j.i1.a[] objArr = v();
        i = 0;
        length = objArr.length;
        for (net.time4j.i1.a aVar : objArr) {
            l = (long)aVar.b();
            long l8 = aVar.c() - l;
            if (this.w) {
            }
        }
        return l2 + 63072000L;
    }

    public boolean D() {
        return this.w;
    }

    public int d(b bVar, b bVar2) {
        int i = 0;
        a date = bVar.getDate();
        a date2 = bVar2.getDate();
        int i2 = date.m();
        int i4 = date2.m();
        i = -1;
        if (i2 < i4) {
            return i;
        }
        i = 1;
        if (i2 > i4) {
            return i;
        }
        int i3 = date.o();
        int i5 = date2.o();
        if (i3 < i5) {
            return i;
        }
        if (i3 > i5) {
            return i;
        }
        int i6 = date.q();
        int i7 = date2.q();
        if (i6 >= i7) {
            int r2 = i6 == i7 ? 0 : i;
        }
        return (i6 == i7 ? 0 : i);
    }

    public long g(long j) {
        int i = 0;
        long l2 = j - 63072000L;
        long l = 0L;
        if (j <= l) {
            return l2;
        }
        net.time4j.i1.a[] objArr = v();
        i = 0;
        while (i < objArr.length) {
            l = objArr[i];
            long l5 = l.a();
            if (l5 < l2) {
                return c.f(l2, l.c() - l.a());
            }
        }
        return l2;
    }

    @Override // java.lang.Iterable
    public Iterator<b> iterator() {
        return Collections.unmodifiableList(Arrays.asList(v())).iterator();
    }

    @Override // java.lang.Object
    public String toString() {
        int i = 1;
        char c;
        StringBuilder stringBuilder = new StringBuilder(2048);
        stringBuilder.append("[PROVIDER=");
        stringBuilder.append(this.a);
        if (this.a != null) {
            stringBuilder.append(",EXPIRES=");
            stringBuilder.append(d.l(u()));
        }
        stringBuilder.append(",EVENTS=[");
        if (A()) {
            i = 1;
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                stringBuilder.append(it.next());
            }
        } else {
            stringBuilder.append("NOT SUPPORTED");
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    public a u() {
        if (!A()) {
            throw new IllegalStateException("Leap seconds not activated.");
        } else {
            return this.a.f();
        }
    }

    public int y(long j) {
        int i;
        i = 0;
        if (j <= 0) {
            return i;
        }
        net.time4j.i1.a[] objArr = v();
        for (net.time4j.i1.a aVar : objArr) {
            long l3 = aVar.c();
            l2 = (long)aVar.b();
            l = aVar.c() - l2;
            if (j > l) {
                return (int)(j - l);
            }
        }
        return i;
    }
}
