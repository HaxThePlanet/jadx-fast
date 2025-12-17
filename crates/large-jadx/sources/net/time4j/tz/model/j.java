package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.b0;
import net.time4j.engine.f0;
import net.time4j.engine.z;
import net.time4j.f1.a;
import net.time4j.f1.b;
import net.time4j.f1.c;
import net.time4j.f1.f;
import net.time4j.f1.g;
import net.time4j.g0;
import net.time4j.i0;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* loaded from: classes3.dex */
final class j extends net.time4j.tz.model.l {

    private static final long serialVersionUID = 2456700806862862287L;
    private static final int x;
    private final transient q a;
    private final transient List<net.time4j.tz.model.d> b;
    private final transient ConcurrentMap<Integer, List<q>> c;
    private final transient List<q> v;
    private final transient boolean w;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            j.a.a = iArr;
            iArr[i.UTC_TIME.ordinal()] = 1;
            j.a.a[i.STANDARD_TIME.ordinal()] = 2;
            j.a.a[i.WALL_TIME.ordinal()] = 3;
        }
    }
    static {
        j.x = b.i(b.l(z.MODIFIED_JULIAN_DATE.transform(l.f(100), obj1)));
    }

    j(p p, List<net.time4j.tz.model.d> list2, boolean z3) {
        super(Long.MIN_VALUE, obj2, p.o(), p.o(), 0);
        super(qVar2, list2, z3);
    }

    j(q q, List<net.time4j.tz.model.d> list2, boolean z3) {
        int iterator;
        net.time4j.engine.i0 i0Var;
        boolean equals;
        Object obj;
        long l;
        int i3;
        int i2;
        int i;
        Object obj10;
        ArrayList obj11;
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.c = concurrentHashMap;
        if (list2.isEmpty()) {
        } else {
            if (list2.size() >= 128) {
            } else {
                if (z3 != null) {
                    obj11 = new ArrayList(list2);
                    obj10 = obj11;
                }
                Collections.sort(obj10, k.INSTANCE);
                obj11 = 0;
                int i5 = 1;
                if (obj10.size() > i5) {
                    iterator = obj10.iterator();
                    for (d equals : iterator) {
                        obj11 = equals.a();
                    }
                }
                this.w = "iso8601".equals(obj11);
                long l4 = Long.MIN_VALUE;
                if (Long.compare(l2, l4) == 0) {
                    if (q.f() != 0) {
                    } else {
                        super((b0)b0.V().I().x(), l4, q.m(), q.m(), 0);
                        this.a = obj;
                        List unmodifiableList = Collections.unmodifiableList(obj10);
                        this.b = unmodifiableList;
                        this.v = j.s(obj, unmodifiableList, 0, i3);
                    }
                    obj11 = new StringBuilder();
                    obj11.append("Initial transition must not have any dst-offset: ");
                    obj11.append(q);
                    obj10 = new IllegalArgumentException(obj11.toString());
                    throw obj10;
                }
                if (q.n() != j.m(q.i(), obj3, q).j()) {
                } else {
                    obj = q;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Inconsistent model: ");
                stringBuilder.append(q);
                stringBuilder.append(" / ");
                stringBuilder.append(obj10);
                obj11 = new IllegalArgumentException(stringBuilder.toString());
                throw obj11;
            }
            obj11 = new StringBuilder();
            obj11.append("Too many daylight saving rules: ");
            obj11.append(list2);
            IllegalArgumentException obj9 = new IllegalArgumentException(obj11.toString());
            throw obj9;
        }
        obj9 = new IllegalArgumentException("Missing daylight saving rules.");
        throw obj9;
    }

    private static q m(long l, q q2, List<net.time4j.tz.model.d> list3) {
        int i3;
        int qVar;
        int i6;
        int cmp;
        Object obj2;
        Object obj;
        int i2;
        int i7;
        long l2;
        int i5;
        int i;
        int i4;
        final Object obj3 = obj21;
        long l4 = Math.max(l, obj4);
        int i8 = list3.m();
        final int size = obj21.size();
        i3 = Integer.MIN_VALUE;
        qVar = 0;
        i6 = 0;
        while (qVar == 0) {
            int i9 = i6 % size;
            obj2 = obj3.get(i9);
            obj = obj3.get(i12 %= size);
            i2 = j.o((d)obj2, i8, (d)obj.e());
            if (i6 == 0) {
            } else {
            }
            if (i9 == 0) {
            }
            l2 = j.p(obj2, i3, i2);
            if (Long.compare(l2, l4) > 0) {
            }
            i6++;
            super(l2, obj14, i8 + i10, i8 + cmp, obj2.e());
            i3++;
            i3 = j.u(obj2, l5 += l4);
        }
        return qVar;
    }

    private static int o(net.time4j.tz.model.d d, int i2, int i3) {
        net.time4j.tz.model.i obj2 = d.d();
        int i = j.a.a[obj2.ordinal()];
        if (i != 1 && i != 2) {
            if (i != 2) {
                if (i != 3) {
                } else {
                    return i2 += i3;
                }
                UnsupportedOperationException obj3 = new UnsupportedOperationException(obj2.name());
                throw obj3;
            }
            return i2;
        }
        return 0;
    }

    private static long p(net.time4j.tz.model.d d, int i2, int i3) {
        return d.b(i2).r0(d.f()).S(p.u(i3)).x();
    }

    private List<q> q(int i) {
        int ifAbsent;
        Object unmodifiableList;
        int i2;
        int i5;
        int size;
        int i4;
        q qVar;
        int i7;
        q qVar2;
        long l;
        int i8;
        int i3;
        int i6;
        final Object obj = this;
        ifAbsent = i;
        final Integer valueOf = Integer.valueOf(i);
        if ((List)obj.c.get(valueOf) == null) {
            ArrayList arrayList = new ArrayList();
            int i9 = obj.a.m();
            i5 = 0;
            size = obj.b.size();
            while (i5 < size) {
                Object obj2 = obj.b.get(i5);
                Object obj3 = obj.b.get(i13 %= size);
                super(j.p(obj2, ifAbsent, j.o((d)obj2, i9, (d)obj3.e())), obj12, i9 + i10, i9 + i11, obj2.e());
                arrayList.add(qVar4);
                i5++;
            }
            ifAbsent = obj.c.putIfAbsent(valueOf, Collections.unmodifiableList(arrayList));
            if (ifAbsent <= j.x && obj.w && (List)ifAbsent != null) {
                if (obj.w) {
                    ifAbsent = obj.c.putIfAbsent(valueOf, unmodifiableList);
                    if ((List)(List)ifAbsent != null) {
                        unmodifiableList = ifAbsent;
                    }
                }
            }
        }
        return unmodifiableList;
    }

    private List<q> r(a a) {
        return q((d)this.b.get(0).i(a));
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    static List<q> s(q q, List<net.time4j.tz.model.d> list2, long l3, long l4) {
        int i6;
        int size;
        int qVar;
        int i5;
        int i4;
        Object obj;
        Object obj2;
        int i2;
        int i8;
        int i9;
        q qVar2;
        long l;
        int i7;
        int i;
        int i3;
        Object obj3 = list2;
        long l2 = l3;
        final long l5 = q.i();
        int cmp = Long.compare(l2, obj27);
        if (cmp > 0) {
        } else {
            if (Long.compare(obj27, l5) > 0) {
                if (cmp == 0) {
                } else {
                    ArrayList arrayList = new ArrayList();
                    i6 = Integer.MIN_VALUE;
                    size = list2.size();
                    i5 = 0;
                    final int i10 = q.m();
                    i4 = i5 % size;
                    obj = obj3.get(i4);
                    obj2 = obj3.get(i13 %= size);
                    i2 = j.o((d)obj, i10, (d)obj2.e());
                    while (i5 == 0) {
                        i9 = size;
                        i6 = j.u(obj, l7 += l6);
                        l = j.p(obj, i6, i2);
                        i5++;
                        if (Long.compare(l, obj27) < 0) {
                        }
                        if (Long.compare(l, l2) >= 0 && Long.compare(l, l5) > 0) {
                        }
                        size = i9;
                        i4 = i5 % size;
                        obj = obj3.get(i4);
                        obj2 = obj3.get(i13 %= size);
                        i2 = j.o((d)obj, i10, (d)obj2.e());
                        i9 = size;
                        if (i4 == 0) {
                        }
                        i6++;
                        if (Long.compare(l, l5) > 0) {
                        }
                        super(l, obj19, i10 + i11, i10 + i4, obj.e());
                        arrayList.add(qVar);
                    }
                }
                return Collections.unmodifiableList(arrayList);
            }
            return Collections.emptyList();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Start after end.");
        throw illegalArgumentException;
    }

    private static int u(net.time4j.tz.model.d d, long l2) {
        return d.h(z.MODIFIED_JULIAN_DATE.transform(c.b(l2, obj4), obj4));
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 125);
        return spx;
    }

    @Override // net.time4j.tz.model.l
    public q a(a a, g g2) {
        return k(a, l.j(a, g2));
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return p.u(this.a.n());
    }

    public List<p> c(a a, g g2) {
        return t(a, l.j(a, g2));
    }

    @Override // net.time4j.tz.model.l
    public q d(f f) {
        long cmp2;
        int i;
        int i4;
        int size;
        int i2;
        int i3;
        int cmp3;
        long cmp;
        Object obj14;
        cmp2 = this.a.i();
        if (Long.compare(l, cmp2) <= 0) {
            return null;
        }
        size = this.b.size();
        Object obj = this.b.get(0);
        final int i7 = size + -1;
        i = j.u(obj, l2 += cmp);
        List list3 = q(i);
        while (i2 < size) {
            i3 = list3.get(i2);
            cmp3 = (q)i3.i();
            if (Long.compare(l3, cmp3) < 0) {
                break;
            } else {
            }
            if (Long.compare(cmp3, cmp2) > 0) {
            }
            i2++;
            i4 = i3;
        }
        return i4;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        int i;
        Iterator iterator = this.b.iterator();
        for (d next2 : iterator) {
        }
        return 0;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof j) {
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.tz.model.l
    public int hashCode() {
        return i2 += i5;
    }

    @Override // net.time4j.tz.model.l
    q k(a a, long l2) {
        int next;
        long cmp;
        boolean z;
        final int i2 = 0;
        if (Long.compare(l2, i) <= 0) {
            return i2;
        }
        Iterator obj7 = r(a).iterator();
        for (q next : obj7) {
            cmp = next.i();
        }
        return i2;
    }

    @Override // net.time4j.tz.model.l
    q l() {
        return this.a;
    }

    List<net.time4j.tz.model.d> n() {
        return this.b;
    }

    List<p> t(a a, long l2) {
        int next;
        long cmp;
        int i;
        long l;
        boolean z;
        i = this.a.n();
        if (Long.compare(l2, i2) <= 0) {
            return l.h(i);
        }
        Iterator obj7 = r(a).iterator();
        for (q next : obj7) {
            cmp = next.i();
            l = next.n();
            i = l;
        }
        return l.h(i);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append(j.class.getName());
        stringBuilder.append("[initial=");
        stringBuilder.append(this.a);
        stringBuilder.append(",rules=");
        stringBuilder.append(this.b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
