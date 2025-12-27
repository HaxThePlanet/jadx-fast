package f.c.a.f.a.a;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class w extends d.a {

    private Integer a;
    private Boolean b;
    @Override // f.c.a.f.a.a.d$a
    public final d a() {
        if (this.a != null) {
            return new y(this.a.intValue(), this.b.booleanValue(), null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a == null) {
            stringBuilder.append(" appUpdateType");
        }
        if (this.b != null) {
            String str = String.valueOf(stringBuilder);
            int i = String.valueOf(str).length() + 28;
            StringBuilder stringBuilder2 = new StringBuilder(i);
            String str5 = "Missing required properties:";
            r0 = i + str5 + str;
            throw new IllegalStateException(r0);
        } else {
            stringBuilder.append(" allowAssetPackDeletion");
        }
    }

    @Override // f.c.a.f.a.a.d$a
    public final d.a b(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    @Override // f.c.a.f.a.a.d$a
    public final d.a c(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }

    w() {
        super();
    }
}
