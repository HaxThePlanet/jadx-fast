package f.c.a.f.a.d;

import java.io.File;
import java.util.Objects;

/* compiled from: com.google.android.play:core@@1.10.2 */
/* loaded from: classes2.dex */
final class c extends t {

    private final File a;
    private final String b;
    c(File file, String str) {
        super();
        Objects.requireNonNull(file, "Null splitFile");
        this.a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.b = str;
    }

    @Override // f.c.a.f.a.d.t
    public final boolean equals(Object object) {
        final boolean z = true;
        if (object == this) {
            return true;
        }
        equals = object instanceof t;
        if (object instanceof t) {
            if (this.a.equals(object.a())) {
                return this.b.equals(object.b()) ? z : 0;
            }
        }
    }

    @Override // f.c.a.f.a.d.t
    public final int hashCode() {
        int i5 = 1000003;
        return (this.a.hashCode() ^ i5) * i5 ^ this.b.hashCode();
    }

    @Override // f.c.a.f.a.d.t
    public final String toString() {
        String str = String.valueOf(this.a);
        int i2 = (String.valueOf(str).length() + 35) + this.b.length();
        final StringBuilder stringBuilder = new StringBuilder(i2);
        String str7 = "SplitFileInfo{splitFile=";
        String str2 = ", splitId=";
        String str3 = "}";
        str4 = i2 + str7 + str + str2 + this.b + str3;
        return str4;
    }

    @Override // f.c.a.f.a.d.t
    final File a() {
        return this.a;
    }

    @Override // f.c.a.f.a.d.t
    final String b() {
        return this.b;
    }
}
