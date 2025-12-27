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

/* compiled from: RuleBasedTransitionModel.java */
/* loaded from: classes3.dex */
final class j extends l {

    private static final long serialVersionUID = 2456700806862862287L;
    private static final int x = 0;
    private final transient q a;
    private final transient List<d> b;
    private final transient ConcurrentMap<Integer, List<q>> c;
    private final transient List<q> v;
    private final transient boolean w;

    static class a {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[i.values().length];
            j.a.a = iArr;
            try {
                iArr[i.UTC_TIME.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[i.STANDARD_TIME.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                j.a.a[i.WALL_TIME.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }
    static {
        j.x = b.i(b.l(z.MODIFIED_JULIAN_DATE.transform(l.f(100), z.UNIX)));
    }

    j(p pVar, List<d> list, boolean z) {
        super(Long.MIN_VALUE, i, pVar.o(), pVar.o(), 0);
        this(qVar, list, z);
    }

    private static q m(long j, q qVar, List<d> list) {
        int i = -2147483648;
        int i2 = 0;
        int i3 = 0;
        int cmp;
        long l;
        long l2;
        int i5;
        int i6;
        int i7;
        final Object obj = list;
        long max = Math.max(j, qVar.i());
        int i8 = qVar.m();
        final int size = list.size();
        i = Integer.MIN_VALUE;
        i2 = 0;
        i3 = 0;
        while (i2 == 0) {
            int i9 = i3 % size;
            Object item = obj.get(i9);
            Object item2 = obj.get((i3 - 1) + size % size);
            int i4 = j.o(item, i8, item2.e());
            l2 = j.p(item, i, i4);
            i3 = i3 + 1;
        }
        return i2;
    }

    private static int o(d dVar, int i, int i2) {
        net.time4j.tz.model.i iVar = dVar.d();
        i = j.a.a[iVar.ordinal()];
        if (j.a.a != 1 && j.a.a != 2) {
            if (j.a.a != 3) {
                throw new UnsupportedOperationException(iVar.name());
            } else {
                return i + i2;
            }
        }
        return 0;
    }

    private static long p(d dVar, int i, int i2) {
        return dVar.b(i).r0(dVar.f()).S(p.u(i2)).x();
    }

    private List<q> q(int i) {
        Object ifAbsent;
        int i4 = 0;
        int i5;
        Object obj;
        int i6;
        q qVar;
        long l;
        int i7;
        int i8;
        final Object i9 = this;
        i2 = i;
        final Integer num = Integer.valueOf(i);
        if ((List)i9.c.get(num) == null) {
            ArrayList arrayList = new ArrayList();
            int i10 = i9.a.m();
            i4 = 0;
            int size = i9.b.size();
            while (i4 < i9.b) {
                Object item = i9.b.get(i4);
                Object item2 = i9.b.get((i4 - 1) + size % size);
                i7 = i10 + item2.e();
                i8 = i10 + item.e();
                qVar = new q(j.p(item, i2, j.o(item, i10, item2.e())), i17, i7, i8, i5);
                arrayList.add(qVar);
                i4 = i4 + 1;
            }
            if (i9.w <= j.x && i9.w) {
                ifAbsent = i9.c.putIfAbsent(num, Collections.unmodifiableList(arrayList));
                if (ifAbsent != null) {
                }
            }
        }
        return ifAbsent;
    }

    private List<q> r(a aVar) {
        return q((d)this.b.get(0).i(aVar));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    static List<q> s(q qVar, List<d> list, long j, long j2) {
        int i = -2147483648;
        int size;
        int i2 = 0;
        int i3;
        long l;
        q qVar2;
        int i5;
        int i6;
        int i7;
        Object list22 = list;
        long j32 = j;
        final long l4 = qVar.i();
        if (j32 > j2) {
            throw new IllegalArgumentException("Start after end.");
        } else {
            return Collections.emptyList();
        }
    }

    private static int u(d dVar, long j) {
        return dVar.h(z.MODIFIED_JULIAN_DATE.transform(c.b(j, 86400), z.UNIX));
    }

    private Object writeReplace() {
        return new SPX(this, 125);
    }

    @Override // net.time4j.tz.model.l
    public q a(a aVar, g gVar) {
        return k(aVar, l.j(aVar, gVar));
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return p.u(this.a.n());
    }

    @Override // net.time4j.tz.model.l
    public List<p> c(a aVar, g gVar) {
        return t(aVar, l.j(aVar, gVar));
    }

    @Override // net.time4j.tz.model.l
    public q d(f fVar) {
        int i;
        int i2 = 0;
        int i3 = 0;
        int i4;
        long cmp;
        long cmp2;
        Object fVar2;
        long l = this.a.i();
        long l2 = fVar.x();
        i2 = 0;
        if (l2 <= l) {
            return null;
        }
        int size = this.b.size();
        i3 = 0;
        Object item2 = this.b.get(i3);
        final int i7 = size - 1;
        cmp2 = (long)(j.o(item2, this.a.m(), (d)this.b.get(i7).e()));
        cmp = fVar.x() + cmp2;
        i = j.u(item2, cmp);
        List list3 = q(i);
        while (i3 < this.b) {
            Object item = list3.get(i3);
            cmp = item.i();
            long l6 = fVar.x();
            if (l6 < cmp) {
            }
        }
        return i2;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            if ((d)it.next().e() < 0) {
                return true;
            }
        }
        return false;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof j) {
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.model.l
    public int hashCode() {
        return (this.a.hashCode() * 17) + (this.b.hashCode() * 37);
    }

    @Override // net.time4j.tz.model.l
    q k(a aVar, long j) {
        cmp2 = (long)(Math.max(this.a.j(), this.a.n()));
        long l2 = this.a.i() + cmp2;
        final int i = 0;
        if (j <= this.a) {
            return null;
        }
        Iterator it = r(aVar).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            long cmp2 = item.i();
            if (item.p()) {
                long l6 = (long)item.n() + cmp2;
            }
            long l8 = (long)item.j() + cmp2;
            z = (long)item.n();
            cmp2 += z;
            if (j < this.a) {
                return item;
            }
        }
        return i;
    }

    @Override // net.time4j.tz.model.l
    q l() {
        return this.a;
    }

    @Override // net.time4j.tz.model.l
    List<d> n() {
        return this.b;
    }

    @Override // net.time4j.tz.model.l
    List<p> t(a aVar, long j) {
        int cmp;
        long l;
        int i;
        boolean z;
        i = this.a.n();
        l2 = (long)(Math.max(this.a.j(), i));
        long l4 = this.a.i() + l2;
        if (j <= this.a) {
            return l.h(i);
        }
        Iterator it = r(aVar).iterator();
        while (it.hasNext()) {
            Object item = it.next();
            l = item.i();
            i = item.n();
            if (item.p()) {
                long l7 = (long)i + l;
            }
            long l10 = (long)item.j() + l;
            l = l + (long)i;
            if (j < l) {
                return Collections.emptyList();
            }
        }
        return l.h(i);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(256);
        String name = j.class.getName();
        String str2 = "[initial=";
        String str3 = ",rules=";
        str = 256 + name + str2 + this.a + str3 + this.b + 93;
        return str;
    }

    j(q qVar, List<d> list, boolean z) {
        q z32;
        int i;
        int i3 = 0;
        ArrayList z33;
        Object obj = null;
        int i4 = 0;
        super();
        this.c = new ConcurrentHashMap();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing daylight saving rules.");
        } else {
            if (list.size() >= 128) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str = "Too many daylight saving rules: ";
                list = str + list;
                throw new IllegalArgumentException(list);
            } else {
                if (z) {
                }
                Collections.sort(z33, k.INSTANCE);
                i4 = 0;
                int i7 = 1;
                if (z33.size() > i7) {
                    Iterator it = z33.iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                    }
                }
                this.w = "iso8601".equals(obj);
                long l2 = qVar.i();
                long l5 = Long.MIN_VALUE;
                if (l2 == Long.MIN_VALUE) {
                    if (qVar.f() != 0) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        String str3 = "Initial transition must not have any dst-offset: ";
                        qVar = str3 + qVar;
                        throw new IllegalArgumentException(qVar);
                    } else {
                        i3 = 0;
                        super((b0)b0.V().I().x(), l5, qVar.m(), qVar.m(), i3);
                        this.a = z32;
                        List unmodifiable = Collections.unmodifiableList(z33);
                        this.b = unmodifiable;
                        this.v = j.s(z32, unmodifiable, 0L, l.f(i7));
                        return;
                    }
                }
                if (qVar.n() != j.m(qVar.i(), qVar, z33).j()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str4 = "Inconsistent model: ";
                    String str6 = " / ";
                    qVar = str4 + qVar + str6 + z33;
                    throw new IllegalArgumentException(qVar);
                } else {
                    String qVar2 = qVar;
                }
            }
        }
    }
}
