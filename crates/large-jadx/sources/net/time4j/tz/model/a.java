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
import net.time4j.f1.g;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* compiled from: ArrayTransitionModel.java */
/* loaded from: classes3.dex */
final class a extends l {

    private static final long serialVersionUID = -5264909488983076587L;
    private final transient q[] a;
    private final transient boolean b = true;
    private final transient List<q> c;
    private transient int v = 0;

    a(List<q> list, boolean z, boolean z2) {
        int i;
        super();
        i = 0;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing timezone transitions.");
        } else {
            Object[] array = list.toArray(new q[list.size()]);
            i = 1;
            while (true) {
            }
        }
    }

    private static void k(q[] qVarArr, List<q> list) {
        int i;
        int i2 = 1;
        i = qVarArr[0].n();
        i2 = 1;
        while (i2 < qVarArr.length) {
            if (i != qVarArr[i2].j()) {
                b0 b0Var = b0.p0(qVarArr[i2].i(), f.POSIX);
                final StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Model inconsistency detected at: ";
                String str = " (";
                long l = qVarArr[i2].i();
                String str3 = ") ";
                String str4 = " in transitions: ";
                qVarArr = str2 + b0Var + str + l + str3 + str4 + list;
                throw new IllegalArgumentException(qVarArr);
            }
        }
    }

    private static List<q> o(q[] qVarArr, long j, long j2) {
        int i;
        int i2;
        if (j > j2) {
            throw new IllegalArgumentException("Start after end.");
        } else {
            i = a.r(j, qVarArr);
            int i4 = a.r(j2, qVarArr);
            if (i4 == 0) {
                return Collections.emptyList();
            }
            if (i > 0 && l == j) {
                i = i - 1;
            }
            i2 = i4 - 1;
            long l2 = qVarArr[i2].i();
            if (l2 == j2) {
                i2 = i2 - 1;
            }
            if (i > i2) {
                return Collections.emptyList();
            }
            i3 = (i2 - i) + 1;
            ArrayList arrayList = new ArrayList(i3);
            while (i <= i2) {
                arrayList.add(qVarArr[i]);
                i = i + 1;
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    private static int r(long j, q[] qVarArr) {
        int i;
        i = qVarArr.length - 1;
        i = 0;
        while (i <= i) {
            int i3 = (i + i) / 2;
            long l = qVarArr[i3].i();
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static int s(long j, q[] qVarArr) {
        int i;
        i = qVarArr.length - 1;
        i = 0;
        while (i <= i) {
            int i3 = (i + i) / 2;
            Object obj = qVarArr[i3];
            l = obj.i() + (long)(Math.max(obj.n(), obj.j()));
        }
        return i;
    }

    private Object writeReplace() {
        return new SPX(this, 126);
    }

    @Override // net.time4j.tz.model.l
    public q a(a aVar, g gVar) {
        return m(aVar, gVar, null);
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return p.u(this.a[0].j());
    }

    @Override // net.time4j.tz.model.l
    public List<p> c(a aVar, g gVar) {
        return p(aVar, gVar, null);
    }

    @Override // net.time4j.tz.model.l
    public q d(net.time4j.f1.f fVar) {
        int i = 0;
        int i2 = a.r(fVar.x(), this.a);
        if (i2 == 0) {
            i = 0;
        } else {
            q qVar = this.a[i2 - 1];
        }
        return i;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        return this.b;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof a) {
            return Arrays.equals(this.a, object.a);
        }
        return false;
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
    boolean l(a aVar, int i, int i2) {
        final int min = Math.min(i, this.a.length);
        i = 0;
        if (min != Math.min(i2, aVar.a.length)) {
            return false;
        }
        while (i < min) {
            if (!this.a[i].equals(aVar.a[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // net.time4j.tz.model.l
    q m(a aVar, g gVar, j jVar) {
        q qVar = null;
        final long l2 = l.j(aVar, gVar);
        int i4 = a.s(l2, this.a);
        if (i4 == objArr.length) {
            if (jVar != null) {
                qVar = jVar.k(aVar, l2);
            }
            return qVar;
        }
        final q qVar2 = objArr[i4];
        if (qVar2.o()) {
            l = (long)qVar2.j();
            long l5 = qVar2.i() + l;
            return this.a <= l2 ? qVar2 : 0;
        } else {
            if (qVar2.p()) {
                l = (long)qVar2.n();
                long l7 = qVar2.i() + l;
                return this.a <= l2 ? qVar2 : i3;
            }
        }
    }

    @Override // net.time4j.tz.model.l
    q n() {
        return objArr[objArr.length - 1];
    }

    @Override // net.time4j.tz.model.l
    List<p> p(a aVar, g gVar, j jVar) {
        final long l = l.j(aVar, gVar);
        int i7 = a.s(l, this.a);
        if (i7 == objArr.length) {
            if (jVar == null) {
                return l.h(objArr[objArr.length - 1].n());
            }
            return jVar.t(aVar, l);
        }
        q qVar2 = objArr[i7];
        if (qVar2.o()) {
            long l8 = qVar2.i() + (long)qVar2.j();
            if (this.a <= l) {
                return Collections.emptyList();
            }
        } else {
            if (qVar2.p()) {
                long l6 = qVar2.i() + (long)qVar2.n();
                if (this.a <= l) {
                    return l.i(qVar2.n(), qVar2.j());
                }
            }
        }
        return l.h(qVar2.j());
    }

    @Override // net.time4j.tz.model.l
    int q(int i) {
        int min = Math.min(i, this.a.length);
        q[] arr = new q[min];
        final int i2 = 0;
        System.arraycopy(this.a, i2, arr, i2, min);
        return Arrays.hashCode(arr);
    }

    @Override // net.time4j.tz.model.l
    void t(int i, ObjectOutput objectOutput) {
        SPX.z(this.a, i, objectOutput);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = a.class.getName();
        String str2 = "[transition-count=";
        int length = this.a.length;
        String str3 = ",hash=";
        int i2 = hashCode();
        str = 32 + name + str2 + length + str3 + i2 + 93;
        return str;
    }

    @Override // net.time4j.tz.model.l
    void u(ObjectOutput objectOutput) {
        t(this.a.length, objectOutput);
    }
}
