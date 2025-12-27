package f.c.a.f.a.a;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class y extends d {

    private final int a;
    private final boolean b;
    @Override // f.c.a.f.a.a.d
    public final boolean equals(Object object) {
        final boolean z3 = true;
        if (object == this) {
            return true;
        }
        z = object instanceof d;
        if (object instanceof d) {
            if (this.a == object.b()) {
                return this.b == object.a() ? z3 : 0;
            }
        }
    }

    @Override // f.c.a.f.a.a.d
    public final String toString() {
        final StringBuilder stringBuilder = new StringBuilder(73);
        String str4 = "AppUpdateOptions{appUpdateType=";
        String str = ", allowAssetPackDeletion=";
        String str2 = "}";
        str3 = 73 + str4 + this.a + str + this.b + str2;
        return str3;
    }

    /* synthetic */ y(int i, boolean z, x xVar) {
        super();
        this.a = i;
        this.b = z;
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
    public final int hashCode() {
        int i = 1237;
        int i6 = 1000003;
        int r1 = 1 != this.b ? 1237 : 1231;
        return (this.a ^ i6) * i6 ^ (1 != this.b ? 1237 : 1231);
    }
}
