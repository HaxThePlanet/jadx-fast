package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.b0;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;
import net.time4j.i1.f;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* loaded from: classes3.dex */
final class a extends net.time4j.tz.model.l {

    private static final long serialVersionUID = -5264909488983076587L;
    private final transient q[] a;
    private final transient boolean b = true;
    private final transient List<q> c;
    private transient int v = 0;
    static {
        final Class<net.time4j.tz.model.a> obj = a.class;
    }

    a(List<q> list, boolean z2, boolean z3) {
        int i;
        int i2;
        int i3;
        Object obj;
        super();
        final int i4 = 0;
        if (list.isEmpty()) {
        } else {
            Object[] array = list.toArray(new q[list.size()]);
            i2 = i;
            while (true) {
                if (i2 == 0) {
                } else {
                }
                i2 = i3;
                i++;
                if ((q[])array[i].f() < 0) {
                } else {
                }
                i2 = i4;
            }
        }
        IllegalArgumentException obj8 = new IllegalArgumentException("Missing timezone transitions.");
        throw obj8;
    }

    private static void k(q[] qArr, List<q> list2) {
        int i3;
        int i2;
        int i;
        i3 = qArr[0].n();
        i2 = 1;
        for (Object obj2 : qArr) {
            i3 = obj2.n();
        }
    }

    private static List<q> o(q[] qArr, long l2, long l3) {
        int i2;
        int i;
        long l;
        long obj5;
        int obj6;
        if (Long.compare(l2, obj7) > 0) {
        } else {
            i2 = a.r(l2, l3);
            int i3 = a.r(obj7, obj8);
            if (i3 == 0) {
                return Collections.emptyList();
            }
            if (i2 > 0 && Long.compare(l, l2) == 0) {
                if (Long.compare(l, l2) == 0) {
                    i2--;
                }
            }
            i3--;
            if (Long.compare(obj5, obj7) == 0) {
                i--;
            }
            if (i2 > i) {
                return Collections.emptyList();
            }
            obj5 = new ArrayList(obj6++);
            while (i2 <= i) {
                obj5.add(qArr[i2]);
                i2++;
            }
            return Collections.unmodifiableList(obj5);
        }
        IllegalArgumentException obj4 = new IllegalArgumentException("Start after end.");
        throw obj4;
    }

    private static int r(long l, q[] q2Arr2) {
        int i3;
        int i;
        int i2;
        int cmp;
        length--;
        i = 0;
        while (i <= i3) {
            i4 /= 2;
            if (Long.compare(l2, l) <= 0) {
            } else {
            }
            i3 = i2;
            i = i2;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private static int s(long l, q[] q2Arr2) {
        int i2;
        int i;
        int i3;
        int cmp;
        int i5;
        int i4;
        length--;
        i = 0;
        while (i <= i2) {
            i6 /= 2;
            Object obj = obj9[i7];
            if (Long.compare(i4, l) <= 0) {
            } else {
            }
            i2 = i3;
            i = i3;
        }
        return i;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 126);
        return spx;
    }

    @Override // net.time4j.tz.model.l
    public q a(a a, g g2) {
        return m(a, g2, 0);
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return p.u(this.a[0].j());
    }

    public List<p> c(a a, g g2) {
        return p(a, g2, 0);
    }

    @Override // net.time4j.tz.model.l
    public q d(f f) {
        long l;
        int obj3;
        obj3 = a.r(f.x(), obj1);
        if (obj3 == null) {
            obj3 = 0;
        } else {
            obj3 = this.a[obj3--];
        }
        return obj3;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        return this.b;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof a) {
            return Arrays.equals(this.a, object.a);
        }
        return 0;
    }

    @Override // net.time4j.tz.model.l
    public int hashCode() {
        int i;
        if (this.v == 0) {
            this.v = Arrays.hashCode(this.a);
        }
        return i;
    }

    @Override // net.time4j.tz.model.l
    boolean l(net.time4j.tz.model.a a, int i2, int i3) {
        boolean equals;
        q qVar;
        int obj6;
        final int obj5 = Math.min(i2, objArr.length);
        int i = 0;
        if (obj5 != Math.min(i3, objArr2.length)) {
            return i;
        }
        obj6 = i;
        while (obj6 < obj5) {
            obj6++;
        }
        return 1;
    }

    @Override // net.time4j.tz.model.l
    q m(a a, g g2, net.time4j.tz.model.j j3) {
        long objArr;
        q i;
        int obj7;
        final long l = l.j(a, g2);
        obj7 = a.s(l, obj1);
        objArr = this.a;
        if (obj7 == objArr.length) {
            if (j3 == null) {
            } else {
                i = j3.k(a, l);
            }
            return i;
        }
        final q obj6 = objArr[obj7];
        if (obj6.o()) {
            if (Long.compare(obj7, l) <= 0) {
                return obj6;
            }
        } else {
            if (obj6.p() && Long.compare(obj7, l) <= 0) {
                if (Long.compare(obj7, l) <= 0) {
                    return obj6;
                }
            }
        }
        return null;
    }

    @Override // net.time4j.tz.model.l
    q n() {
        q[] objArr = this.a;
        return objArr[length--];
    }

    List<p> p(a a, g g2, net.time4j.tz.model.j j3) {
        q[] objArr;
        boolean obj6;
        final long l = l.j(a, g2);
        obj6 = a.s(l, obj1);
        objArr = this.a;
        if (obj6 == objArr.length && j3 == null) {
            if (j3 == null) {
                return l.h(objArr[obj5--].n());
            }
            return j3.t(a, l);
        }
        q obj5 = objArr[obj6];
        if (obj5.o()) {
            if (Long.compare(obj6, l) <= 0) {
                return Collections.emptyList();
            }
        } else {
            if (obj5.p() && Long.compare(obj6, l) <= 0) {
                if (Long.compare(obj6, l) <= 0) {
                    return l.i(obj5.n(), obj5.j());
                }
            }
        }
        return l.h(obj5.j());
    }

    @Override // net.time4j.tz.model.l
    int q(int i) {
        int obj4 = Math.min(i, objArr.length);
        q[] arr = new q[obj4];
        final int i2 = 0;
        System.arraycopy(this.a, i2, arr, i2, obj4);
        return Arrays.hashCode(arr);
    }

    @Override // net.time4j.tz.model.l
    void t(int i, ObjectOutput objectOutput2) {
        SPX.z(this.a, i, objectOutput2);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(a.class.getName());
        stringBuilder.append("[transition-count=");
        stringBuilder.append(objArr.length);
        stringBuilder.append(",hash=");
        stringBuilder.append(hashCode());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.tz.model.l
    void u(ObjectOutput objectOutput) {
        t(objArr.length, objectOutput);
    }
}
