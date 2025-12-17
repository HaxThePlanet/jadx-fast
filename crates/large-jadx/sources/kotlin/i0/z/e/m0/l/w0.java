package kotlin.i0.z.e.m0.l;

/* loaded from: classes3.dex */
public abstract class w0 implements kotlin.i0.z.e.m0.l.v0 {
    @Override // kotlin.i0.z.e.m0.l.v0
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof v0) {
            return i2;
        }
        if (c() != (v0)object.c()) {
            return i2;
        }
        if (a() != object.a()) {
            return i2;
        }
        if (!getType().equals(object.getType())) {
            return i2;
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.v0
    public int hashCode() {
        int i;
        boolean z;
        int i2 = a().hashCode();
        if (c1.v(getType())) {
            i3 += 19;
        } else {
            if (c()) {
                z = 17;
            } else {
                z = getType().hashCode();
            }
            i4 += z;
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.l.v0
    public String toString() {
        if (c()) {
            return "*";
        }
        if (a() == h1.INVARIANT) {
            return getType().toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a());
        stringBuilder.append(" ");
        stringBuilder.append(getType());
        return stringBuilder.toString();
    }
}
