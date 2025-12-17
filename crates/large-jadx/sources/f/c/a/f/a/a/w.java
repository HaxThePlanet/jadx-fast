package f.c.a.f.a.a;

/* loaded from: classes2.dex */
final class w extends f.c.a.f.a.a.d.a {

    private Integer a;
    private Boolean b;
    @Override // f.c.a.f.a.a.d$a
    public final f.c.a.f.a.a.d a() {
        Boolean bool;
        Object str;
        Object str2;
        Integer num = this.a;
        if (num != null && this.b == null) {
            if (this.b == null) {
            }
            y yVar = new y(num.intValue(), this.b.booleanValue(), 0);
            return yVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (this.a == null) {
            stringBuilder.append(" appUpdateType");
        }
        if (this.b != null) {
        } else {
            stringBuilder.append(" allowAssetPackDeletion");
        }
        String valueOf = String.valueOf(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder(length += 28);
        stringBuilder2.append("Missing required properties:");
        stringBuilder2.append(valueOf);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
        throw illegalStateException;
    }

    @Override // f.c.a.f.a.a.d$a
    public final f.c.a.f.a.a.d.a b(boolean z) {
        this.b = Boolean.valueOf(z);
        return this;
    }

    @Override // f.c.a.f.a.a.d$a
    public final f.c.a.f.a.a.d.a c(int i) {
        this.a = Integer.valueOf(i);
        return this;
    }
}
