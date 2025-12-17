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

/* loaded from: classes3.dex */
public final class d implements Iterable<net.time4j.i1.b>, Comparator<net.time4j.i1.b> {

    private static final net.time4j.i1.d A;
    public static final boolean x;
    public static final boolean y;
    private static final net.time4j.i1.a[] z;
    private final net.time4j.i1.c a;
    private final List<net.time4j.i1.a> b;
    private final net.time4j.i1.a[] c;
    private volatile net.time4j.i1.a[] v;
    private final boolean w;

    private static class a implements net.time4j.i1.a, Serializable {

        private static final long serialVersionUID = 5986185471610524587L;
        private final long _raw;
        private final long _utc;
        private final a date;
        private final int shift;
        a(a a, long l2, long l3, int i4) {
            super();
            this.date = a;
            this.shift = obj6;
            this._utc = l2;
            this._raw = i4;
        }

        a(net.time4j.i1.a a, int i2) {
            super();
            this.date = a.getDate();
            this.shift = a.b();
            this._utc = l += l2;
            this._raw = a.a();
        }

        @Override // net.time4j.i1.a
        public long a() {
            return this._raw;
        }

        @Override // net.time4j.i1.a
        public int b() {
            return this.shift;
        }

        @Override // net.time4j.i1.a
        public long c() {
            return this._utc;
        }

        @Override // net.time4j.i1.a
        public a getDate() {
            return this.date;
        }

        @Override // net.time4j.i1.a
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append(b.class.getName());
            stringBuilder.append('[');
            stringBuilder.append(d.b(this.date));
            stringBuilder.append(": utc=");
            stringBuilder.append(this._utc);
            stringBuilder.append(", raw=");
            stringBuilder.append(this._raw);
            stringBuilder.append(" (shift=");
            stringBuilder.append(this.shift);
            stringBuilder.append(")]");
            return stringBuilder.toString();
        }
    }
    static {
        d.x = Boolean.getBoolean("net.time4j.scale.leapseconds.suppressed");
        d.y = Boolean.getBoolean("net.time4j.scale.leapseconds.final");
        System.getProperty("net.time4j.scale.leapseconds.path", "data/leapseconds.data");
        d.z = new a[0];
        d dVar = new d();
        d.A = dVar;
    }

    private d() {
        Iterator iterator;
        int i3;
        Object unmodifiableList;
        boolean i;
        int i4;
        int next;
        int copyOnWriteArrayList;
        boolean next2;
        int size;
        Object obj;
        long l;
        int i2;
        int intValue;
        net.time4j.i1.d.a aVar;
        super();
        i = 0;
        i4 = 0;
        if (!d.x) {
            iterator = d.c().g(c.class).iterator();
            next = i;
            copyOnWriteArrayList = i4;
            while (iterator.hasNext()) {
                next2 = iterator.next();
                size = (c)next2.g().size();
                if (size > copyOnWriteArrayList) {
                }
                next = next2;
                copyOnWriteArrayList = size;
            }
        } else {
            next = i;
            copyOnWriteArrayList = i4;
        }
        if (next != 0) {
            if (copyOnWriteArrayList == null) {
                this.a = i;
                this.b = Collections.emptyList();
                i3 = d.z;
                this.c = i3;
                this.v = i3;
                this.w = i4;
            } else {
                unmodifiableList = new TreeSet(this);
                Iterator iterator2 = next.g().entrySet().iterator();
                for (Map.Entry next5 : iterator2) {
                    obj = key;
                    super(obj, Long.MIN_VALUE, obj9, next2 - i6, obj11, (Integer)next5.getValue().intValue());
                    unmodifiableList.add(aVar);
                }
                d.h(unmodifiableList);
                i = d.y;
                if (i) {
                    copyOnWriteArrayList = new ArrayList(unmodifiableList);
                    this.b = Collections.unmodifiableList(copyOnWriteArrayList);
                } else {
                    copyOnWriteArrayList = new CopyOnWriteArrayList(unmodifiableList);
                    this.b = copyOnWriteArrayList;
                }
                net.time4j.i1.a[] objArr = z();
                this.c = objArr;
                this.v = objArr;
                this.a = next;
                i3 = 1;
                if (i) {
                    if (next.a()) {
                        Iterator iterator3 = this.b.iterator();
                        while (iterator3.hasNext()) {
                            if ((a)iterator3.next().b() < 0) {
                                break;
                            } else {
                            }
                        }
                        i = i4;
                    }
                    this.w = i;
                } else {
                    this.w = i3;
                }
            }
        } else {
        }
    }

    private static long E(a a) {
        return c.i(c.m(b.k(a), obj1), obj1);
    }

    static String b(a a) {
        return d.l(a);
    }

    private static void h(SortedSet<net.time4j.i1.a> sortedSet) {
        int i;
        Object next;
        net.time4j.i1.d.a aVar;
        long l;
        ArrayList arrayList = new ArrayList(sortedSet.size());
        Iterator iterator = sortedSet.iterator();
        i = 0;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (Long.compare(l2, l) == 0) {
            } else {
            }
            arrayList.add(next);
            aVar = new d.a(next, i += i2);
            arrayList.add(aVar);
        }
        sortedSet.clear();
        sortedSet.addAll(arrayList);
    }

    private static String l(a a) {
        Object[] arr = new Object[3];
        return String.format("%1$04d-%2$02d-%3$02d", Integer.valueOf(a.m()), Integer.valueOf(a.o()), Integer.valueOf(a.q()));
    }

    private net.time4j.i1.a[] v() {
        boolean z;
        if (!d.x && d.y) {
            if (d.y) {
            }
            return this.v;
        }
        return this.c;
    }

    public static net.time4j.i1.d w() {
        return d.A;
    }

    private net.time4j.i1.a[] z() {
        ArrayList arrayList = new ArrayList(this.b.size());
        arrayList.addAll(this.b);
        Collections.reverse(arrayList);
        return (a[])arrayList.toArray(new a[arrayList.size()]);
    }

    @Override // java.lang.Iterable
    public boolean A() {
        return empty ^= 1;
    }

    @Override // java.lang.Iterable
    public boolean B(long l) {
        int i2;
        int i;
        int length;
        i2 = 0;
        if (Long.compare(l, i3) <= 0) {
            return i2;
        }
        net.time4j.i1.a[] objArr = v();
        i = i2;
        for (Object aVar : obj0) {
            length = Long.compare(l2, l);
        }
        return i2;
    }

    @Override // java.lang.Iterable
    public long C(long l) {
        boolean z;
        int i;
        net.time4j.i1.a aVar;
        int length;
        int cmp;
        long l2;
        int obj11;
        final int i3 = 63072000;
        if (Long.compare(l, i2) <= 0) {
            return l += i3;
        }
        net.time4j.i1.a[] objArr = v();
        i = 0;
        for (Object aVar : obj0) {
        }
        return obj11 += i3;
    }

    @Override // java.lang.Iterable
    public boolean D() {
        return this.w;
    }

    @Override // java.lang.Iterable
    public int compare(Object object, Object object2) {
        return d((b)object, (b)object2);
    }

    @Override // java.lang.Iterable
    public int d(net.time4j.i1.b b, net.time4j.i1.b b2) {
        int i;
        a obj5 = b.getDate();
        a obj6 = b2.getDate();
        int i2 = obj5.m();
        int i4 = obj6.m();
        i = -1;
        if (i2 < i4) {
            return i;
        }
        final int i6 = 1;
        if (i2 > i4) {
            return i6;
        }
        int i3 = obj5.o();
        int i5 = obj6.o();
        if (i3 < i5) {
            return i;
        }
        if (i3 > i5) {
            return i6;
        }
        obj5 = obj5.q();
        obj6 = obj6.q();
        if (obj5 < obj6) {
        } else {
            i = obj5 == obj6 ? 0 : i6;
        }
        return i;
    }

    @Override // java.lang.Iterable
    public long g(long l) {
        int i;
        int cmp;
        int obj7;
        int i3 = l - i2;
        if (Long.compare(l, i) <= 0) {
            return i3;
        }
        net.time4j.i1.a[] obj6 = v();
        obj7 = 0;
        for (Object i : l) {
        }
        return i3;
    }

    public Iterator<net.time4j.i1.b> iterator() {
        return Collections.unmodifiableList(Arrays.asList(v())).iterator();
    }

    @Override // java.lang.Iterable
    public String toString() {
        Object cVar;
        int str;
        Iterator iterator;
        boolean next;
        int i;
        StringBuilder stringBuilder = new StringBuilder(2048);
        stringBuilder.append("[PROVIDER=");
        stringBuilder.append(this.a);
        if (this.a != null) {
            stringBuilder.append(",EXPIRES=");
            stringBuilder.append(d.l(u()));
        }
        stringBuilder.append(",EVENTS=[");
        if (A()) {
            str = 1;
            iterator = this.b.iterator();
            while (iterator.hasNext()) {
                if (str != null) {
                } else {
                }
                stringBuilder.append('|');
                stringBuilder.append(iterator.next());
                str = 0;
            }
        } else {
            stringBuilder.append("NOT SUPPORTED");
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    @Override // java.lang.Iterable
    public a u() {
        if (!A()) {
        } else {
            return this.a.f();
        }
        IllegalStateException illegalStateException = new IllegalStateException("Leap seconds not activated.");
        throw illegalStateException;
    }

    @Override // java.lang.Iterable
    public int y(long l) {
        int i2;
        int cmp;
        int i;
        long l2;
        final int i4 = 0;
        if (Long.compare(l, i3) <= 0) {
            return i4;
        }
        net.time4j.i1.a[] objArr = v();
        i2 = i4;
        for (Object aVar : obj0) {
            l4 -= l2;
        }
        return i4;
    }
}
