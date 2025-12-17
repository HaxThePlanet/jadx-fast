package f.c.a.f.a.d;

import java.io.File;
import java.util.Objects;

/* loaded from: classes2.dex */
final class c extends f.c.a.f.a.d.t {

    private final File a;
    private final String b;
    c(File file, String string2) {
        super();
        Objects.requireNonNull(file, "Null splitFile");
        this.a = file;
        Objects.requireNonNull(string2, "Null splitId");
        this.b = string2;
    }

    @Override // f.c.a.f.a.d.t
    final File a() {
        return this.a;
    }

    @Override // f.c.a.f.a.d.t
    final String b() {
        return this.b;
    }

    @Override // f.c.a.f.a.d.t
    public final boolean equals(Object object) {
        boolean equals;
        File file;
        Object obj5;
        final int i = 1;
        if (object == this) {
            return i;
        }
        if (object instanceof t && this.a.equals((t)object.a()) && this.b.equals(object.b())) {
            if (this.a.equals((t)object.a())) {
                if (this.b.equals(object.b())) {
                    return i;
                }
            }
        }
        return 0;
    }

    @Override // f.c.a.f.a.d.t
    public final int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // f.c.a.f.a.d.t
    public final String toString() {
        String valueOf = String.valueOf(this.a);
        final String str3 = this.b;
        StringBuilder stringBuilder = new StringBuilder(i += length2);
        stringBuilder.append("SplitFileInfo{splitFile=");
        stringBuilder.append(valueOf);
        stringBuilder.append(", splitId=");
        stringBuilder.append(str3);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
