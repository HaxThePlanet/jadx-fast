package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* compiled from: HistorizedTimezone.java */
/* loaded from: classes3.dex */
final class c extends l {

    private static final long serialVersionUID = 1738909257417361021L;
    private final transient k M;
    private final transient m N;
    private final transient o O;
    c(k kVar, m mVar) {
        this(kVar, mVar, l.c);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 14);
    }

    @Override // net.time4j.tz.l
    public p A(a aVar, g gVar) {
        List list = this.N.c(aVar, gVar);
        if (list.size() == 1) {
            return (p)list.get(0);
        }
        return p.u(this.N.a(aVar, gVar).n());
    }

    @Override // net.time4j.tz.l
    public p B(f fVar) {
        net.time4j.tz.p pVar;
        net.time4j.tz.q qVar = this.N.d(fVar);
        if (qVar == null) {
            pVar = this.N.b();
        } else {
            pVar = p.u(qVar.n());
        }
        return pVar;
    }

    @Override // net.time4j.tz.l
    public o E() {
        return this.O;
    }

    @Override // net.time4j.tz.l
    public boolean I(f fVar) {
        boolean z = false;
        net.time4j.tz.q qVar2 = this.N.d(fVar);
        int i2 = 0;
        if (qVar2 == null) {
            return false;
        }
        int i3 = qVar2.f();
        final int i = 1;
        if (i3 > 0) {
            return true;
        }
        if (i3 < 0) {
            return false;
        }
        if (!this.N.e()) {
            return false;
        }
        f fVar2 = i.b(qVar2.i(), i2);
        net.time4j.tz.q qVar = this.N.d(fVar2);
        if (qVar == null) {
            return false;
        }
        if (qVar.m() == qVar2.m() && qVar.f() < 0) {
            return z;
        }
        return I(fVar2);
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return this.N.isEmpty();
    }

    @Override // net.time4j.tz.l
    public boolean K(a aVar, g gVar) {
        boolean z2 = false;
        net.time4j.tz.q qVar = this.N.a(aVar, gVar);
        aVar = qVar != null && qVar.o() ? 1 : 0;
        return (qVar != null && qVar.o() ? 1 : 0);
    }

    @Override // net.time4j.tz.l
    public l Q(o oVar) {
        if (this.O == oVar) {
            return this;
        }
        return new c(this.M, this.N, oVar);
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        String str;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof c) {
            if (this.M.a().equals(object.M.a())) {
                if (this.N.equals(object.N)) {
                    if (!(this.O.equals(object.O))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.M.a().hashCode();
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = c.class.getName();
        String str2 = this.M.a();
        String str3 = ",history={";
        String str4 = "},strategy=";
        str = 32 + 91 + name + 58 + str2 + str3 + this.N + str4 + this.O + 93;
        return str;
    }

    @Override // net.time4j.tz.l
    public m y() {
        return this.N;
    }

    @Override // net.time4j.tz.l
    public k z() {
        return this.M;
    }

    c(k kVar, m mVar, o oVar) {
        super();
        Objects.requireNonNull(kVar, "Missing timezone id.");
        empty = kVar instanceof p;
        Objects.requireNonNull(mVar, "Missing timezone history.");
        Objects.requireNonNull(oVar, "Missing transition strategy.");
        this.M = kVar;
        this.N = mVar;
        this.O = oVar;
    }
}
