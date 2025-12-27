package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* compiled from: FallbackTimezone.java */
/* loaded from: classes3.dex */
final class a extends l {

    private static final long serialVersionUID = -2894726563499525332L;
    private final l fallback;
    private final k tzid;
    a(k kVar, l lVar) {
        super();
        if (kVar == null) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            if (lVar != null) {
                this.tzid = kVar;
                this.fallback = lVar;
                return;
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 12);
    }

    @Override // net.time4j.tz.l
    public p A(a aVar, g gVar) {
        return this.fallback.A(aVar, gVar);
    }

    @Override // net.time4j.tz.l
    public p B(f fVar) {
        return this.fallback.B(fVar);
    }

    @Override // net.time4j.tz.l
    public o E() {
        return this.fallback.E();
    }

    @Override // net.time4j.tz.l
    public boolean I(f fVar) {
        return this.fallback.I(fVar);
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return this.fallback.J();
    }

    @Override // net.time4j.tz.l
    public boolean K(a aVar, g gVar) {
        return this.fallback.K(aVar, gVar);
    }

    @Override // net.time4j.tz.l
    public l Q(o oVar) {
        return new a(this.tzid, this.fallback.Q(oVar));
    }

    @Override // net.time4j.tz.l
    l R() {
        return this.fallback;
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof a) {
            if (this.tzid.a().equals(object.tzid.a())) {
                if (!(this.fallback.equals(object.fallback))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.tzid.a().hashCode();
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = a.class.getName();
        String str2 = this.tzid.a();
        String str3 = ",fallback=";
        str = 32 + 91 + name + 58 + str2 + str3 + this.fallback + 93;
        return str;
    }

    @Override // net.time4j.tz.l
    public m y() {
        return this.fallback.y();
    }

    @Override // net.time4j.tz.l
    public k z() {
        return this.tzid;
    }
}
