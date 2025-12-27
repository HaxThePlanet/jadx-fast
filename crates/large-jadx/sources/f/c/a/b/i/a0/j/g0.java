package f.c.a.b.i.a0.j;

import f.c.a.b.i.j;
import f.c.a.b.i.p;
import java.util.Objects;

/* compiled from: AutoValue_PersistedEvent.java */
/* loaded from: classes.dex */
final class g0 extends p0 {

    private final long a;
    private final p b;
    private final j c;
    g0(long j, p pVar, j jVar) {
        super();
        this.a = j;
        Objects.requireNonNull(pVar, "Null transportContext");
        this.b = pVar;
        Objects.requireNonNull(jVar, "Null event");
        this.c = jVar;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public j b() {
        return this.c;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public long c() {
        return this.a;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public p d() {
        return this.b;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long l;
        boolean equals;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof p0) {
            final long l2 = object.c();
            if (this.a == l2) {
                if (this.b.equals(object.d())) {
                    if (!(this.c.equals(object.b()))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public int hashCode() {
        int i7 = 1000003;
        return (int)(l ^ (l >>> 32L)) ^ i7 * i7 ^ this.b.hashCode() * i7 ^ this.c.hashCode();
    }

    @Override // f.c.a.b.i.a0.j.p0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PersistedEvent{id=";
        String str3 = ", transportContext=";
        String str4 = ", event=";
        String str5 = "}";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5;
        return str;
    }
}
