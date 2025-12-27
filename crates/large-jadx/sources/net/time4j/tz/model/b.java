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

/* compiled from: CompositeTransitionModel.java */
/* loaded from: classes3.dex */
final class b extends l {

    private static final long serialVersionUID = 1749643877954103721L;
    private final transient int a;
    private final transient a b = new a();
    private final transient j c = new j();
    private final transient q v;
    private transient int w = 0;
    b(int i, List<q> list, List<d> list2, boolean z, boolean z2) {
        super();
        this.a = i;
        q qVar = new a(list, z, z2).n();
        this.v = qVar;
        final net.time4j.tz.model.j jVar = new j(qVar, list2, z);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private Object writeReplace() {
        return new SPX(this, 127);
    }

    @Override // net.time4j.tz.model.l
    public q a(a aVar, g gVar) {
        return this.b.m(aVar, gVar, this.c);
    }

    @Override // net.time4j.tz.model.l
    public p b() {
        return this.b.b();
    }

    @Override // net.time4j.tz.model.l
    public List<p> c(a aVar, g gVar) {
        return this.b.p(aVar, gVar, this.c);
    }

    @Override // net.time4j.tz.model.l
    public q d(f fVar) {
        q qVar;
        long l = fVar.x();
        long l2 = this.v.i();
        if (l < l2) {
            return this.b.d(fVar);
        }
        if (this.c.d(fVar) == null) {
        }
        return qVar;
    }

    @Override // net.time4j.tz.model.l
    public boolean e() {
        boolean z2 = false;
        if (!this.c.e()) {
            if (this.b.e()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    @Override // net.time4j.tz.model.l
    public boolean equals(Object object) {
        boolean z = true;
        boolean z2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof b) {
            if (this.b.l(object.b, this.a, object.a)) {
                if (!(this.c.n().equals(object.c.n()))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // net.time4j.tz.model.l
    public int hashCode() {
        int i;
        if (this.w == 0) {
            i2 = this.c.n().hashCode() * 37;
            i = this.b.q(this.a) + i2;
            this.w = i;
        }
        return i;
    }

    @Override // net.time4j.tz.model.l
    List<d> k() {
        return this.c.n();
    }

    @Override // net.time4j.tz.model.l
    void l(ObjectOutput objectOutput) {
        this.b.t(this.a, objectOutput);
    }

    @Override // net.time4j.tz.model.l
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        String name = b.class.getName();
        String str2 = "[transition-count=";
        String str3 = ",hash=";
        int i3 = hashCode();
        String str4 = ",last-rules=";
        List list = this.c.n();
        str = 32 + name + str2 + this.a + str3 + i3 + str4 + list + 93;
        return str;
    }
}
