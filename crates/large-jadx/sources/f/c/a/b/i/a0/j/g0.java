package f.c.a.b.i.a0.j;

import f.c.a.b.i.j;
import f.c.a.b.i.p;
import java.util.Objects;

/* loaded from: classes.dex */
final class g0 extends f.c.a.b.i.a0.j.p0 {

    private final long a;
    private final p b;
    private final j c;
    g0(long l, p p2, j j3) {
        super();
        this.a = l;
        Objects.requireNonNull(j3, "Null transportContext");
        this.b = j3;
        Objects.requireNonNull(obj4, "Null event");
        this.c = obj4;
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
        int i;
        int equals;
        long l;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof p0) {
            if (Long.compare(l, l2) == 0 && this.b.equals(object.d()) && this.c.equals(object.b())) {
                if (this.b.equals(object.d())) {
                    if (this.c.equals(object.b())) {
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

    @Override // f.c.a.b.i.a0.j.p0
    public int hashCode() {
        long l = this.a;
        int i8 = 1000003;
        return i6 ^= i9;
    }

    @Override // f.c.a.b.i.a0.j.p0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PersistedEvent{id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", transportContext=");
        stringBuilder.append(this.b);
        stringBuilder.append(", event=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
