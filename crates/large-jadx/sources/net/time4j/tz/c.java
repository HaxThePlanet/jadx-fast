package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
final class c extends net.time4j.tz.l {

    private static final long serialVersionUID = 1738909257417361021L;
    private final transient net.time4j.tz.k M;
    private final transient net.time4j.tz.m N;
    private final transient net.time4j.tz.o O;
    c(net.time4j.tz.k k, net.time4j.tz.m m2) {
        super(k, m2, l.c);
    }

    c(net.time4j.tz.k k, net.time4j.tz.m m2, net.time4j.tz.o o3) {
        boolean empty;
        super();
        Objects.requireNonNull(k, "Missing timezone id.");
        if (k instanceof p) {
            if (!m2.isEmpty()) {
            } else {
            }
            StringBuilder obj4 = new StringBuilder();
            obj4.append("Fixed zonal offset can't be combined with offset transitions: ");
            obj4.append(k.a());
            IllegalArgumentException obj3 = new IllegalArgumentException(obj4.toString());
            throw obj3;
        }
        Objects.requireNonNull(m2, "Missing timezone history.");
        Objects.requireNonNull(o3, "Missing transition strategy.");
        this.M = k;
        this.N = m2;
        this.O = o3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 14);
        return spx;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p A(a a, g g2) {
        List list = this.N.c(a, g2);
        if (list.size() == 1) {
            return (p)list.get(0);
        }
        return p.u(this.N.a(a, g2).n());
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p B(f f) {
        net.time4j.tz.p obj2;
        obj2 = this.N.d(f);
        if (obj2 == null) {
            obj2 = this.N.b();
        } else {
            obj2 = p.u(obj2.n());
        }
        return obj2;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.o E() {
        return this.O;
    }

    @Override // net.time4j.tz.l
    public boolean I(f f) {
        int i;
        net.time4j.tz.q obj6 = this.N.d(f);
        i = 0;
        if (obj6 == null) {
            return i;
        }
        int i2 = obj6.f();
        final int i3 = 1;
        if (i2 > 0) {
            return i3;
        }
        if (i2 < 0) {
            return i;
        }
        if (!this.N.e()) {
            return i;
        }
        f fVar = i.b(obj6.i(), obj4);
        net.time4j.tz.q qVar = this.N.d(fVar);
        if (qVar == null) {
            return i;
        }
        if (qVar.m() == obj6.m() && qVar.f() < 0) {
            if (qVar.f() < 0) {
                i = i3;
            }
            return i;
        }
        return I(fVar);
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return this.N.isEmpty();
    }

    @Override // net.time4j.tz.l
    public boolean K(a a, g g2) {
        net.time4j.tz.q obj2;
        obj2 = this.N.a(a, g2);
        if (obj2 != null && obj2.o()) {
            obj2 = obj2.o() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.l Q(net.time4j.tz.o o) {
        if (this.O == o) {
            return this;
        }
        c cVar = new c(this.M, this.N, o);
        return cVar;
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object str;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof c) {
            if (this.M.a().equals(object.M.a()) && this.N.equals(object.N) && this.O.equals(object.O)) {
                if (this.N.equals(object.N)) {
                    if (this.O.equals(object.O)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.M.a().hashCode();
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(c.class.getName());
        stringBuilder.append(':');
        stringBuilder.append(this.M.a());
        stringBuilder.append(",history={");
        stringBuilder.append(this.N);
        stringBuilder.append("},strategy=");
        stringBuilder.append(this.O);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.m y() {
        return this.N;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.k z() {
        return this.M;
    }
}
