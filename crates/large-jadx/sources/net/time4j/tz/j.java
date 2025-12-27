package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.f1.a;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* compiled from: SingleOffsetTimezone.java */
/* loaded from: classes3.dex */
final class j extends l implements m {

    private static final j M = null;
    private static final long serialVersionUID = 7807230388259573234L;
    private final p offset;
    static {
        j.M = new j(p.C);
    }

    private j(p pVar) {
        int i;
        super();
        if (pVar.n() == 0) {
            this.offset = pVar;
        } else {
            i = pVar.n() < 0 ? i - 1 : i;
            this.offset = p.u(i);
        }
    }

    static j R(p pVar) {
        if (pVar.o() == 0 && pVar.n() == 0) {
            return j.M;
        }
        return new j(pVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException, java.lang.ClassNotFoundException, java.io.IOException {
        objectInputStream.defaultReadObject();
        if (this.offset.n() != 0) {
            throw new InvalidObjectException("Fractional offset is invalid.");
        }
    }

    @Override // net.time4j.tz.l
    public p A(a aVar, g gVar) {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public p B(f fVar) {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public o E() {
        return l.c;
    }

    @Override // net.time4j.tz.l
    public p b() {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public List<p> c(a aVar, g gVar) {
        return Collections.singletonList(this.offset);
    }

    @Override // net.time4j.tz.l
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof j) {
            return this.offset.equals(object.offset);
        }
        return false;
    }

    @Override // net.time4j.tz.l
    public int hashCode() {
        return this.offset.hashCode();
    }

    @Override // net.time4j.tz.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = j.class.getName();
        str = 32 + 91 + name + 58 + this.offset + 93;
        return str;
    }

    @Override // net.time4j.tz.l
    public String w(d dVar, Locale locale) {
        String pVar;
        if (dVar.isAbbreviation()) {
            pVar = this.offset.toString();
        } else {
            pVar = this.offset.a();
        }
        return pVar;
    }

    @Override // net.time4j.tz.l
    public k z() {
        return this.offset;
    }

    @Override // net.time4j.tz.l
    public boolean I(f fVar) {
        return false;
    }

    @Override // net.time4j.tz.l
    public boolean J() {
        return true;
    }

    @Override // net.time4j.tz.l
    public boolean K(a aVar, g gVar) {
        return false;
    }

    @Override // net.time4j.tz.l
    public l Q(o oVar) {
        return this;
    }

    @Override // net.time4j.tz.l
    public q a(a aVar, g gVar) {
        return null;
    }

    @Override // net.time4j.tz.l
    public q d(f fVar) {
        return null;
    }

    @Override // net.time4j.tz.l
    public boolean e() {
        return false;
    }

    @Override // net.time4j.tz.l
    public boolean isEmpty() {
        return true;
    }

    @Override // net.time4j.tz.l
    public m y() {
        return this;
    }
}
