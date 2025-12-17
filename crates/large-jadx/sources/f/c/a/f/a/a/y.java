package f.c.a.f.a.a;

/* loaded from: classes2.dex */
final class y extends f.c.a.f.a.a.d {

    private final int a;
    private final boolean b;
    y(int i, boolean z2, f.c.a.f.a.a.x x3) {
        super();
        this.a = i;
        this.b = z2;
    }

    @Override // f.c.a.f.a.a.d
    public final boolean a() {
        return this.b;
    }

    @Override // f.c.a.f.a.a.d
    public final int b() {
        return this.a;
    }

    @Override // f.c.a.f.a.a.d
    public final boolean equals(Object object) {
        boolean i;
        int i2;
        Object obj5;
        final int i3 = 1;
        if (object == this) {
            return i3;
        }
        if (object instanceof d && this.a == (d)object.b() && this.b == object.a()) {
            if (this.a == (d)object.b()) {
                if (this.b == object.a()) {
                    return i3;
                }
            }
        }
        return 0;
    }

    @Override // f.c.a.f.a.a.d
    public final int hashCode() {
        int i;
        int i6 = 1000003;
        i = 1 != this.b ? 1237 : 1231;
        return i4 ^= i;
    }

    @Override // f.c.a.f.a.a.d
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("AppUpdateOptions{appUpdateType=");
        stringBuilder.append(this.a);
        stringBuilder.append(", allowAssetPackDeletion=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
