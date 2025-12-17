package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
final class a extends net.time4j.tz.l {

    private static final long serialVersionUID = -2894726563499525332L;
    private final net.time4j.tz.l fallback;
    private final net.time4j.tz.k tzid;
    a(net.time4j.tz.k k, net.time4j.tz.l l2) {
        super();
        if (k == null) {
        } else {
            if (l2 == null) {
            } else {
                this.tzid = k;
                this.fallback = l2;
            }
        }
        throw 0;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("Serialization proxy required.");
        throw obj2;
    }

    private Object writeReplace() {
        SPX spx = new SPX(this, 12);
        return spx;
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p A(a a, g g2) {
        return this.fallback.A(a, g2);
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.p B(f f) {
        return this.fallback.B(f);
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.o E() {
        return this.fallback.E();
    }

    @Override // net.time4j.tz.l
    public boolean I(f f) {
        return this.fallback.I(f);
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return this.fallback.J();
    }

    @Override // net.time4j.tz.l
    public boolean K(a a, g g2) {
        return this.fallback.K(a, g2);
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.l Q(net.time4j.tz.o o) {
        a aVar = new a(this.tzid, this.fallback.Q(o));
        return aVar;
    }

    @Override // net.time4j.tz.l
    net.time4j.tz.l R() {
        return this.fallback;
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        int i;
        boolean fallback;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof a) {
            if (this.tzid.a().equals(object.tzid.a()) && this.fallback.equals(object.fallback)) {
                if (this.fallback.equals(object.fallback)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.tzid.a().hashCode();
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(a.class.getName());
        stringBuilder.append(':');
        stringBuilder.append(this.tzid.a());
        stringBuilder.append(",fallback=");
        stringBuilder.append(this.fallback);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.m y() {
        return this.fallback.y();
    }

    @Override // net.time4j.tz.l
    public net.time4j.tz.k z() {
        return this.tzid;
    }
}
