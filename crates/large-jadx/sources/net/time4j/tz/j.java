package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
final class j extends net.time4j.tz.l implements net.time4j.tz.m {

    private static final net.time4j.tz.j M = null;
    private static final long serialVersionUID = 7807230388259573234L;
    private final net.time4j.tz.p offset;
    static {
        j jVar = new j(p.C);
        j.M = jVar;
    }

    private j(net.time4j.tz.p p) {
        int i;
        net.time4j.tz.p obj2;
        super();
        if (p.n() == 0) {
            this.offset = p;
        } else {
            i = p.n() < 0 ? i + -1 : i;
            this.offset = p.u(i);
        }
    }

    static net.time4j.tz.j R(net.time4j.tz.p p) {
        int i;
        if (p.o() == 0 && p.n() == 0) {
            if (p.n() == 0) {
                return j.M;
            }
        }
        j jVar = new j(p);
        return jVar;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.offset.n() != 0) {
        } else {
        }
        InvalidObjectException obj2 = new InvalidObjectException("Fractional offset is invalid.");
        throw obj2;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p A(a a, g g2) {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p B(f f) {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.o E() {
        return l.c;
    }

    @Override // net.time4j.tz.l
    public boolean I(f f) {
        return 0;
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return 1;
    }

    @Override // net.time4j.tz.l
    public boolean K(a a, g g2) {
        return 0;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.l Q(net.time4j.tz.o o) {
        return this;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.q a(a a, g g2) {
        return null;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p b() {
        return this.offset;
    }

    public List<net.time4j.tz.p> c(a a, g g2) {
        return Collections.singletonList(this.offset);
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.q d(f f) {
        return null;
    }

    @Override // net.time4j.tz.l
    public boolean e() {
        return 0;
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (object instanceof j) {
            return this.offset.equals(object.offset);
        }
        return 0;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.offset.hashCode();
    }

    @Override // net.time4j.tz.l
    public boolean isEmpty() {
        return 1;
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(j.class.getName());
        stringBuilder.append(':');
        stringBuilder.append(this.offset);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.tz.l
    public String w(net.time4j.tz.d d, Locale locale2) {
        String obj1;
        if (d.isAbbreviation()) {
            obj1 = this.offset.toString();
        } else {
            obj1 = this.offset.a();
        }
        return obj1;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.m y() {
        return this;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.k z() {
        return this.offset;
    }
}
