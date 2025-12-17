package net.time4j.tz.model;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.util.List;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;
import net.time4j.tz.p;
import net.time4j.tz.q;

/* loaded from: classes3.dex */
final class b extends net.time4j.tz.model.l {

    private static final long serialVersionUID = 1749643877954103721L;
    private final transient int a;
    private final transient net.time4j.tz.model.a b;
    private final transient net.time4j.tz.model.j c;
    private final transient q v;
    private transient int w = 0;
    b(int i, List<q> list2, List<net.time4j.tz.model.d> list3, boolean z4, boolean z5) {
        super();
        final int i2 = 0;
        this.a = i;
        a obj2 = new a(list2, z4, z5);
        this.b = obj2;
        obj2 = obj2.n();
        this.v = obj2;
        j obj3 = new j(obj2, list3, z4);
        this.c = obj3;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 127);
        return spx;
    }

    @Override // net.time4j.tz.model.l
    public q a(a a, g g2) {
        return this.b.m(a, g2, this.c);
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return this.b.b();
    }

    public List<p> c(a a, g g2) {
        return this.b.p(a, g2, this.c);
    }

    @Override // net.time4j.tz.model.l
    public q d(f f) {
        q obj5;
        if (Long.compare(l, l2) < 0) {
            return this.b.d(f);
        }
        if (this.c.d(f) == null) {
            obj5 = this.v;
        }
        return obj5;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        int i;
        boolean z;
        if (!this.c.e()) {
            if (this.b.e()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        int i;
        boolean z;
        Object obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof b) {
            if (this.b.l(object.b, this.a, object.a) && this.c.n().equals(object.c.n())) {
                if (this.c.n().equals(object.c.n())) {
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
        int i2;
        int i;
        if (this.w == 0) {
            this.w = i3 += i;
        }
        return i2;
    }

    List<net.time4j.tz.model.d> k() {
        return this.c.n();
    }

    @Override // net.time4j.tz.model.l
    void l(ObjectOutput objectOutput) {
        this.b.t(this.a, objectOutput);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(b.class.getName());
        stringBuilder.append("[transition-count=");
        stringBuilder.append(this.a);
        stringBuilder.append(",hash=");
        stringBuilder.append(hashCode());
        stringBuilder.append(",last-rules=");
        stringBuilder.append(this.c.n());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
